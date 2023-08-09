package com.nexzenapk.techfeed;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    public static String news_Title="";
    public static String news_des ="";
    public static Bitmap news_Banner = null;

    TextView newtitle,newdes;
    ImageView newbanner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        newtitle = findViewById(R.id.newtitle);
        newdes = findViewById(R.id.newsdes);
        newbanner = findViewById(R.id.newbanner);

        newtitle.setText(news_Title);
        newdes.setText(news_des);
        if (news_Banner !=null) newbanner.setImageBitmap(news_Banner);



    }

}