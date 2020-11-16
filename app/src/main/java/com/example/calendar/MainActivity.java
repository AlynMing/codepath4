package com.example.calendar;      //if red change to codepath4

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.CalendarView;
import android.widget.TextView;

import com.example.calendar.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CalendarView calendarView = findViewById(R.id.calendarView);
        final TextView selectedDay = findViewById(R.id.selectedDay);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
//       final TextView selectedYear = findViewById(R.id.selectedYear);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                selectedDay.setText("Day: " + dayOfMonth);

            }
        });
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_home:
                        startActivity(new Intent(MainActivity.this,MainActivity.class));
                        return true;
                    case R.id.action_events:
                        startActivity(new Intent(MainActivity.this,EventActivity.class));
                        return true;
                    case R.id.action_list:
                        startActivity(new Intent(MainActivity.this,TaskActivity.class));
                        return true;
                    default: return true;
                }
            }
        });
    }

}
