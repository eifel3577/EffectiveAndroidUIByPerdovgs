package com.example.effectiveandroiduibyperdovgs.domain;

import com.github.pedrovgs.effectiveandroidui.domain.tvshow.Catalog;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * Dagger module created to provide every domain dependencies as interactors or the main class of
 * this application: Catalog.
 *
 * @author Pedro Vicente Gómez Sánchez
 */
@Module(library = true, complete = false)
public final class TvShowsModule {

  @Provides @Singleton Catalog provideCatalog() {
    return new Catalog();
  }

  @Provides GetTvShows provideGetTvShowsInteractor(GetTvShowsInteractor interactor) {
    return interactor;
  }

  @Provides GetTvShowById provideGetTvShowbyIdInteractor(GetTvShowByIdInteractor interactor) {
    return interactor;
  }
}
