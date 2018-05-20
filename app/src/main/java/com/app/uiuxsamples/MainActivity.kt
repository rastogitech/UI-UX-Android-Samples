package com.app.uiuxsamples

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.app.uiuxsamples.animation.activitytransition.ActivityTransitionAnimationSampleActivity
import com.app.uiuxsamples.materialactionbar.MaterialActionBarSampleActivity
import kotlinx.android.synthetic.main.activity_main.*

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
class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bt_activity_animations.setOnClickListener(this)
        bt_material_action_bars.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.bt_activity_animations ->
                startActivity(Intent(this, ActivityTransitionAnimationSampleActivity::class.java))

            R.id.bt_material_action_bars ->
                startActivity(Intent(this, MaterialActionBarSampleActivity::class.java))
        }
    }

}
