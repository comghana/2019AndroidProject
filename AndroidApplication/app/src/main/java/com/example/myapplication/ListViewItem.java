package com.example.myapplication;

import android.graphics.drawable.Drawable;

    public class ListViewItem {
        private Drawable iconDrawable;
        private String cityTitle;
        private String counName;
        private String cityIn;
        private String cityTime;
        private String cityNum;
        public void setIcon(Drawable icon) { iconDrawable  = icon; }
        public void setTitle(String title) { cityTitle = title; }
        public void  setName(String name) { counName = name; }
        public void setIn(String in) { cityIn = in; }
        public void setTime(String utc) { cityTime = utc; }
        public void setNum(String num) { cityNum = num; }

        public Drawable getIcon() { return this.iconDrawable;}
        public String getTitle() { return this.cityTitle;}
        public String getName() { return this.counName;}
        public String getIn() { return this.cityIn;}
        public String getTime() { return this.cityTime;}
        public String getNum() { return this.cityNum;}

        public void setData(Drawable ic, String title, String name, String in, String time, String num) {
            iconDrawable = ic;
            cityTitle = title;
            counName = name;
            cityIn = in;
            cityTime = time;
            cityNum = num;
        }
    }
