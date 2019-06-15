package com.example.examenfinal;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class AlumnViewModel extends AndroidViewModel {

    private AlumnRepository mRepository;
    private LiveData<List<Alumno>> mAllAlumns;

    public AlumnViewModel(Application application){
        super(application);
        mRepository = new AlumnRepository(application);
        mAllAlumns = mRepository.getAllAlumns();
    }

    LiveData<List<Alumno>> getAllAlums(){
        return mAllAlumns;
    }

    void insert(Alumno alumno){
        mRepository.insert(alumno);
    }

}
