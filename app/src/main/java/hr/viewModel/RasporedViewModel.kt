package hr.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import hr.database.NKJaksicDatabase
import hr.database.table.Raspored
import hr.repository.RasporedRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.launch
import javax.inject.Inject

@InternalCoroutinesApi
@HiltViewModel
class RasporedViewModel @Inject constructor(
    val rasporedRepository: RasporedRepository
): ViewModel() {

    val readAllDataRaspored = rasporedRepository.getAllDataRaspored()

    fun addRaspored(raspored: Raspored){
        viewModelScope.launch ( Dispatchers.IO) {
            rasporedRepository.addRaspored(raspored)
        }
    }

    fun updateRaspored(raspored: Raspored){
        viewModelScope.launch(Dispatchers.IO) {
            rasporedRepository.updateRaspored(raspored)
        }
    }

    fun deleteRaspored(raspored: Raspored){
        viewModelScope.launch(Dispatchers.IO) {
            rasporedRepository.deleteRaspored(raspored)
        }
    }

    fun deleteAllRaspored(){
        viewModelScope.launch(Dispatchers.IO) {
            rasporedRepository.deleteAllRaspored()
        }
    }

}