package hr.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import hr.database.NKJaksicDatabase
import hr.database.table.Raspored
import hr.repository.RasporedRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.launch

@InternalCoroutinesApi
class RasporedViewModel(application: Application): AndroidViewModel(application) {

    val readAllData: LiveData<List<Raspored>>
    private val repository: RasporedRepository

    init {
        val rasporedDao = NKJaksicDatabase.getDatabase(application).rasporedDao()
        repository = RasporedRepository(rasporedDao)
        readAllData = repository.readAllData
    }

    fun addRaspored(raspored: Raspored){
        viewModelScope.launch ( Dispatchers.IO) {
            repository.addRaspored(raspored)
        }
    }

    fun updateRaspored(raspored: Raspored){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateRaspored(raspored)
        }
    }

    fun deleteRaspored(raspored: Raspored){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteRaspored(raspored)
        }
    }

    fun deleteAllRaspored(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllRaspored()
        }
    }

}