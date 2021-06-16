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

public class PriceAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> implements Filterable {

    String data, valorCusto, valotVenda, lucro;
    Context context;

    public PriceAdapter(Context context, String data, String valorCusto, String valorVenda, String lucro){

        this.context = context;
        this.data = data;
        this.valorCusto = valorCusto;
        this.valotVenda = valorVenda;
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

        TextView dataT, valorCustoT, lucroT, valorVendaT;
        CardView priceLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            dataT = itemView.findViewById(R.id.dataT);
            valorCustoT = itemView.findViewById(R.id.valorCustoT);
            lucroT = itemView.findViewById(R.id.lucroT);
            valorVendaT = itemView.findViewById(R.id.valorVendaT);
            priceLayout = itemView.findViewById(R.id.priceLayout);
        }    }
}
