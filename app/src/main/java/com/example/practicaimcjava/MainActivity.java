package com.example.practicaimcjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputFilter;
import android.text.InputType;
import android.text.Spanned;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    private EditText txtAltura2;
    private EditText txtPeso2;
    private TextView lblIMC2;
    private Button btnCalcular;
    private Button btnLimpiar;
    private Button btnRegresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Relacionar los objetos
        txtAltura2 = (EditText) findViewById(R.id.txtAltura);
        txtPeso2 = (EditText) findViewById(R.id.txtPeso);
        lblIMC2 = (TextView) findViewById(R.id.lblIMC);
        btnCalcular = (Button) findViewById(R.id.btnCalculo);
        btnLimpiar = (Button) findViewById(R.id.btnLimpio);
        btnRegresar = (Button) findViewById(R.id.btnRegreso);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Obtenemos el texto de los EditText y eliminamos cualquier espacio en blanco inicial o final
                String textoAltura = txtAltura2.getText().toString().trim();
                String textoPeso = txtPeso2.getText().toString().trim();

                // Verificar que no esten vacíos los campos
                if (textoAltura.isEmpty()) {
                    // El EditText2 txtAltura está vacío, se muestra un mensaje de error
                    txtAltura2.setError("Este campo es obligatorio");
                } else if (textoPeso.isEmpty()) {
                    // El EditText txtPeso2 está vacío, se muestra un mensaje de error
                    txtPeso2.setError("Este campo es obligatorio");
                } else {
                    // Obtener los valores de altura y peso
                    double altura = Double.parseDouble(txtAltura2.getText().toString());
                    double peso = Double.parseDouble(txtPeso2.getText().toString());

                    // Verificar que no sean 0 los valores
                    if(altura!=0 || peso!=0){
                        // Calcular IMC: el peso en kilogramos dividido por la estatura en metros al cuadrado (convertimos de cm a m la altura)
                        altura=altura/100;
                        double imc = peso / (altura * altura);

                        // Mostrar el resultado en el TextView
                        lblIMC2.setText("Su IMC es: " + imc + "kg/m2");
                    }
                }


            }
        });

        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtAltura2.setText("");
                txtPeso2.setText("");
                lblIMC2.setText("Su IMC es:");
            }
        });

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}