package fash.sketch.fashzip.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import fash.sketch.fashzip.R;
import fash.sketch.fashzip.adapter.AdapterCart;
import fash.sketch.fashzip.adapter.AdapterOrders;
import fash.sketch.fashzip.screen.CartScreen;

/**
 * Created by Developer on 9/10/18.
 */

public class FragmentOrder extends Fragment {
    RecyclerView rv_order_list;
    ArrayList<String> cart_list;
    AdapterOrders adapterOrders;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_order, container, false);

        cart_list = new ArrayList<>();

        cart_list.add("Jeans");
        cart_list.add("Top");
        cart_list.add("Shirt");
        cart_list.add("Pant");
        cart_list.add("Coat");
        cart_list.add("Shoes");


        rv_order_list = view.findViewById(R.id.rv_order_list);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        rv_order_list.setLayoutManager(mLayoutManager);

        adapterOrders = new AdapterOrders(getActivity(), cart_list);
        rv_order_list.setAdapter(adapterOrders);


        return view;
    }
}
