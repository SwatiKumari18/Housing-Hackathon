package com.example.housing_hackathon;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.SeekBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SecondRegistrationActivity extends AppCompatActivity {

    String teamName, email, focusGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second_registration);
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

        //Storing all the data from 1st registration page
        Intent intent = getIntent();
        if (intent != null)
        {
            teamName = intent.getStringExtra("team_name");
            email = intent.getStringExtra("email");
            focusGroup = intent.getStringExtra("focus_group");
        }
    }

    public void LaunchFinalPage(View view) {

        SeekBar teamSize = findViewById(R.id.team_size_seekbar);
        EditText member1Name = findViewById(R.id.member1_name);
        EditText member2Name = findViewById(R.id.member2_name);
        EditText member3Name = findViewById(R.id.member3_name);
        EditText member4Name = findViewById(R.id.member4_name);
        EditText member5Name = findViewById(R.id.member5_name);

        Bundle bundle = new Bundle();
        bundle.putString("team_name", teamName);
        bundle.putString("email", email);
        bundle.putString("focus_group", focusGroup);
        bundle.putString("team_size", String.valueOf(teamSize.getProgress()));
        bundle.putString("member1_name", member1Name.getText().toString().trim());
        bundle.putString("member2_name", member2Name.getText().toString().trim());
        bundle.putString("member3_name", member3Name.getText().toString().trim());
        bundle.putString("member4_name", member4Name.getText().toString().trim());
        bundle.putString("member5_name", member5Name.getText().toString().trim());


        Intent intent = new Intent(this, FinalRegistrationActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);

    }
}