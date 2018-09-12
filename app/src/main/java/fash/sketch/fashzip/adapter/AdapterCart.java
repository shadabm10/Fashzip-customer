package fash.sketch.fashzip.adapter;

import android.app.ProgressDialog;
import android.content.Context;

import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import fash.sketch.fashzip.R;


public class AdapterCart extends RecyclerView.Adapter<AdapterCart.ViewHolder>  {

    Context context;
    //ArrayList<HashMap<String,String>> cart_list;
    ArrayList<String> cart_list;

   // GlobalClass globalClass;

    private LayoutInflater mInflater;


    String TAG = "adapter_cart";


    List<String> list = new ArrayList<>();
    List<String> list_qty= new ArrayList<>();

    public AdapterCart(Context c, ArrayList<String> cart_list ) {
        this.mInflater = LayoutInflater.from(c);
        context = c;
        this.cart_list = cart_list;


       // globalClass = (GlobalClass)context.getApplicationContext();

        list = new ArrayList<>();

        list.add("XS");
        list.add("S");
        list.add("M");
        list.add("L");
        list.add("XL");
        list.add("XXL");

        list_qty.add("1");
        list_qty.add("2");
        list_qty.add("3");
        list_qty.add("4");
        list_qty.add("5");
        list_qty.add("6");

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.cart_single_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {




        spinner_size(holder);
        spinner_qty(holder);

        holder.tv_product_name.setText(cart_list.get(position));

       /* SpannableString mySpannableString = new SpannableString(context.getResources().getString(R.string.Qty)
                +" "+cart_list.get(position).get("qty")
                +" "+context.getResources().getString(R.string.pcs));

        mySpannableString.setSpan(new UnderlineSpan(), 0, mySpannableString.length(), 0);
        holder.tv_product_des.setText(mySpannableString);*/

      /*  holder.tv_product_id.setText(context.getResources().getString(R.string.product_id)+cart_list.get(position).get("productId"));
        holder.tv_product_name.setText(cart_list.get(position).get("product_name"));
      //  holder.tv_product_des.setText(context.getResources().getString(R.string.Qty)+" "+cart_list.get(position).get("qty")+" "+context.getResources().getString(R.string.pcs));
        holder.tv_product_price.setText(context.getResources().getString(R.string.currency_symbol)+" "+ cart_list.get(position).get("product_price"));
        loader.displayImage(cart_list.get(position).get("product_image"), holder.img_product , defaultOptions);
*/
/*

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,ProductDetailScreen.class);
                intent.putExtra("position",position);
                context.startActivity(intent);
            }
        });
*/


    }


    @Override
    public int getItemCount() {
        return cart_list.size();
    }


   // stores and recycles views as they are scrolled off screen
   public class ViewHolder extends RecyclerView.ViewHolder
           implements View.OnClickListener {


       ImageView img_product;
       TextView tv_product_name,tv_product_des,tv_product_price,tv_product_id;
       Spinner spinner_qty,spinner_size;

       ViewHolder(View itemView) {
           super(itemView);

           img_product = itemView.findViewById(R.id.img_product);
           //tv_product_id = itemView.findViewById(R.id.tv_product_id);
           tv_product_name = itemView.findViewById(R.id.tv_product_name);
           tv_product_des = itemView.findViewById(R.id.tv_product_des);
           tv_product_price = itemView.findViewById(R.id.tv_product_price);
           spinner_qty = itemView.findViewById(R.id.spinner_qty);
           spinner_size = itemView.findViewById(R.id.spinner_size);




       }



       @Override
       public void onClick(View view) {
          /* if (mClickListener != null) {
               mClickListener.onItemClick(view, getAdapterPosition());


           }*/
       }
   }





    private void spinner_size(final ViewHolder holder){

        ArrayAdapter<String> adp = new ArrayAdapter<String>
                (context, android.R.layout.simple_spinner_item, list);
        holder.spinner_size.setAdapter(adp);

        holder.spinner_size.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            //@Override
            public void onItemSelected(AdapterView<?> parent, View arg1, int arg2, long arg3) {
                // TODO Auto-generated method stub
                String item = holder.spinner_qty.getItemAtPosition(0).toString();
                //Toast.makeText(spinner.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
                //qty_order=holder.spinner_qty.getSelectedItem().toString();
            }


            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }
        });


    }

    private void spinner_qty(final ViewHolder holder){

        ArrayAdapter<String> adp = new ArrayAdapter<String>
                (context, android.R.layout.simple_spinner_item, list_qty);
        holder.spinner_qty.setAdapter(adp);

        holder.spinner_qty.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            //@Override
            public void onItemSelected(AdapterView<?> parent, View arg1, int arg2, long arg3) {
                // TODO Auto-generated method stub
                String item = holder.spinner_qty.getItemAtPosition(0).toString();
                //Toast.makeText(spinner.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
                //qty_order=holder.spinner_qty.getSelectedItem().toString();
            }


            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }
        });


    }

}
