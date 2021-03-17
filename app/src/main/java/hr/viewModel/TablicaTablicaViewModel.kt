package hr.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import hr.database.NKJaksicDatabase
import hr.database.table.TablicaTablica
import hr.repository.TablicaTablicaRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.launch

@InternalCoroutinesApi
class TablicaTablicaViewModel(application: Application): AndroidViewModel(application) {

    val readAllDataTablicaTablica: LiveData<List<TablicaTablica>>
    private val repositoryTablicaTablica: TablicaTablicaRepository

    init {
        val tablicaTablicaDao = NKJaksicDatabase.getDatabase(application).tablicaDao()
        repositoryTablicaTablica = TablicaTablicaRepository(tablicaTablicaDao)
        readAllDataTablicaTablica = repositoryTablicaTablica.readAllDataTablicaTablica
    }

    fun addTablicaTablica(tablicatablica: TablicaTablica){
        viewModelScope.launch (Dispatchers.IO){
            repositoryTablicaTablica.addTablicaTablica(tablicatablica)
        }
    }

    fun updateTablicaTablica(tablicatablica: TablicaTablica){
        viewModelScope.launch(Dispatchers.IO) {
            repositoryTablicaTablica.updateTablicaTablica(tablicatablica)
        }
    }

    fun deleteTablicaTablica(tablicatablica: TablicaTablica){
        viewModelScope.launch(Dispatchers.IO) {
            repositoryTablicaTablica.deleteTablicaTablica(tablicatablica)
        }
    }

    fun deleteAllTablicaTablica(){
        viewModelScope.launch(Dispatchers.IO) {
            repositoryTablicaTablica.deleteAllTablicaTablica()
        }
    }

}