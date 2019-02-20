package com.csmobile.gametv

import android.content.Context
import app.com.tvrecyclerview.ModuleLayoutManager

/**
 * Created by lff on 2018/12/20.
 */
class MyModuleLayout(context: Context,rowCount:Int,orienta:Int,baseItemWight:Int,baseItemHeight:Int)
    :ModuleLayoutManager(rowCount,orienta,baseItemWight,baseItemHeight) {


    var mContext:Context = context

    val startIndex = intArrayOf(0,2,5,6,9,12)
    val itemRowSizes = intArrayOf(2,1,1,3,3,3)
    val itemColumnSize = intArrayOf(2,1,1,1,1,1)

    val itemLeftOffset = intArrayOf(0,0,
        context.resources.getDimensionPixelSize(R.dimen.recyclerview_item_width11),
        context.resources.getDimensionPixelSize(R.dimen.recyclerview_item_width0),
        context.resources.getDimensionPixelSize(R.dimen.recyclerview_item_width2),
        context.resources.getDimensionPixelSize(R.dimen.recyclerview_item_width2)
        )
    val itemTopOffset = intArrayOf(0,context.resources.getDimensionPixelSize(R.dimen.recyclerview_item_height0),
        context.resources.getDimensionPixelSize(R.dimen.recyclerview_item_height0),
        0,0,0)

    val itemWidths = intArrayOf(context.resources.getDimensionPixelSize(R.dimen.recyclerview_item_width0),
        context.resources.getDimensionPixelSize(R.dimen.recyclerview_item_width11),
        context.resources.getDimensionPixelSize(R.dimen.recyclerview_item_width11),
        context.resources.getDimensionPixelSize(R.dimen.recyclerview_item_width2),
        context.resources.getDimensionPixelSize(R.dimen.recyclerview_item_width2),
        context.resources.getDimensionPixelSize(R.dimen.recyclerview_item_width3))

    val itemHeights = intArrayOf(context.resources.getDimensionPixelSize(R.dimen.recyclerview_item_height0),
        context.resources.getDimensionPixelSize(R.dimen.recyclerview_item_height11),
        context.resources.getDimensionPixelSize(R.dimen.recyclerview_item_height11),
        context.resources.getDimensionPixelSize(R.dimen.recyclerview_item_height2),
        context.resources.getDimensionPixelSize(R.dimen.recyclerview_item_height2),
        context.resources.getDimensionPixelSize(R.dimen.recyclerview_item_height3))

    override fun getItemColumnSize(position: Int): Int {
        return if (position<itemColumnSize.size) itemColumnSize[position] else 1
    }

    override fun getItemRowSize(position: Int): Int {
        return if (position<itemRowSizes.size) itemRowSizes[position] else 1
    }

    override fun getColumnSpacing(): Int {
        return mContext.resources.getDimensionPixelSize(R.dimen.recyclerView_item_space)
    }

    override fun getItemStartIndex(position: Int): Int {
        return if (position<startIndex.size) startIndex[position] else 0
    }

    override fun getRowSpacing(): Int {
        return mContext.resources.getDimensionPixelSize(R.dimen.recyclerView_item_space)
    }

    override fun getItemColumnWidth(position: Int) = itemWidths[position]

    override fun getItemColumnHeight(position: Int) = itemHeights[position]

    override fun getItemLeftOffsetWidth(position: Int) = itemLeftOffset[position]

    override fun getItemTopOffsetWidth(position: Int) = itemTopOffset[position]
}