package com.example.pavlovadasha.dashapavlovashop

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.ImageView
import android.widget.LinearLayout
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        frameLayout {

            imageView {
                imageResource = R.drawable.backa
                scaleType = ImageView.ScaleType.CENTER_CROP
            }.lparams {
                width = matchParent
                height = matchParent
            }

            linearLayout {
                orientation = LinearLayout.VERTICAL


                button {
                    backgroundColor = Color.parseColor("#FBE9E7")

                    text = "Hats"
                    textColor = Color.parseColor("#000000")
                    typeface = Typeface.create(Typeface.createFromAsset(assets, "Madelina.ttf"), Typeface.BOLD)
                    textSize = 28f

                    onClick {
                        startActivity<ProductsActivity>()
                    }
                }.lparams {
                    gravity = Gravity.CENTER
                    height = dip(75)
                    width = dip(200)
                    margin = dip(10)
                    topMargin = dip(10)
                }
                linearLayout {
                    orientation = LinearLayout.VERTICAL


                    button {
                        backgroundColor = Color.parseColor("#FBE9E7")

                        text = "Socks"
                        textColor = Color.parseColor("#000000")
                        typeface = Typeface.create(Typeface.createFromAsset(assets, "Madelina.ttf"), Typeface.BOLD)
                        textSize = 28f

                        onClick {
                            startActivity<ProductsActivity>()
                        }
                    }.lparams {
                        gravity = Gravity.CENTER
                        height = dip(75)
                        width = dip(200)
                        margin = dip(10)
                        topMargin = dip(10)
                    }
                }
                linearLayout {
                    orientation = LinearLayout.VERTICAL


                    button {
                        backgroundColor = Color.parseColor("#FBE9E7")

                        text = "Accessories"
                        textColor = Color.parseColor("#000000")
                        typeface = Typeface.create(Typeface.createFromAsset(assets, "Madelina.ttf"), Typeface.BOLD)
                        textSize = 28f

                        onClick {
                            startActivity<CategoriesActivity>()
                        }
                    }.lparams {
                        gravity = Gravity.CENTER
                        height = dip(75)
                        width = dip(200)
                        margin = dip(10)
                        topMargin = dip(10)
                    }
                }
                linearLayout {
                    orientation = LinearLayout.VERTICAL


                    button {
                        backgroundColor = Color.parseColor("#FBE9E7")

                        text = "Glasses"
                        textColor = Color.parseColor("#000000")
                        typeface = Typeface.create(Typeface.createFromAsset(assets, "Madelina.ttf"), Typeface.BOLD)
                        textSize = 28f

                        onClick {
                            startActivity<ProductsActivity>()
                        }
                    }.lparams {
                        gravity = Gravity.CENTER
                        height = dip(75)
                        width = dip(200)
                        margin = dip(10)
                        topMargin = dip(10)
                    }
                }
                linearLayout {
                    orientation = LinearLayout.VERTICAL


                    button {
                        backgroundColor = Color.parseColor("#FBE9E7")

                        text = "bijouterie"
                        textColor = Color.parseColor("#000000")
                        typeface = Typeface.create(Typeface.createFromAsset(assets, "Madelina.ttf"), Typeface.BOLD)
                        textSize = 28f

                        onClick {
                            startActivity<ProductsActivity>()
                        }
                    }.lparams {
                        gravity = Gravity.CENTER
                        height = dip(75)
                        width = dip(200)
                        margin = dip(10)
                        topMargin = dip(10)
                    }


                }
            }.lparams {
                gravity = Gravity.CENTER
            }


        }

    }
}