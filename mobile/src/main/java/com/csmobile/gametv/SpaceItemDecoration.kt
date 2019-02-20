package com.csmobile.gametv

import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * Created by lff on 2018/12/21.
 */
class SpaceItemDecoration(space:Int):RecyclerView.ItemDecoration() {

    val mSpcae = space
    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        outRect.bottom = mSpcae
        outRect.left = mSpcae
    }
}