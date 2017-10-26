
package com.thelazyman193.premierleaguenews.model.detailfixture;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Head2head {

    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("timeFrameStart")
    @Expose
    private String timeFrameStart;
    @SerializedName("timeFrameEnd")
    @Expose
    private String timeFrameEnd;
    @SerializedName("homeTeamWins")
    @Expose
    private Integer homeTeamWins;
    @SerializedName("awayTeamWins")
    @Expose
    private Integer awayTeamWins;
    @SerializedName("draws")
    @Expose
    private Integer draws;
    @SerializedName("lastHomeWinHomeTeam")
    @Expose
    private LastHomeWinHomeTeam lastHomeWinHomeTeam;
    @SerializedName("lastWinHomeTeam")
    @Expose
    private LastWinHomeTeam lastWinHomeTeam;
    @SerializedName("lastAwayWinAwayTeam")
    @Expose
    private Object lastAwayWinAwayTeam;
    @SerializedName("lastWinAwayTeam")
    @Expose
    private Object lastWinAwayTeam;
    @SerializedName("fixtures")
    @Expose
    private List<Fixture_> fixtures = null;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getTimeFrameStart() {
        return timeFrameStart;
    }

    public void setTimeFrameStart(String timeFrameStart) {
        this.timeFrameStart = timeFrameStart;
    }

    public String getTimeFrameEnd() {
        return timeFrameEnd;
    }

    public void setTimeFrameEnd(String timeFrameEnd) {
        this.timeFrameEnd = timeFrameEnd;
    }

    public Integer getHomeTeamWins() {
        return homeTeamWins;
    }

    public void setHomeTeamWins(Integer homeTeamWins) {
        this.homeTeamWins = homeTeamWins;
    }

    public Integer getAwayTeamWins() {
        return awayTeamWins;
    }

    public void setAwayTeamWins(Integer awayTeamWins) {
        this.awayTeamWins = awayTeamWins;
    }

    public Integer getDraws() {
        return draws;
    }

    public void setDraws(Integer draws) {
        this.draws = draws;
    }

    public LastHomeWinHomeTeam getLastHomeWinHomeTeam() {
        return lastHomeWinHomeTeam;
    }

    public void setLastHomeWinHomeTeam(LastHomeWinHomeTeam lastHomeWinHomeTeam) {
        this.lastHomeWinHomeTeam = lastHomeWinHomeTeam;
    }

    public LastWinHomeTeam getLastWinHomeTeam() {
        return lastWinHomeTeam;
    }

    public void setLastWinHomeTeam(LastWinHomeTeam lastWinHomeTeam) {
        this.lastWinHomeTeam = lastWinHomeTeam;
    }

    public Object getLastAwayWinAwayTeam() {
        return lastAwayWinAwayTeam;
    }

    public void setLastAwayWinAwayTeam(Object lastAwayWinAwayTeam) {
        this.lastAwayWinAwayTeam = lastAwayWinAwayTeam;
    }

    public Object getLastWinAwayTeam() {
        return lastWinAwayTeam;
    }

    public void setLastWinAwayTeam(Object lastWinAwayTeam) {
        this.lastWinAwayTeam = lastWinAwayTeam;
    }

    public List<Fixture_> getFixtures() {
        return fixtures;
    }

    public void setFixtures(List<Fixture_> fixtures) {
        this.fixtures = fixtures;
    }

}
