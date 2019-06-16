package com.example.examenfinal;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.sql.Date;

@Entity(tableName = "medida_table")
public class Medida {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "fecha")
    private Date fecha;

    @NonNull
    @ColumnInfo(name = "grasa")
    private int grasa;

    @NonNull
    @ColumnInfo(name = "masaMuscular")
    private int masaMuscular;

    @NonNull
    @ColumnInfo(name = "peso")
    private int peso;

    @NonNull
    @ColumnInfo(name = "edadMetabolica")
    private int edadMetabolica;

    public Medida(@NonNull Date fecha, int grasa, int masaMuscular, int peso, int edadMetabolica) {
        this.fecha = fecha;
        this.grasa = grasa;
        this.masaMuscular = masaMuscular;
        this.peso = peso;
        this.edadMetabolica = edadMetabolica;
    }

    @NonNull
    public Date getFecha() {
        return fecha;
    }

    public int getGrasa() {
        return grasa;
    }

    public int getMasaMuscular() {
        return masaMuscular;
    }

    public int getPeso() {
        return peso;
    }

    public int getEdadMetabolica() {
        return edadMetabolica;
    }
}



