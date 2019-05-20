package com.example.dzienniktreningowy.tools;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class GUITools {
    private static Context appContext;

    public static void toast(final String text) {
        Handler handler = new Handler(Looper.getMainLooper());
        handler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(appContext, text, Toast.LENGTH_SHORT).show();
            }
        });
    }
    public static void setAppContext(Context appContext) {
        GUITools.appContext = appContext;
    }
    public static Context getAppContext(){
        return appContext;
    }

    @NonNull
    public  static ArrayAdapter provideStandardListAdapter(Context applicationContext, ArrayList<String> lista) {
        return new ArrayAdapter(applicationContext,
                android.R.layout.simple_list_item_1, lista){
            @Override
            public View getView(int position, View convertView, ViewGroup parent){
                // Get the Item from ListView
                View view = super.getView(position, convertView, parent);

                // Initialize a TextView for ListView each Item
                TextView tv = (TextView) view.findViewById(android.R.id.text1);

                // Set the text color of TextView (ListView Item)
                tv.setTextColor(Color.BLACK);

                // Generate ListView Item using TextView
                return view;
            }
        };
    }

    public static void showYouTubeVideo(final String address){
        Intent startYT = new Intent(Intent.ACTION_VIEW, Uri.parse(address));
        startYT.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        appContext.startActivity(startYT);
    }
}
