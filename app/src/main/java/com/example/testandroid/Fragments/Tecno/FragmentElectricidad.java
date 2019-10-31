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

public class FragmentElectricidad extends Fragment {

    FormulasTecno ras = new FormulasTecno();

    public double parse(String number) {
        return Double.parseDouble(number);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_elec, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Button btnOhm = getView().findViewById(R.id.tecnoOhm_btn);
        Button btnPot = getView().findViewById(R.id.tecnoPot_btn);
        final TextView textOhm = getView().findViewById(R.id.tecnoOhm_result);
        final TextView textPot = getView().findViewById(R.id.tecnoPot_result);
        final Toast soloIncognita = Toast.makeText(getActivity(),R.string.soloIncognita,Toast.LENGTH_LONG);

        btnOhm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText v11 = getView().findViewById(R.id.tecnoOhm_valueV);
                EditText i11 = getView().findViewById(R.id.tecnoOhm_valueI);
                EditText r11 = getView().findViewById(R.id.tecnoOhm_valueR);
                String v1 = v11.getText().toString();
                String i1 = i11.getText().toString();
                String r1 = r11.getText().toString();
                double v, i, r, res;

                if (v1.isEmpty()) {
                    if (i1.isEmpty() | r1.isEmpty()) {
                        soloIncognita.show();
                        return;
                    }
                }

                if (i1.isEmpty()) {
                    if (r1.isEmpty()) {
                        soloIncognita.show();
                        return;
                    }
                }

                if (v1.equals("")) {
                    i = parse(i1);
                    r = parse(r1);
                    res = ras.oCalcV(i, r);
                    textOhm.setText("V = " + String.format("%.2f", res) + "V");
                } else if (i1.equals("")) {
                    v = parse(v1);
                    r = parse(r1);
                    res = ras.oCalcI(v, r);
                    if (Double.isNaN(res)) {
                        textOhm.setText("I " + R.string.noEs);
                    } else {
                        textOhm.setText("I = " + String.format("%.2f", res) + "A");
                    }
                } else if (r1.equals("")) {
                    v = parse(v1);
                    i = parse(i1);
                    res = ras.oCalcR(i, v);
                    if (Double.isNaN(res)) {
                        textOhm.setText("R " + R.string.noEs);
                    } else {
                        textOhm.setText("R = " + String.format("%.2f", res) + "Ω");
                    }
                }
            }
        });

        btnPot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText p11 = getView().findViewById(R.id.tecnoPot_valueP);
                EditText v11 = getView().findViewById(R.id.tecnoPot_valueV);
                EditText i11 = getView().findViewById(R.id.tecnoPot_valueI);
                String p1 = p11.getText().toString();
                String v1 = v11.getText().toString();
                String i1 = i11.getText().toString();
                double p, v, i, res;

                if (p1.isEmpty()) {
                    if (v1.isEmpty() | i1.isEmpty()) {
                        soloIncognita.show();
                        return;
                    }
                }

                if (v1.isEmpty()) {
                    if (i1.isEmpty()) {
                        soloIncognita.show();
                        return;
                    }
                }

                if (p1.equals("")) {
                    v = parse(v1);
                    i = parse(i1);
                    res = ras.pCalcP(v, i);
                    textPot.setText("P = " + String.format("%.2f", res) + "W");
                } else if (v1.equals("")) {
                    p = parse(p1);
                    i = parse(i1);
                    res = ras.pCalcV(p, i);
                    if (Double.isNaN(res)) {
                        textPot.setText("V " + R.string.noEs);
                    } else {
                        textPot.setText("V = " + String.format("%.2f", res) + "V");
                    }
                } else if (i1.equals("")) {
                    p = parse(p1);
                    v = parse(v1);
                    res = ras.pCalcI(p, v);
                    if (Double.isNaN(res)) {
                        textPot.setText("I " + R.string.noEs);
                    } else {
                        textPot.setText("I = " + String.format("%.2f", res) + "A");
                    }
                }
            }
        });
    }
}
