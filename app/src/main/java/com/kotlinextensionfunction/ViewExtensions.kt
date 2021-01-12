package com.kotlinextensionfunction

import android.app.Activity
import android.widget.Toast
import com.afollestad.materialdialogs.MaterialDialog

fun Activity.displayTost(message: String){
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}

fun Activity.displaySuccessDialog(message: String){
    MaterialDialog(this)
        .show {
            title(R.string.text_success)
            message(text = message)
            positiveButton(R.string.text_ok)
        }
}

fun Activity.displayErrorDialog(errorMessage: String){
    MaterialDialog(this)
        .show {
            title(R.string.text_error)
            message(text = errorMessage)
            positiveButton(R.string.text_ok)
        }
}

fun Activity.displayAreYouSureDialog(message: String, callback: AreYouSureCallback){
    MaterialDialog(this).show {
        title(R.string.are_you_sure)
        message(text = message)
        negativeButton { callback.cancel() }
        positiveButton { callback.proceed() }
    }

}

interface AreYouSureCallback{
    fun proceed()
    fun cancel()
}