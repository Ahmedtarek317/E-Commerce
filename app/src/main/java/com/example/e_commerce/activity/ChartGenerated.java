package com.example.e_commerce.activity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.example.e_commerce.Database.MyDatabase;
import com.example.e_commerce.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import java.util.ArrayList;


public class ChartGenerated extends AppCompatActivity {


    MyDatabase database;
    String[] axisData ={"","","",""};
    int[] yAxisData = {0, 0, 0, 0};
    int iter=0;
    int count=0;
    // variable for our bar chart
    TextView mostSelled;
    BarChart barChart;
    // variable for our bar data.
    BarData barData;

    // variable for our bar data set.
    BarDataSet barDataSet;

    // array list for storing entries.
    ArrayList barEntriesArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart_generated);

         mostSelled = findViewById(R.id.most_selled);
         barChart =  findViewById(R.id.genchart);

        database= MyDatabase.getInstance(getApplicationContext());
        getSupportActionBar().setTitle("Chart Generated");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Cursor cursor =database.getCategory();
        if (cursor!=null){
            while (!cursor.isAfterLast()){
                axisData[count++]=cursor.getString(1);
                yAxisData[iter++]=cursor.getInt(2);
                cursor.moveToNext();
            }
        }

        // bar entries.
        barEntriesArrayList = new ArrayList<>();
        barEntriesArrayList.add(new BarEntry(0f, yAxisData[0]));
        barEntriesArrayList.add(new BarEntry(1f, yAxisData[1]));
        barEntriesArrayList.add(new BarEntry(2f, yAxisData[2]));
        barEntriesArrayList.add(new BarEntry(3f, yAxisData[3]));

        // creating a new bar data set.
        barDataSet = new BarDataSet(barEntriesArrayList, "Categories");

        // creating a new bar data and
        // passing our bar data set.
        barData = new BarData(barDataSet);

        // below line is to set data
        // to our bar chart.
        barChart.setData(barData);

        // adding color to our bar data set.
        barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);

        // setting text color.
        barDataSet.setValueTextColor(Color.BLACK);

        // setting text size
        barDataSet.setValueTextSize(16f);
        XAxis xAxis = barChart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(axisData));
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setGranularity(1f);
        barChart.getDescription().setEnabled(false);
        String catNAME=database.get_most_seeled();
        if(!catNAME.isEmpty())
        {
            mostSelled.setText(catNAME);
        }else{
            mostSelled.setText("");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.adminmenu4,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.feedback:
                Intent i1 = new Intent(ChartGenerated.this, ShowRating.class);
                startActivity(i1);
                return true;
            case R.id.report:
                Intent i2 = new Intent(ChartGenerated.this, ReportGenerated.class);
                startActivity(i2);
                return true;
            case R.id.uploadproduct11:
                Intent i3 = new Intent(ChartGenerated.this, UploadProduct.class);
                startActivity(i3);
                return true;
            case R.id.deleteuser:
                Intent i4=new Intent(ChartGenerated.this, deleteUser.class);
                startActivity(i4);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        //onBackPressed();
        Intent intent=new Intent(ChartGenerated.this,UploadProduct.class);
        startActivity(intent);
        return super.onSupportNavigateUp();
    }
}