package com.example.testandroid.Fragments.Mates;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
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
import com.example.testandroid.FormulasTrigo;
import com.example.testandroid.R;

import org.w3c.dom.Text;

public class FragmentTrigo extends Fragment {

    FormulasTrigo ras = new FormulasTrigo();

    public double parse(String number) {
        return Double.parseDouble(number);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_trigo, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Button btnProperties = getView().findViewById(R.id.matProper_btn);
        Button btnSumaSin = getView().findViewById(R.id.matSumaSin_btn);
        Button btnSumaCos = getView().findViewById(R.id.matSumaCos_btn);
        final TextView textProper_sin = getView().findViewById(R.id.matProper_textSin);
        final TextView textProper_cos = getView().findViewById(R.id.matProper_textCos);
        final TextView textProper_tan = getView().findViewById(R.id.matProper_textTan);

        final TextView textSumaSin = getView().findViewById(R.id.matSumaSin_result);
        final TextView textSumaCos = getView().findViewById(R.id.matSumaCos_result);

        final Toast unaIncognita = Toast.makeText(getActivity(),R.string.unaIncognita,Toast.LENGTH_LONG);

        final Switch switchSumaRestaSin = getView().findViewById(R.id.matSumaRestaSin_switch);
        final Switch switchSumaRestaCos = getView().findViewById(R.id.matSumaRestaCos_switch);

        switchSumaRestaSin.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                TextView text = getView().findViewById(R.id.matSumaSin_title);
                if (isChecked) {
                    text.setText(R.string.restaSin);
                    textSumaSin.setText("");
                } else {
                    text.setText(R.string.sumaSin);
                    textSumaSin.setText("");
                }
            }
        });

        switchSumaRestaCos.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                TextView text = getView().findViewById(R.id.matSumaCos_title);
                if (isChecked) {
                    text.setText(R.string.restaCos);
                    textSumaCos.setText("");
                } else {
                    text.setText(R.string.sumaCos);
                    textSumaCos.setText("");
                }
            }
        });


        btnProperties.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText alpha = getView().findViewById(R.id.matProper_valueAlpha);
                String a1 = alpha.getText().toString();
                double sin, cos, tan, a;

                if (a1.isEmpty()) {
                    unaIncognita.show();
                    return;
                }

                a = parse(a1);
                sin = Math.sin(Math.toRadians(a));
                cos = Math.cos(Math.toRadians(a));
                tan = Math.tan(Math.toRadians(a));

                textProper_sin.setText("sin = " + String.format("%.2f", sin));
                textProper_cos.setText("cos = " + String.format("%.2f", cos));
                textProper_tan.setText("tan = " + String.format("%.2f", tan));
            }
        });

        btnSumaSin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText alpha = getView().findViewById(R.id.matSumaSin_valueAlpha);
                EditText beta = getView().findViewById(R.id.matSumaSin_valueBeta);
                String a1 = alpha.getText().toString();
                String b1 = beta.getText().toString();
                double a, b, res;

                if (a1.isEmpty() & b1.isEmpty()) {
                    unaIncognita.show();
                    return;
                }

                if (!b1.isEmpty()) {
                    if (a1.isEmpty()) {
                        unaIncognita.show();
                        return;
                    }
                }

                if (!a1.isEmpty()) {
                    if (b1.isEmpty()) {
                        unaIncognita.show();
                        return;
                    }
                }

                if (!switchSumaRestaSin.isChecked()) {
                    //AQUÍ SE SUMA
                    a = parse(a1);
                    b = parse(b1);
                    res = ras.sumaSin(a, b);
                    textSumaSin.setText("sin" + a + " + sin" + b + " = " + String.format("%.2f", res));

                } else {
                    //AQUÍ SE RESTA
                    a = parse(a1);
                    b = parse(b1);
                    res = ras.restaSin(a, b);
                    textSumaSin.setText("sin" + a + " - sin" + b + " = " + String.format("%.2f", res));
                }
            }
        });

        btnSumaCos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText alpha = getView().findViewById(R.id.matSumaCos_valueAlpha);
                EditText beta = getView().findViewById(R.id.matSumaCos_valueBeta);
                String a1 = alpha.getText().toString();
                String b1 = beta.getText().toString();
                double a, b, res;

                if (a1.isEmpty() & b1.isEmpty()) {
                    unaIncognita.show();
                    return;
                }

                if (!b1.isEmpty()) {
                    if (a1.isEmpty()) {
                        unaIncognita.show();
                        return;
                    }
                }

                if (!a1.isEmpty()) {
                    if (b1.isEmpty()) {
                        unaIncognita.show();
                        return;
                    }
                }

                if (!switchSumaRestaCos.isChecked()) {
                    //AQUÍ SE SUMA
                    a = parse(a1);
                    b = parse(b1);
                    res = ras.sumaCos(a, b);
                    textSumaCos.setText("cos" + a + " + cos" + b + " = " + String.format("%.2f", res));
                } else {
                    //AQUÍ SE RESTA
                    a = parse(a1);
                    b = parse(b1);
                    res = ras.restaCos(a, b);
                    textSumaCos.setText("cos" + a + " - cos" + b + " = " + String.format("%.2f", res));
                }
            }
        });


    }
}
