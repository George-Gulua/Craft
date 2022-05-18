package com.example.craft.mvvm.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.craft.R;
import com.example.craft.activities.BronActivity;
import com.example.craft.activities.SettingsActivity;
import com.example.craft.mvvm.viewModel.CreateViewModel;

public class RegistrationActivity extends AppCompatActivity {

    EditText registerName;
    EditText registerLogin;
    EditText registerPassword;
    Button createAccountButton;

    CreateViewModel createVM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        registerName = (EditText) findViewById(R.id.editTextTextName);
        registerLogin = (EditText) findViewById(R.id.editTextTextEmailAddress2);
        registerPassword = (EditText) findViewById(R.id.editTextTextPassword);
        createAccountButton = (Button) findViewById(R.id.button_registration);

        createVM = new ViewModelProvider(this).get(CreateViewModel.class);

        createVM.getName().observe(this, name -> {
            registerName.setText(name);
        });

        createVM.getLogin().observe(this, login -> {
            registerLogin.setText(login);
        });

        createVM.getPassword().observe(this, password -> {
            registerPassword.setText(password);
        });

        createVM.getHaveAccount().observe(this, haveAccount -> {
            if (!haveAccount) {
                Intent intent = new Intent(this, AppActivity.class);
                intent.putExtra("nameProfile", createVM.getNewCreateUserNickname());
                intent.putExtra("loginProfile", createVM.getNewCreateUserLogin());
                startActivity(intent);

                Toast.makeText(this, "Аккаунт создан", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Введите другие данные, эти заняты :(", Toast.LENGTH_LONG).show();
            }
        });

        createAccountButton.setOnClickListener(view -> {
            String name = registerName.getText().toString();
            String login = registerLogin.getText().toString();
            String password = registerPassword.getText().toString();
            createVM.creationAccount(name, login, password);
        });



    }

    @Override
    protected void onStop() {
        super.onStop();
        registerName.setText("");
        registerLogin.setText("");
        registerPassword.setText("");
    }
}