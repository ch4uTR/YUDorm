package com.yudorm.app.data

import com.yudorm.app.data.models.Student

object FakeDatabase {

    private var currentId: Long = 0

    fun generateNextId(): String{
        currentId += 1
        return  currentId.toString()
    }

    val registeredUsers = mutableMapOf<String, Student>()
}