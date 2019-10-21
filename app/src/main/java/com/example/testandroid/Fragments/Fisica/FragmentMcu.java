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
        final Toast soloIncognita = Toast.makeText(getActivity(),"No más de un incógnita",Toast.LENGTH_LONG);


        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText w1 = getView().findViewById(R.id.fisicaMCU1_valueW);
                EditText phi1 = getView().findViewById(R.id.fisicaMCU1_valuePhi);
                EditText t1 = getView().findViewById(R.id.fisicaMCU1_valueT);
                String valueW = w1.getText().toString();
                String valuePhi = phi1.getText().toString();
                String valueT = t1.getText().toString();

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
                    double phi = parse(valuePhi);
                    double t = parse(valueT);
                    double res = ras.calcVMRU(phi, t);
                    if (Double.isNaN(res)) {
                        textView1.setText("ω no existe");
                    } else {
                        textView1.setText("ω = " + String.format("%.2f", res) + "rad/s");
                    }
                } else if (valuePhi.equals("")) {
                    double t = parse(valueT);
                    double w = parse(valueW);
                    double res = ras.calcXMRU(w, t);
                    textView1.setText("φ = " + String.format("%.2f", res) + "rad");
                } else if (valueT.equals("")) {
                    double w = parse(valueW);
                    double phi = parse(valuePhi);
                    double res = ras.calcTMRU(w, phi);
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
                    double phi = parse(valuePhi);
                    double r = parse(valueR);
                    double res = ras.calcSecc(phi, r);
                    textView2.setText("S = " + String.format("%.2f", res) + "m");
                } else if (valuePhi.equals("")) {
                    double r = parse(valueR);
                    double s = parse(valueS);
                    double res = ras.calcSeccPhi(s, r);
                    textView2.setText("φ = " + String.format("%.2f", res) + "rad");
                } else if (valueR.equals("")) {
                    double phi = parse(valuePhi);
                    double s = parse(valueS);
                    double res = ras.calcSeccR(phi, s);
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
                    double phi0 = parse(valuePhi0);
                    double w = parse(valueW);
                    double t1 = parse(valueT1);
                    double t0 = parse(valueT0);
                    double res = ras.calcX1(phi0, w, t1, t0);
                    textView.setText("x1 = " + String.format("%.2f", res) + "m");
                } else if (valueT1.equals("")) {
                    double phi0 = parse(valuePhi0);
                    double phi = parse(valuePhi);
                    double w = parse(valueW);
                    double t0 = parse(valueT0);
                    double res = ras.calcT1(phi, phi0, w, t0);
                    if (Double.isNaN(res) || res < 0) {
                        textView.setText(R.string.tNo);
                    } else {
                        textView.setText("t = " + String.format("%.2f", res) + "s");
                    }
                } else if (valueW.equals("")) {
                    double phi0 = parse(valuePhi0);
                    double phi = parse(valuePhi);
                    double t1 = parse(valueT1);
                    double t0 = parse(valueT0);
                    double res = ras.calcV(phi, phi0, t1, t0);
                    if (Double.isNaN(res)) {
                        textView.setText(R.string.vNo);
                    } else {
                        textView.setText("v = " + String.format("%.2f", res) + "m/s");
                    }
                } else if (valuePhi0.equals("")) {
                    double w = parse(valueW);
                    double phi = parse(valuePhi);
                    double t1 = parse(valueT1);
                    double t0 = parse(valueT0);
                    double res = ras.calcX0(phi, w, t1, t0);
                    textView.setText("x0 = " + String.format("%.2f", res) + "m");
                } else if (valueT0.equals("")) {
                    double w = parse(valueW);
                    double phi = parse(valuePhi);
                    double phi0 = parse(valuePhi0);
                    double t1 = parse(valueT1);
                    double res = ras.calcT0(phi, phi0, w, t1);
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
