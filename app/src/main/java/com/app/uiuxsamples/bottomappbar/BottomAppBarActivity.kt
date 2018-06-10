package com.app.uiuxsamples.bottomappbar

import android.os.Bundle
import android.support.design.bottomappbar.BottomAppBar
import com.app.uiuxsamples.BaseActivity
import com.app.uiuxsamples.R
import kotlinx.android.synthetic.main.activity_bottom_app_bar.*

class BottomAppBarActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_app_bar)

        //Note: It's necessary to set this menu. Otherwise, the BottomAppBar won't be shown.
        bottom_app_bar.replaceMenu(R.menu.menu_common)

        bottom_app_bar.setOnMenuItemClickListener({
            when (it!!.itemId) {
                R.id.action_previous -> {
                    bottom_app_bar.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_CENTER
                    true
                }
                R.id.action_next -> {
                    bottom_app_bar.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_END
                    true
                }
                else ->
                    false
            }
        })

    }

}
