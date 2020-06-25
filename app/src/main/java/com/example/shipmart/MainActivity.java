package com.example.shipmart;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText etSalary, etDairy, etMeat, etFruits, etStreetFood, etCafe, etPub, etRestaurant, etClothes,
            etFootwear, etDaal, etBakery, etBeverages, etSnacks, etBeauty, etCleaning, etKitchen, etBabyCare,
            etTransIn, etTransOut, etOthers;

    RadioGroup rgDairy, rgMeat, rgFruits, rgStreetFood, rgCafe, rgPub, rgRestaurant, rgClothes,
            rgFootwear, rgDaal, rgBakery, rgBeverages, rgSnacks, rgBeauty, rgCleaning, rgKitchen, rgBabyCare,
            rgTransIn, rgTransOut, rgOthers;

    double salary=0, saving=0, dairyExp = 0, meatExp = 0, fruitsExp = 0, streetFoodExp = 0, cafeExp = 0, pubExp = 0,
            restaurantExp = 0, clothesExp = 0,
            footwearExp = 0, daalExp = 0, bakeryExp = 0, beveragesExp = 0, snacksExp = 0, beautyExp = 0,
            cleaningExp = 0, kitchenExp = 0,
            babyCareExp = 0,
            transInExp = 0, transOutExp = 0, othersExp = 0;
    TextView tvCriteria, tvSalary, tvSaving, tv10, tv20, tv30, tv50, tv75, tv100;
    SeekBar sb10, sb20, sb30, sb50, sb75, sb100;
    ImageButton ibSubmitExp, ibPrint, ibGo;
    View expensesScreen, outputScreen;
    double salarySaving =0, expenseSaving=0;
    BarChart gvSaving;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etSalary = findViewById(R.id.etSalary);
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
        ibGo = findViewById(R.id.btnGo);
        ibSubmitExp = findViewById(R.id.btnSubMitExp);
        ibPrint = findViewById(R.id.btnPrint);
        tvSalary = findViewById(R.id.tvSalary);
        tvSaving = findViewById(R.id.tvSaving);
        sb10=findViewById(R.id.sb10);
        sb20=findViewById(R.id.sb20);
        sb30=findViewById(R.id.sb30);
        sb50=findViewById(R.id.sb50);
        sb75=findViewById(R.id.sb75);
        sb100=findViewById(R.id.sb100);
        tv10=findViewById(R.id.tv10);
        tv20=findViewById(R.id.tv20);
        tv30=findViewById(R.id.tv30);
        tv50=findViewById(R.id.tv50);
        tv75=findViewById(R.id.tv75);
        tv100=findViewById(R.id.tv100);
        tvCriteria=findViewById(R.id.tvCriteria);
        gvSaving = findViewById(R.id.gvSaving);
        expensesScreen = findViewById(R.id.expenses);
        outputScreen = findViewById(R.id.output);
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
                    expensesScreen.setVisibility(View.VISIBLE);
                    tvSalary.setText(String.valueOf(salary));
                    saving = salary-getTotalExpense();
                    tvSaving.setText(String.valueOf(saving));
                    tv10.setText(String.valueOf((10*saving)/100));
                    tv20.setText(String.valueOf((20*saving)/100));
                    tv30.setText(String.valueOf((30*saving)/100));
                    tv50.setText(String.valueOf((50*salary)/100));
                    tv75.setText(String.valueOf((75*salary)/100));
                    tv100.setText(String.valueOf((100*salary)/100));
                    salarySaving = (50*salary)/100;
                    expenseSaving = (10*saving)/100;

                    seekBarChangeSalarySaveTrack(sb50, tv50);
                    seekBarChangeSalarySaveTrack(sb75, tv75);
                    seekBarChangeSalarySaveTrack(sb100, tv100);
                    seekBarChangeExpenseSaveTrack(sb10, tv10);
                    seekBarChangeExpenseSaveTrack(sb20, tv20);
                    seekBarChangeExpenseSaveTrack(sb30, tv30);

                    ArrayList<BarEntry> entries = new ArrayList<>();
                    entries.add(new BarEntry(getAmountAfterInvesting(1, 6), 0));
                    entries.add(new BarEntry(getAmountAfterInvesting(1,7), 1));
                    entries.add(new BarEntry(getAmountAfterInvesting(5,8), 2));
                    entries.add(new BarEntry(getAmountAfterInvesting(10,10), 3));
                    entries.add(new BarEntry(getAmountAfterInvesting(20,12), 4));

                    ArrayList<String> labels = new ArrayList<String>();
                    labels.add(String.valueOf(getAmountAfterInvesting(1, 6)));
                    labels.add(String.valueOf(getAmountAfterInvesting(1, 7)));
                    labels.add(String.valueOf(getAmountAfterInvesting(5, 8)));
                    labels.add(String.valueOf(getAmountAfterInvesting(10, 10)));
                    labels.add(String.valueOf(getAmountAfterInvesting(20, 12)));

                    drawBarGraph(entries, labels);

//                    BarGraphSeries<DataPoint> series = new BarGraphSeries<DataPoint>(new DataPoint[] {
//                            new DataPoint(0.083, getAmountAfterInvesting(0.083, 6)),
//                            new DataPoint(1, getAmountAfterInvesting(1, 7)),
//                            new DataPoint(5, getAmountAfterInvesting(5, 8)),
//                            new DataPoint(10, getAmountAfterInvesting(10, 10)),
//                            new DataPoint(20, getAmountAfterInvesting(20, 12))
//                    });
//                    gvSaving.removeAllSeries();
//                    gvSaving.addSeries(series);

                    Toast.makeText(getApplicationContext(), "Please Scroll Down", Toast.LENGTH_LONG)
                            .show();



                }
            }
        });

        ibSubmitExp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                outputScreen.setVisibility(View.VISIBLE);
                tvSalary.setText("₹ "+String.valueOf(salary));
                saving = salary-getTotalExpense();
                tvSaving.setText("₹ "+String.valueOf(saving));
                tv10.setText("₹ "+String.valueOf((10*saving)/100));
                tv20.setText("₹ "+String.valueOf((20*saving)/100));
                tv30.setText("₹ "+String.valueOf((30*saving)/100));
                tv50.setText("₹ "+String.valueOf((50*salary)/100));
                tv75.setText("₹ "+String.valueOf((75*salary)/100));
                tv100.setText("₹ "+String.valueOf((100*salary)/100));
                salarySaving = (50*salary)/100;
                expenseSaving = (10*saving)/100;
                tvCriteria.setText("*(₹ " + salary +" - "+ "₹ "+getTotalExpense()+")");

                seekBarChangeSalarySaveTrack(sb50, tv50);
                seekBarChangeSalarySaveTrack(sb75, tv75);
                seekBarChangeSalarySaveTrack(sb100, tv100);
                seekBarChangeExpenseSaveTrack(sb10, tv10);
                seekBarChangeExpenseSaveTrack(sb20, tv20);
                seekBarChangeExpenseSaveTrack(sb30, tv30);

                ArrayList<BarEntry> entries = new ArrayList<>();
                entries.add(new BarEntry(getAmountAfterInvesting(1, 6), 0));
                entries.add(new BarEntry(getAmountAfterInvesting(1,7), 1));
                entries.add(new BarEntry(getAmountAfterInvesting(5,8), 2));
                entries.add(new BarEntry(getAmountAfterInvesting(10,10), 3));
                entries.add(new BarEntry(getAmountAfterInvesting(20,12), 4));

                ArrayList<String> labels = new ArrayList<String>();
                labels.add(String.valueOf(getAmountAfterInvesting(1, 6)));
                labels.add(String.valueOf(getAmountAfterInvesting(1, 7)));
                labels.add(String.valueOf(getAmountAfterInvesting(5, 8)));
                labels.add(String.valueOf(getAmountAfterInvesting(10, 10)));
                labels.add(String.valueOf(getAmountAfterInvesting(20, 12)));

                drawBarGraph(entries, labels);

//                BarGraphSeries<DataPoint> series = new BarGraphSeries<DataPoint>(new DataPoint[] {
//                        new DataPoint(0.083, getAmountAfterInvesting(0.083, 6)),
//                        new DataPoint(1, getAmountAfterInvesting(1, 7)),
//                        new DataPoint(5, getAmountAfterInvesting(5, 8)),
//                        new DataPoint(10, getAmountAfterInvesting(10, 10)),
//                        new DataPoint(20, getAmountAfterInvesting(20, 12))
//                });
//                gvSaving.removeAllSeries();
//                gvSaving.addSeries(series);

                Toast.makeText(getApplicationContext(), "Please Scroll Down", Toast.LENGTH_LONG)
                        .show();

            }
        });

        ibPrint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Printer Is Not Connected To Your Device", Toast.LENGTH_LONG).show();
            }
        });



    }

    private void drawBarGraph(ArrayList<BarEntry> entries, ArrayList<String> labels)
    {
        BarDataSet bardataset = new BarDataSet(entries, "Cells");
        BarData data = new BarData(labels, bardataset);
        gvSaving.setData(data); // set the data and list of labels into chart
//        gvSaving.setDescription("Set Bar Chart Description Here");  // set the description
        bardataset.setColors(ColorTemplate.COLORFUL_COLORS);
        gvSaving.animateY(5000);



    }

    private void seekBarChangeSalarySaveTrack(SeekBar sb, final TextView tv)
    {
        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {

                salarySaving = (progress*salary)/100;
                tv.setText("₹ "+ String.valueOf(salarySaving));
                ArrayList<BarEntry> entries = new ArrayList<>();
                entries.add(new BarEntry(getAmountAfterInvesting(1, 6), 0));
                entries.add(new BarEntry(getAmountAfterInvesting(1,7), 1));
                entries.add(new BarEntry(getAmountAfterInvesting(5,8), 2));
                entries.add(new BarEntry(getAmountAfterInvesting(10,10), 3));
                entries.add(new BarEntry(getAmountAfterInvesting(20,12), 4));

                ArrayList<String> labels = new ArrayList<String>();
                labels.add(String.valueOf(getAmountAfterInvesting(1, 6)));
                labels.add(String.valueOf(getAmountAfterInvesting(1, 7)));
                labels.add(String.valueOf(getAmountAfterInvesting(5, 8)));
                labels.add(String.valueOf(getAmountAfterInvesting(10, 10)));
                labels.add(String.valueOf(getAmountAfterInvesting(20, 12)));

                drawBarGraph(entries, labels);


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }

    private void seekBarChangeExpenseSaveTrack(SeekBar sb, final TextView tv)
    {
        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {

                expenseSaving = (progress*saving)/100;
                tv.setText("₹ " + String.valueOf(expenseSaving));
                ArrayList<BarEntry> entries = new ArrayList<>();
                entries.add(new BarEntry(getAmountAfterInvesting(1, 6), 0));
                entries.add(new BarEntry(getAmountAfterInvesting(1,7), 1));
                entries.add(new BarEntry(getAmountAfterInvesting(5,8), 2));
                entries.add(new BarEntry(getAmountAfterInvesting(10,10), 3));
                entries.add(new BarEntry(getAmountAfterInvesting(20,12), 4));

                ArrayList<String> labels = new ArrayList<String>();
                labels.add(String.valueOf(getAmountAfterInvesting(1, 6)));
                labels.add(String.valueOf(getAmountAfterInvesting(1, 7)));
                labels.add(String.valueOf(getAmountAfterInvesting(5, 8)));
                labels.add(String.valueOf(getAmountAfterInvesting(10, 10)));
                labels.add(String.valueOf(getAmountAfterInvesting(20, 12)));

                drawBarGraph(entries, labels);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
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

        return exp;
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

    private int getAmountAfterInvesting(double time, int rate)
    {
        double principle=0, interest=0;
        principle = salarySaving + expenseSaving;
        interest = (principle*time*rate)/100;
        return (int)(principle+interest);
    }
}
