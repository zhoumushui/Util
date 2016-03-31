package com.util;

import android.app.KeyguardManager;
import android.app.KeyguardManager.KeyguardLock;
import android.content.Context;
import android.media.AudioManager;
import android.os.PowerManager;
import android.provider.Settings;
import android.provider.Settings.SettingNotFoundException;

public class SettingUtil {
	/**
	 * 调整系统亮度
	 * 
	 * @param brightness
	 */
	public static void setBrightness(Context context, int brightness) {
		boolean setSuccess = Settings.System.putInt(
				context.getContentResolver(),
				Settings.System.SCREEN_BRIGHTNESS, brightness);
		MyLog.v("[SettingUtil]setBrightness: " + brightness + ", " + setSuccess);
	}

	public static int getBrightness(Context context) {
		try {
			int nowBrightness = Settings.System.getInt(
					context.getContentResolver(),
					Settings.System.SCREEN_BRIGHTNESS);
			MyLog.v("[SettingUtil]nowBrightness:" + nowBrightness);
			return nowBrightness;
		} catch (SettingNotFoundException e) {
			e.printStackTrace();
			return 55;
		}
	}

	public static void setScreenOffTime(Context context, int time) {
		boolean isSuccess = Settings.System.putInt(
				context.getContentResolver(),
				android.provider.Settings.System.SCREEN_OFF_TIMEOUT, time);

		MyLog.v("[SettingUtil]setScreenOffTime " + time + ",isSuccess:"
				+ isSuccess);

	}

	public static int getScreenOffTime(Context context) {
		try {
			return Settings.System.getInt(context.getContentResolver(),
					Settings.System.SCREEN_OFF_TIMEOUT);
		} catch (SettingNotFoundException e) {
			e.printStackTrace();
			return 155;
		}
	}

	/**
	 * 点亮屏幕
	 * 
	 * @param context
	 */
	public static void lightScreen(Context context) {
		// 获取电源管理器对象
		PowerManager pm = (PowerManager) context
				.getSystemService(Context.POWER_SERVICE);

		// 获取PowerManager.WakeLock对象,后面的参数|表示同时传入两个值,最后的是LogCat里用的Tag
		PowerManager.WakeLock wl = pm.newWakeLock(
				PowerManager.ACQUIRE_CAUSES_WAKEUP
						| PowerManager.SCREEN_DIM_WAKE_LOCK, "bright");

		wl.acquire(); // 点亮屏幕
		wl.release(); // 释放

		// 得到键盘锁管理器对象
		KeyguardManager km = (KeyguardManager) context
				.getSystemService(Context.KEYGUARD_SERVICE);

		// 参数是LogCat里用的Tag
		KeyguardLock kl = km.newKeyguardLock("ZMS");

		kl.disableKeyguard();
	}

	/**
	 * 
	 * @param context
	 * @param type
	 *            AudioManager.STREAM_MUSIC;STREAM_RING
	 * @param step
	 *            增加音量
	 */
	public static void plusVolume(Context context, int type, int step) {
		AudioManager audioManager = (AudioManager) context
				.getSystemService(Context.AUDIO_SERVICE);

		int nowVolume = audioManager.getStreamVolume(type);
		int toVolume = nowVolume + step;
		if (toVolume <= 15)
			audioManager.setStreamVolume(type, toVolume, 0);
		else
			audioManager.setStreamVolume(type, 15, 0);
	}

	/**
	 * 
	 * @param context
	 * @param type
	 *            AudioManager.STREAM_MUSIC;STREAM_RING
	 * @param step
	 */
	public static void minusVolume(Context context, int type, int step) {
		AudioManager audioManager = (AudioManager) context
				.getSystemService(Context.AUDIO_SERVICE);
		int nowVolume = audioManager.getStreamVolume(type);
		int toVolume = nowVolume - step;
		if (toVolume > 0)
			audioManager.setStreamVolume(type, toVolume, 0);
		else
			audioManager.setStreamVolume(type, 0, 0);
	}

	/**
	 * 设置最大音量
	 * 
	 * @param context
	 *            AudioManager.STREAM_MUSIC;STREAM_RING
	 * @param type
	 */
	public static void setMaxVolume(Context context, int type) {
		AudioManager audioManager = (AudioManager) context
				.getSystemService(Context.AUDIO_SERVICE);
		audioManager.setStreamVolume(type, 15, 0);
	}

	/**
	 * 设置最小音量
	 * 
	 * @param context
	 *            AudioManager.STREAM_MUSIC;STREAM_RING
	 * @param type
	 */
	public static void setMinVolume(Context context, int type) {
		AudioManager audioManager = (AudioManager) context
				.getSystemService(Context.AUDIO_SERVICE);
		audioManager.setStreamVolume(type, 0, 0);
	}

	/**
	 * 静音
	 * 
	 * @param context
	 */
	public static void setMute(Context context) {
		AudioManager audioManager = (AudioManager) context
				.getSystemService(Context.AUDIO_SERVICE);
		audioManager.setRingerMode(audioManager.RINGER_MODE_SILENT);
	}

	/**
	 * 关闭静音
	 */
	public static void setUnmute(Context context, int type) {
		AudioManager audioManager = (AudioManager) context
				.getSystemService(Context.AUDIO_SERVICE);
		audioManager.setStreamVolume(type, 8, 0);
	}
}
