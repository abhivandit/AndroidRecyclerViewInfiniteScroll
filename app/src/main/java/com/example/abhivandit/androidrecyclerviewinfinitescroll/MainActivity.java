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
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.*;
import java.net.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import android.widget.ImageView;
import org.json.*;
public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private LinearLayoutManager linearLayoutManager;
    private  List<String> adapterData;
    private Handler handler;
    String myJson=null;//bring the json string here
    final String TAG_RESULTS="result";
    final String TAG_CONTACTNAME = "contactname";
    final String TAG_PRODUCTNAME = "productname";
    final String TAG_LEVEL ="level";
    final String TAG__PRICE="price";
    final String TAG_RATING="rating";
    JSONArray peoples = null;
    int offset2=0;

    ArrayList<HashMap<String, String>> personList=new ArrayList<HashMap<String,String>>();;


    private ImageView imageViewRound;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     /*  setContentView(R.layout.item_list);
        imageViewRound=(ImageView)findViewById(R.id.icon_image);
        Bitmap icon = BitmapFactory.decodeResource(getResources(),R.drawable.mypic);
        imageViewRound.setImageBitmap(icon);*/
        /*Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(),R.drawable.mypic);
        Bitmap circularBitmap = ImageConverter.getRoundedCornerBitmap(bitmap, 100);

        ImageView circularImageView = (ImageView)findViewById(R.id.icon_image);
        circularImageView.setImageBitmap(circularBitmap);*/
        setContentView(R.layout.activity_main);
        handler = new Handler();
        linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        // return the data object
        adapterData = getFirstData();


        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerViewAdapter = new RecyclerViewAdapter(MainActivity.this, adapterData, recyclerView);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerViewAdapter.setOnLoadMoreListener(new RecyclerViewAdapter.OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                adapterData.add(null);
                recyclerViewAdapter.notifyItemInserted(adapterData.size() - 1);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        adapterData.remove(adapterData.size() - 1);
                        recyclerViewAdapter.notifyItemRemoved(adapterData.size());
                        new UserLoginTask(""+offset2+"").execute();
                        try{
                       JSONObject jsonObj = new JSONObject(myJson);
                        peoples = jsonObj.getJSONArray(TAG_RESULTS);}
                        catch(Exception e){

                        }
                       for (int i = 0; i < 15; i++) {



                            adapterData.add("Item" + (adapterData.size() + 1));}

                       // adapterData.add(mystrings);

                            recyclerViewAdapter.notifyItemInserted(adapterData.size());
                        //}
                        recyclerViewAdapter.setLoaded();
                    }
                }, 2000);
                System.out.println("load");
            }
        });
    }

    private List<String> getFirstData(){
        List<String> listObject = new ArrayList<String>();
        listObject.add("one");
        listObject.add("one");
        listObject.add("one");
        listObject.add("one");
        listObject.add("one");
        listObject.add("one");
        listObject.add("one");
        listObject.add("one");
        listObject.add("one");
        listObject.add("one");
        return listObject;
    }

        class UserLoginTask extends AsyncTask<Void, Void, String> {

            private final String offset;


            UserLoginTask(String offset1) {
                offset = offset1;

            }

            @Override
            protected String doInBackground(Void... params) {
                // TODO: attempt authentication against a network service.

                String result1="";

           /* for (String credential : DUMMY_CREDENTIALS) {
                String[] pieces = credential.split(":");
                if (pieces[0].equals(mEmail)) {
                    // Account exists, return true if the password matches.
                    return pieces[1].equals(mPassword);
                }
            }*/
                try {
                    URL url = new URL("http://192.168.0.105/data.php");
                    String data = URLEncoder.encode("offset", "UTF-8")
                            + "=" + URLEncoder.encode(offset, "UTF-8");

                    URLConnection conn = url.openConnection();
                    conn.setDoOutput(true);

                    OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());

                    wr.write(data);
                    wr.flush();

                    BufferedReader in = new BufferedReader(new
                            InputStreamReader(conn.getInputStream()));

                    StringBuilder sb = new StringBuilder();
                    String line = null;

                    // Read Server Response
                    while ((line = in.readLine()) != null) {
                        sb.append(line + "\n");
                        // break;
                    }


                //result1=
                return sb.toString();
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
                myJson=result;
            }

        }


}
