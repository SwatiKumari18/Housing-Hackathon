package com.example.housing_hackathon;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class FirstRegistrationActivity extends AppCompatActivity {

    String focusGroup = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_first_registration);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_bar); //getting the BottomNavigationView
        bottomNavigationView.setSelectedItemId(R.id.nav_registration_form);

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
                return true;
            }
            else if (selected_id == R.id.nav_feedback)
            {
                startActivity(new Intent(getApplicationContext(), FeedbackActivity.class));
                finish();
                return true;
            }
            else
            {
                return false;
            }
        });
    }

    public void LaunchNextPage(View view) {
        EditText teamName = findViewById(R.id.team_name);
        EditText email = findViewById(R.id.email);
        RadioGroup rg = (RadioGroup) findViewById(R.id.focus_group_radio_group);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (checkedId == R.id.focus_affordable) {
                    focusGroup = "Affordable Housing";
                }
                else if (checkedId == R.id.focus_sustainability) {
                    focusGroup = "Sustainability";
                }
                else if (checkedId == R.id.focus_student_friendly) {
                    focusGroup = "Student-Friendly Housing";
                }
                else if (checkedId == R.id.focus_accessibility) {
                    focusGroup = "Accessibility";
                }
            }

        });

        Bundle bundle = new Bundle();
        bundle.putString("team_name", teamName.getText().toString().trim());
        bundle.putString("email", email.getText().toString().trim());
        bundle.putString("focus_group", focusGroup);

        Intent intent = new Intent(this, SecondRegistrationActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);

    }
}