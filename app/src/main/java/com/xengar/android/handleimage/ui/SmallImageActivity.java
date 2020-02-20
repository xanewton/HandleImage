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

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;
import android.widget.ImageView;

import com.xengar.android.handleimage.R;
import com.xengar.android.handleimage.adapter.SmallImageAdapter;

import java.util.ArrayList;

/**
 * SmallImageActivity
 */
public class SmallImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.child_images);

        createImages();
    }


    private void createImages(){
        //Getting the source image to split
        ImageView image = new ImageView(this);
        image.setImageResource(R.drawable.gallery_lion);

        //smallimage_Numbers is to tell how many smallimage_s the image should split
        int smallimage_Numbers = 9;
        //invoking this method makes the actual splitting of the source image to given number of smallimage_s
        //Getting the image chunks sent from the previous activity
        ArrayList<Bitmap> smallImage = splitImage(image, smallimage_Numbers);

        //Getting the grid view and setting an adapter to it
        GridView image_grid = (GridView) findViewById(R.id.child_images_gridview);
        image_grid.setAdapter(new SmallImageAdapter(this, smallImage));
        image_grid.setNumColumns((int) Math.sqrt(smallImage.size()));
    }


    /**
     * Source: http://www.allappsdevelopers.com/TopicDetail.aspx?TopicID=dbf042fc-80be-4eca-9b7c-c0273ae2e8d9
     * Non tested alternative: http://stackoverflow.com/questions/5650740/divide-image-into-parts
     * Splits the source image and show them all into a grid in a new activity
     * @param image The source image to split
     * @param smallimage_Numbers The target number of small image smallimage_s to be formed from the source image
     */
    private ArrayList<Bitmap> splitImage(ImageView image, int smallimage_Numbers) {
        //For the number of rows and columns of the grid to be displayed
        int rows,cols;
        //For height and width of the small image smallimage_s
        int smallimage_Height,smallimage_Width;

        //To store all the small image smallimage_s in bitmap format in this list
        ArrayList<Bitmap> smallimages = new ArrayList<Bitmap>(smallimage_Numbers);

        //Getting the scaled bitmap of the source image
        BitmapDrawable mydrawable = (BitmapDrawable) image.getDrawable();
        Bitmap bitmap = mydrawable.getBitmap();
        Bitmap scaledBitmap = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth(), bitmap.getHeight(), true);

        rows = cols = (int) Math.sqrt(smallimage_Numbers);
        smallimage_Height = bitmap.getHeight()/rows;
        smallimage_Width = bitmap.getWidth()/cols;

        //xCo and yCo are the pixel positions of the image smallimage_s
        int yCo = 0;
        for(int x=0; x<rows; x++){
            int xCo = 0;
            for(int y=0; y<cols; y++){
                smallimages.add(Bitmap.createBitmap(scaledBitmap, xCo, yCo, smallimage_Width, smallimage_Height));
                xCo += smallimage_Width;
            }
            yCo+= smallimage_Height;
        }

        return smallimages;
    }
}
