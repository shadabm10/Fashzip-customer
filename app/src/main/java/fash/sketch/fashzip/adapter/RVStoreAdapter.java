package fash.sketch.fashzip.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import fash.sketch.fashzip.R;


public class RVStoreAdapter extends  RecyclerView.Adapter<RVStoreAdapter.ViewHolder>{
    ArrayList<String> image;
    Context context;

    public RVStoreAdapter(ArrayList<String> image, Context context){
        this.image= image;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflate the layout file
        View groceryProductView = LayoutInflater.from(parent.getContext()).inflate(R.layout.brands_single_item, parent, false);
        ViewHolder gvh = new ViewHolder(groceryProductView);
        return gvh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
      //  holder.imageView.setImageResource(name.get(position).getProductImage());
     //   holder.image_view.setImageResource(image.get(position).);

        //Picasso.with(context).load(image.get(position)).into(holder.image_view);
        Picasso.with(context).load(image.get(position)).
                fit().into(holder.image_view);

    }


    @Override
    public int getItemCount() {
        return image.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
     //   ImageView imageView;
        TextView name_tv;
        ImageView image_view;
        public ViewHolder(View view) {
            super(view);
            image_view=view.findViewById(R.id.image_view);
            name_tv= view.findViewById(R.id.name_tv);
        }
    }
}
