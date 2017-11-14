package com.credithc.mademo;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.spinytech.macore.MaApplication;
import com.spinytech.macore.router.LocalRouter;
import com.spinytech.macore.router.RouterRequest;
import com.spinytech.macore.router.RouterResponse;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";
    private Button btnOpenMine,btnOpenHome,btnOpenSettings,
            btnReleaseMine,btnOpenOOM,btnReleaseSettings,btnStartActivityForResult;

    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }

    private void findViews() {

        btnOpenMine = (Button) findViewById(R.id.btnOpenMine);
        btnOpenHome = (Button) findViewById(R.id.btnOpenHome);
        btnOpenSettings = (Button) findViewById(R.id.btnOpenSettings);
        btnReleaseMine = (Button) findViewById(R.id.btnReleaseMine);
        btnOpenOOM = (Button) findViewById(R.id.btnOpenOOM);
        btnReleaseSettings = (Button) findViewById(R.id.btnReleaseSettings);
        btnStartActivityForResult = (Button) findViewById(R.id.btnStartActivityForResult);

        btnOpenMine.setOnClickListener(this);
        btnOpenHome.setOnClickListener(this);
        btnOpenSettings.setOnClickListener(this);
        btnReleaseMine.setOnClickListener(this);
        btnOpenOOM.setOnClickListener(this);
        btnReleaseSettings.setOnClickListener(this);
        btnStartActivityForResult.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnOpenMine:
                try {
                    final RouterResponse response = LocalRouter.getInstance(MaApplication.getMaApplication())
                            .route(MainActivity.this, RouterRequest.obtain(MainActivity.this)
                                    .domain("com.credithc.mademo:mine")
                                    .provider("mine")
                                    .action("mine"));
                    Log.e(TAG,"response :"+response.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case R.id.btnOpenHome:
                try {
                    final RouterResponse response = LocalRouter.getInstance(MaApplication.getMaApplication())
                            .route(MainActivity.this, RouterRequest.obtain(MainActivity.this)
                                    .provider("home")
                                    .action("home"));
                    Log.e(TAG,"response :"+response.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case R.id.btnOpenSettings:
                try {
                    final RouterResponse response = LocalRouter.getInstance(MaApplication.getMaApplication())
                            .route(MainActivity.this, RouterRequest.obtain(MainActivity.this)
                                    .domain("com.credithc.mademo:settings")
                                    .provider("settings")
                                    .action("settings"));
                    Log.e(TAG,"response :"+response.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case R.id.btnReleaseMine:
                final long startTime = System.currentTimeMillis();
                try {
                    final RouterResponse response = LocalRouter.getInstance(MaApplication.getMaApplication())
                            .route(MainActivity.this, RouterRequest.obtain(MainActivity.this)
                                    .domain("com.credithc.mademo:mine")
                                    .provider("mine")
                                    .action("shutdown"));
                    response.isAsync();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                final String temp = response.getData();
                                final long time = System.currentTimeMillis() - startTime;
                                handler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        try {
                                            Toast.makeText(MainActivity.this, "async:" + response.isAsync()
                                                    + " cost:" + time + " response:" + response.get(), Toast.LENGTH_SHORT).show();
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    }
                                });
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }).start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case R.id.btnOpenOOM:
                try {
                    final RouterResponse response = LocalRouter.getInstance(MaApplication.getMaApplication())
                            .route(MainActivity.this, RouterRequest.obtain(MainActivity.this)
                                    .domain("com.credithc.mademo:mine")
                                    .provider("mine")
                                    .action("oom"));
                    Log.e(TAG,"response :"+response.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case R.id.btnReleaseSettings:
                break;
            case R.id.btnStartActivityForResult:
                try {
                    final RouterResponse response = LocalRouter.getInstance(MaApplication.getMaApplication())
                            .route(MainActivity.this, RouterRequest.obtain(MainActivity.this)
                                    .provider("home")
                                    .action("testResult"));
                    Log.e(TAG,"response :"+response.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;

            default:
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            Toast.makeText(this,"Activity.RESULT_OK",Toast.LENGTH_LONG).show();
        } else if (resultCode == Activity.RESULT_CANCELED) {
            Toast.makeText(this,"Activity.RESULT_CANCELED",Toast.LENGTH_LONG).show();
        }
    }

}
