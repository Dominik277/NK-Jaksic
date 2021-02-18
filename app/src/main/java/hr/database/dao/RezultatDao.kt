package hr.database.dao

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import hr.database.table.Raspored
import hr.database.table.Rezultat

interface RezultatDao {

    @Query("SELECT * FROM rezultat_rezultat ORDER BY id asc")
    fun getRezultatData(): List<Rezultat>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRezultat(rezultat_rezultat: Rezultat)

    @Query("DELETE FROM rezultat_rezultat")
    fun deletePodatkeRezultat()

}