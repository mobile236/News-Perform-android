package com.news.perform.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "country")
data class Country(
    @PrimaryKey(autoGenerate = true)
    val countryPrimaryKey: Long,
    val countryVenueId: Long,
    @SerializedName("_countryID")
    val countryId: Long,
    @SerializedName("_name")
    val countryName: String
)