package pe.edu.ulima.pm.pokeapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// "https://pokeapi.co/api/v2/pokemon/"

@Entity()
data class Pokemon(

    @PrimaryKey
    val id : Long,

    // name --> "bulbasaur"
    @ColumnInfo(name="name")
    val name : String,

    //stats[0] > base_stat
    @ColumnInfo(name="hp")
    val hp : Float,

    //stats[1] > base_stat
    @ColumnInfo(name="attack")
    val attack : Float,

    //stats[2] > base_stat
    @ColumnInfo(name="defense")
    val defense: Float,

    //stats[3] > base_stat
    @ColumnInfo(name="special_attack")
    val specialAttack : Float,

    //stats[4] > base_stat
    @ColumnInfo(name="special_defense")
    val specialDefense: Float,

    // sprites > other > official_artwork > front_default
    //Devuelve este URL a la imagen del pokemon --> https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/1.png
    @ColumnInfo(name="url")
    val url: String

)