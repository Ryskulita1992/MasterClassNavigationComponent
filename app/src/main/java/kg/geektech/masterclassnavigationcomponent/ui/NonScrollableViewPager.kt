package kg.geektech.masterclassnavigationcomponent.ui

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.viewpager.widget.ViewPager

class NonScrollableViewPager(context: Context, attrs: AttributeSet?) : ViewPager(context, attrs) {

    private val isScrollable: Boolean = false

    override fun onTouchEvent(ev: MotionEvent?): Boolean {
        return isScrollable && super.onTouchEvent(ev)
    }

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        return isScrollable && super.onInterceptTouchEvent(ev)
    }
}