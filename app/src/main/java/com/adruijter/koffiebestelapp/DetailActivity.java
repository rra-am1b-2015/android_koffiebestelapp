package com.adruijter.koffiebestelapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        String firstname = intent.getStringExtra("voornaam");
        String infix = intent.getStringExtra("tussenvoegsel");
        TextView firstNameView = (TextView)findViewById(R.id.firstnameValue);
        TextView infixView = (TextView)findViewById(R.id.infixValue);

        firstNameView.setText(firstname);
        infixView.setText(infix);
    }
}
