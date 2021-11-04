package pe.edu.ulima.pm.pokeapp.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import pe.edu.ulima.pm.pokeapp.R
import pe.edu.ulima.pm.pokeapp.model.Pokemon
import pe.edu.ulima.pm.pokeapp.model.PokemonManager

class PokemonFragment() : Fragment() {

    private var listener : OnPokemonSelectedListener? = null

    //---------------- CREACION DE INTERFACE-------------------------------

    interface OnPokemonSelectedListener {
        fun onSelect(pokemon : Pokemon)
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
        // AQUI FALTA COMPLETAR AUN...

    }
}