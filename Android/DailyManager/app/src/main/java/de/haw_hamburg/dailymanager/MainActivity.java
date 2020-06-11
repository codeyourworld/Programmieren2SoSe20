package de.haw_hamburg.dailymanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WriteService writeService = new WriteService();
        Event event = writeService.writeObject(getApplicationContext());
        if(event!=null){
            Log.i("read from File", event.toString());
           // event.getCalendar();
            CalendarView calendarView = findViewById(R.id.calendarView);
            long milliTime = event.getCalendar().getTimeInMillis();
            calendarView.setDate(milliTime,true,true);
        }


        FloatingActionButton floatingActionButton = findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Want to add a new entry", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this, AddEntryActivity.class);
                startActivity(intent);
            }
        });

    }
}
