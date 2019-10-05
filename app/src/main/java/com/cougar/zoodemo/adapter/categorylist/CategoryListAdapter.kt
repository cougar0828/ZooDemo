package com.cougar.zoodemo.adapter.categorylist

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.cougar.zoodemo.R
import com.cougar.zoodemo.model.category.CategoryResultContent
import com.cougar.zoodemo.ui.categorylist.CategoryListFragment
import com.cougar.zoodemo.viewmodel.CategoryListViewModel

class CategoryListAdapter(var mContext: Context?, var frag : CategoryListFragment) :
    RecyclerView.Adapter<CategoryListAdapter.CategoryListViewHolder>() {

    val TAG = "@CategoryListAdapter"
    val mViewModel = CategoryListViewModel(this, frag)
    var mDataList = arrayListOf<CategoryResultContent>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryListViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.element_catelist, parent, false)
        return CategoryListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mDataList.size
    }

    override fun onBindViewHolder(holder: CategoryListViewHolder, position: Int) {
        holder.bindTo(mDataList[position])
    }

    inner class CategoryListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var name = itemView.findViewById<TextView>(R.id.text_catename)
        var intro = itemView.findViewById<TextView>(R.id.text_cateintro)
        var pause = itemView.findViewById<TextView>(R.id.text_pauseinfo)
        val pic = itemView.findViewById<ImageView>(R.id.image_catepic)

        fun bindTo(content: CategoryResultContent) {
            name.text = content.E_Name
            intro.text = content.E_Info

            if (content.E_Memo.isNotEmpty()) {
                pause.text = content.E_Memo
            } else {
                pause.text = "無休館資訊"
            }

            if (content.E_Pic_URL.isNotEmpty())
                Glide.with(itemView.context).load(content.E_Pic_URL)
                    .into(pic)

            itemView.setOnClickListener{
                Log.e(TAG, "要去這個館嗎？")
                mViewModel.itemClick(content)
            }
        }
    }
}