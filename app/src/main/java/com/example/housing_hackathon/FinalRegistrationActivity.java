package com.example.housing_hackathon;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class FinalRegistrationActivity extends AppCompatActivity {

    String teamName, email, focusGroup, teamSize, member1_name, member2_name, member3_name, member4_name, member5_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_final_registration);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Keeping the Registration tab selected
        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_bar); //getting the BottomNavigationView
        bottomNavigationView.setSelectedItemId(R.id.nav_registration_form);

        //Storing all the data from Second Registration page
        Intent intent = getIntent();
        if (intent != null)
        {
            teamName = intent.getStringExtra("team_name");
            email = intent.getStringExtra("email");
            focusGroup = intent.getStringExtra("focus_group");
            teamSize = intent.getStringExtra("team_size");
            member1_name = intent.getStringExtra("member1_name");
            member2_name = intent.getStringExtra("member2_name");
            member3_name = intent.getStringExtra("member3_name");
            member4_name = intent.getStringExtra("member4_name");
            member5_name = intent.getStringExtra("member5_name");
        }

        //Showing data passed on from the Second Registration Page
        //Team Name
        TextView view_teamName = findViewById(R.id.teamNameValue);
        view_teamName.setText(teamName);
        //Registered Email
        TextView view_email = findViewById(R.id.teamEmailValue);
        view_email.setText(email);
        //Team Size
        TextView view_teamSize = findViewById(R.id.numTeamMembersValue);
        view_teamSize.setText(teamSize);
        //Team Member Name
        TextView view_teamNames = findViewById(R.id.teamMemberNamesValue);
        String allMembersName = member1_name + " " + member2_name + " " + member3_name + " " + member4_name + " " + member5_name;
        view_teamNames.setText(allMembersName);


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
}