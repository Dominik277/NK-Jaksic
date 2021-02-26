package hr.repository

import androidx.lifecycle.LiveData
import hr.database.dao.RasporedDao
import hr.database.table.Raspored

class RasporedRepository(private val rasporedDao: RasporedDao) {

    val readAllData: LiveData<List<Raspored>> = rasporedDao.getRasporedData()

    suspend fun addRaspored(raspored: Raspored){
        rasporedDao.insertRaspored(raspored)
    }

}