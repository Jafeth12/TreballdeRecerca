package com.example.testandroid.Fragments.Fisica;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.testandroid.FisicaActivity;
import com.example.testandroid.R;

public class FragmentCaidaLibre extends Fragment {

    private TextInputLayout inputG;
    private TextInputLayout inputT;

    private double calcularArea(double b, double h) {
        return (b*h)/2;
    }

    public double parse(String number) {
        return Double.parseDouble(number);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_caidalibre, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Button btn = getView().findViewById(R.id.fisicaFF_btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = getView().findViewById(R.id.fisicaFF_result);
                TextInputLayout inputG = getView().findViewById(R.id.fisicaFF_inputG);
                TextInputLayout inputT = getView().findViewById(R.id.fisicaFF_inputTiempo);
                EditText y01 = getView().findViewById(R.id.fisicaFF_valueY0);
                EditText y11 = getView().findViewById(R.id.fisicaFF_valueY1);
                EditText v01 = getView().findViewById(R.id.fisicaFF_valueV0);
                EditText t1 = getView().findViewById(R.id.fisicaFF_valueTiempo);
                EditText g1 = getView().findViewById(R.id.fisicaFF_valueG);
                String valueY0 = y01.getText().toString();
                String valueY1 = y11.getText().toString();
                String valueV0 = v01.getText().toString();
                String valueT = t1.getText().toString();
                String valueG = g1.getText().toString();

                /*
                if (parse(valueT) < 0) {
                    textView.setText("");
                    inputT.setError("Can't be negative!");
                    return;
                } else if (parse(valueG) < 0) {
                    textView.setText("");
                    inputG.setError("Can't be negative!");
                    return;
                }
                 */

                if (valueT.equals("")) {
                    if (valueV0.equals("0")) {
                        double y1 = parse(valueY1);
                        double y0 = parse(valueY0);
                        double g = parse(valueG);
                        double res = Math.sqrt((y0-y1)/((g/2)*-1));
                        if (Double.isNaN(res)) {
                            textView.setText(R.string.tNo);
                        } else {
                            textView.setText("t = " + String.format("%.2f", res) + "s");
                        }
                    } else if (valueY0.equals("0")) {
                        double y1 = parse(valueY1);
                        double g = parse(valueG);
                        double v0 = parse(valueV0);
                        double o = (v0*v0)-4*((g/2)*(y1*-1));
                        if (o < 0 && o > -0.3) {
                            o = 0;
                        }
                        //o es porque hay veces que la gente no pone el número exacto para que (b^2)-4ac dé 0, así que si el resultado de eso da entre 0 y -0.5, hago que
                        // el número pequeño sea igual que el grande para que sea exacto.

                        double res = ((-1*v0)+Math.sqrt((o)))/(g);
                        if (res < 0) {
                            double res2 = ((-1*v0)-Math.sqrt((o)))/(g);
                            textView.setText("t = " + String.format("%.2f", res2) + "s");
                        } else if (Double.isNaN(res)) {
                            textView.setText(R.string.tNo);
                        } else {
                            textView.setText("t = " + String.format("%.2f", res) + "s");
                        }
                    } else {
                        double y1 = parse(valueY1);
                        double y0 = parse(valueY0);
                        double g = parse(valueG);
                        double v0 = parse(valueV0);
                        double y1y0 = y0-y1;

                        //y1y0 es porque, obviamente, no se puede empezar a una altura, y luego subir si el cuadrado de la velocidad no es más grande que y1y0.
                        //porque daría negativo en la raíz cuadrada de la fórmula cuadrática.
                        if (y1y0 < 0) {
                            textView.setText(R.string.tNo);
                        }
                        double res = ((-1*v0)+Math.sqrt((v0*v0)-4*(((g/2))*(y1y0))))/(g);
                        if (res < 0) {
                            double res2 = ((-1*v0)-Math.sqrt((v0*v0)-4*(((g/2))*(y1y0))))/(g);
                            textView.setText("t = " + String.format("%.2f", res2) + "s");
                        } else if (Double.isNaN(res)) {
                            textView.setText(R.string.tNo);
                        } else {
                            textView.setText("t = " + String.format("%.2f", res) + "s");
                        }
                    }
                }

                if (valueV0.equals("")) {
                    double y1 = parse(valueY1);
                    double y0 = parse(valueY0);
                    double t = parse(valueT);
                    double g = parse(valueG);
                    double res = ((y1-y0)+((g/2)*-1)*(t*t))/t;
                    textView.setText("v0 = " + String.format("%.2f", res) + "m/s");
                }

                if (valueG.equals("")) {
                    double y1 = parse(valueY1);
                    double y0 = parse(valueY0);
                    double t = parse(valueT);
                    double v0 = parse(valueV0);
                    double res = ((y0-y1)+(v0*t))/t;
                    textView.setText("g = " + String.format("%.2f", res) + "m/s^2");
                }

                if (valueY0.equals("")) {
                    double y1 = parse(valueY1);
                    double t = parse(valueT);
                    double v0 = parse(valueV0);
                    double g = parse(valueG);
                    double res = y1+(((g/2)*-1)*(t*t))-v0*t;
                    textView.setText("y0 = " + String.format("%.2f", res) + "m");
                }

                if (valueY1.equals("")) {
                    double y0 = parse(valueY0);
                    double v0 = parse(valueV0);
                    double t = parse(valueT);
                    double g = parse(valueG);
                    double res = y0+(v0*t)-((g/2)*-1)*(t*t);
                    textView.setText("y = " + String.format("%2", res) + "m");
                }

            }
        });
    }


}
