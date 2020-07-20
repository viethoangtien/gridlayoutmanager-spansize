package com.example.gridlayoutmanager.custom

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SpanItemDecoration(val offset: Int) : BaseItemDecoration() {
    override fun getItemOffsetRecyclerView(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val gridLayoutManager = view.layoutParams as GridLayoutManager.LayoutParams
        when (gridLayoutManager.viewAdapterPosition % 3) {
            0 -> {
                outRect.top = offset
                outRect.left = offset
                outRect.right = offset
            }
            1 -> {
                outRect.top = offset
                outRect.left = offset
                outRect.right = offset / 2
            }
            2 -> {
                outRect.top = offset
                outRect.left = offset / 2
                outRect.right = offset
            }
        }
    }
}