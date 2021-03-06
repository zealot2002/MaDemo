package com.credithc.module_goods.ama.action;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.credithc.module_goods.view.GoodsActivity;
import com.spinytech.macore.MaAction;
import com.spinytech.macore.MaActionResult;

import java.util.HashMap;


public class GoodsAction extends MaAction {
    private final String TAG="GoodsAction";
    @Override
    public boolean isAsync(Context context, HashMap<String, String> requestData) {
        return false;
    }

    @Override
    public MaActionResult invoke(Context context, HashMap<String, String> requestData) {
        Log.e(TAG,"GoodsAction invoke");
//        String isBigString = requestData.get("is_big");
//        boolean isBig = "1".equals(isBigString);
        if(context instanceof Activity){
            Intent i = new Intent(context, GoodsActivity.class);
            context.startActivity(i);
        }else{
            Intent i = new Intent(context, GoodsActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        }
        return new MaActionResult.Builder().code(MaActionResult.CODE_SUCCESS).msg("success").data("").build();
    }
}
