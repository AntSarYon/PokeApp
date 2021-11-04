package pe.edu.ulima.pm.pokeapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import pe.edu.ulima.pm.pokeapp.R
import pe.edu.ulima.pm.pokeapp.model.Pokemon

class PokemonListAdapter(

    private val pokemonList : List<Pokemon>,
    private val fragment : Fragment,
    private val listener : (Pokemon) ->Unit) :

    //-----------------------------------------------------------------

    RecyclerView.Adapter<PokemonListAdapter.ViewHolder>() {

        class ViewHolder(view : View, val listener : (Pokemon) ->Unit, val pokemonList: List<Pokemon>) : RecyclerView.ViewHolder(view), View.OnClickListener {

            val iviPokemonImage : ImageView
            val tviPokemonName : TextView
            val tviPokemonHP : TextView
            val tviPokemonAttack : TextView
            val tviPokemonDefense : TextView
            val tviPokemonSpecialAttack: TextView
            val tviPokemonSpecialDefense : TextView

            init{
                iviPokemonImage = view.findViewById(R.id.iviPokemon)
                tviPokemonName = view.findViewById(R.id.tvi_name)
                tviPokemonHP = view.findViewById(R.id.tvi_HP_value)
                tviPokemonAttack = view.findViewById(R.id.tvi_Attack_value)
                tviPokemonDefense = view.findViewById(R.id.tvi_Defense_value)
                tviPokemonSpecialAttack = view.findViewById(R.id.tvi_SpecialAttack_value)
                tviPokemonSpecialDefense = view.findViewById(R.id.tvi_SpecialDefense_value)
                view.setOnClickListener(this)
            }

            //------------------------------------------------

            override fun onClick(v: View?) {
                listener(pokemonList[adapterPosition])
            }
        }

    //-----------------------------------------------------------------

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_pokemon, parent, false)
        val viewHolder = ViewHolder(view, listener, pokemonList)
        return viewHolder
    }

    //-----------------------------------------------------------------

    override fun onBindViewHolder(holder: ViewHolder, position: Int)
    {
        //accedo a los elementos de ese item para modificar sus propieades ------
        holder.tviPokemonName.text = pokemonList[position].name
        holder.tviPokemonHP.text = pokemonList[position].hp.toString()
        holder.tviPokemonAttack.text = pokemonList[position].attack.toString()
        holder.tviPokemonDefense.text = pokemonList[position].defense.toString()
        holder.tviPokemonSpecialAttack.text = pokemonList[position].special_attack.toString()
        holder.tviPokemonSpecialDefense.text = pokemonList[position].special_defense.toString()


        //Gestionamos Glide para obtener una imagen para el item por medio de la red ---
        Glide.with(fragment)
            .load(pokemonList[position].url)
            .sizeMultiplier(0.8f)
            .fitCenter()
            .into(holder.iviPokemonImage)
    }

    //-----------------------------------------------------------------

    override fun getItemCount(): Int {
        return pokemonList.size
    }

    }