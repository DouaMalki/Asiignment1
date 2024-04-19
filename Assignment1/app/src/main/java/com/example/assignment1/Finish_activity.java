package com.example.rectangles;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Finish_activity extends AppCompatActivity {

    Button btn_back_home;
    Button btn_exit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finish_layout);

        btn_back_home=findViewById(R.id.btn_back_home);
        btn_exit=findViewById(R.id.btn_exit);

        btn_back_home.setOnClickListener(v->{
            Intent intent = new Intent(Finish_activity.this, Tasks.class);
            startActivity(intent);
        });
        btn_exit.setOnClickListener(v->{
            finishAffinity();
            System.exit(0);
        });
    }
}