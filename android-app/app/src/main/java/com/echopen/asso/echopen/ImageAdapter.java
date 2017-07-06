package com.echopen.asso.echopen;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.File;

public class ImageAdapter extends BaseAdapter {

    private File galleryDirectory;
    private int clientId;
    private Context mContext;
    // references to our images
    private Drawable[] mThumbIds;

    public ImageAdapter(Context c, int clientId, File galleryDirectory) {
        mContext = c;
        this.clientId = clientId;
        this.galleryDirectory = galleryDirectory;
        setmThumbIds();
    }

    public Drawable[] getImages() {
        File[] allImages = (new File(this.galleryDirectory.toString() + "/" + clientId + "/")).listFiles();
        Drawable[] validImages = new Drawable[allImages.length];
        int i = 0;
        if (allImages != null) {
            for (File as : allImages) {
                //Convert bitmap to drawable
                Drawable drawable = new BitmapDrawable(mContext.getResources(), BitmapFactory.decodeFile(as.getPath()));
                validImages[i] = drawable;
                i++;
            }
        }
        return validImages;
    }

    public void setmThumbIds() {
        this.mThumbIds = getImages();
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    @Override
    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        View item = convertView;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            item = inflater.inflate(R.layout.gallery_item, parent, false);
        }
        else {
            item = (View) convertView;
        }

        ImageView galleryImage;
        TextView galleryTitle;

        galleryImage = (ImageView) item.findViewById(R.id.galleryImage);
        galleryTitle = (TextView) item.findViewById(R.id.galleryTitle);

        galleryImage.setImageDrawable(mThumbIds[position]);
        galleryTitle.setText("Hello");

        return item;
    }
}