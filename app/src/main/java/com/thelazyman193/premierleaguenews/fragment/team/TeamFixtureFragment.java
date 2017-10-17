package com.thelazyman193.premierleaguenews.fragment.team;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thelazyman193.premierleaguenews.R;
import com.thelazyman193.premierleaguenews.adapter.FixtureAdapter;
import com.thelazyman193.premierleaguenews.model.fixture.Fixture;
import com.thelazyman193.premierleaguenews.model.fixture.FixtureDataBean;
import com.thelazyman193.premierleaguenews.retrofit.FBAPIService;
import com.thelazyman193.premierleaguenews.utils.Utils;

import java.util.List;

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

public class TeamFixtureFragment extends Fragment {
    private static TeamFixtureFragment teamFixtureFragment = null;
    private Utils utils = Utils.getInstance();
    private FBAPIService mService;
    @BindView(R.id.listFixture)
    RecyclerView listFixtures;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_team, container, false);
        ButterKnife.bind(this, view);
        int teamID = getArguments().getInt("link");
        mService = utils.getFABAPIService();
        mService.getNextLastFixture(getString(R.string.token), teamID, "n30").enqueue(new Callback<FixtureDataBean>() {
            @Override
            public void onResponse(Call<FixtureDataBean> call, Response<FixtureDataBean> response) {
                initFixture(response.body().getFixtures());
            }

            @Override
            public void onFailure(Call<FixtureDataBean> call, Throwable t) {

            }
        });
        return view;
    }


    public void initFixture(List<Fixture> listFixture) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        listFixtures.setLayoutManager(layoutManager);
        FixtureAdapter fixtureAdapter = new FixtureAdapter(getContext(),listFixture);
        listFixtures.setAdapter(fixtureAdapter);
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
