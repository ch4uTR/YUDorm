package com.yudorm.app.ui.viewmodel


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class LostItemViewModel : ViewModel() {

    // Form alanları için stateler
    var itemName by mutableStateOf("")
    var itemColor by mutableStateOf("")

    var location by mutableStateOf("")
    var date by mutableStateOf("")

    // Hata veya başarı mesajı
    var message by mutableStateOf("")

    fun submitLostItem(studentNo: String): Boolean {
        // Validasyonlar (Senin IssueViewModel mantığınla)
        if (itemName.isBlank() || location.isBlank()) {
            message = "Lütfen zorunlu alanları (İsim ve Konum) doldurunuz!"
            return false
        }

        if (date.isBlank()) {
            message = "Lütfen tahmini bir tarih giriniz."
            return false
        }

        // Başarı senaryosu
        message = "Kayıp eşya kaydınız başarıyla oluşturuldu!"
        return true
    }

    // Formu temizlemek istersen (isteğe bağlı)
    fun resetForm() {
        itemName = ""
        itemColor = ""
        location = ""
        date = ""
        message = ""
    }
}