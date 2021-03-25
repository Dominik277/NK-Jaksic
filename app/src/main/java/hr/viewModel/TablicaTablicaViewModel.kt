package hr.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import hr.database.NKJaksicDatabase
import hr.database.table.TablicaTablica
import hr.repository.TablicaTablicaRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.launch
import javax.inject.Inject

@InternalCoroutinesApi
@HiltViewModel
class TablicaTablicaViewModel @Inject constructor(
    val repositoryTablicaTablica: TablicaTablicaRepository
) : ViewModel() {

    val readAllDataTablicaTablica = repositoryTablicaTablica.getAllDataTablicaTablica()

    fun addTablicaTablica(tablicatablica: TablicaTablica) {
        viewModelScope.launch(Dispatchers.IO) {
            repositoryTablicaTablica.addTablicaTablica(tablicatablica)
        }
    }

    fun updateTablicaTablica(tablicatablica: TablicaTablica) {
        viewModelScope.launch(Dispatchers.IO) {
            repositoryTablicaTablica.updateTablicaTablica(tablicatablica)
        }
    }

    fun deleteTablicaTablica(tablicatablica: TablicaTablica) {
        viewModelScope.launch(Dispatchers.IO) {
            repositoryTablicaTablica.deleteTablicaTablica(tablicatablica)
        }
    }

    fun deleteAllTablicaTablica() {
        viewModelScope.launch(Dispatchers.IO) {
            repositoryTablicaTablica.deleteAllTablicaTablica()
        }
    }

}