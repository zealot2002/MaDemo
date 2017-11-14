package com.credithc.module_home.ama.action;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.credithc.module_home.view.HomeActivity;
import com.credithc.module_home.view.ResultActivity;
import com.spinytech.macore.MaAction;
import com.spinytech.macore.MaActionResult;

import java.util.HashMap;


public class HomeResultAction extends MaAction {
    private final String TAG="HomeResultAction";
    @Override
    public boolean isAsync(Context context, HashMap<String, String> requestData) {
        return false;
    }

    @Override
    public MaActionResult invoke(Context context, HashMap<String, String> requestData) {
        Log.e(TAG,"HomeResultAction invoke");
//        String isBigString = requestData.get("is_big");
//        boolean isBig = "1".equals(isBigString);
        if(context instanceof Activity){
            Intent i = new Intent(context, ResultActivity.class);
            ((Activity) context).startActivityForResult(i,1);//随便写一个，应该从requestData传进来
        }
        return new MaActionResult.Builder().code(MaActionResult.CODE_SUCCESS).msg("success").data("").build();
    }
}
