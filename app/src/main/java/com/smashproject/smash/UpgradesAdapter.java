package com.smashproject.smash;

import java.util.ArrayList;
    import android.content.Context;
    import android.content.res.Resources;
    import android.graphics.Bitmap;
    import android.graphics.BitmapFactory;
    import android.view.LayoutInflater;
    import android.view.View;
    import android.view.ViewGroup;
    import android.widget.ArrayAdapter;
    import android.widget.ImageView;
    import android.widget.TextView;

public class UpgradesAdapter extends ArrayAdapter<Upgrades> {
    public UpgradesAdapter(Context context, ArrayList<Upgrades> users) {
        super(context, 0, users);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Upgrades upgrades = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_upgrades, parent, false);
        }
        // Lookup view for data population
        TextView upgradeLabel = (TextView) convertView.findViewById(R.id.upgradeName);
        TextView amountLabel = (TextView) convertView.findViewById(R.id.amount);
        ImageView upgradeIcon = (ImageView) convertView.findViewById(R.id.upgradeIcon);
        //assign names and amounts to each upgrade
        upgradeLabel.setText(upgrades.upgradeName);
        amountLabel.setText(upgrades.amount);
        upgradeIcon.setImageBitmap(decodeSampledBitmapFromResource(convertView.getResources(), upgrades.icon, 100, 100));

        return convertView;
    }

    public static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) > reqHeight
                    && (halfWidth / inSampleSize) > reqWidth) {
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
    }

    public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId,
                                                         int reqWidth, int reqHeight) {

        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }
}

