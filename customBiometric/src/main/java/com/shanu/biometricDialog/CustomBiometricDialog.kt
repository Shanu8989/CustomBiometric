package com.shanu.biometricDialog

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import com.shanu.commonsettings.R
import com.shanu.commonsettings.databinding.DialogBiometricsBinding

class CustomBiometricDialog : DialogFragment() {

    private lateinit var dialogBiometricsBinding: DialogBiometricsBinding
    private lateinit var onBiometricIconClick: () -> Unit
    private lateinit var dialogTitle: String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dialogBiometricsBinding =
            DataBindingUtil.inflate(
                LayoutInflater.from(context),
                R.layout.dialog_biometrics,
                null,
                false
            )

        if (dialog != null && dialog?.window != null) {
            dialog?.let { dialog ->
                dialog.window?.let { window ->
                    window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                    window.requestFeature(Window.FEATURE_NO_TITLE)
                }
            }
        }

        dialogBiometricsBinding.biometricImgTxtLayout.setOnClickListener {
            onBiometricIconClick()
            dismiss()
        }

        dialog?.setContentView(dialogBiometricsBinding.root)

        return view
    }

    class Builder {

        private var customBiometricDialogFragment: CustomBiometricDialog = CustomBiometricDialog()

        fun isCancelable(flag: Boolean): Builder {
            customBiometricDialogFragment.isCancelable = flag
            return this
        }

        fun onBiometricClick(action: () -> Unit): Builder {
            customBiometricDialogFragment.onBiometricIconClick = action
            return this
        }

        fun setCustomDialogTitle(title: String): Builder {
            customBiometricDialogFragment.dialogTitle = title
            return this
        }

        fun build(): CustomBiometricDialog {
            return customBiometricDialogFragment
        }
    }
}