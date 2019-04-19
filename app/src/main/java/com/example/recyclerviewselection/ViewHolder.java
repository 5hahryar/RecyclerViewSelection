package com.example.recyclerviewselection;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.selection.ItemDetailsLookup;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {

    TextView nameTV;
    TextView phoneTV;
    LinearLayout container;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        nameTV = itemView.findViewById(R.id.row_item_name);
        phoneTV = itemView.findViewById(R.id.row_item_phone);
        container = itemView.findViewById(R.id.row_item_container);

    }

    //Selection part
    public ItemDetailsLookup.ItemDetails<Long> getViewHolderItemDetails () {

        return new ItemDetailsLookup.ItemDetails<Long>() {
            @Override
            public int getPosition() {
                return getAdapterPosition();
            }

            @Nullable
            @Override
            public Long getSelectionKey() {
                return getItemId();
            }
        };
    }

}
