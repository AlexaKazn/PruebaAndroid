package com.example.prueba02_01_paola_nunez;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNombre, editTextApellido, editTextDividendo, editTextDivisor;
    private EditText editTextParteEntera, editTextResiduo, editTextNumInver;
    private Button buttonMostrar, buttonPasar;

    private int dividendo, divisor, numero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNombre = findViewById(R.id.editTextNombre);
        editTextApellido = findViewById(R.id.editTextText2);
        editTextDividendo = findViewById(R.id.editText_Dividendo);
        editTextDivisor = findViewById(R.id.editText_Divisor);
        editTextParteEntera = findViewById(R.id.editText_ParteEntera);
        editTextResiduo = findViewById(R.id.editText_Residuo);
        editTextNumInver = findViewById(R.id.editText_NumInver);
        buttonMostrar = findViewById(R.id.buttonMostrar);
        buttonPasar = findViewById(R.id.buttonPasar);

        bloquear();

        Intent intent = getIntent();
        String nombre = intent.getStringExtra("nombre");
        String apellido = intent.getStringExtra("apellido");
        dividendo = intent.getIntExtra("dividendo", 1);
        divisor = intent.getIntExtra("divisor", 1);
        numero = intent.getIntExtra("numero", 0);

        editTextNombre.setText(nombre);
        editTextApellido.setText(apellido);
        editTextDividendo.setText(String.valueOf(dividendo));
        editTextDivisor.setText(String.valueOf(divisor));

        buttonMostrar.setOnClickListener(v -> {
            if (divisor == 0) {
                editTextParteEntera.setText("Error");
                editTextResiduo.setText("Error");
                return;
            }

            int cociente = 0;
            int residuoActual = dividendo;

            do {
                int contador = 0;
                int simulacion = 0;
                do {
                    simulacion = simulacion + 1;
                    contador++;
                } while (contador < divisor);

                int comparador = 0;
                int simulador = 0;
                do {
                    simulador = simulador + 1;
                    comparador++;
                } while (simulador < residuoActual);

                if (comparador >= divisor) {
                    residuoActual = residuoActual - divisor;
                    cociente++;
                } else {
                    break;
                }
            } while (residuoActual >= divisor);

            int invertido = 0;
            int temp = numero;
            do {
                int digito = temp % 10;
                invertido = invertido * 10 + digito;
                temp = temp / 10;
            } while (temp != 0);

            editTextParteEntera.setText(String.valueOf(cociente));
            editTextResiduo.setText(String.valueOf(residuoActual));
            editTextNumInver.setText(String.valueOf(invertido));
        });

        buttonPasar.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(i);
        });
    }

    private void bloquear() {
        editTextNombre.setEnabled(false);
        editTextApellido.setEnabled(false);
        editTextDividendo.setEnabled(false);
        editTextDivisor.setEnabled(false);
        editTextParteEntera.setEnabled(false);
        editTextResiduo.setEnabled(false);
        editTextNumInver.setEnabled(false);
    }
}
