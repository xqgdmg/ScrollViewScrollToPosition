package dmg.xqg.com.scrollviewscrolltoposition.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.ScrollView;

/**
 * @author: chris
 * @time: 2018/3/26 08:29
 * @description: 去除ScrollView自动滑动到底部。滑动到指定位置，重写api去除api 23的限制
 */
public class NoAutoScrollViewWithPosition extends ScrollView {

    private ScrollViewListener scrollViewListener;

    public NoAutoScrollViewWithPosition(Context context) {
        super(context);
    }

    public NoAutoScrollViewWithPosition(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NoAutoScrollViewWithPosition(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected int computeScrollDeltaToGetChildRectOnScreen(Rect rect) {
        return 0;
    }

    public void setScrollViewListener(ScrollViewListener scrollViewListener) {
        this.scrollViewListener = scrollViewListener;
    }

    @Override
    protected void onScrollChanged(int x, int y, int oldx, int oldy) {
        super.onScrollChanged(x, y, oldx, oldy);
        if (scrollViewListener != null) {
            scrollViewListener.onScrollChanged(this, x, y, oldx, oldy);
        }
    }

    public interface ScrollViewListener {
        void onScrollChanged(NoAutoScrollViewWithPosition noAutoScrollViewWithPosition, int x, int y, int oldx, int oldy);
    }
}
