package com.example.electronicshelper.ui.calculation.led_r;

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

public class LedR extends AppCompatActivity {
    String[] sArrayU = {"В"};
    String[] sArrayI = {"мА"};

    TextView tvLedR;
    TextView tvLedP;
    EditText etPwrU;
    EditText etLedU;
    EditText etLedI;
    Button btnCalc;
    ImageButton btnClear;
    ImageButton btnCopy1;
    ImageButton btnCopy2;
    Double uPwr = null;
    Double uLed = null;
    Double iLed = null;
    Double uResult = null;
    Double ohmResult = null;
    Double pwrResult = null;
    ClipData buffClip;
    ClipboardManager buffClipboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc_led_r);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        //Вывод
        tvLedR = findViewById(R.id.tv_led_r_out); //Сопротивление светодиода
        tvLedP = findViewById(R.id.tv_led_p_out); //Мощность светодиода

        //Ввод
        etPwrU = findViewById(R.id.et_pwr_u); //Напряжение источника питания
        etLedU = findViewById(R.id.et_led_u); //Напряжение светодиода
        etLedI = findViewById(R.id.et_led_i); //Номинальный ток светодиода

        //Кнопки
        btnCalc = findViewById(R.id.btn_div_u_compute); // Вычислить
        btnClear = findViewById(R.id.btn_div_u_clear); // Очистить
        btnCopy1 = findViewById(R.id.btn_div_u_copy1); // Скопировать первое значение
        btnCopy2 = findViewById(R.id.btn_div_u_copy2); // Скопировать второе значение

        // Спинер напряжения
        ArrayAdapter<String> adapterU = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, sArrayU);
        adapterU.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner spinnerUp = findViewById(R.id.spin_pwr_u);
        spinnerUp.setAdapter(adapterU);
        spinnerUp.setPrompt("U");
        spinnerUp.setSelection(0);
        Spinner spinnerUl = findViewById(R.id.spin_led_u);
        spinnerUl.setAdapter(adapterU);
        spinnerUl.setPrompt("U");
        spinnerUl.setSelection(0);

        // Спинер тока
        ArrayAdapter<String> adapterI = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, sArrayI);
        adapterI.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner spinnerI = findViewById(R.id.spin_led_i);
        spinnerI.setAdapter(adapterI);
        spinnerI.setPrompt("I");
        spinnerI.setSelection(0);

        // Вычислить
        btnCalc.setOnClickListener(view -> {
            try{
                if (TextUtils.isEmpty(etPwrU.getText().toString())
                        || TextUtils.isEmpty(etLedU.getText().toString())
                        || TextUtils.isEmpty(etLedI.getText().toString())){
                    Toast.makeText(this, R.string.is_empty, Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    uPwr = Double.parseDouble(etPwrU.getText().toString());
                    uLed = Double.parseDouble(etLedU.getText().toString());
                    iLed = Double.parseDouble(etLedI.getText().toString());

                    uResult = uPwr - uLed;
                    ohmResult = uResult / (iLed * 0.001);
                    pwrResult = uResult * (iLed * 0.001);

                }
            }catch (ArithmeticException e){
                Toast.makeText(this, R.string.division_by_zero, Toast.LENGTH_SHORT).show();
                return;
            }
            tvLedR.setText(new DecimalFormat("###.###").format(ohmResult));
            tvLedP.setText(new DecimalFormat("###.###").format(pwrResult));
        });

        // Очистить
        btnClear.setOnClickListener(view -> {
            etPwrU.getText().clear();
            etLedU.getText().clear();
            etLedI.getText().clear();
        });

        // Скопировать первое значение
        btnCopy1.setOnClickListener(view -> {
            buffClipboard = (ClipboardManager)getSystemService(CLIPBOARD_SERVICE);
            buffClip = ClipData.newPlainText("buffer1", tvLedR.getText());
            buffClipboard.setPrimaryClip(buffClip);
            Toast.makeText(this, R.string.text_copied, Toast.LENGTH_SHORT).show();
        });

        // Скопировать второе значение
        btnCopy2.setOnClickListener(view -> {
            buffClipboard = (ClipboardManager)getSystemService(CLIPBOARD_SERVICE);
            buffClip = ClipData.newPlainText("buffer2", tvLedP.getText());
            buffClipboard.setPrimaryClip(buffClip);
            Toast.makeText(this, R.string.text_copied, Toast.LENGTH_SHORT).show();
        });

    }

    @Override
    protected void onSaveInstanceState(@NotNull Bundle outState) {
        if(uResult!=null){
            outState.putDouble("Ohm", ohmResult);
            outState.putDouble("Pwr", pwrResult);
            outState.putDouble("U1", uPwr);
            outState.putDouble("U2", uLed);
            outState.putDouble("I", iLed);
        }
        super.onSaveInstanceState(outState);
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        ohmResult = savedInstanceState.getDouble("Ohm");
        pwrResult = savedInstanceState.getDouble("Pwr");
        uPwr = savedInstanceState.getDouble("U1");
        uLed = savedInstanceState.getDouble("U2");
        iLed = savedInstanceState.getDouble("I");
        tvLedR.setText(ohmResult.toString());
        tvLedP.setText(pwrResult.toString());
        etPwrU.setText(uPwr.toString());
        etLedU.setText(uLed.toString());
        etLedI.setText(iLed.toString());
    }

}
