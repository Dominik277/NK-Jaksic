package hr.repository

import androidx.lifecycle.LiveData
import hr.database.dao.TablicaTablicaDao
import hr.database.table.TablicaTablica
import javax.inject.Inject

class TablicaTablicaRepository @Inject constructor(
    private val tablicaTablicaDao: TablicaTablicaDao
) {

    fun getAllDataTablicaTablica() = tablicaTablicaDao.getTablicaTablica()

    suspend fun addTablicaTablica(tablicaTablica: TablicaTablica) {
        tablicaTablicaDao.insertTablicaTablica(tablicaTablica)
    }

    suspend fun updateTablicaTablica(tablicaTablica: TablicaTablica) {
        tablicaTablicaDao.updateTablicaTablica(tablicaTablica)
    }

    suspend fun deleteTablicaTablica(tablicaTablica: TablicaTablica) {
        tablicaTablicaDao.deleteOneTablicaTablica(tablicaTablica)
    }

    suspend fun deleteAllTablicaTablica() {
        tablicaTablicaDao.deleteTablicaTablica()
    }

}