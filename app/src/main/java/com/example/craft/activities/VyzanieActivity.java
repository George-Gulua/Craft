package com.example.craft.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.craft.R;
import com.example.craft.mvvm.views.AppActivity;

public class VyzanieActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vyzanie);
    }

    public void goBron(View view) {
        startActivity(new Intent(this, BronActivity.class));
    }

    public void backDescription(View view) {
        startActivity(new Intent(this, AppActivity.class));
    }
}