package hr.repository

import androidx.lifecycle.LiveData
import hr.database.dao.TablicaRezultatiDao
import hr.database.table.TablicaRezultati

class TablicaRezultatiRepository(private val tablicaRezultatDao: TablicaRezultatiDao) {

    val readAllDataTablicaRezultat: LiveData<List<TablicaRezultati>> = tablicaRezultatDao.getNoviRezultatiData()

    suspend fun addTablicaRezultat(tablicaRezulatat: TablicaRezultati){
        tablicaRezultatDao.insertNoviRezultati(tablicaRezulatat)
    }

}