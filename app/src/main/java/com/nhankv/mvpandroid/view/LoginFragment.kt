package com.nhankv.mvpandroid.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.nhankv.mvpandroid.model.LoginInteractorImpl
import com.nhankv.mvpandroid.presenter.LoginPresenter
import kotlinx.android.synthetic.main.fragment_login.*
import android.app.Activity
import android.view.inputmethod.InputMethodManager

class LoginFragment : Fragment(), LoginView {
    private val TAG = javaClass.name
    private lateinit var presenter: LoginPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(com.nhankv.mvpandroid.R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        presenter = LoginPresenter(this, LoginInteractorImpl())
        btLogin.setOnClickListener {
            login()
        }

//        edUser.setOnFocusChangeListener { v, hasFocus ->
//            if (!hasFocus) {
//                hideKeyboard(v)
//            }
//        }

        viewParent.setOnClickListener { v ->
            hideKeyboard(v)
        }

//        edPass.setOnFocusChangeListener{ v, hasFocus ->
//            if (!hasFocus) {
//                hideKeyboard(v)
//            }
//        }
    }

    private fun login() {
        presenter.login(edUser.text.toString(), edPass.text.toString())
    }

    override fun userIsEmpty() {
        showToast("Username is Empty", Toast.LENGTH_LONG)
    }

    override fun passIsEmpty() {
        showToast("Password is Empty", Toast.LENGTH_LONG)
    }

    override fun errorLogin() {
        showToast("Error login, user or password incorrect", Toast.LENGTH_LONG)
    }

    override fun loginSuccess() {
        showToast("Login success", Toast.LENGTH_SHORT)
    }

    @SuppressLint("ShowToast")
    private fun showToast(message: String, type: Int) {
        Toast.makeText(context, message, type).show()
    }

    fun hideKeyboard(view: View) {
        val inputMethodManager = activity!!.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager?
        inputMethodManager!!.hideSoftInputFromWindow(view.windowToken, 0)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.destroy()
    }
}
