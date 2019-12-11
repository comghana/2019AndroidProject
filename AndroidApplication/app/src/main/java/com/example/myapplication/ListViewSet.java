package com.example.myapplication;
import android.os.Bundle;
import android.content.Intent;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ListViewSet extends AppCompatActivity {
    private ListViewItem data;
    private ArrayList<ListViewItem> arrays;
    String country = "국가: ";
    String include = "소속: ";
    String utc= "시간: ";
    String air = "비행시간: ";


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
        Intent intent= getIntent();
        String continent = intent.getStringExtra("continent");
        setTitle(continent);

        ListView listView = null;
        ListViewAdapter adapter;
        arrays = new ArrayList<ListViewItem>();

        //데이터 추가 부분
        initialData(continent);

        listView = (ListView) findViewById(R.id.listview1);

        //Adapter 생성
        adapter = new ListViewAdapter(arrays);

        //리스트뷰 참조 Adapter 달기
        listView.setAdapter(adapter);

        //리스트뷰 아이템 클릭 이벤트 핸들러
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ListViewItem item = (ListViewItem) parent.getItemAtPosition(position);

                Toast.makeText(ListViewSet.this, item.getTitle() + "선택", Toast.LENGTH_SHORT).show();
            }
        });


        //end of create
    }
    private void initialData(String cont) {

        if(cont.equals("ASIA")) {
            data = new ListViewItem();
            data.setData(getResources().getDrawable(R.drawable.hanoi), "하노이", country + "베트남", include + "중앙직할 시", utc + "UTC+07:00", air + "5시간 5분");
            arrays.add(data);

            data = new ListViewItem();
            data.setData(getResources().getDrawable(R.drawable.chiang), "치앙마이", country + "태국", include + "치앙마이 주", utc + "UTC+07:00", air + "6시간 10분");
            arrays.add(data);

            data = new ListViewItem();
            data.setData(getResources().getDrawable(R.drawable.jeju), "제주도", country + "대한민국", include + "제주 시", utc + "UTC+09:00", air + "1시간 10분");
            arrays.add(data);

        }else if (cont.equals("EUROPE")){
            data = new ListViewItem();
            data.setData(getResources().getDrawable(R.drawable.vane), "베네치아", country + "이탈리아", include + "베네치아 광역시", utc + "UTC+01:00", air + "12시간 0분");
            arrays.add(data);

            data = new ListViewItem();
            data.setData(getResources().getDrawable(R.drawable.aden), "에든버러", country + "영국", include + "스코틀랜드", utc + "UTC+00:00", air + "15시간 5분");
            arrays.add(data);

            data = new ListViewItem();
            data.setData(getResources().getDrawable(R.drawable.copen), "코펜하겐", country + "덴마크", include + "수도", utc + "UTC+01:00", air + "13시간 0분");
            arrays.add(data);

        }else if(cont.equals("AFRICA")) {
            data = new ListViewItem();
            data.setData(getResources().getDrawable(R.drawable.kailo), "카이로", country + "이집트", include + "카이로 주", utc + "UTC+02:00", air + "11시간 55분");
            arrays.add(data);

            data = new ListViewItem();
            data.setData(getResources().getDrawable(R.drawable.tunizi), "튀니스", country + "튀니지", include + "튀니스 주", utc + "UTC+01:00", air + "11시간 3분");
            arrays.add(data);

            data = new ListViewItem();
            data.setData(getResources().getDrawable(R.drawable.labate), "라바트", country + "모로코", include + "리바트살렘젬무르자에르", utc + "UTC+00:00", air + "17시간 35분");
            arrays.add(data);


        }else if(cont.equals("OCEANIA")) {

            data = new ListViewItem();
            data.setData(getResources().getDrawable(R.drawable.bali), "발리", country + "인도네시아", include + "발리 주", utc + "UTC+08:00", air + "7시간 15분");
            arrays.add(data);

            data = new ListViewItem();
            data.setData(getResources().getDrawable(R.drawable.weling), "웰링턴", country + "뉴질랜드", include + "웰링턴 지방", utc + "UTC+12:00", air + "14시간 0분");
            arrays.add(data);

            data = new ListViewItem();
            data.setData(getResources().getDrawable(R.drawable.can), "캔버라", country + "오스트레일리아", include + "7구", utc + "UTC+10:00", air + "13시간 10분");
            arrays.add(data);

        }else if(cont.equals("NORTH AMERICA")) {

            data = new ListViewItem();
            data.setData(getResources().getDrawable(R.drawable.ny), "뉴욕", country + "미국", include + "뉴욕 주", utc + "UTC+05:00", air + "14시간 0분");
            arrays.add(data);

            data = new ListViewItem();
            data.setData(getResources().getDrawable(R.drawable.tlt), "토론토", country + "캐나다", include + "온타리오 주", utc + "UTC+05:00", air + "12시간 50분");
            arrays.add(data);

            data = new ListViewItem();
            data.setData(getResources().getDrawable(R.drawable.lasb), "라스베가스", country + "미국", include + "네바다 주", utc + "UTC+08:00", air + "11시간 15분");
            arrays.add(data);

        }else if(cont.equals("SOUTH AMERICA")) {

            data = new ListViewItem();
            data.setData(getResources().getDrawable(R.drawable.sangpa), "상파울루", country + "브라질", include + "상파울루 주", utc + "UTC-03:00", air + "25시간 0분");
            arrays.add(data);

            data = new ListViewItem();
            data.setData(getResources().getDrawable(R.drawable.cole), "코르도바", country + "아르헨티나", include + "바리오", utc + "UTC-03:00", air + "21시간 4분");
            arrays.add(data);

            data = new ListViewItem();
            data.setData(getResources().getDrawable(R.drawable.lapas), "라바스", country + "볼리비아", include + "라파스", utc + "UTC-04:00", air + "26시간 0분");
            arrays.add(data);

        }
    }
}
