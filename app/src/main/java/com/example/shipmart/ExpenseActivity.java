package com.example.shipmart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.github.mikephil.charting.data.BarEntry;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class ExpenseActivity extends AppCompatActivity {
    EditText etDairy, etMeat, etFruits, etStreetFood, etCafe, etPub, etRestaurant, etClothes,
            etFootwear, etDaal, etBakery, etBeverages, etSnacks, etBeauty, etCleaning, etKitchen, etBabyCare,
            etTransIn, etTransOut, etOthers;

    RadioGroup rgDairy, rgMeat, rgFruits, rgStreetFood, rgCafe, rgPub, rgRestaurant, rgClothes,
            rgFootwear, rgDaal, rgBakery, rgBeverages, rgSnacks, rgBeauty, rgCleaning, rgKitchen, rgBabyCare,
            rgTransIn, rgTransOut, rgOthers;

    ImageButton ibSubmitExp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.expenses);
        etDairy = findViewById(R.id.etDairyAmt);
        etMeat = findViewById(R.id.etMeatAmt);
        etFruits = findViewById(R.id.etFruitsAmt);
        etStreetFood = findViewById(R.id.etStreetFoodAmt);
        etCafe = findViewById(R.id.etCafeAmt);
        etPub = findViewById(R.id.etPubAmt);
        etRestaurant = findViewById(R.id.etRestaurantAmt);
        etClothes = findViewById(R.id.etClothesAmt);
        etFootwear = findViewById(R.id.etFootwearAmt);
        etDaal = findViewById(R.id.etDaalAmt);
        etBakery = findViewById(R.id.etBakeryAmt);
        etBeverages = findViewById(R.id.etBeveragesAmt);
        etSnacks = findViewById(R.id.etSnacksAmt);
        etBeauty = findViewById(R.id.etBeautyAmt);
        etCleaning = findViewById(R.id.etCleaningAmt);
        etKitchen = findViewById(R.id.etKitchenAmt);
        etBabyCare = findViewById(R.id.etBabyCareAmt);
        etTransIn = findViewById(R.id.etTransInAmt);
        etTransOut = findViewById(R.id.etTransOutAmt);
        etOthers = findViewById(R.id.etOthersAmt);
        rgDairy = findViewById(R.id.rgDairy);
        rgMeat = findViewById(R.id.rgMeat);
        rgFruits = findViewById(R.id.rgFruits);
        rgStreetFood = findViewById(R.id.rgStreetFood);
        rgCafe = findViewById(R.id.rgCafe);
        rgPub = findViewById(R.id.rgPub);
        rgRestaurant = findViewById(R.id.rgRestaurant);
        rgClothes = findViewById(R.id.rgClothes);
        rgFootwear = findViewById(R.id.rgFootwear);
        rgDaal = findViewById(R.id.rgDaal);
        rgBakery = findViewById(R.id.rgBakery);
        rgBeverages = findViewById(R.id.rgBeverages);
        rgSnacks = findViewById(R.id.rgSnacks);
        rgBeauty = findViewById(R.id.rgBeauty);
        rgCleaning = findViewById(R.id.rgCleaning);
        rgKitchen = findViewById(R.id.rgKitchen);
        rgBabyCare = findViewById(R.id.rgBabyCare);
        rgTransIn = findViewById(R.id.rgTransIn);
        rgTransOut = findViewById(R.id.rgTransOut);
        rgOthers = findViewById(R.id.rgOthers);
        ibSubmitExp = findViewById(R.id.btnSubMitExp);

        if (getSupportActionBar()!=null)
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ibSubmitExp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double salary = getIntent().getDoubleExtra("Salary", 0);

                Intent intent = new Intent(getApplicationContext(), OutputActivity.class);
                intent.putExtra("Salary", salary);
                intent.putExtra("Expense", getTotalExpense());
                startActivity(intent);

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

    private String getExpenseType(RadioGroup rg) {
        // get selected radio button from radioGroup
        int selectedId = rg.getCheckedRadioButtonId();

        // find the radiobutton by returned id
        RadioButton radioButton = (RadioButton) findViewById(selectedId);

        return radioButton.getText().toString();
    }

    private double getIndividualExpense(RadioGroup rg, EditText et) {
        double exp=0;
        if (getExpenseType(rg).equalsIgnoreCase("D")) {
            if (!et.getText().toString().matches("")) {
                exp=  Double.parseDouble(et.getText().toString()) * 30;
            }
        } else if (getExpenseType(rg).equalsIgnoreCase("W")) {
            if (!et.getText().toString().matches("")) {
                exp= Double.parseDouble(et.getText().toString()) * 4.35;
            }
        } else if (getExpenseType(rg).equalsIgnoreCase("M")) {
            if (!et.getText().toString().matches("")) {
                exp= Double.parseDouble(et.getText().toString());
            }
        }
        DecimalFormat df = new DecimalFormat("#.##");

        return Double.valueOf(df.format(exp));
    }

    private double getTotalExpense()
    {
        double exp=0;
        exp = getIndividualExpense(rgDairy, etDairy) + getIndividualExpense(rgMeat, etMeat)+
                getIndividualExpense(rgFruits, etFruits)+ getIndividualExpense(rgStreetFood, etStreetFood)+
                getIndividualExpense(rgCafe, etCafe)+ getIndividualExpense(rgPub, etPub)+
                getIndividualExpense(rgRestaurant, etRestaurant)+ getIndividualExpense(rgClothes, etClothes)+
                getIndividualExpense(rgFootwear, etFootwear)+ getIndividualExpense(rgDaal, etDaal)+
                getIndividualExpense(rgBakery, etBakery)+ getIndividualExpense(rgBeverages, etBeverages)+
                getIndividualExpense(rgSnacks, etSnacks)+ getIndividualExpense(rgBeauty, etBeauty)+
                getIndividualExpense(rgCleaning, etCleaning)+ getIndividualExpense(rgKitchen, etKitchen)+
                getIndividualExpense(rgBabyCare, etBabyCare)+ getIndividualExpense(rgTransOut, etTransOut)+
                getIndividualExpense(rgTransIn, etTransIn)+ getIndividualExpense(rgOthers, etOthers);
        return exp;
    }
}
