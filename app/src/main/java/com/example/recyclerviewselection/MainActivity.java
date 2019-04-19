package com.example.recyclerviewselection;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.selection.ItemKeyProvider;
import androidx.recyclerview.selection.Selection;
import androidx.recyclerview.selection.SelectionPredicates;
import androidx.recyclerview.selection.SelectionTracker;
import androidx.recyclerview.selection.StableIdKeyProvider;
import androidx.recyclerview.selection.StorageStrategy;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.net.Uri;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ModelAdapter modelAdapter;
    List<Model> mList = new ArrayList<>();
    SelectionTracker<Long> tracker;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Generate fake data for recyclerView
        setFakeData();

        //Find Views and initialize recyclerView
        initRecycler();

        //Initialize tracker for selection
        initTracker();

    }

    private void initTracker() {
        tracker = new SelectionTracker.Builder<>("selection1"
                , recyclerView
                , new StableIdKeyProvider(recyclerView)
                , new MyItemDetailsLookup(recyclerView)
                , StorageStrategy.createLongStorage())
                .withSelectionPredicate(SelectionPredicates.<Long>createSelectAnything())
                .build();

        //set tracker to adapter
        modelAdapter.setTracker(tracker);
    }

    private void initRecycler() {

        recyclerView = findViewById(R.id.Main_RecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recyclerView.setHasFixedSize(true);

        modelAdapter = new ModelAdapter(mList , this);
        recyclerView.setAdapter(modelAdapter);
    }

    private void setFakeData() {

        mList.add(new Model("siamak" , "202-555-0166"));
        mList.add(new Model("mehran" , "202-555-0138"));
        mList.add(new Model("sam" , "202-555-0144"));
        mList.add(new Model("5hahryar" , "202-555-0198"));
        mList.add(new Model("ali" , "202-555-0153"));
        mList.add(new Model("hamed" , "202-555-0109"));
        mList.add(new Model("siavash" , "+1-202-555-0166"));
        mList.add(new Model("shahrzad" , "+1-202-555-0138"));
        mList.add(new Model("mohammad amin" , "+1-202-555-0144"));
        mList.add(new Model("amin" , "+1-202-555-0198"));
        mList.add(new Model("faeze" , "+1-202-555-0153"));
        mList.add(new Model("parsa" , "+1-202-555-0109"));
        mList.add(new Model("hanie" , "+1-202-555-0597"));
        mList.add(new Model("shervin" , "+1-202-555-0571"));
    }
}
