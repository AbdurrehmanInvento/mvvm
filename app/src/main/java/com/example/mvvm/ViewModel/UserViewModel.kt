package com.example.mvvm.ViewModel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm.Model.User
import com.example.mvvm.Repository.UserRepository

class UserViewModel : ViewModel() {

    fun insert(context: Context , user: User) {
        UserRepository.insert(context , user)
    }

    fun getAllUserData (context: Context ) : LiveData<List<User>>? {
        return UserRepository.getAllUserData(context)
    }
}