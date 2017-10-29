package com.thelazyman193.premierleaguenews.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.thelazyman193.premierleaguenews.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by hungvu on 8/29/2017.
 * Project PremierLeagueNews
 * Package com.thelazyman193.premierleaguenews.fragment
 */

public class NewFragment extends Fragment {
    @BindView(R.id.webView)
    WebView webView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new,container,false);
        ButterKnife.bind(this,view);
        WebViewClient webViewClient = new WebViewClient();
        webView.setWebViewClient(webViewClient);
        webView.loadUrl("https://www.premierleague.com/");
        return view;
    }
}
