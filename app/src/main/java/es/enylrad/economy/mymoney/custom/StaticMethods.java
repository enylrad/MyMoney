package es.enylrad.economy.mymoney.custom;

import android.animation.ValueAnimator;
import android.widget.TextView;

import java.text.DecimalFormat;


public class StaticMethods {

    /**
     * Metodo que anyade los puntos en cifras grandes
     *
     * @param number cantidad que a la que se le realizará la operación
     * @return cantidad modificada
     */
    public static String puntosSeparacion(long number) {
        DecimalFormat formatter = new DecimalFormat("#,###");

        return formatter.format(number);
    }

    /**
     * Metodo que incrementa un numero en un tiempo determinado
     *
     * @param num_ini el número con el que inicia
     * @param num_fin el número al que queremos llegar
     * @param textView el textview que animaremos
     */
    public static void iniciarAnimacionContar(int num_ini, int num_fin, final TextView textView) {
        ValueAnimator animator = new ValueAnimator();
        animator.setObjectValues(num_ini, num_fin);
        animator.setDuration(1000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator animation) {
                textView.setText(String.valueOf((int) animation.getAnimatedValue()));
            }
        });
        animator.start();
    }

    public static void iniciarAnimacionContar(int num_ini, int num_fin, int time, final TextView textView) {
        ValueAnimator animator = new ValueAnimator();
        animator.setObjectValues(num_ini, num_fin);
        animator.setDuration(time);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator animation) {
                textView.setText(String.valueOf((int) animation.getAnimatedValue()));
            }
        });
        animator.start();
    }

    public static void inicarAnimacionContarSaldo(long num_ini, long num_fin, final TextView textView) {
        ValueAnimator animator = new ValueAnimator();
        animator.setObjectValues((int) num_ini, (int) num_fin);
        animator.setDuration(1000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator animation) {
                textView.setText(String.valueOf(StaticMethods.puntosSeparacion((int) animation.getAnimatedValue()) + " €"));
            }
        });
        animator.start();

    }
}
