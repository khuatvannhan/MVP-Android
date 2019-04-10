package com.nhankv.mvpandroid.model

import android.os.Handler
import android.text.TextUtils

class LoginInteractorImpl : LoginInteractor {
    private val TAG = javaClass.name

    override fun login(user: String, pass: String, loginCallBack: LoginCallBack) {
        Handler().postDelayed({
            if (TextUtils.isEmpty(user)) {
                loginCallBack.onUsernameIsEmpty()
            }
            if (TextUtils.isEmpty(pass)) {
                loginCallBack.onPasswordIsEmpty()
            }
            if (user == "nhankv" && pass == "123") {
                loginCallBack.onLoginSuccess()
            } else {
                loginCallBack.onErrorLogin()
            }
        }, 1000)
    }
}
