package com.android.fundamentals.workshop04

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.android.fundamentals.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class SampleBottomSheet : BottomSheetDialogFragment() {

    override fun setupDialog(
        dialog: Dialog,
        style: Int
    ) {
        val contentView =
            View.inflate(context, R.layout.dialog_fragment_ws04, null)
        dialog.setContentView(contentView)
        (contentView.parent as View).setBackgroundColor(
            ContextCompat.getColor(
                contentView.context,
                android.R.color.transparent
            )
        )
        contentView.findViewById<Button>(R.id.btn_ok).apply {
            setOnClickListener {
                Toast.makeText(context, "OK", Toast.LENGTH_SHORT).show()
            }
        }
        contentView.findViewById<Button>(R.id.btn_cancel).apply {
            setOnClickListener {
                Toast.makeText(context, "Cancel", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCancel(dialog: DialogInterface) {
        super.onCancel(dialog)

        Toast.makeText(context, "you dismissed dialog", Toast.LENGTH_SHORT).show()
    }
}