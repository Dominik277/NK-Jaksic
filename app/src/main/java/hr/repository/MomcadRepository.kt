package hr.repository

import androidx.lifecycle.LiveData
import hr.database.dao.IgraciDao
import hr.database.table.Igraci
import javax.inject.Inject

class MomcadRepository @Inject constructor(
    private val momcadDao: IgraciDao
) {

    fun getAllDataMomcad() = momcadDao.getIgraciData()

    suspend fun addMomcad(momcad: Igraci) {
        momcadDao.insertIgrac(momcad)
    }

    suspend fun updateMomcad(igraci: Igraci) {
        momcadDao.updateIgrac(igraci)
    }

    suspend fun deleteMomcad(igraci: Igraci) {
        momcadDao.deleteIgrac(igraci)
    }

    suspend fun deleteAllMomcad() {
        momcadDao.deletePodatke()
    }

}