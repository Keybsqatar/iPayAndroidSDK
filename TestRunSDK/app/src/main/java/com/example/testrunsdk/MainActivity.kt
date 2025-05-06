package com.example.testrunsdk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatDelegate
import com.keybs.vodqasdk.VodQaSDK

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        val btnInternationalTopup = findViewById<Button>(R.id.btnInternationalTopup)
        btnInternationalTopup.setOnClickListener {
            VodQaSDK.startInternationalTopup(
                this,
                secretKey = "your_secret_key",
                serviceCode = "INT_TOP_UP",
                mobileNumber = "xxxxxxxx",
                iPayCustomerID = "x"
            )
        }

        val btnSavedTopup = findViewById<Button>(R.id.btnSavedTopup)
        btnSavedTopup.setOnClickListener {
            VodQaSDK.openSavedTopup(
                this,
                secretKey = "your_secret_key",
                serviceCode = "INT_TOP_UP",
                mobileNumber = "xxxxxxxx",
                iPayCustomerID = "x",
                savedBillId = "x"
            )
        }

    }
}
