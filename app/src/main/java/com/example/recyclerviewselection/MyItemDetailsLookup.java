package com.example.recyclerviewselection;

import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.selection.ItemDetailsLookup;
import androidx.recyclerview.widget.RecyclerView;

public class MyItemDetailsLookup extends ItemDetailsLookup<Long> {

    private RecyclerView recyclerView;

    public MyItemDetailsLookup(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
    }

    @Nullable
    @Override
    public ItemDetails<Long> getItemDetails(@NonNull MotionEvent e) {

        View view  = recyclerView.findChildViewUnder(e.getX() , e.getY());
        if (view != null) {
            return ((ViewHolder)recyclerView.getChildViewHolder(view)).getViewHolderItemDetails();
        }
        return null;
    }

}
