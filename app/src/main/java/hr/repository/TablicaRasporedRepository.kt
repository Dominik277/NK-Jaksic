package hr.repository

import androidx.lifecycle.LiveData
import hr.database.dao.TablicaRasporedDao
import hr.database.table.TablicaRaspored

class TablicaRasporedRepository(private val tablicaRasporedDao: TablicaRasporedDao) {

    val readAllDataTablicaRaspored: LiveData<List<TablicaRaspored>> = tablicaRasporedDao.getRasporedData()

    suspend fun addTablicaRaspored (tablicaRaspored: TablicaRaspored){
        tablicaRasporedDao.insertRaspored(tablicaRaspored)
    }

}