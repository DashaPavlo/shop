package com.example.pavlovadasha.dashapavlovashop

import android.content.Context
import android.graphics.Typeface
import android.widget.FrameLayout
import android.widget.TextView
import org.jetbrains.anko.dip
import org.jetbrains.anko.padding
import org.jetbrains.anko.textView

class HeaderView(context: Context) : FrameLayout(context) {
    lateinit var titleView: TextView

    init {
        titleView = textView {
            textSize = 45f
            typeface = Typeface.createFromAsset(context.assets, "Madelina.ttf")
        }
    }

}