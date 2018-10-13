package com.example.effectiveandroiduibyperdovgs.ui.renderer.chapterviewmodel;

import android.view.LayoutInflater;
import com.github.pedrovgs.effectiveandroidui.ui.viewmodel.ChapterViewModel;
import com.pedrogomez.renderers.RendererAdapter;
import javax.inject.Inject;

/**
 * Factory created to provide RendererAdapter<ChapterViewModel> implementations.
 *
 * If you want to lear more about how to use Renderers take a look to this project:
 * https://github.com/pedrovgs/Renderers.
 *
 * @author Pedro Vicente Gómez Sánchez
 */
public class ChapterViewModelRendererAdapterFactory {

  private final ChapterViewModelRendererBuilder rendererBuilder;
  private final LayoutInflater layoutInflater;

  @Inject
  public ChapterViewModelRendererAdapterFactory(ChapterViewModelRendererBuilder rendererBuilder,
      LayoutInflater layoutInflater) {
    this.rendererBuilder = rendererBuilder;
    this.layoutInflater = layoutInflater;
  }

  public RendererAdapter<ChapterViewModel> getChapterRendererAdapter(
      final ChapterViewModelCollection chapterCollection) {
    return new ChapterViewModelRendererAdapter(layoutInflater, rendererBuilder, chapterCollection);
  }
}
