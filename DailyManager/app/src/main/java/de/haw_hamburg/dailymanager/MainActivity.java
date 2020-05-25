package de.haw_hamburg.dailymanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton floatingActionButton = findViewById(R.id.floatingActionButton2);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Add Notification",
                        Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this,
                        AddEntryActivity.class);
                startActivity(intent);
            }
        });
    }
}