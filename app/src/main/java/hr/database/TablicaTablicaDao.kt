package hr.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TablicaTablicaDao {

    @Query("SELECT * FROM tablica_tablica ORDER BY pozicija asc")
    fun getTablicaTablica(): List<TablicaTablica>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTablicaTablica(tablica_tablica: TablicaTablica)

    @Query("DELETE FROM tablica_tablica")
    fun deleteTablicaTablica()

}