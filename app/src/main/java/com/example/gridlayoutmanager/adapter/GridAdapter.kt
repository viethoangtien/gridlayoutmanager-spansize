package com.example.gridlayoutmanager.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gridlayoutmanager.R
import com.example.gridlayoutmanager.data.GridDataFactory
import com.example.gridlayoutmanager.extension.inflateLayout
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_grid.*

class GridAdapter(val context: Context, val isShowHeader: Boolean = false) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object {
        const val VIEW_TYPE_HEADER = 0
        const val VIEW_TYPE_CHILD = 1
    }

    override fun getItemViewType(position: Int): Int {
        if (position == 0 && isShowHeader) return VIEW_TYPE_HEADER
        else return VIEW_TYPE_CHILD
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            VIEW_TYPE_HEADER -> {
                GridHeaderViewHolder(
                    context.inflateLayout(
                        R.layout.item_grid,
                        parent
                    )
                )
            }
            VIEW_TYPE_CHILD -> {
                GridViewHolder(
                    context.inflateLayout(
                        R.layout.item_grid,
                        parent
                    )
                )
            }
            else -> {
                GridViewHolder(
                    context.inflateLayout(
                        R.layout.item_grid,
                        parent
                    )
                )
            }
        }
    }

    override fun getItemCount() = GridDataFactory.provideDataGrid().size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            VIEW_TYPE_HEADER -> {
                if (isShowHeader)
                    (holder as GridHeaderViewHolder).bind(GridDataFactory.provideDataGrid()[position])
                else (holder as GridViewHolder).bind(GridDataFactory.provideDataGrid()[position])
            }
            VIEW_TYPE_CHILD -> {
                (holder as GridViewHolder).bind(GridDataFactory.provideDataGrid()[position])
            }
        }

    }

    class GridHeaderViewHolder(override val containerView: View?) :
        RecyclerView.ViewHolder(containerView!!), LayoutContainer {
        fun bind(data: Int) {
            tv_grid.text = "Grid layout with header, spanning  2 columns"
        }
    }

    class GridViewHolder(override val containerView: View?) :
        RecyclerView.ViewHolder(containerView!!), LayoutContainer {
        fun bind(data: Int) {
            tv_grid.text = "$data"
        }
    }
}