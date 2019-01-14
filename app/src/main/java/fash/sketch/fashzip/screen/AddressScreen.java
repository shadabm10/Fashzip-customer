package fash.sketch.fashzip.screen;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import fash.sketch.fashzip.R;

/**
 * Created by Developer on 9/14/18.
 */

public class AddressScreen extends AppCompatActivity{
    TextView tv_add_new_address,tv_proceed;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.address_screen);

        ImageView toolbar_back = findViewById(R.id.toolbar_back);
        toolbar_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        tv_add_new_address = findViewById(R.id.tv_add_new_address);
        tv_proceed = findViewById(R.id.tv_proceed);

        tv_add_new_address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddressScreen.this,AddNewAddressScreen.class);
                startActivity(intent);
            }
        });

        tv_proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddressScreen.this,PaymentScreen.class);
                startActivity(intent);
            }
        });
    }
}
