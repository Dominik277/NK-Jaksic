package hr.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import hr.database.NKJaksicDatabase
import hr.database.table.TablicaRaspored
import hr.repository.TablicaRasporedRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.launch
import javax.inject.Inject

@InternalCoroutinesApi
@HiltViewModel
class TablicaRasporedViewModel @Inject constructor(
    val tablicaRasporedRepository: TablicaRasporedRepository
) : ViewModel() {

    val readAllDataTablicaRaspored = tablicaRasporedRepository.getAllDataTablicaRaspored()

    fun addTablicaRaspored(tablicaRaspored: TablicaRaspored) {
        viewModelScope.launch(Dispatchers.IO) {
            tablicaRasporedRepository.addTablicaRaspored(tablicaRaspored)
        }
    }

    fun updateTablicaRaspored(tablicaRaspored: TablicaRaspored) {
        viewModelScope.launch(Dispatchers.IO) {
            tablicaRasporedRepository.updateTablicaRaspored(tablicaRaspored)
        }
    }

    fun deleteTablicaRaspored(tablicaRaspored: TablicaRaspored) {
        viewModelScope.launch(Dispatchers.IO) {
            tablicaRasporedRepository.deleteTablicaRaspored(tablicaRaspored)
        }
    }

    fun deleteAllTablicaRaspored() {
        viewModelScope.launch(Dispatchers.IO) {
            tablicaRasporedRepository.deleteAllTablicaRaspored()
        }
    }

}