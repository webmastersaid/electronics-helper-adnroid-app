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

public class CmdPassive extends AppCompatActivity implements SubItemAdapter.OnSubItemListener {

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
        imageView.setImageResource(R.drawable.ic_smd_kerko);
        textView = this.findViewById(R.id.tv_item_title);
        textView.setText(R.string.title_activity_smd_passive);
    }

    private void setUpSearchView(){
        ImageView imageView = findViewById(R.id.img_item);
        imageView.setImageResource(R.drawable.ic_app_bar_search);
        textView = findViewById(R.id.tv_item_title);
        textView.setText(R.string.item_search);
    }

    int[] cSymbols = {
            R.drawable.ic_smd_resistor,
            R.drawable.ic_smd_kerko
    };

    @NotNull
    private List<SubItem> buildSubItemList() {

        List<SubItem> subItemList = new ArrayList<>();

        SubItem subItem;

        subItem = new SubItem(cSymbols[0], "0201", "0.25 х 0.125 мм");
        subItemList.add(subItem);
        subItem = new SubItem(cSymbols[1], "03015", "0.3 х 0.12 мм");
        subItemList.add(subItem);
        subItem = new SubItem(cSymbols[0], "0402", "0.4 х 0.2 мм");
        subItemList.add(subItem);
        subItem = new SubItem(cSymbols[1], "0603", "0.6 х 03 мм");
        subItemList.add(subItem);
        subItem = new SubItem(cSymbols[0], "1005", "1 х 0.5 мм");
        subItemList.add(subItem);
        subItem = new SubItem(cSymbols[1], "1608", "1.6 х 08 мм");
        subItemList.add(subItem);
        subItem = new SubItem(cSymbols[0], "2012", "2 х 1.25 мм");
        subItemList.add(subItem);
        subItem = new SubItem(cSymbols[1], "2520", "2.5 х 2 мм");
        subItemList.add(subItem);
        subItem = new SubItem(cSymbols[0], "3216", "3.2 х 2.5 мм");
        subItemList.add(subItem);
        subItem = new SubItem(cSymbols[1], "3225", "3.2 х 2.5 мм");
        subItemList.add(subItem);
        subItem = new SubItem(cSymbols[0], "4516", "4.5 х 1.6 мм");
        subItemList.add(subItem);
        subItem = new SubItem(cSymbols[1], "4532", "4.5 х 3.2 мм");
        subItemList.add(subItem);
        subItem = new SubItem(cSymbols[0], "4564", "4.5 х 6.4 мм");
        subItemList.add(subItem);
        subItem = new SubItem(cSymbols[1], "5025", "5 х 2.5 мм");
        subItemList.add(subItem);
        subItem = new SubItem(cSymbols[0], "6332", "6.3 х 3.2 мм");
        subItemList.add(subItem);
        subItem = new SubItem(cSymbols[1], "7451", "7.4 х 5.1 мм");
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
        Toast.makeText(this, R.string.text_smd_passive, Toast.LENGTH_SHORT).show();
    }
}
