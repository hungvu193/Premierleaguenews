
package com.thelazyman193.premierleaguenews.model.detailfixture;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Links___ {

    @SerializedName("self")
    @Expose
    private Self___ self;
    @SerializedName("competition")
    @Expose
    private Competition___ competition;
    @SerializedName("homeTeam")
    @Expose
    private HomeTeam___ homeTeam;
    @SerializedName("awayTeam")
    @Expose
    private AwayTeam___ awayTeam;

    public Self___ getSelf() {
        return self;
    }

    public void setSelf(Self___ self) {
        this.self = self;
    }

    public Competition___ getCompetition() {
        return competition;
    }

    public void setCompetition(Competition___ competition) {
        this.competition = competition;
    }

    public HomeTeam___ getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(HomeTeam___ homeTeam) {
        this.homeTeam = homeTeam;
    }

    public AwayTeam___ getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(AwayTeam___ awayTeam) {
        this.awayTeam = awayTeam;
    }

}
