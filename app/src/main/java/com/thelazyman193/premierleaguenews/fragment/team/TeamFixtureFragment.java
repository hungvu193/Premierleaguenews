package com.thelazyman193.premierleaguenews.fragment.team;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thelazyman193.premierleaguenews.R;
import com.thelazyman193.premierleaguenews.model.player.PlayerDataBean;
import com.thelazyman193.premierleaguenews.retrofit.FBAPIService;
import com.thelazyman193.premierleaguenews.utils.Utils;

import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by hungvu on 8/29/2017.
 * Project PremierLeagueNews
 * Package com.thelazyman193.premierleaguenews.fragment
 */

public class TeamFixtureFragment extends Fragment {
    private static TeamFixtureFragment teamFixtureFragment = null;
    private Utils utils = Utils.getInstance();
    private FBAPIService mService;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_team, container, false);
        ButterKnife.bind(this, view);
        int teamID = getArguments().getInt("link");
        mService = utils.getFABAPIService();
        mService.getNextLastFixture(getString(R.string.token),teamID,"n30").enqueue(new Callback<PlayerDataBean>() {
            @Override
            public void onResponse(Call<PlayerDataBean> call, Response<PlayerDataBean> response) {

            }

            @Override
            public void onFailure(Call<PlayerDataBean> call, Throwable t) {

            }
        });
        return view;
    }


    public static TeamFixtureFragment getInstance(int link) {
        if (teamFixtureFragment == null) {
            teamFixtureFragment = new TeamFixtureFragment();
        }
        Bundle bundle = new Bundle();
        bundle.putInt("link", link);
        teamFixtureFragment.setArguments(bundle);
        return teamFixtureFragment;
    }
}
