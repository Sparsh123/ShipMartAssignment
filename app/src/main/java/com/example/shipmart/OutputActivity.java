package com.example.shipmart;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.text.DecimalFormat;
import java.util.ArrayList;

import static java.lang.Math.pow;

public class OutputActivity extends AppCompatActivity {
    ImageButton  ibPrint;
    TextView tvCriteria, tvSalary, tvSaving, tv10, tv20, tv30, tv50, tv75, tv100;
    SeekBar sb10, sb20, sb30, sb50, sb75, sb100;
    BarChart gvSaving;
    double salarySaving =0, expenseSaving=0, savingGraph=0, salary=0, expense=0, saving=0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.output);
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

        salary = getIntent().getDoubleExtra("Salary", 0);
        expense = getIntent().getDoubleExtra("Expense", 0);

        tvSalary.setText("₹ "+String.valueOf(salary));
                saving = salary-expense;
                tvSaving.setText("₹ "+String.valueOf(saving));
                tv10.setText("₹ "+String.valueOf((10*expense)/100));
                tv20.setText("₹ "+String.valueOf((20*expense)/100));
                tv30.setText("₹ "+String.valueOf((30*expense)/100));
                tv50.setText("₹ "+String.valueOf((50*(saving))/100));
                tv75.setText("₹ "+String.valueOf((75*(saving))/100));
                tv100.setText("₹ "+String.valueOf((100*(saving))/100));
                salarySaving = (50*salary)/100;
                expenseSaving = (10*saving)/100;
                tvCriteria.setText("*(₹ " + salary +" - "+ "₹ "+expense+")");
                savingGraph = (100*(salary-expense)/100);


                seekBarChangeSalarySaveTrack(sb50, tv50);
                seekBarChangeSalarySaveTrack(sb75, tv75);
                seekBarChangeSalarySaveTrack(sb100, tv100);
                seekBarChangeExpenseSaveTrack(sb10, tv10);
                seekBarChangeExpenseSaveTrack(sb20, tv20);
                seekBarChangeExpenseSaveTrack(sb30, tv30);

                ArrayList<BarEntry> entries = new ArrayList<>();
                entries.add(new BarEntry(getAmountAfterInvesting(1/12, 0.06), 1/12));
                entries.add(new BarEntry(getAmountAfterInvesting(1,0.07), 1));
                entries.add(new BarEntry(getAmountAfterInvesting(5,0.08), 5));
                entries.add(new BarEntry(getAmountAfterInvesting(10,0.010), 10));
                entries.add(new BarEntry(getAmountAfterInvesting(20,0.012), 20));

                ArrayList<String> labels = new ArrayList<String>();
                labels.add(String.valueOf(getAmountAfterInvesting(1/12, 0.06)));
                labels.add(String.valueOf(getAmountAfterInvesting(1, 0.07)));
                labels.add(String.valueOf(getAmountAfterInvesting(5, 0.08)));
                labels.add(String.valueOf(getAmountAfterInvesting(10, 0.010)));
                labels.add(String.valueOf(getAmountAfterInvesting(20, 0.012)));

                drawBarGraph(entries, labels);



        Toast.makeText(getApplicationContext(), "Please Scroll Down", Toast.LENGTH_LONG)
                .show();





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

                savingGraph = (progress*(saving))/100;
                tv.setText("₹ "+ String.valueOf(salarySaving));
                ArrayList<BarEntry> entries = new ArrayList<>();
                entries.add(new BarEntry(getAmountAfterInvesting(1/12, 0.06), 1/12));
                entries.add(new BarEntry(getAmountAfterInvesting(1,0.07), 1));
                entries.add(new BarEntry(getAmountAfterInvesting(5,0.08), 5));
                entries.add(new BarEntry(getAmountAfterInvesting(10,0.010), 10));
                entries.add(new BarEntry(getAmountAfterInvesting(20,0.012), 20));

                ArrayList<String> labels = new ArrayList<String>();
                labels.add(String.valueOf(getAmountAfterInvesting(1/12, 0.06)));
                labels.add(String.valueOf(getAmountAfterInvesting(1, 0.07)));
                labels.add(String.valueOf(getAmountAfterInvesting(5, 0.08)));
                labels.add(String.valueOf(getAmountAfterInvesting(10, 0.010)));
                labels.add(String.valueOf(getAmountAfterInvesting(20, 0.012)));

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
                expenseSaving=(progress*expense)/100;

                tv.setText("₹ " + String.valueOf(expenseSaving));
//                ArrayList<BarEntry> entries = new ArrayList<>();
//                entries.add(new BarEntry(getAmountAfterInvesting(1, 6), 0));
//                entries.add(new BarEntry(getAmountAfterInvesting(1,7), 1));
//                entries.add(new BarEntry(getAmountAfterInvesting(5,8), 2));
//                entries.add(new BarEntry(getAmountAfterInvesting(10,10), 3));
//                entries.add(new BarEntry(getAmountAfterInvesting(20,12), 4));
//
//                ArrayList<String> labels = new ArrayList<String>();
//                labels.add(String.valueOf(getAmountAfterInvesting(1, 6)));
//                labels.add(String.valueOf(getAmountAfterInvesting(1, 7)));
//                labels.add(String.valueOf(getAmountAfterInvesting(5, 8)));
//                labels.add(String.valueOf(getAmountAfterInvesting(10, 10)));
//                labels.add(String.valueOf(getAmountAfterInvesting(20, 12)));
//
//                drawBarGraph(entries, labels);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }




    private int getAmountAfterInvesting(double time, double rate)
    {
        double principle=0, interest=0, amount=0;
        int n=1;
        principle = savingGraph;
        amount = principle* (pow((1 + (rate/n)),(n*time)));
        DecimalFormat df = new DecimalFormat("#.##");

        double retVal = Double.valueOf(df.format(amount));
        return (int)retVal;
    }
}
