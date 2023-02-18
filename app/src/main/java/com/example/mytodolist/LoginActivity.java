package com.example.mytodolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.widget.Button;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class LoginActivity extends AppCompatActivity {
    private Button btnLogin, btnSignup;
    private EditText etUsername, etPassword;
    private String username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validation()) {
                    Intent intent = new Intent(
                            LoginActivity.this, HomeActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(LoginActivity.this, "please enter valid data", Toast.LENGTH_LONG).show();
                }
            }
        });
        btnSignup = findViewById(R.id.btnSignup);
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });
    }

    private boolean validation() {
        username = etUsername.getText().toString();
        password = etPassword.getText().toString();
        if (username.isEmpty()) {
            etUsername.setError("Invalid Username");
            return false;
        }
        if (password.isEmpty()) {
            etPassword.setError("Invalid Password");
            return false;
        }
        return true;
    }
}