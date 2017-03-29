package com.example.i.androiduitest;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;

import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by i on 2017/3/28.
 */

public class ActionModeDemo extends Activity {

    private String[] name = {"Lion", "Tiger", "Monkey", "Dog", "Cat", "Elephant"};
    private int[] imageids = {R.drawable.lion, R.drawable.tiger,
            R.drawable.monnkey, R.drawable.dog, R.drawable.cat, R.drawable.elephant};

    private ListView father;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_father);
        init();

        father.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        father.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {

            private int nr = 0;

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                // TODO Auto-generated method stub
                return false;
            }
            @Override
            public void onDestroyActionMode(ActionMode mode) {
                // TODO Auto-generated method stub
                for(int i=0;i<6;i++){
                    father.getChildAt(i).setBackgroundColor(0);}
                nr = 0;
            }
            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                // TODO Auto-generated method stub
                MenuInflater inflater = mode.getMenuInflater();
                inflater.inflate(R.menu.contextual_menu, menu);
                return true;
            }


            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                switch (item.getItemId()) {

                    case R.id.item_delete:
                        for(int i=0;i<6;i++){
                        father.getChildAt(i).setBackgroundColor(0);}
                        nr = 0;
                        mode.finish();
                }
                return false;
            }

            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position,
                                                  long id, boolean checked) {
                // TODO Auto-generated method stub
                if (checked) {
                    father.getChildAt(position).setBackgroundColor(Color.BLUE);
                    nr++;
                } else {
                    father.getChildAt(position).setBackgroundColor(0);
                    nr--;
                }
                mode.setTitle(nr + " selected");
            }

        });
    }



    public void init(){

        List<Map<String, Object>> listems = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < name.length; i++) {
            Map<String, Object> listem = new HashMap<String, Object>();
            listem.put("pic", imageids[i]);
            listem.put("name", name[i]);
            listems.add(listem);
        }
        SimpleAdapter simplead = new SimpleAdapter(this, listems,
                R.layout.listview_child, new String[]{"name", "pic"},
                new int[]{R.id.name, R.id.pic});

        father = (ListView) findViewById(R.id.father);
        father.setAdapter(simplead);

        registerForContextMenu(father);
    }
}
