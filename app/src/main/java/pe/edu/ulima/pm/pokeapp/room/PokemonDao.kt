package pe.edu.ulima.pm.pokeapp.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import pe.edu.ulima.pm.pokeapp.model.Pokemon

@Dao
interface PokemonDao {

    @Query("SELECT * FROM Pokemon")
    fun findAll(): List<Pokemon>

    @Query("select * from Pokemon WHERE id=:id")
    fun findByName(id : Long) : Pokemon

    @Insert
    fun insert(pokemon : Pokemon)

}