package com.kotlinextensionfunction

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        success_toast.setToastMessageListner("You successfully did that thing!")

        error_toast.setToastMessageListner("Something went wrong...")

        success_dialog.setDialogMessageListener("You successfully did that thing!", false)

        error_dialog.setDialogMessageListener("Something went wrong...", true)

        are_you_sure.setOnClickListener {
            val areYouSureCallBack = object: AreYouSureCallback{
                override fun proceed() {
                    displayTost("You successfully did that thing!")
                }

                override fun cancel() {
                    displayTost("Cancelled...")
                }
            }
            displayAreYouSureDialog("Are you sure you want to do that? This can't be un-done.", areYouSureCallBack)
        }


    }

    //extension function for Button clickListener for toast
    fun Button.setToastMessageListner(message: String){
        this.setOnClickListener {
            message?.let {
                displayTost(message)
            }
        }
    }

    //extension function for Button clickListener of dialogs
    fun Button.setDialogMessageListener(message: String, isError: Boolean){
        this.setOnClickListener {
            if (isError) displayErrorDialog(message)
            else displaySuccessDialog(message)
        }
    }



}