package com.example.i.androiduitest;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {

    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1=(Button)findViewById(R.id.button1) ;
        //添加按钮监听
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SimpleAdapterDemo.class));
           }
        });
        btn2=(Button)findViewById(R.id.button2) ;
        //添加按钮监听
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  startActivity(new Intent(MainActivity.this, AlertDialogDemo.class));
                startActivity(new Intent(MainActivity.this, AlertDialogDemo.class));
            }
        });
        btn3=(Button)findViewById(R.id.button3) ;
        //添加按钮监听
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, XmlMenuDemo.class));
            }
        });

        btn4=(Button)findViewById(R.id.button4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ActionModeDemo.class));
            }
        });
    }


}
