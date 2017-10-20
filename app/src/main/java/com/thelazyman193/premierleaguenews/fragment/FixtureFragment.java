package com.thelazyman193.premierleaguenews.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thelazyman193.premierleaguenews.R;
import com.thelazyman193.premierleaguenews.adapter.NextLastFixturesAdapter;
import com.thelazyman193.premierleaguenews.model.fixture.Fixture;
import com.thelazyman193.premierleaguenews.model.fixture.FixtureDataBean;
import com.thelazyman193.premierleaguenews.retrofit.FBAPIService;
import com.thelazyman193.premierleaguenews.utils.Utils;

import java.util.ArrayList;
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

public class FixtureFragment extends Fragment {
    @BindView(R.id.listUpcoming)
    RecyclerView listUpcoming;
    @BindView(R.id.listLastest)
    RecyclerView listLastest;
    private Utils utils = Utils.getInstance();
    private FBAPIService mService;
    private List<Fixture> upcomingList = new ArrayList<>();
    private List<Fixture> lastestList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fixture, container, false);
        ButterKnife.bind(this, view);
        mService = utils.getFABAPIService();
        mService.getAllFixture(getString(R.string.token), "445", "n7").enqueue(new Callback<FixtureDataBean>() {
            @Override
            public void onResponse(Call<FixtureDataBean> call, Response<FixtureDataBean> response) {
                initUpcoming(response.body().getFixtures());
            }

            @Override
            public void onFailure(Call<FixtureDataBean> call, Throwable t) {

            }
        });

        mService.getAllFixture(getString(R.string.token), "445", "p14    ").enqueue(new Callback<FixtureDataBean>() {
            @Override
            public void onResponse(Call<FixtureDataBean> call, Response<FixtureDataBean> response) {
                initLastest(response.body().getFixtures());
            }

            @Override
            public void onFailure(Call<FixtureDataBean> call, Throwable t) {

            }
        });
        return view;
    }

    public void initUpcoming(List<Fixture> upcomingList) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        listUpcoming.setLayoutManager(layoutManager);
        listUpcoming.setNestedScrollingEnabled(false);
        NextLastFixturesAdapter nextLastFixturesAdapter = new NextLastFixturesAdapter(getContext(), upcomingList, 0);
        listUpcoming.setAdapter(nextLastFixturesAdapter);
    }


    public void initLastest(List<Fixture> lastestList) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        listLastest.setLayoutManager(layoutManager);
        listLastest.setNestedScrollingEnabled(false);
        NextLastFixturesAdapter nextLastFixturesAdapter = new NextLastFixturesAdapter(getContext(), lastestList, 0);
        listLastest.setAdapter(nextLastFixturesAdapter);
    }
}
