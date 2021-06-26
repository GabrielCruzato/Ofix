package com.example.Ofix;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

public class SavedData extends AppCompatActivity {

    EditText data, valorCusto, lucro;
    Button salvarButton;
    TextView valorVenda;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.price_layout);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        data = (EditText)findViewById(R.id.data);
        valorCusto =(EditText) findViewById(R.id.valorCusto);
        lucro = (EditText)findViewById(R.id.lucro);
        valorVenda = findViewById(R.id.valorVenda);
        salvarButton = findViewById(R.id.salvarButton);

        salvarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pricingOperations();
            }
        });
    }

    public void pricingOperations(){

        String foo = valorCusto.getText().toString();
        double custo = Integer.parseInt(foo);

        String foo2 = lucro.getText().toString();
        double lucro = Integer.parseInt(foo2);

        double profit = ((lucro/100)*custo + custo);

        String sProfit = Double.toString(profit);

        valorVenda.setText(sProfit);

    }
}
