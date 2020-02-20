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

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ShareCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.xengar.android.handleimage.BuildConfig;
import com.xengar.android.handleimage.R;
import com.xengar.android.handleimage.utils.ActivityUtils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

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

            case R.id.action_share:
                Context context = getApplicationContext();
                // Save file to storage
                Bitmap icon = BitmapFactory.decodeResource(getResources(), R.drawable.gallery_lion);
                ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                icon.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
                File imagePath2 = new File(context.getFilesDir(), "internal");
                File f = new File(imagePath2, "gallery_lion.jpg");
                context.deleteFile(f.getName());
                //if(f.exists()){
                //    Log.i("imageExistsInternal", "file is complete");
                //} else {
                FileOutputStream outputStream = null;
                try {
                    outputStream = new FileOutputStream(f, false);
                    outputStream.write(bytes.toByteArray());
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
                //}

                //ActivityUtils.launchShareImage(this, createShareText());
                // https://medium.com/google-developers/sharing-content-between-android-apps-2e6db9d1368b#.6usvw9n9p
                // https://developer.android.com/reference/android/support/v4/content/FileProvider.html

                // Directory must be in file_paths.xml
                File imagePath = new File(context.getFilesDir(), "internal");
                File imageFile = new File(imagePath, "gallery_lion.jpg");
                Uri uriToImage = FileProvider.getUriForFile(context, BuildConfig.FILES_AUTHORITY, imageFile);
                // content://${files_authority}/private/file.jpg
                Intent shareIntent = ShareCompat.IntentBuilder.from(this)
                        .setStream(uriToImage)
                        .setType("image/*")
                        .getIntent();
                // Provide read access
                shareIntent.setData(uriToImage);
                shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                if (shareIntent.resolveActivity(getPackageManager()) != null) {
                    //startActivity(shareIntent);
                    //startActivity(Intent.createChooser(shareIntent, "Share Image"));

                    Intent shareIntent2 = new Intent();
                    shareIntent2.setAction(Intent.ACTION_SEND);
                    shareIntent2.putExtra(Intent.EXTRA_TEXT, "gallery_lion.jpg");
                    shareIntent2.putExtra(Intent.EXTRA_STREAM, uriToImage);
                    shareIntent2.setType("image/*");
                    //shareIntent2.setData(uriToImage);
                    shareIntent2.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    startActivity(Intent.createChooser(shareIntent2, "Share images..."));
                }

                //ActivityUtils.firebaseAnalyticsLogEventSelectContent(mFirebaseAnalytics,
                //        "Animal: " + animal.getName() + ", AnimalId: " + animalID, TYPE_SHARE, TYPE_SHARE);
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
