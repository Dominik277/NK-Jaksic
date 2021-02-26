package hr.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import hr.database.table.TablicaRezultati

@Dao
interface TablicaRezultatiDao {

    @Query("SELECT * FROM novi_rezultati ORDER BY novi_broj_kola asc")
    fun getNoviRezultatiData(): List<TablicaRezultati>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNoviRezultati(noviRezultati: TablicaRezultati)

    @Query("DELETE FROM novi_rezultati")
    fun deleteNoviRezultati()

}