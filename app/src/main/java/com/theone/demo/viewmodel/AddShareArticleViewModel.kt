package com.theone.demo.viewmodel

import com.theone.demo.app.net.Url
import com.theone.demo.data.repository.ApiRepository
import com.theone.mvvm.core.ext.request
import com.theone.mvvm.core.base.viewmodel.BaseRequestViewModel
import com.theone.mvvm.callback.databind.StringObservableField
import rxhttp.wrapper.param.RxHttp
import rxhttp.wrapper.param.toResponse


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
 * @date 2021/3/18 0018
 * @describe TODO
 * @email 625805189@qq.com
 * @remark
 */
class AddShareArticleViewModel:BaseRequestViewModel<String>() {

    val title :StringObservableField = StringObservableField("")
    val url :StringObservableField = StringObservableField("")
    val publisher :StringObservableField = StringObservableField("")

    override fun requestServer() {
       request({
           onSuccess(ApiRepository().shareArticle(title.get(),url.get()))
       },"添加中")
    }
}