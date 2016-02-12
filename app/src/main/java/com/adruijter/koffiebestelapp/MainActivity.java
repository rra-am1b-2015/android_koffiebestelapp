package com.adruijter.koffiebestelapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void orderCoffee(View view)
    {
        EditText txtFirstname = (EditText) findViewById(R.id.firstname);
        EditText txtTest = (EditText) findViewById(R.id.testText);
        txtTest.setText("Voornaam is: " + txtFirstname.getText() + "\n" +
                        "Wat nieuwe tekst");
    }
}
