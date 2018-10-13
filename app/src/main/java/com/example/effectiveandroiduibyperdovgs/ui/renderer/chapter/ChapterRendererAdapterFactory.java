package com.example.effectiveandroiduibyperdovgs.ui.renderer.chapter;

import android.view.LayoutInflater;
import com.github.pedrovgs.effectiveandroidui.domain.tvshow.Chapter;
import com.pedrogomez.renderers.RendererAdapter;
import javax.inject.Inject;

/**
 * Factory created to provide RendererAdapter<Chapter> implementations.
 *
 * If you want to lear more about how to use Renderers take a look to this project:
 * https://github.com/pedrovgs/Renderers.
 *
 * @author Pedro Vicente Gómez Sánchez
 */
public class ChapterRendererAdapterFactory {

  private final ChapterRendererBuilder rendererBuilder;
  private final LayoutInflater layoutInflater;

  @Inject
  public ChapterRendererAdapterFactory(ChapterRendererBuilder rendererBuilder,
      LayoutInflater layoutInflater) {
    this.rendererBuilder = rendererBuilder;
    this.layoutInflater = layoutInflater;
  }

  public RendererAdapter<Chapter> getChapterRendererAdapter(
      final ChapterAdapteeCollection chapterCollection) {
    return new ChapterRendererAdapter(layoutInflater, rendererBuilder, chapterCollection);
  }
}
