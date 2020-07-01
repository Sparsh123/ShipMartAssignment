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



    double salary=0, saving=0, dairyExp = 0, meatExp = 0, fruitsExp = 0, streetFoodExp = 0, cafeExp = 0, pubExp = 0,
            restaurantExp = 0, clothesExp = 0,
            footwearExp = 0, daalExp = 0, bakeryExp = 0, beveragesExp = 0, snacksExp = 0, beautyExp = 0,
            cleaningExp = 0, kitchenExp = 0,
            babyCareExp = 0,
            transInExp = 0, transOutExp = 0, othersExp = 0;
    ScrollView scroll;
    ImageButton  ibGo;
    View expensesScreen, outputScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etSalary = findViewById(R.id.etSalary);

        ibGo = findViewById(R.id.btnGo);

        expensesScreen = findViewById(R.id.expenses);
        outputScreen = findViewById(R.id.output);
        //expensesScreen.setFocusable(true);
        scroll = findViewById(R.id.scroll);

//        sb50.getThumb().setColorFilter(Color.YELLOW, PorterDuff.Mode.SRC_IN);
//        sb75.getThumb().setColorFilter(Color.YELLOW, PorterDuff.Mode.SRC_IN);
//        sb100.getThumb().setColorFilter(Color.YELLOW, PorterDuff.Mode.SRC_IN);
//
//        sb10.getThumb().setColorFilter(Color.MAGENTA, PorterDuff.Mode.SRC_IN);
//        sb20.getThumb().setColorFilter(Color.MAGENTA, PorterDuff.Mode.SRC_IN);
//        sb30.getThumb().setColorFilter(Color.MAGENTA, PorterDuff.Mode.SRC_IN);




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

                   // expensesScreen.setVisibility(View.VISIBLE);
                    //tvSalary.setText(String.valueOf(salary));
                   // saving = salary-getTotalExpense();
                    //tvSaving.setText(String.valueOf(saving));
//                    tv10.setText(String.valueOf((10*saving)/100));
//                    tv20.setText(String.valueOf((20*saving)/100));
//                    tv30.setText(String.valueOf((30*saving)/100));
//                    tv50.setText(String.valueOf((50*salary)/100));
//                    tv75.setText(String.valueOf((75*salary)/100));
//                    tv100.setText(String.valueOf((100*salary)/100));
//                    salarySaving = (50*salary)/100;
//                    expenseSaving = (10*saving)/100;
//                    scroll.fullScroll(View.FOCUS_DOWN);
//                    scroll.scrollTo(0, scroll.getMaxScrollAmount ());


//
//                    seekBarChangeSalarySaveTrack(sb50, tv50);
//                    seekBarChangeSalarySaveTrack(sb75, tv75);
//                    seekBarChangeSalarySaveTrack(sb100, tv100);
//                    seekBarChangeExpenseSaveTrack(sb10, tv10);
//                    seekBarChangeExpenseSaveTrack(sb20, tv20);
//                    seekBarChangeExpenseSaveTrack(sb30, tv30);

//                    ArrayList<BarEntry> entries = new ArrayList<>();
//                    entries.add(new BarEntry(getAmountAfterInvesting(1/12, 6), 1/12));
//                    entries.add(new BarEntry(getAmountAfterInvesting(1,7), 1));
//                    entries.add(new BarEntry(getAmountAfterInvesting(5,8), 2));
//                    entries.add(new BarEntry(getAmountAfterInvesting(10,10), 3));
//                    entries.add(new BarEntry(getAmountAfterInvesting(20,12), 4));
//
//                    ArrayList<String> labels = new ArrayList<String>();
//                    labels.add(String.valueOf(getAmountAfterInvesting(1, 6)));
//                    labels.add(String.valueOf(getAmountAfterInvesting(1, 7)));
//                    labels.add(String.valueOf(getAmountAfterInvesting(5, 8)));
//                    labels.add(String.valueOf(getAmountAfterInvesting(10, 10)));
//                    labels.add(String.valueOf(getAmountAfterInvesting(20, 12)));
//
//                    drawBarGraph(entries, labels);

//                    BarGraphSeries<DataPoint> series = new BarGraphSeries<DataPoint>(new DataPoint[] {
//                            new DataPoint(0.083, getAmountAfterInvesting(0.083, 6)),
//                            new DataPoint(1, getAmountAfterInvesting(1, 7)),
//                            new DataPoint(5, getAmountAfterInvesting(5, 8)),
//                            new DataPoint(10, getAmountAfterInvesting(10, 10)),
//                            new DataPoint(20, getAmountAfterInvesting(20, 12))
//                    });
//                    gvSaving.removeAllSeries();
//                    gvSaving.addSeries(series);
//
//                    Toast.makeText(getApplicationContext(), "Please Scroll Down", Toast.LENGTH_LONG)
//                            .show();



                }
            }
        });





    }


}
