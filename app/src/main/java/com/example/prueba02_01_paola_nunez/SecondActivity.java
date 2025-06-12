package com.example.prueba02_01_paola_nunez;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private EditText editTextNombre, editTextApellido;
    private EditText editTextDividendo, editTextDivisor, editTextNumero;
    private Button buttonSiguiente, buttonCerrar;

    private int dividendo, divisor, numero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        editTextNombre = findViewById(R.id.editTextNombre);
        editTextApellido = findViewById(R.id.editTextText2);
        editTextDividendo = findViewById(R.id.editText_Dividendo);
        editTextDivisor = findViewById(R.id.editText_Divisor);
        editTextNumero = findViewById(R.id.editText_Numero);
        buttonSiguiente = findViewById(R.id.buttonPasar);
        buttonCerrar = findViewById(R.id.buttonCerrar); // Asegúrate de tener este botón

        bloquear();

        // Recibir datos
        Intent intent = getIntent();
        String nombre = intent.getStringExtra("nombre");
        String apellido = intent.getStringExtra("apellido");
        dividendo = intent.getIntExtra("dividendo", 0);
        divisor = intent.getIntExtra("divisor", 0);
        numero = intent.getIntExtra("numero", 0);

        editTextNombre.setText(nombre);
        editTextApellido.setText(apellido);
        editTextDividendo.setText(String.valueOf(dividendo));
        editTextDivisor.setText(String.valueOf(divisor));
        editTextNumero.setText(String.valueOf(numero));

        buttonSiguiente.setOnClickListener(v -> {
            String nombreStr = editTextNombre.getText().toString().trim();
            String apellidoStr = editTextApellido.getText().toString().trim();

            if (TextUtils.isEmpty(nombreStr) || TextUtils.isEmpty(apellidoStr)) {
                Toast.makeText(this, "Por favor, ingresa ambos campos.", Toast.LENGTH_SHORT).show();
                return;
            }

            Intent i = new Intent(SecondActivity.this, ThirdActivity.class);
            i.putExtra("nombre", nombreStr);
            i.putExtra("apellido", apellidoStr);
            i.putExtra("dividendo", dividendo);
            i.putExtra("divisor", divisor);
            i.putExtra("numero", numero);
            startActivity(i);
        });

        buttonCerrar.setOnClickListener(v -> {
            Intent i = new Intent(SecondActivity.this, MainActivity.class);
            i.putExtra("nombre", editTextNombre.getText().toString());
            i.putExtra("apellido", editTextApellido.getText().toString());
            i.putExtra("dividendo", dividendo);
            i.putExtra("divisor", divisor);
            i.putExtra("numero", numero);
            startActivity(i);
        });
    }

    private void bloquear() {
        editTextDividendo.setEnabled(false);
        editTextDivisor.setEnabled(false);
        editTextNumero.setEnabled(false);
    }
}
