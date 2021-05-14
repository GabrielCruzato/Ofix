package com.example.Ofix;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    TextView nome, categoria, codigo, status, valorVenda;

    String data1, data2, data3, data4, data5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        nome = findViewById(R.id.nome);
        categoria = findViewById(R.id.categoria);
        codigo = findViewById(R.id.codigo);
        status = findViewById(R.id.status);
        valorVenda = findViewById(R.id.valorVenda);

        getData();
        setData();

    }

    private void getData(){
        if(getIntent().hasExtra("s1") && getIntent().hasExtra("s2")  && getIntent().hasExtra("s3") && getIntent().hasExtra("s4") && getIntent().hasExtra("s5")) {

            data1 = getIntent().getStringExtra("s1");
            data2 = getIntent().getStringExtra("s2");
            data3 = getIntent().getStringExtra("s3");
            data4 = getIntent().getStringExtra("s4");
            data5 = getIntent().getStringExtra("s5");

        }else{
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }
    }

    private void setData(){
        nome.setText(data1);
        codigo.setText(data2);
        categoria.setText(data3);
        valorVenda.setText(data4);
        status.setText(data5);
    }

}