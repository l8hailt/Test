package com.example.test.reference;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test.R;

import java.util.ArrayList;
import java.util.List;

public class TestDialog extends Dialog implements TestListener {

    private List<TestModel> data;
    private TestCallback callback;

    public void setCallback(TestCallback callback) {
        this.callback = callback;
    }

    public static TestDialog getInstance(Context context, List<TestModel> data) {
        return new TestDialog(context, data);
    }

    public TestDialog(@NonNull Context context, List<TestModel> data) {
        super(context);
        this.data = new ArrayList<>(data);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_test);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        Button btnOk = findViewById(R.id.btnOK);
        Button btnCancel = findViewById(R.id.btnCancel);

        TestAdapter adapter = new TestAdapter(data, this);
        recyclerView.setAdapter(adapter);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callback.onOkDialog();
                dismiss();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callback.onCancelDialog();
                dismiss();
            }
        });

    }

    @Override
    public void onClick(int valueChange) {

    }
}
