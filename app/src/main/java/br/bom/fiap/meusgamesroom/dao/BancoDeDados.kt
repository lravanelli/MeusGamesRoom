package br.bom.fiap.meusgamesroom.dao

/**
 * Created by logonrm on 07/04/2018.
 */
import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import br.bom.fiap.meusgamesroom.dao.GameDAO
import br.bom.fiap.meusgamesroom.model.Game

@Database(entities = arrayOf(Game::class), version = 1)
abstract class BancoDeDados : RoomDatabase() {
    abstract fun gameDAO(): GameDAO
    companion object {
        var INSTANCE: BancoDeDados? = null
        fun getDatabase(context: Context): BancoDeDados? {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.applicationContext,
                        BancoDeDados::class.java,
                        "gamesdbs")
                        .build()
            }
            return INSTANCE
        }
    }
}