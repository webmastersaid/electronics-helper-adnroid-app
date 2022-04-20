package com.example.electronicshelper;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.electronicshelper.ui.calculation.capacitor.ParallelC;
import com.example.electronicshelper.ui.calculation.capacitor.SerialC;
import com.example.electronicshelper.ui.calculation.div_u.DivUr;
import com.example.electronicshelper.ui.calculation.led_r.LedR;
import com.example.electronicshelper.ui.calculation.ohm_law.OhmLaw;
import com.example.electronicshelper.ui.calculation.reactivity.Reactive;
import com.example.electronicshelper.ui.calculation.resistor.ParallelR;
import com.example.electronicshelper.ui.calculation.resistor.SerialR;
import com.example.electronicshelper.ui.adapter.SubItem;
import com.example.electronicshelper.ui.adapter.SubItemAdapter;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class CalcActivity extends AppCompatActivity implements SubItemAdapter.OnSubItemListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        RecyclerView layoutSubItem = this.findViewById(R.id.rv_sub_item);
        LinearLayoutManager layoutSubItemManager = new LinearLayoutManager(getApplicationContext());
        SubItemAdapter subItemAdapter = new SubItemAdapter(buildSubItemList(), this);
        layoutSubItem.setAdapter(subItemAdapter);
        layoutSubItem.setLayoutManager(layoutSubItemManager);

        ImageView imageView = this.findViewById(R.id.img_item);
        imageView.setImageResource(R.drawable.ic_icon_calculator);
        TextView textView = this.findViewById(R.id.tv_item_title);
        textView.setText(R.string.menu_calc);

    }

    int[] calks = {
            R.drawable.png_ohm_law,
            R.drawable.png_div_u,
            R.drawable.png_r_led,
            R.drawable.png_reactive_lc,
            R.drawable.png_parallel_r,
            R.drawable.png_sequence_r,
            R.drawable.png_parallel_c,
            R.drawable.png_sequence_c
    };

    @NotNull
    private List<SubItem> buildSubItemList() {

        List<SubItem> subItemList = new ArrayList<>();

        SubItem subItem;

        subItem = new SubItem(calks[0], "Калькулятор", "закона Ома");
        subItemList.add(subItem);

        subItem = new SubItem(calks[1], "Делитель", "напряжения");
        subItemList.add(subItem);

        subItem = new SubItem(calks[2], "Резистор", "для светодиода");
        subItemList.add(subItem);

        subItem = new SubItem(calks[3], "Реактивность", "индукционной катушки и конденсатора");
        subItemList.add(subItem);

        subItem = new SubItem(calks[4], "Параллельные", "резисторы");
        subItemList.add(subItem);

        subItem = new SubItem(calks[5], "Последовательные", "резисторы");
        subItemList.add(subItem);

        subItem = new SubItem(calks[6], "Параллельные", "конденсаторы");
        subItemList.add(subItem);

        subItem = new SubItem(calks[7], "Последовательные", "конденсаторы");
        subItemList.add(subItem);

        return subItemList;
    }

    @Override
    public void OnSubItemClick(int position) {
        switch (position){
            case 0:
                startActivity(new Intent(this, OhmLaw.class));
                break;
            case 1:
                startActivity(new Intent(this, DivUr.class));
                break;
            case 2:
                startActivity(new Intent(this, LedR.class));
                break;
            case 3:
                startActivity(new Intent(this, Reactive.class));
                break;
            case 4:
                startActivity(new Intent(this, ParallelR.class));
                break;
            case 5:
                startActivity(new Intent(this, SerialR.class));
                break;
            case 6:
                startActivity(new Intent(this, ParallelC.class));
                break;
            case 7:
                startActivity(new Intent(this, SerialC.class));
                break;
        }
    }

}