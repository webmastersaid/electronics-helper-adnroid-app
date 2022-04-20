package com.example.electronicshelper.ui.calculation.div_u;

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

public class DivUr extends AppCompatActivity {

    String[] sArrayU = {"В"};
    String[] sArrayR = {"Ом"};

    EditText etDivU;
    EditText etDivR1;
    EditText etDivR2;
    TextView tvDivUout;
    TextView tvDivU1;
    TextView tvDivU2;
    TextView tvDivUf;
    TextView tvDivUf1;
    TextView tvDivUf2;
    TextView tvDivUv;
    TextView tvDivUv1;
    TextView tvDivUv2;
    TextView tvDivUu;
    TextView tvDivUi;
    TextView tvDivR1;
    TextView tvDivR2;
    Button btnCalc;
    ImageButton btnClear;
    ImageButton btnCopy1;
    ImageButton btnCopy2;
    ImageButton btnCopy;
    Double operand = null;
    Double u = null;
    Double u1 = null;
    Double u2 = null;
    Double r1 = null;
    Double r2 = null;
    ClipData buffClip;
    ClipboardManager buffClipboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc_div_u_r);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        //Формула
        tvDivUf = findViewById(R.id.tv_div_u_f);
        tvDivUf1 = findViewById(R.id.tv_div_u_f1);
        tvDivUf2 = findViewById(R.id.tv_div_u_f2);
        //Выходное напряжение
        tvDivUv = findViewById(R.id.tv_div_v_output);
        tvDivUv1 = findViewById(R.id.tv_div_v_output1);
        tvDivUv2 = findViewById(R.id.tv_div_v_output2);
        //Значение выходного напряжения
        tvDivUout = findViewById(R.id.tv_div_u_output);
        tvDivU1 = findViewById(R.id.tv_div_u_output1);
        tvDivU2 = findViewById(R.id.tv_div_u_output2);
        //Вольт
        tvDivUu = findViewById(R.id.tv_div_output_u);
        //Входное напряжение
        tvDivUi = findViewById(R.id.tv_div_u);
        //Первый резистор
        tvDivR1 = findViewById(R.id.tv_div_u_r1);
        //Второй резистор
        tvDivR2 = findViewById(R.id.tv_div_u_r2);


        //Uвых = Uвход * R2 / (R1 * R2)
        tvDivUf.setText(R.string.div_u_f_u);
        tvDivUf1.setText(R.string.div_u_f_u1);
        tvDivUf2.setText(R.string.div_u_f_u2);
        //Uвых
        tvDivUv.setText(R.string.div_u_v);
        tvDivUv1.setText(R.string.div_u_v1);
        tvDivUv2.setText(R.string.div_u_v2);
        //Uвход
        tvDivUi.setText(R.string.div_u_u);
        //R1
        tvDivR1.setText(R.string.div_u_r1);
        //R2
        tvDivR2.setText(R.string.div_u_r2);
        //Поле ввода входного напряжения
        etDivU = findViewById(R.id.et_div_u);
        //Поле ввода первого резистора
        etDivR1 = findViewById(R.id.et_div_u_r1);
        //Поле ввода второго резистора
        etDivR2 = findViewById(R.id.et_div_u_r2);

        ArrayAdapter<String> adapterU = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, sArrayU);
        adapterU.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner spinnerU = findViewById(R.id.div_u_spin_u);

        spinnerU.setAdapter(adapterU);
        spinnerU.setPrompt("U");
        spinnerU.setSelection(0);

        ArrayAdapter<String> adapterR1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, sArrayR);
        adapterR1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner spinnerR1 = findViewById(R.id.div_u_spin_r1);

        spinnerR1.setAdapter(adapterR1);
        spinnerR1.setPrompt("R");
        spinnerR1.setSelection(0);

        ArrayAdapter<String> adapterR2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, sArrayR);
        adapterR2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner spinnerR2 = findViewById(R.id.div_u_spin_r2);

        spinnerR2.setAdapter(adapterR2);
        spinnerR2.setPrompt("R");
        spinnerR2.setSelection(0);

        btnCalc = findViewById(R.id.btn_compute);
        btnClear = findViewById(R.id.btn_clear);
        btnCopy1 = findViewById(R.id.btn_copy1);
        btnCopy2 = findViewById(R.id.btn_copy2);
        btnCopy = findViewById(R.id.btn_copy);

        btnCalc.setOnClickListener(view -> {
            try{
                if (TextUtils.isEmpty(etDivU.getText().toString())
                        || TextUtils.isEmpty(etDivR1.getText().toString())
                        || TextUtils.isEmpty(etDivR2.getText().toString())){
                    Toast.makeText(this, R.string.is_empty, Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    u = Double.parseDouble(etDivU.getText().toString());
                    r1 = Double.parseDouble(etDivR1.getText().toString());
                    r2 = Double.parseDouble(etDivR2.getText().toString());
                    u1 = (u * r1) / (r1 + r2);
                    u2 = (u * r2) / (r1 + r2);
                    operand = u1 + u2;

                }
            }catch (ArithmeticException e){
                Toast.makeText(this, R.string.division_by_zero, Toast.LENGTH_SHORT).show();
                return;
            }
            tvDivU1.setText(new DecimalFormat("###.###").format(u1));
            tvDivU2.setText(new DecimalFormat("###.###").format(u2));
            tvDivUout.setText(new DecimalFormat("###.###").format(operand));
        });

        btnClear.setOnClickListener(view -> {
            etDivU.getText().clear();
            etDivR1.getText().clear();
            etDivR2.getText().clear();
        });

        btnCopy1.setOnClickListener(view -> {
            buffClipboard = (ClipboardManager)getSystemService(CLIPBOARD_SERVICE);
            buffClip = ClipData.newPlainText("buffer", tvDivU1.getText());
            buffClipboard.setPrimaryClip(buffClip);
            Toast.makeText(this, R.string.text_copied, Toast.LENGTH_SHORT).show();
        });

        btnCopy2.setOnClickListener(view -> {
            buffClipboard = (ClipboardManager)getSystemService(CLIPBOARD_SERVICE);
            buffClip = ClipData.newPlainText("buffer", tvDivU1.getText());
            buffClipboard.setPrimaryClip(buffClip);
            Toast.makeText(this, R.string.text_copied, Toast.LENGTH_SHORT).show();
        });

        btnCopy.setOnClickListener(view -> {
            buffClipboard = (ClipboardManager)getSystemService(CLIPBOARD_SERVICE);
            buffClip = ClipData.newPlainText("buffer", tvDivUout.getText());
            buffClipboard.setPrimaryClip(buffClip);
            Toast.makeText(this, R.string.text_copied, Toast.LENGTH_SHORT).show();
        });

    }

    @Override
    protected void onSaveInstanceState(@NotNull Bundle outState) {
        if(operand!=null){
            outState.putDouble("OPERAND", operand);
            outState.putDouble("Uout", u);
            outState.putDouble("R1", r1);
            outState.putDouble("R2", r1);
        }
        super.onSaveInstanceState(outState);
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        u = savedInstanceState.getDouble("Uout");
        r1 = savedInstanceState.getDouble("R1");
        r2 = savedInstanceState.getDouble("R1");
        operand = savedInstanceState.getDouble("OPERAND");
        etDivU.setText(u.toString());
        etDivR1.setText(r1.toString());
        etDivR2.setText(r2.toString());
        tvDivUout.setText(operand.toString());
    }

}