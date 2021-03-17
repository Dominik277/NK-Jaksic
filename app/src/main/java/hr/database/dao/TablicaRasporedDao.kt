package hr.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import hr.database.table.TablicaRaspored

@Dao
interface TablicaRasporedDao {

    @Query("SELECT * FROM tablica_raspored ORDER BY id asc")
    fun getRasporedData(): LiveData<List<TablicaRaspored>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertRaspored(tablicaRaspored: TablicaRaspored)

    @Update
    suspend fun updateTablicaRaspored(tablicaRaspored: TablicaRaspored)

    @Delete
    suspend fun deleteOneTablicaRaspored(tablicaRaspored: TablicaRaspored)

    @Query("DELETE FROM tablica_raspored")
    fun deletePodatkeRaspored()

}