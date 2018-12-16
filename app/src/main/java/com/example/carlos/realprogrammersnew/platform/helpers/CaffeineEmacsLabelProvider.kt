package com.example.carlos.realprogrammersnew.platform.helpers

import android.content.Context
import com.example.carlos.realprogrammersnew.R

fun getEmacsLabel(context: Context, value: Int?): String {

    return when (value) {
        0 -> context.resources.getString(R.string.emacs_lowest_value)
        1 -> context.resources.getString(R.string.emacs_low_value)
        2 -> context.resources.getString(R.string.emacs_medium_value)
        3 -> context.resources.getString(R.string.emacs_high_value)
        4 -> context.resources.getString(R.string.emacs_highest_value)
        else -> ""
    }

}

fun getCaffeineLabel(context: Context, value: Int?): String {

    return when (value) {
        0 -> context.resources.getString(R.string.caffeine_lowest_value)
        1 -> context.resources.getString(R.string.caffeine_low_value)
        2 -> context.resources.getString(R.string.caffeine_medium_value)
        3 -> context.resources.getString(R.string.caffeine_high_value)
        4 -> context.resources.getString(R.string.caffeine_highest_value)
        else -> ""
    }

}