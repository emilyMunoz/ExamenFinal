package com.example.examenfinal;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;

@Entity(tableName = "alumno")
public class Alumno {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
    private int mId;

    @NonNull
    @ColumnInfo(name = "nombre")
    private String mNombre;

    @NonNull
    @ColumnInfo(name = "edad")
    private int mEdad;

    @NonNull
    @ColumnInfo(name = "correo")
    private String mCorreo;

    @NonNull
    @ColumnInfo(name = "foto")
    private byte mFoto;

    public Alumno(int mId, @NonNull String mNombre, int mEdad, @NonNull String mCorreo, byte mFoto) {
        this.mId = mId;
        this.mNombre = mNombre;
        this.mEdad = mEdad;
        this.mCorreo = mCorreo;
        this.mFoto = mFoto;
    }

    public int getmId() {
        return mId;
    }

    @NonNull
    public String getmNombre() {
        return mNombre;
    }

    public int getmEdad() {
        return mEdad;
    }

    @NonNull
    public String getmCorreo() {
        return mCorreo;
    }

    public byte getmFoto() {
        return mFoto;
    }
}
