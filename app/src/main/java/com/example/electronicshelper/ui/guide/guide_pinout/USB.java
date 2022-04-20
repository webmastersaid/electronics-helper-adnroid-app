package com.example.electronicshelper.ui.guide.guide_pinout;

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

import com.example.electronicshelper.R;
import com.example.electronicshelper.ui.adapter.SubItem;
import com.example.electronicshelper.ui.adapter.SubItemAdapter;
import com.example.electronicshelper.ui.guide.guide_pinout.pinout_view.ImgView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class USB extends AppCompatActivity implements SubItemAdapter.OnSubItemListener {

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
        imageView.setImageResource(R.drawable.ic_usb_port_logo_icon);
        TextView textView = this.findViewById(R.id.tv_item_title);
        textView.setText(R.string.title_activity_usb);

    }

    @NotNull
    private List<SubItem> buildSubItemList() {

        List<SubItem> subItemList = new ArrayList<>();

        SubItem subItem;

        subItem = new SubItem(R.drawable.ic_icon_usb_plug, "USB 1.x и 2.0", "A B");
        subItemList.add(subItem);

        subItem = new SubItem(R.drawable.ic_icon_usb_plug, "USB 3.0", "A B");
        subItemList.add(subItem);

        return subItemList;
    }

    int[] imgUSB = {
            R.drawable.img_usb_pinout_1_2,
            R.drawable.img_usb_pinout_30
    };

    @Override
    public void OnSubItemClick(int position) {
        Intent intent = new Intent(this, ImgView.class);
        Toast.makeText(getApplicationContext(), R.string.item_loading, Toast.LENGTH_SHORT).show();
        intent.putExtra("Img",imgUSB[position]);
        startActivity(intent);
    }

}