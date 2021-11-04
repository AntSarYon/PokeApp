package pe.edu.ulima.pm.pokeapp.room

import androidx.room.Database
import androidx.room.RoomDatabase
import pe.edu.ulima.pm.pokeapp.model.Pokemon

@Database(entities = [Pokemon::class], version = 1)

abstract class PKAppDatabase : RoomDatabase() {
    abstract fun pokemonDao() : PokemonDao
}