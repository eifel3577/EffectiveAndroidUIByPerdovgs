package com.example.effectiveandroiduibyperdovgs.ui.renderer.chapter;

import com.github.pedrovgs.effectiveandroidui.domain.tvshow.Chapter;
import com.pedrogomez.renderers.AdapteeCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * AdapteeCollection implementation for Chapters.
 *
 * I've changed the name of this collection form ChapterCollection to ChapterAdapteeCollection
 * because there is a name collision.
 *
 * If you want to lear more about how to use Renderers take a look to this project:
 * https://github.com/pedrovgs/Renderers.
 *
 * @author Pedro Vicente Gómez Sánchez
 */
public class ChapterAdapteeCollection implements AdapteeCollection<Chapter> {

  private final List<Chapter> chapters;

  public ChapterAdapteeCollection() {
    this(new ArrayList<Chapter>());
  }

  public ChapterAdapteeCollection(List<Chapter> chapters) {
    this.chapters = chapters;
  }

  @Override public int size() {
    return chapters.size();
  }

  @Override public Chapter get(int index) {
    return chapters.get(index);
  }

  @Override public void add(Chapter chapter) {
    chapters.add(chapter);
  }

  @Override public void remove(Chapter chapter) {
    chapters.remove(chapter);
  }

  @Override public void addAll(Collection<Chapter> chapters) {
    this.chapters.addAll(chapters);
  }

  @Override public void removeAll(Collection<Chapter> chapters) {
    this.chapters.removeAll(chapters);
  }

  public void clear() {
    chapters.clear();
  }
}
