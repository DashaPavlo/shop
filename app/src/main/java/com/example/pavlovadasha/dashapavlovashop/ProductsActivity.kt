package com.example.pavlovadasha.dashapavlovashop

import android.content.Context
import android.graphics.Typeface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.TextUtils
import android.text.TextUtils.*
import android.view.Gravity
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import kotlinx.coroutines.experimental.*
import kotlinx.coroutines.experimental.android.Main
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JSON
import okhttp3.Dispatcher
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import org.jetbrains.anko.*
import org.jetbrains.anko.custom.customView
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.kodein.di.direct
import org.kodein.di.generic.instance

class ProductsActivity : AppCompatActivity() {

    val requestMaker: RequestMaker = di.direct.instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        GlobalScope.launch(Dispatchers.Main) {

            frameLayout {
                progressBar {

                }.lparams {
                    gravity = Gravity.CENTER
                }

            }
            val categoryJson = intent.getStringExtra("category")
            val category: Category = JSON.parse(categoryJson)

            val json = async(Dispatchers.IO) {
                requestMaker.make(category.url)
            }.await()

            val accessories: ProductsList = JSON.parse(json)

            verticalLayout {
                customView<HeaderView> {
                    titleView.text = category.title
                }.lparams {
                    gravity = Gravity.CENTER
                }

                recyclerView {
                    layoutManager = GridLayoutManager(this@ProductsActivity, 2)
                    adapter = ProductsAdapter(products = accessories.products, context = this@ProductsActivity)
                }.lparams {
                    margin = dip(25)
                    width = matchParent
                    height = matchParent
                }
            }


        }

    }

    @Serializable
    class Product(
            val title: String,
            val price: Double,
            val pictureUrl: String,
            val description: String)


    @Serializable
    class ProductsList(
            val products: List<Product>
    )

    //
    class ProductViewHolder(val view: ProductView) : RecyclerView.ViewHolder(view)

    class ProductsAdapter(val products: List<Product>,
                          val context: Context) : RecyclerView.Adapter<ProductViewHolder>() {
        override fun onCreateViewHolder(recyclerView: ViewGroup, viewType: Int) = run {
            val itemView = ProductView(context)

            ProductViewHolder(view = itemView)
        }

        //
        override fun getItemCount() = products.size

        override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
            val marginLayoutParams = holder.view.layoutParams as ViewGroup.MarginLayoutParams
            marginLayoutParams.marginStart = if (position % 2 == 1) context.dip(10) else context.dip(5)
            marginLayoutParams.marginEnd = if (position % 2 == 0) context.dip(10) else context.dip(5)
            holder.view.requestLayout()

            val product = products[position]

            holder.view.titleView.text = product.title

            holder.view.priceView.text = product.price.toString()


            holder.view.onClick {
                val json = JSON.stringify(product)
                context.startActivity<ProductsDetailsActivity>(
                        "product" to json
                )
            }


            Picasso.get().load(product.pictureUrl).into(holder.view.pictureView);

        }

    }

    class ProductView(context: Context) : FrameLayout(context) {
        lateinit var titleView: TextView
        lateinit var priceView: TextView
        lateinit var pictureView: ImageView

        init {
            layoutParams = LayoutParams(matchParent, wrapContent)

            verticalLayout {
                pictureView = imageView {

                }.lparams {
                    width = matchParent
                    height = dip(200)
                }

                verticalLayout {
                    titleView = textView {
                        lines = 2 // всегда отображать 2 строки
                        ellipsize = TruncateAt.END // обрезать в конце многоточием
                        gravity = Gravity.CENTER
                    }.lparams {
                        width = matchParent
                        height = wrapContent
                    }
                    priceView = textView {
                        gravity = Gravity.CENTER
                    }.lparams {
                        gravity = Gravity.CENTER
                        width = matchParent
                        height = wrapContent
                    }
                }

            }
        }
    }
}






