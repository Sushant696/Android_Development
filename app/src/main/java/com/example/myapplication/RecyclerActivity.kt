package com.example.myapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.pkg.ProductAdapter

class RecyclerActivity : AppCompatActivity() {
    lateinit var recycler: RecyclerView;
    var imgList = ArrayList<Int>()
    var titleList = ArrayList<String>()
    var desList = ArrayList<String>()


    lateinit var adapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recycler)

        recycler = findViewById(R.id.recycle);

        imgList.add(R.drawable.angorie)
        imgList.add(R.drawable.swappy_20241118_101924)
        imgList.add(R.drawable.node_js_express_login_mongodb_architecture)

        titleList.add("Angorie Rice");
        titleList.add("Spring Boot")
        titleList.add("Architecture")

        desList.add("Angourie Isabel Teresa Rice is an Australian actress. She began her career as a child actress.")
        desList.add("Node js is a javascript runtime, its is popular for backend development")
        desList.add("This is the node js architecture")


        adapter = ProductAdapter(
            this@RecyclerActivity, imgList, titleList, desList
        );

        recycler.adapter = adapter;
        recycler.layoutManager = GridLayoutManager(this@RecyclerActivity, 1)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}