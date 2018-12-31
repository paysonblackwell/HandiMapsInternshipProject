package com.example.cutte.handimapsinternshipproject;

import android.content.Context;
import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /**
        This Activity started empty, I first created a second activity and transmitted text to it and a return response to refamiliarize myself with Android Studio.
        Next I took some time to try to implement a Google Maps fragment. That took more time than I thought it would, but really helped me understand the logic with fragments better

        I then used a tabbed activity for the about page, since I wanted to write multiple sections for text, but knew that there was a better way to do multiple activities in one page.
        Turns out, because I did the Google Maps fragment first, it helped me to better understand the tabbed activity default template faster.

        If I had more time on this project, I would add a couple of this to it, such as back arrows on the toolbar on all the children activities, add multiple map locations
     */

    public static final String EXTRA_MESSAGE = "com.example.cutte.handimapsinternshipproject.MESSAGE";
    public static final int MAPS_REQUEST = 0;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set textView
        textView = findViewById(R.id.textView);
    }

    //When the button is pressed, start maps activity
    public void callMapsActivity(View v)
    {
        //clear the textView
        textView.setText("");

        Intent intent = new Intent(this, MapsActivity.class);
        intent.putExtra(EXTRA_MESSAGE, "Hello World!");
        startActivityForResult(intent,MAPS_REQUEST);
    }

    //When the button is pressed, start about activity
    public void callAboutActivity(View v)
    {
        //clear the textView
        textView.setText("");

        Intent intent = new Intent(this, AboutActivity.class);
        startActivity(intent);
    }

    //When the button is pressed, start coding activity
    public void callCodingActivity(View v)
    {
        //clear the textView
        textView.setText("");

        Intent intent = new Intent(this, CodingActivity.class);
        startActivity(intent);
    }

    //When the button is pressed, start future activity
    public void callFutureActivity(View v)
    {
        //clear the textView
        textView.setText("");

        Intent intent = new Intent(this, FutureActivity.class);
        startActivity(intent);
    }


    //See if we returned with the button press
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if(requestCode == MainActivity.MAPS_REQUEST)
        {
            if(resultCode == RESULT_OK)
            {
                //made it back okay
                textView.setText("Returned: "+ data.getStringExtra(EXTRA_MESSAGE));
            }
            else
            {
                //wasn't called back from the function
                textView.setText("Next Time, Press the button!");
            }
        }
    }


    //I used this to quickly debug stuff by outputting messages
    public void makeToast(String msg)
    {
        Context context = getApplicationContext();
        CharSequence text = msg;
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}
