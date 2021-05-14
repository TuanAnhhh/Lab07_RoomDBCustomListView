package com.example.roomcustomlistview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CityAdapter extends BaseAdapter {
    final List<City> listCity;
    private Context context;
    private HandleOnClick onDeleteListener;
    private HandleOnClick onEditListener;
    int layout;

    public CityAdapter(Context context,List<City> listCity, int layout, HandleOnClick onEditListener, HandleOnClick onDeleteListener) {
        this.context = context;
        this.listCity = listCity;
        this.onEditListener  = onEditListener;
        this.onDeleteListener = onDeleteListener;
        this.layout = layout;

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
        ImageView ivRemove = view1.findViewById(R.id.ivRemove);
        ImageView ivEdit = view1.findViewById(R.id.ivEdit);

        int id = listCity.get(i).getId();
        tv1.setText(city.getCity());


        ivRemove.setOnClickListener(v -> {
            this.onDeleteListener.onItemClick(id);
        });

        ivEdit.setOnClickListener(v -> {
            this.onEditListener.onItemClick(id );
        });
        return view1;
    }
}
