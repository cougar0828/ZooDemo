package com.cougar.zoodemo.ui.mixpage

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cougar.zoodemo.MainActivity
import com.cougar.zoodemo.R
import com.cougar.zoodemo.adapter.mixpage.PlantListAdapter
import com.cougar.zoodemo.model.category.CategoryResultContent
import com.cougar.zoodemo.viewmodel.MixPageFactory
import com.cougar.zoodemo.viewmodel.MixPageViewModel

class MixPageFragment : Fragment() {

    val TAG = "@MixPageFragment"
    lateinit var mMixPageViewModel: MixPageViewModel
    lateinit var mArgs: CategoryResultContent

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
//        ViewModelProviders.of(this).get(MixPageViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_mixpage, container, false)
        val recyclerView: RecyclerView = root.findViewById(R.id.rcv_plantlist)
        val catePic: ImageView = root.findViewById(R.id.image_catepic)
        val cateInfo: TextView = root.findViewById(R.id.text_cateinfo)
        val pauseInfo: TextView = root.findViewById(R.id.text_pauseinfo)
        val cateZone: TextView = root.findViewById(R.id.text_catezone)

        mArgs = arguments?.let { MixPageFragmentArgs.fromBundle(it).categoryContent }!!

        recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        var adapter = PlantListAdapter(context)
        recyclerView.adapter = adapter

        mMixPageViewModel =
                ViewModelProviders.of(this, MixPageFactory(activity!!.application, adapter, mArgs))
                        .get(MixPageViewModel::class.java)

//        mMixPageViewModel = MixPageViewModel(adapter, mArgs)
        mMixPageViewModel.info.observe(this, Observer { cateInfo.text = it })
        mMixPageViewModel.pause.observe(this, Observer { pauseInfo.text = it })
        mMixPageViewModel.zone.observe(this, Observer { cateZone.text = it })
        mMixPageViewModel.picUrl.observe(this, Observer {
            Glide.with(this).load(it).into(catePic)
        })

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (view.context as MainActivity).title = mArgs.E_Name
    }
}