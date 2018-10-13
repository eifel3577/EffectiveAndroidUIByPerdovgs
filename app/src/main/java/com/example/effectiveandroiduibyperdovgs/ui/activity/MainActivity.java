package com.example.effectiveandroiduibyperdovgs.ui.activity;


import android.os.Bundle;

import com.example.effectiveandroiduibyperdovgs.R;

import java.util.LinkedList;
import java.util.List;

/**
 * Core activity of this application. This activity receives the launch intent and works as core of
 * the sample application.
 */
public class MainActivity extends BaseActivity {

    private TvShowFragment tvShowFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeTvShowFragment();
        initializeTvShowDraggableFragment();
    }

    @Override
    protected List<Object> getModules() {
        LinkedList<Object> modules = new LinkedList<>();
        modules.add(new TvShowUIModule());
        return modules;
    }

    private void initializeTvShowFragment() {
        tvShowFragment = (TvShowFragment) getSupportFragmentManager().findFragmentById(R.id.f_tv_show);
    }

    private void initializeTvShowDraggableFragment() {
        TvShowDraggableFragment tvShowDraggableFragment =
                (TvShowDraggableFragment) getSupportFragmentManager().findFragmentById(
                        R.id.f_tv_show_draggable);
    /*
     * If both fragments are visible we have to disable saved instance state in draggable
     * fragment because there are different fragment configurations in activity_main.xml
     * when the device is in portrait or landscape. Review layout- directory to get more
     * information.
     */
        if (tvShowFragment != null && tvShowDraggableFragment != null) {
            tvShowDraggableFragment.disableSaveInstanceState();
        }
    }
}