package com.example.gridlayoutmanager.utils

import android.content.Context
import android.util.DisplayMetrics

object ViewUtil {
    fun calculateNoOfColumns(
        context: Context,
        columnWidthDp: Float = 180f
    ): Int {
        // For example columnWidthDp=180
        val displayMetrics = context.resources.displayMetrics
        val screenWidthDp = displayMetrics.widthPixels / displayMetrics.density
        //+0.5 for correct rounding to int
        return (screenWidthDp / columnWidthDp + 0.5).toInt()
    }
}