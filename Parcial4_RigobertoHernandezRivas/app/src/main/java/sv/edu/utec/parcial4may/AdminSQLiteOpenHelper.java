package sv.edu.utec.parcial4may;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {
//Crear los metodos y el constructor

    private  static  final int DATABASE_VERSION=1;
    private  static  final String DATABASE_NOMBRE="Parcial4May.db";

    private  static  final String MD_Clientes="Cliente";
    private  static  final String MD_ClienteVehiculo="Vehiculo";
    private  static  final String MD_Vehiculos="VehiculoC";
    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase BaseDeDatos) {
        BaseDeDatos.execSQL("CREATE TABLE "+MD_Clientes+"(" +
                "ID_CLIENTE INTEGER PRIMARY KEY AUTOINCREMENT," +
                "SNOMBRECLIENTE TEXT NOT NULL," +
                "SAPELLIDOSCLIENTE TEXT NOT NULL," +
                "SDIRECCION TEXT NOT NULL," +
                "SCIUDADCLIENTE TEXT NOT NULL);");

        BaseDeDatos.execSQL("CREATE TABLE "+MD_ClienteVehiculo+"(" +
                "ID_CLIENTE INTEGER," +
                "ID_VEHICULO INTEGER NOT NULL," +
                "SMATRICULA TEXT NOT NULL," +
                "KILOMETROS TEXT NOT NULL," +
                "CONTRASENIA TEXT NOT NULL);");

        BaseDeDatos.execSQL("CREATE TABLE "+MD_Vehiculos+"(" +
                "ID_VEHICULO INTEGER PRIMARY KEY AUTOINCREMENT," +
                "SMARCA TEXT NOT NULL," +
                "SMODELO TEXT NOT NULL," +
                "FOREIGN KEY(ID_VEHICULO) REFERENCES MD_CLIENTEVEHICULO(ID)," +
                "FOREIGN KEY(ID_CLIENTE) REFERENCES MD_CLIENTES(ID));");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
