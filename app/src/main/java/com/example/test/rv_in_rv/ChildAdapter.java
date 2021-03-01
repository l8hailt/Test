package com.example.test.rv_in_rv;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ITSOL JAPAN
 * Created on 02/01/2021.
 * Copyright © 2020 YSL Solution Co., Ltd. All rights reserved.
 *
 * <p>
 **/
public class ChildAdapter extends RecyclerView.Adapter<ChildAdapter.ChildHolder> {

    private List<Child> children;

    @NonNull
    @Override

    public ChildAdapter.ChildHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_item_child, parent, false);
        return new ChildHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ChildAdapter.ChildHolder holder, int position) {
        Log.e("TAG", "onBindViewHolder: ChildAdapter " + position);
        holder.bind(children.get(position));
    }

    @Override
    public int getItemCount() {
        return children.size();
    }

    public void submitList(List<Child> children) {
        if (this.children == null) {
            this.children = new ArrayList<>();
        }
        this.children.clear();
        this.children.addAll(children);
        notifyDataSetChanged();
    }

    class ChildHolder extends RecyclerView.ViewHolder {

        private TextView tvTitle;

        public ChildHolder(@NonNull View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.tvTitle);
        }

        void bind(Child child) {
            tvTitle.setText(child.getTitle());
        }
    }
}
