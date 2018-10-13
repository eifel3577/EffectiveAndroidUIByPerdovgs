package com.example.effectiveandroiduibyperdovgs.domain;


import com.example.effectiveandroiduibyperdovgs.domain.exception.TvShowNotFoundException;
import com.example.effectiveandroiduibyperdovgs.domain.tvshow.Catalog;
import com.example.effectiveandroiduibyperdovgs.domain.tvshow.TvShow;
import com.example.effectiveandroiduibyperdovgs.executor.Executor;
import com.example.effectiveandroiduibyperdovgs.executor.Interactor;
import com.example.effectiveandroiduibyperdovgs.executor.MainThread;
import com.example.effectiveandroiduibyperdovgs.util.RandomUtils;
import com.example.effectiveandroiduibyperdovgs.util.StringUtils;

import javax.inject.Inject;

/**
 * GetTvShowById implementation. This interactor will go out of the UI thread using the
 * executor, then will get a TvShow from the Catalog using the TvShow identifier  and will return
 * the result over the main thread using a callback and MainThread dependency.
 *
 * This application is a sample about how to work effectively on Android, this interactor will
 * return an error randomly.
 *
 * This interactor also contains a little delay to simulate a internal http request.
 *
 * @author Pedro Vicente Gómez Sánchez
 */
class GetTvShowByIdInteractor implements Interactor, GetTvShowById {

  private static final int PERCENTAGE_OF_FAILS = 50;
  private static final long WAIT_TIME = 1500;

  private final Executor executor;
  private final MainThread mainThread;
  private final Catalog catalog;

  private String tvShowId;
  private Callback callback;

  @Inject GetTvShowByIdInteractor(Executor executor, MainThread mainThread, Catalog catalog) {
    this.executor = executor;
    this.mainThread = mainThread;
    this.catalog = catalog;
  }

  @Override public void execute(final String tvShowId, final Callback callback) {
    validateArguments(callback, tvShowId);
    this.callback = callback;
    this.tvShowId = tvShowId;
    this.executor.run(this);
  }

  @Override public void run() {
    waitToDoThisSampleMoreInteresting();

    if (haveToShowError()) {
      notifyConnectionError();
    } else {
      searchTvShow();
    }
  }

  /**
   * To simulate a we are getting the TvShows data from internet we are going to force a 1.5
   * seconds
   * delay using Thread.sleep.
   */
  private void waitToDoThisSampleMoreInteresting() {
    try {
      Thread.sleep(WAIT_TIME);
    } catch (InterruptedException e) {
      //Empty
    }
  }

  private boolean haveToShowError() {
    return RandomUtils.percent(PERCENTAGE_OF_FAILS);
  }

  private void searchTvShow() {
    TvShow tvShow = null;
    try {
      tvShow = this.catalog.getTvShowById(tvShowId);
    } catch (TvShowNotFoundException e) {
      notifyTvShowNotFound();
    }
    notifyTvShowFound(tvShow);
  }

  private void validateArguments(Callback callback, String tvShowId) {
    if (StringUtils.isNullOrEmpty(tvShowId)) {
      throw new IllegalArgumentException("TvShowId parameter can't be null");
    }
    if (callback == null) {
      throw new IllegalArgumentException("Callback parameter can't be null");
    }
  }

  private void notifyConnectionError() {
    mainThread.post(new Runnable() {
      @Override public void run() {
        callback.onConnectionError();
      }
    });
  }

  private void notifyTvShowFound(final TvShow tvShow) {
    mainThread.post(new Runnable() {
      @Override public void run() {
        callback.onTvShowLoaded(tvShow);
      }
    });
  }

  private void notifyTvShowNotFound() {
    mainThread.post(new Runnable() {
      @Override public void run() {
        callback.onTvShowNotFound();
      }
    });
  }
}
