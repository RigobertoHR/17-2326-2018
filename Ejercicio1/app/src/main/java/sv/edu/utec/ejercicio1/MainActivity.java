package sv.edu.utec.ejercicio1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText usuario1, password1;
    Button btLogin;
    TextView resultado1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usuario1=findViewById(R.id.txtUsuario);
        password1 =findViewById(R.id.txtPassword);
        resultado1=findViewById(R.id.tvResultado);
    }
    public void mostrar(View v){
        String dato1,dato2;
        dato1= usuario1.getText().toString();
        dato2=password1.getText().toString();
        if (dato1.equals("parcialETps1") && dato2.equals("p4rC14l#tp$")){
            resultado1.setText("Incio de sesión exitoso");
        }else{

            resultado1.setText("Error en Inicio de sesión");

        }

    }
}