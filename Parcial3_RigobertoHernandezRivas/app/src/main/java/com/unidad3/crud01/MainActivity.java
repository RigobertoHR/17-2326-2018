package com.unidad3.crud01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txtNombre, txtApellidos, txtDireccion, txtCiudad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNombre = findViewById(R.id.txtNombre);
        txtApellidos = findViewById(R.id.txtApellidos);
        txtDireccion = findViewById(R.id.txtDireccion);
        txtCiudad = findViewById(R.id.txtCiudad);
    }

    //Agregar
    public void Agregar(View view)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "parcial", null, 1);
        SQLiteDatabase BaseDatos = admin.getReadableDatabase();

        String Nombre = txtNombre.getText().toString();
        String Apellidos = txtApellidos.getText().toString();
        String Direccion = txtDireccion.getText().toString();
        String Ciudad = txtCiudad.getText().toString();

        try{
            if(!Nombre.isEmpty() && !Apellidos.isEmpty() && !Direccion.isEmpty() && !Ciudad.isEmpty())
            {
                ContentValues registro = new ContentValues();
                registro.put("nombre", Nombre);
                registro.put("apellidos", Apellidos);
                registro.put("Direccion", Direccion);
                registro.put("Ciudad", Ciudad);

                BaseDatos.insert("contactos", null, registro);
                BaseDatos.close();

                LimpiarCajas();
            }
            else
            {
                Toast.makeText(this, "LLENAR TODOS LOS CAMPOS", Toast.LENGTH_LONG).show();
            }
        }catch (Exception e)
        {
            Toast.makeText(this, "ERROR AL INGRESAR DATOS", Toast.LENGTH_LONG).show();
        }
    }

    //Consultar por Nombre
    public void ConsultarNombre(View view)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "parcial", null, 1);
        SQLiteDatabase BaseDatos = admin.getWritableDatabase();

        String Nombre = txtNombre.getText().toString();
        if(!Nombre.isEmpty())
        {
            Cursor fila = BaseDatos.rawQuery(
                    "SELECT apellidos, direccion, ciudad " +
                    "FROM Clientes " +
                    "WHERE nombre =" + Nombre, null);

            if(fila.moveToFirst())
            {

                txtApellidos.setText(fila.getString(0));
                txtDireccion.setText(fila.getString(1));
                txtCiudad.setText(fila.getString(2));
                BaseDatos.close();
            }
            else
            {
                Toast.makeText(this, "NOMBRE NO EXISTE", Toast.LENGTH_LONG).show();
                BaseDatos.close();
                LimpiarCajas();
            }
        }
        else
        {
            Toast.makeText(this, "NOMBRE VACIO", Toast.LENGTH_LONG).show();
        }
    }

    //Buscar por Apellido
    public void ConsultaApellido(View view)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "parcial", null, 1);
        SQLiteDatabase BaseDatos = admin.getWritableDatabase();

        String Apellidos = txtApellidos.getText().toString();

        if(!Apellidos.isEmpty())
        {
            Cursor fila = BaseDatos.rawQuery(
                    "SELECT nombre, direccion, ciudad " +
                            "FROM contactos " +
                            "WHERE apellidos =" + Apellidos, null);

            if(fila.moveToFirst())
            {
                txtNombre.setText(fila.getString(0));
                txtDireccion.setText(fila.getString(1));
                txtCiudad.setText(fila.getString(2));
                BaseDatos.close();
            }
            else
            {
                Toast.makeText(this, "APELLIDO NO EXISTE", Toast.LENGTH_LONG).show();
                BaseDatos.close();
                LimpiarCajas();
            }
        }
        else
        {
            Toast.makeText(this, "APELLIDO VACIO", Toast.LENGTH_LONG).show();
        }
    }



    //Modificar
    public void Modificar(View view)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "parcial", null, 1);
        SQLiteDatabase BaseDatos = admin.getWritableDatabase();

        String Nombre = txtNombre.getText().toString();
        String Apellidos = txtApellidos.getText().toString();
        String Telefono = txtDireccion.getText().toString();
        String Correo = txtCiudad.getText().toString();

        if(!Nombre.isEmpty() && !Apellidos.isEmpty() && !Telefono.isEmpty() && !Correo.isEmpty())
        {
            ContentValues registro = new ContentValues();
                registro.put("nombre", Nombre);
                registro.put("apellidos", Apellidos);
                registro.put("direcccion", Telefono);
                registro.put("ciudad", Correo);

                int cantidad = BaseDatos.update("Clientes", registro, "nombre=" + Nombre, null);
                BaseDatos.close();

                if(cantidad == 1)
                {
                    Toast.makeText(this, "REGISTRO MODIFICADO", Toast.LENGTH_LONG).show();
                    LimpiarCajas();
                }
                else
                {
                    Toast.makeText(this, "ERROR AL MODIFICAR", Toast.LENGTH_LONG).show();
                }
        }
        else
        {
            Toast.makeText(this, "UN CAMPO ESTA VACIO", Toast.LENGTH_LONG).show();
        }
    }

    //Eliminar
    public void Eliminar(View view)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "parcial", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        String Nombre = txtNombre.getText().toString();

        try
        {
            if(!Nombre.isEmpty())
            {
                int Cantidad = BaseDeDatos.delete("Clientes", "nombre=" + Nombre, null);
                BaseDeDatos.close();
                LimpiarCajas();

                if(Cantidad == 1)
                {
                    Toast.makeText(this, "REGISTRO ELIMINADO", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(this, "ERROR AL ELIMINAR", Toast.LENGTH_LONG).show();
                }
            }
            else
            {
                Toast.makeText(this, "NOMBRE VACIO", Toast.LENGTH_LONG).show();
            }
        }catch (Exception e)
        {

        }
    }
    public void LimpiarCajas()
    {
        txtNombre.setText("");
        txtApellidos.setText("");
        txtDireccion.setText("");
        txtCiudad.setText("");
    }

    public void Finalizar(View view)
    {
        finish();
    }
}