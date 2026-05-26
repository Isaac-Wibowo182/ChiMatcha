package com.example.chimatcha;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {

    EditText etUsername, etPassword;
    Button btnLogin;
    TextView tvSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        tvSignup = findViewById(R.id.tvSignup);

        btnLogin.setOnClickListener(v -> {

            String username =
                    etUsername.getText().toString().trim();

            String password =
                    etPassword.getText().toString().trim();

            if (username.isEmpty()) {
                etUsername.setError(
                        "Username wajib diisi");
                etUsername.requestFocus();
                return;
            }

            if (username.length() <= 6) {
                etUsername.setError(
                        "Username harus lebih dari 6 karakter");
                etUsername.requestFocus();
                return;
            }

            if (password.isEmpty()) {
                etPassword.setError(
                        "Password wajib diisi");
                etPassword.requestFocus();
                return;
            }

            Intent intent =
                    new Intent(LoginActivity.this,
                            HomeActivity.class);

            intent.putExtra("username",
                    username);

            startActivity(intent);
        });

        tvSignup.setOnClickListener(v -> {

            Intent intent =
                    new Intent(LoginActivity.this,
                            RegisterActivity.class);

            startActivity(intent);
        });
    }
}