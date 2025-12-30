package com.yudorm.app.ui.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.yudorm.app.data.FakeDatabase

class IssueViewModel : ViewModel(){

    var activeCategory by mutableStateOf("")
    var otherDetails by mutableStateOf("")
    var message by mutableStateOf("")



    fun submitIssue(studentNo: String) : Boolean{

        if (activeCategory.isEmpty()){
            message = "Lütfen bir kategori seçiniz!"
            return  false
        }

        if (activeCategory.equals("Diğer") && otherDetails.isBlank()){
            message = "Lütfen açıklamayı giriniz!"
            return false
        }

        message = "Kayıt başarılı! \nAnasayafaya yönlendiriliyorsunuz..."
        return true
    }



}