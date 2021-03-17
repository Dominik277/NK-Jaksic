package hr.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import hr.database.NKJaksicDatabase
import hr.database.table.TablicaRaspored
import hr.repository.TablicaRasporedRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.launch

@InternalCoroutinesApi
class TablicaRasporedViewModel(application: Application): AndroidViewModel(application) {

    val readAllDataTablicaRaspored: LiveData<List<TablicaRaspored>>
    private val tablicaRasporedRepository: TablicaRasporedRepository

    init {
        val tablicaRasporedDao = NKJaksicDatabase.getDatabase(application).tablicaRasporedDao()
        tablicaRasporedRepository = TablicaRasporedRepository(tablicaRasporedDao)
        readAllDataTablicaRaspored = tablicaRasporedRepository.readAllDataTablicaRaspored
    }

    fun addTablicaRaspored(tablicaRaspored: TablicaRaspored){
        viewModelScope.launch (Dispatchers.IO){
            tablicaRasporedRepository.addTablicaRaspored(tablicaRaspored)
        }
    }

    fun updateTablicaRaspored(tablicaRaspored: TablicaRaspored){
        viewModelScope.launch(Dispatchers.IO) {
            tablicaRasporedRepository.updateTablicaRaspored(tablicaRaspored)
        }
    }

    fun deleteTablicaRaspored(tablicaRaspored: TablicaRaspored){
        viewModelScope.launch(Dispatchers.IO) {
            tablicaRasporedRepository.deleteTablicaRaspored(tablicaRaspored)
        }
    }

    fun deleteAllTablicaRaspored(){
        viewModelScope.launch(Dispatchers.IO) {
            tablicaRasporedRepository.deleteAllTablicaRaspored()
        }
    }

}