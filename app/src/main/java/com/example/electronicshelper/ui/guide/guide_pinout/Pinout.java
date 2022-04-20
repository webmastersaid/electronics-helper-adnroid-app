package com.example.electronicshelper.ui.guide.guide_pinout;

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

public class Pinout extends AppCompatActivity implements SubItemAdapter.OnSubItemListener {

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
        imageView.setImageResource(R.drawable.ic_guide_pinout_icon);
        TextView textView = this.findViewById(R.id.tv_item_title);
        textView.setText(R.string.menu_guide_pinout);

    }

    @NotNull
    private List<SubItem> buildSubItemList() {

        List<SubItem> subItemList = new ArrayList<>();

        SubItem subItem;

        subItem = new SubItem(R.drawable.ic_arduino_logo_icon, "Arduino", "Mega, Uno, Nano, Micro, Zero");
        subItemList.add(subItem);

        subItem = new SubItem(R.drawable.ic_raspberry_pi_logo_icon, "Raspberry Pi", "4 B, 3 A B+, 2 B, 1 B A+, Zero, Pico");
        subItemList.add(subItem);

        subItem = new SubItem(R.drawable.ic_orange, "Orange Pi", "Zero");
        subItemList.add(subItem);

        subItem = new SubItem(R.drawable.ic_usb_port_logo_icon, "Universal Serial Bus", "USB Type A, B, C, Mini, 3.0");
        subItemList.add(subItem);

        return subItemList;
    }

    @Override
    public void OnSubItemClick(int position) {
        switch (position){
            case 0:
                startActivity(new Intent(this, Arduino.class));
                break;
            case 1:
                startActivity(new Intent(this, Raspberry.class));
                break;
            case 2:
                startActivity(new Intent(this, Orange.class));
                break;
            case 3:
                startActivity(new Intent(this, USB.class));
                break;
        }
    }

}