package com.xtremelabs.robolectric.view;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.*;

public class TestWindow extends Window {
    public int flags;
    public int requestedFeatureId;
    public int featureDrawableResourceFeatureId;
    public int featureDrawableResourceResId;
    public int softInputMode;

    public TestWindow(Context context) {
        super(context);
    }

    @Override public boolean requestFeature(int featureId) {
        this.requestedFeatureId = featureId;
        return true;
    }

    @Override public void setFlags(int flags, int mask) {
        this.flags = (flags & ~mask) | (flags & mask);
    }

    @Override public void addFlags(int flags) {
        setFlags(flags, flags);
    }

    @Override public boolean isFloating() {
        return false;
    }

    @Override public void setContentView(int layoutResID) {
    }

    @Override public void setContentView(View view) {
    }

    @Override public void setContentView(View view, ViewGroup.LayoutParams params) {
    }

    @Override public void addContentView(View view, ViewGroup.LayoutParams params) {
    }

    @Override public View getCurrentFocus() {
        return null;
    }

    @Override public LayoutInflater getLayoutInflater() {
        return null;
    }

    @Override public void setTitle(CharSequence title) {
    }

    @Override public void setTitleColor(int textColor) {
    }

    @Override public void openPanel(int featureId, KeyEvent event) {
    }

    @Override public void closePanel(int featureId) {
    }

    @Override public void togglePanel(int featureId, KeyEvent event) {
    }

    @Override public boolean performPanelShortcut(int featureId, int keyCode, KeyEvent event, int flags) {
        return false;
    }

    @Override public boolean performPanelIdentifierAction(int featureId, int id, int flags) {
        return false;
    }

    @Override public void closeAllPanels() {
    }

    @Override public boolean performContextMenuIdentifierAction(int id, int flags) {
        return false;
    }

    @Override public void onConfigurationChanged(Configuration newConfig) {
    }

    @Override public void setBackgroundDrawable(Drawable drawable) {
    }

    @Override public void setFeatureDrawableResource(int featureId, int resId) {
        featureDrawableResourceFeatureId = featureId;
        featureDrawableResourceResId = resId;
    }

    @Override public void setFeatureDrawableUri(int featureId, Uri uri) {
    }

    @Override public void setFeatureDrawable(int featureId, Drawable drawable) {
    }

    @Override public void setFeatureDrawableAlpha(int featureId, int alpha) {
    }

    @Override public void setFeatureInt(int featureId, int value) {
    }

    @Override public void takeKeyEvents(boolean get) {
    }

    @Override public boolean superDispatchKeyEvent(KeyEvent event) {
        return false;
    }

    @Override public boolean superDispatchTouchEvent(MotionEvent event) {
        return false;
    }

    @Override public boolean superDispatchTrackballEvent(MotionEvent event) {
        return false;
    }

    @Override public View getDecorView() {
        return null;
    }

    @Override public View peekDecorView() {
        return null;
    }

    @Override public Bundle saveHierarchyState() {
        return null;
    }

    @Override public void restoreHierarchyState(Bundle savedInstanceState) {
    }

    @Override protected void onActive() {
    }

    @Override public void setChildDrawable(int featureId, Drawable drawable) {
    }

    @Override public void setChildInt(int featureId, int value) {
    }

    @Override public boolean isShortcutKey(int keyCode, KeyEvent event) {
        return false;
    }

    @Override public void setVolumeControlStream(int streamType) {
    }

    @Override public int getVolumeControlStream() {
        return 0;
    }

    @Override public void setSoftInputMode(int softInputMode) {
        this.softInputMode = softInputMode;
    }
}
