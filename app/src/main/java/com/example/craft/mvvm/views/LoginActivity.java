package com.example.craft.mvvm.views;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.craft.R;
import com.example.craft.mvvm.viewModel.LoginViewModel;
import com.example.craft.ui.MainActivity;


public class LoginActivity extends AppCompatActivity {

    EditText loginEnter;
    EditText passwordEnter;
    Button authorizeButton;

    LoginViewModel loginVM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginEnter = (EditText) findViewById(R.id.editTextTextEmailAddress);
        passwordEnter = (EditText) findViewById(R.id.editTextTextPassword);
        authorizeButton = (Button) findViewById(R.id.button);

        loginVM = new ViewModelProvider(this).get(LoginViewModel.class);

        loginVM.getLogin().observe(this, login -> {
            loginEnter.setText(login);
        });

        loginVM.getPassword().observe(this, password -> {
            passwordEnter.setText(password);
        });

        loginVM.getAccess().observe(this, access -> {
            if (access) {
                startActivity(new Intent(this, MainActivity.class));
                Toast.makeText(this, "Welcome, " + loginVM.getUserNickname() + '!', Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "This user wasn't found!", Toast.LENGTH_LONG).show();
            }
        });

        authorizeButton.setOnClickListener(view -> {
            String login = loginEnter.getText().toString();
            String password = passwordEnter.getText().toString();
            loginVM.authorize(login, password);
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        loginEnter.setText("");
        passwordEnter.setText("");
    }
}