package com.example.abhivandit.androidrecyclerviewinfinitescroll;

/**
 * Created by Abhivandit on 24/5/2017.
 */
import android.content.Intent;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.*;
public class RecyclerViewHolders extends RecyclerView.ViewHolder  implements View.OnClickListener {
    public ImageView displayedImage;
    public TextView textTitle;
    public RecyclerViewHolders(View itemView) {
        super(itemView);
        textTitle = (TextView)itemView.findViewById(R.id.title_header);


    }


    @Override
    public void onClick(View view) {




    }



}
 /*class kk extends AppCompatActivity {
    public  static void start(View view){
        Intent

    }

}*/