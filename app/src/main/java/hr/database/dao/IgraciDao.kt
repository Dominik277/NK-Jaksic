package hr.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import hr.database.table.Igraci

@Dao
interface IgraciDao {

    @Query("SELECT * FROM igraci ORDER BY id desc")
    fun getIgraciData(): LiveData<List<Igraci>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertIgrac(igraci: Igraci): Long

    @Update
    suspend fun updateIgrac(igraci: Igraci)

    @Delete
    suspend fun deleteIgrac(igraci: Igraci)

    @Query("DELETE FROM igraci")
    suspend fun deletePodatke()

}