package hr.repository

import androidx.lifecycle.LiveData
import hr.database.dao.TablicaTablicaDao
import hr.database.table.TablicaTablica

class TablicaTablicaRepository(private val tablicaTablicaDao: TablicaTablicaDao) {

    val readAllDataTablicaTablica: LiveData<List<TablicaTablica>> = tablicaTablicaDao.getTablicaTablica()

    suspend fun addTablicaTablica(tablicaTablica: TablicaTablica){
        tablicaTablicaDao.insertTablicaTablica(tablicaTablica)
    }

    suspend fun updateTablicaTablica(tablicaTablica: TablicaTablica){
        tablicaTablicaDao.updateTablicaTablica(tablicaTablica)
    }

    suspend fun deleteTablicaTablica(tablicaTablica: TablicaTablica){
        tablicaTablicaDao.deleteOneTablicaTablica(tablicaTablica)
    }

    suspend fun deleteAllTablicaTablica(){
        tablicaTablicaDao.deleteTablicaTablica()
    }

}