package com.example.electronicshelper.ui.calculation.ohm_law;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.electronicshelper.R;

import org.jetbrains.annotations.NotNull;

import java.text.DecimalFormat;

public class OhmLawI extends AppCompatActivity {

    String[] sArrayU = {"В"};
    String[] sArrayR = {"Ом"};

    EditText etU;
    EditText etR;
    TextView tvOhmLawOut;
    TextView tvOhmF;
    TextView tvOhm0;
    TextView tvOhm1;
    TextView tvOhm2;
    Button btnCalc;
    ImageButton btnCopy;
    ImageButton btnClear;
    Double operand = null;
    Double u = null;
    Double r = null;
    ClipData buffClip;
    ClipboardManager buffClipboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc_ohm_law);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        tvOhmF = findViewById(R.id.tv_ohm_f);
        tvOhm0 = findViewById(R.id.tv_ohm_0);
        tvOhm1 = findViewById(R.id.tv_ohm_1);
        tvOhm2 = findViewById(R.id.tv_ohm_2);

        tvOhmF.setText(R.string.ohm_law_f_i);
        tvOhm0.setText(R.string.ohm_law_a);
        tvOhm1.setText(R.string.ohm_law_u);
        tvOhm2.setText(R.string.ohm_law_r);

        ArrayAdapter<String> adapterU = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, sArrayU);
        adapterU.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner spinnerU = findViewById(R.id.ohm_law_spin_u);

        spinnerU.setAdapter(adapterU);
        spinnerU.setPrompt("U");
        spinnerU.setSelection(0);

        ArrayAdapter<String> adapterR = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, sArrayR);
        adapterR.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner spinnerR = findViewById(R.id.ohm_law_spin_r);

        spinnerR.setAdapter(adapterR);
        spinnerR.setPrompt("R");
        spinnerR.setSelection(0);

        etU = findViewById(R.id.et_ohm_law_u);
        etR = findViewById(R.id.et_ohm_law_r);
        tvOhmLawOut = findViewById(R.id.ohm_law_output);

        btnCalc = findViewById(R.id.btn_compute);
        btnClear = findViewById(R.id.btn_clear);
        btnCopy = findViewById(R.id.btn_copy);

        // Вычисление
        btnCalc.setOnClickListener(view -> {
            try{
                if (TextUtils.isEmpty(etU.getText().toString())
                        || TextUtils.isEmpty(etR.getText().toString())){
                    return;
                } else {
                    u = Double.parseDouble(etU.getText().toString());
                    r = Double.parseDouble(etR.getText().toString());
                    operand = u / r;
                }
            }catch (ArithmeticException e){
                return;
            }
            tvOhmLawOut.setText(new DecimalFormat("###.###").format(operand));
        });

        // Очистка
        btnClear.setOnClickListener(view -> {
            etU.getText().clear();
            etR.getText().clear();
        });

        // Буфер обмена
        btnCopy.setOnClickListener(view -> {
            buffClipboard = (ClipboardManager)getSystemService(CLIPBOARD_SERVICE);
            buffClip = ClipData.newPlainText("buffer", tvOhmLawOut.getText());
            buffClipboard.setPrimaryClip(buffClip);
            Toast.makeText(this, R.string.text_copied, Toast.LENGTH_SHORT).show();
        });

    }

    // сохранение состояния
    @Override
    protected void onSaveInstanceState(@NotNull Bundle outState) {
        if(operand!=null){
            outState.putDouble("OPERAND", operand);
            outState.putDouble("U", u);
            outState.putDouble("R", r);
        }
        super.onSaveInstanceState(outState);
    }
    // получение ранее сохраненного состояния
    @SuppressLint("SetTextI18n")
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        u = savedInstanceState.getDouble("U");
        r = savedInstanceState.getDouble("R");
        operand = savedInstanceState.getDouble("OPERAND");
        etU.setText(u.toString());
        etR.setText(r.toString());
        tvOhmLawOut.setText(operand.toString());
    }

}