package com.yudorm.app.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.yudorm.app.data.FakeDatabase
import com.yudorm.app.data.models.Student
import kotlin.collections.set

class RegisterViewModel: ViewModel() {

    private var _password by mutableStateOf("")
    private var _passwordRepetition by mutableStateOf("")

    var firstName by mutableStateOf("")
    var lastName by mutableStateOf("")
    var department by mutableStateOf("")
    var studentNo by mutableStateOf("")
    var password: String
        get() = _password
        set(value)  {
            _password = value
            checkPasswordMatch()
        }
    var passwordRepetition: String
        get() = _passwordRepetition
        set(value) {
            _passwordRepetition = value
            checkPasswordMatch()
        }

    var passwordsMatch by mutableStateOf(true)

    var message by mutableStateOf("")



    fun checkPasswordMatch(){
        if (password.isEmpty() && passwordRepetition.isEmpty()){
            passwordsMatch = true
            message = ""
            return
        }

        if (password == passwordRepetition){
            passwordsMatch = true
            message = ""

        }
        else{
            passwordsMatch = false
            message = "Şifreler eşleşmiyor!"

        }
    }


    fun register(): Boolean{

        if (studentNo.isBlank() || password.isBlank()) {
            message = "Tüm zorunlu alanları doldurun."
            return false
        }

        if (!passwordsMatch){
            return false
        }

        if (FakeDatabase.registeredUsers.containsKey(studentNo)) {
            message = "Bu öğrenci numarası zaten kayıtlı."
            return false
        }

        val nextId = FakeDatabase.generateNextId()
        val newStudent = Student(
            id = nextId,
            firstName = firstName,
            lastName = lastName,
            studentNo,
            password = password,
            department = department
        )

        FakeDatabase.registeredUsers[newStudent.studentNumber] = newStudent
        message = "Kayıt Başarılı!"
        return true
    }




}