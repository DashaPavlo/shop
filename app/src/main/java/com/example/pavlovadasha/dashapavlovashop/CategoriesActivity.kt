package com.example.pavlovadasha.dashapavlovashop

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Gravity
import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout
import android.widget.LinearLayout
import kotlinx.coroutines.experimental.*
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JSON
import org.jetbrains.anko.*
import org.jetbrains.anko.custom.customView
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.kodein.di.direct
import org.kodein.di.generic.instance

class CategoriesActivity : AppCompatActivity() {

    private val requestMaker: RequestMaker = di.direct.instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        GlobalScope.launch(Dispatchers.Main) {

            frameLayout {
                progressBar {

                }.lparams {
                    gravity = Gravity.CENTER
                }
            }

            val json = async(Dispatchers.IO) {
                requestMaker.make("https://gist.githubusercontent.com/DashaPavlo/a2f984a089a5b3643935bab1dc26542c/raw/ac451e79749a9d0364ddcc985462f02abc54c2a7/gistfile1.txt")
            }.await()

            val categoriesList: CategoriesList = JSON.parse(json)

            verticalLayout {
                customView<HeaderView> {
                    titleView.text = "Categories"
                }.lparams {
                    gravity = Gravity.CENTER
                }
                recyclerView {
                    layoutManager = LinearLayoutManager(this@CategoriesActivity)
                    adapter = CategoriesAdapter(categoriesList.categories, this@CategoriesActivity)
                }
            }
        }
    }

}

class CategoriesAdapter(
        val categories: List<Category>,
        val context: Context
) : RecyclerView.Adapter<CategoryViewHolder>() {

    override fun getItemCount() = categories.size

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int) = run {
        val view = CategoryView(context)
        view.layoutParams = ViewGroup.LayoutParams(matchParent, wrapContent)
        CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = categories[position]
        holder.view.titleView.text = category.title
        holder.view.titleView.onClick {
            Preferences.currentCategoryUrl = category.url
            val categoryJson = JSON.stringify(category)
            context.startActivity<ProductsActivity>("category" to categoryJson)
        }
    }

}

class CategoryViewHolder(val view: CategoryView) : RecyclerView.ViewHolder(view)

@Serializable
class Category(
        val title: String,
        val url: String
)

@Serializable
class CategoriesList(
        val categories: List<Category>
)


class CategoryView(context: Context) : FrameLayout(context) {
    lateinit var titleView: Button

    init {
        linearLayout {
            orientation = LinearLayout.VERTICAL


            titleView = button {
                backgroundColor = Color.parseColor("#FBE9E7")
                textColor = Color.parseColor("#000000")
                typeface = Typeface.create(Typeface.createFromAsset(context.assets, "Madelina.ttf"), Typeface.BOLD)
                textSize = 28f
            }.lparams {
                gravity = Gravity.CENTER
                height = dip(75)
                width = dip(200)
                margin = dip(10)
                topMargin = dip(10)
            }
        }
    }
}

