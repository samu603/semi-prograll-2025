package com.example.miprimeraaplicacion;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button btnEjecutar;
    TextView txtResultado;
    Spinner spOpciones;
    EditText inputNum1, inputNum2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Asignación de elementos
        btnEjecutar = findViewById(R.id.btnEjecutar);
        inputNum1 = findViewById(R.id.inputNum1);
        inputNum2 = findViewById(R.id.inputNum2);
        txtResultado = findViewById(R.id.txtResultado);
        spOpciones = findViewById(R.id.spOpciones);

        btnEjecutar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mensaje = "";
                try {
                    double num1 = inputNum1.getText().toString().isEmpty() ? 0 : Double.parseDouble(inputNum1.getText().toString());
                    double num2 = inputNum2.getText().toString().isEmpty() ? 0 : Double.parseDouble(inputNum2.getText().toString());
                    double resultado = 0.0;

                    switch (spOpciones.getSelectedItemPosition()) {
                        case 0: // Adición
                            resultado = num1 + num2;
                            mensaje = "El resultado de la suma es: " + resultado;
                            break;
                        case 1: // Sustracción
                            resultado = num1 - num2;
                            mensaje = "El resultado de la resta es: " + resultado;
                            break;
                        case 2: // Multiplicación
                            resultado = num1 * num2;
                            mensaje = "El producto es: " + resultado;
                            break;
                        case 3: // División
                            if (num2 == 0) {
                                mensaje = "Error: No se puede dividir entre cero.";
                                break;
                            }
                            resultado = num1 / num2;
                            mensaje = "El resultado de la división es: " + resultado;
                            break;
                        case 4: // Potencia
                            resultado = Math.pow(num1, num2);
                            mensaje = "El resultado de la potencia es: " + resultado;
                            break;
                        case 5: // Porcentaje
                            resultado = (num1 * num2) / 100;
                            mensaje = "El porcentaje es: " + resultado;
                            break;
                        case 6: // Raíz cuadrada
                            if (num1 < 0) {
                                mensaje = "Error: No se puede obtener la raíz cuadrada de un número negativo.";
                                break;
                            }
                            resultado = Math.sqrt(num1);
                            mensaje = "La raíz cuadrada es: " + resultado;
                            break;
                        case 7: // Factorial
                            if (num1 < 0 || num1 != (int) num1) {
                                mensaje = "Error: El factorial solo es válido para enteros positivos.";
                                break;
                            }
                            int n = (int) num1;
                            resultado = 1;
                            for (int i = 1; i <= n; i++) {
                                resultado *= i;
                            }
                            mensaje = "El factorial es: " + resultado;
                            break;
                        case 8: // Residuo
                            if (num2 == 0) {
                                mensaje = "Error: No se puede calcular el módulo con divisor cero.";
                                break;
                            }
                            resultado = num1 % num2;
                            mensaje = "El residuo de la división es: " + resultado;
                            break;
                        case 9: // Mayor de 2 números
                            resultado = Math.max(num1, num2);
                            mensaje = "El número mayor es: " + resultado;
                            break;
                        default:
                            mensaje = "Error: Opción no válida.";
                            break;
                    }

                    txtResultado.setText("Resultado: " + mensaje);
                    Toast.makeText(MainActivity.this, mensaje, Toast.LENGTH_LONG).show();

                } catch (NumberFormatException e) {
                    txtResultado.setText("Error: Ingrese valores numéricos válidos.");
                    mensaje = "Error: Ingrese valores numéricos válidos.";
                    Toast.makeText(MainActivity.this, mensaje, Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
