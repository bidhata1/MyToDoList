package com.example.mytodolist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {
    private EditText etUsername, etFullName, etPassword, etEmail;
    private Button btnSignup;
    private String username, fullname, email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        btnSignup = findViewById(R.id.btnSignup);
        etUsername = findViewById(R.id.etUsername);
        etFullName = findViewById(R.id.etFullName);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);


        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(SignupActivity.this,"signup click vyo", Toast.LENGTH_LONG).show();
                if (validate()) {
                    Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(SignupActivity.this, "please enter valid data", Toast.LENGTH_LONG).show();
                }
            }
        });
        setAppBar();
    }

    //set back button
    private void setAppBar() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
        }
    }


    private boolean validate() {
        username = etUsername.getText().toString();
        fullname = etFullName.getText().toString();
        email = etEmail.getText().toString();
        password = etPassword.getText().toString();

        if (username.isEmpty()) {
            etUsername.setError("Username is not set");
            return false;
        }
        if (fullname.isEmpty()) {
            etFullName.setError("Invalid fullname");
            return false;
        }
        if (email.isEmpty()) {
            etEmail.setError("Invalid email");

            return false;
        }
        if (password.isEmpty()) {
            etPassword.setError("Invalid password");
            return false;
        }
        return true;
    }
//app bar ma vako menu item /button or function clicked garda k hunxa?

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}