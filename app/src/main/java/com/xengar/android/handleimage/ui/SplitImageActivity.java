/*
 * Copyright (C) 2017 Angel Newton
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.xengar.android.handleimage.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.xengar.android.handleimage.R;
import com.xengar.android.handleimage.utils.ActivityUtils;

/**
 * SplitImageActivity
 */
public class SplitImageActivity extends AppCompatActivity {

    public View.OnClickListener small_listner = new View.OnClickListener() {
        public void onClick(View v) {
            ActivityUtils.launchSmallImagesActivity(getApplicationContext());
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_split_image);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button split = (Button) findViewById(R.id.small_image);
        split.setOnClickListener(small_listner);

    }


}
