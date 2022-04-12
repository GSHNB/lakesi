package com.nsxz.lakesi.vm

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nsxz.lakesi.db.AppDatabase
import com.nsxz.lakesi.db.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class UserViewModel(app:Application): BaseViewModel(app) {
    fun insert(uid:String,firstName:String,lastName:String){
        viewModelScope.launch {
            AppDatabase.getInstance(getApplication())
                .userDao().insert(User(uid = uid.toInt(),firstName,lastName))
        }
    }

    fun getAll():Flow<List<User>>{
        return AppDatabase.getInstance(getApplication())
            .userDao().getAll().catch {
                it.printStackTrace()
            }.flowOn(Dispatchers.IO)
    }


}