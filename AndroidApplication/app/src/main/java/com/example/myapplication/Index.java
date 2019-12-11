package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Index extends AppCompatActivity {
    ImageButton asia;
    ImageButton eu;
    ImageButton africa;
    ImageButton s_a;
    ImageButton n_a;
    ImageButton oceania;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.index);
        setTitle("Index");

        asia = (ImageButton) findViewById(R.id.asia);
        eu = (ImageButton) findViewById(R.id.eu);
        africa = (ImageButton) findViewById(R.id.africa);
        s_a = (ImageButton) findViewById(R.id.s_a);
        n_a = (ImageButton) findViewById(R.id.n_a);
        oceania = (ImageButton) findViewById(R.id.oceania);

        asia.setOnClickListener( new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(Index.this, "ASIA 선택", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), ListViewSet.class);
                intent.putExtra("continent", "ASIA");
                startActivity(intent);
            }
        });

        eu.setOnClickListener( new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ListViewSet.class);
                intent.putExtra("continent", "EUROPE");
                startActivity(intent);
            }
        });

        africa.setOnClickListener( new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ListViewSet.class);
                intent.putExtra("continent", "AFRICA");
                startActivity(intent);
            }
        });

        oceania.setOnClickListener( new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ListViewSet.class);
                intent.putExtra("continent", "OCEANIA");
                startActivity(intent);
            }
        });

        n_a.setOnClickListener( new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ListViewSet.class);
                intent.putExtra("continent", "NORTH AMERICA");
                startActivity(intent);
            }
        });

        s_a.setOnClickListener( new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ListViewSet.class);
                intent.putExtra("continent", "SOUTH AMERICA");
                startActivity(intent);
            }
        });
    }
}
