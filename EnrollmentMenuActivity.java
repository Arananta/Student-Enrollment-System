package com.example.studentenrollmentsystem;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class EnrollmentMenuActivity extends AppCompatActivity {


    CheckBox subject1, subject2, subject3, subject4, subject5, subject6, subject7, subject8, subject9, subject10;
    Button submitButton, logoutButton;
    TextView creditCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enrollment_menu);


        subject1 = findViewById(R.id.subject1);
        subject2 = findViewById(R.id.subject2);
        subject3 = findViewById(R.id.subject3);
        subject4 = findViewById(R.id.subject4);
        subject5 = findViewById(R.id.subject5);
        subject6 = findViewById(R.id.subject6);
        subject7 = findViewById(R.id.subject7);
        subject8 = findViewById(R.id.subject8);
        subject9 = findViewById(R.id.subject9);
        subject10 = findViewById(R.id.subject10);


        submitButton = findViewById(R.id.submitButton);
        logoutButton = findViewById(R.id.logoutButton);
        creditCount = findViewById(R.id.creditCount);


        logoutButton.setOnClickListener(v -> {

            SharedPreferences sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("isLoggedIn", false); // Mark as logged out
            editor.apply();

            Intent intent = new Intent(EnrollmentMenuActivity.this, LoginActivity.class);
            startActivity(intent);
            finish(); // Close the current activity
        });


        submitButton.setOnClickListener(v -> {
            int totalCredits = 0;
            StringBuilder enrolledSubjects = new StringBuilder();


            if (subject1.isChecked()) {
                totalCredits += Integer.parseInt(subject1.getTag().toString());
                enrolledSubjects.append("Geography\n");
            }
            if (subject2.isChecked()) {
                totalCredits += Integer.parseInt(subject2.getTag().toString());
                enrolledSubjects.append("Physics\n");
            }
            if (subject3.isChecked()) {
                totalCredits += Integer.parseInt(subject3.getTag().toString());
                enrolledSubjects.append("Mathematics\n");
            }
            if (subject4.isChecked()) {
                totalCredits += Integer.parseInt(subject4.getTag().toString());
                enrolledSubjects.append("Literature\n");
            }
            if (subject5.isChecked()) {
                totalCredits += Integer.parseInt(subject5.getTag().toString());
                enrolledSubjects.append("Computer Science\n");
            }
            if (subject6.isChecked()) {
                totalCredits += Integer.parseInt(subject6.getTag().toString());
                enrolledSubjects.append("History\n");
            }
            if (subject7.isChecked()) {
                totalCredits += Integer.parseInt(subject7.getTag().toString());
                enrolledSubjects.append("Economics\n");
            }
            if (subject8.isChecked()) {
                totalCredits += Integer.parseInt(subject8.getTag().toString());
                enrolledSubjects.append("Geography\n");
            }
            if (subject9.isChecked()) {
                totalCredits += Integer.parseInt(subject9.getTag().toString());
                enrolledSubjects.append("Biology\n");
            }
            if (subject10.isChecked()) {
                totalCredits += Integer.parseInt(subject10.getTag().toString());
                enrolledSubjects.append("Philosophy\n");
            }


            creditCount.setText("Total Credits: " + totalCredits);


            if (totalCredits > 24) {
                Toast.makeText(EnrollmentMenuActivity.this, "Credit limit exceeded. Maximum 24 credits allowed.", Toast.LENGTH_SHORT).show();
                return; // Don't submit if credit limit is exceeded
            }


            Intent intent = new Intent(EnrollmentMenuActivity.this, SummaryActivity.class);
            intent.putExtra("subjects", enrolledSubjects.toString());
            intent.putExtra("totalCredits", totalCredits);
            startActivity(intent);
            finish();
        });
    }
}
