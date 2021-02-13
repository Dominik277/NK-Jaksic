package hr.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface VijestiDao {

    @Query("SELECT * FROM vijesti ORDER BY id desc")
    fun getVijestiData(): List<Vijesti>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertVijest(vijesti: Vijesti): Long

    @Query("DELETE FROM vijesti")
    fun deletePodatkeVijesti()

}