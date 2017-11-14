package com.credithc.module_mine.ama.action;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.credithc.module_mine.view.MineActivity;
import com.credithc.module_mine.view.OomActivity;
import com.spinytech.macore.MaAction;
import com.spinytech.macore.MaActionResult;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class OomAction extends MaAction {
    private final String TAG="MineAction";
    private static List<Bitmap> oomList = new ArrayList<>();
    @Override
    public boolean isAsync(Context context, HashMap<String, String> requestData) {
        return false;
    }

    @Override
    public MaActionResult invoke(Context context, HashMap<String, String> requestData) {
        Log.e(TAG,"MineAction invoke");
        if(context instanceof Activity){
            Intent i = new Intent(context, OomActivity.class);
            context.startActivity(i);
        }else{
            Intent i = new Intent(context, OomActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        }
        return new MaActionResult.Builder().code(MaActionResult.CODE_SUCCESS).msg("success").data("").build();
    }
}
