package com.nexzenapk.techfeed;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    public static String news_Title="";
    public static String news_des ="";
    public static Bitmap news_Banner = null;

    TextToSpeech textToSpeech;

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

        newtitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                textToSpeech = new TextToSpeech(MainActivity2.this, new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {

                        textToSpeech.speak(""+newdes.getText().toString(),TextToSpeech.QUEUE_ADD,null,null);






                    }
                });




            }
        });



    }

}