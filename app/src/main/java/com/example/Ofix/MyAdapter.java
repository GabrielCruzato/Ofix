package com.example.Ofix;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> implements Filterable {

    List<String> s1;
    List<String> s2;
    List<String> s3;
    List<String> s4;
    List<String> s5;
    List<String> dataAll;
    Context context;

    public MyAdapter(Context ct, List<String> s1,List<String> s2,List<String> s3,List<String> s4,List<String> s5){
        this.context = ct;
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        this.s4 = s4;
        this.s5 = s5;
        dataAll = new ArrayList<>(s1);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view =  inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.myText1.setText(s1.get(position));
        holder.myText2.setText(s2.get(position));
        holder.myText3.setText(s3.get(position));
        holder.myText4.setText(s4.get(position));
        holder.myText5.setText(s5.get(position));



        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Details.class);
                intent.putExtra("s1", s1.get(position));
                intent.putExtra("s2", s2.get(position));
                intent.putExtra("s3", s3.get(position));
                intent.putExtra("s4", s4.get(position));
                intent.putExtra("s5", s5.get(position));


                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return s1.size();
    }

    @Override
    public Filter getFilter() {
        return filter;
    }

    Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<String> filteredList = new ArrayList<>();

            if(constraint.toString().isEmpty()){
                filteredList.addAll(dataAll);
            } else{
                for(String tool: dataAll){
                    if(tool.toLowerCase().contains(constraint.toString().toLowerCase())){
                        filteredList.add(tool);
                    }
                }
            }

            FilterResults filterResults = new FilterResults();
            filterResults.values = filteredList;

            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults filterResults) {
            s1.clear();
            s1.addAll((Collection<? extends String>) filterResults.values);
            notifyDataSetChanged();
        }
    };

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView myText1, myText2, myText3, myText4, myText5;
        CardView mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            myText1 = itemView.findViewById(R.id.myText1);
            myText2 = itemView.findViewById(R.id.myText2);
            myText3 = itemView.findViewById(R.id.myText3);
            myText4 = itemView.findViewById(R.id.myText4);
            myText5 = itemView.findViewById(R.id.myText5);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
