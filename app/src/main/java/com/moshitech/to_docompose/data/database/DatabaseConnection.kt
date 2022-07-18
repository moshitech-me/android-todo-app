package com.moshitech.to_docompose.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.moshitech.to_docompose.data.Dao.IToDoDao
import com.moshitech.to_docompose.data.models.ToDoTask

@Database(entities = [ToDoTask::class], version = 1, exportSchema = false)
abstract class DatabaseConnection: RoomDatabase() {
    abstract fun todoDao():IToDoDao
}