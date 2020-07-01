package com.example.shipmart;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etSalary;
    double salary = 0;
    ImageButton ibGo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etSalary = findViewById(R.id.etSalary);
        ibGo = findViewById(R.id.btnGo);

        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ibGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etSalary.getText().toString().matches("")) {
                    Toast.makeText(getApplicationContext(), "Please enter your salary", Toast.LENGTH_LONG)
                            .show();
                } else {
                    salary = Double.parseDouble(etSalary.getText().toString());
                    Intent intent = new Intent(getApplicationContext(), ExpenseActivity.class);
                    intent.putExtra("Salary", salary);
                    startActivity(intent);


                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item);
    }
}
