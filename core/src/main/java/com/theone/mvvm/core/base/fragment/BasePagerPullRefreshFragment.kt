package com.theone.mvvm.core.base.fragment

import androidx.databinding.ViewDataBinding
import com.qmuiteam.qmui.widget.pullRefreshLayout.QMUICenterGravityRefreshOffsetCalculator
import com.qmuiteam.qmui.widget.pullRefreshLayout.QMUIPullRefreshLayout.OnPullListener
import com.theone.mvvm.core.base.viewmodel.BaseListViewModel
import com.theone.mvvm.core.widge.loadsir.callback.ErrorCallback
import com.theone.mvvm.core.widge.pullrefresh.PullRefreshLayout

//  ┏┓　　　┏┓
//┏┛┻━━━┛┻┓
//┃　　　　　　　┃
//┃　　　━　　　┃
//┃　┳┛　┗┳　┃
//┃　　　　　　　┃
//┃　　　┻　　　┃
//┃　　　　　　　┃
//┗━┓　　　┏━┛
//    ┃　　　┃                  神兽保佑
//    ┃　　　┃                  永无BUG！
//    ┃　　　┗━━━┓
//    ┃　　　　　　　┣┓
//    ┃　　　　　　　┏┛
//    ┗┓┓┏━┳┓┏┛
//      ┃┫┫　┃┫┫
//      ┗┻┛　┗┻┛
/**
 * @author The one
 * @date 2021-04-08 09:04
 * @describe RecyclerView分页显示基类
 * @email 625805189@qq.com
 * @remark 给定了默认的下拉刷新控件 PullRefreshLayout
 */
abstract class BasePagerPullRefreshFragment<T, VM : BaseListViewModel<T>, DB : ViewDataBinding> :
    BasePagerAdapterFragment<T, VM, DB>(),
    OnPullListener {

    abstract fun getRefreshLayout(): PullRefreshLayout?

    override fun initRefreshView() {
        getRefreshLayout()?.run {
            setDragRate(0.5f)
            setRefreshOffsetCalculator(QMUICenterGravityRefreshOffsetCalculator())
            setOnPullListener(this@BasePagerPullRefreshFragment)
            isEnabled = false
        }
    }

    override fun onMoveTarget(offset: Int) {

    }

    override fun onMoveRefreshView(offset: Int) {

    }

    override fun onAutoRefresh() {
        if (getLoadSir()?.currentCallback is ErrorCallback) {
            onPageReLoad()
        } else {
            // 这里要调用PullRefreshLayout的主动刷新方法，后会自动回到到onRefresh 方法请求数据
            getRefreshLayout()?.setToRefreshDirectly()
        }
    }

    override fun setRefreshLayoutEnabled(enabled: Boolean) {
        getRefreshLayout()?.run {
            isEnabled = enabled
            finishRefresh()
        }
    }

}