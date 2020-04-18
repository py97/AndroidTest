package com.example.py.firstactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //向下一个活动传递数据和向上一个活动返回数据在这里不能同时使用：intent
        /*接收MainActivity的data并打印
        字符串：getStringExtra
        整型数据：getIntExtra
        布尔型数据：getBooleanExtra
         */
//        Intent intent = getIntent();
//        String data = intent.getStringExtra("extra_data");
//        Log.d("SecondActivity", data);
//        Toast.makeText(SecondActivity.this,data,Toast.LENGTH_SHORT).show();

        /*返回数据给上一个活动
        *
        * */
        Button button_2_1 = (Button) findViewById(R.id.button_2_1);
        button_2_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent();
                intent1.putExtra("data_return","Hello MainActivity");
                setResult(RESULT_OK,intent1);
                finish();
            }
        });


    }
}
