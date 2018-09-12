package fash.sketch.fashzip.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import fash.sketch.fashzip.R;



public class RecyclerViewHorizontalListAdapter extends  RecyclerView.Adapter<RecyclerViewHorizontalListAdapter.GroceryViewHolder>{
    ArrayList<String> name;
    Context context;

    public RecyclerViewHorizontalListAdapter( ArrayList<String> name, Context context){
        this.name= name;
        this.context = context;
    }

    @Override
    public GroceryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflate the layout file
        View groceryProductView = LayoutInflater.from(parent.getContext()).inflate(R.layout.brands_single_item, parent, false);
        GroceryViewHolder gvh = new GroceryViewHolder(groceryProductView);
        return gvh;
    }

    @Override
    public void onBindViewHolder(GroceryViewHolder holder, final int position) {
      //  holder.imageView.setImageResource(name.get(position).getProductImage());
        holder.name_tv.setText(name.get(position));

    }

    @Override
    public int getItemCount() {
        return name.size();
    }

    public class GroceryViewHolder extends RecyclerView.ViewHolder {
     //   ImageView imageView;
        TextView name_tv;
        public GroceryViewHolder(View view) {
            super(view);
            //imageView=view.findViewById(R.id.idProductImage);
            //txtview=view.findViewById(R.id.idProductName);
            name_tv= view.findViewById(R.id.name_tv);
        }
    }
}
