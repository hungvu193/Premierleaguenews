package com.thelazyman193.premierleaguenews.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
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
    @BindView(R.id.imgHomeTeam)
    ImageView imgHomeTeam;
    @BindView(R.id.imgAwayTeam)
    ImageView imgAwayTeam;
    @BindView(R.id.tvCount)
    TextView tvCount;
    @BindView(R.id.tvHomeWin1)
    TextView tvHomeWin1;
    @BindView(R.id.tvHomeWin2)
    TextView tvHomeWin2;
    @BindView(R.id.tvDrawn)
    TextView tvDrawn;
    @BindView(R.id.tvHomeTeam)
    TextView tvHomeTeam;
    @BindView(R.id.tvAwayTeam)
    TextView tvAwayTeam;
    private Utils utils = Utils.getInstance();
    private FBAPIService mService;
    private List<Fixture> upcomingList = new ArrayList<>();
    private List<Fixture> lastestList = new ArrayList<>();
    private BottomSheetBehavior bottomSheetBehavior;
    private boolean isBottmSheetShow = false;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fixtures, container, false);
        ButterKnife.bind(this, view);
        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheetView);
        bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                switch (newState) {
                    case BottomSheetBehavior.STATE_HIDDEN:
                        isBottmSheetShow = false;
                        break;
                    case BottomSheetBehavior.STATE_EXPANDED:
                        isBottmSheetShow = true;
                        break;
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });
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
        if (isBottmSheetShow)
            bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);

    }

    @Override
    public void onClickNextComming(String fixtureLink, final String homeTeam, final String awayTeam) {

        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        Picasso.with(getContext()).load(utils.getLogoByName(homeTeam)).into(imgHomeTeam);
        Picasso.with(getContext()).load(utils.getLogoByName(awayTeam)).into(imgAwayTeam);
        tvHomeTeam.setText(utils.getShortTeamName(homeTeam));
        tvAwayTeam.setText(utils.getShortTeamName(awayTeam));

        mService.getCurrentFixture(fixtureLink, getString(R.string.token)).enqueue(new Callback<FixtureBean>() {
            @Override
            public void onResponse(Call<FixtureBean> call, Response<FixtureBean> response) {
                if (response.isSuccessful()) {
                    FixtureBean fixtureBean = response.body();
                    tvCount.setText(fixtureBean.getHead2head().getCount() + " Times");
                    tvHomeWin1.setText(fixtureBean.getHead2head().getHomeTeamWins() + "");
                    tvHomeWin2.setText(fixtureBean.getHead2head().getAwayTeamWins() + "");
                    tvDrawn.setText(fixtureBean.getHead2head().getDraws() == null ? "0" : fixtureBean.getHead2head().getDraws() + "");
                }

            }

            @Override
            public void onFailure(Call<FixtureBean> call, Throwable t) {
                Log.d("FixtureFrag", t.toString() + "");
            }
        });
    }
}
