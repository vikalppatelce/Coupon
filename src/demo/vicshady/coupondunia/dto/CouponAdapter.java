package demo.vicshady.coupondunia.dto;

import java.util.ArrayList;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import demo.vicshady.coupondunia.R;

public class CouponAdapter extends BaseAdapter {

	Context context = null;
    ArrayList<CouponsDTO> coupons = null;
    DisplayImageOptions options;
    ImageLoader imageLoader;
    
    public CouponAdapter(Context context, ArrayList<CouponsDTO> coupons, ImageLoader imageLoader, DisplayImageOptions options) {
        this.context = context;
        this.coupons = coupons;
        this.options = options;
        this.imageLoader = imageLoader;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return coupons.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
//        return coupons.get(position).getTitle();
    	return coupons.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }
    
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub

        View v;
        final TextView desc1, desc2, per,suc;
        final ImageView imgcoupon;
        if (convertView == null) {
            LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = li.inflate(R.layout.collection_item, null);

        } else {
            v = convertView;
        }
        
        imgcoupon = (ImageView) v.findViewById(R.id.coll_img_coupon);
        desc1 = (TextView) v.findViewById(R.id.coll_desc_1);
        desc2 = (TextView) v.findViewById(R.id.coll_desc_2);
        per = (TextView) v.findViewById(R.id.coll_succ_1);
        suc = (TextView) v.findViewById(R.id.coll_succ_2);
        
        ((Activity) context).runOnUiThread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                desc1.setText(coupons.get(position).getTitle());
                desc2.setText(coupons.get(position).getTitle());
                per.setText(coupons.get(position).getCountSuccess()+"%");
//                suc.setText(coupons.get(position).getCountSuccess().toUpperCase());
                
                imageLoader.displayImage(coupons.get(position).getImageURL(), imgcoupon, options);
            }
        });

        return v;
    }
}
