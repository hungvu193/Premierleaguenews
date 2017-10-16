package com.thelazyman193.premierleaguenews.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.thelazyman193.premierleaguenews.R;
import com.thelazyman193.premierleaguenews.model.player.Player;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by hungvu on 10/16/2017.
 * Project PremierLeagueNews
 * Package com.thelazyman193.premierleaguenews.adapter
 */

public class SquadAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Player> listPlayer = new ArrayList<>();
    private Context context;

    public SquadAdapter(Context context, List<Player> listPlayer) {
        this.context = context;
        this.listPlayer = listPlayer;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_squad, parent, false);
        return new SquadHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Player currentPlayer = listPlayer.get(position);
        SquadHolder squadHolder = (SquadHolder) holder;
        squadHolder.tvConstract.setText(currentPlayer.getContractUntil() + "");
        squadHolder.tvDate.setText(currentPlayer.getDateOfBirth()+"");
        squadHolder.tvName.setText(currentPlayer.getName());
        squadHolder.tvNumber.setText(currentPlayer.getJerseyNumber()+"");
        squadHolder.tvPosition.setText(currentPlayer.getPosition()+"");
    }

    @Override
    public int getItemCount() {
        return listPlayer == null ? 0 : listPlayer.size();
    }


    class SquadHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvName)
        TextView tvName;
        @BindView(R.id.tvDate)
        TextView tvDate;
        @BindView(R.id.tvConstract)
        TextView tvConstract;
        @BindView(R.id.tvNumber)
        TextView tvNumber;
        @BindView(R.id.tvPosition)
        TextView tvPosition;

        public SquadHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
