package com.example.aplikasijogging.data.db.Dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.aplikasijogging.data.model.Run
import kotlinx.coroutines.flow.Flow
import java.util.Date

@Dao
interface RunDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRun(run: Run)

    @Delete
    suspend fun deleteRun(run: Run)

    @Query("SELECT * FROM running_tbl ORDER BY timestamp DESC")
    fun getAllRunSortByDate(): PagingSource<Int, Run>

    @Query("SELECT * FROM running_tbl ORDER BY durationInMillis DESC")
    fun getAllRunSortByDuration(): PagingSource<Int, Run>

    @Query("SELECT * FROM running_tbl ORDER BY caloriesBurned DESC")
    fun getAllRunSortByCaloriesBurned(): PagingSource<Int, Run>

    @Query("SELECT * FROM running_tbl ORDER BY avgSpeedInKMH DESC")
    fun getAllRunSortByAvgSpeed(): PagingSource<Int, Run>

    @Query("SELECT * FROM running_tbl ORDER BY distanceInMeters DESC")
    fun getAllRunSortByDistance(): PagingSource<Int, Run>

    @Query("SELECT * FROM running_tbl ORDER BY timestamp DESC LIMIT :limit")
    fun getRunByDescDateWithLimit(limit: Int): Flow<List<Run>>


    //for statistics
    @Query(
        "SELECT TOTAL(durationInMillis) FROM running_tbl WHERE " +
                "(:fromDate IS NULL OR timestamp >= :fromDate) AND " +
                "(:toDate IS NULL OR timestamp <= :toDate) " +
                "ORDER BY timestamp DESC"
    )
    fun getTotalRunningDuration(fromDate: Date?, toDate: Date?): Flow<Long>

    @Query(
        "SELECT TOTAL(caloriesBurned) FROM running_tbl WHERE " +
                "(:fromDate IS NULL OR timestamp >= :fromDate) AND " +
                "(:toDate IS NULL OR timestamp <= :toDate) " +
                "ORDER BY timestamp DESC"
    )
    fun getTotalCaloriesBurned(fromDate: Date?, toDate: Date?): Flow<Long>

    @Query(
        "SELECT TOTAL(distanceInMeters) FROM running_tbl WHERE " +
                "(:fromDate IS NULL OR timestamp >= :fromDate) AND " +
                "(:toDate IS NULL OR timestamp <= :toDate) " +
                "ORDER BY timestamp DESC"
    )
    fun getTotalDistance(fromDate: Date?, toDate: Date?): Flow<Long>

    @Query(
        "SELECT AVG(avgSpeedInKMH) FROM running_tbl WHERE " +
                "(:fromDate IS NULL OR timestamp >= :fromDate) AND " +
                "(:toDate IS NULL OR timestamp <= :toDate) " +
                "ORDER BY timestamp DESC"
    )
    fun getTotalAvgSpeed(fromDate: Date?, toDate: Date?): Flow<Float>

}