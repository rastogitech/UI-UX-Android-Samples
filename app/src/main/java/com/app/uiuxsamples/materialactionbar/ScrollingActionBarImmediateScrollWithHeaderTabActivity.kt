package com.app.uiuxsamples.materialactionbar

import android.os.Bundle
import android.view.Menu
import com.app.uiuxsamples.BaseActivity
import com.app.uiuxsamples.R
import kotlinx.android.synthetic.main.activity_scrolling_action_immediate_scroll_with_header_tab.*
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
class ScrollingActionBarImmediateScrollWithHeaderTabActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scrolling_action_immediate_scroll_with_header_tab)

        val tab1 = tab_layout.newTab().setText("Chat")
        val tab2 = tab_layout.newTab().setText("Message")
        val tab3 = tab_layout.newTab().setText("Status")

        tab_layout.addTab(tab1)
        tab_layout.addTab(tab2)
        tab_layout.addTab(tab3)

        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_scrolling, menu)
        return true
    }
}
