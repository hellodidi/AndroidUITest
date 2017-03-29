package com.example.i.androiduitest;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by i on 2017/3/28.
 */

public class AlertDialogDemo extends Activity {
    Button btn_alertdialog;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.blank_page);
        btn_alertdialog = (Button) findViewById(R.id.btn_alertdialog);
        //添加按钮监听
        btn_alertdialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(AlertDialogDemo.this);
                // 获取布局
                View view = View.inflate(AlertDialogDemo.this, R.layout.content_layout, null);
                // 创建对话框
                builder.setView(view);
                builder.show();
            }
        });
    }
}