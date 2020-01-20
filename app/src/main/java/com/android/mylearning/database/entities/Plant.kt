package com.android.mylearning.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "plants")
class Plant(
    @PrimaryKey @ColumnInfo(name = "id") val plantId : String,
    @ColumnInfo(name = "name")val name : String,
    @ColumnInfo(name="description")val description : String,
    @ColumnInfo(name ="imageUrl")val imageUrl : String
)