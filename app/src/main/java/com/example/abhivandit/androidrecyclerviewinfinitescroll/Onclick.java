package com.example.abhivandit.androidrecyclerviewinfinitescroll;



import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.io.*;
import java.lang.reflect.Array;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.*;
import java.net.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import android.widget.ImageView;
import org.json.*;
import android.content.Intent;
import android.widget.TextView;
 public class Onclick extends AppCompatActivity {
  private ArrayList countries = new ArrayList<>();
  private ArrayList reviews = new ArrayList<>();
  private ArrayList ratings = new ArrayList<>();
  String myJson = null;//bring the json string here
  final String TAG_RESULTS = "result";
  final String TAG_CONTACTNAME = "contactname";
  final String TAG_PRODUCTNAME = "productname";
  final String TAG_LEVEL = "level";
  final String TAG__PRICE = "price";
  final String TAG_RATING = "rating";
  JSONArray peoples = null;
  JSONObject jsonObj;
  JSONArray jsonArray;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
   super.onCreate(savedInstanceState);
   setContentView(R.layout.new_layout);
   Intent intent = this.getIntent();
   System.out.println("hjdjhd");

  /* Obtain String from Intent  */
   if (intent != null) {
    String strdata = intent.getExtras().getString("contactname");
    TextView text = (TextView) findViewById(R.id.title_header);
    text.setText(strdata);
    // DO SOMETHING HERE
   } else {
    // DO SOMETHING HERE


   }
   initViews();

  }

  private void initViews() {

   RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
   recyclerView.setHasFixedSize(true);
   RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
   recyclerView.setLayoutManager(layoutManager);

 new UserLoginTask().execute();

   /*countries.add("Australia");
   countries.add("India");
   countries.add("United States of America");
   countries.add("Germany");
   countries.add("Russia");
   countries.add("awdad");
   countries.add("adkhahbdkahdkj");
   countries.add("dfjenadlad");
   countries.add("dadadadadad");
   countries.add("dkjadjajd");
   for(int i=1;i<=10;i++){
    countries.add("adjadadjjdl");
   }*/
   RecyclerView.Adapter adapter = new DataAdapter(countries, reviews, ratings);
   recyclerView.setAdapter(adapter);


  }


   class UserLoginTask extends AsyncTask<Void, Void, String> {


    @Override
    protected String doInBackground(Void... params) {
     // TODO: attempt authentication against a network service.


           /* for (String credential : DUMMY_CREDENTIALS) {
                String[] pieces = credential.split(":");
                if (pieces[0].equals(mEmail)) {
                    // Account exists, return true if the password matches.
                    return pieces[1].equals(mPassword);
                }
            }*/
     try {
      URL url = new URL("http://192.168.0.105/work2.php");

     /* System.out.println("kk");
      URLConnection conn = url.openConnection();

      System.out.println("finally");


      conn.setDoOutput(false);
         conn.setDoInput(true);
System.out.println("ddd");

      BufferedReader in = new BufferedReader(new
              InputStreamReader(conn.getInputStream()));

      StringBuilder sb = new StringBuilder();
      String line = null;
System.out.println("finally2");
      // Read Server Response
      while ((line = in.readLine()) != null) {
       sb.append(line + "\n");
       // break;
      }*/
     System.out.println("hurray");
String ss="{\"results\":[{\"username\":\"anjana\",\"reviews\":\"Ray is true professional-- on time, polished, prepared, helpful and extremely easy to work with. We hosted a retro theme cocktail party for 40 guests this spring ray was our bartender, everyone was very impressed\",\"rating\":\"3\"},{\"username\":\"rammohan\",\"reviews\":\"Ray is true professional-- on time, polished, prepared, helpful and extremely easy to work with. We hosted a retro theme cocktail party for 40 guests this spring ray was our bartender, everyone was very impressed\",\"rating\":\"2.5\"}]}";
      return ss;
     } catch (Exception e) {
      return new String(e.getMessage());
     }

    }

    @Override
    protected void onPostExecute(String result) {

     // } else {
             /*   mPasswordView.setError(getString(R.string.error_incorrect_password));
                mPasswordView.requestFocus();
                status.setText(result);*/
     // }

     //
     myJson = result;
     System.out.println(myJson);
     try {
      jsonObj = new JSONObject(myJson);
      jsonArray = jsonObj.optJSONArray("results");
      for (int i = 0; i < jsonArray.length(); i++) {
       JSONObject jsonObject = jsonArray.getJSONObject(i);

       String username = jsonObject.optString("username").toString();
       countries.add(username);
       String reviews1 = jsonObject.optString("reviews").toString();
       reviews.add(reviews1);
       float rating1 = Float.parseFloat(jsonObject.optString("rating").toString());
       ratings.add(rating1);


     }


     } catch (Exception e) {
      System.out.println("errpr");
     }


    }

   }
  }





