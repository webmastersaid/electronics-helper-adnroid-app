package com.example.electronicshelper.ui.calculation.ohm_law;

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

public class OhmLaw extends AppCompatActivity implements SubItemAdapter.OnSubItemListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arduino);
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
        imageView.setImageResource(R.drawable.ic_omega);
        TextView textView = this.findViewById(R.id.tv_item_title);
        textView.setText(R.string.menu_ohm_law);


    }
    int[] imgURIP = {
            R.drawable.ic_u,
            R.drawable.ic_i,
            R.drawable.ic_p,
            R.drawable.ic_r
    };

    @NotNull
    private List<SubItem> buildSubItemList() {

        List<SubItem> subItemList = new ArrayList<>();

        SubItem subItem;

        subItem = new SubItem(imgURIP[0], "Напряжение (Вольт)", "U = I*R");
        subItemList.add(subItem);

        subItem = new SubItem(imgURIP[1], "Ток (Ампер)", "I = U/R");
        subItemList.add(subItem);

        subItem = new SubItem(imgURIP[2], "Мощность (Ватт)", "P = U/I");
        subItemList.add(subItem);

        subItem = new SubItem(imgURIP[3], "Сопротивление (Ом)", "R = U*I");
        subItemList.add(subItem);

        return subItemList;
    }

    @Override
    public void OnSubItemClick(int position) {
        switch (position){
            case 0:
                startActivity(new Intent(this, OhmLawU.class));
                break;
            case 1:
                startActivity(new Intent(this, OhmLawI.class));
                break;
            case 2:
                startActivity(new Intent(this, OhmLawP.class));
                break;
            case 3:
                startActivity(new Intent(this, OhmLawR.class));
                break;
        }
    }

}