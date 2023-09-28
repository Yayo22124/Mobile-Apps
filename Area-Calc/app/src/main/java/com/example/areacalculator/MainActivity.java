package com.example.areacalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // Declaracion de variables
    private EditText etBase;
    private EditText etAltura;
    private TextView result;
    private Button btnCalc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Toolbar
        Toolbar toolbar =findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Variables para calcular
        etBase = findViewById(R.id.etBase);
        etAltura = findViewById(R.id.etAltura);
        result = findViewById(R.id.result);
        btnCalc = findViewById(R.id.btnCalc);
        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Obtén la base y la altura ingresadas por el usuario
                double base = Double.parseDouble(etBase.getText().toString());
                double height = Double.parseDouble(etAltura.getText().toString());

                // Calcula el área del triángulo
                double area = 0.5 * base * height;

                // Muestra el resultado en el TextView
                result.setText("Resultado: " + area + " cm²");
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_exit) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}