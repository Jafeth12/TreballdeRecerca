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
    private String gORa, y0ORx0, y1ORx1;
    TextView textFormulaFF, textFormulaV1, textFormulaV2;

    public double parse(String number) {
        return Double.parseDouble(number);
    }

    public void clear(EditText k) {
        k.setText("");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_caidalibre, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable final Bundle savedInstanceState) {
        Button btn = getView().findViewById(R.id.fisicaFF_btn);
        Button btn1 = getView().findViewById(R.id.fisicaFF_btn1);
        Button btn2 = getView().findViewById(R.id.fisicaFF_btn2);
        Switch switchFF = getView().findViewById(R.id.switchFF);
        final TextView textView = getView().findViewById(R.id.fisicaFF_result);
        final TextView textView1 = getView().findViewById(R.id.fisicaFFV1_result);
        final TextView textView2 = getView().findViewById(R.id.fisicaFFV2_result);
        final Toast soloIncognita = Toast.makeText(getActivity(),"No más de un incógnita",Toast.LENGTH_LONG);
        gORa = "a";
        y1ORx1 = "x1";
        y0ORx0 = "x0";

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
                    gORa = "g";
                    y1ORx1 = "y1";
                    y0ORx0 = "y0";
                    textView.setText("");
                    textView1.setText("");
                    textView2.setText("");

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
                    gORa = "a";
                    y1ORx1 = "x1";
                    y0ORx0 = "x0";
                    textView.setText("");
                    textView1.setText("");
                    textView2.setText("");
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
                double y0, y1, v0, t, g, res, y1y0, o;

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
                        y1 = parse(valueY1);
                        y0 = parse(valueY0);
                        g = parse(valueG);
                        res = Math.sqrt((2*(y1-y0))/g);
                        if (Double.isNaN(res)) {
                            textView.setText(R.string.tNo);
                        } else {
                            textView.setText("t = " + String.format("%.2f", res) + R.string.segundos);
                        }
                    } else if (valueY0.equals("0")) {
                        y1 = parse(valueY1);
                        g = parse(valueG);
                        v0 = parse(valueV0);
                        o = (v0*v0)-4*((g/2)*(y1*-1));
                        if (o < 0 && o > -0.3) {
                            o = 0;
                        }
                        //o es porque hay veces que la gente no pone el número exacto para que (b^2)-4ac dé 0, así que si el resultado de eso da entre 0 y -0.5, hago que
                        // el número pequeño sea igual que el grande para que sea exacto.

                        res = ((-1*v0)+Math.sqrt((o)))/(g);
                        if (res <= 0) {
                            double res2 = ((-1*v0)-Math.sqrt((o)))/(g);
                            textView.setText("t = " + String.format("%.2f", res2) + "s " + R.string.and + String.format("%.2f", res) + "s");
                        } else if (Double.isNaN(res)) {
                            textView.setText(R.string.tNo);
                        } else {
                            textView.setText("t = " + String.format("%.2f", res) + R.string.segundos);
                        }
                    } else {
                        y1 = parse(valueY1);
                        y0 = parse(valueY0);
                        g = parse(valueG);
                        v0 = parse(valueV0);
                        y1y0 = y0-y1;

                        res = ((-1*v0)+Math.sqrt((v0*v0)-4*(((g/2))*(y0-y1))))/(g);
                        if (res <= 0) {
                            double res2 = ((-1*v0)-Math.sqrt((v0*v0)-4*(((g/2))*(y1y0))))/(g);
                            textView.setText("t = " + String.format("%.2f", res2) + "s " + R.string.and + String.format("%.2f", res) + "s");
                        } else if (Double.isNaN(res)) {
                            textView.setText(R.string.tNo);
                        } else {
                            textView.setText("t = " + String.format("%.2f", res) + R.string.segundos);
                        }
                    }
                } else if (valueV0.equals("")) {
                    y1 = parse(valueY1);
                    y0 = parse(valueY0);
                    t = parse(valueT);
                    g = parse(valueG);
                    res = ((y1-y0)+((g/2)*-1)*(t*t))/t;
                    if (Double.isNaN(res)) {
                        textView1.setText(R.string.v0No);
                    } else {
                        textView1.setText("v = " + String.format("%.2f", res) + R.string.metrosEntreSegundo);
                    }
                } else if (valueG.equals("")) {
                    y1 = parse(valueY1);
                    y0 = parse(valueY0);
                    t = parse(valueT);
                    v0 = parse(valueV0);
                    res = ((y0-y1)+(v0*t))/t;
                    if (Double.isNaN(res)) {
                        textView1.setText(gORa + R.string.noEs);
                    } else {
                        textView.setText(gORa + " = " + String.format("%.2f", res) + R.string.metrosEntreSegundoCuadrado);
                    }
                } else if (valueY0.equals("")) {
                    y1 = parse(valueY1);
                    t = parse(valueT);
                    v0 = parse(valueV0);
                    g = parse(valueG);
                    res = y1+(((g/2)*-1)*(t*t))-v0*t;
                    textView.setText(y0ORx0 + " = " + String.format("%.2f", res) + R.string.metros);
                } else if(valueY1.equals("")) {
                    y0 = parse(valueY0);
                    v0 = parse(valueV0);
                    t = parse(valueT);
                    g = parse(valueG);
                    res = y0+(v0*t)-((g/2)*-1)*(t*t);
                    textView.setText(y1ORx1 + " = " + String.format("%2", res) + R.string.metros);
                }

            }
        });


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText v11 = getView().findViewById(R.id.fisicaFFV1_valueV);
                EditText v01 = getView().findViewById(R.id.fisicaFFV1_valueV0);
                EditText a11 = getView().findViewById(R.id.fisicaFFV1_valueG);
                EditText t11 = getView().findViewById(R.id.fisicaFFV1_valueT);
                EditText t01 = getView().findViewById(R.id.fisicaFFV1_valueT0);
                String valueV = v11.getText().toString();
                String valueV0 = v01.getText().toString();
                String valueA = a11.getText().toString();
                String valueT = t11.getText().toString();
                String valueT0 = t01.getText().toString();
                double v, v0, a, t1, t0, res;

                if (valueV.isEmpty()) {
                    if (valueV0.isEmpty() | valueA.isEmpty() | valueT.isEmpty() | valueT0.isEmpty()) {
                        soloIncognita.show();
                        return;
                    }
                }

                if (valueV0.isEmpty()) {
                    if (valueA.isEmpty() | valueT.isEmpty() | valueT0.isEmpty()) {
                        soloIncognita.show();
                        return;
                    }
                }

                if (valueA.isEmpty()) {
                    if (valueT.isEmpty() | valueT0.isEmpty()) {
                        soloIncognita.show();
                        return;
                    }
                }

                if (valueT.isEmpty()) {
                    if (valueT0.isEmpty()) {
                        soloIncognita.show();
                        return;
                    }
                }


                if (valueV.equals("")) {
                    v0 = parse(valueV0);
                    a = parse(valueA);
                    t1 = parse(valueT);
                    t0 = parse(valueT0);
                    res = ras.calcX1(v0, a, t1, t0);
                    textView1.setText("v = " + String.format("%.2f", res) + R.string.metrosEntreSegundo);
                } else if (valueV0.equals("")) {
                    v = parse(valueV);
                    a = parse(valueA);
                    t1 = parse(valueT);
                    t0 = parse(valueT0);
                    res = ras.calcX0(v, a, t1, t0);
                    textView1.setText("v = " + String.format("%.2f", res) + R.string.metrosEntreSegundo);
                } else if (valueA.equals("")) {
                    v = parse(valueV);
                    v0 = parse(valueV0);
                    t1 = parse(valueT);
                    t0 = parse(valueT0);
                    res = ras.calcV(v, v0, t1, t0);
                    if (Double.isNaN(res)) {
                        textView1.setText(gORa + R.string.noEs);
                    } else {
                        textView1.setText(gORa + " = " + String.format("%.2f", res) + R.string.metrosEntreSegundoCuadrado);
                    }
                } else if (valueT.equals("")) {
                    v = parse(valueV);
                    v0 = parse(valueV0);
                    a = parse(valueA);
                    t0 = parse(valueT0);
                    res = ras.calcT1(v, v0, a, t0);
                    if (Double.isNaN(res)) {
                        textView1.setText(R.string.tNo);
                    } else {
                        textView1.setText("t = " + String.format("%.2f", res) + R.string.segundos);
                    }
                } else if (valueT0.equals("")) {
                    v = parse(valueV);
                    v0 = parse(valueV0);
                    a = parse(valueA);
                    t1 = parse(valueT);
                    res = ras.calcT0(v, v0, a, t1);
                    if (Double.isNaN(res)) {
                        textView1.setText(R.string.tNo);
                    } else {
                        textView1.setText("t = " + String.format("%.2f", res) + R.string.segundos);
                    }
                }
            }

        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText v11 = getView().findViewById(R.id.fisicaFFV2_valueV);
                EditText v01 = getView().findViewById(R.id.fisicaFFV2_valueV0);
                EditText a11 = getView().findViewById(R.id.fisicaFFV2_valueG);
                EditText x11 = getView().findViewById(R.id.fisicaFFV2_valueX1);
                EditText x01 = getView().findViewById(R.id.fisicaFFV2_valueX0);
                String valueX1 = x11.getText().toString();
                String valueX0 = x01.getText().toString();
                String valueA = a11.getText().toString();
                String valueV0 = v01.getText().toString();
                String valueV = v11.getText().toString();
                double x1, x0, a, v0, v,  res;

                if (valueX1.isEmpty()) {
                    if (valueX0.isEmpty() | valueA.isEmpty() | valueV0.isEmpty() | valueV.isEmpty()) {
                        soloIncognita.show();
                        return;
                    }
                }

                if (valueX0.isEmpty()) {
                    if (valueA.isEmpty() | valueV0.isEmpty() | valueV.isEmpty()) {
                        soloIncognita.show();
                        return;
                    }
                }

                if (valueA.isEmpty()) {
                    if (valueV0.isEmpty() | valueV.isEmpty()) {
                        soloIncognita.show();
                        return;
                    }
                }

                if (valueV0.isEmpty()) {
                    if (valueV.isEmpty()) {
                        soloIncognita.show();
                        return;
                    }
                }


                if (valueX1.equals("")) {
                    x0 = parse(valueX0);
                    a  = parse(valueA);
                    v0 = parse(valueV0);
                    v = parse(valueV);
                    res = ras2.calcX1(v, v0, x0,  a);
                    if (Double.isNaN(res)) {
                        textView2.setText(y1ORx1 + R.string.noEs);
                    } else {
                        textView2.setText(y1ORx1 + " = " + String.format("%.2f", res) + "m");
                    }
                } else if (valueX0.equals("")) {
                    x1 = parse(valueX1);
                    a = parse(valueA);
                    v0 = parse(valueV0);
                    v = parse(valueV);
                    res =  ras2.calcX0(v, v0, x1, a);
                    if (Double.isNaN(res)) {
                        textView2.setText(y0ORx0 + R.string.noEs);
                    } else {
                        textView2.setText(y0ORx0 + " = " + String.format("%.2f", res) + "m");
                    }
                } else if (valueA.equals("")) {
                    x0 = parse(valueX0);
                    x1 = parse(valueX1);
                    v0 = parse(valueV0);
                    v = parse(valueV);
                    res = ras2.calcA(v, v0, x1, x0);
                    if (Double.isNaN(res)) {
                        textView2.setText(gORa + "no existe");
                    } else {
                        textView2.setText(gORa + " = " + String.format("%.2f", res) + "m");
                    }
                } else if (valueV0.equals("")) {
                    x0 = parse(valueX0);
                    x1 = parse(valueX1);
                    a = parse(valueA);
                    v = parse(valueV);
                    res = ras2.calcV0(v, a, x1, x0);
                    if (Double.isNaN(res)) {
                        textView2.setText(R.string.v0No);
                    } else {
                        textView2.setText("v0 = " + String.format("%.2f", res) + "m/s");
                    }
                } else if (valueV.equals("")) {
                    x0 = parse(valueX0);
                    x1 = parse(valueX1);
                    a = parse(valueA);
                    v0 = parse(valueV0);
                    res = ras2.calcV(v0, a, x1, x0);
                    if (Double.isNaN(res)) {
                        textView2.setText(R.string.vNo);
                    } else {
                        textView2.setText("v = " + String.format("%.2f", res) + "m/s");
                    }
                }

            }
        });

    }


}
