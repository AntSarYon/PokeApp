package pe.edu.ulima.pm.pokeapp.network

import android.os.Build
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.net.HttpURLConnection
import java.net.URL
import java.util.stream.Collectors

class NetworkClient(val url:String) {

    fun download(callbackOk : (String) -> Unit, callbackError: (String) -> Unit) {

        Thread(){
            val urlConn = URL(url)
            val conn = urlConn.openConnection()

            conn as HttpURLConnection
            conn.requestMethod = "GET"

            conn.connect()

            val statusCode = conn.responseCode

            if(statusCode != 200){
                callbackError("ERROR EN LA COMUNICACION: $statusCode")
            }

            else{
                val inputStream = conn.inputStream

                // no estamos recibienod la Data como un conjunto de Bytes; sino como un flujo, --> tendremos que leer a partir de ese flujo
                // similar de la conversion a JSON efectuada en Fecth en Progra Web
                val resp = convertInputStreamtoString(inputStream)

                inputStream.close()
                callbackOk(resp.toString())
            }
        }.start()
    }

    //-----------------------------------------------------------------------------

    private fun convertInputStreamtoString(inputStream: InputStream?): Any {
        val br = BufferedReader(InputStreamReader(inputStream))

        val cadena = if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
            br.lines().collect(Collectors.joining("\n"))
        }

        else{
            val cadenaCompleta = StringBuilder()
            var line : String = ""

            line = br.readLine()
            while(line != null){
                cadenaCompleta.append(line).append("\n")
                line = br.readLine()
            }

            cadenaCompleta.toString()
        }
        return cadena
    }
}