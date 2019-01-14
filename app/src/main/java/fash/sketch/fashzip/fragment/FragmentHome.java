package fash.sketch.fashzip.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import fash.sketch.fashzip.R;
import fash.sketch.fashzip.adapter.MainSliderAdapter;
import fash.sketch.fashzip.adapter.PicassoImageLoadingService;
import fash.sketch.fashzip.adapter.RVBySizeAdapter;
import fash.sketch.fashzip.adapter.RVStoreAdapter;
import fash.sketch.fashzip.adapter.RecyclerViewHorizontalListAdapter;
import ss.com.bannerslider.Slider;
import ss.com.bannerslider.event.OnSlideClickListener;

/**
 * Created by Developer on 9/10/18.
 */

public class FragmentHome extends Fragment {


    ArrayList<String> name;
    ArrayList<String> image;
    ArrayList<Integer> array_image;
    LayoutInflater mInflater ;
    Slider slider;
    RecyclerView rv_new_collection,rv_brands,rv_stores,rv_by_size;
    RecyclerViewHorizontalListAdapter rvHorizontalAdapter;
    RVBySizeAdapter rvBySizeAdapter;
    RVStoreAdapter storeAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_home, container, false);

        initialisation(view);
        function();


        return view;
    }

    private void initialisation(View view) {

        rv_new_collection= view.findViewById(R.id.rv_new_collection);
        rv_brands= view.findViewById(R.id.rv_brands);
        rv_stores= view.findViewById(R.id.rv_stores);
        rv_by_size= view.findViewById(R.id.rv_by_size);

        slider = view.findViewById(R.id.banner_slider);
    }

    private void function() {

        name =new ArrayList<>();
        array_image = new ArrayList<>();
        image = new ArrayList<>();

        name.add("Any name");
        name.add("My name");
        name.add("yo");
        name.add("hello");
        name.add("hey");
        name.add("my");
        name.add("src");
        name.add("vxz");
        name.add("rrrd");
        name.add("ggb");

        image.add("https://cdn.pixabay.com/photo/2015/10/12/15/18/store-984393_960_720.jpg");
        image.add("https://previews.123rf.com/images/fiphoto/fiphoto1411/fiphoto141100598/34260764-le-luxe-et-la-mode-tout-nouveau-int%C3%A9rieur-du-magasin-de-tissu.jpg");
        image.add("http://www.pepage365.com/wp-content/uploads/2016/07/clothing-stores-yahoo-answers-2.jpg");
        image.add("http://www.cstylejeans.com/wp-content/uploads/2016/03/clothes-store-around-me.jpg");
        image.add("https://media.timeout.com/images/101714607/image.jpg");
        image.add("https://media.timeout.com/images/102721027/630/472/image.jpg");



        array_image.add(R.mipmap.man_96);
        array_image.add(R.mipmap.woman_96);
        array_image.add(R.mipmap.girls_96);
        array_image.add(R.mipmap.boy_96);
        array_image.add(R.mipmap.kids_96);
        array_image.add(R.mipmap.infant_96);
        array_image.add(R.mipmap.toddler_96);


        rvHorizontalAdapter = new RecyclerViewHorizontalListAdapter(name, getActivity());
        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        rv_brands.setLayoutManager(horizontalLayoutManager);
        rv_brands.setAdapter(rvHorizontalAdapter);

        rvHorizontalAdapter = new RecyclerViewHorizontalListAdapter(name, getActivity());
        LinearLayoutManager horizontalLayoutManager1 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        rv_new_collection.setLayoutManager(horizontalLayoutManager1);
        rv_new_collection.setAdapter(rvHorizontalAdapter);

        storeAdapter = new RVStoreAdapter(image, getActivity());
        LinearLayoutManager horizontalLayoutManager2 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        rv_stores.setLayoutManager(horizontalLayoutManager2);
        rv_stores.setAdapter(storeAdapter);

        rvBySizeAdapter = new RVBySizeAdapter(array_image, getActivity());
        LinearLayoutManager horizontalLayoutManager3 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        rv_by_size.setLayoutManager(horizontalLayoutManager3);
        rv_by_size.setAdapter(rvBySizeAdapter);


        Slider.init(new PicassoImageLoadingService(getActivity()));
        slider.setAdapter(new MainSliderAdapter());

        slider.setOnSlideClickListener(new OnSlideClickListener() {
            @Override
            public void onSlideClick(int position) {
                //Do what you want
            }
        });






    }


}
