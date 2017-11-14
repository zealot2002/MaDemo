package com.credithc.module_goods.presenter;

import android.support.annotation.NonNull;
import com.credithc.module_goods.GoodsContract;
import com.credithc.module_goods.model.DataProvider;
import com.credithc.module_goods.model.GoodsBean;
import com.spinytech.macore.MaApplication;

import org.zzy.aframwork.network.util.HttpConstant;
import org.zzy.aframwork.network.util.HttpInterface;
import org.zzy.aframwork.util.CommonUtil;

import java.util.List;


public class GoodsPresenter implements GoodsContract.Presenter{
    private final GoodsContract.View view;

/****************************************************************************************************/
    public GoodsPresenter(@NonNull GoodsContract.View view) {
        this.view = view;
        this.view.setPresenter(this);
    }
    @Override
    public void start() {
    }
    public void getGoodsList() {
        if (!CommonUtil.isNetWorkConnected(MaApplication.getMaApplication())) {
            view.showDisconnect("请检查您的网络再试");
        }
        view.showLoading();
        DataProvider.getGoodsList(new HttpInterface.DataCallback() {
            @Override
            public void requestCallback(int result, final Object data, Object tagData) {
                view.closeLoading();
                if (result == HttpConstant.SUCCESS) {
                    view.refreshGoodsList((List<GoodsBean>) data);
                } else {
                    view.showError(data.toString());
                }
            }
        });
    }
}
