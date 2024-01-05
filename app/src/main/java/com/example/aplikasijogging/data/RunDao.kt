package com.example.aplikasijogging.data

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

        @Query("SELECT * FROM running_tbl ORDER BY durasiMillis DESC")

        @Query("SELECT * FROM running_tbl ORDER BY kaloriBurn DESC")

        @Query("SELECT * FROM running_tbl ORDER BY kecepatanKMH DESC")

        @Query("SELECT * FROM running_tbl ORDER BY jarakMeters DESC")

        @Query("SELECT * FROM running_tbl ORDER BY timestamp DESC")




    }
}