package com.example.myapplication;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.*;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.app.AlertDialog;
import android.net.Uri;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {
    //Adapter에 추가된 데이터를 저장하기 위한 ArrayList
    private ArrayList<ListViewItem> listViewItemList = new ArrayList<ListViewItem>();

    //ListViewAdapter의 생성자
    public ListViewAdapter(ArrayList<ListViewItem> data) {
        this.listViewItemList = data;
    }

    //Adapter에 사용되는 데이터의 개수를 리턴 : 필수 구현
    @Override
    public int getCount() {
        return listViewItemList.size();
    }

    //position에 위치한 데이터를 화면에 출력하는데 사용될 View를 리턴 : 필수 구현
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        //layout을 inflat하여 convertView 참조 획득.
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.row, parent, false);
        }

        ImageView iconImageView = (ImageView) convertView.findViewById(R.id.imageView1);
        TextView titleTextView = (TextView) convertView.findViewById(R.id.textView1);
        TextView nameTextView = (TextView) convertView.findViewById(R.id.textView2);
        TextView inTextView = (TextView) convertView.findViewById(R.id.textView3);
        TextView timeTextView = (TextView) convertView.findViewById(R.id.textView4);
        TextView numTextView = (TextView) convertView.findViewById(R.id.textView5);


        //Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득
        ListViewItem listViewItem = listViewItemList.get(position);

        //아이템 내 각 위젯에 데이터 반영
        iconImageView.setImageDrawable(listViewItem.getIcon());
        titleTextView.setText(listViewItem.getTitle());
        nameTextView.setText(listViewItem.getName());
        inTextView.setText(listViewItem.getIn());
        timeTextView.setText(listViewItem.getTime());
        numTextView.setText(listViewItem.getNum());

        ImageView button = (ImageView) convertView.findViewById(R.id.imageView2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, listViewItemList.get(pos).getTitle() + "선택", Toast.LENGTH_SHORT).show();

                AlertDialog.Builder alertdialog = new AlertDialog.Builder(context);
                alertdialog.setMessage(listViewItemList.get(pos).getTitle() + "의 지도를 보시겠습니까?");

                alertdialog.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(context, "확인버튼을 불렀습니다.", Toast.LENGTH_SHORT).show();
                        Intent it = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0, 0?q=" + listViewItemList.get(pos).getTitle()));
                        context.startActivity(it);
                    }
                });

                alertdialog.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(context, "취소버튼을 불렀습니다.", Toast.LENGTH_SHORT).show();
                    }
                });
                AlertDialog alert = alertdialog.create();
                alert.setIcon(R.drawable.map_icon);
                alert.setTitle("지도검색");
                alert.show();
            }
        });
        ImageView button2 = (ImageView) convertView.findViewById(R.id.imageView1);
        button2.setOnClickListener(v -> {
            Intent it2 = new Intent(context, ViewCity.class);
            it2.putExtra("title", listViewItemList.get(pos).getTitle());
            it2.putExtra("country", listViewItemList.get(pos).getName());
            it2.putExtra("include", listViewItemList.get(pos).getIn());
            it2.putExtra("utc", listViewItemList.get(pos).getTime());
            it2.putExtra("air", listViewItemList.get(pos).getNum());

            context.startActivity(it2);
        });

        return convertView;
    }

    //지정한 위치(position)에 있는 데이터와 관계된 아이템(row)의 ID를 리턴 : 구현 필수
    @Override
    public long getItemId(int position) {
        return position;
    }

    //지정한 위치(position)에 있는 데이터 리언 : 필수 구현
    @Override
    public  Object getItem(int position) {
        return listViewItemList.get(position);
    }

    //아이템 데이터 추가를 위한 함수, 개발자가 원하는대로 작성 가능
    public void addItem(Drawable icon, String title, String name, String in, String time, String num) {
        ListViewItem item = new ListViewItem();

        item.setIcon((icon));
        item.setTime(title);
        item.setName(name);
        item.setIn(in);
        item.setTime(time);
        item.setNum(num);

        listViewItemList.add(item);

    }

}
