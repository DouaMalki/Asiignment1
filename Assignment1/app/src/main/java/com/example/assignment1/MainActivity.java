package com.example.assignment1;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button btn_login=findViewById(R.id.btn_login);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_login.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Tasks.class);
            startActivity(intent);
            finish();
        });
    }
}