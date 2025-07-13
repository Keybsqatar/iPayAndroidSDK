# iPayAndroidSDK Integration Guide

This document explains how to integrate and use the VodQaSDK in your Android application. It covers permissions, Settings setup, Gradle setup, and the two main entry points: International Top‑up,Saved Top‑up, Digital Vouchers and Utility Payment.

1. Add the AAR
Copy VodQaSDK.aar into your app/libs/ folder.


2. In settings.gradle, add:
```
dependencyResolutionManagement
{
  repositories {
    flatDir { dirs("libs") }
  }
}
```

3. In your app module’s build.gradle, declare:

```
dependencies {
  implementation(files("libs/VodQaSDK.aar"))
  implementation("com.squareup.retrofit2:retrofit:2.9.0")
  implementation("com.squareup.retrofit2:converter-gson:2.9.0")
  implementation("com.squareup.retrofit2:converter-moshi:2.9.0")
  implementation("com.squareup.okhttp3:okhttp:4.9.1")
  implementation("com.caverock:androidsvg:1.4")
  implementation("pl.droidsonroids.gif:android-gif-drawable:1.2.29")
  implementation("com.github.bumptech.glide:glide:4.15.1")
  implementation("com.github.bumptech.glide:compiler:4.12.0")`
  implementation("com.google.android.gms:play-services-auth-api-phone:18.2.0")
  implementation("com.google.android.gms:play-services-auth:21.3.0")
}
```

4. Add the following network_security_config.xml file or update it:
```
<network-security-config>
    <domain-config cleartextTrafficPermitted="true">
        <!-- Allow cleartext traffic for a specific IP -->
        <domain includeSubdomains="true">keybs.ai</domain>
    </domain-config>
</network-security-config>
```

5. Add the following permissions and network security config to your host app’s AndroidManifest.xml:
```
<uses-permission android:name="android.permission.INTERNET" />
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
<uses-permission android:name="android.permission.READ_CONTACTS" />

<application
  android:networkSecurityConfig="@xml/network_security_config">
/>
```

6. Launching the SDK
In your MainActivity (or any other Context), call the SDK’s entry points:
import com.keybs.vodqasdk.VodQaSDK

6.1 Start Service Type
```
VodQaSDK.startServiceType(
  this,
  secretKey      = "your_secret_key",
  serviceCode    = "xxx", // "INT_TOP_UP", "INT_VOUCHER", "INT_UTIL_PAYMENT"
  mobileNumber   = "xxxxxxxx",
  iPayCustomerID = "x"
)
```
6.2 Saved Top‑up
```
VodQaSDK.openSavedTopup(
  this,
  secretKey      = "your_secret_key",
  serviceCode    = "INT_TOP_UP",
  mobileNumber   = "xxxxxxxx",
  iPayCustomerID = "x",
  savedBillId    = "x"
)
```

Parameters:
- secretKey: Your API secret key.
- serviceCode: like "INT_TOP_UP", "INT_VOUCHER", "INT_UTIL_PAYMENT".
- mobileNumber: Sender’s phone number.
- iPayCustomerID: Your iPay customer identifier.
- savedBillId (only for Saved Top‑up): ID of the transaction to display.
