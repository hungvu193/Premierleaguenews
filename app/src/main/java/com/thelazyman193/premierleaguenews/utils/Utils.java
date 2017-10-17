package com.thelazyman193.premierleaguenews.utils;

import android.content.Context;
import android.content.res.AssetManager;

import com.thelazyman193.premierleaguenews.R;
import com.thelazyman193.premierleaguenews.retrofit.FBAPIService;
import com.thelazyman193.premierleaguenews.retrofit.RetrofitClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by hungvu on 8/27/2017.
 * Project PremierLeagueNews
 * Package com.thelazyman193.premierleaguenews.utils
 */

public class Utils {
    private static Utils utils;
    private static final String BASE_URL = "http://api.football-data.org";

    public static Utils getInstance() {
        if (utils == null)
            utils = new Utils();
        return utils;
    }

    public FBAPIService getFABAPIService() {
        return RetrofitClient.getClient(BASE_URL).create(FBAPIService.class);
    }

    public String getTextFromAsset(String fileName, Context context) {
        String result = null;
        AssetManager am = context.getAssets();
        try {
            InputStream is = am.open(fileName);
            BufferedReader r = new BufferedReader(new InputStreamReader(is));
            StringBuilder total = new StringBuilder();
            String line;
            while ((line = r.readLine()) != null) {
                total.append(line).append('\n');
            }
            result = total.toString();

        } catch (IOException e) {

            e.printStackTrace();
        }

        return result;
    }

    public int getClubId(String clubName) {
        if (clubName.equalsIgnoreCase("Manchester United FC")) {
            return 66;
        } else if (clubName.equalsIgnoreCase("Liverpool FC")) {
            return 64;
        } else if (clubName.equalsIgnoreCase("Huddersfield Town")) {
            return 394;
        } else if (clubName.equalsIgnoreCase("Manchester City FC")) {
            return 65;
        } else if (clubName.equalsIgnoreCase("West Bromwich Albion FC")) {
            return 74;
        } else if (clubName.equalsIgnoreCase("Chelsea FC")) {
            return 61;
        } else if (clubName.equalsIgnoreCase("Watford FC")) {
            return 346;
        } else if (clubName.equalsIgnoreCase("Southampton FC")) {
            return 340;
        } else if (clubName.equalsIgnoreCase("Tottenham Hotspur FC")) {
            return 73;
        } else if (clubName.equalsIgnoreCase("Burnley FC")) {
            return 328;
        } else if (clubName.equalsIgnoreCase("Stoke City FC")) {
            return 70;
        } else if (clubName.equalsIgnoreCase("Everton FC")) {
            return 62;
        } else if (clubName.equalsIgnoreCase("Swansea City FC")) {
            return 72;
        } else if (clubName.equalsIgnoreCase("Newcastle United FC")) {
            return 67;
        } else if (clubName.equalsIgnoreCase("Leicester City FC")) {
            return 338;
        } else if (clubName.equalsIgnoreCase("Arsenal FC")) {
            return 57;
        } else if (clubName.equalsIgnoreCase("Brighton & Hove Albion")) {
            return 397;
        } else if (clubName.equalsIgnoreCase("AFC Bournemouth")) {
            return 1044;
        } else if (clubName.equalsIgnoreCase("Crystal Palace FC")) {
            return 354;
        } else if (clubName.equalsIgnoreCase("West Ham United FC")) {
            return 563;
        }

        return 64;
    }

    public int getLogoByName(String teamFull) {
        if (teamFull.equalsIgnoreCase("Manchester United FC")) {
            return R.mipmap.ic_mu;

        } else if (teamFull.equalsIgnoreCase("Liverpool FC")) {
            return R.mipmap.ic_liv;

        } else if (teamFull.equalsIgnoreCase("Huddersfield Town")) {
            return R.mipmap.ic_hudder;

        } else if (teamFull.equalsIgnoreCase("Manchester City FC")) {
            return R.mipmap.ic_mc;

        } else if (teamFull.equalsIgnoreCase("West Bromwich Albion FC")) {
            return R.mipmap.ic_westbrom;

        } else if (teamFull.equalsIgnoreCase("Chelsea FC")) {
            return R.mipmap.ic_chel;

        } else if (teamFull.equalsIgnoreCase("Watford FC")) {
            return R.mipmap.ic_wat;

        } else if (teamFull.equalsIgnoreCase("Southampton FC")) {
            return R.mipmap.ic_sou;

        } else if (teamFull.equalsIgnoreCase("Tottenham Hotspur FC")) {
            return R.mipmap.ic_tot;

        } else if (teamFull.equalsIgnoreCase("Burnley FC")) {
            return R.mipmap.ic_burney;

        } else if (teamFull.equalsIgnoreCase("Stoke City FC")) {
            return R.mipmap.ic_stoke;

        } else if (teamFull.equalsIgnoreCase("Everton FC")) {
            return R.mipmap.ic_eve;

        } else if (teamFull.equalsIgnoreCase("Swansea City FC")) {
            return R.mipmap.ic_swan;

        } else if (teamFull.equalsIgnoreCase("Newcastle United FC")) {
            return R.mipmap.ic_new;

        } else if (teamFull.equalsIgnoreCase("Leicester City FC")) {
            return R.mipmap.ic_lei;

        } else if (teamFull.equalsIgnoreCase("Arsenal FC")) {
            return R.mipmap.ic_ars;

        } else if (teamFull.equalsIgnoreCase("Brighton & Hove Albion")) {
            return R.mipmap.ic_bha;

        } else if (teamFull.equalsIgnoreCase("AFC Bournemouth")) {
            return R.mipmap.ic_bou;

        } else if (teamFull.equalsIgnoreCase("Crystal Palace FC")) {
            return R.mipmap.ic_cry;

        } else if (teamFull.equalsIgnoreCase("West Ham United FC")) {
            return R.mipmap.ic_westham;

        } else {
            return R.mipmap.logo_placeholder;

        }
    }


    public String getShortTeamName(String teamFull) {
        if (teamFull.equalsIgnoreCase("Manchester United FC")) {
            return "MUN";
        } else if (teamFull.equalsIgnoreCase("Liverpool FC")) {
            return "LIV";
        } else if (teamFull.equalsIgnoreCase("Huddersfield Town")) {
            return "HUD";
        } else if (teamFull.equalsIgnoreCase("Manchester City FC")) {
            return "MCI";
        } else if (teamFull.equalsIgnoreCase("West Bromwich Albion FC")) {
            return "WBA";
        } else if (teamFull.equalsIgnoreCase("Chelsea FC")) {
            return "CHE";
        } else if (teamFull.equalsIgnoreCase("Watford FC")) {
            return "WAT";
        } else if (teamFull.equalsIgnoreCase("Southampton FC")) {
            return "SOU";
        } else if (teamFull.equalsIgnoreCase("Tottenham Hotspur FC")) {
            return "TOT";
        } else if (teamFull.equalsIgnoreCase("Burnley FC")) {
            return "BUR";
        } else if (teamFull.equalsIgnoreCase("Stoke City FC")) {
            return "STK";
        } else if (teamFull.equalsIgnoreCase("Everton FC")) {
            return "EVE";
        } else if (teamFull.equalsIgnoreCase("Swansea City FC")) {
            return "SWA";
        } else if (teamFull.equalsIgnoreCase("Newcastle United FC")) {
            return "NEW";
        } else if (teamFull.equalsIgnoreCase("Leicester City FC")) {
            return "LEI";
        } else if (teamFull.equalsIgnoreCase("Arsenal FC")) {
            return "ARS";
        } else if (teamFull.equalsIgnoreCase("Brighton & Hove Albion")) {
            return "BHA";
        } else if (teamFull.equalsIgnoreCase("AFC Bournemouth")) {
            return "BOU";
        } else if (teamFull.equalsIgnoreCase("Crystal Palace FC")) {
            return "CRY";
        } else if (teamFull.equalsIgnoreCase("West Ham United FC")) {
            return "WHU";
        } else {
            return teamFull.substring(0, 3);
        }
    }
}
