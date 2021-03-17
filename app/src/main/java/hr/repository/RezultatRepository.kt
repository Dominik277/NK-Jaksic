package hr.repository

import androidx.lifecycle.LiveData
import hr.database.dao.RezultatDao
import hr.database.table.Rezultat

class RezultatRepository(private val rezultatiDao: RezultatDao) {

    val readAllDataRezultat: LiveData<List<Rezultat>> = rezultatiDao.getRezultatData()

    suspend fun addRezultat(rezultat: Rezultat){
        rezultatiDao.insertRezultat(rezultat)
    }

    suspend fun updateRezultat(rezultat: Rezultat){
        rezultatiDao.updateRezultat(rezultat)
    }

    suspend fun deleteRezultat(rezultat: Rezultat){
        rezultatiDao.deleteOneRezultat(rezultat)
    }

    suspend fun deleteAllRezultat(){
        rezultatiDao.deletePodatkeRezultat()
    }

}