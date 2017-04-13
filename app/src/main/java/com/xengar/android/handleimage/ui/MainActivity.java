/*
 * Copyright (C) 2017 Angel Garcia
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
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.xengar.android.handleimage.R;
import com.xengar.android.handleimage.utils.ActivityUtils;

/**
 * MainActivity
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button button = (Button) findViewById(R.id.split);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchSplit();
            }
        });

        button = (Button) findViewById(R.id.drag);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchDrag();
            }
        });

        button = (Button) findViewById(R.id.dragdrop);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchDragAndDrop();
            }
        });

        button = (Button) findViewById(R.id.dropoutisde);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchDropOutside();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id){
            case R.id.action_settings:
                return true;

            case R.id.action_split:
                launchSplit();
                return true;

            case R.id.action_drag:
                launchDrag();
                return true;

            case R.id.action_drag_drop:
                launchDragAndDrop();
                return true;

            case R.id.action_drop_outside:
                launchDropOutside();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void launchSplit(){
        ActivityUtils.launchSplitActivity(getApplicationContext());
    }

    private void launchDrag(){
        ActivityUtils.launchDragActivity(getApplicationContext());
    }

    private void launchDragAndDrop(){
        ActivityUtils.launchDragAndDropActivity(getApplicationContext());
    }

    private void launchDropOutside(){
        ActivityUtils.launchDropOutsideActivity(getApplicationContext());
    }
}
