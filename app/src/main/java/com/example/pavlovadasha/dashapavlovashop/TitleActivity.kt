package com.example.pavlovadasha.dashapavlovashop

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.LinearLayout
import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import org.jetbrains.anko.*

class TitleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

      //  if (Preferences.currentCategoryUrl != null) {
      //      startActivity<ProductsActivity>("category" to Preferences.currentCategoryUrl)
       // }


        frameLayout {

            verticalLayout {
                imageView {
                    imageResource = R.drawable.magazin

                }.lparams {
                    width = matchParent
                    height = matchParent
                    margin = dip(100)
                }

            }
            val gradient = GradientDrawable(
                    GradientDrawable.Orientation.TOP_BOTTOM,
                    intArrayOf(Color.parseColor("#FBE9E7"), Color.parseColor("#FFAB91"))
            )
            gradient.cornerRadius = 0f
            background = gradient
        }

        GlobalScope.launch {
            delay(3000)
            startActivity<MainActivity>()
        }


    }
}