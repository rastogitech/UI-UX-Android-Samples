package com.app.uiuxsamples.materialactionbar

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.app.uiuxsamples.BaseActivity
import com.app.uiuxsamples.R
import kotlinx.android.synthetic.main.activity_material_action_bar_sample.*

/**
 * Copyright 2018 Rahul Rastogi. All Rights Reserved.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
class MaterialActionBarSampleActivity : BaseActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_material_action_bar_sample)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        /**
         * In CollapsingToolbarLayout:
         *
         * 1. app:layout_scrollFlags="scroll|enterAlways": To collapse action bar fully on scroll up
         * and expand immediately on scroll down.
         *
         * 2. app:layout_scrollFlags="scroll|enterAlwaysCollapsed": To collapse action bar fully on scroll up
         * and doesn't expand until the whole scrollable content is visible.
         *
         * 3. app:layout_scrollFlags="scroll|exitUntilCollapsed": If CollapsingToolbarLayout height
         * is larger than height of Toolbar then action bar collapses on scrolling up to the height of
         * Toolbar only and doesn't expand on scrolling down until whole scrollable content is visible.
         *
         * 4. app:layout_scrollFlags="scroll|snap": If CollapsingToolbarLayout height
         * is larger than height of Toolbar then action bar collapses fully on scrolling up
         * and doesn't expands on scrolling down until whole scrollable content is visible.
         */

        scrolling_action_bar_with_header_tabs.setOnClickListener(this)
        scrolling_action_bar_at_last_scroll.setOnClickListener(this)
        big_scrolling_action_bar_at_last_scroll.setOnClickListener(this)
        big_scrolling_action_bar_until_collapsed.setOnClickListener(this)
        parallax_action_bar.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.scrolling_action_bar_with_header_tabs ->
                startActivity(Intent(this, ScrollingActionBarImmediateScrollWithHeaderTabActivity::class.java))

            R.id.scrolling_action_bar_at_last_scroll ->
                startActivity(Intent(this, ScrollingActionBarAtLastScrollActivity::class.java))

            R.id.big_scrolling_action_bar_at_last_scroll ->
                startActivity(Intent(this, BigScrollingActionBarAtLastScrollActivity::class.java))

            R.id.big_scrolling_action_bar_until_collapsed ->
                startActivity(Intent(this, BigScrollingActionBarUntilCollapsedActivity::class.java))

            R.id.parallax_action_bar ->
                startActivity(Intent(this, ParallaxScrollingBarActivity::class.java))
        }
    }

}
