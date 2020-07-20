package com.example.gridlayoutmanager.custom

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class GridDecoration(val offset: Int) : BaseItemDecoration() {
    override fun getItemOffsetRecyclerView(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val gridLayoutManager = view.layoutParams as GridLayoutManager.LayoutParams
        when {
            gridLayoutManager.spanIndex % 2 == 0 -> {
                outRect.top = offset
                outRect.left = offset
                outRect.right = offset / 2
            }
            else -> {
                outRect.top = offset
                outRect.left = offset / 2
                outRect.right = offset
            }
        }
    }
}