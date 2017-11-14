package com.credithc.module_home.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.credithc.module_home.R;
import com.spinytech.macore.MaApplication;
import com.spinytech.macore.router.LocalRouter;
import com.spinytech.macore.router.RouterRequest;
import com.spinytech.macore.router.RouterResponse;

public class HomeActivity extends AppCompatActivity {
    private Fragment[] fragments;
    private Button[] mTabs;
    private int currentTabIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        currentTabIndex = 0;
        initTabButton();
        initFragment();
        showFragment(0);
    }

    private Fragment getGoodsListFragment(){
        try {
            RouterResponse response = LocalRouter.getInstance(MaApplication.getMaApplication())
                    .route(HomeActivity.this, RouterRequest.obtain(HomeActivity.this)
                            .provider("goods")
                            .action("goodsListFragment"));
            if(response.getObject() instanceof Fragment){
                return (Fragment) response.getObject();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Fragment();
    }
    private void initFragment() {
        fragments = new Fragment[] { new HomeFragment(), getGoodsListFragment(), getGoodsListFragment() };
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, fragments[0]).show(fragments[0]).commitAllowingStateLoss();
    }

    private void initTabButton() {
        mTabs = new Button[3];
        mTabs[0] = (Button) findViewById(R.id.btnMain);
        mTabs[1] = (Button) findViewById(R.id.btnOrder);
        mTabs[2] = (Button) findViewById(R.id.btnMine);

        mTabs[0].setSelected(true);
    }
    public void onTabClicked(View view) {
        int selected = 0;
        if (view.getId() == R.id.btnMain){
            selected = 0;
        }else if(view.getId() == R.id.btnOrder){
            selected = 1;
        }else if(view.getId() == R.id.btnMine){
            selected = 2;
        }
        showFragment(selected);
    }

    private void showFragment(int index){
        if (currentTabIndex != index) {
            FragmentTransaction trx = getSupportFragmentManager().beginTransaction();
            trx.hide(fragments[currentTabIndex]);
            if (!fragments[index].isAdded()) {
                trx.add(R.id.fragment_container, fragments[index]);
            }
            trx.show(fragments[index]).commitAllowingStateLoss();
        }
        mTabs[currentTabIndex].setSelected(false);
        // 把当前tab设为选中状态
        mTabs[index].setSelected(true);
        currentTabIndex = index;
    }
}
