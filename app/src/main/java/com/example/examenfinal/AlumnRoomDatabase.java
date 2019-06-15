package com.example.examenfinal;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Alumno.class}, version = 1)
public abstract class AlumnRoomDatabase extends RoomDatabase {

    public abstract AlumnoDao alumnoDao();

    private static volatile AlumnRoomDatabase INSTANCE;

    static AlumnRoomDatabase getDatabase(final Context context){
        if (INSTANCE == null){
            synchronized (AlumnRoomDatabase.class){
                if (INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AlumnRoomDatabase.class, "alumno_database")
                            .fallbackToDestructiveMigration()
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback(){
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db){
            super.onOpen(db);
            new PopulateDbAsync(INSTANCE).execute();
        }
    };

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void>{

        private final AlumnoDao mDao;

        PopulateDbAsync(AlumnRoomDatabase db){mDao = db.alumnoDao();}

        @Override
        protected Void doInBackground(Void... voids) {
            mDao.deleteAll();
            return null;
        }
    }
}
