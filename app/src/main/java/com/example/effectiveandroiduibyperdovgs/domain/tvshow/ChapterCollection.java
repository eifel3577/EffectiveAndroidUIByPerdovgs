package com.example.effectiveandroiduibyperdovgs.domain.tvshow;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Set of chapters. Contains all the chapters information for each TvShow.
 *
 * This class implements Serializable because we need to put this inside a bundle when the activity
 * lifecycle is restarted. This Serializable implementation could be replaced with a Parcelable
 * implementation if the performance is a problem. This is a sample of how, sometimes, an SDK is
 * going to influence our software design.
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class ChapterCollection implements Iterable<Chapter>, Serializable {

  private static final long serialVersionUID = 8799656478677673292L;

  private final Set<Chapter> chapters;

  public ChapterCollection() {
    this.chapters = new LinkedHashSet<Chapter>();
  }

  public Collection<Chapter> getChapters() {
    return (Collection<Chapter>) ((LinkedHashSet<Chapter>) chapters).clone();
  }

  public void add(Chapter chapter) {
    this.chapters.add(chapter);
  }

  @Override public Iterator<Chapter> iterator() {
    return chapters.iterator();
  }
}
