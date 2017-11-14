package com.credithc.module_goods.model;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.zzy.aframwork.network.HttpUtil;
import org.zzy.aframwork.network.util.HttpConstant;
import org.zzy.aframwork.network.util.HttpInterface;
import org.zzy.aframwork.network.util.NetDataInvalidException;
import org.zzy.aframwork.network.util.RequestCtx;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by dell-7020 on 2017/11/14.
 */

public class DataProvider {
    public static void getGoodsList(HttpInterface.DataCallback callback) {
        LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();

        String url = com.credithc.module_goods.constant.HttpConstant.SERVER_URL + "/"+com.credithc.module_goods.constant.HttpConstant.GET_GOODS_LIST;
        RequestCtx ctx = new RequestCtx.Builder(map)
                .methodAndUrl(HttpConstant.HTTP_METHOD_GET, url)
                .callback(callback)
                .jsonParser(getGoodsListJsonParser)
                .validator(getGoodsListValidator)
                .build();
        try {
            HttpUtil.getInstance().request(ctx);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static HttpInterface.JsonParser getGoodsListJsonParser = new HttpInterface.JsonParser() {
        @Override
        public Object[] parse(String str) throws JSONException {
            List<GoodsBean> dataList = new ArrayList<>();
            JSONTokener jsonParser = new JSONTokener(str);
            JSONObject obj = (JSONObject) jsonParser.nextValue();
            int errno = obj.getInt("errorCode");
            if (errno == 0) {
                JSONArray goodsList = obj.getJSONArray("data");
                for (int i = 0; i < goodsList.length(); i++) {
                    JSONObject goodsObj = (JSONObject) goodsList.get(i);
                    GoodsBean bean = new GoodsBean();
                    bean.setName(goodsObj.getString("name"));
                    bean.setPrice(goodsObj.getInt("price"));
                    dataList.add(bean);
                }
            } else {
                String msg = obj.getString("errorMessage");
                return new Object[]{HttpConstant.FAIL,msg};
            }
            return new Object[]{HttpConstant.SUCCESS,dataList};
        }
    };
    private static HttpInterface.Validator getGoodsListValidator = new HttpInterface.Validator() {
        @Override
        public void validate(Object o) throws NetDataInvalidException {
            List<GoodsBean> dataList = (List<GoodsBean>) o;
            //check something..
            //and throw new NetDataInvalidException()
        }
    };
}
