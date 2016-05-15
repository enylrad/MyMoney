package es.enylrad.economy.mymoney;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Main extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        Button btn_registros = (Button) findViewById(R.id.registros);
        Button btn_grafica = (Button) findViewById(R.id.grafica);
        if (btn_registros != null ) {
            btn_registros.setOnClickListener(this);
        }
        if (btn_grafica != null) {
            btn_grafica.setOnClickListener(this);
        }

    }

    @Override
    public void onClick(View v) {

        Intent intent;

        switch (v.getId()){

            case R.id.registros:
                intent = new Intent(Main.this, RegistrosActivity.class);
                startActivity(intent);
                break;

            case R.id.grafica:
                intent = new Intent(Main.this, GraficaActivity.class);
                startActivity(intent);
                break;
        }

    }
}