package de.haw_hamburg.myalarm;

public class AlarmClock {

    public static final int MONDAY = 0;
    public static final int TUESDAY = 1;
    public static final int WEDNESDAY = 2;
    public static final int THURSDAY = 3;
    public static final int FRIDAY = 4;
    public static final int SATURDAY = 5;
    public static final int SUNDAY = 6;

    private int hour;
    private int min;
    private boolean isOn;
    private boolean[] day = new boolean[7];

    public AlarmClock(int hour, int min, boolean isOn) {
        this.hour = hour;
        this.min = min;
        this.isOn = isOn;
    }

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public boolean getDay(int index) {
        boolean retValue = false;
        if(checkIndex(index)) {
            retValue = day[index];
        }
        return retValue;
    }

    public void setDay(boolean isSet, int index) {
        if(checkIndex(index)) {
            this.day[index] = isSet;
        }
    }

    public void toggleDay(int index) {
        if(checkIndex(index)) {
            day[index] = !day[index];
        }
    }

    private boolean checkIndex(int index) {
        return index < this.day.length && index >= 0;
    }
    
    @Override
    public String toString() {
        String time = String.format(hour + ':' + min);
        return time;
    }
}