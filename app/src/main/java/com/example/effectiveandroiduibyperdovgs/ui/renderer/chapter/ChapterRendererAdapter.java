package com.example.effectiveandroiduibyperdovgs.ui.renderer.chapter;

import android.view.LayoutInflater;
import com.github.pedrovgs.effectiveandroidui.domain.tvshow.Chapter;
import com.pedrogomez.renderers.AdapteeCollection;
import com.pedrogomez.renderers.Renderer;
import com.pedrogomez.renderers.RendererAdapter;
import com.pedrogomez.renderers.RendererBuilder;

/**
 * RendererAdapter extension created to provide position information to every Renderer<Chapter>
 *
 * If you want to lear more about how to use Renderers take a look to this project:
 * https://github.com/pedrovgs/Renderers.
 *
 * @author Pedro Vicente Gómez Sánchez
 */
public class ChapterRendererAdapter extends RendererAdapter<Chapter> {

  public ChapterRendererAdapter(LayoutInflater layoutInflater, RendererBuilder rendererBuilder,
      AdapteeCollection<Chapter> collection) {
    super(layoutInflater, rendererBuilder, collection);
  }

  @Override protected void updateRendererExtraValues(Chapter content, Renderer<Chapter> renderer,
      int position) {
    super.updateRendererExtraValues(content, renderer, position);
    ((ChapterRenderer) renderer).setPosition(position);
  }
}
