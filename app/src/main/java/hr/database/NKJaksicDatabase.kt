package hr.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Igraci::class,Vijesti::class],version = 3)
abstract class NKJaksicDatabase: RoomDatabase() {

    abstract fun igraciDao(): IgraciDao

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