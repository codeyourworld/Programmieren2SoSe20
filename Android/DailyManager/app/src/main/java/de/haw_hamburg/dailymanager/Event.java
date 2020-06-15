package de.haw_hamburg.dailymanager;

import java.io.Serializable;
import java.util.Calendar;

public class Event implements Serializable {
    private Calendar calendar;
    private String time;
    private String name;
    private String location;
    private String note;
    private String erinnerung;

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getErinnerung() {
        return erinnerung;
    }

    public void setErinnerung(String erinnerung) {
        this.erinnerung = erinnerung;
    }

    @Override
    public String toString() {
        return "Event{" +
                "calendar=" + calendar +
                ", time='" + time + '\'' +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", note='" + note + '\'' +
                ", erinnerung='" + erinnerung + '\'' +
                '}';
    }
}


