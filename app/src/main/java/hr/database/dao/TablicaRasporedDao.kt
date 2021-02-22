package hr.database.dao

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import hr.database.table.TablicaRaspored

interface TablicaRasporedDao {

    @Query("SELECT * FROM tablica_raspored ORDER BY broj_kola asc")
    fun getRasporedData(): List<TablicaRaspored>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRaspored(tablicaRaspored: TablicaRaspored)

    @Query("DELETE FROM tablica_raspored")
    fun deletePodatkeRaspored()

}