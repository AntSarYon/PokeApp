package pe.edu.ulima.pm.pokeapp.adapter

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import pe.edu.ulima.pm.pokeapp.R

class FavoritoListAdapter(
    private val pokemonLista : MutableList<String>,
    private val fragment : Fragment,
    private val listener : (String) -> Unit) : RecyclerView.Adapter<FavoritoListAdapter.ViewHolder>(){

        class ViewHolder(view: View, val listener: (String) -> Unit, val pokemonLista: MutableList<String>): RecyclerView.ViewHolder(view), View.OnClickListener{
            val tviPokemon : TextView

            init {
                tviPokemon = view.findViewById(R.id.tviPKFavorito)
                view.setOnClickListener(this)
            }

            override fun onClick(p0: View?) {
                listener(pokemonLista[adapterPosition])
            }

        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_favorite,parent,false)
        val viewHolder = ViewHolder(view,listener,pokemonLista)
        return  viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tviPokemon.text = pokemonLista[position]
    }

    override fun getItemCount(): Int {
        return pokemonLista.size
    }
}