package com.shitou.cehua;

import com.shitou.cehua.DragLayout.OnDragStateChangeListener;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {
	 private DragLayout dl;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		dl=(DragLayout) findViewById(R.id.dl);
		dl.setDragRange(0.7f);
		dl.setOnDragStateChangeListener(new OnDragStateChangeListener() {
			
			@Override
			public void onOpen() {
			}
			
			@Override
			public void onDragging(float percent) {
			}
			
			@Override
			public void onClose() {
			}
		});
	}

}
