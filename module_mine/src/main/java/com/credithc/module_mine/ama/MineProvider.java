package com.credithc.module_mine.ama;

import com.credithc.module_mine.ama.action.MineAction;
import com.credithc.module_mine.ama.action.OomAction;
import com.credithc.module_mine.ama.action.ShutdownAction;
import com.spinytech.macore.MaProvider;

public class MineProvider extends MaProvider {
    @Override
    protected void registerActions() {
        registerAction("mine",new MineAction());
        registerAction("shutdown",new ShutdownAction());
        registerAction("oom",new OomAction());
    }
}
