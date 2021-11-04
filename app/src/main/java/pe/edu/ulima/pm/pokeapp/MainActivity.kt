package pe.edu.ulima.pm.pokeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import pe.edu.ulima.pm.pokeapp.fragments.FavoritesFragment
import pe.edu.ulima.pm.pokeapp.fragments.PokemonDetailFragment
import pe.edu.ulima.pm.pokeapp.fragments.PokemonFragment
import pe.edu.ulima.pm.pokeapp.model.Pokemon

class MainActivity : AppCompatActivity(), PokemonFragment.OnPokemonSelectedListener {

    //Manejamos una Lista de FRAGMENTS
    private var fragments : MutableList<Fragment> = mutableListOf()
    private  lateinit var  dlaMain : DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragments.add(PokemonFragment())
        fragments.add(FavoritesFragment())
        fragments.add(PokemonDetailFragment())

    }

    /*
    //-----------------------------------------------------------

    private fun changePokemonFragment(){
        val fragment = fragments[0]

        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.flaContent, fragment)

        ft.commit()
    }

    //-----------------------------------------------------------

    private fun changePokemonDetailFragment(){
        val fragment = fragments[2]

        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.flaContent, fragment)

        ft.commit()
    }

    //-----------------------------------------------------------

    private fun changeFavoriteFragment(){
        val fragment = fragments[1]

        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.flaContent, fragment)

        ft.commit()
    }

    //-----------------------------------------------------------

    */


    override fun onSelect(pokemon: Pokemon) {
        //______
    }
}