package com.thelazyman193.premierleaguenews.model.premierleagueteam;

import com.google.gson.annotations.SerializedName;

/**
 * Created by hungvu on 8/27/2017.
 * Project PremierLeagueNews
 * Package com.thelazyman193.premierleaguenews.model.premierleagueteam
 */

public class Team {

    @SerializedName("_links")
    private links _links;
    @SerializedName("name")
    private String name;
    @SerializedName("code")
    private String code;
    @SerializedName("shortName")
    private String shortName;
    @SerializedName("squadMarketValue")
    private String squadMarketValue;

    public links get_links() {
        return _links;
    }

    public void set_links(links _links) {
        this._links = _links;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getSquadMarketValue() {
        return squadMarketValue;
    }

    public void setSquadMarketValue(String squadMarketValue) {
        this.squadMarketValue = squadMarketValue;
    }

    public class links {
        @SerializedName("self")
        private self self;
        @SerializedName("fixtures")
        private fixtures fixtures;
        @SerializedName("players")
        private players players;

        public Team.self getSelf() {
            return self;
        }

        public void setSelf(Team.self self) {
            this.self = self;
        }

        public Team.fixtures getFixtures() {
            return fixtures;
        }

        public void setFixtures(Team.fixtures fixtures) {
            this.fixtures = fixtures;
        }

        public Team.players getPlayers() {
            return players;
        }

        public void setPlayers(Team.players players) {
            this.players = players;
        }
    }

    private class self {
        @SerializedName("href")
        private String href;

        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }
    }

    private class fixtures {
        @SerializedName("href")
        private String href;

        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }
    }

    private class players {
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
