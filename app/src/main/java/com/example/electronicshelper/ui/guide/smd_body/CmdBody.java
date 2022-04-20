package com.example.electronicshelper.ui.guide.smd_body;

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

public class CmdBody extends AppCompatActivity implements SubItemAdapter.OnSubItemListener {
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
        imageView.setImageResource(R.drawable.ic_sot23_5);
        TextView textView = this.findViewById(R.id.tv_item_title);
        textView.setText(R.string.title_activity_smd_body);

    }

    int[] cSymbols = {
            R.drawable.ic_smd_kerko,
            R.drawable.ic_sot23_5
    };

    @NotNull
    private List<SubItem> buildSubItemList() {

        List<SubItem> subItemList = new ArrayList<>();

        SubItem subItem;

        subItem = new SubItem(cSymbols[0], "Прямоугольные", "пассивные компоненты");
        subItemList.add(subItem);

        subItem = new SubItem(cSymbols[1], "SOT", "Small-outline transistor");
        subItemList.add(subItem);

        return subItemList;
    }

    @Override
    public void OnSubItemClick(int position) {
        switch (position){
            case 0:
                startActivity(new Intent(this, CmdPassive.class));
                break;
            case 1:
                startActivity(new Intent(this, SmdSOT.class));
        }
    }
}
