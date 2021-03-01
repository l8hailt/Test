package com.example.test.rv_in_rv;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.test.R;

import java.util.ArrayList;
import java.util.List;

public class RvInRvActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rv_in_rv);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        List<Parent> parents = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            Parent parent = new Parent();
            if (i % 2 == 0) {
                parent.setType(1);
                parent.setTitle("Header " + i);
            } else {
                List<Child> children = new ArrayList<>();
                for (int j = 0; j < 50; j++) {
                    Child child = new Child();
                    child.setTitle("Child " + j + " of " + i);
                    children.add(child);
                }
                parent.setType(2);
                parent.setChildren(children);
            }
            parents.add(parent);
        }

        RecyclerView.RecycledViewPool viewPool = recyclerView.getRecycledViewPool();
        viewPool.setMaxRecycledViews(2, 30);
        ParentAdapter parentAdapter = new ParentAdapter(parents, viewPool);
        recyclerView.setAdapter(parentAdapter);

    }
}