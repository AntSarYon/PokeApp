package pe.edu.ulima.pm.pokeapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentResultListener
import pe.edu.ulima.pm.pokeapp.fragments.FavoritesFragment
import pe.edu.ulima.pm.pokeapp.fragments.PokemonDetailFragment
import pe.edu.ulima.pm.pokeapp.fragments.PokemonFragment

data class Favoritos(val nombres: MutableList<String>)

class MainActivity : AppCompatActivity(), PokemonFragment.OnPokemonSelectedListener, PokemonDetailFragment.OnClicked, FavoritesFragment.onCliked {

    //Manejamos los Fragments
    private var fragmentPK : Fragment = Fragment()
    private var fragmentPKD : Fragment = Fragment()
    private var fragmentPKF : Fragment = Fragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragmentPK = PokemonFragment()          // <-- Fragment Pokemon
        fragmentPKD = PokemonDetailFragment()       // <-- Fragment Detalles del Pokemon
        fragmentPKF = FavoritesFragment()   // <-- Fragment Pokemon Favoritos

        var fragmentMostrado = intent.getBundleExtra("data")?.getString("fragment")

        //SI SE OPRIMIÓ EL BOTON "CONTINUAR" MUESTRA EL FRAGMENT DE POKEMON
        if(fragmentMostrado.equals("pokemon")){
            val ft = supportFragmentManager.beginTransaction()
            ft.replace(R.id.flaContent,fragmentPK)
            ft.commit()
        }
        //SI SE OPRIMIÓ EL BOTON "FAVORITOS" MUESTRA EL FRAGMENT DE POKEMON
        else if(fragmentMostrado.equals("favoritos")){
            val ft = supportFragmentManager.beginTransaction()
            ft.replace(R.id.flaContent,fragmentPKF)
            ft.commit()
        }

    }

    //-- FUNCION | Cambio a Lista de Pokemon ---------------------------------

    private fun changePokemonFragment(){
        val ft = supportFragmentManager.beginTransaction()
        ft.remove(fragmentPKD)
        ft.remove(fragmentPKF)
        ft.show(fragmentPK)
        ft.commit()
    }

    //-- FUNCION | Cambio a Pokemon favoritos ---------------------------------

    private fun changeFavoritesFragment(){
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.flaContent, fragmentPKF)
        ft.commit()

    }

    //-- FUNCION | Cambio a Detalles de Pokemon ---------------------------------

    private fun changePokemonDetailFragment(){
        val ft = supportFragmentManager.beginTransaction()
        fragmentPKD =  PokemonDetailFragment()
        ft.add(R.id.flaContent, fragmentPKD)
        ft.hide(fragmentPK)
        ft.commit()
    }

    //-----------------------------------------------------------

    override fun onSelect() {
        changePokemonDetailFragment()

    }

    override fun onClick(vista: String) {
        if(vista == "cancelar"){
        changePokemonFragment()
        }else{
            val editor = getSharedPreferences("FAVORITOS",Context.MODE_PRIVATE)
            val favoritos = editor.getStringSet("LIST_POKEMON", setOf<String>())?.toMutableList()
            if(favoritos!=null){
                favoritos.add(vista)
                Log.i("valor",favoritos[0].toString())
                val editor2 = getSharedPreferences("FAVORITOS",Context.MODE_PRIVATE).edit()
                editor2.putStringSet("LIST_POKEMON",favoritos.toSet())
                editor2.commit()
            }

            changePokemonFragment()

        }
    }

    override fun onClick() {
        changePokemonFragment()
    }
}