package com.nhankv.mvpandroid.model

interface LoginCallBack {
    fun onUsernameIsEmpty()

    fun onPasswordIsEmpty()

    fun onErrorLogin()

    fun onLoginSuccess()
}
