package com.thelazyman193.premierleaguenews.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.thelazyman193.premierleaguenews.R;
import com.thelazyman193.premierleaguenews.model.fixture.Fixture;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by hungvu on 10/17/2017.
 * Project PremierLeagueNews
 * Package com.thelazyman193.premierleaguenews.adapter
 */

public class FixtureAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<Fixture> fixtureList = new ArrayList<>();

    public FixtureAdapter(Context context, List<Fixture> fixtures) {
        this.context = context;
        this.fixtureList = fixtures;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_fixtures, parent, false);
        return new FixtureHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Fixture currentFixture = fixtureList.get(position);
        FixtureHolder fixtureHolder = (FixtureHolder) holder;

    }

    @Override
    public int getItemCount() {
        return fixtureList.size();
    }

    class FixtureHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvNameTeam1)
        TextView tvTeam1;
        @BindView(R.id.tvNameTeam2)
        TextView tvTeam2;
        @BindView(R.id.imgLogo1)
        ImageView imgLogo1;
        @BindView(R.id.imgLogo2)
        ImageView imgLogo2;
        @BindView(R.id.tvTime)
        TextView tvTime;
        @BindView(R.id.tvDate)
        TextView tvDate;

        public FixtureHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
