package com.huami.android.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.xiaomi.hm.health.a.j;

public class CustomViewPager extends ViewPager {
    private boolean d;

    public CustomViewPager(Context context) {
        super(context);
    }

    public CustomViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.CustomViewPager);
        try {
            this.d = obtainStyledAttributes.getBoolean(j.CustomViewPager_swipeable, true);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public void b(boolean z) {
        this.d = z;
    }

    public boolean n() {
        return this.d;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.d ? super.onInterceptTouchEvent(motionEvent) : false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.d ? super.onTouchEvent(motionEvent) : false;
    }
}
