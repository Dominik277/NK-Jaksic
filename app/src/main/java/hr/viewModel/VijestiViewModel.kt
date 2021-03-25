package hr.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import hr.database.NKJaksicDatabase
import hr.database.table.Vijesti
import hr.repository.VijestiRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.launch
import javax.inject.Inject

@InternalCoroutinesApi
@HiltViewModel
class VijestiViewModel @Inject constructor(
    val vijestiRepository: VijestiRepository
) : ViewModel() {

    val readAllDataVijesti = vijestiRepository.getAllDataVijesti()

    fun addVijesti(vijesti: Vijesti) {
        viewModelScope.launch(Dispatchers.IO) {
            vijestiRepository.addVijest(vijesti)
        }
    }

    fun updateVijesti(vijesti: Vijesti) {
        viewModelScope.launch(Dispatchers.IO) {
            vijestiRepository.updateVijest(vijesti)
        }
    }

    fun deleteVijesti(vijesti: Vijesti) {
        viewModelScope.launch(Dispatchers.IO) {
            vijestiRepository.deleteVijest(vijesti)
        }
    }

    fun deleteAllVijesti() {
        viewModelScope.launch(Dispatchers.IO) {
            vijestiRepository.deleteAllVijesti()
        }
    }

}