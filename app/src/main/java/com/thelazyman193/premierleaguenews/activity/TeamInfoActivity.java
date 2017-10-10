package com.thelazyman193.premierleaguenews.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.thelazyman193.premierleaguenews.R;
import com.thelazyman193.premierleaguenews.retrofit.FBAPIService;
import com.thelazyman193.premierleaguenews.utils.Utils;

import butterknife.BindView;

public class TeamInfoActivity extends AppCompatActivity {
    private String teamName;
    private Utils utils = Utils.getInstance();
    private FBAPIService mService;
    private int logoSource;
    private String linkNews;
    private int teamId;
    private String fixtureTeam;
    private String playerTeam;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.viewpager)
    ViewPager viewPager;

    //e66c32d50df447358ea63b34235dc8c3
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_info);
        teamName = getIntent().getExtras().getString("team_name");
        teamId = getTeamID(teamName);
        fixtureTeam = "http://api.football-data.org/v1/teams/" + teamId + "/fixtures";
        playerTeam = "http://api.football-data.org/v1/teams/" + teamId + "/players";

    }



    private int getTeamID(String teamFull) {
        if (teamFull.equalsIgnoreCase("Manchester United FC")) {
            logoSource = R.mipmap.ic_mu;
            linkNews = "http://www.manutd.com/";
            return 66;
        } else if (teamFull.equalsIgnoreCase("Liverpool FC")) {
            logoSource = R.mipmap.ic_liv;
            linkNews = "http://www.liverpoolfc.com/";
            return 64;
        } else if (teamFull.equalsIgnoreCase("Huddersfield Town")) {
            logoSource = R.mipmap.ic_hudder;
            linkNews = "https://www.htafc.com/";
            return 394;
        } else if (teamFull.equalsIgnoreCase("Manchester City FC")) {
            logoSource = R.mipmap.ic_mc;
            linkNews = "https://www.mancity.com/";
            return 65;
        } else if (teamFull.equalsIgnoreCase("West Bromwich Albion FC")) {
            logoSource = R.mipmap.ic_westbrom;
            linkNews = "https://www.wba.co.uk/";
            return 74;
        } else if (teamFull.equalsIgnoreCase("Chelsea FC")) {
            logoSource = R.mipmap.ic_chel;
            linkNews = "http://www.chelseafc.com/";
            return 61;
        } else if (teamFull.equalsIgnoreCase("Watford FC")) {
            logoSource = R.mipmap.ic_wat;
            linkNews = "https://www.watfordfc.com/";
            return 346;
        } else if (teamFull.equalsIgnoreCase("Southampton FC")) {
            logoSource = R.mipmap.ic_sou;
            linkNews = "https://southamptonfc.com/";
            return 340;
        } else if (teamFull.equalsIgnoreCase("Tottenham Hotspur FC")) {
            logoSource = R.mipmap.ic_tot;
            linkNews = "http://www.tottenhamhotspur.com/";
            return 73;
        } else if (teamFull.equalsIgnoreCase("Burnley FC")) {
            logoSource = R.mipmap.ic_burney;
            linkNews = "https://www.burnleyfootballclub.com/";
            return 328;
        } else if (teamFull.equalsIgnoreCase("Stoke City FC")) {
            logoSource = R.mipmap.ic_stoke;
            linkNews = "https://www.stokecityfc.com/";
            return 70;
        } else if (teamFull.equalsIgnoreCase("Everton FC")) {
            logoSource = R.mipmap.ic_eve;
            linkNews = "http://www.evertonfc.com/";
            return 62;
        } else if (teamFull.equalsIgnoreCase("Swansea City FC")) {
            logoSource = R.mipmap.ic_swan;
            linkNews = "https://www.swanseacity.com/";
            return 72;
        } else if (teamFull.equalsIgnoreCase("Newcastle United FC")) {
            logoSource = R.mipmap.ic_new;
            linkNews = "https://www.nufc.co.uk/";
            return 67;
        } else if (teamFull.equalsIgnoreCase("Leicester City FC")) {
            logoSource = R.mipmap.ic_lei;
            linkNews = "https://www.lcfc.com/";
            return 338;
        } else if (teamFull.equalsIgnoreCase("Arsenal FC")) {
            logoSource = R.mipmap.ic_ars;
            linkNews = "https://www.arsenal.com/";
            return 57;
        } else if (teamFull.equalsIgnoreCase("Brighton & Hove Albion")) {
            linkNews = "https://www.brightonandhovealbion.com/";
            logoSource = R.mipmap.ic_bha;
            return 397;
        } else if (teamFull.equalsIgnoreCase("AFC Bournemouth")) {
            linkNews = "https://www.afcb.co.uk/";
            logoSource = R.mipmap.ic_bou;
            return 1044;
        } else if (teamFull.equalsIgnoreCase("Crystal Palace FC")) {
            logoSource = R.mipmap.ic_cry;
            linkNews = "https://www.cpfc.co.uk/";
            return 354;
        } else if (teamFull.equalsIgnoreCase("West Ham United FC")) {
            logoSource = R.mipmap.ic_westham;
            linkNews = "https://www.whufc.com/";
            return 563;
        } else {
            logoSource = R.mipmap.ic_liv;
            linkNews = "http://www.liverpoolfc.com/";
            return 397;
        }
    }


}
