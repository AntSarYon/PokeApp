package pe.edu.ulima.pm.pokeapp.network

import pe.edu.ulima.pm.pokeapp.model.Pokemon
import retrofit2.Call
import retrofit2.http.GET

//https://pokeapi.co/api/v2/pokemon?offset=0&limit=20
interface APIPokemonService {
    @GET("pokemon?offset=0&limit=20")
    fun getAllPokemon():Call<List<Pokemon>>
}