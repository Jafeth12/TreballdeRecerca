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
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.testandroid.FisicaActivity;
import com.example.testandroid.FormulasMRUA;
import com.example.testandroid.FormulasMRUyMCU;
import com.example.testandroid.R;

public class FragmentCaidaLibre extends Fragment {

    FormulasMRUyMCU ras = new FormulasMRUyMCU();
    FormulasMRUA ras2 = new FormulasMRUA();

    private EditText g1FF, a1FFV1, a1FFV2;
    private TextInputLayout y01FF1, y11FF1, g1FF1;
    private TextInputLayout a11FFV1, a11FFV2, x11FFV2, x011FFV2;
    TextView textFormulaFF, textFormulaV1, textFormulaV2;

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
        Button btn1 = getView().findViewById(R.id.fisicaFF_btn1);
        Button btn2 = getView().findViewById(R.id.fisicaFF_btn2);
        Switch switchFF = getView().findViewById(R.id.switchFF);
        final TextView textView = getView().findViewById(R.id.fisicaFF_result);
        final TextView textView1 = getView().findViewById(R.id.fisicaFFV1_result);
        final TextView textView2 = getView().findViewById(R.id.fisicaFFV2_result);
        final Toast soloIncognita = Toast.makeText(getActivity(),"No más de un incógnita",Toast.LENGTH_LONG);

        switchFF.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                y01FF1 = getView().findViewById(R.id.fisicaFF_inputY0);
                y11FF1 = getView().findViewById(R.id.fisicaFF_inputY1);
                g1FF1 = getView().findViewById(R.id.fisicaFF_inputG);
                g1FF = getView().findViewById(R.id.fisicaFF_valueG);

                a11FFV1 = getView().findViewById(R.id.fisicaFFV1_inputG);
                a1FFV1 = getView().findViewById(R.id.fisicaFFV1_valueG);

                a11FFV2 = getView().findViewById(R.id.fisicaFFV2_inputG);
                a1FFV2 = getView().findViewById(R.id.fisicaFFV2_valueG);
                x11FFV2 = getView().findViewById(R.id.fisicaFFV2_inputX1);
                x011FFV2 = getView().findViewById(R.id.fisicaFFV2_inputX0);

                textFormulaFF = getView().findViewById(R.id.textFormulaFF);
                textFormulaV1 = getView().findViewById(R.id.textFormulaV1);
                textFormulaV2 = getView().findViewById(R.id.textFormulaV2);

                if (isChecked) {
                    y01FF1.setHint(getResources().getString(R.string.y0));
                    y11FF1.setHint(getResources().getString(R.string.y1));
                    g1FF1.setHint(getResources().getString(R.string.g));
                    a11FFV1.setHint(getResources().getString(R.string.g));
                    a11FFV2.setHint(getResources().getString(R.string.g));
                    x11FFV2.setHint(getResources().getString(R.string.y1));
                    x011FFV2.setHint(getResources().getString(R.string.y0));
                    g1FF.setText(R.string.defaultG);
                    a1FFV2.setText(R.string.defaultG);
                    a1FFV1.setText(R.string.defaultG);
                    textFormulaFF.setText(R.string.freeFallFormula);
                    textFormulaV1.setText(R.string.v1GFormula);
                    textFormulaV2.setText(R.string.v2GFormula);
                } else {
                    y01FF1.setHint(getResources().getString(R.string.x0));
                    y11FF1.setHint(getResources().getString(R.string.x1));
                    x11FFV2.setHint(getResources().getString(R.string.x1));
                    x011FFV2.setHint(getResources().getString(R.string.x0));
                    g1FF1.setHint(getResources().getString(R.string.a));
                    a11FFV2.setHint(getResources().getString(R.string.a));
                    a11FFV1.setHint(getResources().getString(R.string.a));
                    a1FFV1.setText("");
                    g1FF.setText("");
                    a1FFV2.setText("");
                    textFormulaFF.setText(R.string.mruaFormula);
                    textFormulaV1.setText(R.string.v1Formula);
                    textFormulaV2.setText(R.string.v2Formula);
                }
            }
        });


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText y01FF = getView().findViewById(R.id.fisicaFF_valueY0);
                EditText y11FF = getView().findViewById(R.id.fisicaFF_valueY1);
                EditText v01FF = getView().findViewById(R.id.fisicaFF_valueV0);
                EditText t1FF = getView().findViewById(R.id.fisicaFF_valueTiempo);
                EditText g1FF = getView().findViewById(R.id.fisicaFF_valueG);
                String valueY0 = y01FF.getText().toString();
                String valueY1 = y11FF.getText().toString();
                String valueV0 = v01FF.getText().toString();
                String valueT = t1FF.getText().toString();
                String valueG = g1FF.getText().toString();

                if (valueY0.isEmpty()) {
                    if (valueY1.isEmpty() | valueV0.isEmpty() | valueT.isEmpty() | valueG.isEmpty()) {
                        soloIncognita.show();
                        return;
                    }
                }

                if (valueY1.isEmpty()) {
                    if (valueV0.isEmpty() | valueT.isEmpty() | valueG.isEmpty()) {
                        soloIncognita.show();
                        return;
                    }
                }

                if (valueV0.isEmpty()) {
                    if (valueT.isEmpty() | valueG.isEmpty()) {
                        soloIncognita.show();
                        return;
                    }
                }

                if (valueT.isEmpty()) {
                    if (valueG.isEmpty()) {
                        soloIncognita.show();
                        return;
                    }
                }


                if (valueT.equals("")) {
                    if (valueV0.equals("0")) {
                        double y1 = parse(valueY1);
                        double y0 = parse(valueY0);
                        double g = parse(valueG);
                        double res = Math.sqrt((2*(y1-y0))/g);
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
                        if (res <= 0) {
                            double res2 = ((-1*v0)-Math.sqrt((o)))/(g);
                            textView.setText("t = " + String.format("%.2f", res2) + "s " + R.string.and + String.format("%.2f", res) + "s");
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

                        double res = ((-1*v0)+Math.sqrt((v0*v0)-4*(((g/2))*(y0-y1))))/(g);
                        if (res <= 0) {
                            double res2 = ((-1*v0)-Math.sqrt((v0*v0)-4*(((g/2))*(y1y0))))/(g);
                            textView.setText("t = " + String.format("%.2f", res2) + "s " + R.string.and + String.format("%.2f", res) + "s");
                        } else if (Double.isNaN(res)) {
                            textView.setText(R.string.tNo);
                        } else {
                            textView.setText("t = " + String.format("%.2f", res) + "s");
                        }
                    }
                } else if (valueV0.equals("")) {
                    double y1 = parse(valueY1);
                    double y0 = parse(valueY0);
                    double t = parse(valueT);
                    double g = parse(valueG);
                    double res = ((y1-y0)+((g/2)*-1)*(t*t))/t;
                    textView.setText("v0 = " + String.format("%.2f", res) + "m/s");
                } else if (valueG.equals("")) {
                    double y1 = parse(valueY1);
                    double y0 = parse(valueY0);
                    double t = parse(valueT);
                    double v0 = parse(valueV0);
                    double res = ((y0-y1)+(v0*t))/t;
                    textView.setText("g = " + String.format("%.2f", res) + "m/s^2");
                } else if (valueY0.equals("")) {
                    double y1 = parse(valueY1);
                    double t = parse(valueT);
                    double v0 = parse(valueV0);
                    double g = parse(valueG);
                    double res = y1+(((g/2)*-1)*(t*t))-v0*t;
                    textView.setText("y0 = " + String.format("%.2f", res) + "m");
                } else if(valueY1.equals("")) {
                    double y0 = parse(valueY0);
                    double v0 = parse(valueV0);
                    double t = parse(valueT);
                    double g = parse(valueG);
                    double res = y0+(v0*t)-((g/2)*-1)*(t*t);
                    textView.setText("y = " + String.format("%2", res) + "m");
                }

            }
        });


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }


}
