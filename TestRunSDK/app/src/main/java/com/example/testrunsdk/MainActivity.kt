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
                secretKey = "b7435e09bf97c1be53acb407102e245ad9f960fa874df9e18de7b1f7c4486540",
                serviceCode = "INT_TOP_UP",
                mobileNumber = "88776630",
                iPayCustomerID = "13"
            )
        }

        val btnSavedTopup = findViewById<Button>(R.id.btnSavedTopup)
        btnSavedTopup.setOnClickListener {
            VodQaSDK.openSavedTopup(
                this,
                secretKey = "b7435e09bf97c1be53acb407102e245ad9f960fa874df9e18de7b1f7c4486540",
                serviceCode = "INT_TOP_UP",
                mobileNumber = "88776630",
                iPayCustomerID = "13",
                savedBillId = "2"
            )
        }

    }
}
