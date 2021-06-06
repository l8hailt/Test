package com.example.test.popup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
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

    private TooltipsDialog tooltipDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tooltip);
        ButterKnife.bind(this);

        List<TooltipsOption> options = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            if (i == 0) {
                options.add(new TooltipsOption(i + "", i + "", true));
            } else {
                options.add(new TooltipsOption(i + "", i + "", false));
            }
        }

        llContainer.setOnClickListener(v -> {
            if (tooltipDialog == null) {
                tooltipDialog = new TooltipsDialog.Builder()
                        .attachedView(imgArrow)
                        .options(options)
                        .defaultType("0")
                        .listener(new OnOptionClick() {
                            @Override
                            public void onClick(String type) {

                            }
                        })
                        .build(this);
            }
            tooltipDialog.show();
        });

    }
}