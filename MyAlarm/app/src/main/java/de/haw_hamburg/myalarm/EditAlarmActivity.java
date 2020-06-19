package de.haw_hamburg.myalarm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;

public class EditAlarmActivity extends AppCompatActivity {

    private AlarmClock alarmClock;

    public TextView colorTextView(EditAlarmActivity.this, TextView day, boolean isDay) {
        day.setTextColor(ContextCompat.getColor(this, R.color.colorAccent));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_alarm);

        //read object from file or create a new one
        alarmClock = (AlarmClock) ReadService.readObject(this);
        if(alarmClock == null) {
            alarmClock = new AlarmClock(8, 0, true);
        }

        //set attributes for time picker
        TimePicker timePicker = findViewById(R.id.timePicker);
        timePicker.setHour(alarmClock.getHour());
        timePicker.setMinute(alarmClock.getMin());
        timePicker.setIs24HourView(true);

        //set attributes for switch
        Switch isOnSwitch = findViewById(R.id.toggleSwitch_2);
        isOnSwitch.setChecked(alarmClock.isOn());

        //init text views
        TextView monTextView = colorTextView((TextView) findViewById(R.id.monday), alarmClock.getDay(AlarmClock.MONDAY));
        TextView tueTextView = colorTextView((TextView) findViewById(R.id.tuesday), alarmClock.getDay(AlarmClock.TUESDAY));
        TextView wedTextView = colorTextView((TextView) findViewById(R.id.wednesday), alarmClock.getDay(AlarmClock.WEDNESDAY));
        TextView thuTextView = colorTextView((TextView) findViewById(R.id.thursday), alarmClock.getDay(AlarmClock.TUESDAY));
        TextView friTextView = colorTextView((TextView) findViewById(R.id.friday), alarmClock.getDay(AlarmClock.FRIDAY));
        TextView satTextView = colorTextView((TextView) findViewById(R.id.saturday), alarmClock.getDay(AlarmClock.SATURDAY));
        TextView sunTextView = colorTextView((TextView) findViewById(R.id.sunday), alarmClock.getDay(AlarmClock.SUNDAY));

        setDayListener(monTextView, AlarmClock.MONDAY);
        setDayListener(tueTextView, AlarmClock.TUESDAY);
        setDayListener(wedTextView, AlarmClock.WEDNESDAY);
        setDayListener(thuTextView, AlarmClock.THURSDAY);
        setDayListener(friTextView, AlarmClock.FRIDAY);
        setDayListener(satTextView, AlarmClock.SATURDAY);
        setDayListener(sunTextView, AlarmClock.SUNDAY);

    }

    private void setDayListener(TextView textView, int index) {
        textView.setOnClickListener(v -> {
            alarmClock.setDay(!alarmClock.getDay(index), index);
            colorTextView(this, (TextView) v, alarmClock.getDay(index));
        });
    }
}

/*
public class EditAlarmActivity extends AppCompatActivity {

    TextView[] days = new TextView[7];
    String[] days_id = new String[7];
    days_id = {"monday", "tuesday", "wednesday", "thursday", "friday", "saturday", "sunday"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_alarm);

        for(int i=0; i<days.length; i++){
            int temp;
            temp = getResources().getIdentifier(days_id[i], "id", getPackageName());
            days[i] = (TextView)findViewById(temp);
        }
        }
    }
}
*/
