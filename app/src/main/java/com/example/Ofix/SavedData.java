package com.example.Ofix;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

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

        data = (EditText)findViewById(R.id.data);
        valorCusto =(EditText) findViewById(R.id.valorCusto);
        lucro = (EditText)findViewById(R.id.lucro);
        valorVenda = (EditText)findViewById(R.id.valorVenda);
        salvarButton = findViewById(R.id.salvarButton);
        dataT = findViewById(R.id.dataT);
        valorCustoT = findViewById(R.id.valorCustoT);
        lucroT = findViewById(R.id.lucroT);
        valorVendaT = findViewById(R.id.valorVendaT);

        PriceAdapter priceAdapter = new PriceAdapter(this,data.getText().toString(),valorCusto.getText().toString(),valorVenda.getText().toString(),lucro.getText().toString());

        salvarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savePrice();
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
}
