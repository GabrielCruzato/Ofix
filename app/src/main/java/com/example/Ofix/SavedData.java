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

    EditText data, valorCusto, lucro, valorVenda;
    TextView dataT, valorCustoT, lucroT, valorVendaT;
    Button salvarButton;
    String dataStr, valorCustoStr, lucroStr, valorVendaStr;

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String DATA = "data";
    public static final String VALORCUSTO = "valorCusto";
    public static final String LUCRO = "lucro";
    public static final String VALORVENDA = "valorVenda";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.price_layout);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        data = (EditText)findViewById(R.id.data);
        valorCusto =(EditText) findViewById(R.id.valorCusto);
        lucro = (EditText)findViewById(R.id.lucro);
        valorVenda = (EditText)findViewById(R.id.valorVenda);
        salvarButton = findViewById(R.id.salvarButton);
        dataT = findViewById(R.id.venda);
        valorCustoT = findViewById(R.id.valorCustoT);
        lucroT = findViewById(R.id.lucroT);
        valorVendaT = findViewById(R.id.valorVendaT);

        RecyclerView recyclerView;
        PriceAdapter priceAdapter;
        recyclerView = findViewById(R.id.recyclerViewPrice);
        ArrayList<String> venda = new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.venda)));
        ArrayList<String> custo = new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.custo)));
        ArrayList<String> lucro = new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.lucro)));

        priceAdapter = new PriceAdapter(this,venda,custo,lucro);

        recyclerView.setAdapter(priceAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        salvarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pricingOperations();
            }
        });
    }

    public void savePrice(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(DATA,data.getText().toString());
        editor.putString(VALORCUSTO,valorCusto.getText().toString());
        editor.putString(VALORVENDA,valorVenda.getText().toString());
        editor.putString(LUCRO,lucro.getText().toString());

        editor.apply();

    }

    public void loadData(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);

        dataStr = sharedPreferences.getString(DATA,"");
        valorCustoStr = sharedPreferences.getString(VALORCUSTO,"");
        lucroStr = sharedPreferences.getString(LUCRO,"");
        valorVendaStr = sharedPreferences.getString(VALORVENDA,"");
    }

    public void updateViews(){
        dataT.setText(dataStr);
        valorCustoT.setText(valorCustoStr);
        valorVendaT.setText(valorVendaStr);
        lucroT.setText(lucroStr);
    }

    public void pricingOperations(){

        String foo = valorCusto.getText().toString();
        double custo = Integer.parseInt(foo);

        String foo2 = lucro.getText().toString();
        double lucro = Integer.parseInt(foo2);

        double profit = ((lucro/100)*custo + custo);

        valorVendaT.setText((int) profit);

    }
}
