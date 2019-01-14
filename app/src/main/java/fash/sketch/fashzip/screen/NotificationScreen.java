package fash.sketch.fashzip.screen;

import android.app.Notification;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import fash.sketch.fashzip.R;
import fash.sketch.fashzip.adapter.AdapterNotify;
import fash.sketch.fashzip.adapter.AdapterOrdersDetails;

/**
 * Created by Developer on 9/14/18.
 */

public class NotificationScreen extends AppCompatActivity {

    RecyclerView rv_notify;
    ArrayList<String> cart_list;
    AdapterNotify adapterNotify;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification_screen);

        ImageView toolbar_back = findViewById(R.id.toolbar_back);
        toolbar_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        cart_list = new ArrayList<>();

        cart_list.add("Notification 1");
        cart_list.add("Notification 2");



        rv_notify = findViewById(R.id.rv_notify);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rv_notify.setLayoutManager(mLayoutManager);

        adapterNotify = new AdapterNotify(NotificationScreen.this, cart_list);
        rv_notify.setAdapter(adapterNotify);



    }
}
