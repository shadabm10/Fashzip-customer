package fash.sketch.fashzip.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.HashMap;

import fash.sketch.fashzip.R;

public class AdapterPurchasedItem extends RecyclerView.Adapter<AdapterPurchasedItem.ViewHolder> {

    Context mContext;
   // ArrayList<HashMap<String,String>> cart_list = new ArrayList<>();
    ArrayList<String> cart_list;
    LayoutInflater inflater;

   // GlobalClass globalClass;

    public AdapterPurchasedItem(Context c,  ArrayList<String> cart_list ) {
        this.inflater = LayoutInflater.from(c);
        mContext = c;
        this.cart_list = cart_list;

      //  globalClass = (GlobalClass)mContext.getApplicationContext();

        // custom_font = Typeface.createFromAsset(mContext.getAssets(),  "fonts/open_sans_light.ttf");
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.purchased_single_row, parent, false);
        return new AdapterPurchasedItem.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        int po = position+1;
        holder.tv_sl.setText(String.valueOf(po));
        holder.tv_des .setText(cart_list.get(position));
/*
        holder.tv_des.setText(cart_list.get(position).get("product_name"));
        holder.tv_qty.setText(cart_list.get(position).get("qty"));
        holder.tv_product_price.setText(globalClass.getCurrency_symbol()+" "+cart_list.get(position).get("product_price"));
        loader.displayImage(cart_list.get(position).get("product_image"), holder.img_product , defaultOptions);*/

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

        ImageView img_product;
        TextView tv_sl,tv_des,tv_qty,tv_product_price;

        ViewHolder(View itemView) {
            super(itemView);



            img_product = itemView.findViewById(R.id.img_product);
            tv_sl = itemView.findViewById(R.id.tv_sl);
            tv_des = itemView.findViewById(R.id.tv_des);
            tv_qty = itemView.findViewById(R.id.tv_qty);
            tv_product_price = itemView.findViewById(R.id.tv_price);





        }


    }


}

