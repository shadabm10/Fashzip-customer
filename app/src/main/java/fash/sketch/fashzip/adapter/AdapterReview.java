package fash.sketch.fashzip.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.HashMap;

import fash.sketch.fashzip.R;


public class AdapterReview extends RecyclerView.Adapter<AdapterReview.ViewHolder> {

    Context mContext;
   // ArrayList<HashMap<String,String>> cart_list;
   ArrayList<String> cart_list;
    LayoutInflater inflater;
  //  ImageLoader loader;

    String TAG = "adapterhistory";

  /*  DisplayImageOptions defaultOptions;
    GlobalClass globalClass;*/

    public AdapterReview(Context c, ArrayList<String> cart_list) {
        this.inflater = LayoutInflater.from(c);
        mContext = c;
        this.cart_list = cart_list;

    //    globalClass = (GlobalClass)mContext.getApplicationContext();

        // custom_font = Typeface.createFromAsset(mContext.getAssets(),  "fonts/open_sans_light.ttf");
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.single_row_review, parent, false);
        return new AdapterReview.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        holder.tv_product_name.setText(cart_list.get(position));


      /*  String delivery_boy_name =cart_list.get(position).get("fname") +" "+cart_list.get(position).get("lname");
        String rating_val = cart_list.get(position).get("rating");

        holder.tv_order_id.setText(cart_list.get(position).get("id"));
        holder.tv_customer_name.setText(delivery_boy_name);
        holder.tv_product_name.setText(cart_list.get(position).get("product_name"));
        holder.tv_order_date.setText(cart_list.get(position).get("order_placed_on"));*/



/*

        if(rating_val.equals("0")){
            holder.tv_review.setVisibility(View.VISIBLE);
            holder.rl_rating.setVisibility(View.GONE);
        }else{
            holder.tv_review.setVisibility(View.GONE);
            holder.rl_rating.setVisibility(View.VISIBLE);
            holder.rating.setRating(Float.parseFloat(rating_val));

        }
*/

        holder.tv_review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            /*    Intent intent = new Intent(mContext, RatingScreen.class);
                intent.putExtra("order_id",cart_list.get(position).get("id"));
                intent.putExtra("deliveryboy_id",cart_list.get(position).get("deliveryboy_id"));

                mContext.startActivity(intent);*/
            }
        });


      /*  holder.tv_qty.setText(cart_list.get(position).get("product_quantity"));
        holder.tv_address.setText(cart_list.get(position).get("address"));



        if(status.equals("order_cancelled")){
            holder.tv_order_status.setText("Cancelled");
            holder.tv_order_status.setTextColor(mContext.getResources().getColor(R.color.red));

        }else if(status.equals("order_completed")){
            holder.tv_order_status.setText("Completed");
            holder.tv_order_status.setTextColor(mContext.getResources().getColor(R.color.green));
        }else{
            holder.tv_order_status.setText("");
        }
*/




        /*  holder.tv_apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = cart_list.get(position).get("id");
                String discount_amount = cart_list.get(position).get("discount_amount");
               // verify_coupon(id,discount_amount);
            }
        });*/


    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return cart_list.size();
    }



    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_order_date,tv_product_name,tv_customer_name,
                tv_review,tv_order_id;

        RatingBar rating;
        RelativeLayout rl_rating;

        ViewHolder(View itemView) {
            super(itemView);



            tv_order_id = itemView.findViewById(R.id.tv_order_id);
            tv_review = itemView.findViewById(R.id.tv_review);
            tv_product_name = itemView.findViewById(R.id.tv_product_name);
            tv_order_date = itemView.findViewById(R.id.tv_order_date);
            tv_customer_name = itemView.findViewById(R.id.tv_customer_name);
            rl_rating = itemView.findViewById(R.id.rl_rating);

            rating = itemView.findViewById(R.id.rating);





        }



    }

}

