package hr.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import hr.database.dao.*
import hr.database.table.*
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized

@Database(
    entities = [Igraci::class, Vijesti::class, TablicaTablica::class, NajboljiStrijelci::class, Raspored::class, Rezultat::class, TablicaRaspored::class, TablicaRezultati::class],
    version = 22
)
abstract class NKJaksicDatabase : RoomDatabase() {

    abstract fun igraciDao(): IgraciDao
    abstract fun vijestiDao(): VijestiDao
    abstract fun tablicaDao(): TablicaTablicaDao
    abstract fun rasporedDao(): RasporedDao
    abstract fun rezultatiDao(): RezultatDao
    abstract fun najboljiStrijelciDao(): NajboljiStrijelciDao
    abstract fun tablicaRasporedDao(): TablicaRasporedDao
    abstract fun tablicaRezultatiDao(): TablicaRezultatiDao

    companion object {
        @Volatile
        private var INSTANCE: NKJaksicDatabase? = null

        @InternalCoroutinesApi
        fun getDatabase(context: Context): NKJaksicDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NKJaksicDatabase::class.java,
                    "nk_jaksic_baza"
                ).fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}