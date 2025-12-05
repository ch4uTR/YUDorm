package com.yudorm.app.ui.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.yudorm.app.data.FakeDatabase
import com.yudorm.app.data.models.Student


class LoginViewModel : ViewModel() {

    var studentNo by mutableStateOf("")
    var password by mutableStateOf("")
    var message by mutableStateOf("")

    var activeStudent: Student? by mutableStateOf(null)


    fun login():  Boolean{

        val registeredStudent = FakeDatabase.registeredUsers[studentNo]

        if (registeredStudent != null && registeredStudent.password == password){
            activeStudent = registeredStudent
            message = "Giriş Başarılı!"
            return  true
        }

        else{
            message = "Giriş başarısız! Şifre veya kullanıcı adı hatalı"
            return false
        }
    }



    fun resetStates(){
        studentNo = ""
        password = ""
        message = ""
    }


}