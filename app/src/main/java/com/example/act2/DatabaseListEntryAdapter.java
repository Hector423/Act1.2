package com.example.act2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DatabaseListEntryAdapter extends RecyclerView.Adapter<DatabaseListEntryHolder>
{
    ArrayList<DatabaseListEntry> adapterDatabaseListEntries;

    public DatabaseListEntryAdapter()
    {
        this.adapterDatabaseListEntries = adapterDatabaseListEntries;
    }

    @Override
    public DatabaseListEntryHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_llistar_incidencies, parent, false);
        DatabaseListEntryHolder viewHolder = new DatabaseListEntryHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(DatabaseListEntryHolder holder, int position)
    {
        holder.text.setText(adapterDatabaseListEntries.get(position).toString());
//        holder.text1.setText(adapterDatabaseListEntries.get(position).toString());
    }

    @Override
    public int getItemCount()
    {
        return adapterDatabaseListEntries.size();
    }

//    @NonNull
//    @Override
//    public DatabaseListEntry onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        return null;
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull DatabaseListEntry holder, int position) {
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return 0;
//    }
}