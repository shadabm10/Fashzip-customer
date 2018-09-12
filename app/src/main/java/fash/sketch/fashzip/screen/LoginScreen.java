package fash.sketch.fashzip.screen;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


import fash.sketch.fashzip.R;


/**
 * Created by Developer on 2/14/18.
 */
public class LoginScreen extends AppCompatActivity {

    TextView tv_sign_up,tv_login,tv_forget_pass;
    String TAG = "login_screen";
 /*   Global_Class globalClass;
    Shared_Prefrence prefrence;*/
    EditText input_email,input_password;
    ProgressDialog pd;
    String device_id;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginscreen);

      /*  globalClass = (Global_Class)getApplicationContext();
        prefrence = new Shared_Prefrence(LoginScreen.this);
        prefrence.loadPrefrence();*/
        pd=new ProgressDialog(LoginScreen.this);
        pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        pd.setMessage("Loading...");

     //   device_id = Secure.getString(getContentResolver(), Secure.ANDROID_ID);
        Log.d(TAG, "device_id: "+device_id);
     //   globalClass.setDeviceid(device_id);

        input_email = findViewById(R.id.input_email);
        input_password = findViewById(R.id.input_password);
        tv_sign_up =  findViewById(R.id.tv_sign_up);
        tv_login =  findViewById(R.id.tv_login);
        tv_forget_pass =  findViewById(R.id.tv_forget_pass);


        tv_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginScreen.this, Drawer_Activity.class);
                startActivity(intent);


            }
        });
        tv_sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginScreen.this, Signup.class);
                startActivity(intent);
            }
        });





    }





}
