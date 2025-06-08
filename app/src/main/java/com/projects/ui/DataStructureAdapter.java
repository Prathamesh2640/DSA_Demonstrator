package com.projects.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.projects.R;
import java.util.ArrayList;
import java.util.List;

public class DataStructureAdapter extends RecyclerView.Adapter<DataStructureAdapter.ViewHolder> {
    private List<Integer> data = new ArrayList<>();
    private String errorMessage = null;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_data_structure, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (errorMessage != null) {
            holder.textView.setText(errorMessage);
        } else {
            holder.textView.setText(String.valueOf(data.get(position)));
        }
    }

    @Override
    public int getItemCount() {
        return errorMessage != null ? 1 : data.size();
    }

    public void setData(List<Integer> data) {
        this.data = data;
        this.errorMessage = null;
        notifyDataSetChanged();
    }

    public void setError(String error) {
        this.errorMessage = error;
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text_item);
        }
    }
}