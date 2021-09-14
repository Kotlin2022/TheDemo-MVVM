package com.theone.demo.viewmodel

import com.theone.demo.data.model.bean.ClassifyResponse
import com.theone.demo.app.net.Url
import com.theone.demo.data.repository.ApiRepository
import com.theone.mvvm.core.ext.request
import com.theone.mvvm.core.base.viewmodel.BaseRequestViewModel
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
 * @date 2021/3/2 0002
 * @describe 微信公众号
 * @email 625805189@qq.com
 * @remark
 */
class WxGzhRequestViewModel : BaseRequestViewModel<List<ClassifyResponse>>() {

    override fun requestServer() {
        request({
            onSuccess(ApiRepository().getWxGzh(getCacheMode(true)))
        })
    }

}