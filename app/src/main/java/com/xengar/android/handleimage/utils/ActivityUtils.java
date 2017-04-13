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
package com.xengar.android.handleimage.utils;

import android.content.Context;
import android.content.Intent;

import com.xengar.android.handleimage.ui.DragAndDropActivity;
import com.xengar.android.handleimage.ui.DragImageActivity;
import com.xengar.android.handleimage.ui.DropOutsideActivity;
import com.xengar.android.handleimage.ui.SmallImageActivity;
import com.xengar.android.handleimage.ui.SplitImageActivity;

/**
 * ActivityUtils. To handle common tasks.
 */
public class ActivityUtils {

    private static final String TAG = ActivityUtils.class.getSimpleName();


    /**
     * Launches the activity.
     * @param context Context
     */
    public static void launchSplitActivity(final Context context) {
        Intent intent = new Intent(context, SplitImageActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    /**
     * Launches the activity.
     * @param context Context
     */
    public static void launchSmallImagesActivity(final Context context) {
        Intent intent = new Intent(context, SmallImageActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    /**
     * Launches the activity.
     * @param context Context
     */
    public static void launchDragActivity(final Context context) {
        Intent intent = new Intent(context, DragImageActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    /**
     * Launches the activity.
     * @param context Context
     */
    public static void launchDragAndDropActivity(final Context context) {
        Intent intent = new Intent(context, DragAndDropActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    /**
     * Launches the activity.
     * @param context Context
     */
    public static void launchDropOutsideActivity(final Context context) {
        Intent intent = new Intent(context, DropOutsideActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

}
