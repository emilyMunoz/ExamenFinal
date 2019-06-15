package com.example.examenfinal;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface AlumnoDao {

    @Query("SELECT * from alumno ORDER BY nombre ASC")
    LiveData<List<Alumno>> getAlphabetizedAlum();

    @Insert
    void insert(Alumno alumno);

    @Update
    void update(Alumno alumno);

    @Query("DELETE FROM alumno")
    void deleteAll();

}
