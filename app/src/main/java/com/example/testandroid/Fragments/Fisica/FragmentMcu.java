package com.example.testandroid.Fragments.Fisica;

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

import com.example.testandroid.FormulasMRUyMCU;
import com.example.testandroid.R;

public class FragmentMcu extends Fragment {

    FormulasMRUyMCU ras = new FormulasMRUyMCU();

    public double parse(String number) {
        return Double.parseDouble(number);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_mcu, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Button btn1 = getView().findViewById(R.id.fisicaMCU_btn);
        Button btn2 = getView().findViewById(R.id.fisicaMCU1_btn);
        Button btn3 = getView().findViewById(R.id.fisicaMCU2_btn);
        final TextView textView = getView().findViewById(R.id.fisicaMCU_result);
        final TextView textView1 = getView().findViewById(R.id.fisicaMCU1_result);
        final TextView textView2 = getView().findViewById(R.id.fisicaMCU2_result);
        final Toast soloIncognita = Toast.makeText(getActivity(),R.string.soloIncognita,Toast.LENGTH_LONG);


        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText w1 = getView().findViewById(R.id.fisicaMCU1_valueW);
                EditText phi1 = getView().findViewById(R.id.fisicaMCU1_valuePhi);
                EditText t1 = getView().findViewById(R.id.fisicaMCU1_valueT);
                String valueW = w1.getText().toString();
                String valuePhi = phi1.getText().toString();
                String valueT = t1.getText().toString();
                double phi, t, w, res;

                if (valueW.isEmpty()) {
                    if (valuePhi.isEmpty() | valueT.isEmpty()) {
                        soloIncognita.show();
                        return;
                    }
                }

                if (valuePhi.isEmpty()) {
                    if (valueT.isEmpty()) {
                        soloIncognita.show();
                        return;
                    }
                }


                if (valueW.equals("")) {
                    phi = parse(valuePhi);
                    t = parse(valueT);
                    res = ras.calcVMRU(phi, t);
                    if (Double.isNaN(res)) {
                        textView1.setText(R.string.wNo);
                    } else {
                        textView1.setText("ω = " + String.format("%.2f", res) + "rad/s");
                    }
                } else if (valuePhi.equals("")) {
                    t = parse(valueT);
                    w = parse(valueW);
                    res = ras.calcXMRU(w, t);
                    textView1.setText("φ = " + String.format("%.2f", res) + "rad");
                } else if (valueT.equals("")) {
                    w = parse(valueW);
                    phi = parse(valuePhi);
                    res = ras.calcTMRU(w, phi);
                    if (Double.isNaN(res)) {
                        textView1.setText(R.string.tNo);
                    } else {
                        textView1.setText("t = " + String.format("%.2f", res) + "s");
                    }

                }

            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText s1 = getView().findViewById(R.id.fisicaMCU2_valueS);
                EditText phi1 = getView().findViewById(R.id.fisicaMCU2_valuePhi);
                EditText r1 = getView().findViewById(R.id.fisicaMCU2_valueR);
                String valueS = s1.getText().toString();
                String valuePhi = phi1.getText().toString();
                String valueR = r1.getText().toString();
                double phi, r, res, s;

                if (valuePhi.isEmpty()) {
                    if (valueR.isEmpty() | valueS.isEmpty()) {
                        soloIncognita.show();
                        return;
                    }
                }

                if (valueR.isEmpty()) {
                    if ( valueS.isEmpty()) {
                        soloIncognita.show();
                        return;
                    }
                }

                if (valueS.equals("")) {
                    phi = parse(valuePhi);
                    r = parse(valueR);
                    res = ras.calcSecc(phi, r);
                    textView2.setText("S = " + String.format("%.2f", res) + "m");
                } else if (valuePhi.equals("")) {
                    r = parse(valueR);
                    s = parse(valueS);
                    res = ras.calcSeccPhi(s, r);
                    textView2.setText("φ = " + String.format("%.2f", res) + "rad");
                } else if (valueR.equals("")) {
                    phi = parse(valuePhi);
                    s = parse(valueS);
                    res = ras.calcSeccR(phi, s);
                    textView2.setText("R = " + String.format("%.2f", res) + "m");
                }
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText t01 = getView().findViewById(R.id.fisicaMCU_valueT0);
                EditText t11 = getView().findViewById(R.id.fisicaMCU_valueT1);
                EditText phi1 = getView().findViewById(R.id.fisicaMCU_valuePhi);
                EditText w1 = getView().findViewById(R.id.fisicaMCU_valueW);
                EditText phi01 = getView().findViewById(R.id.fisicaMCU_valuePhi0);

                String valueT0 = t01.getText().toString();
                String valuePhi = phi1.getText().toString();
                String valuePhi0 = phi01.getText().toString();
                String valueT1 = t11.getText().toString();
                String valueW = w1.getText().toString();
                double t0, t1, phi, phi0, w, res;

                if (valueT0.isEmpty()) {
                    if (valuePhi.isEmpty() | valuePhi0.isEmpty() | valueT1.isEmpty() | valueW.isEmpty()) {
                        soloIncognita.show();
                        return;
                    }
                }

                if (valuePhi.isEmpty()) {
                    if (valuePhi0.isEmpty() | valueT1.isEmpty() | valueW.isEmpty()) {
                        soloIncognita.show();
                        return;
                    }
                }

                if (valuePhi0.isEmpty()) {
                    if (valueT1.isEmpty() | valueW.isEmpty()) {
                        soloIncognita.show();
                        return;
                    }
                }

                if (valueT1.isEmpty()) {
                    if (valueW.isEmpty()) {
                        soloIncognita.show();
                        return;
                    }
                }

                if (valuePhi.equals("")) {
                    phi0 = parse(valuePhi0);
                    w = parse(valueW);
                    t1 = parse(valueT1);
                    t0 = parse(valueT0);
                    res = ras.calcX1(phi0, w, t1, t0);
                    textView.setText("φ = " + String.format("%.2f", res) + "rad");
                } else if (valueT1.equals("")) {
                    phi0 = parse(valuePhi0);
                    phi = parse(valuePhi);
                    w = parse(valueW);
                    t0 = parse(valueT0);
                    res = ras.calcT1(phi, phi0, w, t0);
                    if (Double.isNaN(res) || res < 0) {
                        textView.setText(R.string.tNo);
                    } else {
                        textView.setText("t = " + String.format("%.2f", res) + "s");
                    }
                } else if (valueW.equals("")) {
                    phi0 = parse(valuePhi0);
                    phi = parse(valuePhi);
                    t1 = parse(valueT1);
                    t0 = parse(valueT0);
                    res = ras.calcV(phi, phi0, t1, t0);
                    if (Double.isNaN(res)) {
                        textView.setText(R.string.wNo);
                    } else {
                        textView.setText("ω = " + String.format("%.2f", res) + "rad/s");
                    }
                } else if (valuePhi0.equals("")) {
                    w = parse(valueW);
                    phi = parse(valuePhi);
                    t1 = parse(valueT1);
                    t0 = parse(valueT0);
                    res = ras.calcX0(phi, w, t1, t0);
                    textView.setText("φ0 = " + String.format("%.2f", res) + "rad");
                } else if (valueT0.equals("")) {
                    w = parse(valueW);
                    phi = parse(valuePhi);
                    phi0 = parse(valuePhi0);
                    t1 = parse(valueT1);
                    res = ras.calcT0(phi, phi0, w, t1);
                    if (Double.isNaN(res) || res < 0) {
                        textView.setText(R.string.tNo);
                    } else {
                        textView.setText("t0 = " + String.format("%.2f", res) + "s");
                    }
                }

            }
        });

    }
}
