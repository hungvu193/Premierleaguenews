package com.thelazyman193.premierleaguenews.model.premierleagueteam;

import com.google.gson.annotations.SerializedName;

/**
 * Created by hungvu on 8/27/2017.
 * Project PremierLeagueNews
 * Package com.thelazyman193.premierleaguenews.model.premierleagueteam
 */

public class Link {

    @SerializedName("self")
    private self self;
    @SerializedName("competition")
    private competition competition;

    public Link.self getSelf() {
        return self;
    }

    public void setSelf(Link.self self) {
        this.self = self;
    }

    public class self {
        @SerializedName("href")
        private String hreft;

        public String getHreft() {
            return hreft;
        }

        public void setHreft(String hreft) {
            this.hreft = hreft;
        }
    }

    public class competition {
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
