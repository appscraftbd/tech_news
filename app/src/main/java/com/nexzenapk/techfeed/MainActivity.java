package com.nexzenapk.techfeed;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;


public class MainActivity extends AppCompatActivity {

    LayoutInflater layoutInflater;
    ListView listView;

    HashMap <String,String> hashMap ;
    ArrayList <HashMap <String,String> > arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        meta_data();


        listView = findViewById(R.id.listView);
        MyAdapter myAdapter = new MyAdapter();
        listView.setAdapter(myAdapter);





    }
    ///////////////////////////////////////////////
    ////////////////Create MyAdapter //////////////
    ///////////////////////////////////////////////
    public  class MyAdapter extends BaseAdapter{

        LinearLayout btn;


        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @SuppressLint("MissingInflatedId")
        @Override
        public View getView(int possion, View view, ViewGroup viewGroup) {

            layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View myView = layoutInflater.inflate(R.layout.activity_feed,viewGroup,false);

            HashMap <String,String> hashMap = arrayList.get(possion);

            String stitle = hashMap.get("title");
            String sdes = hashMap.get("des");
            String image_url = hashMap.get("image_url");

            TextView iTitle = myView.findViewById(R.id.textTitle);
            TextView ides = myView.findViewById(R.id.textDes);
            ImageView banner = myView.findViewById(R.id.banner);
            btn= myView.findViewById(R.id.newsbtn);
            ImageView itemMore = myView.findViewById(R.id.itemMore);
            ImageView itemSave = myView.findViewById(R.id.itemSave);


            itemMore.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Toast.makeText(MainActivity.this,"more "+stitle,Toast.LENGTH_LONG).show();

                }
            });

            itemSave.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Toast.makeText(MainActivity.this,"save "+stitle,Toast.LENGTH_LONG).show();



                }
            });




            iTitle.setText(stitle);
            ides.setText(sdes);

            Picasso.get()
                    .load(image_url)
                    .placeholder(R.drawable.nimage)
                    .into(banner);

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                    startActivity(intent);
                    Toast.makeText(MainActivity.this,""+stitle,Toast.LENGTH_LONG).show();
                    MainActivity2.news_Title=stitle;
                    MainActivity2.news_des=sdes;

                    Bitmap bitmap = ((BitmapDrawable)banner.getDrawable()).getBitmap();
                    MainActivity2.news_Banner=bitmap;




                }
            });



            return myView;
        }
    }

    ///////////////////////////////////////////////
    ////////////////Create DataBase ///////////////
    ///////////////////////////////////////////////

    public void meta_data(){


        hashMap = new HashMap<>();
        hashMap.put("title","স্যামসাংয়ের এই ফোনে ৫০ মেগাপিক্সেলের ক্যামেরা আছে");
        hashMap.put("image_url","https://techzoom.tv/wp-content/uploads/2023/08/%E0%A6%B8%E0%A7%8D%E0%A6%AF%E0%A6%BE%E0%A6%AE%E0%A6%B8%E0%A6%BE%E0%A6%82%E0%A7%9F%E0%A7%87%E0%A6%B0-%E0%A6%8F%E0%A6%87-%E0%A6%AB%E0%A7%8B%E0%A6%A8%E0%A7%87-%E0%A7%AB%E0%A7%A6-%E0%A6%AE%E0%A7%87%E0%A6%97%E0%A6%BE%E0%A6%AA%E0%A6%BF%E0%A6%95%E0%A7%8D%E0%A6%B8%E0%A7%87%E0%A6%B2%E0%A7%87%E0%A6%B0-%E0%A6%95%E0%A7%8D%E0%A6%AF%E0%A6%BE%E0%A6%AE%E0%A7%87%E0%A6%B0%E0%A6%BE-%E0%A6%86%E0%A6%9B%E0%A7%87.jpg");
        hashMap.put("des","৫০ মেগাপিক্সেল ক্যামেরার ফোন আনল স্যামসাং। মডেল স্যামসাং গ্যালাক্সি এ৩৪। হ্যান্ডসেটটিতে শক্তিশালী ব্যাটারি দিয়েছে দক্ষিণ কোরিয়ার এই প্রযুক্তি পণ্য নির্মাতা প্রতিষ্ঠান। কোম্পানি দাবি করছে এই ফোন একবার চার্জ দিলে টানা দুই দিন চলবে। জানুন এই ফোনের বাদবাকি স্পেসিফিকেশন।\n" +
                "স্যামসাংয়ের নতুন এই ডিভাইস ৬ জিবি র\u200C্যাম ও ১২৮ জিবি স্টোরেজ দেওয়া হয়েছে। যার দাম ভারতে ১৮ হাজার ৯৯৯ রুপি। অন্যদিকে একই মডেল পাওয়া যাবে ৮ জিবি র\u200C্যাম ও ১২৮ স্টোরেজ দেওয়া হয়েছে। যার দাম ২০ হাজার ৯৯৯ রুপি।\n" +
                "এতে ৬.৪৭ ইঞ্চির ফুল এইচডি প্লাস অ্যামোলিড ডিসপ্লে দেওয়া হয়েছে। এই ডিসপ্লের সুরক্ষার জন্য গরিলা গ্লাস প্রটেকশন রয়েছে। মাল্টিটাস্কিংয়ের জন্য এক্সিনোস ১২০৮ মডেলের প্রসেসর দিয়েছে স্যামসাং।\n" +
                "এই স্মার্টফোনে ক্যামেরা রয়েছে ৫০ মেগাপিক্সেল প্রাইমারি সেন্সর সঙ্গে ৮ মেগাপিক্সেল আল্ট্রা ওয়াইড লেন্স এবং ২ মেগাপিক্সেল সেন্সর। প্রাইমারি ক্যামেরাতে পাবেন অটো নাইট মোড, ৪কে ভিডিও রেকর্ডিং ইত্যাদি। সামনে সেলফি ও ভিডিও কলের জন্য থাকছে ১৩ মেগাপিক্সেল ফ্রন্ট ক্যামেরা।\n" +
                "ব্যাকআপের জন্য হ্যান্ডসেটটিতে ৬০০০ মিলিঅ্যাম্পিয়ারের ব্যাটারি দেওয়া হয়েছে। কোম্পানি দাবি করছে একবার চার্জ দিলে দুই দিন পর্যন্ত ব্যাকআপ পাওয়া যাবে। এই ব্যাটারি চার্জ দেওয়ার জন্য ফাস্ট চার্জার রয়েছে।\n" +
                "ফোনটির চলবে অ্যানড্রয়েড ১৩ অপারেটিং সিস্টেমে। ৪ বছর গুরুত্বপূর্ণ আপডেট দেওয়া হবে এবং ৫ বছর মিলবে সিকিউরিটি আপডেট।\n" +
                "কানেক্টিভিটির ক্ষেত্রে ৫জি এবং নিরাপত্তার জন্য সাইড মাউন্টেড ফিঙ্গারপ্রিন্ট সেন্সর পাবেন ইউজাররা। বাজারে এই স্মার্টফোনটি দুইটি রঙে হাজির করেছে স্যামসাং।\n");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("title","শাওমি আনল ‘ওয়াটার গান’");
        hashMap.put("image_url","https://techzoom.tv/wp-content/uploads/2023/08/%E0%A6%B6%E0%A6%BE%E0%A6%93%E0%A6%AE%E0%A6%BF-%E0%A6%86%E0%A6%A8%E0%A6%B2-%E2%80%98%E0%A6%93%E0%A7%9F%E0%A6%BE%E0%A6%9F%E0%A6%BE%E0%A6%B0-%E0%A6%97%E0%A6%BE%E0%A6%A8.jpg");
        hashMap.put("des","চীনের উদীয়মান প্রযুক্তিপণ্য নির্মাতা প্রতিষ্ঠান শাওমি ওয়াটার গান। এটি নিছক খেলনা নয়। এর বহুবিধ ব্যবহারও রয়েছে। এটি দিয়ে ঘর-বাড়ি পরিষ্কারও করা যাবে। এমনকি পোষা প্রাণীকেও গোসল করানো যাবে। শাওমির নতুন এই ডিভাইসটির নাম মিজিয়া পালস ওয়াটার গান।\n\n" +
                "শাওমি বাজারে ভিন্ন ধরনের গ্যাজেট তৈরি করেছে। স্নিকার্স থেকে শুরু করে ভ্যাকুম ক্লিনার পর্যন্ত, তাদের বিস্তৃত প্রোডাক্ট ক্যাটেগরিতে কী নেই! সেই কোম্পানিই এবার ফ্যান্সি টয় গান বিক্রি করছে, যা দেখতে সাই-ফাই ছবির থেকে কোনও অংশে কম নয়।\n\n" +
                "ওয়াটার গানটিতে বেশ কিছু আকর্ষণীয় ফিচার রয়েছে। যা আনন্দদায়ক এবং যথেষ্ট প্র্যাক্টিক্যালও বটে। পানির নিচে ভিডিও রেকর্ড করতে পারে ডিভাইসটি। তিনটি মোড রয়েছ এতে। এগুলো হলো- কন্টিনিউয়াস, সিঙ্গেল এবং চার্জড।\n\n" +
                "ডিভাইসটির সর্বাধিক স্পিড ২৫ ওয়াটার বম্ব প্রতি সেকেন্ড এবং রেঞ্জ ৭-৯ মিটার পর্যন্ত। এটি নিজেকেই স্বয়ংক্রিয়ভাবে রিফিল করতে পারে যেকোনো সোর্স থেকে ১০-১৫ সেকেন্ডের মধ্যে পানি শোষণ করে। হাই-ডেফিনিশন ট্যাক্টিক্যাল ডিসপ্লে রয়েছে এতে, যা রিয়্যাল টাইম ভিত্তিতে মোড এবং স্টেটাস দেখাতে পারে।\n\n" +
                "ক্লিনিংয়ের কাজেও লাগতে পারে এই গ্যাজেটটি।। আপনার গাড়ি পরিষ্কার করতে পারেন এটি দিয়ে। সেই সঙ্গেই আবার ঘরের দরজা-জাোলা থেকে শুরু করে ফ্লোর এমনকি আপনার পোষ্যকেও পরিষ্কার করতে পারেন এই ডিভাইসের সাহায্যে।\n\n" +
                "ডিভাইসটিতে রয়েছে ৮০০ মিলিঅ্যাম্পিয়ারের লিথিয়াম আয়ন ব্যাটারি। যা ১০ ওয়াট চার্জিং সাপোর্ট করে। একটি ইউএসবি টাইপ সি চার্জিং পোর্টের মাধ্যমে গ্যাজেটটি চার্জ করা যাবে। একবার চার্জে ৪০ মিনিট পর্যন্ত ব্যাকআপ দিতে পারে খেলনা পিস্তলটি।\n\n");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("title","যেসব অ্যাপ ব্যবহার করলে ফোনের তথ্য চুরি হতে পারে");
        hashMap.put("image_url","https://techzoom.tv/wp-content/uploads/2023/04/%E0%A6%B8%E0%A7%8D%E0%A6%AE%E0%A6%BE%E0%A6%B0%E0%A7%8D%E0%A6%9F%E0%A6%AB%E0%A7%8B%E0%A6%A8-%E0%A6%A5%E0%A7%87%E0%A6%95%E0%A7%87-%E0%A6%A4%E0%A6%A5%E0%A7%8D%E0%A6%AF-%E0%A6%9A%E0%A7%81%E0%A6%B0%E0%A6%BF-%E0%A6%95%E0%A6%B0%E0%A6%9B%E0%A7%87-%E0%A6%AE%E0%A7%8D%E0%A6%AF%E0%A6%BE%E0%A6%B2%E0%A6%93%E0%A7%9F%E0%A7%8D%E0%A6%AF%E0%A6%BE%E0%A6%B0%E0%A6%AF%E0%A7%81%E0%A6%95%E0%A7%8D%E0%A6%A4-%E0%A7%AC%E0%A7%A6-%E0%A6%85%E0%A7%8D%E0%A6%AF%E0%A6%BE%E0%A6%AA.webp");
        hashMap.put("des","তথ্য প্রযুক্তির বিপ্লবের এই সময়ে জীবনকে সহজ করে তুলতে মোবাইল ফোনের ভূমিকা অতুলনীয়। বিনোদন থেকে শুরু করে ব্যাংকিং লেনদেন, সবই এখন হাতের মুঠোয়। বিভিন্ন কাজের জন্য আমরা অসংখ্য অ্যাপ ইন্সটল করে থাকি। কিন্তু কখনো ভেবে দেখেছেন, এসব অ্যাপের মাধ্যমে আপনার ফোনের গুরুত্বপূর্ণ তথ্য চুরি হতে পারে?\n" +
                "কিছু সাইবার অপরাধী ফোনের বিভিন্ন তথ্য চুরি করতে কিছু লোভনীয় ফিচার সমৃদ্ধ অ্যাপ তৈর করে তা ইন্টারনেটে ছড়িয়ে দেও। গুগলের প্লে স্টোর বা অ্যাপলের অ্যাপ স্টোরেও এ ধরনের অ্যাপ পাওয়া যায়।\n" +
                "বিভিন্ন আকর্ষণীয় ফিচার ব্যবহারের লোভে অনেকে তেমন কিছু না ভেবেই ফোনে এসব অ্যাপ ইন্সটল করে ফেলেন। এসব অ্যাপ আপনার জন্য হয়ে উঠতে পারে মারাত্মক বিপদের কারণ। সাইবার নিরাপত্তা বিশেষজ্ঞরা জানিয়েছেন, হ্যাকাররা প্লে স্টোরের অ্যাপে ট্রোজান, অ্যাডওয়্যার, স্পাইওয়্যার ও বিভিন্ন ম্যালওয়্যার প্রোগ্রাম আপলোড করছে, যা ফোনের ডেটা চুরি করতে সক্ষম। বেশকিছু সাইবার সিকিউরিটি বিষয়ক জার্নালে বলা হয়েছে অ্যান্ড্রয়েড স্মার্টফোনগুলো গত ১ দশকে ধরে সাইবার অপরাধীদের প্রধান টার্গেটে পরিণত হয়েছে। কারণ এটি একটি ওপেন সোর্স প্রোগ্রাম ও সহজেই পরিবর্তন করা যায়।\n" +
                "আমরা অনেকেই ব্যবহার করে থাকি এরকম বেশ কিছু জনপ্রিয় অ্যাপও ফোনের তথ্য চুরি করে থাকে। উদাহরণ হিসেবে নিচের তালিকাটি দেওয়া হল:\n\n" +
                "অ্যামেজিং ওয়ালপেপার\n" +
                "হোপ ক্যামেরা-পিকচার রেকর্ড\n" +
                "সেম লঞ্চার এবং লাইভ ওয়ালপেপার\n" +
                "কুল ইমোজি এডিটর এবং স্টিকার\n" +
                "সিম্পল নোট স্ক্যানার\n" +
                "ইউনিভার্সাল পিডিএফ স্ক্যানার\n" +
                "ব্লাড প্রেসার চেকার\n" +
                "ভ্লগ স্টার ভিডিও এডিটর\n" +
                "ওয়াও বিউটি ক্যামেরা\n" +
                "ইনস্ট্যান্ট হার্ট রেট এনিটাইম\n\n" +
                "অ্যান্ড্রয়েড ব্যবহারকারীরা গুগল প্লে স্টোরে অনেক অ্যাপের সমাহার দেখতে পান। কিন্তু, এর মধ্যে সব অ্যাপ সমান নিরাপত্তা নিশ্চিত করবে না। তাই কোনো অ্যাপ ডাউনলোড করার আগে এর রেটিং দেখা উচিৎ এবং ব্যবহারকারীদের রিভিউ পড়া উচিৎ। রিভিউ ভালো হলে তবেই ডাউনলোড করা তুলনামূলক নিরাপদ। একই ফিচারের এবং দেখতে প্রায় একই রকম অ্যাপ পেতে পারেন প্লে স্টোরে। সেক্ষেত্রে যে অ্যাপটি সবচেয়ে বেশি ডাউনলোড হয়েছে সেটি বেছে নিতে পারেন এবং অবশ্যই রেটিং ও রিভিউ দেখে নিতে ভুলবেন না।\n");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("title","তিন চাকার বৈদ্যুতিক সাইকেল এলো বাজারে");
        hashMap.put("image_url","https://techzoom.tv/wp-content/uploads/2023/08/%E0%A6%A4%E0%A6%BF%E0%A6%A8-%E0%A6%9A%E0%A6%BE%E0%A6%95%E0%A6%BE%E0%A6%B0-%E0%A6%AC%E0%A7%88%E0%A6%A6%E0%A7%8D%E0%A6%AF%E0%A7%81%E0%A6%A4%E0%A6%BF%E0%A6%95-%E0%A6%B8%E0%A6%BE%E0%A6%87%E0%A6%95%E0%A7%87%E0%A6%B2-%E0%A6%8F%E0%A6%B2%E0%A7%8B-%E0%A6%AC%E0%A6%BE%E0%A6%9C%E0%A6%BE%E0%A6%B0%E0%A7%87.jpg");
        hashMap.put("des","জ্বালানি তেলের দাম বৃদ্ধি এবং পরিবেশ দূষণ কমাতে সবাই বৈদ্যুতিক যান তৈরিতে ঝুঁকছে। এরই মধ্যে অনেক দেশেই চালু হয়েছে বৈদ্যুতিক গাড়ি, বাইক, স্কুটারের ব্যবহার। ইউরোপের অনেক দেশেই বৈদ্যুতিক গাড়ি বাধ্যতামূলক করা হচ্ছে।\n\n" +
                "সাইকেল যদিও পরিবেশবান্ধব তারপরও ব্যবহারের সুবিধায় বৈদ্যুতিক সাইকেল দিন দিন জনপ্রিয় হচ্ছে। কিছুদিন আগেই টাটা নিয়ে এসেছে তাদের বৈদ্যুতিক সাইকেল। এবার একটি বৈদ্যুতিক সাইকেল বাজারে এসছে যারা চাকা দুটি নয় তিনটি। চেহারায় বেশ আকর্ষণীয় এই বৈদ্যুতিক সাইকেলের নাম ভাইরিবাস ট্রাইক।\n\n" +
                "শক্তি উৎপাদনের জন্য রয়েছে ৩৫ভি ১০এএইচ ব্যাটারি। ফ্রন্ট হুইলে রয়েছে ২৫০ ওয়াট মোটর। এটির হাব মোটরের সর্বোচ্চ আউটপুট ৫০০ ওয়াট। সংস্থার দাবি, একবার ফুল চার্জে টানা ৪৮ কিলোমিটার ঘোরা যাবে। ঘণ্টায় ২৪ কিলোমিটার চলতে পারে সাইকেলটি। সাইকেলের যে ব্যাটারি রয়েছে তা ফুল চার্জ হতে সময় নেয় ৪ থেকে ৬ ঘণ্টা।\n\n" +
                "আরাম করে পা রাখার জন্য রয়েছে থাম্ব থ্রটেল। ওজনেও বেশ হালকা সাইকেলটি। মাত্র ৩২ কেজি ওজন এই বৈদ্যুতিক সাইকেলের। ২৪ ইঞ্চি এবং ২৬ ইঞ্চি-এই দু’ধরনের সাইজে পাওয়া যায় সাইকেলটি। সাইকেলের সঙ্গে আছে ৩.৫ ইঞ্চি ডিসপ্লে। মোটরসাইকেল ও স্কুটারের মতো এটির সামনেও রয়েছে এলইডি হেডলাইট।\n\n" +
                "৩ চাকার এই বৈদ্যুতিক সাইকেলটি ৬টি রঙের বিকল্পে পাওয়া যাবে। এরই মধ্যে ইউরোপ, আমেরিকার একাধিক দেশে বেশ জনপ্রিয় হয়ে উঠেছে এই সাইকেল। তবে ভারতে বা বাংলাদেশে কবে আসবে এই সাইকেল তা জানা যায়নি। চাইলে ই-কমার্স সাইট অ্যামাজনে অর্ডার করে কিনতে পারবেন সাইকেলটি। আন্তর্জাতিক বাজারে এর দাম ৮৯৯ ডলার। বাংলাদেশি মুদ্রায় ৯৭ হাজার টাকা।\n\n");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("title","অনলাইনে আপনার ব্যক্তিগত তথ্য পেলে জানাবে গুগল");
        hashMap.put("image_url","https://techzoom.tv/wp-content/uploads/2023/06/%E0%A6%AB%E0%A7%8B%E0%A6%A8%E0%A7%87%E0%A6%B0-%E0%A6%AC%E0%A7%8D%E0%A6%AF%E0%A6%95%E0%A7%8D%E0%A6%A4%E0%A6%BF%E0%A6%97%E0%A6%A4-%E0%A6%A4%E0%A6%A5%E0%A7%8D%E0%A6%AF.jpg");
        hashMap.put("des","নিত্যনতুন ফিচার নিয়ে আসছে গুগল। গত বছর সেপ্টেম্বরে নিয়ে এসেছিল তেমনই একটি ফিচার ‘রেজাল্ট অ্যাবাউট ইউ’। অনলাইনে আপনার কি কি তথ্য আছে সে তথ্য জানাতেই এই ফিচারে নিয়ে আসা হয়। এবার সেই ড্যাশবোর্ড আপডেট করে নতুন ফিচার যোগ করেছে গুগল।\n" +
                "\n" +
                "চারদিকে ব্যক্তিগত তথ্য ফাঁস নিয়ে যখন এতো হইচই তখন সেই ব্যক্তিগত তথ্যে খোঁজ জানাবে এই ফিচার। এই ড্যাশবোর্ডে নিজের নাম-পরিচয় দিলে সে নিজেই খোঁজার কাজটি করে দেবে। যে সব ওয়েবসাইটে এই সংক্রান্ত তথ্য রয়েছে, সেগুলো আপনার সামনে তুলে ধরা হবে। এবার আপনি সেই ওয়েব পেজগুলোতে গিয়ে দেখে নিতে পারবেন কোন তথ্য ফাঁস হয়ে গেছে। সঙ্গে সঙ্গে তা মুছে দেয়ার আবেদনও করে দিতে পারবেন।\n" +
                "\n" +
                "আগে কোনও ওয়েবসাইটে ব্যক্তিগত তথ্য খুঁজে পাওয়া গেলে তা সরিয়ে দেয়ার জন্য ম্যানুয়ালি আবেদন করতে হতো। যার ফলাফল পেতে অনেক সময় লাগতো। কিন্তু প্রযুক্তির উন্নতির সঙ্গে নিজেকেও আপডেট করেছে গুগল।\n" +
                "\n" +
                "এখন কোনো ওয়েবসাইটে আপনার ঠিকানা, ফোন নম্বর কিংবা ই-মেইল আইডি খুঁজে পাওয়া গেলে নোটিফিকেশনের মাধ্যমে তা আপনাকে নিজেই জানিয়ে দেবে গুগল। ফলে সহজেই আপনি তা মুছে ফেলার সুযোগ পাবেন।\n" +
                "\n" +
                "এতে ব্যক্তিগত তথ্য সুরক্ষিত থাকবে বলে দাবি গুগলের। প্রতারণার হাত থেকেও নিরাপদ থাকা যাবে। প্রাথমিক ভাবে এই ফিচার মার্কিন যুক্তরাষ্ট্রে চালু হয়েছে। খুব শিগগিরই এটি একাধিক ভাষায় চালু করা হবে।");
        arrayList.add(hashMap);


    }



}