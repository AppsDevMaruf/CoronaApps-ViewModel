package com.marufalam.coronaapps.adapter;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.databinding.BindingAdapter;

import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomBindingAdapter {
    @BindingAdapter(value = "app:setDate")
    public static void setDate(TextView textView, long date) {
        final String dateString = new SimpleDateFormat("hh:mm:a EEE,MMM dd,yyyy")
                .format(new Date(date));
        textView.setText("" + dateString);
    }

    @BindingAdapter(value = "app:setFlagImg")
    public static void setImageUrl(ImageView imageView, String url) {
        if (url != null) {
            Picasso.get().load(url).into(imageView);
        } else {
            Picasso.get().load("https://www.logistec.com/wp-content/uploads/2017/12/placeholder.png").into(imageView);
        }
    }
}
