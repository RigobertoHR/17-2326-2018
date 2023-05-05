package com.unidad3.crud01;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
//Importar SQLite
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper{
//Crear los metodos y el constructor

    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase BaseDeDatos) {
        BaseDeDatos.execSQL("create table Clientes(" +
                "nombre text primary key," +
                "apellidos text," +
                "Direccion text," +
                "Ciudad text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
