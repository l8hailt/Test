package com.example.test.upload_file_android_q;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test.R;
import com.example.test.reference.TestAdapter;
import com.example.test.reference.TestModel;

import java.util.ArrayList;
import java.util.List;

public class NewStyleFragment extends Fragment {

    public NewStyleFragment() {
        super(R.layout.fragment_news_style);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);

        List<TestModel> models = new ArrayList<>();
        models.add(new TestModel(0));
        models.add(new TestModel(3));
        models.add(new TestModel(0));
        models.add(new TestModel(0));
        models.add(new TestModel(0));
        models.add(new TestModel(5));
        models.add(new TestModel(0));
        models.add(new TestModel(0));
        models.add(new TestModel(0));
        models.add(new TestModel(5));
        models.add(new TestModel(0));
        models.add(new TestModel(0));
        models.add(new TestModel(0));
        models.add(new TestModel(5));
        models.add(new TestModel(0));
        models.add(new TestModel(0));
        models.add(new TestModel(0));
        models.add(new TestModel(5));
        models.add(new TestModel(0));
        models.add(new TestModel(0));
        models.add(new TestModel(0));
        models.add(new TestModel(5));
        models.add(new TestModel(0));
        models.add(new TestModel(0));
        models.add(new TestModel(0));
        models.add(new TestModel(0));
        models.add(new TestModel(0));
        models.add(new TestModel(7));
        models.add(new TestModel(0));
        models.add(new TestModel(3));
        TestAdapter adapter = new TestAdapter(models, null);
        recyclerView.setAdapter(adapter);
    }
}
