package com.example.aplikasijogging.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.aplikasijogging.data.db.Dao.RunDao
import com.example.aplikasijogging.model.Run

@Database(
    entities = [Run::class],
    version = 1,
)


abstract class RunDatabase : RoomDatabase() {
    companion object {
        const val RUN_DB_NAME = "run_db"
    }

    abstract fun getRunDao(): RunDao

}
