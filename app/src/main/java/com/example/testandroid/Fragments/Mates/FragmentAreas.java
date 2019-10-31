package com.example.testandroid.Fragments.Mates;

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

import com.example.testandroid.FormulasAreas;
import com.example.testandroid.R;

public class FragmentAreas extends Fragment {

    FormulasAreas ras = new FormulasAreas();

    public double parse(String number) {
        return Double.parseDouble(number);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_areas, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Button btnTri = getView().findViewById(R.id.matTri_btn);
        Button btnCir = getView().findViewById(R.id.matCir_btn);
        Button btnCua = getView().findViewById(R.id.matCua_btn);
        Button btnRomb = getView().findViewById(R.id.matRomb_btn);
        final TextView textTri = getView().findViewById(R.id.matTri_result);
        final TextView textCir = getView().findViewById(R.id.matCir_result);
        final TextView textCua = getView().findViewById(R.id.matCua_result);
        final TextView textRomb = getView().findViewById(R.id.matRomb_result);
        final Toast soloIncognita = Toast.makeText(getActivity(),R.string.soloIncognita,Toast.LENGTH_LONG);

        btnTri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText a11 = getView().findViewById(R.id.matTri_valueA);
                EditText base1 = getView().findViewById(R.id.matTri_valueBase);
                EditText altura1 = getView().findViewById(R.id.matTri_valueAltura);
                String a1 = a11.getText().toString();
                String b1 = base1.getText().toString();
                String h1 = altura1.getText().toString();
                double b, h, a, res;

                if (b1.isEmpty()) {
                    if (h1.isEmpty() | a1.isEmpty()) {
                        soloIncognita.show();
                        return;
                    }
                }

                if (h1.isEmpty()) {
                    if (a1.isEmpty()) {
                        soloIncognita.show();
                        return;
                    }
                }

                if (a1.equals("")) {
                    b = parse(b1);
                    h = parse(h1);
                    res = ras.tri(b, h);
                    if (Double.isNaN(res)) {
                        textTri.setText("a " + R.string.noEs);
                    } else {
                        textTri.setText("a = " + String.format("%.2f", res));
                    }
                } else if (b1.equals("")) {
                    a = parse(a1);
                    h = parse(h1);
                    res = ras.triCalcB(a, h);
                    if (Double.isNaN(res)) {
                        textTri.setText("a " + R.string.noEs);
                    } else {
                        textTri.setText("b = " + String.format("%.2f", res) + "m");
                    }
                } else if (h1.equals("")) {
                    a = parse(a1);
                    b = parse(b1);
                    res = ras.triCalcH(a, b);
                    if (Double.isNaN(res)) {
                        textTri.setText("h " + R.string.noEs);
                    } else {
                        textTri.setText("h = " + String.format("%.2f", res) + "m");
                    }
                }

            }
        });


        btnCua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText a11 = getView().findViewById(R.id.matCua_valueA);
                EditText b11 = getView().findViewById(R.id.matCua_valueBase);
                EditText h11 = getView().findViewById(R.id.matCua_valueAltura);
                String a1 = a11.getText().toString();
                String b1 = b11.getText().toString();
                String h1 = h11.getText().toString();
                double b, h, a, res;

                if (b1.isEmpty()) {
                    if (h1.isEmpty() | a1.isEmpty()) {
                        soloIncognita.show();
                        return;
                    }
                }

                if (h1.isEmpty()) {
                    if (a1.isEmpty()) {
                        soloIncognita.show();
                        return;
                    }
                }

                if  (a1.equals("")) {
                    b = parse(b1);
                    h = parse(h1);
                    res = ras.bh(b, h);
                    if (Double.isNaN(res)) {
                        textCua.setText("a " + R.string.noEs);
                    } else {
                        textCua.setText("a = " + String.format("%.2f", res));
                    }
                } else if (b1.equals("")) {
                    h = parse(h1);
                    a = parse(a1);
                    res = ras.bhCalcB(a, h);
                    if (Double.isNaN(res)) {
                        textCua.setText("h " + R.string.noEs);
                    } else {
                        textCua.setText("h = " + String.format("%.2f", res) + "m");
                    }
                } else if (h1.equals("")) {
                    b = parse(b1);
                    a = parse(a1);
                    res = ras.bhCalcH(a, b);
                    if (Double.isNaN(res)) {
                        textCua.setText("a " + R.string.noEs);
                    } else {
                        textCua.setText("B = " + String.format("%.2f", res) + "m");
                    }
                }

            }
        });

        btnRomb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText a11 = getView().findViewById(R.id.matRomb_valueA);
                EditText d11 = getView().findViewById(R.id.matRomb_valueDi);
                EditText d21 = getView().findViewById(R.id.matRomb_valuedi);
                String a1 = a11.getText().toString();
                String d1 = d11.getText().toString();
                String d2 = d21.getText().toString();
                double D, d, a, res;

                if (d1.isEmpty()) {
                    if (d2.isEmpty() | a1.isEmpty()) {
                        soloIncognita.show();
                        return;
                    }
                }

                if (d2.isEmpty()) {
                    if (a1.isEmpty()) {
                        soloIncognita.show();
                        return;
                    }
                }

                if  (a1.equals("")) {
                    D = parse(d1);
                    d = parse(d2);
                    res = ras.tri(D, d);
                    if (Double.isNaN(res)) {
                        textRomb.setText("a " + R.string.noEs);
                    } else {
                        textRomb.setText("a = " + String.format("%.2f", res));
                    }
                } else if (d1.equals("")) {
                    d = parse(d2);
                    a = parse(a1);
                    res = ras.triCalcB(a, d);
                    if (Double.isNaN(res)) {
                        textRomb.setText("D " + R.string.noEs);
                    } else {
                        textRomb.setText("D = " + String.format("%.2f", res) + "m");
                    }
                } else if (d2.equals("")) {
                    D = parse(d1);
                    a = parse(a1);
                    res = ras.triCalcH(a, D);
                    if (Double.isNaN(res)) {
                        textRomb.setText("d " + R.string.noEs);
                    } else {
                        textRomb.setText("d = " + String.format("%.2f", res) + "m");
                    }
                }


            }
        });

        btnCir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText radio1 = getView().findViewById(R.id.matCir_valueRadio);
                EditText a11 = getView().findViewById(R.id.matCir_valueA);
                String a1 = a11.getText().toString();
                String r1 = radio1.getText().toString();
                double r, a, res;

                if (r1.isEmpty() & a1.isEmpty()) {
                    soloIncognita.show();
                    return;
                }

                if (a1.equals("")) {
                    r = parse(r1);
                    res = ras.cir(r);
                    textCir.setText("a = " + String.format("%.2f", res));
                } else if (r1.equals("")) {
                    a = parse(a1);
                    res = ras.cirCalcR(a);
                    if (Double.isNaN(res)) {
                        textCir.setText("r " + R.string.noEs);
                    } else {
                        textCir.setText("r = " + String.format("%.2f", res) + "m");
                    }
                }


            }
        });
    }
}
