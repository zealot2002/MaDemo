package com.credithc.module_goods.view;

import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.credithc.module_goods.R;
import com.credithc.module_goods.model.GoodsBean;

import java.util.List;

public class GoodsListAdapter extends BaseQuickAdapter<GoodsBean, BaseViewHolder> {
    private View.OnClickListener onClickListener;
    /********************************************************************************************************/
    public GoodsListAdapter(int layoutResId, List data,View.OnClickListener onClickListener) {
        super(layoutResId, data);
        this.onClickListener = onClickListener;
    }
    @Override
    protected void convert(BaseViewHolder helper, GoodsBean item) {
        helper.setText(R.id.tvName,item.getName());
        helper.setText(R.id.tvPrice,item.getPrice()+"");
    }
}
