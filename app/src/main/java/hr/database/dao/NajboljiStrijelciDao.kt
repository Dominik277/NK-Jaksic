package hr.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import hr.database.table.Igraci
import hr.database.table.NajboljiStrijelci

@Dao
interface NajboljiStrijelciDao {

    @Query("SELECT * FROM najbolji_strijelci ORDER BY pozicija_po_golovima asc")
    fun getNajboljiStrijelciData(): LiveData<List<NajboljiStrijelci>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertNajboljiStrijelac(najboljiStrijelac: NajboljiStrijelci)

    @Query("DELETE FROM najbolji_strijelci")
    fun deleteNajboljiStrijelci()

}