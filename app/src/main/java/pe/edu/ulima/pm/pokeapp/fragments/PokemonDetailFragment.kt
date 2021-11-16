package pe.edu.ulima.pm.pokeapp.fragments

import android.content.Context
import android.os.Bundle
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Button
import androidx.core.os.HandlerCompat
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import pe.edu.ulima.pm.pokeapp.R
import pe.edu.ulima.pm.pokeapp.model.PokemonManager

class PokemonDetailFragment() : Fragment() {



    //-------------------------------------------------------------------

    private var listener : OnClicked? = null
    private var ide : Long? = null

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
            ide = bundle.getLong("id")
            val handler = HandlerCompat.createAsync(Looper.myLooper()!!)
            Thread() {
                val pokemon = PokemonManager(requireActivity().applicationContext).getPokemon(this.ide!!)
                handler.post {
                    val name = view.findViewById<TextView>(R.id.tvi_nombre)
                    name.text = pokemon.name
                    val hp = view.findViewById<TextView>(R.id.tvi_DHP_value)
                    hp.text = pokemon.hp.toString()
                    val att = view.findViewById<TextView>(R.id.tvi_DAttack_value)
                    att.text = pokemon.attack.toString()
                    val def = view.findViewById<TextView>(R.id.tvi_DDefense_value)
                    def.text = pokemon.defense.toString()
                    val ate = view.findViewById<TextView>(R.id.tvi_DSpecialAttack_value)
                    ate.text = pokemon.specialAttack.toString()
                    val dee = view.findViewById<TextView>(R.id.tvi_DSpecialDefense_value)
                    dee.text = pokemon.specialDefense.toString()

                    var img = view.findViewById<ImageView>(R.id.imageView)
                    Glide.with(this).load(pokemon.url)
                        .sizeMultiplier(1f).fitCenter()
                        .into(img)
                }
            }.start()
        })

        return view
    }

    //-----------------------------------------------------------------------------

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnAtras = view.findViewById<Button>(R.id.btnAtras)
        btnAtras.setOnClickListener {
            listener?.onClick("cancelar")
        }
        val btnFavoritos = view.findViewById<Button>(R.id.but_añadir)
        btnFavoritos.setOnClickListener {
            val nombre = view.findViewById<TextView>(R.id.tvi_nombre)
            listener?.onClick(nombre.text.toString())
        }
    }

}