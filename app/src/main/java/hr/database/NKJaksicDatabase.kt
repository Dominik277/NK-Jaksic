package hr.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import hr.database.dao.*
import hr.database.table.*

@Database(entities = [Igraci::class, Vijesti::class, TablicaTablica::class,NajboljiStrijelci::class,Raspored::class],version = 7)
abstract class NKJaksicDatabase: RoomDatabase() {

    abstract fun igraciDao(): IgraciDao
    abstract fun vijestiDao(): VijestiDao
    abstract fun tablicaDao(): TablicaTablicaDao
    abstract fun strijelciDao(): NajboljiStrijelciDao
    abstract fun rasporedDao(): RasporedDao

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