package com.spiderinductions.rb.spidertask2;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class textdisplayactivity extends ActionBarActivity {
    TextView textView;
    String text2;
    int color;
    private boolean boldcount,italicscount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textdisplayactivity);
        textView = (TextView)findViewById(R.id.textview);
        Bundle bundle = getIntent().getExtras();
        text2 = bundle.getString("edittext");
        boldcount = bundle.getBoolean("boldcount");
        color = bundle.getInt("color");
        italicscount = bundle.getBoolean("italicscount");
        textView.setText(text2);
        if(boldcount)
            textView.setTypeface(null,Typeface.BOLD);
        else
            textView.setTypeface(Typeface.DEFAULT);

        if(italicscount)
            textView.setTypeface(null,Typeface.ITALIC);
        else
            textView.setTypeface(Typeface.DEFAULT);
        switch(color)
        {
            case 0: textView.setTextColor(Color.BLUE);break;
            case 1: textView.setTextColor(Color.BLACK);break;
            case 2: textView.setTextColor(Color.GREEN);break;
            case 3: textView.setTextColor(Color.YELLOW);break;
            case 4: textView.setTextColor(Color.RED);break;
            case 5: textView.setTextColor(Color.WHITE);break;
            case 6: textView.setTextColor(Color.parseColor("#ff69b4"));break;
            case 7: textView.setTextColor(Color.CYAN);break;
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_textdisplayactivity, menu);
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
}
