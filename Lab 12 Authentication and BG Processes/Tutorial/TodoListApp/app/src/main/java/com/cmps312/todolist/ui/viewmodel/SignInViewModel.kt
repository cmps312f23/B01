package com.cmps312.todolist.ui.viewmodel

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.cmps312.todolist.model.User
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SignInViewModel(application: Application) : AndroidViewModel(application) {
    val context = application
    private var auth = FirebaseAuth.getInstance()

    private val _user: MutableStateFlow<User?> = MutableStateFlow(null)
    val user: StateFlow<User?> = _user
    var userRegisteredSuccessfully = MutableStateFlow(false)

    init {
//        Todo initialize the user if the user is already logged in
        if (auth.currentUser != null) {
             val email = auth.currentUser?.email!!
             val displayName = email.split("@")[0]
            _user.value = User(email , displayName)
        }
    }

    fun registerUser(email: String, password: String) = viewModelScope.launch {
//        Todo
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if(task.isSuccessful){
                    userRegisteredSuccessfully.value = true
                    Toast.makeText(context, "Successfully registered", Toast.LENGTH_SHORT).show()
                }else{
                    userRegisteredSuccessfully.value = false
                    Toast.makeText(context, "Not able to register", Toast.LENGTH_SHORT).show()
                }
            }
    }

    fun signIn(email: String, password: String) = viewModelScope.launch {
//        Todo
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener{
                if(it.isSuccessful){
                    val email = auth.currentUser?.email!!
                    val displayName = email.split("@")[0]
                    _user.value = User(email , displayName)
                    Toast.makeText(context, "Successfully signed in", Toast.LENGTH_SHORT).show()
                }

                else _user.value = null
            }
    }
    fun signOut() = viewModelScope.launch {
        auth.signOut()
        _user.value = null
        Toast.makeText(context, "Successfully signed out", Toast.LENGTH_SHORT).show()
    }

    override fun onCleared() {
        super.onCleared()
        signOut()
    }

}