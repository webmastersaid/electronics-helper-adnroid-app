package com.example.electronicshelper.ui.guide.circuit_symbol;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.SearchView;
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

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ElectronicsSymbols extends AppCompatActivity implements SubItemAdapter.OnSubItemListener {

    private SubItemAdapter subItemAdapter;
    private TextView textView;

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
        subItemAdapter = new SubItemAdapter(buildSubItemList(), this);
        layoutSubItem.setAdapter(subItemAdapter);
        layoutSubItem.setLayoutManager(layoutSubItemManager);

        setUpRecyclerView();

    }

    private void setUpRecyclerView(){
        ImageView imageView = this.findViewById(R.id.img_item);
        imageView.setImageResource(R.drawable.ic_ground_symbol);
        TextView textView = this.findViewById(R.id.tv_item_title);
        textView.setText(R.string.title_activity_electronics_symbols);
    }

    private void setUpSearchView(){
        ImageView imageView = findViewById(R.id.img_item);
        imageView.setImageResource(R.drawable.ic_app_bar_search);
        textView = findViewById(R.id.tv_item_title);
        textView.setText(R.string.item_search);
    }

    int[] cSymbols = {
            R.drawable.s00001, R.drawable.s00002,
            R.drawable.s00003, R.drawable.s00004,
            R.drawable.s00005, R.drawable.s00006,
            R.drawable.s00007, R.drawable.s00008,
            R.drawable.s00009, R.drawable.s00010,
            R.drawable.s00011, R.drawable.s00013,
            R.drawable.s00014, R.drawable.s00015,
            R.drawable.s00018, R.drawable.s00020,
            R.drawable.s00019, R.drawable.s00021,
            R.drawable.s00022, R.drawable.s00023,
            R.drawable.s00024, R.drawable.s00004,
            R.drawable.s00025, R.drawable.s00026,
            R.drawable.s00027, R.drawable.s00028,
            R.drawable.s00029
    };

    @NotNull
    private List<SubItem> buildSubItemList() {

        List<SubItem> subItemList = new ArrayList<>();

        SubItem subItem;

        subItem = new SubItem(cSymbols[0], "S00001", "соединение, общий символ");
        subItemList.add(subItem);

        subItem = new SubItem(cSymbols[1], "S00002", "группа соединений (количество соединений указано)");
        subItemList.add(subItem);

        subItem = new SubItem(cSymbols[2], "S00003", "группа соединений (количество соединений указано)");
        subItemList.add(subItem);

        subItem = new SubItem(cSymbols[3], "S00004", "цепь постоянного тока");
        subItemList.add(subItem);

        subItem = new SubItem(cSymbols[4], "S00005", "трехфазная цепь");
        subItemList.add(subItem);

        subItem = new SubItem(cSymbols[5], "S00006", "гибкое соединение");
        subItemList.add(subItem);

        subItem = new SubItem(cSymbols[6], "S00007", "экранированный провод");
        subItemList.add(subItem);

        subItem = new SubItem(cSymbols[7], "S00008", "скрученное соединение");
        subItemList.add(subItem);

        subItem = new SubItem(cSymbols[8], "S00009", "проводники в кабеле");
        subItemList.add(subItem);

        subItem = new SubItem(cSymbols[9], "S00010", "проводники в кабеле");
        subItemList.add(subItem);

        subItem = new SubItem(cSymbols[10], "S00011", "коаксиальная пара");
        subItemList.add(subItem);

        subItem = new SubItem(cSymbols[11], "S00013", "коаксиальная пара с экраном");
        subItemList.add(subItem);

        subItem = new SubItem(cSymbols[12], "S00014", "конец проводника или кабеля, свободный");
        subItemList.add(subItem);

        subItem = new SubItem(cSymbols[13], "S00015", "свободный конец проводника или кабеля, со специальной изоляцией");
        subItemList.add(subItem);

        subItem = new SubItem(cSymbols[14], "S00018", "клеммная колодка");
        subItemList.add(subItem);

        subItem = new SubItem(cSymbols[15], "S00019", "Т-образное соединение");
        subItemList.add(subItem);

        subItem = new SubItem(cSymbols[16], "S00020", "Т-образное соединение");
        subItemList.add(subItem);

        subItem = new SubItem(cSymbols[17], "S00021", "двойное ответвление проводников");
        subItemList.add(subItem);

        subItem = new SubItem(cSymbols[18], "S00022", "двойное ответвление проводников");
        subItemList.add(subItem);

        subItem = new SubItem(cSymbols[19], "S00023", "ответвление");
        subItemList.add(subItem);

        subItem = new SubItem(cSymbols[20], "S00024", "перемена проводников");
        subItemList.add(subItem);

        subItem = new SubItem(cSymbols[21], "S00025", "изменение порядка чередования фаз");
        subItemList.add(subItem);

        subItem = new SubItem(cSymbols[22], "S00026", "нейтральная точка");
        subItemList.add(subItem);

        subItem = new SubItem(cSymbols[23], "S00027", "нейтральная точка генератора (однолинейное представление)");
        subItemList.add(subItem);

        subItem = new SubItem(cSymbols[24], "S00028", "нейтральная точка генератора (многолинейное представление)");
        subItemList.add(subItem);

        subItem = new SubItem(cSymbols[25], "S00029", "соединение без прерывания проводника");
        subItemList.add(subItem);

        return subItemList;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_main, menu);

        MenuItem searchItem = menu.findItem(R.id.app_bar_search);
        SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setOnSearchClickListener(view -> setUpSearchView());

        searchView.setOnCloseListener(() -> {
            setUpRecyclerView();
            return false;
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                subItemAdapter.getFilter().filter(s);
                if (subItemAdapter.getItemCount() <= 0){
                    textView.setText(R.string.item_not_found);
                } else {
                    textView.setText(R.string.item_search);
                }
                return false;
            }
        });
        return true;
    }

    @Override
    public void OnSubItemClick(int position) {
        Toast.makeText(this, "Электронная схема", Toast.LENGTH_SHORT).show();
    }
}
