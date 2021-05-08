package com.example.edukacine2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import java.util.Arrays;

public class ImageAdapter extends BaseAdapter {
    public Context mContext;
    public Integer[] arrToDisplay;

    public ImageAdapter(Context c,  int kiekis) {
        this.mContext = c;
        arrToDisplay = Arrays.copyOfRange(mThumbIds, 0, kiekis);
    }

    public int getCount() {
        return arrToDisplay.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;

        if (convertView == null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(250, 250));
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            imageView.setPadding(10, 10, 10, 10);
        }
        else
        {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(arrToDisplay[position]);
        return imageView;
    }

    public Integer[] mThumbIds = {
            R.drawable.balionaitrys, R.drawable.bananaitrys,
            R.drawable.debesysdu, R.drawable.delfinaidu,
            R.drawable.dviratis, R.drawable.gelestrys,
            R.drawable.gile, R.drawable.grybaitrys,
            R.drawable.kate, R.drawable.kiskis,
            R.drawable.knygosdvi, R.drawable.kede,
            R.drawable.lape, R.drawable.masina,
            R.drawable.trysledai, R.drawable.tulpestrys,
            R.drawable.trophy
    };
}
