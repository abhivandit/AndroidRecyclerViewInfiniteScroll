package com.example.abhivandit.androidrecyclerviewinfinitescroll;

/**
 * Created by Abhivandit on 26/5/2017.
 */



        import android.support.v7.widget.RecyclerView;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.RatingBar;
        import android.widget.TextView;

        import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private ArrayList<String> countries;
    private ArrayList<String> reviews;
    private ArrayList<Float> rating;

    public DataAdapter(ArrayList<String> countries,ArrayList<String> reviews,ArrayList<Float> rating) {
        this.countries = countries;
        this.reviews=reviews;
        this.rating=rating;
    }

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.new_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder viewHolder, int i) {

        viewHolder.tv_country.setText(countries.get(i));//
        viewHolder.reviews1.setText(reviews.get(i));
        viewHolder.rating1.setRating(rating.get(i));
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_country;
        private TextView reviews1;
        private RatingBar rating1;


        public ViewHolder(View view) {
            super(view);

            tv_country = (TextView) view.findViewById(R.id.reviewer_name);
            reviews1=(TextView) view.findViewById(R.id.review_msg);
            rating1=(RatingBar)view.findViewById(R.id.myRatingBar);
        }
    }
}