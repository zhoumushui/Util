package com.util;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;

public class OpenUtil {

	public enum MODULE_TYPE {

		/** 图库 */
		GALLERY,

		/** 短信 */
		MMS,

		/** 关于 */
		SETTING_ABOUT,

		/** 应用 */
		SETTING_APP,

		/** 流量使用情况 */
		SETTING_DATA_USAGE,

		/** 日期和时间 */
		SETTING_DATE,

		/** 显示设置 */
		SETTING_DISPLAY,

		/** FM发射设置 */
		SETTING_FM,

		/** 位置 */
		SETTING_LOCATION,

		/** 音量设置 */
		SETTING_VOLUME,

		/** 备份和重置 */
		SETTING_RESET,

		/** 存储设置 */
		SETTING_STORAGE,

		/** 系统设置 */
		SETTING_SYSTEM,

		/** 视频 */
		VIDEO,

		/** Wi-Fi */
		WIFI,

		/** Wi-Fi热点 */
		WIFI_AP,

	}

	public static void openModule(Activity activity, MODULE_TYPE moduleTye) {
		if (!ClickUtil.isQuickClick(1000)) {
			try {
				switch (moduleTye) {

				case GALLERY:
					ComponentName componentImage = new ComponentName(
							"com.android.gallery3d",
							"com.android.gallery3d.app.GalleryActivity");
					Intent intentImage = new Intent();
					intentImage.setComponent(componentImage);
					intentImage.addCategory(Intent.CATEGORY_LAUNCHER);
					intentImage.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					activity.startActivity(intentImage);
					break;

				case MMS:
					ComponentName componentMessage = new ComponentName(
							"com.android.mms",
							"com.android.mms.ui.BootActivity");
					Intent intentMessage = new Intent();
					intentMessage.setComponent(componentMessage);
					activity.startActivity(intentMessage);
					activity.overridePendingTransition(
							R.anim.zms_translate_up_out,
							R.anim.zms_translate_up_in);
					break;

				case SETTING_ABOUT:
					activity.startActivity(new Intent(
							android.provider.Settings.ACTION_DEVICE_INFO_SETTINGS));
					break;

				case SETTING_APP:
					activity.startActivity(new Intent(
							android.provider.Settings.ACTION_MANAGE_APPLICATIONS_SETTINGS));
					break;

				case SETTING_DATA_USAGE:
					activity.startActivity(new Intent(
							"android.settings.DATA_USAGE_SETTINGS"));
					break;

				case SETTING_DATE:
					activity.startActivity(new Intent(
							android.provider.Settings.ACTION_DATE_SETTINGS));
					break;

				case SETTING_FM:
					activity.startActivity(new Intent(
							"android.settings.FM_SETTINGS"));
					break;

				case SETTING_LOCATION:
					activity.startActivity(new Intent(
							android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS));
					break;

				case SETTING_RESET:
					activity.startActivity(new Intent(
							"android.settings.BACKUP_AND_RESET_SETTINGS"));
					break;

				case SETTING_STORAGE:
					activity.startActivity(new Intent(
							android.provider.Settings.ACTION_MEMORY_CARD_SETTINGS));
					break;

				case SETTING_SYSTEM:
					ComponentName componentSettingSystem = new ComponentName(
							"com.android.settings",
							"com.android.settings.Settings");
					Intent intentSettingSystem = new Intent();
					intentSettingSystem.setComponent(componentSettingSystem);
					activity.startActivity(intentSettingSystem);
					break;

				case VIDEO:
					ComponentName componentVideo = new ComponentName(
							"com.mediatek.videoplayer",
							"com.mediatek.videoplayer.MovieListActivity");
					Intent intentVideo = new Intent();
					intentVideo.setComponent(componentVideo);
					intentVideo.addCategory(Intent.CATEGORY_DEFAULT);
					intentVideo.addCategory(Intent.CATEGORY_LAUNCHER);
					intentVideo.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK
							| Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
					activity.startActivity(intentVideo);
					break;

				case WIFI:
					activity.startActivity(new Intent(
							android.provider.Settings.ACTION_WIFI_SETTINGS));
					break;

				case WIFI_AP:
					activity.startActivity(new Intent(
							"android.settings.TETHER_WIFI_SETTINGS"));
					break;

				default:
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}
