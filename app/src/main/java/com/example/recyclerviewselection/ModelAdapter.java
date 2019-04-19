package com.example.recyclerviewselection;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.selection.SelectionTracker;
import androidx.recyclerview.widget.RecyclerView;

public class ModelAdapter extends RecyclerView.Adapter<ViewHolder> {

    List<Model> mList;
    Context context;
    SelectionTracker<Long> tracker;

    public ModelAdapter(List<Model> mList, Context context) {
        this.mList = mList;
        this.context = context;
        setHasStableIds(true);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.row_item , parent , false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.nameTV.setText(mList.get(position).getName());

        holder.phoneTV.setText(mList.get(position).getPhone());

        if (tracker != null) {

            //if item is selected , change the color of views
            if (tracker.isSelected((long)position)) {
                holder.nameTV.setTextColor(Color.RED);
                holder.phoneTV.setTextColor(Color.RED);
                holder.container.setBackgroundColor(Color.LTGRAY);
            }
            //if item is not selected or deselected change color to default
            else {
                holder.nameTV.setTextColor(Color.BLACK);
                holder.phoneTV.setTextColor(Color.BLACK);
                holder.container.setBackgroundColor(Color.WHITE);
            }
        }

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    //Dont forget this part!
    @Override
    public long getItemId(int position) {
        return (long)position;
    }

    public void setTracker(SelectionTracker<Long> tracker) {
        this.tracker = tracker;
    }

}
