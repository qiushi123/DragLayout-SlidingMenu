#侧滑菜单&侧滑面板的实现（仿QQ5.0）
	-用自定义的布局（侧滑菜单）来实现侧滑的效果
##特点
	1，可以实现侧滑菜单的效果，使用起来特别方便
	2，可以在侧滑的同时实现一些动画效果。

#先看效果图
##仿QQ5.0的侧滑菜单
![图片](http://a2.qpic.cn/psb?/V13yyfT93I2jgl/S4FZBiN1ENeB4rc3ZyQu02EiOTQr9Ww1oEq57iWSWDU!/b/dB4BAAAAAAAA&bo=bAGGAmwBhgICEDQ!&rf=viewer_4)

##简单的侧滑效果
![文字](http://a2.qpic.cn/psb?/V13yyfT93I2jgl/bhr.4kEHMM7G5GNdbdlrjRk9TFrpwP9DPb4kcEaPG7A!/b/dB4BAAAAAAAA&bo=bAGGAmwBhgICDCg!&rf=viewer_4)


##带缩放效果的侧滑菜单
![图片](http://a2.qpic.cn/psb?/V13yyfT93I2jgl/X1OHhjJ2Avyl8IpfOwgoDmkkKUtcVl.j4KgM41IaRtg!/b/dBsBAAAAAAAA&bo=bAGGAmwBhgICKg4!&rf=viewer_4)![图片](http://a3.qpic.cn/psb?/V13yyfT93I2jgl/6g97V1fuBG6A7PwtXF2neITvWU.u0mqP0MhYOG19wvw!/b/dKEAAAAAAAAA&bo=bAGGAmwBhgICKw8!&rf=viewer_4)




#使用步骤
##只需完成下面三步，就能使用这个自定义的侧滑菜单控件

##1 导包
	将dragLayout.jar包导入到你的项目中。

##2，布局文件
### 布局中使用这个自定义的侧滑菜单控件，里面必须有两个面板。一个是左侧菜单面板，一个是主面板

	<com.shitou.cehua.DragLayout 
		xmlns:android="http://schemas.android.com/apk/res/android"
	    xmlns:tools="http://schemas.android.com/tools"
	    android:layout_width="match_parent"
	    android:layout_height="match_parent"
	    android:background="@drawable/bg"
	    android:id="@+id/dl" >

	    <!-- 左侧菜单面板布局 -->
		<LinearLayout 
		    android:layout_width="match_parent"
		    android:layout_height="match_parent"
		    android:orientation="vertical"
		    android:background="#88FF1515"
		    >
		    </LinearLayout>
		
		<!-- 主面板布局 -->
		<LinearLayout 
		    android:layout_width="match_parent"
		    android:layout_height="match_parent"
		    android:orientation="vertical"
		    android:background="#660000ff"
		    >
		    </LinearLayout>
	</com.shitou.cehua.DragLayout>

##3,在activity中设置必要的参数，并设置监听器。
###注意：使用setDragRange可以设置侧滑主面板距离左侧屏幕的距离
###setOnDragStateChangeListener这个监听器必须设置。否则会影响一些方法的实现。

    public class MainActivity extends Activity {
	 private DragLayout dl;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		dl=(DragLayout) findViewById(R.id.dl);//找到我们的自定义侧滑菜单控件
		
		//调用setDragRange设置侧滑菜单可以滑动的最大距离，只能传入0-1.0f之间的float数值
		dl.setDragRange(0.7f);
		
		//为DragLayout控件设置监听事件。这一步必须有。即便你不实现任何方法。
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

有源码，不懂的可以去看下源码,DragLayoutQQ是仿QQ5.0新特性的侧滑效果。