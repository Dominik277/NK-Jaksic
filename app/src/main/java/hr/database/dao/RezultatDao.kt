package hr.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import hr.database.table.Raspored
import hr.database.table.Rezultat

@Dao
interface RezultatDao {

    @Query("SELECT * FROM rezultat_rezultat ORDER BY id asc")
    fun getRezultatData(): LiveData<List<Rezultat>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRezultat(rezultat: Rezultat)

    @Query("DELETE FROM rezultat_rezultat")
    fun deletePodatkeRezultat()

}