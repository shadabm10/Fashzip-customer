package fash.sketch.fashzip.adapter;

import ss.com.bannerslider.adapters.SliderAdapter;
import ss.com.bannerslider.viewholder.ImageSlideViewHolder;

/**
 * Created by Developer on 9/10/18.
 */

public class MainSliderAdapter extends SliderAdapter {

    @Override
    public int getItemCount() {
        return 3;
    }

    @Override
    public void onBindImageSlide(int position, ImageSlideViewHolder viewHolder) {
        switch (position) {
            case 0:
                viewHolder.bindImageSlide("https://cdn.pixabay.com/photo/2015/10/30/18/04/banner-1014539_960_720.jpg");
                break;
            case 1:
                viewHolder.bindImageSlide("https://forums.oscommerce.com/uploads/monthly_04_2016/post-336856-0-18918000-1459704022.jpg");
                break;
            case 2:
                viewHolder.bindImageSlide("https://khalilcenter.com/wp-content/uploads/2015/09/article-banner.jpg");
                break;
        }
    }
}