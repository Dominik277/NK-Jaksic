package hr.database

import androidx.room.*

@Dao
interface IgraciDao {

    @Query("SELECT * FROM igraci ORDER BY id desc")
    fun getIgraciData(): List<Igraci>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertIgrac(igraci: Igraci): Long

    @Query("DELETE FROM igraci")
    fun deletePodatke()

}