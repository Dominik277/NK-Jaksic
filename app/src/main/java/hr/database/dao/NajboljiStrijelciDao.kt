package hr.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import hr.database.table.Igraci
import hr.database.table.NajboljiStrijelci

@Dao
interface NajboljiStrijelciDao {

    @Query("SELECT * FROM najbolji_strijelci ORDER BY pozicija_po_golovima asc")
    fun getNajboljiStrijelciData(): LiveData<List<NajboljiStrijelci>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertNajboljiStrijelac(najboljiStrijelac: NajboljiStrijelci)

    @Update
    suspend fun updateNajboljiStrijelci(najboljiStrijelac: NajboljiStrijelci)

    @Delete
    suspend fun deleteNajboljiStrijelac(najboljiStrijelac: NajboljiStrijelci)

    @Query("DELETE FROM najbolji_strijelci")
    fun deleteNajboljiStrijelci()

}