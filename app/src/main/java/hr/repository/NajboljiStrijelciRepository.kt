package hr.repository

import androidx.lifecycle.LiveData
import hr.database.dao.NajboljiStrijelciDao
import hr.database.table.NajboljiStrijelci

class NajboljiStrijelciRepository(private val najboljiStrijelciDao: NajboljiStrijelciDao) {

    val readAllDataNajboljiStrijelci: LiveData<List<NajboljiStrijelci>> = najboljiStrijelciDao.getNajboljiStrijelciData()

    suspend fun addNajboljiStrijelac(najboljiStrijelac: NajboljiStrijelci){
        najboljiStrijelciDao.insertNajboljiStrijelac(najboljiStrijelac)
    }

    suspend fun updateNajboljiStrijelci(najboljiStrijelac: NajboljiStrijelci){
        najboljiStrijelciDao.updateNajboljiStrijelci(najboljiStrijelac)
    }

    suspend fun deleteNajboljiStrijelci(najboljiStrijelac: NajboljiStrijelci){
        najboljiStrijelciDao.deleteNajboljiStrijelac(najboljiStrijelac)
    }

    suspend fun deleteAllNajboljiStrijelci(){
        najboljiStrijelciDao.deleteNajboljiStrijelci()
    }

}