package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;


import android.app.SearchManager;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;

public class ViewCity extends AppCompatActivity {
    ImageView imageview;
    TextView citytitle;
    TextView citycoun;
    TextView cityin;
    TextView cityutc;
    TextView cityair;
    ImageView weather;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewcity);

        imageview = (ImageView) findViewById(R.id.img);
        citytitle = (TextView)findViewById(R.id.cityname);
        citycoun = (TextView)findViewById(R.id.countryname);
        cityin = (TextView)findViewById(R.id.includecity);
        cityutc = (TextView)findViewById(R.id.utctime);
        cityair = (TextView)findViewById(R.id.airtime);
        weather = (ImageView)findViewById(R.id.weather);

        Intent ie = getIntent();

        String title = ie.getStringExtra("title");
        if(title.equals("하노이")) imageview.setImageDrawable((getResources().getDrawable(R.drawable.hanoi)));
        else if(title.equals("치앙마이")) imageview.setImageDrawable((getResources().getDrawable(R.drawable.chiang)));
        else if(title.equals("제주도")) imageview.setImageDrawable((getResources().getDrawable(R.drawable.jeju)));
        else if(title.equals("베네치아")) imageview.setImageDrawable((getResources().getDrawable(R.drawable.vane)));
        else if(title.equals("에든버러")) imageview.setImageDrawable((getResources().getDrawable(R.drawable.aden)));
        else if(title.equals("코펜하겐")) imageview.setImageDrawable((getResources().getDrawable(R.drawable.copen)));
        else if(title.equals("뉴욕")) imageview.setImageDrawable((getResources().getDrawable(R.drawable.ny)));
        else if(title.equals("토론토")) imageview.setImageDrawable((getResources().getDrawable(R.drawable.tlt)));
        else if(title.equals("라스베가스")) imageview.setImageDrawable((getResources().getDrawable(R.drawable.lasb)));
        else if(title.equals("상파울루")) imageview.setImageDrawable((getResources().getDrawable(R.drawable.sangpa)));
        else if(title.equals("코르도바")) imageview.setImageDrawable((getResources().getDrawable(R.drawable.cole)));
        else if(title.equals("라파스")) imageview.setImageDrawable((getResources().getDrawable(R.drawable.lapas)));
        else if(title.equals("카이로")) imageview.setImageDrawable((getResources().getDrawable(R.drawable.kailo)));
        else if(title.equals("튀니스")) imageview.setImageDrawable((getResources().getDrawable(R.drawable.tunizi)));
        else if(title.equals("라바트")) imageview.setImageDrawable((getResources().getDrawable(R.drawable.labate)));
        else if(title.equals("발리")) imageview.setImageDrawable((getResources().getDrawable(R.drawable.bali)));
        else if(title.equals("웰링턴")) imageview.setImageDrawable((getResources().getDrawable(R.drawable.weling)));
        else if(title.equals("켄버라")) imageview.setImageDrawable((getResources().getDrawable(R.drawable.can)));

        citytitle.setText(title);
        citycoun.setText(ie.getStringExtra("country"));
        cityin.setText(ie.getStringExtra("include"));
        cityutc.setText(ie.getStringExtra("utc"));
        cityair.setText(ie.getStringExtra("air"));

        weather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = "https://www.google.com/search?q=+"+title+"날씨";
                Intent wea = new Intent(Intent.ACTION_WEB_SEARCH);
                wea.putExtra(SearchManager.QUERY, result);
                startActivity(wea);
            }
        });
    }
}
