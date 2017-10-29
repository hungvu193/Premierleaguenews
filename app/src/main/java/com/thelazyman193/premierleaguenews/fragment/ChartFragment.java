package com.thelazyman193.premierleaguenews.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.thelazyman193.premierleaguenews.R;
import com.thelazyman193.premierleaguenews.activity.TeamInfoActivity;
import com.thelazyman193.premierleaguenews.adapter.RankingAdapter;
import com.thelazyman193.premierleaguenews.interfaces.OnClickRanking;
import com.thelazyman193.premierleaguenews.model.premierleagueteam.PremierLeagueRank;
import com.thelazyman193.premierleaguenews.retrofit.FBAPIService;
import com.thelazyman193.premierleaguenews.utils.Utils;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by hungvu on 8/29/2017.
 * Project PremierLeagueNews
 * Package com.thelazyman193.premierleaguenews.fragment
 */

public class ChartFragment extends Fragment implements OnClickRanking {
    private String result;
    private Utils utils = Utils.getInstance();
    @BindView(R.id.listRank)
    RecyclerView listRanking;
    private FBAPIService mService;
    private RankingAdapter rankingAdapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chart, container, false);
        ButterKnife.bind(this, view);
        result = utils.getTextFromAsset("demo_league_table.json", getContext());
        Gson gson = new Gson();
        PremierLeagueRank premierLeagueRank = gson.fromJson(result, PremierLeagueRank.class);
        mService = utils.getFABAPIService();
        mService.getTeamRank(getString(R.string.token)).enqueue(new Callback<PremierLeagueRank>() {
            @Override
            public void onResponse(Call<PremierLeagueRank> call, Response<PremierLeagueRank> response) {
                rankingAdapter = new RankingAdapter(getActivity(), response.body().getStanding());
                listRanking.setHasFixedSize(false);
                LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                listRanking.setLayoutManager(layoutManager);
                listRanking.setAdapter(rankingAdapter);
                rankingAdapter.setOnClickRanking(ChartFragment.this);
            }

            @Override
            public void onFailure(Call<PremierLeagueRank> call, Throwable t) {
                Log.d("ChartFrag",t.toString()+"");
            }
        });


//        e66c32d50df447358ea63b34235dc8c3

        return view;
    }

    @Override
    public void onClickTeam(String teamName) {
        Intent intent = new Intent(getActivity(), TeamInfoActivity.class);
        intent.putExtra("team_name", teamName);
        startActivity(intent);
    }
}
