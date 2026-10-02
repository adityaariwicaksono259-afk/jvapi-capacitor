package com.jvapi.app;

import android.os.Bundle;
import android.webkit.WebSettings;
import com.getcapacitor.BridgeActivity;

public class MainActivity extends BridgeActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        applySettings();
    }

    @Override
    public void onResume() {
        super.onResume();
        applySettings();
    }

    private void applySettings() {
        try {
            if (getBridge() == null || getBridge().getWebView() == null) return;
            WebSettings s = getBridge().getWebView().getSettings();
            s.setMediaPlaybackRequiresUserGesture(false);
            s.setJavaScriptEnabled(true);
            s.setDomStorageEnabled(true);
            s.setAllowFileAccess(true);
            s.setAllowContentAccess(true);
            s.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
            s.setUseWideViewPort(true);
            s.setLoadWithOverviewMode(true);
            getBridge().getWebView().setBackgroundColor(0x00000000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
