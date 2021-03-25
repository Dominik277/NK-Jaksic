package hr.repository

import androidx.lifecycle.LiveData
import hr.database.dao.TablicaRezultatiDao
import hr.database.table.TablicaRezultati
import javax.inject.Inject

class TablicaRezultatiRepository @Inject constructor(
    private val tablicaRezultatDao: TablicaRezultatiDao
) {

    fun getAllDataTablicaRezultati() = tablicaRezultatDao.getNoviRezultatiData()

    suspend fun addTablicaRezultat(tablicaRezulatat: TablicaRezultati) {
        tablicaRezultatDao.insertNoviRezultati(tablicaRezulatat)
    }

    suspend fun updateTablicaRezultat(tablicaRezulatat: TablicaRezultati) {
        tablicaRezultatDao.updateTablicaRezultat(tablicaRezulatat)
    }

    suspend fun deleteTablicaRezultat(tablicaRezulatat: TablicaRezultati) {
        tablicaRezultatDao.deleteOneTablicaRezultati(tablicaRezulatat)
    }

    suspend fun deleteAllTablicaRezultat() {
        tablicaRezultatDao.deleteNoviRezultati()
    }

}