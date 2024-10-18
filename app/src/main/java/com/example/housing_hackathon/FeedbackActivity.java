package com.example.housing_hackathon;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class FeedbackActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_feedback);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_bar); //getting the BottomNavigationView
        bottomNavigationView.setSelectedItemId(R.id.nav_feedback);

        //Changing the View upon selection
        bottomNavigationView.setOnItemSelectedListener(item -> {
            int selected_id = item.getItemId();

            //if-else case to identify which icon has been selected
            if (selected_id == R.id.nav_welcome)
            {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
                return true;
            }
            else if (selected_id == R.id.nav_about)
            {
                startActivity(new Intent(getApplicationContext(), AboutActivity.class));
                finish();
                return true;
            }
            else if (selected_id == R.id.nav_registration_form)
            {
                startActivity(new Intent(getApplicationContext(), FirstRegistrationActivity.class));
                finish();
                return true;
            }
            else if (selected_id == R.id.nav_feedback)
            {
                return true;
            }
            else
            {
                return false;
            }
        });

    }

    //Logic For the Submit Button
    public void submitFeedback(View view) {
        EditText feedback = findViewById(R.id.input_feedback);
        String str = feedback.getText() + "";
        if (!str.isEmpty())
        {
            feedback.getText().clear();
            Toast.makeText(this, R.string.toast_message, Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(this, R.string.no_feedback, Toast.LENGTH_LONG).show();
        }
    }
}