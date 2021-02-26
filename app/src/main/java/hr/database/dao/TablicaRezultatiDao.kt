package hr.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import hr.database.table.TablicaRezultati

@Dao
interface TablicaRezultatiDao {

    @Query("SELECT * FROM novi_rezultati ORDER BY novi_broj_kola asc")
    fun getNoviRezultatiData(): LiveData<List<TablicaRezultati>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertNoviRezultati(noviRezultati: TablicaRezultati)

    @Query("DELETE FROM novi_rezultati")
    fun deleteNoviRezultati()

}