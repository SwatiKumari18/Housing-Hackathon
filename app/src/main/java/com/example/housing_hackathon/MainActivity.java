package com.example.housing_hackathon;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_bar); //getting the BottomNavigationView
        bottomNavigationView.setSelectedItemId(R.id.nav_welcome);

        //Changing the View upon selection
        bottomNavigationView.setOnItemSelectedListener(item -> {
            int selected_id = item.getItemId();

            //if-else case to identify which icon has been selected
            if (selected_id == R.id.nav_welcome) {
                return true;
            } else if (selected_id == R.id.nav_about) {
                startActivity(new Intent(getApplicationContext(), AboutActivity.class));
                finish();
                return true;
            } else if (selected_id == R.id.nav_registration_form) {
                startActivity(new Intent(getApplicationContext(), FirstRegistrationActivity.class));
                finish();
                return true;
            } else if (selected_id == R.id.nav_feedback) {
                startActivity(new Intent(getApplicationContext(), FeedbackActivity.class));
                finish();
                return true;
            } else {
                return false;
            }
        });

    }
}