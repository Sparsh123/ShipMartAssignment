package com.example.shipmart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.text.DecimalFormat;
import java.util.ArrayList;

import static java.lang.Math.pow;
import static java.lang.Math.round;

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
}
