package pe.edu.ulima.pm.pokeapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import pe.edu.ulima.pm.pokeapp.model.UserManager

class PresentationActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_presentation)


        val butContinuar : Button = findViewById(R.id.but_continuar)
        butContinuar.setOnClickListener { v : View ->

            UserManager.instance.saveUser(
                findViewById<EditText>(R.id.eteUsuario).text.toString(),
                {
                    val intent = Intent()
                    val bundle = Bundle()

                    bundle.putString("username", findViewById<EditText>(R.id.eteUsuario).text.toString())
                    //El Bundle tambien indica que se debe mostar el Fragment de la lista de Pokemon
                    bundle.putString("fragment", "pokemon")

                    intent.putExtra("data", bundle)

                    intent.setClass(this, MainActivity::class.java)
                    startActivity(intent)
                },{
                    Log.e("PresentationActivity", it)
                    Toast.makeText(this, "Error guardando usuario", Toast.LENGTH_SHORT).show()
                }
            )
        }

        val butFavoritos : Button = findViewById<Button>(R.id.but_favoritos)
        butFavoritos.setOnClickListener {

            UserManager.instance.saveUser(
                findViewById<EditText>(R.id.eteUsuario).text.toString(),
                {
                    val intent = Intent()
                    val bundle = Bundle()

                    bundle.putString("username", findViewById<EditText>(R.id.eteUsuario).text.toString())
                    //El Bundle indica que se debe mostar el Fragment de Favoritos
                    bundle.putString("fragment", "favoritos")

                    intent.putExtra("data", bundle)

                    intent.setClass(this, MainActivity::class.java)
                    startActivity(intent)
                },{
                    Log.e("PresentationActivity", it)
                    Toast.makeText(this, "Error guardando usuario", Toast.LENGTH_SHORT).show()
                }
            )
        }

    }
}