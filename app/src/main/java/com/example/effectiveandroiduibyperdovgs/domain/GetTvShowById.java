package com.example.effectiveandroiduibyperdovgs.domain;


import com.example.effectiveandroiduibyperdovgs.domain.tvshow.TvShow;

/**
 * Get a TvShow given a TvShow identifier. Return the result using a Callback.
 *
 * This interactor can execute onTvShowNotFound Callback method if there is no any tv show that
 * matches with the tvShowId passed as parameter. Other possible result is the execution of
 * OnConnectionError when there is no internet connection and the client code executes this
 * interactor.
 *
 * @author Pedro Vicente Gómez Sánchez
 */
public interface GetTvShowById {

  interface Callback {
    void onTvShowLoaded(final TvShow tvShow);

    void onTvShowNotFound();

    void onConnectionError();
  }

  void execute(final String tvShowId, final Callback callback);
}
