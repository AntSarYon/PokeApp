package pe.edu.ulima.pm.pokeapp.model

import android.content.Context
import android.util.Log
import androidx.room.Room
import com.google.gson.Gson
import me.sargunvohra.lib.pokekotlin.client.PokeApiClient
import pe.edu.ulima.pm.pokeapp.room.PKAppDatabase

class PokemonManager(context: Context) {

    val db = Room.databaseBuilder(context, PKAppDatabase::class.java, "db_pokemon").allowMainThreadQueries().build()
    //val API_URL = "https://pokeapi.co/api/v2/"

    fun getPokemon(callbackOK : (List<Pokemon>) -> Unit , callbackError : (String) ->Unit) {

        //PRIMERO GESTIONAR EL NETWORKCLIENT
        // (...)
    }
    fun getAllPokemon():List<me.sargunvohra.lib.pokekotlin.model.Pokemon>{
        val pokeApi = PokeApiClient()

        val lista : MutableList<me.sargunvohra.lib.pokekotlin.model.Pokemon> = mutableListOf()
        for (i in 1..20){
            val test = pokeApi.getPokemon(i)
            lista.add(test)
        }
        return lista;
    }

}