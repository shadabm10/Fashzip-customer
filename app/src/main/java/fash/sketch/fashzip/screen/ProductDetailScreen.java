package fash.sketch.fashzip.screen;

import android.app.ProgressDialog;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import fash.sketch.fashzip.R;


public class ProductDetailScreen extends AppCompatActivity {

   // GlobalClass globalClass;
    ProgressDialog pd;
   // Shared_Preference prefrence;
    ImageView toolbar_back,toolbar_clock;
    RelativeLayout rl_cart_notification;
    TextView toolbar_title,cart_badge;
    List<String> list;
    Spinner spinner;
    ViewPager viewPager;
    TextView tv_add_to_cart;
    String TAG = "product_detail";

    ArrayList<String> sliderImagesId = new ArrayList<>();
    ArrayList<HashMap<String,String>> cart_item_list;

    String data;
    TextView tv_product_price,tv_product_name,tv_product_capacity,tv_product_description_1;
    String product_id;
    String qty_order;
    RelativeLayout rl_add_to_cart;
  //  ImageView img_previous,img_next;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_deatil_screen);

     /*   globalClass = (GlobalClass)getApplicationContext();
        prefrence = new Shared_Preference(ProductDetailScreen.this);
        prefrence.loadPrefrence();*/
        pd=new ProgressDialog(ProductDetailScreen.this);
        pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        pd.setMessage("Loading");

        data=  getIntent().getStringExtra("data");

        toolbar_title = findViewById(R.id.toolbar_title);
        toolbar_back =  findViewById(R.id.toolbar_back);

     //   toolbar_logo =  findViewById(R.id.toolbar_logo);
        rl_cart_notification =  findViewById(R.id.rl_cart_notification);
        cart_badge =  findViewById(R.id.cart_badge);

        rl_add_to_cart =  findViewById(R.id.rl_add_to_cart);

        toolbar_title.setVisibility(View.VISIBLE);
        toolbar_back.setVisibility(View.VISIBLE);
    //    toolbar_logo.setVisibility(View.GONE);


        toolbar_title.setText("Product Detail");
        toolbar_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        rl_cart_notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProductDetailScreen.this,CartScreen.class);
                startActivity(intent);
            }
        });

        rl_add_to_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProductDetailScreen.this,CartScreen.class);
                startActivity(intent);
            }
        });
/*

        if(globalClass.getCart_no().equals("0")){
            cart_badge.setVisibility(View.GONE);
            cart_badge.setText("0");

        } else{
            cart_badge.setVisibility(View.VISIBLE);
            cart_badge.setText(globalClass.getCart_no());
        }
*/


        ///////////////////////////////////////////

        viewPager = findViewById(R.id.viewPager);
        tv_add_to_cart = findViewById(R.id.tv_add_to_cart);
        tv_product_price = findViewById(R.id.tv_product_price);
        tv_product_name = findViewById(R.id.tv_product_name);
        tv_product_capacity = findViewById(R.id.tv_product_capacity);
        tv_product_description_1 = findViewById(R.id.tv_product_description_1);
        //img_previous = findViewById(R.id.img_previous);
        //img_next = findViewById(R.id.img_next);


        list = new ArrayList<>();
        cart_item_list = new ArrayList<>();

      /*  list.add("https://cdn.pixabay.com/photo/2015/10/12/15/18/store-984393_960_720.jpg");
        list.add("https://previews.123rf.com/images/fiphoto/fiphoto1411/fiphoto141100598/34260764-le-luxe-et-la-mode-tout-nouveau-int%C3%A9rieur-du-magasin-de-tissu.jpg");
        list.add("http://www.pepage365.com/wp-content/uploads/2016/07/clothing-stores-yahoo-answers-2.jpg");
        */
        list.add("XS");
        list.add("S");
        list.add("M");
        list.add("L");
        list.add("XL");
        list.add("XXL");


        spinner = findViewById(R.id.spinner);

        ArrayAdapter<String> adp = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_item, list);
        spinner.setAdapter(adp);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            //@Override
            public void onItemSelected(AdapterView<?> parent, View arg1, int arg2, long arg3) {
                // TODO Auto-generated method stub
                String item = spinner.getItemAtPosition(0).toString();
                //Toast.makeText(spinner.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
                qty_order=spinner.getSelectedItem().toString();
            }


            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }
        });


    /*    tv_add_to_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               *//* if(globalClass.isNetworkAvailable()) {

                    Add_To_Cart();
                }else{
                    Toasty.info(ProductDetailScreen.this,getResources().getString(R.string.check_internet), Toast.LENGTH_LONG).show();
                }*//*
            }
        });*/
       // getdata();

        Log.d("slider", "sliderImagesId: "+sliderImagesId.size());
    /*    if (sliderImagesId.size()>1)
        {
            img_previous.setVisibility(View.VISIBLE);
            img_next.setVisibility(View.VISIBLE);

        }else{
            img_previous.setVisibility(View.GONE);
            img_next.setVisibility(View.GONE);
        }


        img_previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                viewPager.setCurrentItem(getItemofviewpager(-1), true);

            }
        });
        img_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(getItemofviewpager(+1), true);
            }
        });
*/
    }


   /* public void getdata(){

        try {

            JSONObject object = new JSONObject(data);
            //id = object.getString("id");


            product_id = object.optString("product_id");
            String product_name = object.optString("product_name");
            double product_price = object.optDouble("product_price");
            String product_quantity = object.optString("product_quantity");
            String product_capacity = object.optString("product_capacity");
            String product_description = object.optString("product_description");

            tv_product_name.setText(product_name);
            tv_product_price.setText(globalClass.getCurrency_symbol()+" "+ String.format("%.2f", product_price));
            tv_product_description_1.setText(product_description);
            tv_product_capacity.setText(product_capacity);

            JSONArray gallery = object.getJSONArray("gallery");
            Log.d(TAG, "gallery: "+gallery.length());
            for (int k =0 ; k <gallery.length(); k++){
                JSONObject gallery_object = gallery.optJSONObject(k);

                String id = gallery_object.optString("id");
                String product_image = gallery_object.optString("product_image");


                sliderImagesId.add(product_image);

            }
            viewPager.setAdapter(new ViewPagerAdapter(ProductDetailScreen.this, sliderImagesId));

            int p_qty = Integer.parseInt(product_quantity);

            Log.d(TAG, "p_qty: "+p_qty);
            int i=1;
            while (i<=p_qty){
               *//* System.out.println(i++);
                Log.d(TAG, "i: "+i++);*//*

                list.add(""+i++);
            }
            ArrayAdapter<String> adp = new ArrayAdapter<String>
                    (this, android.R.layout.simple_spinner_item, list);
            //adp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            spinner.setAdapter(adp);

          //  initViewpager();





        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void Add_To_Cart(){


        pd.show();

        String url = WebserviceUrl.user_add_to_cart;
        AsyncHttpClient client = new AsyncHttpClient();
        RequestParams params = new RequestParams();

        //  params.put("email", global.getEmail());


        params.put("product_id", product_id);
        params.put("product_quantity", qty_order);
        params.put("user_id", globalClass.getId());



        Log.d(TAG , "productAddToCart- " + url);
        Log.d(TAG , "productAddToCart- " + params.toString());

        int DEFAULT_TIMEOUT = 30 * 1000;
        client.setMaxRetriesAndTimeout(5 , DEFAULT_TIMEOUT);
        client.post(url, params, new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {

                Log.d(TAG, "productAddToCart- " + response.toString());

                if (response != null) {
                    try {


                       // JSONObject result = response.getJSONObject("result");
                        int status = response.optInt("status");
                        String message = response.optString("message");

                        if (status == 0){

                            Toasty.error(ProductDetailScreen.this, message, Toast.LENGTH_LONG).show();

                        }else if (status == 1){

                            cart_item_list.clear();



                            JSONObject obj_data = response.getJSONObject("data");
                            String cart_item_no = obj_data.optString("cart_item_no");
                            globalClass.setCart_no(cart_item_no);
                            cart_badge.setVisibility(View.VISIBLE);
                            cart_badge.setText(cart_item_no);
                            Log.d(TAG, "cart_item_no: "+cart_item_no);

                            JSONArray products_arr = obj_data.getJSONArray("products");


                            for (int i = 0; i < products_arr.length(); i++) {
                                JSONObject obj_cart_data = products_arr.getJSONObject(i);

                                String cart_id = obj_cart_data.optString("cart_id");
                                String product_id = obj_cart_data.optString("product_id");
                                String qty = obj_cart_data.optString("qty");
                                String product_price = obj_cart_data.optString("product_price");
                                String product_image = obj_cart_data.optString("product_image");
                                String product_name = obj_cart_data.optString("product_name");


                                HashMap<String, String> map_cart = new HashMap<String, String>();

                                map_cart.put("cart_id", cart_id);
                                map_cart.put("product_id", product_id);
                                map_cart.put("qty", qty);
                                map_cart.put("product_price", product_price);
                                map_cart.put("product_image", product_image);
                                map_cart.put("product_name", product_name);


                                cart_item_list.add(map_cart);

                                globalClass.setCART_item_list(cart_item_list);

                            }

                            if(message.equals("Product added to cart.")){
                                Toasty.success(ProductDetailScreen.this,getResources().getString(R.string.product_added_to_cart), Toast.LENGTH_SHORT).show();
                            }else if(message.equals("Cart updated.")){
                                Toasty.success(ProductDetailScreen.this,getResources().getString(R.string.cart_updated), Toast.LENGTH_SHORT).show();
                            }


                        *//*    Intent intent = new Intent(ProductDetailScreen.this,CartScreen.class);
                            startActivity(intent);*//*


                        }else {

                            Toasty.error(ProductDetailScreen.this, message, Toast.LENGTH_LONG).show();
                        }

                        pd.dismiss();

                        //    Validate_Authentication();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }



            @Override
            public void onFailure(int statusCode, Header[] headers, String res, Throwable t) {
                Log.d(TAG, "productAddToCart- " + res);

                pd.dismiss();

                android.app.AlertDialog alert = new android.app.AlertDialog.Builder(ProductDetailScreen.this).create();
                alert.setMessage(getResources().getString(R.string.server_error));
                alert.show();
            }


        });


    }*/
    @Override
    protected void onResume() {
        super.onResume();
        /*if(globalClass.getCart_no().equals("0")){
            cart_badge.setVisibility(View.GONE);
            cart_badge.setText("0");

        } else{
            cart_badge.setVisibility(View.VISIBLE);
            cart_badge.setText(globalClass.getCart_no());
        }
*/
    }


    private int getItemofviewpager(int i) {
        return viewPager.getCurrentItem() + i;
    }

}
