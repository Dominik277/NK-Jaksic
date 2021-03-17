package hr.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import hr.database.NKJaksicDatabase
import hr.database.table.Igraci
import hr.repository.MomcadRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.launch

@InternalCoroutinesApi
class MomcadViewModel(application: Application): AndroidViewModel(application) {

    val readAllDataMomcad: LiveData<List<Igraci>>
    private val momcadRepository: MomcadRepository

    init {
        val momcadDao = NKJaksicDatabase.getDatabase(application).igraciDao()
        momcadRepository = MomcadRepository(momcadDao)
        readAllDataMomcad = momcadRepository.readAllDataMomcad
    }

    fun addMomcad(momcad: Igraci){
        viewModelScope.launch (Dispatchers.IO){
            momcadRepository.addMomcad(momcad)
        }
    }

    fun updateMomcad(momcad: Igraci){
        viewModelScope.launch(Dispatchers.IO) {
            momcadRepository.updateMomcad(momcad)
        }
    }

    fun deleteMomcad(momcad: Igraci){
        viewModelScope.launch(Dispatchers.IO) {
            momcadRepository.deleteMomcad(momcad)
        }
    }

    fun deleteAllMomcad(){
        viewModelScope.launch(Dispatchers.IO) {
            momcadRepository.deleteAllMomcad()
        }
    }

}