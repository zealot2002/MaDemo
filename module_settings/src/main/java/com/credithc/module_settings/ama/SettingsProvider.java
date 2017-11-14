package com.credithc.module_settings.ama;

import com.spinytech.macore.MaProvider;

public class SettingsProvider extends MaProvider {
    @Override
    protected void registerActions() {
        registerAction("settings",new SettingsAction());
    }
}
