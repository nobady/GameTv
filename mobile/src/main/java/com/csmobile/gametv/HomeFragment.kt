package com.csmobile.gametv

import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Toast
import app.com.tvrecyclerview.TvRecyclerView
import com.alibaba.android.vlayout.DelegateAdapter
import com.alibaba.android.vlayout.LayoutHelper
import com.alibaba.android.vlayout.VirtualLayoutManager
import com.alibaba.android.vlayout.layout.GridLayoutHelper
import com.alibaba.android.vlayout.layout.LinearLayoutHelper
import com.alibaba.android.vlayout.layout.StaggeredGridLayoutHelper
import com.game.base.mvp.BaseFragment
import java.util.*

/**
 * Created by lff on 2018/12/26.
 */
class HomeFragment:BaseFragment() {

    companion object {
        fun newInstance(): HomeFragment {
            val fragment = HomeFragment()
            return fragment
        }
    }

    private val imgSrcs1 = intArrayOf(R.mipmap.home1,R.mipmap.home2,R.mipmap.home3,R.mipmap.home4,R.mipmap.home5,R.mipmap.home6)
    private val imgSrcs2 = intArrayOf(R.mipmap.home21,R.mipmap.home22,R.mipmap.home23,R.mipmap.home24,R.mipmap.home25,R.mipmap.home26,R.mipmap.home27)

    private val layoutHelperList = LinkedList<LayoutHelper>()
    private val layoutHelperList1 = LinkedList<LayoutHelper>()
    override fun initView(view: View) {
        initFirstRecycler(view)
        initSecondRecycler(view)
    }

    private fun initSecondRecycler(view: View) {
        val recyclerView: TvRecyclerView = view.findViewById(R.id.tv_recycler_view1)

        val layoutParams = recyclerView.layoutParams
        layoutParams.height = resources.getDimensionPixelSize(R.dimen.recyclerview_item_height21)
        recyclerView.layoutParams = layoutParams

        val layoutManager = VirtualLayoutManager(context!!)
        layoutManager.orientation = VirtualLayoutManager.HORIZONTAL
        recyclerView.layoutManager = layoutManager

        val space = resources.getDimensionPixelSize(R.dimen.recyclerView_item_space)
        recyclerView.addItemDecoration(SpaceItemDecoration(space))
        recyclerView.setSelectPadding(25, 24, 25, 28)

        val linearLayoutHelper = LinearLayoutHelper()
        layoutHelperList1.add(linearLayoutHelper)

        layoutManager.setLayoutHelpers(layoutHelperList1)

        val adapter = HomeAdapter2(layoutManager,context!!)
        adapter.imgSrc = imgSrcs2
        recyclerView.adapter = adapter
    }


    private fun initFirstRecycler(view: View) {
        val recyclerView: TvRecyclerView = view.findViewById(R.id.tv_recycler_view)

        val layoutParams = recyclerView.layoutParams
        layoutParams.height = resources.getDimensionPixelSize(R.dimen.recyclerview_item)
        recyclerView.layoutParams = layoutParams
        recyclerView.setFocusDrawable(resources.getDrawable(R.drawable.fousc))

        val layoutManager = VirtualLayoutManager(context!!)
        layoutManager.orientation = VirtualLayoutManager.HORIZONTAL
        recyclerView.layoutManager = layoutManager

        val space = resources.getDimensionPixelSize(R.dimen.recyclerView_item_space)
        recyclerView.addItemDecoration(SpaceItemDecoration(space))
        recyclerView.setSelectPadding(1, 1, 1, 1)

        recyclerView.setOnItemStateListener(object : TvRecyclerView.OnItemStateListener {
            override fun onItemViewClick(view: View?, position: Int) {
                Toast.makeText(context, "点击", Toast.LENGTH_SHORT).show()
            }

            override fun onItemViewFocusChanged(gainFocus: Boolean, view: View?, position: Int) {
                Toast.makeText(context, "聚焦$position", Toast.LENGTH_SHORT).show()
            }
        })

        val gridLayoutHelper = GridLayoutHelper(3)
        gridLayoutHelper.itemCount = 1

        val staggeredGridLayoutHelper = StaggeredGridLayoutHelper(2)
        staggeredGridLayoutHelper.itemCount = 3

        val linearLayoutHelper = LinearLayoutHelper()
        linearLayoutHelper.itemCount = 2

        layoutHelperList.add(staggeredGridLayoutHelper)
        layoutHelperList.add(linearLayoutHelper)
        layoutHelperList.add(gridLayoutHelper)

        layoutManager.setLayoutHelpers(layoutHelperList)

        val adapter = HomeAdapter(layoutManager, context!!)
        adapter.imgSrc = imgSrcs1
        recyclerView.adapter = adapter
    }

    override fun lazyLoadData() {
    }

    override fun getLayoutId() = R.layout.frag_home
}