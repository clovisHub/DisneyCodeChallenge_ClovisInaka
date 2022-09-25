package com.clovis.dataprovider.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//import androidx.room.ColumnInfo
//import androidx.room.Entity
//import androidx.room.PrimaryKey

/**
 * We are not using room so we don't need this
 */
@Entity(tableName = "Populations")
data class PopulationType(
    @ColumnInfo(name = "name") val name: String = "No Name",
    @ColumnInfo(name = "contentType") val contentType: PopulationContentType,
    @ColumnInfo(name = "sectionNumber") val sectionNumber: Int,
    @ColumnInfo(name = "isCheck") var isCheck: Boolean = false,
    @PrimaryKey(autoGenerate = false) val id: Int? = null,
)

//data class PopulationType(
//     val name: String = "No Name",
//     val contentType: PopulationContentType,
//     val sectionNumber: Int,
//     var isCheck: Boolean = false,
//     val id: Int? = null,
//)

enum class PopulationContentType{ PERSON, SECTION, FOOTER }