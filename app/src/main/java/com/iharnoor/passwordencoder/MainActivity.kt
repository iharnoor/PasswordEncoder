package com.iharnoor.passwordencoder

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.util.Log
import android.widget.EditText
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    val encryptionObj = Encryption()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        encodeButton.setOnClickListener {
            onClickEncode()
        }
        decodeButton.setOnClickListener {
            onClickDecode()
        }
    }

    private fun isEmpty(etText: EditText): Boolean {
        return etText.text.toString().trim { it <= ' ' }.isEmpty()
    }

    fun onClickEncode() {
        if (!isEmpty(keyInput) && !isEmpty(passwordInput) && keyInput.text.toString().toInt() > 0 && keyInput.text.toString().toInt()<27) {
            val encodedMessage = encryptionObj.encode(passwordInput.text.toString(), keyInput.text.toString().toInt())
            Toast.makeText(this, "encodedMessage is $encodedMessage", Toast.LENGTH_LONG).show()
            Log.v("encoded Message", "encoded message = $encodedMessage")
            decodedOutput.setText(encodedMessage)
        } else decodedOutput.setText("Please enter both Message and Key");
        Toast.makeText(this, "onClickEncode works", Toast.LENGTH_LONG).show()
    }

    fun onClickDecode() {
        if (!isEmpty(keyInput) && !isEmpty(passwordInput)&& keyInput.text.toString().toInt() > 0 && keyInput.text.toString().toInt()<27) {
            val decodedMessage = encryptionObj.decode(passwordInput.text.toString(), keyInput.text.toString().toInt())
            decodedOutput.setText(decodedMessage)
        } else decodedOutput.setText("Please enter both Message and Key");
        Toast.makeText(this, "onClickDecode works", Toast.LENGTH_LONG).show()
    }
}
