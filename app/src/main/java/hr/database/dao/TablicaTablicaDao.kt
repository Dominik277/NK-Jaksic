package hr.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import hr.database.table.TablicaTablica

@Dao
interface TablicaTablicaDao {

    @Query("SELECT * FROM tablica_tablica ORDER BY pozicija asc")
    fun getTablicaTablica(): LiveData<List<TablicaTablica>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTablicaTablica(tablica_tablica: TablicaTablica)

    @Update
    suspend fun updateTablicaTablica(tablica_tablica: TablicaTablica)

    @Delete
    suspend fun deleteOneTablicaTablica(tablica_tablica: TablicaTablica)

    @Query("DELETE FROM tablica_tablica")
    fun deleteTablicaTablica()

}