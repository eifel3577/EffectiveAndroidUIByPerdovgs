package com.example.effectiveandroiduibyperdovgs.ui.renderer.tvshow;

import com.github.pedrovgs.effectiveandroidui.domain.tvshow.TvShow;
import com.pedrogomez.renderers.AdapteeCollection;
import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * AdapteeCollection implementation for TvShow.
 *
 * If you want to lear more about how to use Renderers take a look to this project:
 * https://github.com/pedrovgs/Renderers.
 *
 * @author Pedro Vicente Gómez Sánchez
 */
public class TvShowCollection implements AdapteeCollection<TvShow>, Serializable {
  private static final long serialVersionUID = 8799677673292716638L;

  private final List<TvShow> tvShows;

  public TvShowCollection() {
    this(new LinkedList<TvShow>());
  }

  public TvShowCollection(Collection<TvShow> tvShows) {
    this.tvShows = new LinkedList<TvShow>();
    this.tvShows.addAll(tvShows);
  }

  @Override public int size() {
    return tvShows.size();
  }

  @Override public TvShow get(int index) {
    return tvShows.get(index);
  }

  @Override public void add(TvShow tvShow) {
    tvShows.add(tvShow);
  }

  @Override public void remove(TvShow tvShow) {
    tvShows.remove(tvShow);
  }

  @Override public void addAll(Collection<TvShow> tvShows) {
    this.tvShows.addAll(tvShows);
  }

  @Override public void removeAll(Collection<TvShow> tvShows) {
    this.tvShows.removeAll(tvShows);
  }

  public void clear() {
    tvShows.clear();
  }

  public List<TvShow> getAsList() {
    return (List<TvShow>) ((LinkedList<TvShow>) tvShows).clone();
  }
}
