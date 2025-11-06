package com.mrbackend.recyclertoggledemo;


import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MyAdapter adapter;
    SwitchCompat switchLayout;
    TextView tvMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // find views
        recyclerView = findViewById(R.id.recyclerView);
        switchLayout = findViewById(R.id.switchLayout);
        tvMode = findViewById(R.id.tvMode);

        List<Item> items = new ArrayList<>();
        items.add(new Item("item1", "Description", R.drawable.menu));
        items.add(new Item("item2", "Description", R.drawable.menu));
        items.add(new Item("item3", "Description", R.mipmap.ic_launcher));
        items.add(new Item("item4", "Description", R.mipmap.ic_launcher));

        adapter = new MyAdapter(this, items);

        setSingleColumnLayout();

        recyclerView.setAdapter(adapter);

        switchLayout.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {

                    setTwoColumnLayout();
                    tvMode.setText("Two columns");
                } else {
                    setSingleColumnLayout();
                    tvMode.setText("Single column");
                }
            }
        });
    }

    private void setSingleColumnLayout() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
    }

    private void setTwoColumnLayout() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);
    }
}
