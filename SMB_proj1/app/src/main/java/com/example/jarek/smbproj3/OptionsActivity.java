package com.example.jarek.smbproj3;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class OptionsActivity extends AppCompatActivity {

    public static String MY_SHARED_PREFERENCES = "MyPrefFile";

    private Spinner colorSpinner;
    private EditText fontSize;
    private TextView colorSetTextView;
    private TextView fontSetTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        colorSpinner = (Spinner) findViewById(R.id.color_spinner);
        fontSize = (EditText) findViewById(R.id.font_size_edit_text);
        colorSetTextView = (TextView) findViewById(R.id.colorSetTextView);
        fontSetTextView = (TextView) findViewById(R.id.fontSetTextView);

        SharedPreferences prefs = getSharedPreferences(MY_SHARED_PREFERENCES, MODE_PRIVATE);

        colorSetTextView.setText("Wybrano kolor: " + prefs.getString("background_color", "No color defined"));
        fontSetTextView.setText("Wybrano wielkość tekstu: " + prefs.getString("font_size", "No font size defined"));

    }

    public void saveInfo(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences(MY_SHARED_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("background_color", colorSpinner.getSelectedItem().toString());
        editor.putString("font_size", String.valueOf(fontSize.getText()));
        editor.apply();

        colorSetTextView.setText("Wybrano kolor: " + colorSpinner.getSelectedItem().toString());
        fontSetTextView.setText("Wybrano wielkość tekstu: " + String.valueOf(fontSize.getText()));
    }

    public void goToMainActivity(View view) {
        Intent intent = new Intent(OptionsActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
