package es.enylrad.economy.mymoney;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.formatter.YAxisValueFormatter;
import com.github.mikephil.charting.utils.ViewPortHandler;

import java.util.ArrayList;

import es.enylrad.economy.mymoney.clases.Concepto;
import es.enylrad.economy.mymoney.custom.StaticMethods;

public class GraficaActivity extends AppCompatActivity {

    private LineChart mChart;
    private LineData data;
    private LineDataSet setComp;

    //Valores de la numericos de la grafica
    private ArrayList<Entry> valores_grafica;
    //Valores de la linea de tiempo X
    private ArrayList<String> xVals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grafica_activity);

        configurarGrafica();
    }

    private void configurarGrafica() {
        configurarLineChart();
        addDatos();

    }

    /**
     * Recogemos los datos desde el servidor
     */
    private void addDatos(){

        valores_grafica = new ArrayList<>();
        xVals = new ArrayList<>();
        int saldo = 0;
        int random;
        for (int i = 0; i < (30*6); i++) {
            xVals.add(String.valueOf(i+1));

            if(i % 30 == 0){
                random = 1050;
            }else {
                random = -50 + (int) (Math.random() * ((1 - (-50)) + 1));
            }
            saldo = saldo + random;
            valores_grafica.add(new Entry(saldo, i));
        }

        configurarLineData();

        data = new LineData(xVals, setComp);
        //Color de los textos de los puntos de la grafica
        data.setValueTextColor(getResources().getColor(android.R.color.white));

        mChart.setData(data);
        mChart.invalidate();


    }

    /**
     * Iniciamos y configuramos la grafica con los elementos basicos
     */
    private void configurarLineChart(){
        //Linchart es toda la pantalla de la grafica
        mChart = (LineChart) findViewById(R.id.chart);
        //Configurar Texto cuando no existen datos
        //mChart.setNoDataText(getString(R.string.loading));
        //Color del fondo de la pantalla
        mChart.setBackgroundColor(getResources().getColor(android.R.color.black));
        //Color de un texto pequeño que sale arriba a la derecha (dentro de la grafica)
        mChart.setDescriptionColor(getResources().getColor(android.R.color.transparent));
        //Animación que aparece cuando se abre la grafica
        mChart.animateX(3000, Easing.EasingOption.EaseInOutCubic);

        //Permitir o no manipular la grafica
        mChart.setTouchEnabled(true);
        //Permite ampliar el eje X
        mChart.setScaleXEnabled(true);
        //Permite ampliar el eje Y
        mChart.setScaleYEnabled(false);
        //Añade margen a la derecha
        mChart.setExtraRightOffset(20);

        configXAxis();
        configYAxis();
        configLegend();
    }

    /**
     * Configuración referente a los valores de X
     */
    private void configXAxis(){
        XAxis xAxis = mChart.getXAxis();
        xAxis.setEnabled(true);
        xAxis.setTextSize(6);
        xAxis.setTextColor(getResources().getColor(android.R.color.white));
    }

    /**
     * Configuración referente a los valores de Y
     */
    private void configYAxis(){
        YAxis yAxis_R = mChart.getAxisRight();
        yAxis_R.setEnabled(false);

        YAxis yAxis_L = mChart.getAxisLeft();
        yAxis_L.setEnabled(true);
        yAxis_L.setTextSize(6);
        yAxis_L.setValueFormatter(new YAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, YAxis yAxis) {
                return StaticMethods.puntosSeparacion((long) value) + "€";
            }
        });
        yAxis_L.setTextColor(getResources().getColor(android.R.color.white));
    }

    /**
     * Configuración referente a la leyenda
     */
    private void configLegend(){
        Legend legend = mChart.getLegend();
        legend.setEnabled(false);
    }

    /**
     * Configuramos los datos y varias configuraciones de los datos que se añadiran a la grafica
     */
    private void configurarLineData(){
        //Clase para aplicar los valores
        setComp = new LineDataSet(valores_grafica, "Valor jugador");
        //Configuramos los valores para que se muestren en forma curva
        setComp.setDrawCubic(true);
        //Quitamos los circulos de la grafica
        setComp.setDrawCircleHole(false);
        setComp.setDrawCircles(false);
        //Habilitamos que se muestre color en la parte inferior de la grafica
        setComp.setDrawFilled(true);
        //Sets the intensity for cubic lines (if enabled). Max = 1f = very cubic, Min = 0.05f = low cubic effect, Default: 0.2f
        setComp.setCubicIntensity(0.05f);
        //El color inferior de la grafica se mostrará de este color
        setComp.setFillColor(getResources().getColor(android.R.color.holo_green_dark));
        //Color de la linea de la grafica
        setComp.setColor(getResources().getColor(R.color.green));
        setComp.setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
                return StaticMethods.puntosSeparacion((long) value) + "€";
            }
        });
    }
}
