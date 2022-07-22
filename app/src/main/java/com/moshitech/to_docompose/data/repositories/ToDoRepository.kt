package com.moshitech.to_docompose.data.repositories

import com.moshitech.to_docompose.data.Dao.IToDoDao
import com.moshitech.to_docompose.data.models.ToDoTask
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ViewModelScoped
class ToDoRepository @Inject constructor(private val todoDao: IToDoDao) {

    val getAllTasks: Flow<List<ToDoTask>> = todoDao.getAllTasks()
    val sortByLowPriority: Flow<List<ToDoTask>> = todoDao.sortByLowPriority()
    val sortByHighPriority: Flow<List<ToDoTask>> = todoDao.sortByHighPriority()

    fun getSelectedTask(taskId:Int):Flow<ToDoTask>{
        return todoDao.getSelectedTask(taskId=taskId)
    }

    suspend fun addTask(toDoTask: ToDoTask){
        todoDao.addTask(toDoTask = toDoTask)
    }

    suspend fun updateTask(toDoTask: ToDoTask){
        todoDao.updateTask(toDoTask = toDoTask)
    }
    suspend fun deleteTask(toDoTask: ToDoTask){
        todoDao.deleteTask(toDoTask = toDoTask)
    }

    suspend fun deleteAllTasks(){
        todoDao.deleteAllTasks()
    }

    fun searchDatabase(searchQuery:String): Flow<List<ToDoTask>>{
        return todoDao.searchTasks(searchQuery = searchQuery)
    }
}