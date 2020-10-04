package com.example.test;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class TestFragment extends Fragment {

    public static TestFragment getInstance() {
        TestFragment fragment = new TestFragment();
        return fragment;
    }

    public TestFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_test, container, false);
    }

    private TestDialog testDialog;
    private List<TestModel> data;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final TextView tvValue = view.findViewById(R.id.tvValue);

        data = new ArrayList<>();
        data.add(new TestModel(0));
        data.add(new TestModel(0));
        data.add(new TestModel(0));

        view.findViewById(R.id.btnTest).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (testDialog == null) {
                    testDialog = TestDialog.getInstance(getContext(), data);
                    testDialog.setCancelable(false);
                }

                testDialog.setCallback(new TestCallback() {
                    @Override
                    public void onOkDialog() {
                        StringBuilder text = new StringBuilder();
                        for (TestModel model : data) {
                            text.append(model.getTestField()).append("\n");
                        }
                        tvValue.setText(text);
                    }

                    @Override
                    public void onCancelDialog() {
                        StringBuilder text = new StringBuilder();
                        for (TestModel model : data) {
                            text.append(model.getTestField()).append("\n");
                        }
                        tvValue.setText(text);
                    }
                });
                testDialog.show();

            }
        });

    }
}
