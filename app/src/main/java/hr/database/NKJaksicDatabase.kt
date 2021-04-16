package hr.database

import androidx.room.Database
import androidx.room.RoomDatabase
import hr.database.dao.*
import hr.database.table.*

@Database(
    entities = [Igraci::class,
                Vijesti::class,
                TablicaTablica::class,
                NajboljiStrijelci::class,
                Raspored::class, Rezultat::class,
                TablicaRaspored::class,
                TablicaRezultati::class],
                version = 25
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
}