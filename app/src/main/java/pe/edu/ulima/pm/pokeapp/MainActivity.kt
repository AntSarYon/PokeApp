package pe.edu.ulima.pm.pokeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import pe.edu.ulima.pm.pokeapp.fragments.FavoritesFragment
import pe.edu.ulima.pm.pokeapp.fragments.PokemonDetailFragment
import pe.edu.ulima.pm.pokeapp.fragments.PokemonFragment

class MainActivity : AppCompatActivity(), PokemonFragment.OnPokemonSelectedListener, PokemonDetailFragment.OnClicked {

    //Manejamos los Fragments
    private var fragmentPK : Fragment = Fragment()
    private var fragmentPKD : Fragment = Fragment()
    private var fragmentPKF : Fragment = Fragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragmentPK = PokemonFragment()          // <-- Fragment Pokemon
        fragmentPKD = FavoritesFragment()       // <-- Fragment Detalles del Pokemon
        fragmentPKF = PokemonDetailFragment()   // <-- Fragment Pokemon Favoritos

        var fragmentMostrado = intent.getBundleExtra("data")?.getString("fragment")

        //SI SE OPRIMIÓ EL BOTON "CONTINUAR" MUESTRA EL FRAGMENT DE POKEMON
        if(fragmentMostrado.equals("pokemon")){
            val ft = supportFragmentManager.beginTransaction()
            ft.add(R.id.flaContent,fragmentPK)
            ft.commit()
        }
        //SI SE OPRIMIÓ EL BOTON "FAVORITOS" MUESTRA EL FRAGMENT DE POKEMON
        else if(fragmentMostrado.equals("favoritos")){
            val ft = supportFragmentManager.beginTransaction()
            ft.add(R.id.flaContent,fragmentPKF)
            ft.commit()
        }

    }

    //-- FUNCION | Cambio a Lista de Pokemon ---------------------------------

    private fun changePokemonFragment(){
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.flaContent, fragmentPK)
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
        ft.replace(R.id.flaContent, fragmentPKD)
        ft.commit()
    }

    //-----------------------------------------------------------

    override fun onSelect() {
        changePokemonDetailFragment()

    }

    override fun onClick(vista: String) {
        changePokemonFragment()
    }
}