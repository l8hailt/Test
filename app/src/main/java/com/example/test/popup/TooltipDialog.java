package com.example.test.popup;

import android.content.Context;
import android.graphics.Color;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test.R;
import com.michael.easydialog.EasyDialog;

import java.util.List;

public class TooltipDialog extends EasyDialog {

    public TooltipDialog(@NonNull Context context, View attachView, List<TooltipOption> options) {
        super(context);

//        int[] screenPosition = new int[2];
//        attachView.getLocationOnScreen(screenPosition);
//
//        screenPosition[0] += attachView.getWidth();
//        screenPosition[1] += attachView.getHeight();

        this
                .setLocationByAttachedView(attachView)
                .setGravity(EasyDialog.GRAVITY_BOTTOM)
                .setBackgroundColor(Color.WHITE)
                .setTouchOutsideDismiss(true)
                .setMarginLeftAndRight((int) (attachView.getLeft() - convertDpToPixel(22f, context)), 32)
                .setMatchParent(true);
        this.getTipViewInstance().findViewById(R.id.llContent).setBackgroundResource(0);
        this.getTipViewInstance().findViewById(R.id.ivTriangle).setVisibility(View.GONE);
        View dialogLayout = getLayoutSharePopup(context, options);
        this.setLayout(dialogLayout);
    }

    private View getLayoutSharePopup(Context context, List<TooltipOption> options) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View dialogLayout = inflater.inflate(R.layout.dialog_tooltip, null);

        dialogLayout.findViewById(R.id.img_arrow).setOnClickListener(view -> dismiss());
        RecyclerView rvSortType = dialogLayout.findViewById(R.id.rv_option);
        TooltipAdapter tooltipAdapter = new TooltipAdapter(context, options, new TooltipAdapter.OnTooltipClick() {
            @Override
            public void onClick(String type) {
//                if (!LifeBoxDownloadFragment.sortType.equals(type)) {
//                    LifeBoxDownloadFragment.sortType = type;
//                    for (SortType item : listDisplay) {
//                        item.setCheck(LifeBoxDownloadFragment.sortType.equals(item.getType()));
//                    }
//                    adapterType.notifyDataSetChanged();
//                    itemClickListener.onChooseType(type);
//                }
                dismiss();
            }
        });
        rvSortType.setAdapter(tooltipAdapter);
        return dialogLayout;
    }

    public float convertDpToPixel(float dp, Context context){
        return dp * ((float) context.getResources().getDisplayMetrics().densityDpi / DisplayMetrics.DENSITY_DEFAULT);
    }
}
