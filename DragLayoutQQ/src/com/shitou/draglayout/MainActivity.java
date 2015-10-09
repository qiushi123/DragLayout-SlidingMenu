package com.shitou.draglayout;

import java.util.Random;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.CycleInterpolator;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.nineoldandroids.animation.ObjectAnimator;
import com.nineoldandroids.view.ViewHelper;
import com.shitou.cehua.DragLayout;
import com.shitou.cehua.DragLayout.OnDragStateChangeListener;
import com.shitou.draglayout.bean.Cheeses;
import com.shitou.draglayout.util.ToastUtil;
import com.shitou.draglayout.view.InnerLinearLayout;

public class MainActivity extends Activity {

    private ListView mLvMain;
    private ListView mLvLeft;
    private DragLayout mDl;
    private ImageView mIvHead;
    private InnerLinearLayout mIll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLvMain = (ListView) findViewById(R.id.lv_main);
        mLvLeft = (ListView) findViewById(R.id.lv_left);
        mDl = (DragLayout) findViewById(R.id.dl);
        mIvHead = (ImageView) findViewById(R.id.iv_head);
        mIll = (InnerLinearLayout) findViewById(R.id.ill);
        mIll.setDragLayout(mDl);
        mLvMain.setAdapter(new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_list_item_1, Cheeses.NAMES) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                TextView tv = (TextView) super.getView(position, convertView, parent);
                tv.setTextColor(Color.BLACK);
                return tv;
            }
        });
        mLvLeft.setAdapter(new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_list_item_1, Cheeses.sCheeseStrings));
        mDl.setOnDragStateChangeListener(new OnDragStateChangeListener() {

            @Override
            public void onOpen() {
                ToastUtil.showToast(getApplicationContext(), "我打开了");
                mLvLeft.smoothScrollToPosition(new Random().nextInt(50));
            }

            @Override
            public void onDragging(float percent) {
                ToastUtil.showToast(getApplicationContext(), "percent:" + percent);
                ViewHelper.setAlpha(mIvHead, 1.0f-percent);
            }

            @Override
            public void onClose() {
                ToastUtil.showToast(getApplicationContext(), "我关闭了");
//                mIvHead.setTranslationX(translationX);
                ObjectAnimator animator = ObjectAnimator.ofFloat(mIvHead, "translationX", 15f);
                animator.setInterpolator(new CycleInterpolator(4.0f));
                animator.setDuration(500);
                animator.start();
            }
        });
    }
}
