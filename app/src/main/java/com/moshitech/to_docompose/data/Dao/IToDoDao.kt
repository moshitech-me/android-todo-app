package com.moshitech.to_docompose.data.Dao

import androidx.room.*
import com.moshitech.to_docompose.data.models.ToDoTask
import com.moshitech.to_docompose.util.Constants.DB_TODO_TABLE_TABLE
import kotlinx.coroutines.flow.Flow

@Dao
interface IToDoDao {
    @Query("SELECT * FROM " + DB_TODO_TABLE_TABLE + " ORDER BY id DESC")
    fun getAllTasks(): Flow<List<ToDoTask>>

    @Query("SELECT * FROM " + DB_TODO_TABLE_TABLE + " WHERE id =:taskId")
    fun getSelectedTask(taskId: Int): Flow<ToDoTask>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addTask(toDoTask: ToDoTask)

    @Update
    suspend fun updateTask(toDoTask: ToDoTask)

    @Delete
    suspend fun deleteTask(toDoTask: ToDoTask)


    @Query("DELETE FROM " + DB_TODO_TABLE_TABLE)
    suspend fun deleteAllTasks()

    @Query("SELECT * FROM " + DB_TODO_TABLE_TABLE + " WHERE title LIKE '%' || :searchQuery || '%' OR description LIKE '%' || :searchQuery || '%'")
    fun searchTasks(searchQuery: String): Flow<List<ToDoTask>>

    @Query("SELECT * FROM " + DB_TODO_TABLE_TABLE + " ORDER BY CASE WHEN priority LIKE 'L%' THEN 1 WHEN priority LIKE 'M%' THEN 2 WHEN priority LIKE 'H%' THEN 3 END")
    fun sortByLowPriority(): Flow<List<ToDoTask>>

    @Query("SELECT * FROM " + DB_TODO_TABLE_TABLE + " ORDER BY CASE WHEN priority LIKE 'H%' THEN 1 WHEN priority LIKE 'M%' THEN 2 WHEN priority LIKE 'L%' THEN 3 END")
    fun sortByHighPriority(): Flow<List<ToDoTask>>


}