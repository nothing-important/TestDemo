package com.example.nothing.testdemo.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nothing.testdemo.api.UnityConstants;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DriveFragment extends Fragment {

    private View playerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        playerView = UnityConstants.unityPlayer.getView();
        if(playerView.getParent() != null){
            ((ViewGroup)playerView.getParent()).removeAllViews();
        }
        playerView.getViewTreeObserver().addOnWindowFocusChangeListener(hasFocus -> UnityConstants.unityPlayer.windowFocusChanged(hasFocus));
        return playerView;
    }

    @Override
    public void onResume() {
        UnityConstants.unityPlayer.resume();
        super.onResume();
    }

    @Override
    public void onPause() {
        UnityConstants.unityPlayer.pause();
        super.onPause();
    }
}
