package com.thelazyman193.premierleaguenews.retrofit;

import com.thelazyman193.premierleaguenews.model.player.PlayerDataBean;
import com.thelazyman193.premierleaguenews.model.premierleagueteam.PremierLeagueRank;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by hungvu on 8/29/2017.
 * Project PremierLeagueNews
 * Package com.thelazyman193.premierleaguenews.retrofit
 */

public interface FBAPIService {
    //get all table leauge premier 2017-18
    @GET("/v1/competitions/445/leagueTable")
    Call<PremierLeagueRank> getTeamRank(@Header("X-Auth-Token") String token);

    //get player
    @GET("/v1/teams/{teamid}/players")
    Call<PlayerDataBean> getPlayerList(@Header("X-Auth-Token") String token,
                                       @Path("teamid") String teamid);

    //get all fixtures
    @GET("/v1/teams/{teamid}/fixtures")
    Call<PlayerDataBean> getAllFixture(@Header("X-Auth-Token") String token,
                                       @Path("teamid") String teamid);


    //get player
    @GET("/v1/teams/{teamid}/fixtures")
    Call<PlayerDataBean> getNextLastFixture(@Header("X-Auth-Token") String token,
                                            @Path("teamid") String teamid,
                                            @Query("timeFrame") String timeFrame);


}