package com.credithc.mademo.ama;


import com.credithc.module_goods.ama.GoodsApplicationLogic;
import com.credithc.module_goods.ama.GoodsRouterConnectService;
import com.credithc.module_home.ama.HomeApplicationLogic;
import com.credithc.module_mine.ama.MineApplicationLogic;
import com.credithc.module_mine.ama.MineRouterConnectService;
import com.credithc.module_settings.ama.SettingsApplicationLogic;
import com.credithc.module_settings.ama.SettingsRouterConnectService;
import com.spinytech.macore.MaApplication;
import com.spinytech.macore.router.WideRouter;

/**
 * Created by wanglei on 2016/11/29.
 */

public class MyApplication extends MaApplication {
    @Override
    public void initializeAllProcessRouter() {
        WideRouter.registerLocalRouter("com.credithc.mademo",MainRouterConnectService.class);
        WideRouter.registerLocalRouter("com.credithc.mademo:mine",MineRouterConnectService.class);
        WideRouter.registerLocalRouter("com.credithc.mademo:settings",SettingsRouterConnectService.class);
    }

    @Override
    protected void initializeLogic() {
        registerApplicationLogic("com.credithc.mademo",999, MainApplicationLogic.class);
        registerApplicationLogic("com.credithc.mademo",998, HomeApplicationLogic.class);
        registerApplicationLogic("com.credithc.mademo",997, GoodsApplicationLogic.class);
        registerApplicationLogic("com.credithc.mademo:mine",999, MineApplicationLogic.class);
        registerApplicationLogic("com.credithc.mademo:settings",999, SettingsApplicationLogic.class);

    }

    @Override
    public boolean needMultipleProcess() {
        return true;
    }
}
