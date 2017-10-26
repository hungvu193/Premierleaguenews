package com.thelazyman193.premierleaguenews.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.thelazyman193.premierleaguenews.R;
import com.thelazyman193.premierleaguenews.model.fixture.Fixture;
import com.thelazyman193.premierleaguenews.utils.Utils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by hungvu on 10/20/2017.
 * Project PremierLeagueNews
 * Package com.thelazyman193.premierleaguenews.adapter
 */

public class LastestAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Utils utils = Utils.getInstance();
    private Context context;
    private List<Fixture> fixtureList = new ArrayList<>();
    //flag = 0 : next
    //flag = 1 : last
    OnClickLastest onClickLastest;

    public LastestAdapter(Context context, List<Fixture> fixtures) {
        this.context = context;
        this.fixtureList = fixtures;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_lastest, parent, false);
        return new LastestHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final LastestHolder nextLastHolder = (LastestHolder) holder;
        final Fixture currentFixture = fixtureList.get(position);
        nextLastHolder.imgTeam1.setImageResource(utils.getLogoByName(currentFixture.getHomeTeamName()));
        nextLastHolder.tvTeam1.setText(utils.getShortTeamName(currentFixture.getHomeTeamName()));
        nextLastHolder.imgTeam2.setImageResource(utils.getLogoByName(currentFixture.getAwayTeamName()));
        nextLastHolder.tvTeam2.setText(utils.getShortTeamName(currentFixture.getAwayTeamName()));
        nextLastHolder.tvTime.setText(currentFixture.getResult().getGoalsHomeTeam() + "-" + currentFixture.getResult().getGoalsAwayTeam());
        nextLastHolder.layoutRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickLastest.clickLastest(currentFixture.getLinks().getSelf().getHref());
            }
        });

    }

    @Override
    public int getItemCount() {
        return fixtureList == null ? 0 : fixtureList.size();
    }

    class LastestHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.layoutRoot)
        LinearLayout layoutRoot;
        @BindView(R.id.imgTeam1)
        ImageView imgTeam1;
        @BindView(R.id.imgTeam2)
        ImageView imgTeam2;
        @BindView(R.id.tvTeam1)
        TextView tvTeam1;
        @BindView(R.id.tvTeam2)
        TextView tvTeam2;
        @BindView(R.id.tvTime)
        TextView tvTime;

        public LastestHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public void setOnClickLastest(OnClickLastest onClickLastest) {
        this.onClickLastest = onClickLastest;
    }

    public interface OnClickLastest {
        void clickLastest(String linkFixture);
    }
}
