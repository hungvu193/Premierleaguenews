
package com.thelazyman193.premierleaguenews.model.detailfixture;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Links__ {

    @SerializedName("self")
    @Expose
    private Self__ self;
    @SerializedName("competition")
    @Expose
    private Competition__ competition;
    @SerializedName("homeTeam")
    @Expose
    private HomeTeam__ homeTeam;
    @SerializedName("awayTeam")
    @Expose
    private AwayTeam__ awayTeam;

    public Self__ getSelf() {
        return self;
    }

    public void setSelf(Self__ self) {
        this.self = self;
    }

    public Competition__ getCompetition() {
        return competition;
    }

    public void setCompetition(Competition__ competition) {
        this.competition = competition;
    }

    public HomeTeam__ getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(HomeTeam__ homeTeam) {
        this.homeTeam = homeTeam;
    }

    public AwayTeam__ getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(AwayTeam__ awayTeam) {
        this.awayTeam = awayTeam;
    }

}
