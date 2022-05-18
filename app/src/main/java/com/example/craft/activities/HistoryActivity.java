package com.example.craft.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.craft.R;
import com.example.craft.mvvm.views.AppActivity;

public class HistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
    }
    public void backHistory(View view) {
        startActivity(new Intent(this, AppActivity.class));
    }
}