package com.credithc.module_home.ama;

import com.credithc.module_home.ama.action.HomeAction;
import com.credithc.module_home.ama.action.HomeResultAction;
import com.spinytech.macore.MaProvider;

public class HomeProvider extends MaProvider {
    @Override
    protected void registerActions() {
        registerAction("home",new HomeAction());
        registerAction("testResult",new HomeResultAction());


    }
}
