package de.haw_hamburg.dailymanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.Calendar;
import java.util.Date;

public class AddEntryActivity extends AppCompatActivity {
    private Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_entry);

        CalendarView calendarView = findViewById(R.id.addEntryCalendarView);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                calendar = Calendar.getInstance();
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            }
        });

        Spinner spinner = findViewById(R.id.spinner);
        String[] arraySpinner = new String[] { "keine", "15 min vorher", "30 min vorher", "1 Stunde vorher", "morgens um 08:00", "1 Tag vorher" };
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        Button saveButton = findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Event event = new Event();

                event.setCalendar(calendar);

                EditText timeText = (EditText) findViewById(R.id.timeText);
                event.setTime(timeText.getText().toString());
                EditText nameText = (EditText) findViewById(R.id.nameText);
                event.setName(nameText.getText().toString());
                EditText locationText =(EditText) findViewById(R.id.locationText);
                event.setLocation(locationText.getText().toString());
                EditText noteText = (EditText) findViewById(R.id.noteText);
                event.setNote(noteText.getText().toString());
                Spinner spinner = findViewById(R.id.spinner);
                event.setErinnerung(spinner.getSelectedItem().toString());

                //System.out.println(event);
                Log.i("myEvent", event.toString());

                ReadService readService = new ReadService();
                readService.readObject(getApplicationContext(), event);

                Intent intent = new Intent(AddEntryActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }


}
