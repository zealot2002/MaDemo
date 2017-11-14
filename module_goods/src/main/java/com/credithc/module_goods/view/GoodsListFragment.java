package com.credithc.module_goods.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.credithc.module_goods.GoodsContract;
import com.credithc.module_goods.R;
import com.credithc.module_goods.model.GoodsBean;
import com.credithc.module_goods.presenter.GoodsPresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell-7020 on 2017/11/13.
 */

public class GoodsListFragment extends Fragment implements GoodsContract.View, View.OnClickListener {

    private View view;
    private GoodsContract.Presenter presenter;

    private List<GoodsBean> goodsList = new ArrayList<>();
    private RecyclerView rvGoodsList;
    private GoodsListAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.goods_list_fragment, container, false);
        presenter = new GoodsPresenter(this);
        presenter.getGoodsList();
        return view;
    }

    @Override
    public void refreshGoodsList(List<GoodsBean> goodsList) {
        this.goodsList = goodsList;
        findViews();
    }

    public void findViews() {
        rvGoodsList = (RecyclerView) view.findViewById(R.id.rvGoodsList);
        rvGoodsList.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new GoodsListAdapter(R.layout.goods_list_item,goodsList,this);
        rvGoodsList.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
    @Override
    public void showLoading() {

    }

    @Override
    public void closeLoading() {

    }

    @Override
    public void showDisconnect(String s) {

    }

    @Override
    public void showError(String s) {

    }

    @Override
    public void updateUI(Object o) {

    }

    @Override
    public void setPresenter(Object o) {

    }

    @Override
    public void onClick(View v) {

    }
}
