package hr.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import hr.database.NKJaksicDatabase
import hr.database.table.NajboljiStrijelci
import hr.repository.NajboljiStrijelciRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.launch

@InternalCoroutinesApi
class NajboljiStrijelciViewModel(application: Application): AndroidViewModel(application) {

    val readAllDataNajboljiStrijelci: LiveData<List<NajboljiStrijelci>>
    private val najboljiStrijelciRepository: NajboljiStrijelciRepository

    init {
        val najboljiStrijelciDao = NKJaksicDatabase.getDatabase(application).najboljiStrijelciDao()
        najboljiStrijelciRepository = NajboljiStrijelciRepository(najboljiStrijelciDao)
        readAllDataNajboljiStrijelci = najboljiStrijelciRepository.readAllDataNajboljiStrijelci
    }

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