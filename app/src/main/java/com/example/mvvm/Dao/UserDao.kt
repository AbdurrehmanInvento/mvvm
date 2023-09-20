package com.example.mvvm.Dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mvvm.Model.User
import kotlinx.coroutines.selects.select

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: User)

    @Query("SELECT * FROM user ORDER BY id ASC")
    fun getAllUserData() : LiveData<List<User>>


}