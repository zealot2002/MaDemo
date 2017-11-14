package com.credithc.module_goods.ama.action;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.widget.Toast;

import com.credithc.module_goods.view.GoodsListFragment;
import com.spinytech.macore.MaAction;
import com.spinytech.macore.MaActionResult;

import java.util.HashMap;


public class GoodsListFragmentAction extends MaAction {
    private final String TAG="GoodsListFragmentAction";
    @Override
    public boolean isAsync(Context context, HashMap<String, String> requestData) {
        return false;
    }

    @Override
    public MaActionResult invoke(Context context, HashMap<String, String> requestData) {
        Log.e(TAG,"GoodsListFragmentAction invoke");
//
        Fragment f = new GoodsListFragment();
        return new MaActionResult.Builder().code(MaActionResult.CODE_SUCCESS).msg("success").object(f).build();
    }
}
