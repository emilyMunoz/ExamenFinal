package com.example.examenfinal;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class AlumnRepository {

    private AlumnoDao mAlumnoDao;
    private LiveData<List<Alumno>> mAllAlumns;

    AlumnRepository(Application application){
        AlumnRoomDatabase db = AlumnRoomDatabase.getDatabase(application);
        mAlumnoDao = db.alumnoDao();
        mAllAlumns = mAlumnoDao.getAlphabetizedAlum();
    }

    LiveData<List<Alumno>> getAllAlumns(){return mAllAlumns;}

    void insert(Alumno alumno){new insertAsyncTask(mAlumnoDao).execute(alumno);}

    private static class insertAsyncTask extends AsyncTask<Alumno, Void, Void>{

        private AlumnoDao mAsyncTaskDao;

        insertAsyncTask(AlumnoDao dao){mAsyncTaskDao = dao;}

        @Override
        protected Void doInBackground(Alumno... alumnos) {
            mAsyncTaskDao.insert(alumnos[0]);
            return null;
        }
    }
}
