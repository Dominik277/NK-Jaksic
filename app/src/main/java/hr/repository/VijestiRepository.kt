package hr.repository

import androidx.lifecycle.LiveData
import hr.database.dao.VijestiDao
import hr.database.table.Vijesti
import javax.inject.Inject

class VijestiRepository @Inject constructor(
    private val vijestiDao: VijestiDao
) {

    fun getAllDataVijesti() = vijestiDao.getVijestiData()

    suspend fun addVijest(vijesti: Vijesti) {
        vijestiDao.insertVijest(vijesti)
    }

    suspend fun updateVijest(vijesti: Vijesti) {
        vijestiDao.updateVijesti(vijesti)
    }

    suspend fun deleteVijest(vijesti: Vijesti) {
        vijestiDao.deleteVijesti(vijesti)
    }

    suspend fun deleteAllVijesti() {
        vijestiDao.deletePodatkeVijesti()
    }

}