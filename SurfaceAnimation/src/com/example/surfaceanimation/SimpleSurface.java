package com.example.surfaceanimation;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class SimpleSurface extends SurfaceView {
	Paint p;

	public SimpleSurface(Context context) {
		super(context);
		init();
	}

	public SimpleSurface(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public SimpleSurface(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	private void init() {
		p = new Paint();
		p.setColor(Color.CYAN);
		getHolder().addCallback(new SurfaceHolder.Callback() {

			@Override
			public void surfaceDestroyed(SurfaceHolder holder) {
			}

			@Override
			public void surfaceCreated(SurfaceHolder holder) {
				draw(holder);
			}

			@Override
			public void surfaceChanged(SurfaceHolder holder, int format,
					int width, int height) {
			}
		});

	}

	private void draw(SurfaceHolder holder) {
		final SurfaceHolder h = holder;
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 500; i++) {
					Canvas canvas = h.lockCanvas();
					canvas.drawColor(Color.WHITE);
					canvas.drawCircle(50 + i, 50 + i, 20, p);
					h.unlockCanvasAndPost(canvas);
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		thread.start();
	}
}
