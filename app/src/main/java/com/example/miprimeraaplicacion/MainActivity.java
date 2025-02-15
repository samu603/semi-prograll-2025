package com.example.miprimeraaplicacion;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btn;
    TextView tempVal;
    Spinner spn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btnCalcular);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempVal = findViewById(R.id.txtNum1);
                double num1 = Double.parseDouble(tempVal.getText().toString());
                tempVal = findViewById(R.id.txtNum2);
                double num2 = Double.parseDouble(tempVal.getText().toString());
                double respuesta = 0.0;

                spn = findViewById(R.id.spnOpciones);
                switch (spn.getSelectedItemPosition()){
                    case 0:
                        respuesta = num1 + num2;
                        break;
                    case 1:
                        respuesta = num1 - num2;
                        break;
                    case 2:
                        respuesta = num1 * num2;
                        break;
                    case 3:
                        respuesta = num1 / num2;
                        break;

                }
                tempVal = findViewById(R.id.lblRespuesta);
                tempVal.setText("Respuesta: "+ respuesta);

            }
        });

    }
}

