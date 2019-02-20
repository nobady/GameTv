package com.csmobile.gametv

import android.os.Bundle
import android.view.View
import com.game.base.mvp.BaseFragment

/**
 * Created by lff on 2018/12/26.
 */
class ClassifyFragment():BaseFragment() {


    companion object {
        fun getIntance(type:Int): ClassifyFragment {
            val bundle = Bundle()
            bundle.putInt("type",type)
            val fragment = ClassifyFragment()
            fragment.arguments = bundle

            return fragment
        }
    }

    override fun initView(view: View) {
    }

    override fun lazyLoadData() {
    }

    override fun getLayoutId() = R.layout.frag_classify
}