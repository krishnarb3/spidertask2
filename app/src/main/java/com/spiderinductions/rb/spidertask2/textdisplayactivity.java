package com.spiderinductions.rb.spidertask2;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class textdisplayactivity extends ActionBarActivity {
    Typeface t;
    TextView textView;
    String text2;
    int color,fontface,fontsize;
    Button button_exit,button_sendback;
    private boolean boldcount,italicscount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textdisplayactivity);
        textView = (TextView)findViewById(R.id.textview);
        Bundle bundle = getIntent().getExtras();
        text2 = bundle.getString("text");
        textView.setText(text2);
        boldcount = bundle.getBoolean("boldcount");
        color = bundle.getInt("color");
        italicscount = bundle.getBoolean("italicscount");
        fontface = bundle.getInt("fontface1");
        fontsize = bundle.getInt("fontsize");
        switch(fontface)
        {
            case 0:
                t = Typeface.MONOSPACE;
                textView.setTypeface(t);
                if(boldcount)
                    textView.setTypeface(Typeface.MONOSPACE,1);
                if(italicscount)
                    textView.setTypeface(Typeface.MONOSPACE,2);
                if((boldcount)&&(italicscount))
                    textView.setTypeface(Typeface.MONOSPACE,3);
                break;
            case 1:
                t = Typeface.SANS_SERIF;
                textView.setTypeface(t);
                if(boldcount)
                    textView.setTypeface(Typeface.SANS_SERIF,1);
                if(italicscount)
                    textView.setTypeface(Typeface.SANS_SERIF,2);
                if((boldcount)&&(italicscount))
                    textView.setTypeface(Typeface.SANS_SERIF,3);
                break;
            case 2:
                t = Typeface.SERIF;
                textView.setTypeface(t);
                if(boldcount)
                    textView.setTypeface(Typeface.SERIF,1);
                if(italicscount)
                    textView.setTypeface(Typeface.SERIF,2);
                if((boldcount)&&(italicscount))
                    textView.setTypeface(Typeface.SERIF,3);
                break;
        }
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
        switch (fontsize)
        {
            case 20: textView.setTextSize(20);break;
            case 24: textView.setTextSize(24);break;
            case 28: textView.setTextSize(28);break;
            case 32: textView.setTextSize(32);break;
            case 36: textView.setTextSize(36);break;
        }

        button_sendback = (Button)findViewById(R.id.button_sendback);
        button_sendback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                setResult(0,intent);
                finish();
            }
        });
        button_exit = (Button)findViewById(R.id.button_exit);
        button_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                setResult(1,intent);
                finish();
            }
        });
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
