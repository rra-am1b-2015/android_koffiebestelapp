package com.adruijter.koffiebestelapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
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
    private static final int NUM_ROWS = 4;
    private static final int NUM_COLS = 9;
    private String[] words;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);
        showOrders();
       // this.dataTxt = (TextView)findViewById(R.id.dataView);
    }

    public void placeOrder(View view)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void showOrders()
    {


        Toast.makeText(this, "Er is op de bestelling knop gedrukt", Toast.LENGTH_LONG).show();

        FileInputStream fis;

        try {

            String[] test;

            fis = openFileInput("bestelappdata.txt");
            int read = -1;
            StringBuffer buffer = new StringBuffer();
            while ((read = fis.read()) != -1) {
                buffer.append((char) read);
            }
            String output = buffer.substring(0, buffer.length());

            test = output.split(System.getProperty("line.separator"));

            Log.v("test123", output);

            //this.dataTxt.setText(output);

            TableLayout table = (TableLayout)findViewById(R.id.tableInternalMemory);


            for ( int row = 0; row < test.length; row++)
            {
                words = test[row].split(" ");
                TableRow tableRow = new TableRow(this);
                tableRow.setLayoutParams(new TableLayout.LayoutParams(
                        TableLayout.LayoutParams.MATCH_PARENT,
                        TableLayout.LayoutParams.MATCH_PARENT,
                        1.0f
                ));
                table.addView(tableRow);

                for ( int col = 0; col < NUM_COLS; col++ )
                {
                    TextView tblData = new TextView(this);
                    String arjan = words[col];
                    tblData.setText(arjan);
                    tblData.setTextSize(11);
                    tblData.setBackgroundColor(Color.rgb(200, 200,200));
                    tblData.setPadding(2, 20, 0, 20);
                    tblData.setLayoutParams(new TableRow.LayoutParams(
                            TableRow.LayoutParams.WRAP_CONTENT,
                            TableRow.LayoutParams.WRAP_CONTENT,
                            1.0f
                    ));
                    tableRow.addView(tblData);
                }
                Button button = new Button(this);
                button.setPadding(0, 0, 0, 0);
                button.setHeight(20);
                button.setWidth(20);
                button.setText("Druk");
                button.setLayoutParams(new TableRow.LayoutParams(
                        TableRow.LayoutParams.WRAP_CONTENT,
                        TableRow.LayoutParams.WRAP_CONTENT,
                        1.0f
                ));

                View.OnClickListener btnClickListener = new View.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        Toast.makeText(getApplicationContext(), "Er is op de knop gedrukt", Toast.LENGTH_LONG).show();
                        showDetail(v);
                    }
                };
                button.setOnClickListener(btnClickListener);
                tableRow.addView(button);

            }


            for (int i = 0; i < test.length; i++) {
                words = test[i].split(" ");
                for (int j = 0; j < words.length; j++)
                {
                    Log.v("test9", words[j]);
                }
                Log.v("test789", test[i] + Integer.toString(i));
            }

            //test.add(Arrays.toString(output.split(" ")));
            //Log.v("Hoi", test[5] + "i");
            //Log.v("test456", test.get(0));
            //Toast.makeText(getBaseContext(), output, Toast.LENGTH_LONG).show();
            //ArrayList<String> test = new ArrayList<String>();
            //Toast.makeText(getBaseContext(), buffer.substring(0, buffer.length()) + buffer.lastIndexOf("#"), Toast.LENGTH_SHORT).show();
            //Log.d("een", Integer.toString(buffer.lastIndexOf("#")));
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

    public void showDetail(View view)
    {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("voornaam",words[0]);
        intent.putExtra("tussenvoegsel", words[1]);
        startActivity(intent);
    }
}
