package com.example.test;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

class TestAdapter extends RecyclerView.Adapter<TestAdapter.TestHolder> {

    private List<TestModel> data;
//    private TestListener listener;

    public TestAdapter(List<TestModel> data, TestListener listener) {
        this.data = data;
//        this.listener = listener;
    }

    @NonNull
    @Override
    public TestHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_test, parent, false);
        return new TestHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final TestHolder holder, int position) {
        final TestModel model = data.get(position);
        holder.tvValue.setText(model.getTestField() + "");

        holder.btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                listener.onClick(1);
                model.setTestField(model.getTestField() + 1);
                holder.tvValue.setText(model.getTestField() + "");
            }
        });

        holder.btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                listener.onClick(-1);
                model.setTestField(model.getTestField() - 1);
                holder.tvValue.setText(model.getTestField() + "");
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class TestHolder extends RecyclerView.ViewHolder {
        private TextView tvValue;
        private Button btnPlus, btnMinus;

        public TestHolder(@NonNull View itemView) {
            super(itemView);

            tvValue = itemView.findViewById(R.id.tvValue);
            btnPlus = itemView.findViewById(R.id.btnPlus);
            btnMinus = itemView.findViewById(R.id.btnMinus);
        }
    }
}
