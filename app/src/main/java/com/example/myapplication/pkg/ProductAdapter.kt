package com.example.myapplication.pkg

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import de.hdodenhof.circleimageview.CircleImageView
import java.util.ArrayList


class ProductAdapter(
    val context: Context,
    val imgList: ArrayList<Int>,
    var titleList: ArrayList<String>,
    var desList: ArrayList<String>
) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): ProductViewHolder {
        val itemView: View = LayoutInflater.from(context).inflate(
            R.layout.single_product, parent, false
        );
        // the third param is always false
        return ProductViewHolder(itemView);
    }

    override fun onBindViewHolder(
        holder: ProductViewHolder, position: Int
    ) {
        holder.title.text = titleList[position]
        holder.des.text = desList[position]
        holder.image.setImageResource(imgList[position])
    }

    override fun getItemCount(): Int {
        return imgList.size;
    }

    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image: CircleImageView = itemView.findViewById(R.id.profile_image)
        var title: TextView = itemView.findViewById(R.id.pTitle)
        var des: TextView = itemView.findViewById(R.id.pdes)

    }
}

//
//var imgList = ArrayList<Int>()
//var titleList = ArrayList<String>()
//var desList = ArrayList<String>()