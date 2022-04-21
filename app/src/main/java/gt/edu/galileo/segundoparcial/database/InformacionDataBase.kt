package gt.edu.galileo.segundoparcial.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import gt.edu.galileo.segundoparcial.model.Informacion

@Database(entities = arrayOf(Informacion::class), version = 1)
abstract class InformacionDataBase() : RoomDatabase() {
    abstract fun infoDao(): InformacionDao
    companion object {
        @Volatile private var instace: InformacionDataBase? = null
        private val LOCK = Any()
        operator fun invoke(context: Context) = instace?: synchronized(LOCK) {
            instace ?: buildDatabase(context).also { db ->
                instace = db
            }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            InformacionDataBase::class.java,
            "gradosDatabase"
        ).build()
    }
}