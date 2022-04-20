package com.example.electronicshelper.ui.calculation.capacitor;

import static com.example.electronicshelper.R.id;
import static com.example.electronicshelper.R.layout;
import static com.example.electronicshelper.R.string;

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

public class ParallelC extends AppCompatActivity {

    String[] sArrayR = {"мкФ"};

    EditText etCI;
    EditText etF;
    TextView tvOhm;
    TextView tvReF;
    TextView tvReCI;
    TextView tvReCF;
    TextView tvOhm0;
    Button btnCalc;
    ImageButton btnCopy;
    ImageButton btnClear;
    Double operand = null;
    Double ci = null;
    Double f = null;
    ClipData buffClip;
    ClipboardManager buffClipboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_calc_view);
        Toolbar toolbar = findViewById(id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        tvReF = findViewById(id.tv_react_f);
        tvReCI = findViewById(id.tv_capacity);
        tvReCF = findViewById(id.tv_ohm_2);
        tvOhm0 = findViewById(id.tv_ohm_0);

        tvReF.setText(string.parallel_c);
        tvReCI.setText(string.div_u_c1);
        tvReCF.setText(string.div_u_c2);
        tvOhm0.setText(string.micro_f);

        ArrayAdapter<String> adapterR = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, sArrayR);
        adapterR.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner spinnerR1 = findViewById(id.spin_capacity);

        spinnerR1.setAdapter(adapterR);
        spinnerR1.setPrompt("С");
        spinnerR1.setSelection(0);

        Spinner spinnerR2 = findViewById(id.spin_frequency);

        spinnerR2.setAdapter(adapterR);
        spinnerR2.setPrompt("С");
        spinnerR2.setSelection(0);

        etCI = findViewById(id.et_capacity_induct);
        etF = findViewById(id.et_frequency);
        tvOhm = findViewById(id.tv_ohm);

        btnCalc = findViewById(id.btn_compute);
        btnClear = findViewById(id.btn_clear);
        btnCopy = findViewById(id.btn_copy);

        btnCalc.setOnClickListener(view -> {
            try{
                if (TextUtils.isEmpty(etCI.getText().toString())
                        || TextUtils.isEmpty(etF.getText().toString())){
                    return;
                } else {
                    ci = Double.parseDouble(etCI.getText().toString());
                    f = Double.parseDouble(etF.getText().toString());
                    operand = ci + f;
                }
            }catch (ArithmeticException e){
                return;
            }
            tvOhm.setText(new DecimalFormat("###.###").format(operand));
        });

        btnClear.setOnClickListener(view -> {
            etCI.getText().clear();
            etF.getText().clear();
        });

        btnCopy.setOnClickListener(view -> {
            buffClipboard = (ClipboardManager)getSystemService(CLIPBOARD_SERVICE);
            buffClip = ClipData.newPlainText("buffer", tvOhm.getText());
            buffClipboard.setPrimaryClip(buffClip);
            Toast.makeText(this, R.string.text_copied, Toast.LENGTH_SHORT).show();
        });

    }

    // сохранение состояния
    @Override
    protected void onSaveInstanceState(@NotNull Bundle outState) {
        if(operand!=null){
            outState.putDouble("OPERAND", operand);
            outState.putDouble("CI", ci);
            outState.putDouble("F", f);
        }
        super.onSaveInstanceState(outState);
    }

    // получение ранее сохраненного состояния
    @SuppressLint("SetTextI18n")
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        ci = savedInstanceState.getDouble("CI");
        f = savedInstanceState.getDouble("F");
        operand = savedInstanceState.getDouble("OPERAND");
        etCI.setText(ci.toString());
        etF.setText(f.toString());
        tvOhm.setText(operand.toString());
    }

}
