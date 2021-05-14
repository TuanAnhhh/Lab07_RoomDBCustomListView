package com.example.roomcustomlistview;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class CityAdapter extends BaseAdapter {
    final List<City> listCity;

    public CityAdapter(List<City> listCity) {
        this.listCity = listCity;
    }

    @Override
    public int getCount() {
        return listCity.size();
    }

    @Override
    public Object getItem(int i) {
        return listCity.get(i);
    }

    @Override
    public long getItemId(int i) {
        return listCity.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view1;
        if (view == null){
            view1 = View.inflate(viewGroup.getContext(), R.layout.item, null);
        }else view1 = view;

        City city = (City) getItem(i);
        TextView tv1 = view1.findViewById(R.id.tvName);
        tv1.setText(city.getCity());


        return view1;
    }
}
