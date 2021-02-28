package hr.repository

import androidx.lifecycle.LiveData
import hr.database.dao.IgraciDao
import hr.database.table.Igraci

class MomcadRepository(private val momcadDao: IgraciDao) {

    val readAllDataMomcad: LiveData<List<Igraci>> = momcadDao.getIgraciData()

    suspend fun addMomcad(momcad: Igraci){
        momcadDao.insertIgrac(momcad)
    }

}