package com.example.Ofix;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PriceAdapter extends RecyclerView.Adapter<PriceAdapter.MyViewHolder> implements Filterable {

    List<String> data;
    List<String> custo;
    List<String> lucro;
    List<String> venda;
    Context context;

    public PriceAdapter(Context context, List<String> venda, List<String> custo, List<String> lucro, List<String> data){

        this.context = context;
        this.venda = venda;
        this.custo = custo;
        this.lucro = lucro;
        this.data = data;
    }

    @Override
    public Filter getFilter() {
        return null;
    }

    @NonNull
    @Override
    public PriceAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view =  inflater.inflate(R.layout.data_row, parent, false);
        return new PriceAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.dataCardView.setText(data.get(position));
        holder.custoCardTextView.setText(custo.get(position));
        holder.lucroCardTextView.setText(lucro.get(position));
        holder.vendaCardView.setText(venda.get(position));
    }

    @Override
    public int getItemCount() {
        return custo.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView vendaCardView, custoCardTextView, lucroCardTextView, dataCardView;
        CardView dataLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            vendaCardView = itemView.findViewById(R.id.vendaCardTextView);
            lucroCardTextView = itemView.findViewById(R.id.lucroCardTextView);
            custoCardTextView = itemView.findViewById(R.id.custoCardTextView);
            dataCardView = itemView.findViewById(R.id.dataCardView);
            dataLayout = itemView.findViewById(R.id.dataLayout);
        }    }
}
