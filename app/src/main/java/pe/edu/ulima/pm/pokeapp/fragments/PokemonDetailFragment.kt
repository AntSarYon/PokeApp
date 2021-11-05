package pe.edu.ulima.pm.pokeapp.fragments

import android.content.Context
import android.os.Bundle
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.HandlerCompat
import androidx.fragment.app.Fragment
import pe.edu.ulima.pm.pokeapp.R
import pe.edu.ulima.pm.pokeapp.model.PokemonManager

class PokemonDetailFragment() : Fragment() {



    //-------------------------------------------------------------------

    private var listener : OnClicked? = null
    private var ide = 0

    interface OnClicked{
        fun onClick(vista:String)
    }
    //-------------------------------------------------------------------

    override fun onAttach(context : Context) {
        super.onAttach(context)
        listener = context as? OnClicked

    }

    //-------------------------------------------------------------------

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    //-------------------------------------------------------------------

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_pokemondetail, container, false)
        //parentFragmentManager.setFragmentResultListener("pokemon",this,{ requestkey, bundle ->
        //    result = bundle.getString("id").toString()
        //}
        parentFragmentManager.setFragmentResultListener("pok",this,{
            requestKey, bundle ->
            ide = bundle.getInt("id")

        })

        return view
    }

    //-----------------------------------------------------------------------------

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}