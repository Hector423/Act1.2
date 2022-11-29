package com.example.act2;

import android.view.View;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class DatabaseListEntryHolder extends RecyclerView.ViewHolder
{
    protected CardView card_view;
    protected TextView text;

    public DatabaseListEntryHolder(View itemView)
    {
        super(itemView);
//        card_view = (CardView) itemView.findViewById(R.id.card_view);
//        text = (TextView)itemView.findViewById(R.id.tv1);
    }
}