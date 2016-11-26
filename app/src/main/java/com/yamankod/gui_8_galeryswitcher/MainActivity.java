package com.yamankod.gui_8_galeryswitcher;
import android.os.Bundle;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Gallery;
import android.widget.Gallery.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher.ViewFactory;

public class MainActivity extends Activity {
    private ImageSwitcher mSwitcher;
    private Gallery galeri;
    private ImageView view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSwitcher = (ImageSwitcher) findViewById(R.id.switcher);
        mSwitcher.setFactory(new ViewFactory() {
            @Override
            public View makeView() {
                view = new ImageView(getApplicationContext());
                view.setScaleType(ImageView.ScaleType.FIT_CENTER);
                view.setLayoutParams(new ImageSwitcher.LayoutParams(
                        LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
                return view;
            }
        });
        mSwitcher.setInAnimation(AnimationUtils.loadAnimation(
                getApplicationContext(), android.R.anim.fade_in));
        mSwitcher.setOutAnimation(AnimationUtils.loadAnimation(
                getApplicationContext(), android.R.anim.fade_out));
        galeri = (Gallery) findViewById(R.id.gallery);
        galeri.setAdapter(new ImageAdapter(this));
        galeri.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View v,
                                       int position, long id) {

                mSwitcher.setImageResource(mImageIds[position]);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
    public class ImageAdapter extends BaseAdapter {
        private Context mContext;

        public ImageAdapter(Context c) {

            mContext = c;
        }
        public int getCount() {

            return mImageIds.length;
        }
        public Object getItem(int position) {

            return position;
        }
        public long getItemId(int position) {

            return position;
        }
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView i = new ImageView(mContext);
            i.setImageResource(mImageIds[position]);
            i.setAdjustViewBounds(true);
            i.setLayoutParams(new Gallery.LayoutParams(
                    LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
            i.setBackgroundResource(R.drawable.r1);
            return i;
        }
    }
    private Integer[] mImageIds = { R.drawable.r2, R.drawable.r3,
            R.drawable.r4, R.drawable.r5 };
}





