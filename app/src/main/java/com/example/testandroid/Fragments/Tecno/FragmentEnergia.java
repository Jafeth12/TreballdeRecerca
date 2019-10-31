package com.example.testandroid.Fragments.Tecno;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.testandroid.FormulasTecno;
import com.example.testandroid.R;

public class FragmentEnergia extends Fragment {

    FormulasTecno ras = new FormulasTecno();

    public double parse(String number) {
        return Double.parseDouble(number);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_energia, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Button btnW = getView().findViewById(R.id.tecnoW_btn);
        Button btnEc = getView().findViewById(R.id.tecnoEc_btn);
        Button btnEp = getView().findViewById(R.id.tecnoEp_btn);
        final TextView textW = getView().findViewById(R.id.tecnoW_result);
        final TextView textEc = getView().findViewById(R.id.tecnoEc_result);
        final TextView textEp = getView().findViewById(R.id.tecnoEp_result);
        final Toast soloIncognita = Toast.makeText(getActivity(),R.string.soloIncognita,Toast.LENGTH_LONG);

        btnEc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText ec11 = getView().findViewById(R.id.tecnoEc_valueEc);
                EditText masa1 = getView().findViewById(R.id.tecnoEc_valueM);
                EditText vel1 = getView().findViewById(R.id.tecnoEc_valueV);
                String ec1 = ec11.getText().toString();
                String m1 = masa1.getText().toString();
                String v1 = vel1.getText().toString();
                double ec, m, v, res;

                if (ec1.isEmpty()) {
                    if (m1.isEmpty() | v1.isEmpty()) {
                        soloIncognita.show();
                        return;
                    }
                }

                if (m1.isEmpty()) {
                    if (v1.isEmpty()) {
                        soloIncognita.show();
                        return;
                    }
                }

                if (ec1.equals("")) {
                    m = parse(m1);
                    v = parse(v1);
                    res = ras.ec(m, v);
                    textEc.setText(R.string.ec + " = " + String.format("%.2f", res));
                } else if (m1.equals("")) {
                    ec = parse(ec1);
                    v = parse(v1);
                    res = ras.ecCalcM(ec, v);
                    if (Double.isNaN(res)) {
                        textEc.setText("m " + R.string.noEs);
                    } else {
                        textEc.setText("m = " + String.format("%.2f", res) + "kg");
                    }
                } else if (v1.equals("")) {
                    ec = parse(ec1);
                    m = parse(m1);
                    res = ras.ecCalcV(ec, m);
                    if (Double.isNaN(res)) {
                        textEc.setText("v " + R.string.noEs);
                    } else {
                        textEc.setText("v = " + String.format("%.2f", res) + "m/s");
                    }
                }

            }
        });

        btnEp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText ep11 = getView().findViewById(R.id.tecnoEp_valueEp);
                EditText masa1 = getView().findViewById(R.id.tecnoEp_valueM);
                EditText g11 = getView().findViewById(R.id.tecnoEp_valueG);
                EditText altura1 = getView().findViewById(R.id.tecnoEp_valueH);
                String ep1  = ep11.getText().toString();
                String m1 = masa1.getText().toString();
                String g1 = g11.getText().toString();
                String h1 = altura1.getText().toString();
                double ep, m, g, h, res;

                if (ep1.isEmpty()) {
                    if (m1.isEmpty() | g1.isEmpty() | h1.isEmpty()) {
                        soloIncognita.show();
                        return;
                    }
                }

                if (m1.isEmpty()) {
                    if (h1.isEmpty() | g1.isEmpty()) {
                        soloIncognita.show();
                        return;
                    }
                }

                if (h1.isEmpty()) {
                    if(g1.isEmpty()) {
                        soloIncognita.show();
                        return;
                    }
                }

                if (ep1.equals("")) {
                    m = parse(m1);
                    g = parse(g1);
                    h = parse(h1);
                    res = ras.ep(m, g, h);
                    textEp.setText(R.string.ep + " = " + String.format("%.2f", res));
                } else  if (m1.equals("")) {
                    g = parse(g1);
                    h = parse(h1);
                    ep = parse(ep1);
                    res  = ras.epCalcM(ep, g, h);
                    if (Double.isNaN(res)) {
                        textEp.setText("m " + R.string.noEs);
                    } else {
                        textEp.setText("m = " + String.format("%.2f", res) + "kg");
                    }
                } else if (g1.equals("")) {
                    m = parse(m1);
                    h = parse(h1);
                    ep = parse(ep1);
                    res = ras.epCalcG(ep, m, h);
                    if (Double.isNaN(res)) {
                        textEp.setText("g " + R.string.noEs);
                    } else {
                        textEp.setText("g = " + String.format("%.2f", res) + "m/s^2");
                    }
                } else if (h1.equals("")) {
                    m = parse(m1);
                    g = parse(g1);
                    ep = parse(ep1);
                    res = ras.epCalcH(ep, m , g);
                    if (Double.isNaN(res)) {
                        textEp.setText("h " + R.string.noEs);
                    } else {
                        textEp.setText("h = " + String.format("%.2f", res) + "m");
                    }
                }

            }
        });

        btnW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText w11 = getView().findViewById(R.id.tecnoW_valueW);
                EditText f11 = getView().findViewById(R.id.tecnoW_valueF);
                EditText d11 = getView().findViewById(R.id.tecnoW_valueD);
                EditText cos11 = getView().findViewById(R.id.tecnoW_valueCos);
                String w1 = w11.getText().toString();
                String f1 = f11.getText().toString();
                String d1 = d11.getText().toString();
                String cos1 = cos11.getText().toString();
                double w, f, d, cos, res;

                if (w1.isEmpty()) {
                    if (f1.isEmpty() | d1.isEmpty() | cos1.isEmpty()) {
                        soloIncognita.show();
                        return;
                    }
                }

                if (f1.isEmpty()) {
                    if (d1.isEmpty() | cos1.isEmpty()) {
                        soloIncognita.show();
                        return;
                    }
                }

                if (d1.isEmpty()) {
                    if (cos1.isEmpty()) {
                        soloIncognita.show();
                        return;
                    }
                }

                if (w1.equals("")) {
                    f  = parse(f1);
                    d = parse(d1);
                    cos = parse(cos1);
                    res = ras.workCalcW(f, d, cos);
                    if (Double.isNaN(res)) {
                        textW.setText("W " + R.string.noEs);
                    } else {
                        textW.setText("W = " + String.format("%.2f", res) + "J");
                    }
                } else if (f1.equals("")) {
                    w = parse(w1);
                    d = parse(d1);
                    cos = parse(cos1);
                    res = ras.workCalcF(w, d, cos);
                    if (Double.isNaN(res)) {
                        textW.setText("F " + R.string.noEs);
                    } else {
                        textW.setText("F = " + String.format("%.2f", res) + "N");
                    }
                } else if (d1.equals("")) {
                    w = parse(w1);
                    f = parse(f1);
                    cos = parse(cos1);
                    res = ras.workCalcD(w, f, cos);
                    if (Double.isNaN(res)) {
                        textW.setText("d " + R.string.noEs);
                    } else {
                        textW.setText("d = " + String.format("%.2f", res) + "m");
                    }
                } else if (cos1.equals("")) {
                    w = parse(w1);
                    f = parse(f1);
                    d = parse(d1);
                    res = ras.workCalcCos(w, f, d);
                    if (Double.isNaN(res)) {
                        textW.setText("cos " + R.string.noEs);
                    } else {
                        textW.setText("cos = " + String.format("%.2f", res) + "º");
                    }
                }


            }
        });


    }
}
