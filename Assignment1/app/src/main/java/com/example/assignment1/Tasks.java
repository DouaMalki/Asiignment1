package com.example.assignment1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class Tasks extends AppCompatActivity {
    ListView listViewTopics;
    Button btn_tasks;

    String[] tasks = {"Rectangle Definition", "Rectangle Properties", "Rectangle Area and Perimeter", "Challenge"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tasks);

        listViewTopics=findViewById(R.id.lv_tasks);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, tasks);
        listViewTopics.setAdapter(adapter);

        btn_tasks =findViewById(R.id.btn_tasks);
        btn_tasks.setOnClickListener(v -> {
            Intent intent = new Intent(Tasks.this, Seen_activity.class);
            startActivity(intent);
        });
    }
}