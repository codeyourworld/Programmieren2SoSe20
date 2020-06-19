package de.haw_hamburg.myalarm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton imageButton = findViewById(R.id.editButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Want to add a new entry",
                        Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this, EditAlarmActivity.class);
                startActivity(intent);
            }});
        }
}
