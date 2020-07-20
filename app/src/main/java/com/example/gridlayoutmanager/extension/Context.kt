package com.example.gridlayoutmanager.extension

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity

/**
 * Extension method to startActivity for Context.
 */

inline fun <reified T : Any> Context?.launchActivity() =
    this?.startActivity(Intent(this, T::class.java))

inline fun <reified T : Any> Context?.launchActivity(func: Intent.() -> Intent) =
    this?.startActivity(Intent(this, T::class.java).func())

inline fun <reified T : Any> AppCompatActivity.launchActivity(
    func: Intent.() -> Intent,
    requestCode: Int = -1
) =
    startActivityForResult(Intent(this, T::class.java).func(), requestCode)


/**
 * InflateLayout
 */
fun Context.inflateLayout(
    @LayoutRes layoutId: Int, parent: ViewGroup? = null,
    attachToRoot: Boolean = false
): View = LayoutInflater.from(this).inflate(layoutId, parent, attachToRoot)
