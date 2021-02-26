package hr.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import hr.database.table.TablicaRaspored

@Dao
interface TablicaRasporedDao {

    @Query("SELECT * FROM tablica_raspored ORDER BY id asc")
    fun getRasporedData(): LiveData<List<TablicaRaspored>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertRaspored(tablicaRaspored: TablicaRaspored)

    @Query("DELETE FROM tablica_raspored")
    fun deletePodatkeRaspored()

}