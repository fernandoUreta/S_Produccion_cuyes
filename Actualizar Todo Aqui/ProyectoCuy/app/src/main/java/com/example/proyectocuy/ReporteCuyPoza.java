package com.example.proyectocuy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Pie;
import com.anychart.enums.Align;
import com.anychart.enums.LegendLayout;

import java.util.ArrayList;
import java.util.List;

public class ReporteCuyPoza extends AppCompatActivity {
    AnyChartView anyChartView;
    String[] pozas={"Empadre","Recria","Gazapos","Padrillos"};
    int[] cantidad={BD_ProduccionCuyes.consultarReporteCuy("A%"),
            BD_ProduccionCuyes.consultarReporteCuy("B%"),
            BD_ProduccionCuyes.consultarReporteCuy("C%"),
            BD_ProduccionCuyes.consultarReporteCuy("D%")};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporte_cuy_poza);
        anyChartView=findViewById(R.id.any_chart_view);
        setupPieChart();
    }
    public void setupPieChart(){
        Pie pie= AnyChart.pie();
        List<DataEntry> dataEntries=new ArrayList<>();
        for (int i=0;i<pozas.length;i++){
            dataEntries.add(new ValueDataEntry(pozas[i],cantidad[i]));
        }
        pie.data(dataEntries);
        pie.title("Cantidad de cuyes por poza");

        pie.labels().position("inside");

        pie.legend().title().enabled(true);
        pie.legend().title()
                .text("Reporte")
                .padding(0d, 0d, 10d, 0d);

        pie.legend()
                .position("center-bottom")
                .itemsLayout(LegendLayout.HORIZONTAL)
                .align(Align.CENTER);

        anyChartView.setChart(pie);
    }
}