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

    private fun onClickEncode() {
        if (!isEmpty(keyInput) && !isEmpty(passwordInput) && keyInput.text.toString().toInt() > 0 && keyInput.text.toString().toInt() < 27) {
            val encodedMessage = encryptionObj.encode(passwordInput.text.toString(), keyInput.text.toString().toInt())
            Log.v("encoded Message", "encoded message = $encodedMessage")
            decodedOutput.setText(encodedMessage)
            printLabel.text = "To test: Copy the ENCODED text and paste it in the \n" +
                    "password text field and use the same KEY for decoding"
        } else printLabel.text = "Please enter both Message and Key"
    }

    private fun onClickDecode() {
        try {
            if (!isEmpty(keyInput) && !isEmpty(passwordInput) && keyInput.text.toString().toInt() > 0 && keyInput.text.toString().toInt() < 27) {
                val decodedMessage = encryptionObj.decode(passwordInput.text.toString(), keyInput.text.toString().toInt())
                decodedOutput.setText(decodedMessage)
            } else printLabel.text = "Please enter both Message and Key"
        } catch (e: TypeCastException) {
            printLabel.text = "Make sure that your PASSWORD Text is encoded for Decoding: Must contain Chemistry Symbols"
        }
    }
}
