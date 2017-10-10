package com.thelazyman193.premierleaguenews.model.premierleagueteam;

import com.google.gson.annotations.SerializedName;

/**
 * Created by hungvu on 8/28/2017.
 * Project PremierLeagueNews
 * Package com.thelazyman193.premierleaguenews.model.premierleagueteam
 */

public class Standing {
    @SerializedName("_links")
    private _links _links;
    @SerializedName("position")
    private int position;
    @SerializedName("teamName")
    private String teamName;
    //ava
    @SerializedName("crestURI")
    private String crestURI;
    @SerializedName("playedGames")
    private String playedGames;
    @SerializedName("points")
    private int points;
    @SerializedName("goals")
    private int goals;
    @SerializedName("goalsAgainst")
    private int goalsAgainst;
    @SerializedName("goalDifference")
    private int goalDifference;
    @SerializedName("wins")
    private int wins;
    @SerializedName("draws")
    private int draws;
    @SerializedName("losses")
    private int losses;
    @SerializedName("home")
    private home home;
    @SerializedName("away")
    private away away;

    public Standing._links get_links() {
        return _links;
    }

    public void set_links(Standing._links _links) {
        this._links = _links;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getCrestURI() {
        return crestURI;
    }

    public void setCrestURI(String crestURI) {
        this.crestURI = crestURI;
    }

    public String getPlayedGames() {
        return playedGames;
    }

    public void setPlayedGames(String playedGames) {
        this.playedGames = playedGames;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getGoalsAgainst() {
        return goalsAgainst;
    }

    public void setGoalsAgainst(int goalsAgainst) {
        this.goalsAgainst = goalsAgainst;
    }

    public int getGoalDifference() {
        return goalDifference;
    }

    public void setGoalDifference(int goalDifference) {
        this.goalDifference = goalDifference;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public Standing.home getHome() {
        return home;
    }

    public void setHome(Standing.home home) {
        this.home = home;
    }

    public Standing.away getAway() {
        return away;
    }

    public void setAway(Standing.away away) {
        this.away = away;
    }

    private class home {
        @SerializedName("goals")
        private int goals;
        @SerializedName("goalsAgainst")
        private int goalsAgainst;
        @SerializedName("wins")
        private int wins;
        @SerializedName("draws")
        private int draws;
        @SerializedName("losses")
        private int losses;

        public int getGoals() {
            return goals;
        }

        public void setGoals(int goals) {
            this.goals = goals;
        }

        public int getGoalsAgainst() {
            return goalsAgainst;
        }

        public void setGoalsAgainst(int goalsAgainst) {
            this.goalsAgainst = goalsAgainst;
        }

        public int getWins() {
            return wins;
        }

        public void setWins(int wins) {
            this.wins = wins;
        }

        public int getDraws() {
            return draws;
        }

        public void setDraws(int draws) {
            this.draws = draws;
        }

        public int getLosses() {
            return losses;
        }

        public void setLosses(int losses) {
            this.losses = losses;
        }
    }

    private class away {
        @SerializedName("goals")
        private int goals;
        @SerializedName("goalsAgainst")
        private int goalsAgainst;
        @SerializedName("wins")
        private int wins;
        @SerializedName("draws")
        private int draws;
        @SerializedName("losses")
        private int losses;

        public int getGoals() {
            return goals;
        }

        public void setGoals(int goals) {
            this.goals = goals;
        }

        public int getGoalsAgainst() {
            return goalsAgainst;
        }

        public void setGoalsAgainst(int goalsAgainst) {
            this.goalsAgainst = goalsAgainst;
        }

        public int getWins() {
            return wins;
        }

        public void setWins(int wins) {
            this.wins = wins;
        }

        public int getDraws() {
            return draws;
        }

        public void setDraws(int draws) {
            this.draws = draws;
        }

        public int getLosses() {
            return losses;
        }

        public void setLosses(int losses) {
            this.losses = losses;
        }
    }

    public class _links {
        @SerializedName("team")
        private team team;

        public Standing.team getTeam() {
            return team;
        }

        public void setTeam(Standing.team team) {
            this.team = team;
        }
    }

    public class team {
        @SerializedName("href")
        private String href;

        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }
    }
}
