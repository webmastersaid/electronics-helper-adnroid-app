package com.example.electronicshelper.ui.guide.circuit_symbol;

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

public class GostR  extends AppCompatActivity implements SubItemAdapter.OnSubItemListener {

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
        imageView.setImageResource(R.drawable.ic_guarantee_certificate);
        TextView textView = this.findViewById(R.id.tv_item_title);
        textView.setText(R.string.title_activity_gost);

    }

    int[] cSymbols = {R.drawable.ic_guarantee_certificate};

    @NotNull
    private List<SubItem> buildSubItemList() {

        List<SubItem> subItemList = new ArrayList<>();

        SubItem subItem;

        subItem = new SubItem(cSymbols[0], "ГОСТ Р МЭК", "60617-DB-12M-2015");
        subItemList.add(subItem);

        return subItemList;
    }


    @Override
    public void OnSubItemClick(int position) {
        if (position == 0) {
            startActivity(new Intent(this, ElectronicsSymbols.class));
        }
    }

}
