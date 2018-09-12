package fash.sketch.fashzip.screen;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.Typeface;

import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.provider.Settings;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableString;


import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

import android.widget.ImageView;


import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.ss.bottomnavigation.BottomNavigation;
import com.ss.bottomnavigation.events.OnSelectedItemChangeListener;

import java.util.ArrayList;

import es.dmoral.toasty.Toasty;
import fash.sketch.fashzip.R;

import fash.sketch.fashzip.fragment.FragmentHome;
import fash.sketch.fashzip.fragment.FragmentOrder;
import fash.sketch.fashzip.fragment.FragmentProfile;
import fash.sketch.fashzip.fragment.FragmentSearch;
import fash.sketch.fashzip.fragment.Frg_Boys;
import fash.sketch.fashzip.fragment.Frg_Girls;
import fash.sketch.fashzip.fragment.Frg_Kids;
import fash.sketch.fashzip.fragment.Frg_Men;
import fash.sketch.fashzip.fragment.Frg_My_Wallet;
import fash.sketch.fashzip.fragment.Frg_Reviews;
import fash.sketch.fashzip.fragment.Frg_Support;
import fash.sketch.fashzip.fragment.Frg_Women;
import fash.sketch.fashzip.utils.CustomTypefaceSpan;


/**
 * Created by ANDRIOD on 11/14/2016.
 */
public class Drawer_Activity extends AppCompatActivity {


    private DrawerLayout mDrawer;
    private Toolbar toolbar;
    private NavigationView navigationView;
    private ActionBarDrawerToggle drawerToggle;

    Fragment fragment = null;
    TextView tooltext;

    ImageView toolbar_image;
    FragmentTransaction transaction;
/*
    Global_Class global_class;
    Shared_Prefrence shared_prefrence;*/
    ProgressDialog progressBar;

    boolean doubleBackToExitPressedOnce = false;

    String device_id;
    public static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;

    BottomNavigation bottomNavigation;
    RelativeLayout rl_cart_notification;


    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);
        setContentView(R.layout.drawer_activity);


     /*   global_class = (Global_Class) getApplicationContext();
        shared_prefrence = new Shared_Prefrence(this);
        shared_prefrence.loadPrefrence();
        shared_prefrence.load_noti();*/


        progressBar = new ProgressDialog(Drawer_Activity.this);
        progressBar.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressBar.setMessage("Loading...");

        device_id = Settings.Secure.getString(getApplicationContext().getContentResolver(), Settings.Secure.ANDROID_ID);
      /*  Log.d("device_id","device_id >>>"+device_id);
        Log.d("device_id","id >>>>"+global_class.getId());*/

        bottomNavigation=findViewById(R.id.bottom_navigation);
        // Set a Toolbar to replace the ActionBar.
        toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        tooltext = toolbar.findViewById(R.id.toolbar_title);
        rl_cart_notification = toolbar.findViewById(R.id.rl_cart_notification);

       

        // Find our drawer view
        mDrawer =  findViewById(R.id.drawer_layout);
        navigationView =  findViewById(R.id.nvView);
        navigationView.setItemIconTintList(null);
        View head=navigationView.getHeaderView(0);
       // header_text = head.findViewById(R.id.header_text);
       // header_text.setText(global_class.getName());
        Menu m = navigationView.getMenu();
        for (int i = 0; i < m.size(); i++) {
            MenuItem mi = m.getItem(i);

            //the method we have create in activity
            applyFontToMenuItem(mi);
        }


        setupDrawerContent(navigationView);
        drawerToggle = setupDrawerToggle();



        DrawerLayout drawer =  findViewById(R.id.drawer_layout);



        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                    this, drawer, toolbar, R.string.drawer_open, R.string.drawer_close) {



                public void onDrawerClosed(View view) {
                    super.onDrawerClosed(view);
                    //getActionBar().setTitle(R.string.app_name);
                    InputMethodManager inputMethodManager = (InputMethodManager) Drawer_Activity.this.getSystemService(Activity.INPUT_METHOD_SERVICE);
                    inputMethodManager.hideSoftInputFromWindow(Drawer_Activity.this.getCurrentFocus().getWindowToken(), 0);
                    invalidateOptionsMenu();
                    //show_chat();
                }


                public void onDrawerOpened(View drawerView) {
                    super.onDrawerOpened(drawerView);
                    // getActionBar().setTitle("Home");
                    InputMethodManager inputMethodManager = (InputMethodManager) Drawer_Activity.this.getSystemService(Activity.INPUT_METHOD_SERVICE);
                    inputMethodManager.hideSoftInputFromWindow(Drawer_Activity.this.getCurrentFocus().getWindowToken(), 0);
                    invalidateOptionsMenu();


                  //  show_chat();
                }
            };
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        bottomNavBar();

        rl_cart_notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Drawer_Activity.this,CartScreen.class);
                startActivity(intent);
            }
        });


    }

    public void bottomNavBar(){
        bottomNavigation.setOnSelectedItemChangeListener(new OnSelectedItemChangeListener() {
            @Override
            public void onSelectedItemChanged(int itemId) {
                switch (itemId){
                    case R.id.tab_home:
                        transaction=getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.flContent,new FragmentHome());
                        break;
                    case R.id.tab_search:
                        transaction=getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.flContent,new FragmentSearch());
                        break;
                    case R.id.tab_order:
                        transaction=getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.flContent,new FragmentOrder());
                        break;
                    case R.id.tab_profile:
                        transaction=getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.flContent,new FragmentProfile());
                        break;

                }
                transaction.commit();
            }
        });
    }





    private ActionBarDrawerToggle setupDrawerToggle() {
        // NOTE: Make sure you pass in a valid toolbar reference.  ActionBarDrawToggle() does not require it
        // and will not render the hamburger icon without it.
        return new ActionBarDrawerToggle(this, mDrawer, toolbar, R.string.drawer_open, R.string.drawer_close);

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggles
        drawerToggle.onConfigurationChanged(newConfig);
    }


    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        selectDrawerItem(menuItem);
                        return true;
                    }
                });
    }


    public void selectDrawerItem(MenuItem menuItem) {



        switch (menuItem.getItemId()) {
            case R.id.nav_Women:

                fragment = new Frg_Women();

                break;
            case R.id.nav_Men:
                fragment = new Frg_Women();
                //fragment = new Frg_Men();

                break;
            case R.id.nav_Girls:
                fragment = new Frg_Women();
               // fragment = new Frg_Girls();

                break;

            case R.id.nav_Boys:
                fragment = new Frg_Women();
               // fragment = new Frg_Boys();

                break;
            case R.id.nav_Kids:
                fragment = new Frg_Women();
               // fragment = new Frg_Kids();

                break;

            case R.id.nav_My_Wallet:

                fragment = new Frg_My_Wallet();

                break;

            case R.id.nav_My_Order:
              
                fragment = new FragmentOrder();
             
                break;
            case R.id.nav_Reviews:

                fragment = new Frg_Reviews();

                break;

            case R.id.nav_Support:

                fragment = new Frg_Support();

                break;
            case R.id.nav_Logout:

                break;



            default:


        }


        if (fragment != null) {

            try {
                // fragment = (Fragment) fragmentCla0ss.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }

            // Insert the fragment by replacing any existing fragment
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();

            // Highlight the selected item has been done by NavigationView
            menuItem.setChecked(true);
            // Set action bar title

            // Close the navigation drawer
            mDrawer.closeDrawers();

        }


    }
    @Override
    protected void onResume() {

      //  show_chat();
        super.onResume();
        setupDrawerContent(navigationView);

       // Log.d("ORRRR", "Call Onresume");
    }

    @Override
    protected void onPause() {
        super.onPause();
       
      //  stopService(new Intent(this,Service_class.class));

    }


    public void checkLocationPermission(){


        // Asking user if explanation is needed
        if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                android.Manifest.permission.ACCESS_FINE_LOCATION)) {

            // Show an explanation to the user *asynchronously* -- don't block
            // this thread waiting for the user's response! After the user
            // sees the explanation, try again to request the permission.

            //Prompt the user once explanation has been shown
            ActivityCompat.requestPermissions(this,
                    new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},
                    MY_PERMISSIONS_REQUEST_LOCATION);


        } else {
            // No explanation needed, we can request the permission.
            ActivityCompat.requestPermissions(this,
                    new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},
                    MY_PERMISSIONS_REQUEST_LOCATION);
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_LOCATION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted. Do the
                    // contacts-related task you need to do.
                    if (ContextCompat.checkSelfPermission(this,
                            android.Manifest.permission.ACCESS_FINE_LOCATION)
                            == PackageManager.PERMISSION_GRANTED) {



                    }

                } else {

                    checkLocationPermission();

                    // Permission denied, Disable the functionality that depends on this permission.
                    // Toast.makeText(this, "permission denied", Toast.LENGTH_LONG).show();
                }
                return;
            }

            // other 'case' lines to check for other permissions this app might request.
            // You can add here other case statements according to your requirement.
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // The action bar home/up action should open or close the drawer.
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawer.openDrawer(GravityCompat.START);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }


    private void applyFontToMenuItem(MenuItem mi) {
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/MyriadPro-Cond.ttf");
        SpannableString mNewTitle = new SpannableString(mi.getTitle());
        mNewTitle.setSpan(new CustomTypefaceSpan("" , font), 0 , mNewTitle.length(),  Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        mi.setTitle(mNewTitle);
    }


    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;

        Toasty.info(Drawer_Activity.this,"Tap back button in order to exit", Toast.LENGTH_SHORT,true).show();
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }

}
