package pe.edu.ulima.pm.pokeapp.model

import android.content.Context
import android.util.Log
import androidx.room.Room
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.gson.Gson
import me.sargunvohra.lib.pokekotlin.client.PokeApiClient
import pe.edu.ulima.pm.pokeapp.room.PKAppDatabase
import pe.edu.ulima.pm.pokeapp.model.Pokemon

class PokemonManager(context: Context) {

    private val dbFirebase = Firebase.firestore

    fun getAllPokemon(callbackOK: (List<Pokemon>) -> Unit, callbackError: (String) -> Unit) {
        dbFirebase.collection("pokemon")
            .get()
            .addOnSuccessListener { res ->
                val listaPokes = arrayListOf<Pokemon>()
                for(document in res){

                    val pk = Pokemon(
                        document.id.toLong(),
                        document.data["name"]!! as String,
                        (document.data["hp"]!! as Long).toFloat(),
                        (document.data["attack"]!! as Long).toFloat(),
                        (document.data["defense"]!! as Long).toFloat(),
                        (document.data["specialAttack"]!! as Long).toFloat(),
                        (document.data["specialDefense"]!! as Long).toFloat(),
                        document.data["url"]!! as String
                    )
                    listaPokes.add(pk)
                }
                callbackOK(listaPokes)
            }
            .addOnFailureListener {
                callbackError(it.message!!)
            }
        /*----------------------------------------------------------------------------------------
        val lista : MutableList<me.sargunvohra.lib.pokekotlin.model.Pokemon> = mutableListOf()
        for (i in 1..20){
            val test = pokeApi.getPokemon(i)
            lista.add(test)
        }
        return lista;
        -------------------------------------------------------------------------------------------*/
    }

    fun getPokemon(i:Int): Pokemon{
        var pk : Pokemon? = null
        dbFirebase.collection("pokemon")
            .get()
            .addOnSuccessListener { res ->
                for(document in res){
                    if(document.id.toLong() == i.toLong()){
                        pk = Pokemon(
                            document.id.toLong(),
                            document.data["name"]!! as String,
                            (document.data["hp"]!! as Long).toFloat(),
                            (document.data["attack"]!! as Long).toFloat(),
                            (document.data["defense"]!! as Long).toFloat(),
                            (document.data["specialAttack"]!! as Long).toFloat(),
                            (document.data["specialDefense"]!! as Long).toFloat(),
                            document.data["url"]!! as String
                        )
                        break
                    }
                }
            }
        return pk!!
    }
}