package com.example.gridlayoutmanager.custom

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseItemDecoration : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        getItemOffsetRecyclerView(outRect, view, parent, state)
    }

    abstract fun getItemOffsetRecyclerView(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    )
}