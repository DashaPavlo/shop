package com.example.pavlovadasha.dashapavlovashop

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.LinearLayout
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        frameLayout {

            verticalLayout {
                imageView {
                    imageResource = R.drawable.magazin

                }.lparams {
                    width = matchParent
                    height = matchParent
                    margin = dip(25)
                    gravity= Gravity.TOP
                    bottomMargin= dip(400)
                }
            }


            linearLayout {
                orientation = LinearLayout.VERTICAL

                editText {
                    hint = "Логин"
                    hintTextColor = Color.parseColor("#000000")
                    gravity = Gravity.CENTER
                    backgroundColor = Color.parseColor("#FBE9E7")

                }.lparams {
                    gravity = Gravity.CENTER
                    height = dip(50)
                    width = dip(200)
                    margin = dip(10)
                    topMargin = dip(10)
                }
                editText {
                    hint = "Пароль"
                    hintTextColor = Color.parseColor("#000000")
                    gravity = Gravity.CENTER
                    backgroundColor = Color.parseColor("#FBE9E7")

                }.lparams {
                    gravity = Gravity.CENTER
                    height = dip(50)
                    width = dip(200)
                    margin = dip(20)
                    topMargin = dip(10)
                }
            }.lparams {
                width = matchParent
                gravity = Gravity.CENTER
                margin = dip(50)
            }

            button {
                text = "Войти"
                backgroundColor = Color.parseColor("#FBE9E7")

                onClick {
                    startActivity<CategoriesActivity>()
                }
            }.lparams {
                height = dip(50)
                width = dip(200)
                gravity = Gravity.CENTER
                margin = dip(25)
                topMargin = dip(200)
            }

        }
    }


}
