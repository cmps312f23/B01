package com.cmps312.todolistapp.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.cmps312.todolistapp.entity.Project
import com.cmps312.todolistapp.entity.Todo
import com.cmps312.todolistapp.repository.TodoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class TodolistViewModel(appContext: Application) : AndroidViewModel(appContext) {

    private val todoRepository by lazy { TodoRepository(appContext) }
    var projectsFlow = todoRepository.observeProjects()
    lateinit var todos: Flow<List<Todo>>

    lateinit var selectedProject: Project
    lateinit var selectedTodo: Todo
    var isEditMode = false

    private val _uiStateOfTodo = MutableStateFlow(Todo())
    val uiStateOfTodo: StateFlow<Todo> = _uiStateOfTodo


    fun updateUiStateOfTodo(newState: Todo) {
        _uiStateOfTodo.update {
            it.copy(
                title = newState.title,
                priority = newState.priority,
                date = newState.date,
                time = newState.time,
                pid = newState.pid,
            )
        }
    }

    fun getTodos(project: Project) {
        todos = todoRepository.getTodoListByProject(project.id)
    }

    fun addTodo(todo: Todo) {
        viewModelScope.launch(Dispatchers.IO) {
            todoRepository.upsertTodo(todo)
        }
    }

    fun deleteTodo(todo: Todo) {
        viewModelScope.launch(Dispatchers.IO) {
            todoRepository.deleteTodo(todo)
        }
    }

    fun updateTodo(todo: Todo) = viewModelScope.launch(Dispatchers.IO) {
        todoRepository.upsertTodo(todo)
    }


    fun upsertProject(project: Project) = viewModelScope.launch(Dispatchers.IO) {
        todoRepository.upsertProject(project)
    }

    fun deleteProject(project: Project) = viewModelScope.launch(Dispatchers.IO) {
        todoRepository.deleteProject(project)
    }

}