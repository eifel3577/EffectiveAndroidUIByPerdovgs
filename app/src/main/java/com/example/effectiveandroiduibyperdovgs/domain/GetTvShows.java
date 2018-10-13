package com.example.effectiveandroiduibyperdovgs.domain;

import com.github.pedrovgs.effectiveandroidui.domain.tvshow.TvShow;
import java.util.Collection;

/**
 * Returns every available TvShow in the system.
 *
 * This interactor will not the result is the execution finish with a onConnectionError when there
 * is no internet connection and the client code executes this interactor.
 *
 * @author Pedro Vicente Gómez Sánchez
 */
public interface GetTvShows {

  interface Callback {
    void onTvShowsLoaded(final Collection<TvShow> tvShows);

    void onConnectionError();
  }

  void execute(Callback callback);
}
