package com.example.craft.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.craft.R;
import com.example.craft.mvvm.views.AppActivity;

public class LyFinalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ly_final);
    }
    public void backFinal(View view) {
        startActivity(new Intent(this, AppActivity.class));
    }
}