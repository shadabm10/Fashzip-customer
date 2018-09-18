package fash.sketch.fashzip.screen;


import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import es.dmoral.toasty.Toasty;
import fash.sketch.fashzip.R;
import fash.sketch.fashzip.adapter.AdapterCart;


public class CartScreen extends AppCompatActivity {


  //  GlobalClass globalClass;
    ProgressDialog pd;
   // Shared_Preference prefrence;
    ImageView toolbar_back,toolbar_logo,toolbar_clock;
    TextView toolbar_title,tv_proceed,tv_error_msg,tv_delivery_time;

    AdapterCart adapterCart;

    RelativeLayout rl_cart_notification,rl_delivery_time;
    String TAG = "cart";
    LinearLayout empty_cart_iv;
    RelativeLayout rl_main_layout,rl_error_status;
    RecyclerView rv_cart_list;

   // ArrayList<HashMap<String,String>> cart_list;
    ArrayList<String> cart_list;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cart_screen);

       /* globalClass = (GlobalClass)getApplicationContext();
        prefrence = new Shared_Preference(CartScreen.this);
        prefrence.loadPrefrence();*/
        pd=new ProgressDialog(CartScreen.this);
        pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        pd.setMessage("Loading");

        cart_list = new ArrayList<>();

        cart_list.add("Jeans");
        cart_list.add("Top");
        cart_list.add("Shirt");
        cart_list.add("Pant");
        cart_list.add("Coat");
        cart_list.add("Shoes");


        toolbar_title = findViewById(R.id.toolbar_title);
        toolbar_back = findViewById(R.id.toolbar_back);
        tv_proceed = findViewById(R.id.tv_proceed);

        toolbar_title.setText("My Cart");
        toolbar_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        rv_cart_list = findViewById(R.id.rv_cart_list);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rv_cart_list.setLayoutManager(mLayoutManager);

        adapterCart = new AdapterCart(CartScreen.this, cart_list);
        rv_cart_list.setAdapter(adapterCart);

        tv_proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CartScreen.this,AddressScreen.class);
                startActivity(intent);
            }
        });


    }


}
