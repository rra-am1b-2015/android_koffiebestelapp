package com.adruijter.koffiebestelapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LoadActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);
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
            fis = openFileInput("bestelappdata.txt");
            int read = -1;
            StringBuffer buffer = new StringBuffer();
            while ((read = fis.read()) != -1)
            {
               buffer.append((char)read);

            }

            String voornaam = buffer.substring(0, buffer.indexOf(" "));
            String tussenvoegsel = buffer.substring(buffer.indexOf(" ") + 1, 25);
            Toast.makeText(getBaseContext(), "Inhoud intern geheugen: " + voornaam + " *&* " + tussenvoegsel, Toast.LENGTH_LONG).show();

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
