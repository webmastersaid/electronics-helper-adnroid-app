package com.example.electronicshelper.ui.guide.smd_body;

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

public class SmdSOT extends AppCompatActivity implements SubItemAdapter.OnSubItemListener {

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
        imageView.setImageResource(R.drawable.ic_sot23_5);
        textView = this.findViewById(R.id.tv_item_title);
        textView.setText(R.string.title_activity_smd_sot);
    }

    private void setUpSearchView(){
        ImageView imageView = findViewById(R.id.img_item);
        imageView.setImageResource(R.drawable.ic_app_bar_search);
        textView = findViewById(R.id.tv_item_title);
        textView.setText(R.string.item_search);
    }

    int[] cSymbols = {
            R.drawable.ic_sot23_5
    };

    @NotNull
    private List<SubItem> buildSubItemList() {

        List<SubItem> subItemList = new ArrayList<>();

        SubItem subItem;

        subItem = new SubItem(cSymbols[0], "SOT-23, TO-236-3, SC-59", "2.9 x 1.3/1.75 x 1.3 мм 3 pin");
        subItemList.add(subItem);
        subItem = new SubItem(cSymbols[0], "SOT-89, TO-243, SC-62", "4.5 x 2.5 x 1.5 мм 4 pin");
        subItemList.add(subItem);
        subItem = new SubItem(cSymbols[0], "SOT-143", "3 x 1.4 x 1.1 мм 4 pin");
        subItemList.add(subItem);
        subItem = new SubItem(cSymbols[0], "SOT-223", "6.7 x 3.7 x 1.8 мм 4 pin");
        subItemList.add(subItem);
        subItem = new SubItem(cSymbols[0], "SOT-323, SC-70", "2 x 1.25 x 0.95 мм 3 pin");
        subItemList.add(subItem);
        subItem = new SubItem(cSymbols[0], "SOT-416, SC-75", "1.6 x 0.8 x 0.8 мм 3 pin");
        subItemList.add(subItem);
        subItem = new SubItem(cSymbols[0], "SOT-663", "1.6 x 1.6 x 0.55 мм 3 pin");
        subItemList.add(subItem);
        subItem = new SubItem(cSymbols[0], "SOT-723, VMT3, 631AA", "1.2 x 0.8 x 0.5 мм 3 pin");
        subItemList.add(subItem);
        subItem = new SubItem(cSymbols[0], "SOT-883, SC-101", "1 x 0.6 x 0.5 мм 3 pin");
        subItemList.add(subItem);
        subItem = new SubItem(cSymbols[0], "SOT-23-5, SOT-25, SC-74A", "2.9 x 1.3/1.75 x 1.3 мм 5 pin");
        subItemList.add(subItem);
        subItem = new SubItem(cSymbols[0], "SOT-23-6, SOT-26, SC-74", "2.9 x 1.3/1.75 x 1.3 мм 6 pin");
        subItemList.add(subItem);
        subItem = new SubItem(cSymbols[0], "SOT-23-8, SOT-28", "2.9 x 1.3/1.75 x 1.3 мм 8 pin");
        subItemList.add(subItem);
        subItem = new SubItem(cSymbols[0], "SOT-353, SC-88A, TSSOP5", "2 x 1.25 x 0.95 мм 5 pin");
        subItemList.add(subItem);
        subItem = new SubItem(cSymbols[0], "SOT-363, SC-88, SC-70-6, TSSOP6", "2 x 1.25 x 0.95 мм 6 pin");
        subItemList.add(subItem);
        subItem = new SubItem(cSymbols[0], "SOT-563", "1.6 x 1.2 x 0.6 мм 6 pin");
        subItemList.add(subItem);
        subItem = new SubItem(cSymbols[0], "SOT-665", "1.6 x 1.6 x 0.55 мм 5 pin");
        subItemList.add(subItem);
        subItem = new SubItem(cSymbols[0], "SOT-666", "1.6 x 1.2 x 0.55 мм 6 pin");
        subItemList.add(subItem);
        subItem = new SubItem(cSymbols[0], "SOT-886, XSON6, MO-252", "1 x 1.45 x 0.5 мм 6 pin");
        subItemList.add(subItem);
        subItem = new SubItem(cSymbols[0], "SOT-891, XSON6", "1 x 1 x 0.5 мм 5 pin");
        subItemList.add(subItem);
        subItem = new SubItem(cSymbols[0], "SOT-953", "1 x 1 x 0.5 мм 5 pin");
        subItemList.add(subItem);
        subItem = new SubItem(cSymbols[0], "SOT-963", "1 x 1 x 0.5 мм 6 pin");
        subItemList.add(subItem);
        subItem = new SubItem(cSymbols[0], "SOT-1115, XSON6", "0.9 x 1 x 0.35 мм 6 pin");
        subItemList.add(subItem);
        subItem = new SubItem(cSymbols[0], "SOT-1202, XSON6", "1 x 1 x 0.35 мм 6 pin");
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
        Toast.makeText(this, R.string.text_sot, Toast.LENGTH_SHORT).show();
    }
}