package com.example.test.popup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.test.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TooltipActivity extends AppCompatActivity {

    @BindView(R.id.button)
    TextView button;
    @BindView(R.id.img_arrow)
    ImageView imgArrow;
    @BindView(R.id.ll_container)
    LinearLayout llContainer;

    private TooltipDialog tooltipDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tooltip);
        ButterKnife.bind(this);

        List<TooltipOption> options = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            options.add(new TooltipOption(i + "", i + "", false));
        }

        llContainer.setOnClickListener(v -> {
            if (tooltipDialog == null) {
                tooltipDialog = new TooltipDialog(this, imgArrow, options);
            }
            tooltipDialog.show();
        });

    }
}