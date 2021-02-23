package hr.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import hr.database.table.NoviRezultati

@Dao
interface NoviRezultatiDao {

    @Query("SELECT * FROM novi_rezultati ORDER BY novi_broj_kola asc")
    fun getNoviRezultatiData(): List<NoviRezultati>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNoviRezultati(noviRezultati: NoviRezultati)

    @Query("DELETE FROM novi_rezultati")
    fun deleteNoviRezultati()

}