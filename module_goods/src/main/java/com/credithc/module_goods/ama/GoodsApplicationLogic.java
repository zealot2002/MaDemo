package com.credithc.module_goods.ama;

import com.spinytech.macore.multiprocess.BaseApplicationLogic;
import com.spinytech.macore.router.LocalRouter;

public class GoodsApplicationLogic extends BaseApplicationLogic {

    @Override
    public void onCreate() {
        super.onCreate();
        LocalRouter.getInstance(mApplication).registerProvider("goods",new GoodsProvider());
    }
}
