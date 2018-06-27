package com.app.uiuxsamples.materialactionbar

import android.graphics.BitmapFactory
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.content.ContextCompat
import android.support.v7.graphics.Palette
import android.view.Menu
import android.view.WindowManager
import com.app.uiuxsamples.BaseActivity
import com.app.uiuxsamples.R
import kotlinx.android.synthetic.main.activity_parallax_scrolling_bar.*


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
class ParallaxScrollingBarActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parallax_scrolling_bar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //Making status bar translucent
        window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        //Changing status bar and action bar colors on collapsed state according to header image color
        val palette = Palette
                .from(BitmapFactory.decodeResource(resources, R.drawable.ocean))
                .generate()

        collapsing_toolbar_layout.setStatusBarScrimColor(palette
                .getDarkMutedColor((ContextCompat.getColor(this, R.color.colorPrimaryDark))))
        collapsing_toolbar_layout.setContentScrimColor(palette
                .getMutedColor(ContextCompat.getColor(this, R.color.colorPrimary)))

        //On Fab button click
        fab.setOnClickListener {
            Snackbar.make(activity_parallax_scrolling_bar, "Fab clicked.", Snackbar.LENGTH_SHORT)
                    .setAction(R.string.undo, {})
                    .show()
        }
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_scrolling, menu)
        return true
    }

}
