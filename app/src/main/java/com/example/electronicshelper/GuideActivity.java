package com.example.electronicshelper;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.electronicshelper.ui.guide.smd_body.CmdBody;
import com.example.electronicshelper.ui.guide.smd_components.CmdComponents;
import com.example.electronicshelper.ui.guide.circuit_symbol.GostR;
import com.example.electronicshelper.ui.guide.guide_pinout.Pinout;
import com.example.electronicshelper.ui.adapter.SubItem;
import com.example.electronicshelper.ui.adapter.SubItemAdapter;
import com.example.electronicshelper.ui.guide.WebViewCapacitorEsr;
import com.example.electronicshelper.ui.guide.WebViewCapacitorMark;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class GuideActivity extends AppCompatActivity implements SubItemAdapter.OnSubItemListener {

    public void onCreate(Bundle savedInstanceState) {
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
        imageView.setImageResource(R.drawable.ic_icon_book);
        TextView textView = this.findViewById(R.id.tv_item_title);
        textView.setText(R.string.menu_guide);

    }

    @NotNull
    private List<SubItem> buildSubItemList() {

        List<SubItem> subItemList = new ArrayList<>();

        SubItem subItem;

        subItem = new SubItem(R.drawable.ic_guide_pinout_icon, "Справочник", "распиновок (цоколевка)");
        subItemList.add(subItem);

        subItem = new SubItem(R.drawable.ic_ground_symbol, "Символы", "электронных схем");
        subItemList.add(subItem);

        subItem = new SubItem(R.drawable.ic_capacitor_k, "Маркировки", "конденсаторов");
        subItemList.add(subItem);

        subItem = new SubItem(R.drawable.ic_capacitor_el, "Таблица ESR", "электролитических конденсаторов");
        subItemList.add(subItem);

        subItem = new SubItem(R.drawable.ic_smd_diode, "Коды маркировки", "SMD компонентов");
        subItemList.add(subItem);

        subItem = new SubItem(R.drawable.ic_sot23_5, "Список SMD", "корпусов");
        subItemList.add(subItem);

        return subItemList;
    }

    void openingToast(){
        Toast.makeText(this, R.string.item_opening, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void OnSubItemClick(int position) {
        switch (position) {
            case 0:
                startActivity(new Intent(this, Pinout.class));
                break;
            case 1:
                startActivity(new Intent(this, GostR.class));
                break;
            case 2:
                openingToast();
                startActivity(new Intent(this, WebViewCapacitorMark.class));
                break;
            case 3:
                openingToast();
                startActivity(new Intent(this, WebViewCapacitorEsr.class));
                break;
            case 4:
                startActivity(new Intent(this, CmdComponents.class));
                break;
            case 5:
                startActivity(new Intent(this, CmdBody.class));
                break;
        }
    }
}