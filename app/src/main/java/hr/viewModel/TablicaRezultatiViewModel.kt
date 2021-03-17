package hr.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import hr.database.NKJaksicDatabase
import hr.database.table.TablicaRezultati
import hr.repository.TablicaRezultatiRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.launch

@InternalCoroutinesApi
class TablicaRezultatiViewModel(application: Application): AndroidViewModel(application) {

    val readAllDataTablicaRezultat: LiveData<List<TablicaRezultati>>
    private val tablicaRezultatRepository: TablicaRezultatiRepository

    init {
        val tablicaRezultatDao = NKJaksicDatabase.getDatabase(application).tablicaRezultatiDao()
        tablicaRezultatRepository = TablicaRezultatiRepository(tablicaRezultatDao)
        readAllDataTablicaRezultat = tablicaRezultatRepository.readAllDataTablicaRezultat
    }

    fun addTablicaRezultat(tablicaRezultat: TablicaRezultati){
        viewModelScope.launch (Dispatchers.IO){
            tablicaRezultatRepository.addTablicaRezultat(tablicaRezultat)
        }
    }

    fun updateTablicaRezultat(tablicaRezultat: TablicaRezultati){
        viewModelScope.launch(Dispatchers.IO) {
            tablicaRezultatRepository.updateTablicaRezultat(tablicaRezultat)
        }
    }

    fun deleteTablicaRezultat(tablicaRezultat: TablicaRezultati){
        viewModelScope.launch(Dispatchers.IO) {
            tablicaRezultatRepository.deleteTablicaRezultat(tablicaRezultat)
        }
    }

    fun deleteAllTablicaRezultat(){
        viewModelScope.launch(Dispatchers.IO) {
            tablicaRezultatRepository.deleteAllTablicaRezultat()
        }
    }

}