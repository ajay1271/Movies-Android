package com.ajayspace.cinema

import android.content.Context
import android.util.AttributeSet
import android.view.View.MeasureSpec
import android.view.ViewGroup
import android.widget.GridView

/*
 * A custom class to to make gridview expandable on screen
 */
class ExpandableHeightGridView : GridView {
    var isExpanded = false

    constructor(context: Context?) : super(context) {}
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {}
    constructor(
        context: Context?, attrs: AttributeSet?,
        defStyle: Int
    ) : super(context, attrs, defStyle) {
    }

    public override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        if (isExpanded) {
            // Calculate entire height by providing a very large height hint.
            // View.MEASURED_SIZE_MASK represents the largest height possible.
            val expandSpec = MeasureSpec.makeMeasureSpec(
                MEASURED_SIZE_MASK,
                MeasureSpec.AT_MOST
            )
            super.onMeasure(widthMeasureSpec, expandSpec)
            val params = layoutParams
            params.height = measuredHeight
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        }
    }
}