
package com.thelazyman193.premierleaguenews.model.detailfixture;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("goalsHomeTeam")
    @Expose
    private Object goalsHomeTeam;
    @SerializedName("goalsAwayTeam")
    @Expose
    private Object goalsAwayTeam;

    public Object getGoalsHomeTeam() {
        return goalsHomeTeam;
    }

    public void setGoalsHomeTeam(Object goalsHomeTeam) {
        this.goalsHomeTeam = goalsHomeTeam;
    }

    public Object getGoalsAwayTeam() {
        return goalsAwayTeam;
    }

    public void setGoalsAwayTeam(Object goalsAwayTeam) {
        this.goalsAwayTeam = goalsAwayTeam;
    }

}
