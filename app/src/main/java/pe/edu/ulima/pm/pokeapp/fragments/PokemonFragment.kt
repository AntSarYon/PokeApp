package pe.edu.ulima.pm.pokeapp.fragments

import android.content.Context
import android.os.Bundle
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.HandlerCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import pe.edu.ulima.pm.pokeapp.R
import pe.edu.ulima.pm.pokeapp.adapter.PokemonListAdapter
import pe.edu.ulima.pm.pokeapp.model.Pokemon
import pe.edu.ulima.pm.pokeapp.model.PokemonManager
import java.io.FileNotFoundException
import java.lang.reflect.Type
import kotlin.concurrent.thread

class PokemonFragment() : Fragment() {

    private var listener : OnPokemonSelectedListener? = null

    //---------------- CREACION DE INTERFACE-------------------------------

    interface OnPokemonSelectedListener {
        fun onSelect(pokemon : me.sargunvohra.lib.pokekotlin.model.Pokemon)
    }

    //-----------------------------------------------------------------------------

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnPokemonSelectedListener
   }

    //-----------------------------------------------------------------------------

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_pokemon, container, false)
    }

    //-----------------------------------------------------------------------------

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        var pkLista: List<me.sargunvohra.lib.pokekotlin.model.Pokemon> = listOf()
        val rviPokemon = view.findViewById<RecyclerView>(R.id.rviPokemon)
        val handler = HandlerCompat.createAsync(Looper.myLooper()!!)
        Thread() {
             pkLista = PokemonManager(requireActivity().applicationContext).getAllPokemon()//getPokemonAI()
             handler.post {
                 rviPokemon.adapter = PokemonListAdapter(pkLista,this){
                     pokemon ->
                     Log.i("ProductsFragment", pokemon.name)
                     listener?.onSelect(pokemon)
                 }

             }
            val gson = Gson()
            activity?.openFileOutput("Pokemon.json", Context.MODE_PRIVATE).use{
                pkLista.forEach { pok ->
                    it?.write(gson.toJson(pok).toByteArray(Charsets.UTF_8))
                }
            }
        }.start()
    }
    //funcion para almacenamiento interno de pokemon
    fun getPokemonAI(): List<me.sargunvohra.lib.pokekotlin.model.Pokemon> {
        var cadena : String =""
        try {
            activity?.openFileInput("Pokemon.json").use {
                val byteArray = it?.readBytes()
                cadena = String(byteArray!!)
            }
        }catch (info:FileNotFoundException){
            Log.i("kk", "error")
        }
        //val listType = TypeToken<List<me.sargunvohra.lib.pokekotlin.model.Pokemon>>(){}.type
        val pkList : List<me.sargunvohra.lib.pokekotlin.model.Pokemon> = Gson().fromJson<List<me.sargunvohra.lib.pokekotlin.model.Pokemon>>(
            cadena,me.sargunvohra.lib.pokekotlin.model.Pokemon::class.java)
        return pkList
    }
}