package com.example.roomcustomlistview;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CityDao {
    @Query("SELECT * FROM City")
    List<City> getAll();


    @Insert
    void insertAll(City... city);
    @Delete
    void delete(City city);
}
