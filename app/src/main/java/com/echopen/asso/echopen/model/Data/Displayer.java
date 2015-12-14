package com.echopen.asso.echopen.model.Data;

import android.app.Activity;
import android.content.res.AssetManager;

import com.echopen.asso.echopen.preproc.ScanConversion;
import com.echopen.asso.echopen.ui.MainActionController;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * This class connects with the UI of the MainActivity
 * handled by the MainActionController class. This is the parent of the classes that displays
 * image from data
 *
 * @todo implement a code pattern protocol-agnostic. Indeed, this should store the generic variables and methods
 * that will be inherited by classes that will be protocol specific. See UDPToBitmapDisplayer class for an example
 * of a class that  displays image from UDP data
 */
public class Displayer {

    /* The MainActivity variable */
    protected Activity activity;

    /* Holds the main elementes of UI of MainActivity */
    protected MainActionController mainActionController;

    /* As for testing purpose, this is used when simulated data is taken from csv file */
    protected InputStreamReader inputStreamReader;

    /* Incoming data is transformed into pixels array via the ScanConversion class */
    protected ScanConversion scanConversion;

    /**
     * @param activity, practically the MainActivity
     * @param mainActionController, holds the UI of the MainActivity
     */
    public Displayer(Activity activity, MainActionController mainActionController) {
        this.activity = activity;
        this.mainActionController =  mainActionController;
        setAssetManager(activity);
    }

    /**
     * As for testing purpose, this is used when simulated data is taken from csv file
     * @param activity, practically the MainActivity
     */
    private void setAssetManager(Activity activity) {
        AssetManager assetManager = activity.getResources().getAssets();
        try {
            InputStream inputStream = assetManager.open("data/raw_data/redpitaya_phantom.csv");
            inputStreamReader = new InputStreamReader(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
