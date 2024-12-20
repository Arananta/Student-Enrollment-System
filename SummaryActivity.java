package com.example.studentenrollmentsystem;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SummaryActivity extends AppCompatActivity {

    private TextView selectedSubjectsTextView;
    private TextView totalCreditsTextView;
    private Button finishButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);


        selectedSubjectsTextView = findViewById(R.id.selectedSubjects);
        totalCreditsTextView = findViewById(R.id.totalCredits);
        finishButton = findViewById(R.id.btnFinish);


        String subjects = getIntent().getStringExtra("subjects");
        int totalCredits = getIntent().getIntExtra("totalCredits", 0);


        selectedSubjectsTextView.setText(subjects);
        totalCreditsTextView.setText("Total Credits: " + totalCredits);


        finishButton.setOnClickListener(v -> {

            Intent intent = new Intent(SummaryActivity.this, EnrollmentMenuActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
