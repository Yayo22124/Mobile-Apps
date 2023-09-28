package com.example.fundamentals_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText etName;
    private EditText etAge;
    private Button btnAccept;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        etName = findViewById(R.id.etName);
        etAge = findViewById(R.id.etAge);
        String ageStr = etAge.getText().toString();
        btnAccept = findViewById(R.id.btnAccept);
        btnAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = etName.getText().toString();
                byte age = Byte.parseByte(etAge.getText().toString());

                if (!ageStr.isEmpty()) { // Validar que no este vació
                    if (age < 1 || age > 126) {
                        etAge.setError("Edad fuera de rango permitido.");
                        return;
                    }
                }


                Toast.makeText(MainActivity.this, "Hola " + name, Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this, "Tienes " + age + " años", Toast.LENGTH_SHORT).show();
            }
        });
    }

            @Override
            public boolean onCreateOptionsMenu(Menu menu) {
                getMenuInflater().inflate(R.menu.menu_main,menu);
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