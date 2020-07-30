package com.destinyed.recyclerview.RecyclerViewHolder

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.destinyed.recyclerview.R

class viewAdapter(var ctx : Context, var arrList : ArrayList<viewModel>) : RecyclerView.Adapter<viewAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewAdapter.ViewHolder {
        var root = LayoutInflater.from(ctx).inflate(R.layout.custom_model, parent, false)

        return ViewHolder(root)
    }

    override fun getItemCount(): Int {
        return arrList.size
    }

    override fun onBindViewHolder(holder: viewAdapter.ViewHolder, position: Int) {
        return holder.bindItems(arrList[position])
    }


    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(list : viewModel) {
            var title = itemView.findViewById<TextView>(R.id.viewTitle)
            var subTitle = itemView.findViewById<TextView>(R.id.viewSubtitle)

            title.text = list.title
            subTitle.text = list.subTitle

            itemView.setOnClickListener {
                var titleText = list.title
                Toast.makeText(ctx, titleText, Toast.LENGTH_SHORT).show()
            }
        }
    }
}