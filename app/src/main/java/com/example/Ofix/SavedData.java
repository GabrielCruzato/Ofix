package com.example.Ofix;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SavedData extends AppCompatActivity {

    EditText data, valorCusto, lucro;
    Button salvarButton;
    TextView valorVenda;


    ArrayList<String> dataList = new ArrayList<String>();
    ArrayList<String> lucroList = new ArrayList<String>();
    ArrayList<String> custoList = new ArrayList<String>();
    ArrayList<String> valorVendaList = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.price_layout);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        data = findViewById(R.id.data);
        valorCusto = findViewById(R.id.valorCusto);
        lucro = findViewById(R.id.lucro);
        valorVenda = findViewById(R.id.valorVenda);
        salvarButton = findViewById(R.id.salvarButton);


        RecyclerView recyclerView;
        PriceAdapter priceAdapter;
        recyclerView = findViewById(R.id.recyclerViewPrice);


        priceAdapter = new PriceAdapter(this, valorVendaList, custoList, lucroList, dataList );

        salvarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pricingOperations();
                dataList.add(data.getText().toString());
                custoList.add(valorCusto.getText().toString());
                lucroList.add(lucro.getText().toString());
                priceAdapter.notifyDataSetChanged();
            }
        });

        recyclerView.setAdapter(priceAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void pricingOperations() {

        String foo = valorCusto.getText().toString();
        double custo = Integer.parseInt(foo);

        String foo2 = lucro.getText().toString();
        double lucro = Integer.parseInt(foo2);

        double profit = ((lucro / 100) * custo + custo);

        String sProfit = Double.toString(profit);

        valorVendaList.add("$"+ sProfit);
        valorVenda.setText(sProfit);

    }
}
