package com.example.cutte.handimapsinternshipproject;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CodingActivity extends AppCompatActivity {

     /*
        This started out as an empty Activity. All I do here is make the button functional.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coding);

    }

    public void goToGithub(View v)
    {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/paysonblackwell"));
        startActivity(browserIntent);
    }
}
