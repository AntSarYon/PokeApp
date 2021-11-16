package pe.edu.ulima.pm.pokeapp.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import pe.edu.ulima.pm.pokeapp.R
import pe.edu.ulima.pm.pokeapp.adapter.FavoritoListAdapter
import pe.edu.ulima.pm.pokeapp.model.PokemonManager

class FavoritesFragment() : Fragment()  {

    interface  onCliked{
        fun onClick()
    }
    private var listener : onCliked?=null
    private var lista : MutableList<String> = mutableListOf()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as? onCliked

    }

    //-----------------------------------------------------------------------------

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_favorites, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val editor = view.context.getSharedPreferences("FAVORITOS",Context.MODE_PRIVATE)
        lista = editor.getStringSet("LIST_POKEMON", setOf<String>())?.toMutableList()!!
        val rvNombres = view.findViewById<RecyclerView>(R.id.rviFavorites)
        rvNombres.adapter = FavoritoListAdapter(lista, this){
            nombre : String ->
            lista.removeAt(lista.indexOf(nombre))
            listener?.onClick()
        }
    }

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        val rvNombres = view?.findViewById<RecyclerView>(R.id.rviFavorites)
        rvNombres?.adapter = FavoritoListAdapter(lista, this){
                nombre : String ->
            lista.removeAt(lista.indexOf(nombre))
            listener?.onClick()
        }
    }
}