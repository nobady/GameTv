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
class HomeAdapter2(layoutManager: VirtualLayoutManager,context: Context):VirtualLayoutAdapter<HomeAdapter2.HomeViewHolder>(layoutManager) {

    lateinit var imgSrc:IntArray
    var mContext:Context = context

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): HomeAdapter2.HomeViewHolder {
        val view = View.inflate(parent.context, R.layout.adapter_home_item, null)
        return HomeViewHolder(view)
    }

    override fun getItemCount(): Int  = imgSrc.size

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val context = holder.imageView.context
        val layoutParams = holder.imageView.layoutParams
        layoutParams.width = mContext.dip2Px(R.dimen.recyclerview_item_width21)
        layoutParams.height = mContext.dip2Px(R.dimen.recyclerview_item_height21)
        holder.imageView.layoutParams = layoutParams
        ImageUtil.showImage(context,holder.imageView,imgSrc[position],imgSrc[position])
    }

    inner class HomeViewHolder(view: View):RecyclerView.ViewHolder(view){
        val imageView = view.iv
    }
}

private fun Context.dip2Px(dpValue: Int) = resources.getDimensionPixelSize(dpValue)
