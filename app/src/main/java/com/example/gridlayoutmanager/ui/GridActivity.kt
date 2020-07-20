package com.example.gridlayoutmanager.ui

import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.gridlayoutmanager.R
import com.example.gridlayoutmanager.adapter.GridAdapter
import com.example.gridlayoutmanager.custom.GridDecoration
import com.example.gridlayoutmanager.custom.HeaderDecoration
import com.example.gridlayoutmanager.custom.SpanItemDecoration
import com.example.gridlayoutmanager.utils.Define
import com.example.gridlayoutmanager.utils.ViewUtil
import kotlinx.android.synthetic.main.activity_grid.*

class GridActivity : AppCompatActivity() {
    private var type: Int? = null
        get() = intent.getIntExtra(Define.IntentArgument.TYPE, 0)
    private lateinit var mGridAdapter: GridAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid)
        initViews()
        initListener()
    }

    private fun initViews() {
        when (type) {
            Define.IntentArgument.GRID -> {
                initGridAdapter()
            }
            Define.IntentArgument.SPAN -> {
                initSpanSizeAdapter()
            }
            Define.IntentArgument.HEADER -> {
                initHeaderAdapter()
            }
            Define.IntentArgument.AUTO_FIT -> {
                initAutoFitAdapter()
            }
        }
    }

    private fun initAutoFitAdapter() {
        mGridAdapter = GridAdapter(this)
        rcv_grid.adapter = mGridAdapter
        rcv_grid.layoutManager = GridLayoutManager(this, ViewUtil.calculateNoOfColumns(this))
        rcv_grid.addItemDecoration(GridDecoration(resources.getDimensionPixelOffset(R.dimen.content_padding_16dp)))
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        if (type == Define.IntentArgument.AUTO_FIT){
            rcv_grid.layoutManager = GridLayoutManager(this, ViewUtil.calculateNoOfColumns(this))
        }
    }

    private fun initHeaderAdapter() {
        mGridAdapter = GridAdapter(this, isShowHeader = true)
        rcv_grid.adapter = mGridAdapter
        val gridLayoutManager = GridLayoutManager(this, 2)
        gridLayoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return when (mGridAdapter.getItemViewType(position)) {
                    GridAdapter.VIEW_TYPE_HEADER -> 2
                    else -> 1
                }
            }
        }
        rcv_grid.layoutManager = gridLayoutManager
        rcv_grid.addItemDecoration(HeaderDecoration(resources.getDimensionPixelOffset(R.dimen.content_padding_16dp)))
    }

    private fun initSpanSizeAdapter() {
        mGridAdapter = GridAdapter(this)
        rcv_grid.adapter = mGridAdapter
        val gridLayoutManager = GridLayoutManager(this, 3)
        gridLayoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return (3 - position % 3)
            }
        }
        rcv_grid.layoutManager = gridLayoutManager
        rcv_grid.addItemDecoration(SpanItemDecoration(resources.getDimensionPixelOffset(R.dimen.content_padding_16dp)))

    }

    private fun initGridAdapter() {
        mGridAdapter = GridAdapter(this)
        rcv_grid.adapter = mGridAdapter
        rcv_grid.layoutManager = GridLayoutManager(this, 2)
        rcv_grid.addItemDecoration(GridDecoration(resources.getDimensionPixelOffset(R.dimen.content_padding_16dp)))
    }

    private fun initListener() {

    }
}