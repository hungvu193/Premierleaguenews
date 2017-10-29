package com.thelazyman193.premierleaguenews.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.thelazyman193.premierleaguenews.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by hungvu on 8/29/2017.
 * Project PremierLeagueNews
 * Package com.thelazyman193.premierleaguenews.fragment
 */

public class MoreFragment extends Fragment {
    @BindView(R.id.layoutAbout)
    LinearLayout layoutAbout;
    @BindView(R.id.layoutFanpage)
    LinearLayout layoutFanpage;
    @BindView(R.id.layoutPro)
    LinearLayout layoutPro;
    @BindView(R.id.layoutShare)
    LinearLayout layoutShare;
    private static String store_deep_link = "http://play.google.com/store/apps/details?id=com.thelazyman193.premierleaguenews";
    private static String fanpge_link = "https://www.facebook.com/thegioixungquanh193/";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_more, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.layoutAbout)
    public void setLayoutAbout() {
        showAlertAbount();
    }
    @OnClick(R.id.layoutPro)
    public void setLayoutPro(){
        actionIntent(store_deep_link);
    }


    @OnClick(R.id.layoutFanpage)
    public void setLayoutFanpage(){
        actionIntent(fanpge_link);
    }

    @OnClick(R.id.layoutShare)
    public void setLayoutShare(){
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, store_deep_link);
        sendIntent.setType("text/plain");
        startActivity(sendIntent);
    }

    public void actionIntent(String link){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(link));
        startActivity(intent);
    }

    public void showAlertAbount() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("About");
        builder.setMessage("Project III - MSSV : 20135730");
        builder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
