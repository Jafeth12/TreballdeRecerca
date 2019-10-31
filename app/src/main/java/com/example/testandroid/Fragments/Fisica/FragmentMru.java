package com.example.testandroid.Fragments.Fisica;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.testandroid.FisicaActivity;
import com.example.testandroid.FormulasMRUyMCU;
import com.example.testandroid.R;

public class FragmentMru extends Fragment {

    FormulasMRUyMCU ras = new FormulasMRUyMCU();

    public double parse(String number) {
        return Double.parseDouble(number);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_mru, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Button btn1 = getView().findViewById(R.id.fisicaMRU_btn);
        Button btn2 = getView().findViewById(R.id.fisicaMRU1_btn);
        final Toast soloIncognita = Toast.makeText(getActivity(),R.string.soloIncognita,Toast.LENGTH_LONG);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView textView = getView().findViewById(R.id.fisicaMRU1_result);
                EditText x1 = getView().findViewById(R.id.fisicaMRU1_valueX);
                EditText v1 = getView().findViewById(R.id.fisicaMRU1_valueV);
                EditText t1 = getView().findViewById(R.id.fisicaMRU1_valueT);
                String valueX = x1.getText().toString();
                String valueV = v1.getText().toString();
                String valueT = t1.getText().toString();
                double x, v, t, res;

                if (valueX.isEmpty()) {
                    if (valueV.isEmpty() | valueT.isEmpty()) {
                        soloIncognita.show();
                        return;
                    }
                }

                if (valueT.isEmpty()) {
                    if (valueV.isEmpty()) {
                        soloIncognita.show();
                        return;
                    }
                }


                if (valueX.equals("")) {
                    t = parse(valueT);
                    v = parse(valueV);
                    res = ras.calcXMRU(v, t);
                    textView.setText("x = " + String.format("%.2f", res) + "m");
                } else if (valueT.equals("")) {
                    x = parse(valueX);
                    v = parse(valueV);
                    res = ras.calcTMRU(v, x);
                    if (Double.isNaN(res)) {
                        textView.setText(R.string.tNo);
                    } else {
                        textView.setText("t = " + String.format("%.2f", res) + "s");
                    }
                } else if (valueV.equals("")) {
                    t = parse(valueT);
                    x = parse(valueX);
                    res = ras.calcVMRU(x, t);
                    if (Double.isNaN(res)) {
                        textView.setText(R.string.vNo);
                    } else {
                        textView.setText("v = " + String.format("%.2f", res) + "m/s");
                    }
                }

            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView textView = getView().findViewById(R.id.fisicaMRU_result);
                EditText x11 = getView().findViewById(R.id.fisicaMRU_valueX1);
                EditText x01 = getView().findViewById(R.id.fisicaMRU_valueX0);
                EditText v1 = getView().findViewById(R.id.fisicaMRU_valueV);
                EditText t11 = getView().findViewById(R.id.fisicaMRU_valueT1);
                EditText t01 = getView().findViewById(R.id.fisicaMRU_valueT0);
                String valueX1 = x11.getText().toString();
                String valueX0 = x01.getText().toString();
                String valueV = v1.getText().toString();
                String valueT1 = t11.getText().toString();
                String valueT0 = t01.getText().toString();
                double x1, x0, v, t1, t0, res;

                if (valueT1.isEmpty()) {
                    if (valueV.isEmpty() | valueX0.isEmpty() | valueX1.isEmpty() | valueT0.isEmpty()) {
                        soloIncognita.show();
                        return;
                    }
                }

                if (valueV.isEmpty()) {
                    if (valueX0.isEmpty() | valueX1.isEmpty() | valueT0.isEmpty()) {
                        soloIncognita.show();
                        return;
                    }
                }

                if (valueX0.isEmpty()) {
                    if (valueX1.isEmpty() | valueT0.isEmpty()) {
                        soloIncognita.show();
                        return;
                    }
                }

                if (valueX1.isEmpty()) {
                    if (valueT0.isEmpty()) {
                        soloIncognita.show();
                        return;
                    }
                }


                if (valueX1.equals("")) {
                    x0 = parse(valueX0);
                    v = parse(valueV);
                    t1 = parse(valueT1);
                    t0 = parse(valueT0);
                    res = ras.calcX1(x0, v, t1, t0);
                    textView.setText("x1 = " + String.format("%.2f", res) + "m");
                } else if (valueT1.equals("")) {
                    x0 = parse(valueX0);
                    x1 = parse(valueX1);
                    v = parse(valueV);
                    t0 = parse(valueT0);
                    res = ras.calcT1(x1, x0, v, t0);
                    if (Double.isNaN(res) || res < 0) {
                        textView.setText(R.string.tNo);
                    } else {
                        textView.setText("t = " + String.format("%.2f", res) + "s");
                    }
                } else if (valueV.equals("")) {
                    x0 = parse(valueX0);
                    x1 = parse(valueX1);
                    t1 = parse(valueT1);
                    t0 = parse(valueT0);
                    res = ras.calcV(x1, x0, t1, t0);
                    if (Double.isNaN(res)) {
                        textView.setText(R.string.vNo);
                    } else {
                        textView.setText("v = " + String.format("%.2f", res) + "m/s");
                    }
                } else if (valueX0.equals("")) {
                    v = parse(valueV);
                    x1 = parse(valueX1);
                    t1 = parse(valueT1);
                    t0 = parse(valueT0);
                    res = ras.calcX0(x1, v, t1, t0);
                    textView.setText("x0 = " + String.format("%.2f", res) + "m");
                } else if (valueT0.equals("")) {
                    v = parse(valueV);
                    x1 = parse(valueX1);
                    x0 = parse(valueX0);
                    t1 = parse(valueT1);
                    res = ras.calcT0(x1, x0, v, t1);
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
