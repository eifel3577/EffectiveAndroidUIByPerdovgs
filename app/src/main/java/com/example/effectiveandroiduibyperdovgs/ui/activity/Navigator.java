package com.example.effectiveandroiduibyperdovgs.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;


import javax.inject.Inject;

/**
 * Class created to handle all the navigation between activities. This class knows how to open
 * every activity in the application and provides to the client code different methods to start
 * activities with the information needed.
 * <p/>
 * You can use other approach based on ActionCommands if you wish. To do that review MVVM
 * pattern and ActionCommand interface.
 *
 * @author Pedro Vicente Gómez Sánchez
 */
public class Navigator {

    private TvShowFragment tvShowFragment;
    private TvShowDraggableFragment tvShowDraggableFragment;

    private final Context activityContext;

    @Inject
    public Navigator(@ActivityContext Context activityContext) {
        this.activityContext = activityContext;
    }

    /*
     * This method contains the key of the application navigation. If there are no fragments attached
     * we will launch TvShowActivity.
     *
     * If any fragment is visible on injected activity, we will load the TvShow.
     *
     * Other approach to connect fragments could be based on a Bus event implementation. But this is
     * only valid if you only have fragments in your activity.
     *
     */
    public void openTvShowDetails(TvShow tvShow) {

        if (canInteractWithFragments()) {
            showTvShowOnTvShowDraggableFragment(tvShow);
            showTvShowOnTvShowFragment(tvShow);
        } else {
            openTvShowActivity(tvShow.getTitle());
        }
    }

    private FragmentManager getFragmentManager() {
        return ((FragmentActivity) activityContext).getSupportFragmentManager();
    }

    private boolean canInteractWithFragments() {
        tvShowFragment = (TvShowFragment) getFragmentManager().findFragmentById(R.id.f_tv_show);
        tvShowDraggableFragment =
                (TvShowDraggableFragment) getFragmentManager().findFragmentById(R.id.f_tv_show_draggable);

        return tvShowDraggableFragment != null || tvShowFragment != null;
    }

    private void showTvShowOnTvShowDraggableFragment(TvShow tvShow) {
        if (isFragmentAvailable(tvShowDraggableFragment)) {
            tvShowDraggableFragment.showTvShow(tvShow.getTitle());
        }
    }

    private void showTvShowOnTvShowFragment(TvShow tvShow) {
        if (isFragmentAvailable(tvShowFragment)) {
            tvShowFragment.showTvShow(tvShow.getTitle());
        }
    }

    /**
     * Check if the fragment is ready to be notified of a new TvShow loaded.
     *
     * @return true if the Fragment instance is not null and is attached.
     */
    private boolean isFragmentAvailable(Fragment fragment) {
        return fragment != null && fragment.isAdded();
    }

    /**
     * Open TvShowActivity using a tvShowId.
     */
    public void openTvShowActivity(final String tvShowId) {
        Intent intent = TvShowActivity.getLaunchIntent(activityContext, tvShowId);
        startActivity(intent);
    }

    private void startActivity(Intent intent) {
        activityContext.startActivity(intent);
    }
}