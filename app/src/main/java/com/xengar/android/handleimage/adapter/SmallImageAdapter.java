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
package com.xengar.android.handleimage.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * SmallImageAdapter for SplitImage
 */
public class SmallImageAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<Bitmap> smallImages;
    private int imageWidth, imageHeight;

    //constructor
    public SmallImageAdapter(Context c, ArrayList<Bitmap> images){
        mContext = c;
        smallImages = images;
        imageWidth = images.get(0).getWidth();
        imageHeight = images.get(0).getHeight();
    }

    // return how many view is crated
    public int getCount() {
        return smallImages.size();
    }

    public Object getItem(int position) {
        return smallImages.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView image;
        if(convertView == null){
            image = new ImageView(mContext);
            image.setLayoutParams(new GridView.LayoutParams(imageWidth - 12 , imageHeight));
            image.setPadding(0, 0, 0, 0);
        }else{
            image = (ImageView) convertView;
        }
        image.setImageBitmap(smallImages.get(position));
        return image;
    }

}
