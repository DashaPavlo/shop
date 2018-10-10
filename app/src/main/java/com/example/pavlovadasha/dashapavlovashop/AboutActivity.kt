package com.example.pavlovadasha.dashapavlovashop

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.view.Gravity
import android.widget.LinearLayout
import kotlinx.android.synthetic.*
import org.jetbrains.anko.*
import org.w3c.dom.Text

class AboutActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        frameLayout {

            linearLayout {
                orientation = LinearLayout.VERTICAL

                button {

                    backgroundColor = Color.BLUE
                }.lparams {
                    gravity = Gravity.CENTER
                    gravity = Gravity.TOP
                    height = dip(100)
                    width = dip(100)
                    margin = dip(150)
                    topMargin = dip(25)

                }
                textView {
                    text = "НАЗВАНИЕ МАГАЗИНА"
                    textSize = 28f

                }.lparams {
                    margin = dip(25)
                    topMargin= dip (-50)
                }
                textView {
                    text = "Павлова Дарья"
                    textSize = 20f
                }.lparams {
                    margin = dip(25)
                    bottomMargin =dip (20)
                }
                textView {
                    text = "Dashapavlo1994@mail.ru"

                    textSize = 20f
                    textColor = Color.CYAN
                }.lparams {
                margin = dip(25)
            }
                textView {
                    text = "IT SCHOOL RUSSIA 2018"
                    textSize = 18f
                }.lparams {
                    gravity=Gravity.BOTTOM
                    margin = dip(10)
                    gravity= Gravity.END
                }
                textView {
                    text = "#ХОЧУВАЙТИ"
                    textSize = 24f
                    textColor = Color.MAGENTA
                }.lparams {
                    gravity=Gravity.BOTTOM
                    margin = dip(10)
                    gravity= Gravity.END

                }
            }

        }
    }
}
