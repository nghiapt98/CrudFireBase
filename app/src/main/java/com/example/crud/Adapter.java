package com.example.crud;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    Context context;
    ArrayList<Country> arrayList;
    public Adapter(Context context, ArrayList<Country> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new ViewHolder(v);
    };

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            Country country = arrayList.get(position);
            holder.name.setText(country.getName());
            holder.state.setText(country.getState());
            holder.country.setText(country.getCountry());
    }

    @Override
    public int getItemCount() {

        return arrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView name,state,country;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name =itemView.findViewById(R.id.tvname);
            state = itemView.findViewById(R.id.tvstate);
            country = itemView.findViewById(R.id.tvcountry);
        }
    }
}
