package fash.sketch.fashzip.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import fash.sketch.fashzip.R;


public class AdapterNotify extends RecyclerView.Adapter<AdapterNotify.ViewHolder>  {

    Context context;
    //ArrayList<HashMap<String,String>> cart_list;
    ArrayList<String> cart_list;

   // GlobalClass globalClass;

    private LayoutInflater mInflater;


    String TAG = "adapter_cart";




    public AdapterNotify(Context c, ArrayList<String> cart_list ) {
        this.mInflater = LayoutInflater.from(c);
        context = c;
        this.cart_list = cart_list;


       // globalClass = (GlobalClass)context.getApplicationContext();


    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.single_row_notify, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {





        holder.tv_notify_title.setText(cart_list.get(position));

       /* holder.img_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,OrderDetailScreen.class);
                intent.putExtra("position",position);
                context.startActivity(intent);
            }
        });*/

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


*/


    }


    @Override
    public int getItemCount() {
        return cart_list.size();
    }


   // stores and recycles views as they are scrolled off screen
   public class ViewHolder extends RecyclerView.ViewHolder
           implements View.OnClickListener {


       ImageView img_notify,img_arrow;
       TextView tv_notify_title;


       ViewHolder(View itemView) {
           super(itemView);

           img_notify = itemView.findViewById(R.id.img_notify);

           tv_notify_title = itemView.findViewById(R.id.tv_notify_title);





       }



       @Override
       public void onClick(View view) {
          /* if (mClickListener != null) {
               mClickListener.onItemClick(view, getAdapterPosition());


           }*/
       }
   }







}
