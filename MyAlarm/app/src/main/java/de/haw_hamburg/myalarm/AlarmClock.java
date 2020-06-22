package de.haw_hamburg.myalarm;

import androidx.annotation.NonNull;

import java.util.Locale;

public class AlarmClock {

     static final int MONDAY = 0;
     static final int TUESDAY = 1;
     static final int WEDNESDAY = 2;
     static final int THURSDAY = 3;
     static final int FRIDAY = 4;
     static final int SATURDAY = 5;
     static final int SUNDAY = 6;

    private int hour;
    private int min;
    private boolean isOn;
    private boolean[] day = new boolean[7];

     AlarmClock(int hour, int min, boolean isOn) {
        this.hour = hour;
        this.min = min;
        this.isOn = isOn;
    }

     boolean isOn() {
        return isOn;
    }

     void setOn(boolean on) {
        isOn = on;
    }

     int getHour() {
        return hour;
    }

     void setHour(int hour) {
        this.hour = hour;
    }

     int getMin() {
        return min;
    }

     void setMin(int min) {
        this.min = min;
    }

     boolean getDay(int index) {
        boolean retValue = false;
        if(checkIndex(index)) {
            retValue = day[index];
        }
        return retValue;
    }

     void setDay(boolean isSet, int index) {
        if(checkIndex(index)) {
            this.day[index] = isSet;
        }
    }

     void toggleDay(int index) {
        if(checkIndex(index)) {
            day[index] = !day[index];
        }
    }

    private boolean checkIndex(int index) {
        return index < this.day.length && index >= 0;
    }

    @NonNull
    @Override
    public String toString() {
        return String.format(Locale.GERMAN,"%02d:%02d", hour, min );
    }
}