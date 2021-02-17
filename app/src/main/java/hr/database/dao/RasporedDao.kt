package hr.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import hr.database.table.Raspored
import hr.database.table.Vijesti

@Dao
interface RasporedDao {

    @Query("SELECT * FROM raspored ORDER BY id asc")
    fun getRasporedData(): List<Raspored>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRaspored(raspored: Raspored)

    @Query("DELETE FROM raspored")
    fun deletePodatkeRaspored()

}