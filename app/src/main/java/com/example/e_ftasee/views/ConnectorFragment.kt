package com.example.e_ftasee.views

interface ConnectorFragment {

    fun passCode(editTextInput: Int)
    fun tableChoice(choice: Int)
    fun loginPage()
    fun login(user: String, pass: String)
    fun feedback(feedback: String)

}