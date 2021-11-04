package pe.edu.ulima.pm.pokeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import pe.edu.ulima.pm.pokeapp.fragments.FavoritesFragment
import pe.edu.ulima.pm.pokeapp.fragments.PokemonDetailFragment
import pe.edu.ulima.pm.pokeapp.fragments.PokemonFragment
import pe.edu.ulima.pm.pokeapp.model.Pokemon

class MainActivity : AppCompatActivity(), PokemonFragment.OnPokemonSelectedListener {

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

        val ft = supportFragmentManager.beginTransaction()
        ft.add(R.id.flaContent,fragmentPK)
        ft.commit()

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
        ft.replace(R.id.flaContent, fragmentPKD)
        ft.commit()
    }

    //-----------------------------------------------------------

    override fun onSelect(pokemon: Pokemon) {
        Log.i("Mensaje","onSelectDefinido")
    }
}