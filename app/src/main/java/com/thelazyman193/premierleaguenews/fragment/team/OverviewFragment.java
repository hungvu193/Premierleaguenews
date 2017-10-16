package com.thelazyman193.premierleaguenews.fragment.team;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.thelazyman193.premierleaguenews.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by hungvu on 10/2/2017.
 * Project PremierLeagueNews
 * Package com.thelazyman193.premierleaguenews.fragment
 */

public class OverviewFragment extends Fragment {
    @BindView(R.id.webView)
    WebView webView;
    private static OverviewFragment overviewFragment = null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_overview, container, false);
        ButterKnife.bind(this, view);
        String linkNews = getArguments().getString("link");
        webView.loadUrl(linkNews);
        return view;
    }

    public static OverviewFragment getInstance(String overview) {
        if (overviewFragment == null) {
            overviewFragment = new OverviewFragment();
        }
        Bundle bundle = new Bundle();
        bundle.putString("link", overview);
        overviewFragment.setArguments(bundle);
        return overviewFragment;
    }
}
