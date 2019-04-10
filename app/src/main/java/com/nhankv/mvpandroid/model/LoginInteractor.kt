package com.nhankv.mvpandroid.model

interface LoginInteractor {
    fun login(user: String, pass: String, loginCallBack: LoginCallBack)
}
