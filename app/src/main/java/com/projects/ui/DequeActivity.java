package com.projects.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.projects.R;
import com.projects.data.DequeDS;
import com.projects.util.AnimationUtils;
import com.projects.util.InputValidator;

public class DequeActivity extends AppCompatActivity {
    private DequeDS deque;
    private RecyclerView recyclerView;
    private DataStructureAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_structure);

        TextView titleTextView = findViewById(R.id.text_title);
        EditText inputEditText = findViewById(R.id.edit_input);
        Button addButton = findViewById(R.id.button_add);
        Button removeButton = findViewById(R.id.button_remove);
        Button addFrontButton = findViewById(R.id.button_add_front);
        Button removeFrontButton = findViewById(R.id.button_remove_front);
        Button palindromeButton = findViewById(R.id.button_palindrome);
        recyclerView = findViewById(R.id.recycler_output);

        titleTextView.setText("Deque Demonstration");
        deque = new DequeDS();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new DataStructureAdapter();
        recyclerView.setAdapter(adapter);

        addButton.setText("Add Rear");
        removeButton.setText("Remove Rear");
        addFrontButton.setText("Add Front");
        removeFrontButton.setText("Remove Front");
        palindromeButton.setVisibility(View.VISIBLE);

        addButton.setOnClickListener(v -> {
            String input = inputEditText.getText().toString();
            if (InputValidator.isValidNumber(input)) {
                deque.insert(Integer.parseInt(input));
                updateRecyclerView();
                inputEditText.setText("");
            } else {
                adapter.setError("Error: Invalid input");
            }
        });

        removeButton.setOnClickListener(v -> {
            if (!deque.display().isEmpty()) {
                deque.delete(deque.display().get(deque.display().size() - 1));
                updateRecyclerView();
            } else {
                adapter.setError("Error: Deque empty");
            }
        });

        addFrontButton.setOnClickListener(v -> {
            String input = inputEditText.getText().toString();
            if (InputValidator.isValidNumber(input)) {
                deque.insertFront(Integer.parseInt(input));
                updateRecyclerView();
                inputEditText.setText("");
            } else {
                adapter.setError("Error: Invalid input");
            }
        });

        removeFrontButton.setOnClickListener(v -> {
            if (!deque.display().isEmpty()) {
                deque.deleteFront();
                updateRecyclerView();
            } else {
                adapter.setError("Error: Deque empty");
            }
        });

        palindromeButton.setOnClickListener(v -> {
            String input = inputEditText.getText().toString();
            if (InputValidator.isValidNumber(input)) {
                boolean isPalindrome = deque.isPalindrome(input);
                adapter.setError("Is Palindrome: " + isPalindrome);
            } else {
                adapter.setError("Error: Invalid input");
            }
        });
    }

    private void updateRecyclerView() {
        adapter.setData(deque.display());
        AnimationUtils.applyFadeAnimation(recyclerView);
    }
}