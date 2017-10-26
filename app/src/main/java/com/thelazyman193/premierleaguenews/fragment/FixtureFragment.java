package com.thelazyman193.premierleaguenews.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.thelazyman193.premierleaguenews.R;
import com.thelazyman193.premierleaguenews.adapter.LastestAdapter;
import com.thelazyman193.premierleaguenews.adapter.UpcomingAdapter;
import com.thelazyman193.premierleaguenews.interfaces.OnClickNextComming;
import com.thelazyman193.premierleaguenews.model.detailfixture.FixtureBean;
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

public class FixtureFragment extends Fragment implements LastestAdapter.OnClickLastest, OnClickNextComming {
    @BindView(R.id.listUpcoming)
    RecyclerView listUpcoming;
    @BindView(R.id.listLastest)
    RecyclerView listLastest;
    @BindView(R.id.bottomSheetLayout)
    LinearLayout bottomSheetView;
    private Utils utils = Utils.getInstance();
    private FBAPIService mService;
    private List<Fixture> upcomingList = new ArrayList<>();
    private List<Fixture> lastestList = new ArrayList<>();
    private BottomSheetBehavior bottomSheetBehavior;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fixtures, container, false);
        ButterKnife.bind(this, view);
        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheetView);
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

        mService.getAllFixture(getString(R.string.token), "445", "p7").enqueue(new Callback<FixtureDataBean>() {
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
        UpcomingAdapter nextLastFixturesAdapter = new UpcomingAdapter(getContext(), upcomingList, 0);
        nextLastFixturesAdapter.setNextComming(FixtureFragment.this);
        listUpcoming.setAdapter(nextLastFixturesAdapter);
    }


    public void initLastest(List<Fixture> lastestList) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        listLastest.setLayoutManager(layoutManager);
        listLastest.setNestedScrollingEnabled(false);
        LastestAdapter nextLastFixturesAdapter = new LastestAdapter(getContext(), lastestList);
        nextLastFixturesAdapter.setOnClickLastest(FixtureFragment.this);
        listLastest.setAdapter(nextLastFixturesAdapter);
    }

    @Override
    public void clickLastest(String linkFixture) {
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);

    }

    @Override
    public void onClickNextComming(String fixtureLink) {
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        mService.getCurrentFixture(fixtureLink,getString(R.string.token)).enqueue(new Callback<FixtureBean>() {
            @Override
            public void onResponse(Call<FixtureBean> call, Response<FixtureBean> response) {
                Log.d("FixtureFrag",response.toString()+"");
            }

            @Override
            public void onFailure(Call<FixtureBean> call, Throwable t) {
                Log.d("FixtureFrag",t.toString()+"");
            }
        });
    }
}
