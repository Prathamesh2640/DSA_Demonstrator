package com.projects.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.projects.R;
import com.projects.util.AnimationUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button arrayListButton = findViewById(R.id.button_arraylist);
        Button linkedListButton = findViewById(R.id.button_linkedlist);
        Button stackButton = findViewById(R.id.button_stack);
        Button dequeButton = findViewById(R.id.button_deque);
        Button bstButton = findViewById(R.id.button_bst);

        // Apply button animations
        AnimationUtils.applyButtonAnimation(arrayListButton);
        AnimationUtils.applyButtonAnimation(linkedListButton);
        AnimationUtils.applyButtonAnimation(stackButton);
        AnimationUtils.applyButtonAnimation(dequeButton);
        AnimationUtils.applyButtonAnimation(bstButton);

        arrayListButton.setOnClickListener(v -> startActivity(new Intent(this, ArrayListActivity.class)));
        linkedListButton.setOnClickListener(v -> startActivity(new Intent(this, LinkedListActivity.class)));
        stackButton.setOnClickListener(v -> startActivity(new Intent(this, StackActivity.class)));
        dequeButton.setOnClickListener(v -> startActivity(new Intent(this, DequeActivity.class)));
        bstButton.setOnClickListener(v -> startActivity(new Intent(this, BSTActivity.class)));
    }
}