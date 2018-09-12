package fash.sketch.fashzip.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import fash.sketch.fashzip.R;
import fash.sketch.fashzip.adapter.AdapterCategory;

/**
 * Created by Developer on 9/11/18.
 */

public class Frg_Women extends Fragment {

    RecyclerView rv_category;
    ArrayList<String> image;
    AdapterCategory adapterCategory;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_category, container, false);

        image = new ArrayList<>();

        image.add("https://ae01.alicdn.com/kf/HTB16FuNPFXXXXXZXpXXq6xXFXXXZ/2017-Autumn-Winter-Hot-Sale-Ladies-Female-Lapel-Long-Sleeve-Casual-Plaid-Shirt-Women-Slim-Outerwear.jpg_640x640.jpg");
        image.add("https://bfme-prod.s3.ap-south-1.amazonaws.com/Storage/Shop/1446/Products/26388/Woman-Plaid-Black-White-Crop-Top-Long-Sleeve-T-Shirt-Pid-26388-77856ef6b15f973.jpg");
        image.add("https://image.dhgate.com/0x0/f2/albu/g5/M00/AB/A9/rBVaJFgypKWAYN79AAOndQvvCdY184.jpg");
        image.add("https://anf.scene7.com/is/image/anf/anf_221774_01_model1?$product-anf-v1$&wid=347&hei=438");
        image.add("https://5.imimg.com/data5/VB/RX/MY-2/pm-48-500x500.jpg");
        image.add("https://i.pinimg.com/736x/c0/1c/5e/c01c5e644d33d111eab3e310f471a688--patchwork-dress-dress-formal.jpg");
        image.add("https://my-live-01.slatic.net/original/26b80023bdcf19f6ab41f1cb299e61f8.jpg");
        image.add("http://www.rimmington-electrical.co.uk/image/cache/data/category_75/women-and-039-s-shoes-velvet-flat-heel-mary-pointed-toe-flats-office-and-career-dress-1137-500x500_0.jpg");
        image.add("https://www.dhresource.com/0x0s/f2-albu-g1-M01-5F-7F-rBVaGVZftKSARMvKAA0Uk7Tb4jA959.jpg/gros-gros-gothique-gros-pierre-gemme-noir.jpg");


        rv_category = view.findViewById(R.id.rv_category);
        rv_category.setNestedScrollingEnabled(false);
        rv_category.setLayoutManager(new GridLayoutManager(getActivity(), 3));

        adapterCategory = new AdapterCategory(getActivity(),image);
        rv_category.setAdapter(adapterCategory);

        return view;
    }
}
