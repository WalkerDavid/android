package com.example.davidwalker.test3;

import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mp;
    TextView tv;

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // Example of a call to a native method
        tv = (TextView) findViewById(R.id.sample_text);
        tv.setText(stringFromJNI());

        final Button button = (Button) findViewById(R.id.btnDo);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                //TextView tv = (TextView) findViewById(R.id.sample_text);
                Resources resources = getResources();
                //String[] values = resources.getStringArray(R.array.first);
                String[] values = resources.getStringArray(R.array.first);
                tv.setText(values[0] + values[1] + values[2]);
            }
        });


        final Button playSound = (Button) findViewById(R.id.play_Sound);
        // mp is declared as a class variable as so is global and available for all sub methods and functions
        mp = MediaPlayer.create(this, R.raw.classicloop);

        playSound.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                if(mp.isPlaying())
                {
                    mp.pause();
                }
                else
                {
                    mp.start();
                }

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}
