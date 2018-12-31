package com.example.cutte.handimapsinternshipproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class FutureActivity extends AppCompatActivity {

     /*
        This started out as an empty Activity. and mostly stayed that way, All I did was create a textView and fill it with text
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_future);

        TextView textView = findViewById(R.id.textView);
        textView.setText(R.string.future_text);
    }
}
