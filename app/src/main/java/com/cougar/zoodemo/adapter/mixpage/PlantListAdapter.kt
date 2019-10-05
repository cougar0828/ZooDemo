package com.cougar.zoodemo.adapter.mixpage

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cougar.zoodemo.R
import com.cougar.zoodemo.model.plant.PlantResultContent

class PlantListAdapter(var mContext: Context?) :
    RecyclerView.Adapter<PlantListAdapter.PlantListViewHolder>() {

    val TAG = "@PlantListAdapter"
    var mDataList = arrayListOf<PlantResultContent>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantListViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.element_catelist, parent, false)
        return PlantListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mDataList.size
    }

    override fun onBindViewHolder(holder: PlantListViewHolder, position: Int) {
        holder.bindTo(mDataList[position])
    }

    inner class PlantListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var name = itemView.findViewById<TextView>(R.id.text_catename)
        var intro = itemView.findViewById<TextView>(R.id.text_cateintro)
        var pause = itemView.findViewById<TextView>(R.id.text_pauseinfo)
        val pic = itemView.findViewById<ImageView>(R.id.image_catepic)

        fun bindTo(content: PlantResultContent) {
            name.text = content.F_Name_Ch
            intro.text = content.F_AlsoKnown
            pause.visibility = View.INVISIBLE

            if (!content.F_Pic01_URL.isNullOrEmpty())
                Glide.with(itemView.context).load(content.F_Pic01_URL)
                    .into(pic)
        }
    }
}