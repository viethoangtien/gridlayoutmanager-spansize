package com.example.gridlayoutmanager.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gridlayoutmanager.R
import com.example.gridlayoutmanager.extension.launchActivity
import com.example.gridlayoutmanager.utils.Define
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initListener()
    }

    private fun initListener() {
        grid_layout_manager.setOnClickListener {
            launchActivity<GridActivity> {
                putExtra(Define.IntentArgument.TYPE, Define.IntentArgument.GRID)
            }
        }
        variable_span_size.setOnClickListener {
            launchActivity<GridActivity> {
                putExtra(Define.IntentArgument.TYPE, Define.IntentArgument.SPAN)
            }
        }
        header.setOnClickListener {
            launchActivity<GridActivity> {
                putExtra(Define.IntentArgument.TYPE, Define.IntentArgument.HEADER)
            }
        }
        autofit.setOnClickListener {
            launchActivity<GridActivity> {
                putExtra(Define.IntentArgument.TYPE, Define.IntentArgument.AUTO_FIT)
            }
        }
    }
}