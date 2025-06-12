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

            int cocientePAND = 0;
            int residuoActualPAND = dividendo;

            do {
                int contadorPAND = 0;
                int simulacionPAND = 0;
                do {
                    simulacionPAND = simulacionPAND + 1;
                    contadorPAND++;
                } while (contadorPAND < divisor);

                int comparadorPAND = 0;
                int simuladorPAND = 0;
                do {
                    simuladorPAND = simuladorPAND + 1;
                    comparadorPAND++;
                } while (simuladorPAND < residuoActualPAND);

                if (comparadorPAND >= divisor) {
                    residuoActualPAND = residuoActualPAND - divisor;
                    cocientePAND++;
                } else {
                    break;
                }
            } while (residuoActualPAND >= divisor);

            int invertidoPAND = 0;
            int tempPAND = numero;
            do {
                int digito = tempPAND % 10;
                invertidoPAND = invertidoPAND * 10 + digito;
                tempPAND = tempPAND / 10;
            } while (tempPAND != 0);

            editTextParteEntera.setText(String.valueOf(cocientePAND));
            editTextResiduo.setText(String.valueOf(residuoActualPAND));
            editTextNumInver.setText(String.valueOf(invertidoPAND));
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
