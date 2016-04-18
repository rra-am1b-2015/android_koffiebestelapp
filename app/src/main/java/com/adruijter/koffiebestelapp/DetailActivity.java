package com.adruijter.koffiebestelapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DetailActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        String firstname = intent.getStringExtra("voornaam");
        String infix = intent.getStringExtra("tussenvoegsel");
        String lastname = intent.getStringExtra("achternaam");
        String amountOfCoffee = intent.getStringExtra("aantalKoffie");
        TextView firstNameView = (TextView)findViewById(R.id.firstnameValue);
        TextView infixView = (TextView)findViewById(R.id.infixValue);
        TextView lastnameView = (TextView)findViewById(R.id.lastnameValue);
        TextView amountOfCoffeeView = (TextView)findViewById(R.id.numberOfCoffeeValue);

        firstNameView.setText(firstname);
        infixView.setText(infix);
        lastnameView.setText(lastname);
        amountOfCoffeeView.setText(amountOfCoffee);
    }
}
