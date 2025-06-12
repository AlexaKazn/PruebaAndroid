package com.example.prueba02_01_paola_nunez;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {

    private EditText editTextNombre, editTextApellido, editTextDividendo, editTextDivisor, editTextNumero;
    private Button buttonCerrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        editTextNombre = findViewById(R.id.editTextNombre);
        editTextApellido = findViewById(R.id.editTextText2);
        editTextDividendo = findViewById(R.id.editText_Dividendo);
        editTextDivisor = findViewById(R.id.editText_Divisor);
        editTextNumero = findViewById(R.id.editText_Numero);
        buttonCerrar = findViewById(R.id.buttonCerrar);

        editTextNombre.setEnabled(false);
        editTextApellido.setEnabled(false);

        Intent intent = getIntent();
        String nombre = intent.getStringExtra("nombre");
        String apellido = intent.getStringExtra("apellido");

        editTextNombre.setText(nombre);
        editTextApellido.setText(apellido);

        buttonCerrar.setOnClickListener(v -> {
            String sDividendo = editTextDividendo.getText().toString().trim();
            String sDivisor = editTextDivisor.getText().toString().trim();
            String sNumero = editTextNumero.getText().toString().trim();

            if (TextUtils.isEmpty(sDividendo) || TextUtils.isEmpty(sDivisor) || TextUtils.isEmpty(sNumero)) {
                Toast.makeText(this, "Todos los campos numéricos son obligatorios.", Toast.LENGTH_SHORT).show();
                return;
            }

            try {
                int dividendo = Integer.parseInt(sDividendo);
                int divisor = Integer.parseInt(sDivisor);
                int numero = Integer.parseInt(sNumero);

                Intent resultado = new Intent(ThirdActivity.this, SecondActivity.class);
                resultado.putExtra("nombre", nombre);
                resultado.putExtra("apellido", apellido);
                resultado.putExtra("dividendo", dividendo);
                resultado.putExtra("divisor", divisor);
                resultado.putExtra("numero", numero);
                startActivity(resultado);

            } catch (NumberFormatException e) {
                Toast.makeText(this, "Solo se permiten números válidos.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
