package com.thelazyman193.premierleaguenews.adapter;

import android.content.Context;
import android.graphics.drawable.PictureDrawable;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.GenericRequestBuilder;
import com.caverock.androidsvg.SVG;
import com.squareup.picasso.Picasso;
import com.thelazyman193.premierleaguenews.R;
import com.thelazyman193.premierleaguenews.interfaces.OnClickRanking;
import com.thelazyman193.premierleaguenews.model.premierleagueteam.Standing;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by hungvu on 8/28/2017.
 * Project PremierLeagueNews
 * Package com.thelazyman193.premierleaguenews.adapter
 */

public class RankingAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private GenericRequestBuilder<Uri, InputStream, SVG, PictureDrawable> requestBuilder;
    private Context context;
    private List<Standing> teams = new ArrayList<>();
    private int TYPE_HEAD = 0, TYPE_NORMAL = 1;
    private int logoSource;
    private OnClickRanking onClickRanking;

    public RankingAdapter(Context context, List<Standing> teams) {
        this.context = context;
        this.teams = teams;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_HEAD;
        } else {
            return TYPE_NORMAL;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_HEAD) {
            View view = LayoutInflater.from(context).inflate(R.layout.row_header_rank, parent, false);
            return new HeaderRankHolder(view);
        } else {
            View view = LayoutInflater.from(context).inflate(R.layout.row_ranking, parent, false);
            return new RankingHolder(view);
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (position == 0) {

        } else {

            final Standing tmpTeam = teams.get(position - 1);
            String shortName = getShortTeamName(tmpTeam.getTeamName());
            RankingHolder rankingHolder = (RankingHolder) holder;
            rankingHolder.tvDraw.setText(tmpTeam.getDraws() + "");
            rankingHolder.tvGD.setText(tmpTeam.getGoalDifference() + "");
            rankingHolder.tvLost.setText(tmpTeam.getLosses() + "");
            rankingHolder.tvNameClub.setText(shortName + "");
            rankingHolder.tvPlayed.setText(tmpTeam.getPlayedGames() + "");
            rankingHolder.tvPoints.setText(tmpTeam.getPoints() + "");
            rankingHolder.tvPos.setText(tmpTeam.getPosition() + "");
            Picasso.with(context).load(logoSource).into(rankingHolder.imgLogo);
            rankingHolder.layoutRowRoot.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onClickRanking.onClickTeam(tmpTeam.getTeamName());
                }
            });
            /*
            Code with svg link or drawable
             */
//            if (!logo.endsWith(".svg")) {
//                if (shortName.equalsIgnoreCase("LEI")) {
//                    Picasso.with(context).load(R.mipmap.ic_lei).into(rankingHolder.imgLogo);
//                } else
//                    Picasso.with(context).load(logo).into(rankingHolder.imgLogo);
//            } else {
//                requestBuilder = Glide.with(context)
//                        .using(Glide.buildStreamModelLoader(Uri.class, context), InputStream.class)
//                        .from(Uri.class)
//                        .as(SVG.class)
//                        .transcode(new SvgDrawableTranscoder(), PictureDrawable.class)
//                        .sourceEncoder(new StreamEncoder())
//                        .cacheDecoder(new FileToStreamDecoder<SVG>(new SvgDecoder()))
//                        .decoder(new SvgDecoder())
//                        .placeholder(R.mipmap.ic_placeholder)
//                        .error(R.mipmap.ic_placeholder)
//                        .animate(android.R.anim.fade_in)
//                        .listener(new SvgSoftwareLayerSetter<Uri>());
//                Uri uri = Uri.parse(logo);
//                requestBuilder
//                        .diskCacheStrategy(DiskCacheStrategy.SOURCE)
//                        // SVG cannot be serialized so it's not worth to cache it
//                        .load(uri)
//                        .into(rankingHolder.imgLogo);
//            }
        }


    }

    public void setOnClickRanking(OnClickRanking onClickRanking) {
        this.onClickRanking = onClickRanking;
    }

    @Override
    public int getItemCount() {
        return this.teams == null ? 0 : teams.size() + 1;
    }

    private String getShortTeamName(String teamFull) {
        if (teamFull.equalsIgnoreCase("Manchester United FC")) {
            logoSource = R.mipmap.ic_mu;
            return "MUN";
        } else if (teamFull.equalsIgnoreCase("Liverpool FC")) {
            logoSource = R.mipmap.ic_liv;
            return "LIV";
        } else if (teamFull.equalsIgnoreCase("Huddersfield Town")) {
            logoSource = R.mipmap.ic_hudder;
            return "HUD";
        } else if (teamFull.equalsIgnoreCase("Manchester City FC")) {
            logoSource = R.mipmap.ic_mc;
            return "MCI";
        } else if (teamFull.equalsIgnoreCase("West Bromwich Albion FC")) {
            logoSource = R.mipmap.ic_westbrom;
            return "WBA";
        } else if (teamFull.equalsIgnoreCase("Chelsea FC")) {
            logoSource = R.mipmap.ic_chel;
            return "CHE";
        } else if (teamFull.equalsIgnoreCase("Watford FC")) {
            logoSource = R.mipmap.ic_wat;
            return "WAT";
        } else if (teamFull.equalsIgnoreCase("Southampton FC")) {
            logoSource = R.mipmap.ic_sou;
            return "SOU";
        } else if (teamFull.equalsIgnoreCase("Tottenham Hotspur FC")) {
            logoSource = R.mipmap.ic_tot;
            return "TOT";
        } else if (teamFull.equalsIgnoreCase("Burnley FC")) {
            logoSource = R.mipmap.ic_burney;
            return "BUR";
        } else if (teamFull.equalsIgnoreCase("Stoke City FC")) {
            logoSource = R.mipmap.ic_stoke;
            return "STK";
        } else if (teamFull.equalsIgnoreCase("Everton FC")) {
            logoSource = R.mipmap.ic_eve;
            return "EVE";
        } else if (teamFull.equalsIgnoreCase("Swansea City FC")) {
            logoSource = R.mipmap.ic_swan;
            return "SWA";
        } else if (teamFull.equalsIgnoreCase("Newcastle United FC")) {
            logoSource = R.mipmap.ic_new;
            return "NEW";
        } else if (teamFull.equalsIgnoreCase("Leicester City FC")) {
            logoSource = R.mipmap.ic_lei;
            return "LEI";
        } else if (teamFull.equalsIgnoreCase("Arsenal FC")) {
            logoSource = R.mipmap.ic_ars;
            return "ARS";
        } else if (teamFull.equalsIgnoreCase("Brighton & Hove Albion")) {
            logoSource = R.mipmap.ic_bha;
            return "BHA";
        } else if (teamFull.equalsIgnoreCase("AFC Bournemouth")) {
            logoSource = R.mipmap.ic_bou;
            return "BOU";
        } else if (teamFull.equalsIgnoreCase("Crystal Palace FC")) {
            logoSource = R.mipmap.ic_cry;
            return "CRY";
        } else if (teamFull.equalsIgnoreCase("West Ham United FC")) {
            logoSource = R.mipmap.ic_westham;
            return "WHU";
        } else {
            logoSource = R.mipmap.ic_liv;
            return "LFC";
        }
    }

    class RankingHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvPos)
        TextView tvPos;
        @BindView(R.id.imgLogo)
        ImageView imgLogo;
        @BindView(R.id.tvNameClub)
        TextView tvNameClub;
        @BindView(R.id.tvPlayed)
        TextView tvPlayed;
        @BindView(R.id.tvWin)
        TextView tvWin;
        @BindView(R.id.tvDraw)
        TextView tvDraw;
        @BindView(R.id.tvLost)
        TextView tvLost;
        @BindView(R.id.tvGD)
        TextView tvGD;
        @BindView(R.id.tvPoints)
        TextView tvPoints;
        @BindView(R.id.layoutRowRoot)
        RelativeLayout layoutRowRoot;

        public RankingHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


    class HeaderRankHolder extends RecyclerView.ViewHolder {

        public HeaderRankHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
