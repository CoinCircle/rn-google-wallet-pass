package com.rngooglewalletpass

import android.app.Activity
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import com.facebook.react.bridge.Promise
import com.google.android.gms.pay.PayApiAvailabilityStatus
import com.google.android.gms.pay.Pay
import com.google.android.gms.pay.PayClient
import java.util.*
import kotlin.random.Random



class RnGoogleWalletPassModule(reactContext: ReactApplicationContext) : ReactContextBaseJavaModule(reactContext) {

    private var reactContext: ReactApplicationContext = reactContext;
    private lateinit var walletClient: PayClient;
    private var addToGoogleWalletRequestCode: Int = 0

    override fun getName(): String {
        return "RnGoogleWalletPass"
    }

    @ReactMethod
    fun isSupported(promise: Promise) {
    val activity: Activity? = currentActivity
        if (activity != null) {
            this.walletClient = Pay.getClient(this.reactContext);
            this.walletClient
                .getPayApiAvailabilityStatus(PayClient.RequestType.SAVE_PASSES)
                .addOnSuccessListener { status ->
                    promise.resolve(status == PayApiAvailabilityStatus.AVAILABLE);
                }
                .addOnFailureListener {
                    promise.reject("400", "Something went wrong");
                }
        }
    }

    @ReactMethod
    fun addWalletPass(jsonObject: String): Int {
        val activity = currentActivity
        if (activity != null && this.walletClient != null) {
            this.walletClient.savePasses(jsonObject, activity, this.addToGoogleWalletRequestCode)
            return this.addToGoogleWalletRequestCode;
        };
        return -1;
    }

}
