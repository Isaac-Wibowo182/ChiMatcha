package com.example.chimatcha;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class RegisterActivity
        extends AppCompatActivity {

    EditText etName,
            etEmail,
            etPassword,
            etConfirmPassword;

    Button btnRegister;
    TextView txtLogin;

    @Override
    protected void onCreate(
            Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(
                R.layout.activity_register);

        initViews();

        txtLogin.setOnClickListener(v -> {

            startActivity(
                    new Intent(
                            this,
                            LoginActivity.class));

            finish();
        });

        btnRegister.setOnClickListener(v -> {

            validateRegister();
        });
    }

    private void initViews(){

        etName =
                findViewById(R.id.etEnterUsername);

        etEmail =
                findViewById(R.id.etEnterEmail);

        etPassword =
                findViewById(R.id.etPassword);

        etConfirmPassword =
                findViewById(
                        R.id.etConfirmPassword);

        btnRegister =
                findViewById(
                        R.id.btnRegister);

        txtLogin =
                findViewById(
                        R.id.tvLogin);
    }

    private void validateRegister(){

        String name =
                etName.getText()
                        .toString().trim();

        String email =
                etEmail.getText()
                        .toString().trim();

        String password =
                etPassword.getText()
                        .toString().trim();

        String confirm =
                etConfirmPassword
                        .getText()
                        .toString().trim();

        if(name.isEmpty()
                || email.isEmpty()
                || password.isEmpty()
                || confirm.isEmpty()){

            showError(
                    "All fields must be filled.");
            return;
        }

        if(!Patterns.EMAIL_ADDRESS
                .matcher(email)
                .matches()){

            showError(
                    "Email format is invalid.");
            return;
        }

        if(password.length() < 6){

            showError(
                    "Password minimum 6 characters.");
            return;
        }

        if(!password.equals(confirm)){

            showError(
                    "Password does not match.");
            return;
        }

        new MaterialAlertDialogBuilder(this)
                .setTitle(
                        "Registration Success")
                .setMessage(
                        "Your account has been created.")
                .setPositiveButton(
                        "Login",
                        (dialog, which) -> {

                            Intent intent =
                                    new Intent(
                                            this,
                                            LoginActivity.class);

                            startActivity(intent);
                            finish();
                        })
                .show();
    }

    private void showError(
            String message){

        new MaterialAlertDialogBuilder(this)
                .setTitle("Error")
                .setMessage(message)
                .setPositiveButton(
                        "OK",
                        null)
                .show();
    }
}