package com.example.studentenrollmentsystem;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText emailEditText, passwordEditText;
    private Button loginButton;
    private TextView registerLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.loginButton);
        registerLink = findViewById(R.id.registerLink);


        loginButton.setOnClickListener(v -> loginUser());


        registerLink.setOnClickListener(v -> {

            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);
        });
    }

    private void loginUser() {

        String email = emailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();


        if (TextUtils.isEmpty(email)) {
            emailEditText.setError("Email is required");
            return;
        }
        if (TextUtils.isEmpty(password)) {
            passwordEditText.setError("Password is required");
            return;
        }


        SharedPreferences sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE);
        String savedEmail = sharedPreferences.getString("userEmail", null);
        String savedPassword = sharedPreferences.getString("userPassword", null);


        if (email.equals(savedEmail) && password.equals(savedPassword)) {

            Toast.makeText(this, "Login Successful!", Toast.LENGTH_SHORT).show();


            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish(); // Close LoginActivity
        } else {

            Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show();
        }
    }
}
