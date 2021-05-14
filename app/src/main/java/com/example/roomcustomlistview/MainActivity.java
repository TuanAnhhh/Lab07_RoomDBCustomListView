package com.example.roomcustomlistview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    CityDao cityDao;
    List<City> listCity;
    ListView lvCity;
    CityAdapter mAdapter;
    Button btnSave;
    Button btnCancel;
    EditText tvCity;
    private HandleOnClick onDeleteListener;
    private HandleOnClick onEditListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        handle();
    }
    public void init(){
        AppDatabase db1 = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "CityManager")
                .allowMainThreadQueries()
                .build();
        cityDao = db1.cityDao();
        lvCity = findViewById(R.id.lvCitys);

        lvCity.setAdapter(new CityAdapter(this,cityDao.getAll(), R.layout.item,onEditListener, onDeleteListener));

        btnSave = findViewById(R.id.btnSave);
        btnCancel = findViewById(R.id.btnCancel);
        tvCity  = findViewById(R.id.etVisit);
    }
    public void handle(){
        onDeleteListener = id -> {
            cityDao.delete(cityDao.getById(id));
            lvCity.setAdapter(new CityAdapter(this,cityDao.getAll(), R.layout.item,onEditListener, onDeleteListener));

        };

        onEditListener = id -> {
            City city  = cityDao.getById(id);
            tvCity.setText(city.getCity());

        };



        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cityStr = tvCity.getText().toString().trim();
                Random rand = new Random();
                cityDao.insertAll(new City(rand.nextInt(),cityStr));

                listCity = cityDao.getAll();

                lvCity.setAdapter(new CityAdapter(view.getContext(),cityDao.getAll(), R.layout.item,onEditListener, onDeleteListener));
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvCity.setText("");
            }
        });
    }
}