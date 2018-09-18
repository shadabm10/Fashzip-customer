package fash.sketch.fashzip.screen;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

import fash.sketch.fashzip.R;

import fash.sketch.fashzip.adapter.AdapterOrdersDetails;

/**
 * Created by Developer on 9/13/18.
 */

public class OrderDetailScreen extends AppCompatActivity{
    RecyclerView rv_order_detail_list;
    ArrayList<String> cart_list;
    AdapterOrdersDetails adapterOrdersDetails;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_detail_screen);

        ImageView toolbar_back = findViewById(R.id.toolbar_back);
        toolbar_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        cart_list = new ArrayList<>();

        cart_list.add("Jeans");
        cart_list.add("Top");



        rv_order_detail_list = findViewById(R.id.rv_order_detail_list);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rv_order_detail_list.setLayoutManager(mLayoutManager);

        adapterOrdersDetails = new AdapterOrdersDetails(OrderDetailScreen.this, cart_list);
        rv_order_detail_list.setAdapter(adapterOrdersDetails);



    }
}
