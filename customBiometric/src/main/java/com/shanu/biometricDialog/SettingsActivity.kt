package com.shanu.biometricDialog

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SettingsActivity : AppCompatActivity() {

    private lateinit var customBiometricDialog: CustomBiometricDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        callCustomBiometricDialog()
    }

    private fun callCustomBiometricDialog() {
        customBiometricDialog =
            CustomBiometricDialog.Builder().isCancelable(true).onBiometricClick {
                Toast.makeText(this, "Clicked on Biometric.", Toast.LENGTH_SHORT).show()
            }.build()

        customBiometricDialog.show(
            this.supportFragmentManager, "CustomBiometricDialog"
        )
    }

}