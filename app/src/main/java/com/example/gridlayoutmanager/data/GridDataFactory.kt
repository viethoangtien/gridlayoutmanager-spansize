package com.example.gridlayoutmanager.data

class GridDataFactory {

    companion object {
        fun provideDataGrid(): ArrayList<Int> {
            return ArrayList((1..30).map {
                it
            })
        }
    }
}