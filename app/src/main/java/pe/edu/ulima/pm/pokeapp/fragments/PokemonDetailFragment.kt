package pe.edu.ulima.pm.pokeapp.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import pe.edu.ulima.pm.pokeapp.R
import pe.edu.ulima.pm.pokeapp.model.Pokemon

class PokemonDetailFragment() : Fragment() {

    interface onClicked{
        fun onClick(vista:String)
    }

    //-------------------------------------------------------------------

    private var listener : onClicked? = null
    private var result : String = ""

    //-------------------------------------------------------------------

    override fun onAttach(context : Context) {
        super.onAttach(context)
        listener = context as? onClicked

        if(listener == null){
            Log.e("PokemonDetaiFragment", "Activity no implementa interface de Details")
        }
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
        return inflater.inflate(R.layout.fragment_pokemondetail, container, false)
        //parentFragmentManager.setFragmentResultListener("pokemon",this,{ requestkey, bundle ->
        //    result = bundle.getString("id").toString()
        //}
    }

    //-----------------------------------------------------------------------------

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //
    }

}