package com.nhankv.mvpandroid.presenter

import com.nhankv.mvpandroid.model.LoginCallBack
import com.nhankv.mvpandroid.view.LoginFragment
import com.nhankv.mvpandroid.model.LoginInteractor

class LoginPresenter(private var loginView: LoginFragment?, private var loginInteractor: LoginInteractor?): LoginCallBack {
    private val TAG = javaClass.name

    fun login(user: String, pass: String) {
        loginInteractor!!.login(user, pass, this)
    }

    override fun onUsernameIsEmpty() {
        loginView!!.userIsEmpty()
    }

    override fun onPasswordIsEmpty() {
        loginView!!.passIsEmpty()
    }

    override fun onErrorLogin() {
        loginView!!.errorLogin()
    }

    override fun onLoginSuccess() {
        loginView!!.loginSuccess()
    }

    fun destroy() {
        loginView = null
        loginInteractor = null
    }
}
