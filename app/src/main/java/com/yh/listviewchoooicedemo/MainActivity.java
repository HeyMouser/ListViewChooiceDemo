package com.yh.listviewchoooicedemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<InfoBean> mList;
    private MyAdapter mAdapter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.lv);

        mList = new ArrayList<>();
        for (int i = 0;i<30;i++){
            mList.add(new InfoBean("item"+i));
        }
        mAdapter = new MyAdapter(this);
        mAdapter.setmList(mList);
        listView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                MyAdapter.ViewHolder viewHolder = (MyAdapter.ViewHolder) view.getTag();
                //改变CheckBox选中状态
                viewHolder.checkBox.toggle();
                //记录下来
                MyAdapter.getIsSelectMap().put(i,viewHolder.checkBox.isChecked());
            }
        });

    }
}
