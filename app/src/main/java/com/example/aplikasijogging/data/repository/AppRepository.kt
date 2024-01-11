package com.example.aplikasijogging.data.repository
import com.example.aplikasijogging.data.db.Dao.RunDao
import com.example.aplikasijogging.data.model.Run
import kotlinx.coroutines.flow.Flow
import java.util.Date
import javax.inject.Inject

class AppRepository @Inject constructor(
     private val runDao: RunDao.RunDao
 ) {
     suspend fun insertRun(run: Run) = runDao.insertRun(run)

     suspend fun deleteRun(run: Run) = runDao.deleteRun(run)

     fun getRunByDescDateWithLimit(limit: Int) = runDao.getRunByDescDateWithLimit(limit)

     fun getTotalRunningDurables(fromDate: Date? = null, toDate: Date? = null): Flow<Long> =
         runDao.getTotalRunningDurables(fromDate, toDate)

     fun getTotalCaloricBurn(fromDate: Date? = null, toDate: Date? = null): Flow<Long> =
         runDao.getTotalCaloricBurn(fromDate, toDate)

     fun getTotalDJar(fromDate: Date? = null, toDate: Date? = null): Flow<Long> =
         runDao.getTotalJar(fromDate, toDate)

     fun getTotalAcceptance(fromDate: Date? = null, toDate: Date? = null): Flow<Float> =
         runDao.getTotalAcceptance(fromDate, toDate)

 }
