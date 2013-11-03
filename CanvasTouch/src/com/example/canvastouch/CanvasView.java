package com.example.canvastouch;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class CanvasView extends View {
	private Path path;
	private Paint p;

	public CanvasView(Context context) {
		super(context);
		init();
	}

	public CanvasView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public CanvasView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	private void init() {
		p = new Paint();
		p.setColor(Color.CYAN);
		p.setStrokeWidth(10);
		p.setStyle(Paint.Style.STROKE);
		p.setStrokeJoin(Paint.Join.ROUND);
		path = new Path();
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		canvas.drawPath(path, p);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			path.moveTo(event.getX(), event.getY());
			break;
		case MotionEvent.ACTION_MOVE:
			path.lineTo(event.getX(), event.getY());
			break;
		case MotionEvent.ACTION_UP:
			path.lineTo(event.getX(), event.getY());
			break;
		}
		invalidate();
		return true;
	}

}
