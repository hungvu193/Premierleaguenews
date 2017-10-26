
package com.thelazyman193.premierleaguenews.model.detailfixture;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Links_ {

    @SerializedName("self")
    @Expose
    private Self_ self;
    @SerializedName("competition")
    @Expose
    private Competition_ competition;
    @SerializedName("homeTeam")
    @Expose
    private HomeTeam_ homeTeam;
    @SerializedName("awayTeam")
    @Expose
    private AwayTeam_ awayTeam;

    public Self_ getSelf() {
        return self;
    }

    public void setSelf(Self_ self) {
        this.self = self;
    }

    public Competition_ getCompetition() {
        return competition;
    }

    public void setCompetition(Competition_ competition) {
        this.competition = competition;
    }

    public HomeTeam_ getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(HomeTeam_ homeTeam) {
        this.homeTeam = homeTeam;
    }

    public AwayTeam_ getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(AwayTeam_ awayTeam) {
        this.awayTeam = awayTeam;
    }

}
