package com.adruijter.koffiebestelapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoadActivity extends Activity {

    //Fields
    TextView dataTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);
        this.dataTxt = (TextView)findViewById(R.id.dataView);
    }

    public void placeOrder(View view)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void showOrders(View view)
    {

        Toast.makeText(getBaseContext(), "Er is op de bestelling knop gedrukt", Toast.LENGTH_LONG).show();

        FileInputStream fis;

        try {
            //ArrayList<String> test = new ArrayList<String>();
            String[] test, words;
            fis = openFileInput("bestelappdata.txt");
            int read = -1;
            StringBuffer buffer = new StringBuffer();
            while ((read = fis.read()) != -1) {
                buffer.append((char) read);
                //Toast.makeText(getBaseContext(), buffer.substring(0, buffer.length()) + buffer.lastIndexOf("#"), Toast.LENGTH_SHORT).show();
                //Log.d("een", Integer.toString(buffer.lastIndexOf("#")));
            }
            String output = buffer.substring(0, buffer.length());

            test = output.split(System.getProperty("line.separator"));

            //test.add(Arrays.toString(output.split(" ")));
            Log.v("test123", output);
            //Log.v("test456", test.get(0));
            //Toast.makeText(getBaseContext(), output, Toast.LENGTH_LONG).show();
            this.dataTxt.setText(output);

            for (int i = 0; i < test.length; i++) {
                words = test[i].split(" ");
                for (int j = 0; j < words.length; j++)
                {
                    Log.v("test9", words[j]);
                }
                Log.v("test789", test[i] + Integer.toString(i));
            }

            //Log.v("Hoi", test[5] + "i");
        }
        catch (FileNotFoundException e)
        {
            e.getMessage();
        }
        catch (IOException e)
        {
            e.getMessage();
        }



    }
}
