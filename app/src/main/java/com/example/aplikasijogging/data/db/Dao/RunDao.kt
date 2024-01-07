package com.example.aplikasijogging.data.db.Dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.aplikasijogging.model.Run
import kotlinx.coroutines.flow.Flow
import java.util.Date

interface RunDao {

    @Dao
    interface RunDao {

        @Insert(onConflict = OnConflictStrategy.REPLACE)
        suspend fun insertRun(run: Run)

        @Delete
        suspend fun deleteRun(run: Run)

        @Query("SELECT * FROM running_tbl ORDER BY timestamp DESC")
        fun getAllRunSortByDate(): PagingSource<Int, Run>

        @Query("SELECT * FROM running_tbl ORDER BY durablesMillis DESC")
        fun getAllRunSortByDurables(): PagingSource<Int, Run>

        @Query("SELECT * FROM running_tbl ORDER BY caloricBurn DESC")
        fun getAllRunSortByCaloricBurn(): PagingSource<Int, Run>

        @Query("SELECT * FROM running_tbl ORDER BY acceptanceKMH DESC")
        fun getAllRunSortByAcceptance(): PagingSource<Int, Run>

        @Query("SELECT * FROM running_tbl ORDER BY jarMeters DESC")
        fun getAllRunSortByJar(): PagingSource<Int, Run>

        @Query("SELECT * FROM running_tbl ORDER BY timestamp DESC LIMIT :limit")
        fun getRunByDescDateWithLimit(limit: Int): Flow<List<Run>>


        //Statistik
        @Query(
            "SELECT TOTAL(durablesMillis) FROM running_tbl WHERE " +
                    "(:fromDate IS NULL OR timestamp >= :fromDate) AND " +
                    "(:toDate IS NULL OR timestamp <= :toDate) " +
                    "ORDER BY timestamp DESC"
        )
        fun getTotalRunningDurables(fromDate: Date?, toDate: Date?): Flow<Long>

        @Query(
            "SELECT TOTAL(caloricBurn) FROM running_tbl WHERE " +
                    "(:fromDate IS NULL OR timestamp >= :fromDate) AND " +
                    "(:toDate IS NULL OR timestamp <= :toDate) " +
                    "ORDER BY timestamp DESC"
        )
        fun getTotalCaloricBurn(fromDate: Date?, toDate: Date?): Flow<Long>

        @Query(
            "SELECT TOTAL(jarMeters) FROM running_tbl WHERE " +
                    "(:fromDate IS NULL OR timestamp >= :fromDate) AND " +
                    "(:toDate IS NULL OR timestamp <= :toDate) " +
                    "ORDER BY timestamp DESC"
        )
        fun getTotalJar(fromDate: Date?, toDate: Date?): Flow<Long>

        @Query(
            "SELECT AVG(acceptanceKMH) FROM running_tbl WHERE " +
                    "(:fromDate IS NULL OR timestamp >= :fromDate) AND " +
                    "(:toDate IS NULL OR timestamp <= :toDate) " +
                    "ORDER BY timestamp DESC"
        )
        fun getTotalAcceptance(fromDate: Date?, toDate: Date?): Flow<Float>

    }
}