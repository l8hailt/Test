package com.example.test;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.LinearLayout;
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
        if (model.getTestField() > 2) {
            holder.startAnim();
        } else {
            holder.cancelAnim();
        }

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
        private LinearLayout layoutContainer;
        private TextView tvValue;
        private Button btnPlus, btnMinus;

        private ObjectAnimator anim;

        public TestHolder(@NonNull View itemView) {
            super(itemView);

            layoutContainer = itemView.findViewById(R.id.layoutContainer);
            tvValue = itemView.findViewById(R.id.tvValue);
            btnPlus = itemView.findViewById(R.id.btnPlus);
            btnMinus = itemView.findViewById(R.id.btnMinus);

            anim = ObjectAnimator.ofInt(layoutContainer, "backgroundColor", Color.WHITE, Color.RED,
                Color.WHITE);
            anim.setDuration(1500);
            anim.setEvaluator(new ArgbEvaluator());
            anim.setRepeatMode(ValueAnimator.REVERSE);
            anim.setRepeatCount(ValueAnimator.INFINITE);
            anim.setInterpolator(new LinearInterpolator());
        }

        void startAnim() {
            anim.start();
        }

        void cancelAnim() {
            layoutContainer.setBackgroundColor(Color.WHITE);
            anim.cancel();
        }

    }
}
