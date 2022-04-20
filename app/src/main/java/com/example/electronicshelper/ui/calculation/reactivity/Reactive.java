package com.example.electronicshelper.ui.calculation.reactivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.electronicshelper.R;
import com.example.electronicshelper.ui.adapter.SubItem;
import com.example.electronicshelper.ui.adapter.SubItemAdapter;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Reactive extends AppCompatActivity implements SubItemAdapter.OnSubItemListener {

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
        imageView.setImageResource(R.drawable.ic_frequency);
        TextView textView = this.findViewById(R.id.tv_item_title);
        textView.setText(R.string.menu_calc_react);


    }
    int[] imgCL = {
            R.drawable.ic_icon_capacitor,
            R.drawable.ic_icon_inductor
    };

    @NotNull
    private List<SubItem> buildSubItemList() {

        List<SubItem> subItemList = new ArrayList<>();

        SubItem subItem;

        subItem = new SubItem(imgCL[0], "Реактивность", "конденсатора");
        subItemList.add(subItem);

        subItem = new SubItem(imgCL[1], "Реактивность", "индукционной катушки");
        subItemList.add(subItem);

        return subItemList;
    }

    @Override
    public void OnSubItemClick(int position) {
        switch (position){
            case 0:
                startActivity(new Intent(this, ReactiveCapacitor.class));
                break;
            case 1:
                startActivity(new Intent(this, ReactiveInductor.class));
                break;
        }
    }

}