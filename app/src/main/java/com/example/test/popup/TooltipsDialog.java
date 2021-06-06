package com.example.test.popup;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test.R;
import com.michael.easydialog.EasyDialog;

import java.util.List;

public class TooltipsDialog extends EasyDialog {

    public static final int TRIANGLE_LEFT = 0;
    public static final int TRIANGLE_RIGHT = 1;

    private int trianglePosition = TRIANGLE_LEFT;

    private String defaultType;

    private TooltipsAdapter adapter;
    private OnOptionClick listener;

    public TooltipsDialog(@NonNull Context context, Builder builder) {
        super(context);
        this.defaultType = builder.defaultType;
        this.listener = builder.listener;
        this
                .setLocationByAttachedView(builder.attachedView)
                .setGravity(EasyDialog.GRAVITY_BOTTOM)
                .setTouchOutsideDismiss(true)
                .setMarginLeftAndRight(builder.attachedView.getLeft() - (int) convertDpToPixel(22f, context), 32)
                .setMatchParent(true);
        this.getTipViewInstance().findViewById(R.id.llContent).setBackgroundResource(0);
        this.getTipViewInstance().findViewById(R.id.ivTriangle).setVisibility(View.GONE);
        View dialogLayout = getLayoutSharePopup(context, builder.options);
        this.setLayout(dialogLayout);
    }

    private View getLayoutSharePopup(Context context, List<TooltipsOption> options) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View dialog = inflater.inflate(R.layout.dialog_tooltip, null);

        dialog.findViewById(R.id.img_arrow).setOnClickListener(view -> dismiss());
        RecyclerView rvOption = dialog.findViewById(R.id.rv_option);
        adapter = new TooltipsAdapter(context, options, new OnOptionClick() {
            @Override
            public void onClick(String type) {
                if (!defaultType.equals(type)) {
                    defaultType = type;
                    for (TooltipsOption option : options) {
                        option.setChecked(defaultType.equals(option.getType()));
                    }
                    adapter.notifyDataSetChanged();
                    if (listener != null) {
                        listener.onClick(type);
                    }
                }
                dismiss();
            }
        });
        rvOption.setAdapter(adapter);
        return dialog;
    }

    public float convertDpToPixel(float dp, Context context) {
        return dp * ((float) context.getResources().getDisplayMetrics().densityDpi / DisplayMetrics.DENSITY_DEFAULT);
    }

    static class Builder {

        private List<TooltipsOption> options;
        private View attachedView;
        private String defaultType;
        private int trianglePosition;
        private OnOptionClick listener;

        public Builder trianglePosition(int position) {
            this.trianglePosition = position;
            return this;
        }

        public Builder options(List<TooltipsOption> options) {
            this.options = options;
            return this;
        }

        public Builder attachedView(View attachedView) {
            this.attachedView = attachedView;
            return this;
        }

        public Builder defaultType(String defaultType) {
            this.defaultType = defaultType;
            return this;
        }

        public Builder listener(OnOptionClick listener) {
            this.listener = listener;
            return this;
        }

        public TooltipsDialog build(Context context) {
            return new TooltipsDialog(context, this);
        }

    }
}
