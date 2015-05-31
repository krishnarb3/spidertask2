package com.spiderinductions.rb.spidertask2;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Adapter;

import java.util.ArrayList;

public class MainActivity extends ActionBarActivity {
    TextView textView;
    String text;
    int color,fontsize,fontface1;
    EditText editText;
    Spinner spinner1,spinner2;
    boolean boldcount,italicscount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText)findViewById(R.id.edittext);
        textView = (TextView)findViewById(R.id.textView);
        Checkboxcheck();
        spinner1 = (Spinner)findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.colors,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);
        spinner2 = (Spinner)findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,R.array.fontsize,android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                switch(position)
                {
                    case 0: color=0;break;
                    case 1: color=1;break;
                    case 2: color=2;break;
                    case 3: color=3;break;
                    case 4: color=4;break;
                    case 5: color=5;break;
                    case 6: color=6;break;
                    case 7: color=7;break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                color=5;
            }
        });
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                switch(position)
                {
                    case 0: fontsize=20;break;
                    case 1: fontsize=24;break;
                    case 2: fontsize=28;break;
                    case 3: fontsize=32;break;
                    case 4: fontsize=36;break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                color=5;
            }
        });

        final String[] fontface = getResources().getStringArray(R.array.fontface);
        ListAdapter adapter3 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,fontface);
        ListView listview = (ListView)findViewById(R.id.listViewfontface);
        listview.setAdapter(adapter3);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                switch(position)
                {
                    case 0:fontface1=0;break;
                    case 1:fontface1=1;break;
                    case 2:fontface1=2;break;
                }
                Intent i = new Intent(MainActivity.this,textdisplayactivity.class);
                text = editText.getText().toString();
                i.putExtra("fontface1",fontface1);
                i.putExtra("text",text);
                i.putExtra("boldcount",boldcount);
                i.putExtra("italicscount",italicscount);
                i.putExtra("color",color);
                i.putExtra("fontsize",fontsize);
                startActivityForResult(i,1);
            }
        });
    }

    public void Checkboxcheck()
    {
    final CheckBox ch1= (CheckBox)findViewById(R.id.checkbox_bold);
    final CheckBox ch2= (CheckBox)findViewById(R.id.checkbox_italic);
    ch1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(ch1.isChecked())
                boldcount=true;
            else
                boldcount=false;


        }
    });
    ch2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(ch2.isChecked())
                italicscount=true;
            else
                italicscount=false;
        }
    });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==1)
        {
        finish();
        System.exit(0);
        }
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
}
