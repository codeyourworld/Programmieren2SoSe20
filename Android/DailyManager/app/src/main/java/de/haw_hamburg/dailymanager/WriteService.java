package de.haw_hamburg.dailymanager;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class WriteService {
    public Event writeObject(Context context) {
        File file = new File(context.getExternalFilesDir(null).getAbsolutePath(), "Event.txt");
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);

            Object obj = ois.readObject();
            if (obj instanceof Event) {
                Event event = (Event) obj;

                return event;
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void writeList(Context context){
        File file = new File(context.getExternalFilesDir(null).getAbsolutePath(), "Events.txt");


    }
}
