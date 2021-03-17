package hr.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import hr.database.NKJaksicDatabase
import hr.database.table.Rezultat
import hr.repository.RezultatRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.launch

@InternalCoroutinesApi
class RezultatViewModel(application: Application): AndroidViewModel(application) {

    val readAllDataRezultat: LiveData<List<Rezultat>>
    private val repositoryRezultat: RezultatRepository

    init {
        val rezultatiDao = NKJaksicDatabase.getDatabase(application).rezultatiDao()
        repositoryRezultat = RezultatRepository(rezultatiDao)
        readAllDataRezultat = repositoryRezultat.readAllDataRezultat
    }

    fun addRezultat(rezultat: Rezultat){
        viewModelScope.launch (Dispatchers.IO){
            repositoryRezultat.addRezultat(rezultat)
        }
    }

    fun updateRezultati(rezultat: Rezultat){
        viewModelScope.launch(Dispatchers.IO) {
            repositoryRezultat.updateRezultat(rezultat)
        }
    }

    fun deleteRezultat(rezultat: Rezultat){
        viewModelScope.launch(Dispatchers.IO) {
            repositoryRezultat.deleteRezultat(rezultat)
        }
    }

    fun deleteAllRezultati(){
        viewModelScope.launch (Dispatchers.IO){
            repositoryRezultat.deleteAllRezultat()
        }
    }

}