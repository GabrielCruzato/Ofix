package com.example.Ofix;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PriceAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> implements Filterable {

    List<String> venda;
    List<String> custo;
    List<String> lucro;
    Context context;

    public PriceAdapter(Context context, ArrayList<String> venda, ArrayList<String> custo, ArrayList<String> lucro){

        this.context = context;
        this.venda = venda;
        this.custo = custo;
        this.lucro = lucro;
    }

    @Override
    public Filter getFilter() {
        return null;
    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView venda, valorCustoT, lucroT, data;
        CardView priceLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            venda = itemView.findViewById(R.id.venda);
            valorCustoT = itemView.findViewById(R.id.valorCustoT);
            lucroT = itemView.findViewById(R.id.lucroT);
            data = itemView.findViewById(R.id.data);
            priceLayout = itemView.findViewById(R.id.priceLayout);
        }    }
}
