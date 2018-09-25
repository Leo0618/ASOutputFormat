package vip.okfood.outputformat;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView mTextView;
    LeoAdd leoAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = findViewById(R.id.textUI);
        leoAdd = new LeoAdd("HaHa-Leo 就是我");
        mTextView.setText(leoAdd.getMsg());
    }

    public void hintClick(View view) {
        toast("bug没有了");
        mTextView.setText(CacheMsg.msgList());
    }


    private void toast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        CacheMsg.clean();
    }

    public void queryFix(View view) {
        toast("查询!");
    }
}
