package com.thelazyman193.premierleaguenews.model.premierleagueteam;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by hungvu on 8/28/2017.
 * Project PremierLeagueNews
 * Package com.thelazyman193.premierleaguenews.model.premierleagueteam
 */

public class PremierLeagueRank {
    @SerializedName("_links")
    private Link _links;
    @SerializedName("leagueCaption")
    private String leagueCaption;
    @SerializedName("matchday")
    private int matchday;
    @SerializedName("standing")
    private List<Standing> standing;

    public Link get_links() {
        return _links;
    }

    public void set_links(Link _links) {
        this._links = _links;
    }

    public String getLeagueCaption() {
        return leagueCaption;
    }

    public void setLeagueCaption(String leagueCaption) {
        this.leagueCaption = leagueCaption;
    }

    public int getMatchday() {
        return matchday;
    }

    public void setMatchday(int matchday) {
        this.matchday = matchday;
    }

    public List<Standing> getStanding() {
        return standing;
    }

    public void setStanding(List<Standing> standing) {
        this.standing = standing;
    }
}
