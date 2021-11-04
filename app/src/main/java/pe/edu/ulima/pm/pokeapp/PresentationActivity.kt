package pe.edu.ulima.pm.pokeapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class PresentationActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_presentation)


        val butContinuar : Button = findViewById(R.id.but_continuar)
        butContinuar.setOnClickListener {
            val intent = Intent()
            val bundle = Bundle()

            //El Bundle indica que se debe mostar el Fragment de la lista de Pokemon
            bundle.putString("fragment", "pokemon")
            intent.putExtra("data", bundle)

            intent.setClass(this, MainActivity::class.java)
            startActivity(intent)
        }

        val butFavoritos : Button = findViewById<Button>(R.id.but_favoritos)
        butFavoritos.setOnClickListener {
            val intent = Intent()
            val bundle = Bundle()

            //El Bundle indica que se debe mostar el Fragment de Favoritos
            bundle.putString("fragment", "favoritos")
            intent.putExtra("data", bundle)

            intent.setClass(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}