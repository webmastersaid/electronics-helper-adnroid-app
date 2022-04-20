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

public class Raspberry extends AppCompatActivity implements SubItemAdapter.OnSubItemListener {

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
        imageView.setImageResource(R.drawable.ic_raspberry_pi_logo_icon);
        TextView textView = this.findViewById(R.id.tv_item_title);
        textView.setText(R.string.title_activity_raspberry);

    }

    int[] raspberry = {
            R.drawable.png_raspberry_pi,
            R.drawable.png_raspberry_pi_pico
    };

    @NotNull
    private List<SubItem> buildSubItemList() {

        List<SubItem> subItemList = new ArrayList<>();

        SubItem subItem;

        subItem = new SubItem(raspberry[0], "Raspberry Pi", "A, A+, B, B+, Zero");
        subItemList.add(subItem);

        subItem = new SubItem(raspberry[1], "Raspberry Pi", "Pico");
        subItemList.add(subItem);

        return subItemList;
    }

    int[] imgRaspberry = {
            R.drawable.img_raspberry_pi_pinout,
            R.drawable.img_raspberry_pi_pinout_pico
    };

    @Override
    public void OnSubItemClick(int position) {
        Intent intent = new Intent(this, ImgView.class);
        Toast.makeText(getApplicationContext(), R.string.item_loading,Toast.LENGTH_SHORT).show();
        intent.putExtra("Img",imgRaspberry[position]);
        startActivity(intent);
    }

}