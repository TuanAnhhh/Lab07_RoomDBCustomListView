package com.example.roomcustomlistview;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class City {
    @PrimaryKey
    public int id;

    @ColumnInfo(name = "city")
    public String city;

    public City(int id, String city) {
        this.id = id;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", city='" + city + '\'' +
                '}';
    }
}
