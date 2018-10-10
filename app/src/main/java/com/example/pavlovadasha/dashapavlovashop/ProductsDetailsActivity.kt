package com.example.pavlovadasha.dashapavlovashop

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.serialization.json.JSON
import org.jetbrains.anko.textView
import org.jetbrains.anko.verticalLayout

class ProductsDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

val json= intent.getStringExtra ("product")
        val product : ProductsActivity.Product = JSON.parse(json)
        verticalLayout {
            textView {
                text=product.title

            }
            textView {
                text=product.price.toString()

            }
        }
    }

}
