package hr.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface VijestiDao {

    @Query("SELECT * FROM vijesti")
    fun getAllVijesti(): List<Vijesti>

    @Insert
    fun insertVijest(vijesti: Vijesti)

    @Query("DELETE FROM vijesti")
    fun deleteVijesti()

}