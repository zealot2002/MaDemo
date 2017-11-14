package com.credithc.module_goods;

import com.credithc.module_goods.model.GoodsBean;

import org.zzy.aframwork.base.BaseLoadingView;
import org.zzy.aframwork.base.BasePresenter;

import java.util.List;

/**
 * Created by dell-7020 on 2017/11/14.
 */

public class GoodsContract {
    public interface View extends BaseLoadingView<Presenter> {
        void refreshGoodsList(List<GoodsBean> goodsList);
    }

    public interface Presenter extends BasePresenter {
        void getGoodsList();
    }
}
