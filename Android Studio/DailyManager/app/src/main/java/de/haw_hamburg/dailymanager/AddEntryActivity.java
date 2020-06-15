package de.haw_hamburg.dailymanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TimePicker;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class AddEntryActivity extends AppCompatActivity {

    int getYear;
    int getMonth;
    int getDay;
    int getHour;
    int getMinute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_entry);

        FloatingActionButton saveButton = findViewById(R.id.saveButton);
        CalendarView calendarView = findViewById(R.id.calendarView2);
        final TimePicker timePicker = findViewById(R.id.timePicker);
        timePicker.setIs24HourView(true);
        final EditText editTextName = findViewById(R.id.editName);
        final EditText editTextLocation = findViewById(R.id.editLocation);
        final EditText editTextNotification = findViewById(R.id.editNotification);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                getYear = year;
                getMonth = month;
                getDay = dayOfMonth;
            }
        });

        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                getHour = hourOfDay;
                getMinute = minute;
            }
        });


        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = editTextName.getText().toString();
                String location = editTextLocation.getText().toString();
                String notification = editTextNotification.getText().toString();

                Event event = new Event(getYear, getMonth, getDay, getHour, getMinute, name, location, notification);
                Log.i("checkEvent", "AddEntryActivity:"+event.toString());

                WriterService.writeObject(AddEntryActivity.this, event);
                Intent intent = new Intent(AddEntryActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });


    }


}
