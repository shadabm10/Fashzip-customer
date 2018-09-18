package fash.sketch.fashzip.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import fash.sketch.fashzip.R;

/**
 * Created by Developer on 9/10/18.
 */

public class FragmentProfile extends Fragment {
    private Toolbar toolbar;

    ImageView imageView2;
    TextView name_tv,txt_phone_no,txt_email,toolbar_save,change_pic_tv,toolbar_edit;
    EditText edt_phone_no,name_edt;
    RatingBar ratingBar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_profile, container, false);

        toolbar =  getActivity().findViewById(R.id.toolbar);


        toolbar_edit = toolbar.findViewById(R.id.toolbar_edit);
        toolbar_save = toolbar.findViewById(R.id.toolbar_save);

        imageView2 = view.findViewById(R.id.imageView2);
        name_tv = view.findViewById(R.id.name_tv);
        txt_phone_no = view.findViewById(R.id.txt_phone_no);
        txt_email = view.findViewById(R.id.txt_email);

        edt_phone_no = view.findViewById(R.id.edt_phone_no);
        name_edt = view.findViewById(R.id.name_edt);
        change_pic_tv = view.findViewById(R.id.change_pic_tv);

        ratingBar = view.findViewById(R.id.ratingBar);

        name_edt.setVisibility(View.GONE);
        change_pic_tv.setVisibility(View.GONE);
        edt_phone_no.setVisibility(View.GONE);
        toolbar_save.setVisibility(View.GONE);

        toolbar_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name_edt.setVisibility(View.VISIBLE);
                change_pic_tv.setVisibility(View.VISIBLE);
                edt_phone_no.setVisibility(View.VISIBLE);
                toolbar_save.setVisibility(View.VISIBLE);
                name_tv.setVisibility(View.GONE);
                txt_phone_no.setVisibility(View.GONE);
                toolbar_edit.setVisibility(View.GONE);
                edt_phone_no.setSelection(edt_phone_no.getText().length());
                name_edt.setSelection(name_edt.getText().length());
            }
        });


        toolbar_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name_edt.setVisibility(View.GONE);
                change_pic_tv.setVisibility(View.GONE);
                edt_phone_no.setVisibility(View.GONE);
                toolbar_save.setVisibility(View.GONE);
                name_tv.setVisibility(View.VISIBLE);
                txt_phone_no.setVisibility(View.VISIBLE);
                toolbar_edit.setVisibility(View.VISIBLE);
                InputMethodManager imm = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(edt_phone_no.getWindowToken(), 0);
                imm.hideSoftInputFromWindow(name_edt.getWindowToken(), 0);


            }
        });


        return view;
    }


}