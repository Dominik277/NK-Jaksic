package hr.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import hr.database.table.TablicaRezultati

@Dao
interface TablicaRezultatiDao {

    @Query("SELECT * FROM novi_rezultati ORDER BY novi_broj_kola asc")
    fun getNoviRezultatiData(): LiveData<List<TablicaRezultati>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertNoviRezultati(noviRezultati: TablicaRezultati)

    @Update
    suspend fun updateTablicaRezultat(tablicaRezultati: TablicaRezultati)

    @Delete
    suspend fun deleteOneTablicaRezultati(tablicaRezultati: TablicaRezultati)

    @Query("DELETE FROM novi_rezultati")
    fun deleteNoviRezultati()

}