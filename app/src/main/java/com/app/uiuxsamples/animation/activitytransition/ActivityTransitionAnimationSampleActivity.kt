package com.app.uiuxsamples.animation.activitytransition

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.app.uiuxsamples.BaseActivity
import com.app.uiuxsamples.R
import kotlinx.android.synthetic.main.activity_transition_animation_sample.*

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
class ActivityTransitionAnimationSampleActivity : BaseActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transition_animation_sample)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        bt_from_left.setOnClickListener(this)
        bt_from_top.setOnClickListener(this)
        bt_from_right.setOnClickListener(this)
        bt_from_bottom.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.bt_from_left -> {
                startActivity(Intent(this, LeftSlideInAnimationActivity::class.java))
                overridePendingTransition(R.anim.left_slide_in, R.anim.no_animation)
            }
            R.id.bt_from_top -> {
                startActivity(Intent(this, TopSlideInAnimationActivity::class.java))
                overridePendingTransition(R.anim.top_slide_in, R.anim.no_animation)
            }
            R.id.bt_from_right -> {
                startActivity(Intent(this, RightSlideInAnimationActivity::class.java))
                overridePendingTransition(R.anim.right_slide_in, R.anim.no_animation)
            }
            R.id.bt_from_bottom -> {
                startActivity(Intent(this, BottomSlideInAnimationActivity::class.java))
                overridePendingTransition(R.anim.bottom_slide_in, R.anim.no_animation)
            }
        }
    }

}
