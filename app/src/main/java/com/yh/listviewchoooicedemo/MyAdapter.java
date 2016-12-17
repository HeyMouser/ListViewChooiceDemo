package com.yh.listviewchoooicedemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by YH on 2016/12/17.
 */

public class MyAdapter extends BaseAdapter {
    private List<InfoBean> mList ;
    private Context mContext;
    private static Map<Integer,Boolean> isSelectMap;

    public MyAdapter(Context mContext) {
        this.mContext = mContext;
        mList = new ArrayList<>();
        isSelectMap = new HashMap<Integer, Boolean>();
    }

    private void initMap() {
        for (int i = 0;i<mList.size();i++){
            getIsSelectMap().put(i,false);
        }
    }

    public void setmList(List<InfoBean> mList) {
        this.mList = mList;
        initMap();
    }

    public static Map<Integer, Boolean> getIsSelectMap() {
        return isSelectMap;
    }

    public static void setIsSelectMap(Map<Integer, Boolean> selectMap) {
        MyAdapter.isSelectMap = selectMap;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int i) {
        return mList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder vh ;
        if(view==null){
            view = LayoutInflater.from(mContext).inflate(R.layout.item_lv,null);
            vh = new ViewHolder();
            vh.checkBox = (CheckBox) view.findViewById(R.id.checkBox);
            vh.tv_name = (TextView) view.findViewById(R.id.tv_name);
            view.setTag(vh);
        }else{
            vh = (ViewHolder) view.getTag();
        }
        vh.tv_name.setText(mList.get(i).getName());
        vh.checkBox.setChecked(getIsSelectMap().get(i));
        return view;
    }
    class ViewHolder{
        public TextView tv_name;
        public CheckBox checkBox;
    }
}
