package hr.repository

import androidx.lifecycle.LiveData
import hr.database.dao.TablicaRasporedDao
import hr.database.table.TablicaRaspored
import javax.inject.Inject

class TablicaRasporedRepository @Inject constructor(
    private val tablicaRasporedDao: TablicaRasporedDao
) {

    fun getAllDataTablicaRaspored() = tablicaRasporedDao.getRasporedData()

    suspend fun addTablicaRaspored(tablicaRaspored: TablicaRaspored) {
        tablicaRasporedDao.insertRaspored(tablicaRaspored)
    }

    suspend fun updateTablicaRaspored(tablicaRaspored: TablicaRaspored) {
        tablicaRasporedDao.updateTablicaRaspored(tablicaRaspored)
    }

    suspend fun deleteTablicaRaspored(tablicaRaspored: TablicaRaspored) {
        tablicaRasporedDao.deleteOneTablicaRaspored(tablicaRaspored)
    }

    suspend fun deleteAllTablicaRaspored() {
        tablicaRasporedDao.deletePodatkeRaspored()
    }

}