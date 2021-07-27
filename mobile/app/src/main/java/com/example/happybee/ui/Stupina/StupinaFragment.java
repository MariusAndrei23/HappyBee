package com.example.happybee.ui.Stupina;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Pie;
import com.example.happybee.Pagina_de_info;
import com.example.happybee.R;

import java.util.ArrayList;
import java.util.List;

public class StupinaFragment extends Fragment {

    private StupinaViewModel stupinaViewModel;
    AnyChartView anyChartView;

    TextView iconInfo;

    String[] months={"jan","feb","mar"};
    int[] earn={500,800,2000};

//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        getActivity().setContentView(R.layout.fragment_stupina);
//        anyChartView=anyChartView.findViewById(R.id.any_chart_view);
//        setupPieChart();
//    }

    public void setupPieChart()
    {
        Pie pie= AnyChart.pie();
        List<DataEntry> dataEntries= new ArrayList<>();

        for(int i=0;i<months.length;i++) {
            dataEntries.add(new ValueDataEntry(months[i], earn[i]));
        }

        pie.data(dataEntries);
        anyChartView.setChart(pie);
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        stupinaViewModel =
                new ViewModelProvider(this).get(StupinaViewModel.class);
        View root = inflater.inflate(R.layout.fragment_stupina, container, false);
        anyChartView=root.findViewById(R.id.any_chart_view);
        setupPieChart();
        //final TextView textView = root.findViewById(R.id.text_slideshow);
        stupinaViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

                //textView.setText(s);
            }
        });

        iconInfo=root.findViewById(R.id.iconInfoStupina);
        iconInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), Pagina_de_info.class);
                startActivity(intent);
            }
        });

        return root;
    }
}