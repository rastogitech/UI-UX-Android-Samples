package com.app.uiuxsamples.sheet

import android.app.Dialog
import android.os.Bundle
import android.support.design.widget.BottomSheetDialogFragment
import com.app.uiuxsamples.R

class FilterBottomSheetFragment : BottomSheetDialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = Dialog(activity)
        dialog.setContentView(R.layout.fragment_bottom_sheet_dialog)

        return dialog
    }

}