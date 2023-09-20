package com.example.mvvm.Repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.mvvm.Database.UserDatabase
import com.example.mvvm.Model.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.IO_PARALLELISM_PROPERTY_NAME
import kotlinx.coroutines.launch

class UserRepository {

    companion object {

        private var userDatabase : UserDatabase ? = null

        fun initilizeDB (context : Context) : UserDatabase? {
            return UserDatabase.getInstance(context)
        }

        fun insert(context : Context , user: User) {
            userDatabase = initilizeDB(context)
            CoroutineScope(IO).launch {
                userDatabase?.getDao()?.insert(user)
            }
        }
        fun getAllUserData(context: Context): LiveData<List<User>>? {
            userDatabase = initilizeDB(context)
            return userDatabase?.getDao()?.getAllUserData()
        }

    }
}