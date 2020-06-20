package com.example.shipmart;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etSalary, etDairy, etMeat, etFruits, etStreetFood, etCafe, etPub, etRestaurant, etClothes,
    etFootwear, etDaal, etBakery, etBeverages, etSnacks, etBeauty, etCleaning, etKitchen, etBabyCare,
    etTransIn, etTransOut, etOthers;

    TextView tvSalary, tvSaving;

    Button btnSubmitExp, btnGo, btnPrint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etSalary = findViewById(R.id.etSalary);
        etDairy = findViewById(R.id.etDa);
    }
}
