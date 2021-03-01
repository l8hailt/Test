package com.example.test.rv_in_rv;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test.R;

import java.util.List;

/**
 * @author ITSOL JAPAN
 * Created on 02/01/2021.
 * Copyright © 2020 YSL Solution Co., Ltd. All rights reserved.
 *
 * <p>
 **/
public class ParentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Parent> parents;
    private RecyclerView.RecycledViewPool viewPool;

    public ParentAdapter(List<Parent> parents, RecyclerView.RecycledViewPool viewPool) {
        this.parents = parents;
        this.viewPool = viewPool;
    }

    @Override
    public int getItemViewType(int position) {
        if (parents.get(position).getType() == 1) {
            return 1;
        } else if (parents.get(position).getType() == 2) {
            return 2;
        } else {
            throw new IllegalArgumentException();
        }
    }

    @NonNull
    @Override

    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 1) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_header, parent, false);
            return new HeaderHolder(v);
        } else if (viewType == 2) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_item, parent, false);
            return new ItemHolder(v);
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof HeaderHolder) {
            ((HeaderHolder) holder).bind(parents.get(position));
        } else if (holder instanceof ItemHolder) {
            ((ItemHolder) holder).bind(parents.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return parents.size();
    }

    class HeaderHolder extends RecyclerView.ViewHolder {

        private TextView tvTitle;

        public HeaderHolder(@NonNull View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.tvTitle);
        }

        void bind(Parent parent) {
            tvTitle.setText(parent.getTitle());
        }
    }

    class ItemHolder extends RecyclerView.ViewHolder {

        private RecyclerView rvItem;
        private ChildAdapter childAdapter;

        public ItemHolder(@NonNull View itemView) {
            super(itemView);

            rvItem = itemView.findViewById(R.id.recyclerView);
            rvItem.setRecycledViewPool(viewPool);
            childAdapter = new ChildAdapter();
            rvItem.setAdapter(childAdapter);
        }

        void bind(Parent parent) {
            childAdapter.submitList(parent.getChildren());
        }

    }

}
