package com.bczm.widgetcollections.utils;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AlphaAnimation;

public class ViewUtils {
	/** 把自身从父View中移除 */
	public static void removeSelfFromParent(View view) {
		if (view != null) {
			ViewParent parent = view.getParent();
			if (parent != null && parent instanceof ViewGroup) {
				ViewGroup group = (ViewGroup) parent;
				group.removeView(view);
			}
		}
	}

	/** 请求View树重新布局，用于解决中层View有布局状态而导致上层View状态断裂 */
	public static void requestLayoutParent(View view, boolean isAll) {
		ViewParent parent = view.getParent();
		while (parent != null && parent instanceof View) {
			if (!parent.isLayoutRequested()) {
				parent.requestLayout();
				if (!isAll) {
					break;
				}
			}
			parent = parent.getParent();
		}
	}

	/** 判断触点是否落在该View上 */
	public static boolean isTouchInView(MotionEvent ev, View v) {
		int[] vLoc = new int[2];
		v.getLocationOnScreen(vLoc);
		float motionX = ev.getRawX();
		float motionY = ev.getRawY();
		return motionX >= vLoc[0] && motionX <= (vLoc[0] + v.getWidth()) && motionY >= vLoc[1] && motionY <= (vLoc[1] + v.getHeight());
	}

	/** FindViewById的泛型封装，减少强转代码 */
	public static <T extends View> T findViewById(View layout, int id) {
		return (T) layout.findViewById(id);
	}

	/**
	 * 显示View
	 * @param v
	 */
	public static void showView(View v) {
		if (v != null)
			v.setVisibility(View.VISIBLE);
	}

	/**
	 * 隐藏View
	 * @param v
	 */
	public static void hideView(View v) {
		if (v != null)
			v.setVisibility(View.GONE);
	}

	public static void invisibleView(View v) {
		if (v != null)
			v.setVisibility(View.INVISIBLE);
	}

	/**
	 * 逐渐显示 View
	 * @param v
	 */
	public static void showAlphaView(View v) {
		if (v.getVisibility() == View.VISIBLE)
			return;
		v.setVisibility(View.VISIBLE);
		AlphaAnimation aa = new AlphaAnimation(0.0f, 1.0f);
		aa.setDuration(2000);
		v.setAnimation(aa);

	}

	/**
	 * 逐渐隐藏view
	 * @param v
	 */
	public static void hideAlphaView(View v) {
		if (v.getVisibility() == View.GONE)
			return;
		AlphaAnimation aa = new AlphaAnimation(1.0f, 0.0f);
		aa.setDuration(2000);
		v.setAnimation(aa);
		v.setVisibility(View.GONE);

	}
}
