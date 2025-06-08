package com.projects.ui;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.projects.R;
import com.projects.data.StackDS;
import com.projects.data.StructureInterface;
import com.projects.util.AnimationUtils;
import com.projects.util.InputValidator;

public class StackActivity extends AppCompatActivity {
    private StructureInterface stack;
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
        recyclerView = findViewById(R.id.recycler_output);

        titleTextView.setText("Stack Demonstration");
        stack = new StackDS();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new DataStructureAdapter();
        recyclerView.setAdapter(adapter);

        addButton.setText("Push");
        removeButton.setText("Pop");

        addButton.setOnClickListener(v -> {
            String input = inputEditText.getText().toString();
            if (InputValidator.isValidNumber(input)) {
                stack.insert(Integer.parseInt(input));
                updateRecyclerView();
                inputEditText.setText("");
            } else {
                adapter.setError("Error: Invalid input");
            }
        });

        removeButton.setOnClickListener(v -> {
            if (!stack.display().isEmpty()) {
                stack.delete(stack.display().get(stack.display().size() - 1));
                updateRecyclerView();
            } else {
                adapter.setError("Error: Stack empty");
            }
        });
    }

    private void updateRecyclerView() {
        adapter.setData(stack.display());
        AnimationUtils.applyFadeAnimation(recyclerView);
    }
}