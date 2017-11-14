package debug;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.credithc.module_goods.view.GoodsActivity;

public class LauncherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(this, GoodsActivity.class);
        intent.putExtra("id", "9500116");
        startActivity(intent);
        finish();
    }

}
