package sv.edu.utec.controleslayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText; //***********Se agrego Libreria************
import android.widget.RadioButton; //***********Se agrego Libreria************
import android.widget.Spinner; //***********Se agrego Libreria************

public class MainActivity extends AppCompatActivity {
    Spinner spPais; //**********Se agrego************
    EditText etNombres, etApellidos, etInfo;
    RadioButton rbFem, rbMas, rbOtros;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //************Se agrego***********************************************
        etNombres = findViewById(R.id.edtNombres);
        etApellidos = findViewById(R.id.edtApellidos);
        etInfo = findViewById(R.id.editTextTextMultiLine);
        spPais = findViewById(R.id.spnPais);
        //***************************Definimos un arreglo que va a llenar el Spinner**************
        String[] opciones = {"Seleccione un pais", "Guatemala", "El Salvador", "Honduras", "Nicaragua", "Panama", "Costa Rica"};
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, opciones);
        spPais.setAdapter(adaptador);

    }
        //********************************* Se agrego***************************************************************************************************
        public void Almacenar (View v){
            String datos = "";
            String seleccion = spPais.getSelectedItem().toString();
            if (seleccion.equals("Seleccione un pais")) {
                datos = "No selecciono ningun pais";
            }
            else if (seleccion.equals("Guatemala")) {
                datos = "Guatemala";
               // etInfo.append(datos);
            }
            else if (seleccion.equals("El Salvador")) {
                datos = "El Salvador";
                //etInfo.append(datos);
            }
            else if (seleccion.equals("Honduras")) {
                datos = "Honduras";
                //etInfo.append(datos);
            }
            else if (seleccion.equals("Nicaragua")) {
                datos = "Nicaragua";
                //etInfo.append(datos);
            }
            else if (seleccion.equals("Costa Rica")) {
                datos = "Costa Rica";
                //etInfo.append(datos);
            }
            else if (seleccion.equals("Panama")) {
                datos = "Panama";
                //etInfo.append(datos);
            }

            etInfo.append(datos);
        }

}




