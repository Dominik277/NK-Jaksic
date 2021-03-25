package hr.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import hr.database.NKJaksicDatabase
import hr.database.table.Igraci
import hr.repository.MomcadRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.launch
import javax.inject.Inject

@InternalCoroutinesApi
@HiltViewModel
class MomcadViewModel @Inject constructor(
    val momcadRepository: MomcadRepository
): ViewModel() {

    val readAllDataMomcad = momcadRepository.getAllDataMomcad()

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