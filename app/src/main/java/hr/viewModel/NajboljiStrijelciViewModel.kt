package hr.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import hr.database.NKJaksicDatabase
import hr.database.table.NajboljiStrijelci
import hr.repository.NajboljiStrijelciRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.launch
import javax.inject.Inject

@InternalCoroutinesApi
@HiltViewModel
class NajboljiStrijelciViewModel @Inject constructor(
    val najboljiStrijelciRepository: NajboljiStrijelciRepository
): ViewModel() {

    val readAllDataNajboljiStrijelci =  najboljiStrijelciRepository.getAllDataNajboljiStrijelci()

    fun addNajboljiStrijelac(najboljiStrijelac: NajboljiStrijelci){
        viewModelScope.launch (Dispatchers.IO){
            najboljiStrijelciRepository.addNajboljiStrijelac(najboljiStrijelac)
        }
    }

    fun updateNajboljiStrijalci(najboljiStrijelac: NajboljiStrijelci){
        viewModelScope.launch(Dispatchers.IO) {
            najboljiStrijelciRepository.updateNajboljiStrijelci(najboljiStrijelac)
        }
    }

    fun deleteNajboljiStrijelci(najboljiStrijelac: NajboljiStrijelci){
        viewModelScope.launch(Dispatchers.IO) {
            najboljiStrijelciRepository.deleteNajboljiStrijelci(najboljiStrijelac)
        }
    }

    fun deleteAllNajboljiStrijelaci(){
        viewModelScope.launch(Dispatchers.IO) {
            najboljiStrijelciRepository.deleteAllNajboljiStrijelci()
        }
    }

}