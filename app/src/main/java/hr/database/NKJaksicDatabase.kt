package hr.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import hr.database.dao.IgraciDao
import hr.database.dao.TablicaTablicaDao
import hr.database.dao.VijestiDao
import hr.database.table.Igraci
import hr.database.table.TablicaTablica
import hr.database.table.Vijesti

@Database(entities = [Igraci::class, Vijesti::class, TablicaTablica::class],version = 5)
abstract class NKJaksicDatabase: RoomDatabase() {

    abstract fun igraciDao(): IgraciDao
    abstract fun vijestiDao(): VijestiDao
    abstract fun tablicaDao(): TablicaTablicaDao

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