package com.csmobile.gametv

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import com.alibaba.android.vlayout.DelegateAdapter
import com.alibaba.android.vlayout.LayoutHelper
import com.alibaba.android.vlayout.VirtualLayoutAdapter
import com.alibaba.android.vlayout.VirtualLayoutManager
import com.game.base.image.ImageUtil
import kotlinx.android.synthetic.main.adapter_home_item.view.*

/**
 * Created by lff on 2018/12/20.
 */
class HomeAdapter(layoutManager: VirtualLayoutManager,context: Context):VirtualLayoutAdapter<HomeAdapter.HomeViewHolder>(layoutManager) {

    lateinit var imgSrc:IntArray
    var mContext:Context = context

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): HomeViewHolder {
        val view = View.inflate(parent.context, R.layout.adapter_home_item, null)
        return HomeViewHolder(view)
    }

    override fun getItemCount(): Int  = imgSrc.size

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val context = holder.imageView.context
        val layoutParams = holder.imageView.layoutParams
        when (position % 6) {
            0 -> {
                layoutParams.width = mContext.dip2Px(R.dimen.recyclerview_item_width0)
                layoutParams.height = mContext.dip2Px(R.dimen.recyclerview_item_height0)
            }
            1,2 -> {
                layoutParams.width = mContext.dip2Px(R.dimen.recyclerview_item_width11)
                layoutParams.height = mContext.dip2Px(R.dimen.recyclerview_item_height11)
            }
            3,4 -> {
                layoutParams.width = mContext.dip2Px(R.dimen.recyclerview_item_width2)
                layoutParams.height = mContext.dip2Px(R.dimen.recyclerview_item_height2)
            }
            5 -> {
                layoutParams.width = mContext.dip2Px(R.dimen.recyclerview_item_width3)
                layoutParams.height = mContext.dip2Px(R.dimen.recyclerview_item_height2)
            }
        }
        holder.imageView.layoutParams = layoutParams
        ImageUtil.showImage(context,holder.imageView,imgSrc[position],imgSrc[position])
    }

    inner class HomeViewHolder(view: View):RecyclerView.ViewHolder(view){
        val imageView = view.iv
    }
}

private fun Context.dip2Px(dpValue: Int) = resources.getDimensionPixelSize(dpValue)
