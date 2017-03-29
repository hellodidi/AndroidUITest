package com.example.i.androiduitest;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by i on 2017/3/24.
 */

public class XmlMenuDemo extends Activity {
    private EditText etHelloWorld;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xmlmenu_layout);
        etHelloWorld = (EditText) findViewById(R.id.et_hello_world);
        registerForContextMenu(etHelloWorld);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return true;

    }

/*

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.context_menu, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }
*/


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_plain_menu:
                Toast.makeText(this, "你单击了普通菜单", Toast.LENGTH_LONG).show();
                break;
            case R.id.font_10:
                etHelloWorld.setTextSize(10);
                break;
            case R.id.font_16:
                etHelloWorld.setTextSize(16);
                break;
            case R.id.font_20:
                etHelloWorld.setTextSize(20);
                break;
            case R.id.font_red:
                item.setChecked(true);
                etHelloWorld.setTextColor(Color.RED);
                break;
            case R.id.font_black:
                item.setChecked(true);
                etHelloWorld.setTextColor(Color.BLACK);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

/*

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        item.setChecked(true);
        switch (item.getItemId()) {
            case R.id.font_red:
                item.setChecked(true);
                etHelloWorld.setBackgroundColor(Color.RED);
                break;
            case R.id.font_black:
                item.setChecked(true);
                etHelloWorld.setBackgroundColor(Color.BLACK);
                break;
        }
        return super.onContextItemSelected(item);
    }
*/

}
