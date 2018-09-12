package fash.sketch.fashzip.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import fash.sketch.fashzip.R;

/**
 * Created by Developer on 9/11/18.
 */

public class AdapterCategory extends RecyclerView.Adapter<AdapterCategory.MyViewHolder> {


    Context context;
    ArrayList<String> list_claim;
    LayoutInflater inflater;


    public AdapterCategory(Context c, ArrayList<String> list_claim
    ) {
        this.context = c;
        this.list_claim = list_claim;

     //   globalClass = ((GlobalClass) c.getApplicationContext());

        inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);



    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_category, parent, false);
        // set the view's size, margins, paddings and layout parameters

// pass the view to View Holder
        MyViewHolder vh = new MyViewHolder(v);
        return vh;

    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {




        Picasso.with(context).load(list_claim.get(position)).
                fit().into(holder.image);


/*
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });*/
    }

    @Override
    public int getItemCount() {
        return list_claim.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        // init the item view's
        TextView name;
        ImageView image;

        public MyViewHolder(View itemView) {
            super(itemView);
            // get the reference of item view's
            name =  itemView.findViewById(R.id.name);
            image = (ImageView) itemView.findViewById(R.id.image_view);

        }
    }
}