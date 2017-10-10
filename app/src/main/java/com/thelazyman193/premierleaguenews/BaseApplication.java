package com.thelazyman193.premierleaguenews;

import android.app.Application;

import com.thelazyman193.premierleaguenews.utils.FontsOverride;

/**
 * Created by hungvu on 8/28/2017.
 * Project PremierLeagueNews
 * Package com.thelazyman193.premierleaguenews
 */

public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        FontsOverride.setDefaultFont(this, "DEFAULT", "SFUShannonBook.TTF");
        FontsOverride.setDefaultFont(this, "MONOSPACE", "SFUShannonBook.TTF");
        FontsOverride.setDefaultFont(this, "SERIF", "SFUShannonBook.TTF");
        FontsOverride.setDefaultFont(this, "SANS_SERIF", "SFUShannonBook.TTF");
    }
}
