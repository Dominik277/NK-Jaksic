package hr.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import hr.database.dao.*
import hr.database.table.*

@Database(entities = [Igraci::class, Vijesti::class, TablicaTablica::class,NajboljiStrijelci::class,Raspored::class,Rezultat::class],version = 8)
abstract class NKJaksicDatabase: RoomDatabase() {

    abstract fun igraciDao(): IgraciDao
    abstract fun vijestiDao(): VijestiDao
    abstract fun tablicaDao(): TablicaTablicaDao
    abstract fun strijelciDao(): NajboljiStrijelciDao
    abstract fun rasporedDao(): RasporedDao
    abstract fun rezultatiDao(): RezultatDao
    abstract fun najboljiStrijelciDao(): NajboljiStrijelciDao

    companion object{
        private var INSTANCE : NKJaksicDatabase? = null

        fun getAppDatabase(context: Context): NKJaksicDatabase?{
            if (INSTANCE == null){
                INSTANCE = Room.databaseBuilder(
                        context.applicationContext,NKJaksicDatabase::class.java,"nk_jaksic_baza"
                )
                        .allowMainThreadQueries()
                        .build()
            }
            return INSTANCE
        }
    }

}