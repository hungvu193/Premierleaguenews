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
import com.thelazyman193.premierleaguenews.adapter.SquadAdapter;
import com.thelazyman193.premierleaguenews.model.player.Player;
import com.thelazyman193.premierleaguenews.model.player.PlayerDataBean;
import com.thelazyman193.premierleaguenews.retrofit.FBAPIService;
import com.thelazyman193.premierleaguenews.utils.Utils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by hungvu on 10/2/2017.
 * Project PremierLeagueNews
 * Package com.thelazyman193.premierleaguenews.fragment
 */

public class SquadFragment extends Fragment {
    private static SquadFragment squadFragment = null;
    private Utils utils = Utils.getInstance();
    private FBAPIService mService;
    @BindView(R.id.listSquad)
    RecyclerView listSquad;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_squad, container, false);
        ButterKnife.bind(this, view);
        int teamID = getArguments().getInt("link");
        mService = utils.getFABAPIService();
        mService.getPlayerList(getString(R.string.token), teamID).enqueue(new Callback<PlayerDataBean>() {
            @Override
            public void onResponse(Call<PlayerDataBean> call, Response<PlayerDataBean> response) {
                List<Player> players = response.body().getPlayers();
                initListPlayer(players);

            }

            @Override
            public void onFailure(Call<PlayerDataBean> call, Throwable t) {

            }
        });
        return view;
    }

    public void initListPlayer(List<Player> players) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        listSquad.setLayoutManager(layoutManager);
        SquadAdapter squadAdapter = new SquadAdapter(getContext(), players);
        listSquad.setAdapter(squadAdapter);
    }

    public static SquadFragment getInstance(int link) {
        if (squadFragment == null) {
            squadFragment = new SquadFragment();
        }
        Bundle bundle = new Bundle();
        bundle.putInt("link", link);
        squadFragment.setArguments(bundle);
        return squadFragment;
    }
}
