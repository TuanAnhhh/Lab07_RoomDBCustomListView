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
        listCity = cityDao.getAll();

        lvCity = findViewById(R.id.lvCitys);
        mAdapter = new CityAdapter(listCity);
        lvCity.setAdapter(mAdapter);

        btnSave = findViewById(R.id.btnSave);
        btnCancel = findViewById(R.id.btnCancel);
        tvCity  = findViewById(R.id.etVisit);
    }
    public void handle(){
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cityStr = tvCity.getText().toString().trim();
                Random rand = new Random();
                cityDao.insertAll(new City(rand.nextInt(),cityStr));

                listCity = cityDao.getAll();

                mAdapter = new CityAdapter(listCity);
                lvCity.setAdapter(mAdapter);
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