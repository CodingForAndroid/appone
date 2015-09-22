package com.bczm.widgetcollections.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import android.text.format.DateFormat;
import android.text.format.Time;

public class DateFormatUtil {
	private static final int DAY_MILLIS = 24 * 60 * 60 * 1000;
	private static final int HOUR_MILLIS = 60 * 60 * 1000;
	private static final int MINUTE_MILLIS = 60 * 1000;

	private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static SimpleDateFormat format1 = new SimpleDateFormat("yyyyMMddHHmmss");
	private static SimpleDateFormat format2 = new SimpleDateFormat("MM-dd HH:mm");
	private static SimpleDateFormat format3 = new SimpleDateFormat("yy-MM-dd");
	private static SimpleDateFormat format4 = new SimpleDateFormat("MM");
	private static SimpleDateFormat format5 = new SimpleDateFormat("dd");

	/**
	 * 格式化时间
	 * 
	 * @param datetime
	 * @return
	 */
	public static String format(long datetime) {
		String datetimeStr = null;
		if (datetime != 0) {
			datetimeStr = DateFormat.format("yyyy-MM-dd HH:mm:ss", datetime).toString();
		}
		return datetimeStr;
	}

	/**
	 * 获取时间 分：秒 mm:ss
	 * 
	 * @param 秒数
	 * @return string
	 */
	public static String getTimeShort(int m) {
		String minute;// 分钟
		String second;// 秒
		minute = (m / 60 < 10) ? "0" + m / 60 : m / 60 + "";
		second = (m % 60 < 10) ? "0" + m % 60 : m % 60 + "";
		return minute + ":" + second;
	}

	/**
	 * 播放时间转换
	 * 
	 * @param t
	 * @return
	 */
	public static StringBuffer formatTime(int t) {
		int second = t / 1000;
		int minute = second / 60;
		second = second % 60;
		int hour = minute / 60;
		minute = minute % 60;
		StringBuffer time = new StringBuffer();
		if (hour > 0) {
			time.append(hour).append(':');
		}
		if (minute < 10) {
			time.append(0).append(minute);
		} else {
			time.append(minute);
		}
		time.append(':');
		if (second < 10) {
			time.append(0).append(second);
		} else {
			time.append(second);
		}
		return time;
	}

	public static String formatTime(String datetime) {
		String result = "";
		try {
			Date date = format.parse(datetime);
			Time time = new Time();
			time.set(date.getTime());
			int year = time.year;
			int month = time.month;
			int day = time.monthDay;

			Time now = new Time();
			now.setToNow();

			if (year != now.year || month != now.month || now.monthDay - day > 1) {
				result = format2.format(date);
			} else if (now.monthDay - day == 1) {
				result = "昨天" + format3.format(date);
			} else if (now.monthDay - day == 0) {
				long timeMillis = date.getTime();
				long nowMillis = System.currentTimeMillis();

				int hour = (int) ((nowMillis - timeMillis) / HOUR_MILLIS);
				int minute = (int) ((nowMillis - timeMillis) / MINUTE_MILLIS);
				if (hour >= 1) {
					result = hour + "小时前";
				} else if (minute > 0) {
					result = minute + "分钟前";
				} else {
					result = "刚刚";
				}

			}

		} catch (ParseException e) {
			result = datetime;
			e.printStackTrace();
		}

		return result;

	}

	/**
	 * 是否是今天
	 * 
	 * @param milliseconds
	 *            毫秒
	 * @return
	 */
	public static boolean isToday(long milliseconds) {
		boolean b = false;

		Calendar calDate = Calendar.getInstance();
		calDate.setTimeInMillis(milliseconds);

		Calendar calToday = Calendar.getInstance();
		calToday.setTime(new Date());
		int monthT = (calToday.get(Calendar.MONTH)) + 1;
		int monthD = (calDate.get(Calendar.MONTH)) + 1;

		if (monthT == monthD && calToday.get(Calendar.DAY_OF_MONTH) == calDate.get(Calendar.DAY_OF_MONTH)) {
			return true;
		}
		return false;
	}

	/**
	 * 格式化时间字符串
	 * 
	 * @param dateStr
	 * @return
	 */
	public static String formatDateStr(String dateStr) {
		try {
			Date date = format1.parse(dateStr);
			return format.format(date);
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dateStr;
	}

	/**
	 * 格式化日期
	 * 
	 * @param dateStr
	 * @return
	 */
	public static String formatDate(String dateStr) {
		try {
			Date date = format.parse(dateStr);
			return format3.format(date);
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dateStr;
	}

	/**
	 * 两个日期相差的天数
	 * 
	 * @param startDate
	 * @param endDate
	 * @return 相差天数
	 */
	public static int getDayCount(String startDate, String endDate) {
		try {
			long start = format.parse(startDate).getTime();
			long end = format.parse(endDate).getTime();
			return (int) ((end - start) / DAY_MILLIS);
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (Exception e) {

		}
		return 0;
	}
}
