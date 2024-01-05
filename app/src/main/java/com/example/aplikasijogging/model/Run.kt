package com.example.aplikasijogging.model

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date


@Entity(tableName = "running_tbl")
data class Run(
    var img: Bitmap,
    var timestamp: Date = Date(),
    var kecepatanKMH: Float = 0f,
    var jarakMeters: Int = 0,
    var durasiMillis: Long = 0L,
    var kaloriBurn: Int = 0,

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)