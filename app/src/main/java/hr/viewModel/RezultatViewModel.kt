package hr.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import hr.database.NKJaksicDatabase
import hr.database.table.Rezultat
import hr.repository.RezultatRepository
import hr.repository.TablicaRezultatiRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.launch
import javax.inject.Inject

@InternalCoroutinesApi
@HiltViewModel
class RezultatViewModel @Inject constructor(
    val rezultatiRepository: RezultatRepository
) : ViewModel() {

    val readAllDataRezultati = rezultatiRepository.getAllDataRezultati()

    fun addRezultat(rezultat: Rezultat) {
        viewModelScope.launch(Dispatchers.IO) {
            rezultatiRepository.addRezultat(rezultat)
        }
    }

    fun updateRezultati(rezultat: Rezultat) {
        viewModelScope.launch(Dispatchers.IO) {
            rezultatiRepository.updateRezultat(rezultat)
        }
    }

    fun deleteRezultat(rezultat: Rezultat) {
        viewModelScope.launch(Dispatchers.IO) {
            rezultatiRepository.deleteRezultat(rezultat)
        }
    }

    fun deleteAllRezultati() {
        viewModelScope.launch(Dispatchers.IO) {
            rezultatiRepository.deleteAllRezultat()
        }
    }

}