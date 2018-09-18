package fash.sketch.fashzip.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import fash.sketch.fashzip.R;
import fash.sketch.fashzip.screen.CategoryScreen;


public class RVBySizeAdapter extends  RecyclerView.Adapter<RVBySizeAdapter.ViewHolder>{
    ArrayList<Integer> array_image;
    Context context;

    public RVBySizeAdapter(ArrayList<Integer> array_image, Context context){
        this.array_image= array_image;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflate the layout file
        View groceryProductView = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row_brands, parent, false);
        ViewHolder gvh = new ViewHolder(groceryProductView);
        return gvh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
      //  holder.imageView.setImageResource(name.get(position).getProductImage());
        holder.image_view.setImageResource(array_image.get(position));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,CategoryScreen.class);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return array_image.size();
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
