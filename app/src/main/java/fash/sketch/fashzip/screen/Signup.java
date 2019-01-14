package fash.sketch.fashzip.screen;

import android.app.ProgressDialog;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;

import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


import fash.sketch.fashzip.R;


/**
 * Created by Developer on 2/14/18.
 */
public class Signup extends AppCompatActivity {

    EditText input_user,input_email,input_password,input_con_password,input_mobile;
    CheckBox checkbox_terms;
    TextView tv_login;
   /* Global_Class globalClass;
    Shared_Prefrence prefrence;*/
    ProgressDialog pd;
    String TAG = "Signup";
    ImageView img_eye_1, img_eye_2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

     /*   globalClass = (Global_Class)getApplicationContext();
        prefrence = new Shared_Prefrence(Signup.this);*/
        pd=new ProgressDialog(Signup.this);
        pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        pd.setMessage("Loading...");

        input_user = findViewById(R.id.input_user);
        input_email = findViewById(R.id.input_email);
        input_password = findViewById(R.id.input_password);

        input_mobile = findViewById(R.id.input_mobile);

        tv_login = findViewById(R.id.tv_login);

        tv_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });



    }

}
