package com.nhankv.mvpandroid.view

interface LoginView {
    fun userIsEmpty()

    fun passIsEmpty()

    fun errorLogin()

    fun loginSuccess()
}
