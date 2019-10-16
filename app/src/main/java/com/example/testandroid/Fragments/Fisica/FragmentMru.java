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

import com.example.testandroid.R;

public class FragmentMru extends Fragment {

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
        Button btn = getView().findViewById(R.id.fisicaMRU_btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView textView = getView().findViewById(R.id.fisicaMRU_result);
                EditText x01 = getView().findViewById(R.id.fisicaMRU_valueX0);
                EditText x11 = getView().findViewById(R.id.fisicaMRU_valueX1);
                EditText v01 = getView().findViewById(R.id.fisicaMRU_valueV0);
                EditText t1 = getView().findViewById(R.id.fisicaMRU_valueTiempo);
                String valueX0 = x01.getText().toString();
                String valueX1 = x11.getText().toString();
                String valueV0 = v01.getText().toString();
                String valueT = t1.getText().toString();

                if (valueX1.equals("")) {
                    double x0 = parse(valueX0);
                    double v0 = parse(valueV0);
                    double t = parse(valueT);
                    double res = x0+v0*t;
                    textView.setText("x1 = " + String.format("%.2f", res) + "m");
                } else if (valueT.equals("")) {
                    double x0 = parse(valueX0);
                    double x1 = parse(valueX1);
                    double v0 = parse(valueV0);
                    double res = (x1-x0)/v0;
                    if (Double.isNaN(res)) {
                        textView.setText(R.string.tNo);
                    } else {
                        textView.setText("t = " + String.format("%.2f", res) + "s");
                    }
                } else if (valueV0.equals("")) {
                    double x0 = parse(valueX0);
                    double x1 = parse(valueX1);
                    double t = parse(valueT);
                    double res = (x1-x0)/t;
                    if (Double.isNaN(res)) {
                        textView.setText(R.string.vNo);
                    } else {
                        textView.setText("v = " + String.format("%.2f", res) + "m/s");
                    }
                } else if (valueX0.equals("")) {
                    double v0 = parse(valueV0);
                    double x1 = parse(valueX1);
                    double t = parse(valueT);
                    double res = x1-(v0*t);
                    textView.setText("x0 = " + String.format("%.2f", res) + "m");
                }

            }
        });
    }
}
