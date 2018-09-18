package fash.sketch.fashzip.screen;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import fash.sketch.fashzip.R;
import fash.sketch.fashzip.adapter.AdapterPurchasedItem;


public class PlacedOrderDetails extends AppCompatActivity {

  /*  GlobalClass globalClass;
    Shared_Preference prefrence;*/
    ProgressDialog pd;
    String TAG = "placed_order";

    ImageView toolbar_back,toolbar_logo,toolbar_clock;
    TextView toolbar_title;
    ArrayList<String> product_images;
    RecyclerView list_purchased_item;
    AdapterPurchasedItem adapterPurchasedItem;
    TextView tv_delivery_add_val,tv_delivery_time;
    RelativeLayout rl_done;
    SimpleDateFormat simpleDateFormat;
    DatePickerDialog.OnDateSetListener datepicker1;
    Calendar myCalendar = Calendar.getInstance();
    String days_selected="";
    ArrayList<String> days_open = new ArrayList<>();
    ArrayList<String> cart_list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.placed_order_details);
/*
        globalClass = (GlobalClass)getApplicationContext();
        prefrence = new Shared_Preference(PlacedOrderDetails.this);
        prefrence.loadPrefrence();*/

        pd=new ProgressDialog(PlacedOrderDetails.this);
        pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        pd.setMessage("Loading");



        toolbar_title = findViewById(R.id.toolbar_title);
        toolbar_back = findViewById(R.id.toolbar_back);

        cart_list = new ArrayList<>();


        cart_list.add("Jeans");
        cart_list.add("Top");




       // toolbar_title.setText("Placed Order Details");

        toolbar_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        /////////////////////////////////////////////////////////////////////


        tv_delivery_add_val = findViewById(R.id.tv_delivery_add_val);
        rl_done = findViewById(R.id.rl_done);
        tv_delivery_time = findViewById(R.id.tv_delivery_time);

        //tv_delivery_time.setText(getIntent().getStringExtra("delivery_time"));

     //   tv_delivery_add_val.setText(globalClass.getShipping_full_address());
      //  simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

        list_purchased_item = findViewById(R.id.list_purchased_item);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        list_purchased_item.setLayoutManager(mLayoutManager);
        adapterPurchasedItem = new AdapterPurchasedItem(PlacedOrderDetails.this, cart_list);
        list_purchased_item.setAdapter(adapterPurchasedItem);



        rl_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             /*   globalClass.CART_item_list.clear();
                globalClass.setCart_no("0");
*/
                Intent intent = new Intent(PlacedOrderDetails.this,Drawer_Activity.class);
                startActivity(intent);
                finish();
            }
        });




    }

    @Override
    protected void onResume() {
        super.onResume();
       /* prefrence.loadPrefrence();
        Log.d(TAG, "getShipping_id: "+globalClass.getShipping_id());
        Log.d(TAG, "getShipping_full_address: "+globalClass.getShipping_full_address());

        tv_delivery_add_val.setText(globalClass.getShipping_full_address());*/
    }


    @Override
    public void onBackPressed() {

    }




}
