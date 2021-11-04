package pe.edu.ulima.pm.pokeapp.model

import android.content.Context
import androidx.room.Room
import pe.edu.ulima.pm.pokeapp.room.PKAppDatabase

class PokemonManager(context: Context) {

    val db = Room.databaseBuilder(context, PKAppDatabase::class.java, "db_pokemon").allowMainThreadQueries().build()
    //val API_URL = "https://pokeapi.co/api/v2/pokemon/"

    fun getPokemon(callbackOK : (List<Pokemon>) -> Unit , callbackError : (String) ->Unit) {

        //PRIMERO GESTIONAR EL NETWORKCLIENT
        // (...)
    }
}