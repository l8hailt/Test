package com.example.test.popup;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TooltipAdapter extends RecyclerView.Adapter<TooltipAdapter.TooltipHolder> {

    private Context context;
    private List<TooltipOption> options;
    private OnTooltipClick listener;

    public TooltipAdapter(Context context, List<TooltipOption> options, OnTooltipClick listener) {
        this.context = context;
        this.options = options;
        this.listener = listener;
    }

    @NonNull
    @Override
    public TooltipHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_tooltip, viewGroup, false);
        return new TooltipHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TooltipHolder holder, int position) {
        TooltipOption option = options.get(position);
        holder.bind(option);
    }

    @Override
    public int getItemCount() {
        return options == null ? 0 : options.size();
    }

    public class TooltipHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.img_icon)
        AppCompatImageView ivCheck;
        @BindView(R.id.tv_display_name)
        TextView tvDisplayName;

        public TooltipHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(TooltipOption tooltipOption) {
            if (tooltipOption.isChecked()) {
//                ivCheck.setImageResource(R.drawable.ic_clock_uu_dai);
//                tvName.setTextColor(ContextCompat.getColor(context, R.color.default_color_app));
                tvDisplayName.setTextColor(Color.BLACK);
            } else {
//                ivCheck.setImageResource(R.drawable.ic_clock_gray);
//                tvName.setTextColor(ContextCompat.getColor(context, R.color.color_B5B4B4));
                tvDisplayName.setTextColor(Color.RED);
            }
            tvDisplayName.setText(tooltipOption.getDisplayName());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClick(tooltipOption.getType());
                }
            });
        }
    }

    public interface OnTooltipClick {
        void onClick(String type);
    }
}