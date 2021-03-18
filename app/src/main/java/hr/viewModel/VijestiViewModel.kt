package hr.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import hr.database.NKJaksicDatabase
import hr.database.table.Vijesti
import hr.repository.VijestiRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.launch

@InternalCoroutinesApi
class VijestiViewModel(application: Application): AndroidViewModel(application) {

    val readAllDataVijesti: LiveData<List<Vijesti>>
    private val vijestiRepository: VijestiRepository

    init {
        val vijestiDao = NKJaksicDatabase.getDatabase(application).vijestiDao()
        vijestiRepository = VijestiRepository(vijestiDao)
        readAllDataVijesti = vijestiRepository.readAllDataVijesti
    }

    fun addVijesti(vijesti: Vijesti){
        viewModelScope.launch(Dispatchers.IO){
            vijestiRepository.addVijest(vijesti)
        }
    }

    fun updateVijesti(vijesti: Vijesti){
        viewModelScope.launch(Dispatchers.IO) {
            vijestiRepository.updateVijest(vijesti)
        }
    }

    fun deleteVijesti(vijesti: Vijesti){
        viewModelScope.launch(Dispatchers.IO) {
            vijestiRepository.deleteVijest(vijesti)
        }
    }

    fun deleteAllVijesti(){
        viewModelScope.launch(Dispatchers.IO) {
            vijestiRepository.deleteAllVijesti()
        }
    }

}