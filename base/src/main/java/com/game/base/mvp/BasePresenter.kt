package com.game.base.mvp

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import java.lang.RuntimeException

/**
 * Created by lff on 2018/12/19.
 */
open class BasePresenter<T: IBaseView>: IPresenter<T> {
    var mRootView:T? = null

    private val composiDisposable by lazy { CompositeDisposable() }

    override fun attachView(mRootView: T) {
        this.mRootView = mRootView
    }

    override fun detachView() {
        mRootView = null

        if (!composiDisposable.isDisposed){
            composiDisposable.clear()
        }
    }

    private val isViewAttached:Boolean get() = mRootView!=null

    fun checkViewAttached(){
        if (!isViewAttached) throw MvpViewNoAttachedException()
    }

    fun addSubScription(d:Disposable){
        composiDisposable.add(d)
    }

    private class MvpViewNoAttachedException internal constructor():RuntimeException("请调用IPresenter.attachView(IBaseView)")
}