package hr.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import hr.database.table.Raspored
import hr.database.table.Rezultat

@Dao
interface RezultatDao {

    @Query("SELECT * FROM rezultat_rezultat ORDER BY id asc")
    fun getRezultatData(): LiveData<List<Rezultat>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRezultat(rezultat: Rezultat)

    @Update
    suspend fun updateRezultat(rezultat: Rezultat)

    @Delete
    suspend fun deleteOneRezultat(rezultat: Rezultat)

    @Query("DELETE FROM rezultat_rezultat")
    suspend fun deletePodatkeRezultat()

}