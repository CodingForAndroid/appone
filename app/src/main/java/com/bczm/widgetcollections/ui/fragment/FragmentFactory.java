package com.bczm.widgetcollections.ui.fragment;


import java.util.HashMap;
import java.util.Map;

public class FragmentFactory {
	public static final int TAB_FIRST = 0;
	public static final int TAB_SECOND = 1;
	public static final int TAB_THIRD = 2;
	public static final int TAB_FOURTH = 3;
	/** 记录所有的fragment，防止重复创建 */
	private static Map<Integer, BaseFragment> mFragmentMap = new HashMap<Integer, BaseFragment>();

	/** 采用工厂类进行创建Fragment，便于扩展，已经创建的Fragment不再创建 */
	public static BaseFragment createFragment(int index) {
		BaseFragment fragment = mFragmentMap.get(index);
		if (fragment == null) {
			switch (index) {
				case TAB_FIRST:
					fragment = new RecommandFragment();
					break;
				case TAB_SECOND:
					fragment = new AppFragment();
					break;
				case TAB_THIRD:
					fragment = new AppFragment();
					break;
				case TAB_FOURTH:
					fragment = new AppFragment();
					break;
			}
			mFragmentMap.put(index, fragment);
		}
		return fragment;
	}
}
