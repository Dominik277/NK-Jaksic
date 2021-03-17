package hr.database.dao

import androidx.room.*
import hr.database.table.Vijesti

@Dao
interface VijestiDao {

    @Query("SELECT * FROM vijesti ORDER BY id desc")
    fun getVijestiData(): List<Vijesti>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertVijest(vijesti: Vijesti): Long

    @Update
    suspend fun updateVijesti(vijesti: Vijesti)

    @Delete
    suspend fun deleteVijesti(vijesti: Vijesti)

    @Query("DELETE FROM vijesti")
    fun deletePodatkeVijesti()

}