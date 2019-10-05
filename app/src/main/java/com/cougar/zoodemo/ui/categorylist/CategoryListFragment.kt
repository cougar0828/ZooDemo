package com.cougar.zoodemo.ui.categorylist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cougar.zoodemo.R
import com.cougar.zoodemo.adapter.categorylist.CategoryListAdapter
import com.cougar.zoodemo.viewmodel.CategoryListFactory
import com.cougar.zoodemo.viewmodel.CategoryListViewModel

class CategoryListFragment : Fragment() {

    lateinit var mCateViewModel: CategoryListViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        mCateViewModel =
//            ViewModelProviders.of(this).get(CategoryListViewModel::class.java)

        val root = inflater.inflate(R.layout.fragment_catelist, container, false)
//        val textView: TextView = root.findViewById(R.id.text_catelist)
        val recyclerView: RecyclerView = root.findViewById(R.id.rcv_categoryList)
//        val goMix: Button = root.findViewById(R.id.btn_gomix)

        recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        var adapter = CategoryListAdapter(context, this)
        recyclerView.adapter = adapter

        mCateViewModel =
            ViewModelProviders.of(this, CategoryListFactory(activity!!.application, adapter, this)).get(CategoryListViewModel::class.java)

//        mCateViewModel = CategoryListViewModel(adapter, this)

//        goMix.setOnClickListener {
//            findNavController().navigate(R.id.action_nav_categorylisy_to_nav_mixpage)
//        }
        return root
    }
}