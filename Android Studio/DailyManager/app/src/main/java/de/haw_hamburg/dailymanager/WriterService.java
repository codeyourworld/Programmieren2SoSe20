package de.haw_hamburg.dailymanager;

import android.content.Context;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class WriterService {

    public static void writeObject(Context context, Object object) {

        File file = new File(context.getExternalFilesDir(null).getAbsolutePath(), ReadService.OBJECT_FILE);
        try (FileOutputStream fos = new FileOutputStream(file);
             ObjectOutputStream oos = new ObjectOutputStream(fos)){

            oos.writeObject(object);
            oos.flush();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
