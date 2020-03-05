package com.example.bottomnavigationproject.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.bottomnavigationproject.R;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView title_detail = findViewById(R.id.title_detail);
        TextView release_date_detail = findViewById(R.id.release_date_detail);
        TextView director_detail = findViewById(R.id.director_detail);
        TextView producer_detail = findViewById(R.id.producer_detail);
        TextView rt_score_detail = findViewById(R.id.rt_score_detail);
        TextView description_detail = findViewById(R.id.description_detail);

        Intent intent = getIntent();
        title_detail.setText(intent.getExtras().getString("title"));
        release_date_detail.setText(intent.getExtras().getString("release_date"));
        director_detail.setText(intent.getExtras().getString("director"));
        producer_detail.setText(intent.getExtras().getString("producer"));
        rt_score_detail.setText(intent.getExtras().getString("rt_score"));
        description_detail.setText(intent.getExtras().getString("description"));


    }
}
