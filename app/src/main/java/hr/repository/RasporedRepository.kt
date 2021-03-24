package hr.repository

import androidx.lifecycle.LiveData
import hr.database.dao.RasporedDao
import hr.database.table.Raspored
import javax.inject.Inject

class RasporedRepository @Inject constructor(
    private val rasporedDao: RasporedDao
) {

    fun getAllDataRaspored() = rasporedDao.getRasporedData()

    suspend fun addRaspored(raspored: Raspored) {
        rasporedDao.insertRaspored(raspored)
    }

    suspend fun updateRaspored(raspored: Raspored) {
        rasporedDao.updateRaspored(raspored)
    }

    suspend fun deleteRaspored(raspored: Raspored) {
        rasporedDao.deleteRaspored(raspored)
    }

    suspend fun deleteAllRaspored() {
        rasporedDao.deleteAllRaspored()
    }

}