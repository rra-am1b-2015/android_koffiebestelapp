package com.adruijter.koffiebestelapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    String datumTest = "";
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
                orderCoffee(view);
                // TODO Auto-generated method stub
                Toast.makeText(
                        getBaseContext(),
                        "Selected Date is\n\n" + dayOfMonth + " / " + (month + 1)
                                + " / " + year, Toast.LENGTH_LONG).show();

            }
        });

        File file = getBaseContext().getFileStreamPath("myfile.txt");
        String readString = "";
        if (file.exists()) {

            FileInputStream fis;

            Toast.makeText(
                    getBaseContext(),
                    "Hij bestaat", Toast.LENGTH_LONG).show();

            try {
                fis = openFileInput("myfile.txt");

                fis.read(readString.getBytes());
                StringBuilder sb = new StringBuilder();
                Reader r = new InputStreamReader(fis, "UTF-8");
                int ch = r.read();
                while ( ch >= 0)
                {
                    sb.append(ch);
                    ch = r.read();
                }

                Toast.makeText(
                        getBaseContext(),
                        sb.toString(), Toast.LENGTH_LONG).show();
                fis.close();


            } catch (IOException e) {
                e.printStackTrace();

            }
        }
        Toast.makeText(getBaseContext(), readString  , Toast.LENGTH_LONG).show();
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
        milkTxt += "melk" + getFilesDir();


        //Date datum = new Date(cld.getDate());
       // datumTest = new SimpleDateFormat("dd-MM-yyyy").format(datum);


        String output = String.format("Voornaam: %s \n Tussenvoegsel: %s \n Achternaam: %s \n Aantal Koffie: %s \n Wel of geen melk: %s \n Sterktepercentage: %s procent \n datum: %s",
                txtFirstname.getText(), txtInfix.getText(), txtLastname.getText(), txtNumberOfCoffee.getText(), milkTxt, skbar.getProgress(), datumTest);

        File file = this.getFilesDir();
        File newFile = new File(file.getAbsolutePath() + "/arjan");
        newFile.mkdir();
        String filename = "myfile.txt";
        String string = "Hello world!";
        FileOutputStream outputStream;

        try {
            outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
            outputStream.write(output.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        txtTest.setText(output);
    }



    public void getDatum(View view, int year, int month, int dayOfMonth){
        datumTest = dayOfMonth + "-" + month + "-" + year;
    }
}
