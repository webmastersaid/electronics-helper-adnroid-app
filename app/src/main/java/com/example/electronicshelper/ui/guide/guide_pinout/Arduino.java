package com.example.electronicshelper.ui.guide.guide_pinout;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.electronicshelper.R;
import com.example.electronicshelper.ui.guide.guide_pinout.pinout_view.ImgView;
import com.example.electronicshelper.ui.adapter.SubItem;
import com.example.electronicshelper.ui.adapter.SubItemAdapter;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Arduino extends AppCompatActivity implements SubItemAdapter.OnSubItemListener {

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

        android.widget.ImageView imageView = this.findViewById(R.id.img_item);
        imageView.setImageResource(R.drawable.ic_arduino_logo_icon);
        TextView textView = this.findViewById(R.id.tv_item_title);
        textView.setText(R.string.title_activity_arduino);

    }

    int[] arduino = {
            R.drawable.png_arduino_due,
            R.drawable.png_arduino_edge_control,
            R.drawable.png_arduino_leonardo,
            R.drawable.png_arduino_mega_2560,
            R.drawable.png_arduino_micro,
            R.drawable.png_arduino_mkr1000,
            R.drawable.png_arduino_mkr_nb1500,
            R.drawable.png_arduino_mkr_sgm1400,
            R.drawable.png_arduino_mkr_vidor4000,
            R.drawable.png_arduino_mkr_wan1300,
            R.drawable.png_arduino_mkr_wan1310,
            R.drawable.png_arduino_mkr_zero,
            R.drawable.png_arduino_nano,
            R.drawable.png_arduino_nano_33_ble,
            R.drawable.png_arduino_nano_33_ble_sense,
            R.drawable.png_arduino_nano_33_iot,
            R.drawable.png_arduino_nano_every,
            R.drawable.png_arduino_nano_rp2040_connect,
            R.drawable.png_arduino_portenta_breakout,
            R.drawable.png_arduino_portenta_h7,
            R.drawable.png_arduino_uno_rev3,
            R.drawable.png_arduino_uno_rev3_smd,
            R.drawable.png_arduino_uno_wifi_rev2,
            R.drawable.png_arduino_vision_shield_ethernet,
            R.drawable.png_arduino_vision_shield_lora,
            R.drawable.png_arduino_yun_rev2,
            R.drawable.png_arduino_zero
    };

    @NotNull
    private List<SubItem> buildSubItemList() {

        List<SubItem> subItemList = new ArrayList<>();

        SubItem subItem;

        subItem = new SubItem(arduino[0], "Arduino", "Due");
        subItemList.add(subItem);
        subItem = new SubItem(arduino[1], "Arduino", "Edge Control");
        subItemList.add(subItem);
        subItem = new SubItem(arduino[2], "Arduino", "Leonardo");
        subItemList.add(subItem);
        subItem = new SubItem(arduino[3], "Arduino", "Mega 2560 Rev 3");
        subItemList.add(subItem);
        subItem = new SubItem(arduino[4], "Arduino", "Micro");
        subItemList.add(subItem);
        subItem = new SubItem(arduino[5], "Arduino", "MKR WiFi 1000");
        subItemList.add(subItem);
        subItem = new SubItem(arduino[6], "Arduino", "MKR NB 1500");
        subItemList.add(subItem);
        subItem = new SubItem(arduino[7], "Arduino", "MKR GSM 1400");
        subItemList.add(subItem);
        subItem = new SubItem(arduino[8], "Arduino", "MKR VIDOR 4000");
        subItemList.add(subItem);
        subItem = new SubItem(arduino[9], "Arduino", "MKR WAN 1300");
        subItemList.add(subItem);
        subItem = new SubItem(arduino[10], "Arduino", "MKR WAN 1310");
        subItemList.add(subItem);
        subItem = new SubItem(arduino[11], "Arduino", "MKR Zero");
        subItemList.add(subItem);
        subItem = new SubItem(arduino[12], "Arduino", "Nano");
        subItemList.add(subItem);
        subItem = new SubItem(arduino[13], "Arduino", "Nano 33 BLE");
        subItemList.add(subItem);
        subItem = new SubItem(arduino[14], "Arduino", "Nano 33 BLE Sense");
        subItemList.add(subItem);
        subItem = new SubItem(arduino[15], "Arduino", "Nano 33 IoT");
        subItemList.add(subItem);
        subItem = new SubItem(arduino[16], "Arduino", "Nano Every");
        subItemList.add(subItem);
        subItem = new SubItem(arduino[17], "Arduino", "Nano RP2040 Connect");
        subItemList.add(subItem);
        subItem = new SubItem(arduino[18], "Arduino", "Portenta Breakout");
        subItemList.add(subItem);
        subItem = new SubItem(arduino[19], "Arduino", "Portenta H7");
        subItemList.add(subItem);
        subItem = new SubItem(arduino[20], "Arduino", "Uno Rev 3");
        subItemList.add(subItem);
        subItem = new SubItem(arduino[21], "Arduino", "Uno Rev3 SMD");
        subItemList.add(subItem);
        subItem = new SubItem(arduino[22], "Arduino", "Uno WiFi Rev 2");
        subItemList.add(subItem);
        subItem = new SubItem(arduino[23], "Arduino", "Portenta Vision Shield with Ethernet");
        subItemList.add(subItem);
        subItem = new SubItem(arduino[24], "Arduino", "Portenta Vision Shield with LoRa");
        subItemList.add(subItem);
        subItem = new SubItem(arduino[25], "Arduino", "Yun Rev 2");
        subItemList.add(subItem);
        subItem = new SubItem(arduino[26], "Arduino", "Zero");
        subItemList.add(subItem);

        return subItemList;
    }

    int[] imgArduino = {
            R.drawable.img_arduino_pinout_due,
            R.drawable.img_arduino_pinout_edge_control,
            R.drawable.img_arduino_pinout_leonardo,
            R.drawable.img_arduino_pinout_mega_2560_r3,
            R.drawable.img_arduino_pinout_micro,
            R.drawable.img_arduino_pinout_mkr1000,
            R.drawable.img_arduino_pinout_mkr_nb1500,
            R.drawable.img_arduino_pinout_mkr_sgm1400,
            R.drawable.img_arduino_pinout_mkr_vidor4000,
            R.drawable.img_arduino_pinout_mkr_wan1300,
            R.drawable.img_arduino_pinout_mkr_wan1310,
            R.drawable.img_arduino_pinout_mkr_zero,
            R.drawable.img_arduino_pinout_nano,
            R.drawable.img_arduino_pinout_nano_33_ble,
            R.drawable.img_arduino_pinout_nano_33_ble_sense,
            R.drawable.img_arduino_pinout_nano_33_iot,
            R.drawable.img_arduino_pinout_nano_every,
            R.drawable.img_arduino_pinout_nano_rp2040,
            R.drawable.img_arduino_pinout_portenta_breakout,
            R.drawable.img_arduino_pinout_portenta_h7,
            R.drawable.img_arduino_pinout_uno_rev3,
            R.drawable.img_arduino_pinout_uno_rev3_smd,
            R.drawable.img_arduino_pinout_uno_wifi_rev2,
            R.drawable.img_arduino_pinout_vision_shield_ethernet,
            R.drawable.img_arduino_pinout_vision_shield_lora,
            R.drawable.img_arduino_pinout_yun_rev2,
            R.drawable.img_arduino_pinout_zero
    };

    @Override
    public void OnSubItemClick(int position) {
        Intent intent = new Intent(this, ImgView.class);
        Toast.makeText(getApplicationContext(), R.string.item_loading, Toast.LENGTH_SHORT).show();
        intent.putExtra("Img",imgArduino[position]);
        startActivity(intent);
    }

}