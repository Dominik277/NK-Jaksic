package hr.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import hr.database.table.Raspored
import hr.database.table.Vijesti

@Dao
interface RasporedDao {

    @Query("SELECT * FROM raspored ORDER BY id asc")
    fun getRasporedData(): LiveData<List<Raspored>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertRaspored(raspored: Raspored)

    @Update
    suspend fun updateRaspored(raspored: Raspored)

    @Delete
    suspend fun deleteRaspored(raspored: Raspored)

    @Query("DELETE FROM raspored")
    suspend fun deleteAllRaspored()

    @Query("DELETE FROM raspored")
    fun deletePodatkeRaspored()

}