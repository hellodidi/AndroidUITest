package com.example.i.androiduitest;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by i on 2017/3/22.
 */

public class SimpleAdapterDemo extends Activity {

    private String[] name = { "Lion", "Tiger", "Monkey", "Dog","Cat","Elephant" };
    private int[] imageids = { R.drawable.lion, R.drawable.tiger,
            R.drawable.monnkey, R.drawable.dog ,R.drawable.cat,R.drawable.elephant};

    private ListView father;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_father);
        List<Map<String, Object>> listems = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < name.length; i++) {
            Map<String, Object> listem = new HashMap<String, Object>();
            listem.put("pic", imageids[i]);
            listem.put("name", name[i]);
            listems.add(listem);
        }
        SimpleAdapter simplead = new SimpleAdapter(this, listems,
                R.layout.listview_child, new String[] { "name", "pic" },
                new int[] {R.id.name,R.id.pic});

        father=(ListView)findViewById(R.id.father);
        father.setAdapter(simplead);

        father.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast toast = Toast.makeText(SimpleAdapterDemo.this,name[i], Toast.LENGTH_SHORT);
                toast.show();
            }
        });
}
}
