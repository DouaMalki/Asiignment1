package com.example.rectangles;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.concurrent.atomic.AtomicInteger;

public class Seen_activity extends AppCompatActivity {

    ConstraintLayout constraintLayout;
    Button btn_next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seen_layout);

        btn_next =findViewById(R.id.btn_next);
        constraintLayout =findViewById(R.id.layout);

        LayoutInflater inflater = LayoutInflater.from(this);
        View seen=inflater.inflate(R.layout.rectangle_difinition, constraintLayout, false);;
        constraintLayout.removeAllViews();
        constraintLayout.addView(seen);

        AtomicInteger count= new AtomicInteger(1);
        btn_next.setOnClickListener(v -> {
            View seen_view;
            if(count.get() ==1)
            {
                seen_view=inflater.inflate(R.layout.rectangle_properties, constraintLayout, false);
                constraintLayout.removeAllViews();
                constraintLayout.addView(seen_view);
            }
            else if(count.get() ==2)
            {
                seen_view=inflater.inflate(R.layout.rectangle_calculations, constraintLayout, false);
                constraintLayout.removeAllViews();
                constraintLayout.addView(seen_view);
            }
            else if(count.get() ==3)
            {
                Intent intent = new Intent(Seen_activity.this, Challenge_activity.class);
                startActivity(intent);
            }
            else
            {
                Intent intent = new Intent(Seen_activity.this, Finish_activity.class);
                startActivity(intent);
            }
            count.getAndIncrement();
        });
    }
}