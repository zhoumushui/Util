package com.util;

import android.util.Log;

public class MyLog {
	private final static String TAG = "AZ";
	private final static boolean isDebug = true;

	public static void e(String log) {
		if (isDebug) {
			String systemTime = TimeUtil.getTimeStr("HH:mm:ss");
			Log.e(TAG, systemTime + "-" + log);
		}
	}

	public static void v(String log) {
		if (isDebug) {
			String systemTime = TimeUtil.getTimeStr("HH:mm:ss");
			Log.v(TAG, systemTime + "-" + log);
		}
	}

	public static void d(String log) {
		if (isDebug) {
			String systemTime = TimeUtil.getTimeStr("HH:mm:ss");
			Log.d(TAG, systemTime + "-" + log);
		}
	}

	public static void i(String log) {
		if (isDebug) {
			String systemTime = TimeUtil.getTimeStr("HH:mm:ss");
			Log.i(TAG, systemTime + "-" + log);
		}
	}

	public static void w(String log) {
		if (isDebug) {
			String systemTime = TimeUtil.getTimeStr("HH:mm:ss");
			Log.w(TAG, systemTime + "-" + log);
		}
	}

}
