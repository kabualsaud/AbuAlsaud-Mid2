package com.example.abualsaud_mid2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    final DatabaseHelper MyDB = new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        final TextView txtID = (TextView) findViewById(R.id.txtID);
        final TextView txtFName = (TextView) findViewById(R.id.txtFName);
        final TextView txtSName = (TextView) findViewById(R.id.txtSName);
        final TextView txtNatID = (TextView) findViewById(R.id.txtNatID);
        final Button btnInsert = (Button) findViewById(R.id.btnInsert);
        final Button btn2to1 = (Button) findViewById(R.id.btn2to1);
        final Button btn2to3 = (Button) findViewById(R.id.btn2to3);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String idGet = txtID.getText().toString();
                String fnameGet = txtFName.getText().toString();
                String snameGet = txtSName.getText().toString();
                String natIdGet = txtNatID.getText().toString();

                if (idGet != "" && fnameGet != "" && snameGet != "" && natIdGet != ""){
                    Toast.makeText(getApplicationContext(),"Data inserted successfully",Toast.LENGTH_LONG).show();
                    MyDB.Insert(idGet, fnameGet, snameGet, natIdGet);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Please fill in all the fields",Toast.LENGTH_LONG).show();
                }
            }
        });
        btn2to1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity2.this, MainActivity.class));
            }
        });
        btn2to3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity2.this, MainActivity3.class));
            }
        });
    }
}