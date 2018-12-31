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

    public static final String EXTRA_MESSAGE = "com.example.cutte.handimapsinternshipproject.MESSAGE";
    public static final int MAPS_REQUEST = 0;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
    }



    //When the button is pressed, start the other activity
    public void callMapsActivity(View v)
    {
        Intent intent = new Intent(this, MapsActivity.class);
        intent.putExtra(EXTRA_MESSAGE, "Hello World!");
        startActivityForResult(intent,MAPS_REQUEST);
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
        else
        {
            //Failed, output that
            textView.setText("Got a failed result");
        }
    }


    public void makeToast(String msg)
    {
        Context context = getApplicationContext();
        CharSequence text = msg;
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}
