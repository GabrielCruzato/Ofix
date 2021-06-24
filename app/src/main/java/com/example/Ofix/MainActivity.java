package com.example.Ofix;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    List<String> s1;
    List<String> s2;
    List<String> s3;
    List<String> s4;
    List<String> s5;
    List<String> s6;
    List<String> s7;


    MyAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);


        ArrayList<String> s1 = new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.nome)));
        ArrayList<String> s2 = new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.categoria)));
        ArrayList<String> s3 = new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.codigo)));
        ArrayList<String> s4 = new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.status)));
        ArrayList<String> s5 = new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.valorVenda)));
        Collections.sort(s1);


        myAdapter = new MyAdapter(this, s1, s2,s3,s4,s5);

        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.searchmenu, menu);
        MenuItem menuItem = menu.findItem(R.id.action_search);
        androidx.appcompat.widget.SearchView searchView = (androidx.appcompat.widget.SearchView) menuItem.getActionView();

        searchView.setOnQueryTextListener(new androidx.appcompat.widget.SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                myAdapter.getFilter().filter(newText);
                return false;
            }
        });



        return super.onCreateOptionsMenu(menu);
    }

}