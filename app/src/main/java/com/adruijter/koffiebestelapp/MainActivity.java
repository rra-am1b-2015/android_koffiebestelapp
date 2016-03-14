package com.adruijter.koffiebestelapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CalendarView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    // Fields
    String datumTest = "",
           saveText = "";
    CalendarView cld;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cld = (CalendarView) findViewById(R.id.calendarDate);
        cld.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year,
                                            int month, int dayOfMonth) {
                datumTest = dayOfMonth + "-" + (month + 1) + "-" + year;
                //orderCoffee(view);
                // TODO Auto-generated method stub
                Toast.makeText(
                        getBaseContext(),
                        "Selected Date is\n\n" + dayOfMonth + " / " + (month + 1)
                                + " / " + year, Toast.LENGTH_LONG).show();

            }
        });



    }

    public void orderCoffee(View view)
    {
        EditText txtFirstname = (EditText) findViewById(R.id.firstname);
        EditText txtInfix = (EditText) findViewById(R.id.infix);
        EditText txtLastname = (EditText) findViewById(R.id.lastname);
        EditText txtNumberOfCoffee = (EditText) findViewById(R.id.numberOfCoffee);
        EditText txtTest = (EditText) findViewById(R.id.testText);
        CheckBox chkbxMilk = (CheckBox) findViewById(R.id.milk);
        SeekBar skbar = (SeekBar) findViewById(R.id.coffeeStrength);

        String milkTxt = "";
        if ( chkbxMilk.isChecked())
        {
            milkTxt += " wel ";
        }
        else
        {
            milkTxt += " geen ";
        }
        milkTxt += "melk";

        //Date datum = new Date(cld.getDate());
       // datumTest = new SimpleDateFormat("dd-MM-yyyy").format(datum);

        /*
        String output = String.format("Voornaam: %s \n Tussenvoegsel: %s \n Achternaam: %s \n Aantal Koffie: %s \n Wel of geen melk: %s \n Sterktepercentage: %s procent \n datum: %s",
                txtFirstname.getText(), txtInfix.getText(), txtLastname.getText(), txtNumberOfCoffee.getText(), milkTxt, skbar.getProgress(), datumTest);
        */

        String output = String.format("%s %s %s %s %s %s %s",
                txtFirstname.getText(), txtInfix.getText(), txtLastname.getText(), txtNumberOfCoffee.getText(), milkTxt, skbar.getProgress(), datumTest);

        this.saveText = output + System.getProperty("line.separator");
        txtTest.setText(output);

        if (TextUtils.isEmpty(txtFirstname.getText().toString()))
        {
            txtFirstname.setError("U moet een voornaam invullen");
        }
        else if (TextUtils.isEmpty(txtLastname.getText().toString()))
        {
            txtLastname.setError("U moet een achternaam invullen");
        }
        else if (TextUtils.isEmpty(txtNumberOfCoffee.getText().toString()))
        {
            txtNumberOfCoffee.setError("U moet het aantal koffie invullen");
        }
        else
        {
            saveDataToInternal(view);
        }

    }

    public void saveDataToInternal(View view)
    {
        // Hier komt de code om weg te schrijven naar file

        FileOutputStream fos;

        try
        {
            fos = openFileOutput("bestelappdata.txt", Context.MODE_PRIVATE | MODE_APPEND);
            fos.write(this.saveText.getBytes());
            fos.close();
        }
        catch(FileNotFoundException e)
        {
            e.getMessage();
        }
        catch(IOException e)
        {
            e.getMessage();
        }
    }

    public void getDatum(View view, int year, int month, int dayOfMonth){
        datumTest = dayOfMonth + "-" + month + "-" + year;
    }

    public void showOrder(View view)
    {
        Intent intent = new Intent(this, LoadActivity.class);
        startActivity(intent);
    }
}
