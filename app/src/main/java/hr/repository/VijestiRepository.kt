package hr.repository

import androidx.lifecycle.LiveData
import hr.database.dao.VijestiDao
import hr.database.table.Vijesti

class VijestiRepository(private val vijestiDao: VijestiDao) {

    val readAllDataVijesti: LiveData<List<Vijesti>> = vijestiDao.getVijestiData()

    suspend fun addVijest(vijesti: Vijesti){
        vijestiDao.insertVijest(vijesti)
    }

    suspend fun updateVijest(vijesti: Vijesti){
        vijestiDao.updateVijesti(vijesti)
    }

    suspend fun deleteVijest(vijesti: Vijesti){
        vijestiDao.deleteVijesti(vijesti)
    }

    suspend fun deleteAllVijesti(){
        vijestiDao.deletePodatkeVijesti()
    }

}