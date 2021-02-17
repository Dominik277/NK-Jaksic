package hr.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import hr.database.table.Vijesti

@Dao
interface VijestiDao {

    @Query("SELECT * FROM vijesti ORDER BY id desc")
    fun getVijestiData(): List<Vijesti>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertVijest(vijesti: Vijesti): Long

    @Query("DELETE FROM vijesti")
    fun deletePodatkeVijesti()

}