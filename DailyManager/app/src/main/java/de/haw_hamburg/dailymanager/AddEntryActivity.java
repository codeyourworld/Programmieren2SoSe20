package de.haw_hamburg.dailymanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TimePicker;

public class AddEntryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_entry);
        TimePicker picker=(TimePicker)findViewById(R.id.datePicker1);
        picker.setIs24HourView(true);
    }
}
