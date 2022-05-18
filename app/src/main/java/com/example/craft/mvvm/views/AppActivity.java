package com.example.craft.mvvm.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.craft.R;
import com.example.craft.activities.HistoryActivity;
import com.example.craft.activities.SettingsActivity;
import com.example.craft.activities.VyzanieActivity;
import com.example.craft.fragments.ChoiceFragment;
import com.example.craft.fragments.FavoutitesFragment;
import com.example.craft.fragments.ProfileFragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class AppActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    ChoiceFragment choiceFragment = new ChoiceFragment();
    FavoutitesFragment favoutitesFragment = new FavoutitesFragment();
    ProfileFragment profileFragment = new ProfileFragment();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_choice);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        getSupportFragmentManager().beginTransaction().replace(R.id.body_container, new ChoiceFragment()).commit();

        bottomNavigationView.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;
            switch (item.getItemId()) {
                case R.id.page_favourites:
                    selectedFragment = favoutitesFragment;
                    break;
                case R.id.page_choice:
                    selectedFragment = choiceFragment;
                    break;
                case R.id.page_profile:
                    selectedFragment = profileFragment;
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.body_container, selectedFragment).commit();
            return true;
        });
    }

    public void openDescription(View view) {
        startActivity(new Intent(this, VyzanieActivity.class));
    }

    public void goHistory(View view) {
        startActivity(new Intent(this, HistoryActivity.class));
    }

    public void goSettings(View view) {
        startActivity(new Intent(this, SettingsActivity.class));
    }
}