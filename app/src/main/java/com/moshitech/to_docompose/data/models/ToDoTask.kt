package com.moshitech.to_docompose.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.moshitech.to_docompose.util.Constants.DB_TODO_TABLE_TABLE

@Entity(tableName = DB_TODO_TABLE_TABLE)
data class ToDoTask(
    @PrimaryKey(autoGenerate = true)
    val id: Int=0,
    val title: String,
    val description:String,
    val priority: Priority
)