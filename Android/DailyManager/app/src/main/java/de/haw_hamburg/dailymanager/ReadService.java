package de.haw_hamburg.dailymanager;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class ReadService {
    //To Do
    public void readObject(Context context,Event event) {
        Log.i("location",context.getExternalFilesDir(null).getAbsolutePath());

        File file = new File(context.getExternalFilesDir(null).getAbsolutePath(), "Event.txt");
        try{
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(event);

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void readList(Context context){
        File file = new File(context.getExternalFilesDir(null).getAbsolutePath(), "Events.txt");


    }


}
