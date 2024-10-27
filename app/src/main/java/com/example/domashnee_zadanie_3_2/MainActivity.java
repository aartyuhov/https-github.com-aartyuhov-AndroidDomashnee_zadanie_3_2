package com.example.domashnee_zadanie_3_2;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private CheckBox checkBoxRed;
    private CheckBox checkBoxGreen;
    private CheckBox checkBoxBlue;
    private LinearLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        checkBoxRed = findViewById(R.id.checkBoxRed);
        checkBoxGreen = findViewById(R.id.checkBoxGreen);
        checkBoxBlue = findViewById(R.id.checkBoxBlue);
        layout = findViewById(R.id.layout);

        checkBoxRed.setOnCheckedChangeListener((buttonView, isChecked) -> updateBackgroundColor());
        checkBoxGreen.setOnCheckedChangeListener((buttonView, isChecked) -> updateBackgroundColor());
        checkBoxBlue.setOnCheckedChangeListener((buttonView, isChecked) -> updateBackgroundColor());
    }

    private void updateBackgroundColor() {
        int color = Color.WHITE; // Default to white

        if (checkBoxRed.isChecked()) {
            color = Color.RED;
        }
        if (checkBoxGreen.isChecked()) {
            color = Color.GREEN;
        }
        if (checkBoxBlue.isChecked()) {
            color = Color.BLUE;
        }

        // Combine colors if multiple checkboxes are selected
        if (checkBoxRed.isChecked() && checkBoxGreen.isChecked()) {
            color = Color.YELLOW; // Red + Green = Yellow
        } else if (checkBoxRed.isChecked() && checkBoxBlue.isChecked()) {
            color = Color.MAGENTA; // Red + Blue = Magenta
        } else if (checkBoxGreen.isChecked() && checkBoxBlue.isChecked()) {
            color = Color.CYAN; // Green + Blue = Cyan
        }

        layout.setBackgroundColor(color);
    }
}