package hr.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import hr.database.NKJaksicDatabase
import hr.database.table.TablicaRezultati
import hr.repository.TablicaRezultatiRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.launch
import javax.inject.Inject

@InternalCoroutinesApi
@HiltViewModel
class TablicaRezultatiViewModel @Inject constructor(
    val tablicaRezultatRepository: TablicaRezultatiRepository
): ViewModel() {

    val readAllDataTablicaRezultati = tablicaRezultatRepository.getAllDataTablicaRezultati()

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