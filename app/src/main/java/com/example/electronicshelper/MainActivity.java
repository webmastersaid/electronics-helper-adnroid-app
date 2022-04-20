package com.example.electronicshelper;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.electronicshelper.ui.adapter.SubItem;
import com.example.electronicshelper.ui.adapter.SubItemAdapter;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SubItemAdapter.OnSubItemListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setUpRecyclerView();

    }

    @Override
    public boolean onSupportNavigateUp() {
        return super.onSupportNavigateUp();
    }

    private void setUpRecyclerView(){
        RecyclerView layoutSubItem = findViewById(R.id.rv_sub_item);
        LinearLayoutManager layoutSubItemManager = new LinearLayoutManager(getApplicationContext());
        SubItemAdapter subItemAdapter = new SubItemAdapter(buildSubItemList(), this);
        layoutSubItem.setAdapter(subItemAdapter);
        layoutSubItem.setLayoutManager(layoutSubItemManager);

        ImageView imageView = findViewById(R.id.img_item);
        imageView.setImageResource(R.drawable.ic_icon_menu);
        TextView textView = this.findViewById(R.id.tv_item_title);
        textView.setText(R.string.menu_menu);
    }

    @NotNull
    private List<SubItem> buildSubItemList() {

        List<SubItem> subItemList = new ArrayList<>();

        SubItem subItem = new SubItem(R.drawable.ic_icon_book, (String) getText(R.string.menu_guide), "справочная информация по электронике");
        subItemList.add(subItem);

        subItem = new SubItem(R.drawable.ic_icon_calculator, (String) getText(R.string.menu_calc), "расчеты и вычисления электронных схем");
        subItemList.add(subItem);

        subItem = new SubItem(R.drawable.ic_icon_info, (String) getText(R.string.menu_about), "информация о приложении");
        subItemList.add(subItem);

        return subItemList;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_main, menu);
        return true;
    }

    @Override
    public void OnSubItemClick(int position) {
        switch (position) {
            case 0:
                startActivity(new Intent(this, GuideActivity.class));
                break;
            case 1:
                startActivity(new Intent(this, CalcActivity.class));
                break;
            case 2:
                startActivity(new Intent(this, AboutActivity.class));
                break;
        }

    }

}