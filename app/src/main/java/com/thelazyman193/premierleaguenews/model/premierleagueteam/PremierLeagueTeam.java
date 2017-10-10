package com.thelazyman193.premierleaguenews.model.premierleagueteam;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by hungvu on 8/27/2017.
 * Project PremierLeagueNews
 * Package com.thelazyman193.premierleaguenews.model.premierleagueteam
 */

public class PremierLeagueTeam {
    @SerializedName("_links")
    private Link _links;
    @SerializedName("count")
    private int count;
    @SerializedName("teams")
    private List<Team> teams;

    public Link get_links() {
        return _links;
    }

    public void set_links(Link _links) {
        this._links = _links;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }
}
