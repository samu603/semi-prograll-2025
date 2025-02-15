package com.example.miprimeraaplicacion;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.TabHost;

public class MainActivity extends AppCompatActivity {
    TabHost tbh;
    Button btn;
    TextView tempVal;
    Spinner spn;
    Conversores objConversores = new Conversores();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tbh = findViewById(R.id.tbhConversor);
        tbh.setup();
        tbh.addTab(tbh.newTabSpec("Monedas").setContent(R.id.tabMonedas).setIndicator("MONEDAS", null));
        tbh.addTab(tbh.newTabSpec("Longitud").setContent(R.id.tabLongitud).setIndicator("LONGITUD", null));
        tbh.addTab(tbh.newTabSpec("Tiempo").setContent(R.id.tabTiempo).setIndicator("TIEMPO", null));
        tbh.addTab(tbh.newTabSpec("Almacenamiento").setContent(R.id.tabAlmacenamiento).setIndicator("ALMACENAMIENTO", null));

        // Configurar el botón de cálculo
        btn = findViewById(R.id.btnCalcular);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener la pestaña activa
                int opcion = tbh.getCurrentTab();

                // Obtener el Spinner y la cantidad para la conversión
                spn = findViewById(R.id.spnDeMonedas);
                int de = spn.getSelectedItemPosition();

                spn = findViewById(R.id.spnAMonedas);
                int a = spn.getSelectedItemPosition();

                tempVal = findViewById(R.id.txtCantidad);
                double cantidad = Double.parseDouble(tempVal.getText().toString());

                // Realizar la conversión
                tempVal = findViewById(R.id.lblRespuesta);
                double respuesta = objConversores.convertir(opcion, de, a, cantidad);
                tempVal.setText("Respuesta: " + respuesta);
            }
        });
    }

    class Conversores {
        double[][] valores = {
                {1, 0.98, 7.73, 25.45, 36.78, 508.87, 8.74}, // monedas
                {1, 1000, 100, 0.01}, // longitud
                {1, 60, 3600}, // tiempo (segundos a minutos, horas)
                {1, 1024, 1048576}, // almacenamiento (bytes a kilobytes, megabytes)
        };

        // Método para realizar la conversión
        public double convertir(int opcion, int de, int a, double cantidad) {
            if (opcion < valores.length && de < valores[opcion].length && a < valores[opcion].length) {
                return valores[opcion][a] / valores[opcion][de] * cantidad;
            }
            return 0;
        }
    }
}
