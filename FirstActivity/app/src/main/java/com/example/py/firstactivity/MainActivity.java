package com.example.py.firstactivity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //logt+tab:private static final String TAG = "HelloWorldActivity";
    private static final String TAG = "HelloWorldActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //log:日志
        //logd+tab:打印调试信息
        Log.d(TAG, "onCreate: Debug");
        //logi+tab：打印一些较为重要的数据
        Log.i(TAG, "onCreate: Info");
        //logw+tab：打印警告信息
        Log.w(TAG, "onCreate: Warm" );
        //loge+tab：打印程序中的错误信息
        Log.e(TAG, "onCreate: Error" );

        //Toast
        Button button1 = (Button) findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"你点击了Toast",Toast.LENGTH_SHORT).show();
            }
        });

        //显示Intent
        Button button2 = (Button) findViewById(R.id.button_2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });

        //隐式Intent:和显示Intent作用类似
        Button button3 = (Button) findViewById(R.id.button_3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.example.firstactivity.ACTION_START");
                intent.addCategory("com.example.firstactivity.MY_CATEGORY");
                startActivity(intent);
            }
        });

        //隐式Intet:打开浏览器
        Button button4 = (Button) findViewById(R.id.button_4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intent);
            }
        });

        //隐式Intent;拨号10086
        Button button5 = (Button) findViewById(R.id.button_5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("tel:10086"));
                startActivity(intent);
            }
        });

        //向下一个活动传递数据:data = Hello SecondActivity
        Button button6 = (Button) findViewById(R.id.button_6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = "Hello SecondActivity";
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                intent.putExtra("extra_data",data);
                startActivity(intent);
            }
        });

        //返回数据给上一个活动
        Button button7 = (Button) findViewById(R.id.button_7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity.this,SecondActivity.class);
                startActivityForResult(intent1,1);
            }
        });

    }

    //返回数据给上一个活动：将返回的数据打印出来
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (requestCode){
            case 1:
                if (requestCode == 1){
                    String returnedData = data.getStringExtra("data_return");
                    Log.d("FirstActivity", returnedData);
                    Toast.makeText(MainActivity.this,returnedData,Toast.LENGTH_SHORT).show();
                }
                break;
            default:
        }
    }

    //创建右上角的Menu菜单
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(this, "你点击了Add", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this, "你点击了Remove", Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }

}
