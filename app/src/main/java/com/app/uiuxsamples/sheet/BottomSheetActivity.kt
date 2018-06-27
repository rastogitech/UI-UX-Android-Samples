package com.app.uiuxsamples.sheet

import android.os.Bundle
import android.support.design.widget.BottomSheetBehavior
import android.util.Log
import android.util.TypedValue
import android.view.View
import android.widget.ArrayAdapter
import com.app.uiuxsamples.BaseActivity
import com.app.uiuxsamples.R
import kotlinx.android.synthetic.main.activity_bottom_sheet.*
import kotlinx.android.synthetic.main.layout_bottom_sheet.*
import kotlinx.android.synthetic.main.layout_bottom_sheet_content.*


class BottomSheetActivity : BaseActivity() {

    private lateinit var bottomSheetBehavior: BottomSheetBehavior<View>
    private var actionBarHeight: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_sheet)

        actionBarHeight = getActionBarHeight()

        //Preparing dummy data for ListView
        val dataList = mutableListOf<String>()

        for (i in 0..50) {
            dataList.add(i.toString())
        }

        list_view.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dataList)

        bottomSheetBehavior = BottomSheetBehavior.from(bottom_sheet)
        bottomSheetBehavior.setBottomSheetCallback(RecipeBottomSheetBehaviorCallback())

        //Toggling bottom sheet by button click
        bt_recipe_details.setOnClickListener({
            toggleBottomSheet()
        })
    }

    private fun toggleBottomSheet() {
        if (bottomSheetBehavior.state != BottomSheetBehavior.STATE_EXPANDED) {
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
        } else {
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
        }
    }

    private fun getActionBarHeight(): Int {
        val typedValue = TypedValue()
        if (theme.resolveAttribute(android.R.attr.actionBarSize, typedValue, true)) {
            return TypedValue.complexToDimensionPixelSize(typedValue.data, resources.displayMetrics)
        }
        return -1
    }


    private inner class RecipeBottomSheetBehaviorCallback : BottomSheetBehavior.BottomSheetCallback() {

        override fun onSlide(bottomSheet: View, slideOffset: Float) {
            val ACTION_BAR_THRESHOLD = 0.15f
            val totalSteps = ACTION_BAR_THRESHOLD * 1000
            val oneStepValue = 1 / totalSteps

            val currentSteps = (1 - slideOffset) * 1000
            val INITIAL_ALPHA_OFFSET = 0.35f

            if (currentSteps <= totalSteps) {
                val alpha: Float = currentSteps * oneStepValue
                app_bar_layout.alpha = alpha - INITIAL_ALPHA_OFFSET
            } else {
                app_bar_layout.alpha = 1f
            }

            tv_message.text = "" + actionBarHeight + "  :  " + slideOffset
        }

        override fun onStateChanged(bottomSheet: View, newState: Int) {
            when (newState) {
                BottomSheetBehavior.STATE_HIDDEN -> {
                    Log.d("", "btmsht::Hidden")
                }
                BottomSheetBehavior.STATE_EXPANDED -> {
                    Log.d("", "btmsht::Expanded")
                    bt_recipe_details.text = "Hide Details"
                }
                BottomSheetBehavior.STATE_COLLAPSED -> {
                    Log.d("", "btmsht::Collapsed")
                    bt_recipe_details.text = "Show Details"
                }
                BottomSheetBehavior.STATE_DRAGGING -> {
                    Log.d("", "btmsht::Dragging")
                }
                BottomSheetBehavior.STATE_SETTLING -> {
                    Log.d("", "btmsht::Settling")
                }
            }
        }
    }
}
