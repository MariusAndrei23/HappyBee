package com.example.happybee.ui.Statistici;

import android.content.Intent;
import android.os.Bundle;
import android.util.EventLogTags;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.happybee.BarDates;
import com.example.happybee.Pagina_de_info;
import com.example.happybee.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class StatisticiFragment extends Fragment {

    private StatisticiViewModel statisticiViewModel;


    BarChart barChart;
    ArrayList<BarEntry> barEntryArrayList;
    ArrayList<String> labelNames;

    ArrayList<BarDates> barDates = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        statisticiViewModel =
                new ViewModelProvider(this).get(StatisticiViewModel.class);
        View root = inflater.inflate(R.layout.fragment_statistici, container, false);
        //////////////////////////////


        /////////////////////////////
        barChart=root.findViewById(R.id.barChart);
        //
        barEntryArrayList =new ArrayList<>();
        labelNames=new ArrayList<>();

        barEntryArrayList.clear();
        labelNames.clear();

        fillMouthSales();
        for(int i=0;i<barDates.size();i++)
        {
            String mont = barDates.get(i).getMonth();
            int sales=barDates.get(i).getSales();
            barEntryArrayList.add(new BarEntry(i,sales));
            labelNames.add(mont);
        }

        BarDataSet barDataSet = new BarDataSet(barEntryArrayList, "Monthly sales" );
        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        Description description=new Description();
        description.setText("Months");
        barChart.setDescription(description);
        BarData barData=new BarData(barDataSet);
        barChart.setData(barData);

        XAxis xAxis=barChart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(labelNames));

        xAxis.setPosition(XAxis.XAxisPosition.TOP);
        xAxis.setDrawGridLines(false);
        xAxis.setDrawAxisLine(false);
        xAxis.setGranularity(1f);
        xAxis.setLabelCount(labelNames.size());
        xAxis.setLabelRotationAngle(270);
        barChart.animateY(2000);
        barChart.invalidate();


        ///////////////////////
        //final TextView textView = root.findViewById(R.id.text_gallery);
        statisticiViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

                //textView.setText(s);
            }
        });
        return root;
    }

    private void fillMouthSales(){
        barDates.clear();
        barDates.add(new BarDates("Januarty",1));
        barDates.add(new BarDates("February",2));
        barDates.add(new BarDates("March",3));
        barDates.add(new BarDates("April",4));
        barDates.add(new BarDates("May",5));
        barDates.add(new BarDates("June",6));
        barDates.add(new BarDates("July",7));
        barDates.add(new BarDates("August",8));
        barDates.add(new BarDates("September",9));
        barDates.add(new BarDates("October",10));
        barDates.add(new BarDates("November",11));
        barDates.add(new BarDates("December",12));

    }
}