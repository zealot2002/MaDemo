package com.credithc.module_mine.ama.action;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;


import com.credithc.module_mine.view.MineActivity;
import com.spinytech.macore.MaAction;
import com.spinytech.macore.MaActionResult;

import java.util.HashMap;


public class MineAction extends MaAction {
    private final String TAG="MineAction";
    @Override
    public boolean isAsync(Context context, HashMap<String, String> requestData) {
        return false;
    }

    @Override
    public MaActionResult invoke(Context context, HashMap<String, String> requestData) {
        Log.e(TAG,"MineAction invoke");
//        String isBigString = requestData.get("is_big");
//        boolean isBig = "1".equals(isBigString);
        if(context instanceof Activity){
            Intent i = new Intent(context, MineActivity.class);
            context.startActivity(i);
        }else{
            Intent i = new Intent(context, MineActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        }
        return new MaActionResult.Builder().code(MaActionResult.CODE_SUCCESS).msg("success").data("").build();
    }
}
