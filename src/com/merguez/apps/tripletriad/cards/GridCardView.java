package com.merguez.apps.tripletriad.cards;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

public class GridCardView extends GridView {
	

	public GridCardView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	public GridCardView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}
	public GridCardView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// TODO Auto-generated method stub
		int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);

        android.view.ViewGroup.LayoutParams params =  getLayoutParams();
        params.height = getMeasuredHeight();

	}
}
