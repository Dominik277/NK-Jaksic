package hr.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface IgraciDao {

    @Query("SELECT * FROM igraci ORDER BY id desc")
    fun getIgraciData(): List<Igraci>

    @Insert
    fun insertIgrac(igraci: Igraci): Long

    @Delete
    fun delete(igraci: Igraci)

}