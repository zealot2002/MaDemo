package com.credithc.module_goods.ama;

import com.credithc.module_goods.ama.action.GoodsAction;
import com.credithc.module_goods.ama.action.GoodsListFragmentAction;
import com.credithc.module_goods.ama.action.ShutdownAction;
import com.spinytech.macore.MaProvider;

public class GoodsProvider extends MaProvider {
    @Override
    protected void registerActions() {
        registerAction("shutdown",new ShutdownAction());
        registerAction("goodsListFragment",new GoodsListFragmentAction());
        registerAction("goods",new GoodsAction());
    }
}
