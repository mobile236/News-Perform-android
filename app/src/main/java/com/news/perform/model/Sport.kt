package com.news.perform.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "sport")
data class Sport(
    @PrimaryKey(autoGenerate = true)
    val sportPrimaryKey: Long,
    val sportVenueId: Long,
    @SerializedName( "_description")
    val description: String,
    @SerializedName( "_sportID")
    val sportId: Long
)