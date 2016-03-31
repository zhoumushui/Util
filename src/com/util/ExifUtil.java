package com.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;

import net.sourceforge.jheader.App1Header;
import net.sourceforge.jheader.App1Header.Tag;
import net.sourceforge.jheader.ExifFormatException;
import net.sourceforge.jheader.JpegFormatException;
import net.sourceforge.jheader.JpegHeaders;
import net.sourceforge.jheader.TagFormatException;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.ExifInterface;

/**
 * Using:jheader-0.1.jar
 * 
 * @author AZ
 */
public class ExifUtil {

	/**
	 * 写入EXIF信息
	 * 
	 * @param context
	 * @param imagePath
	 */
	public static void writeImageExif(Context context, String imagePath) {
		// Android Way
		try {
			SharedPreferences sharedPreferences = context.getSharedPreferences(
					"TEST", Context.MODE_PRIVATE);

			ExifInterface exif = new ExifInterface(imagePath);
			String strLongitude = sharedPreferences.getString("longitude",
					"0.00"); // 经度
			double intLongitude = Double.parseDouble(strLongitude);
			exif.setAttribute(ExifInterface.TAG_GPS_LONGITUDE, strLongitude);
			exif.setAttribute(ExifInterface.TAG_GPS_LONGITUDE_REF,
					intLongitude > 0.0f ? "E" : "W");
			String strLatitude = sharedPreferences
					.getString("latitude", "0.00"); // 纬度
			double intLatitude = Double.parseDouble(strLatitude);
			exif.setAttribute(ExifInterface.TAG_GPS_LATITUDE, strLongitude);
			exif.setAttribute(ExifInterface.TAG_GPS_LATITUDE_REF,
					intLatitude > 0.0f ? "N" : "S");
			exif.setAttribute(ExifInterface.TAG_ORIENTATION, ""
					+ ExifInterface.ORIENTATION_NORMAL);
			exif.setAttribute(ExifInterface.TAG_MAKE, "zenlane"); // 品牌
			exif.setAttribute(ExifInterface.TAG_MODEL, "X755"); // 型号/机型
			// exif.setAttribute(ExifInterface.TAG_FLASH, "1/30"); // 闪光灯
			// exif.setAttribute(ExifInterface.TAG_FOCAL_LENGTH, "5/1"); // 焦距
			// exif.setAttribute(ExifInterface.TAG_WHITE_BALANCE,
			// ExifInterface.WHITEBALANCE_AUTO+"/1"); // 白平衡
			// exif.setAttribute(ExifInterface.TAG_EXPOSURE_TIME, "1/30"); //
			// // 曝光时间
			// exif.setAttribute(ExifInterface.TAG_ISO, "100"); // 感光度
			// exif.setAttribute(ExifInterface.TAG_APERTURE, "2/1"); // 光圈
			exif.saveAttributes();
		} catch (Exception e) {
			MyLog.e("[Android]Set Attribute Catch Exception:" + e.toString());
			e.printStackTrace();
		}

		// JpegHeaders Way
		try {
			JpegHeaders jpegHeaders = new JpegHeaders(imagePath);
			App1Header exifHeader = jpegHeaders.getApp1Header();
			// 遍历显示EXIF
			// SortedMap tags = exifHeader.getTags();
			// for (Map.Entry entry : tags.entrySet()) {
			// System.out.println(entry.getKey() + "[" + entry.getKey().name
			// + "]:" + entry.getValue());
			// }

			// 修改EXIF
			// exifHeader.setValue(Tag.DATETIMEORIGINAL, "2015:05:55 05:55:55");
			exifHeader.setValue(Tag.ORIENTATION, "1"); // 浏览模式/方向:上/左
			exifHeader.setValue(Tag.APERTUREVALUE, "22/10"); // 光圈：2.2
			exifHeader.setValue(Tag.FOCALLENGTH, "7/2"); // 焦距：3.5mm
			exifHeader.setValue(Tag.WHITEBALANCE, "0"); // 白平衡：自动
			exifHeader.setValue(Tag.ISOSPEEDRATINGS, "100"); // ISO感光度：100
			exifHeader.setValue(Tag.EXPOSURETIME, "1/30"); // 曝光时间：1/30
			// 曝光补偿:EV值每增加1.0，相当于摄入的光线量增加一倍，如果照片过亮，要减小EV值，EV值每减小1.0，相当于摄入的光线量减小一倍
			exifHeader.setValue(Tag.EXPOSUREBIASVALUE,
					(1 + new Random().nextInt(10)) + "/10");
			exifHeader.setValue(Tag.METERINGMODE, "1"); // 测光模式：平均
			exifHeader.setValue(Tag.SATURATION,
					"" + (5 + new Random().nextInt(10))); // 饱和度：5-15
			exifHeader.setValue(Tag.FLASH, "0"); // 闪光灯：未使用
			jpegHeaders.save(false); // 保存,参数：是否保存原文件为.old
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			MyLog.e("[JpegHeaders]Set Attribute Error,FileNotFoundException:"
					+ e.toString());
		} catch (ExifFormatException e) {
			e.printStackTrace();
			MyLog.e("[JpegHeaders]Set Attribute Error,ExifFormatException:"
					+ e.toString());
		} catch (TagFormatException e) {
			e.printStackTrace();
			MyLog.e("[JpegHeaders]Set Attribute Error,TagFormatException:"
					+ e.toString());
		} catch (IOException e) {
			e.printStackTrace();
			MyLog.e("[JpegHeaders]Set Attribute Error,IOException:"
					+ e.toString());
		} catch (JpegFormatException e) {
			e.printStackTrace();
			MyLog.e("[JpegHeaders]Set Attribute Error,JpegFormatException:"
					+ e.toString());
		}
	}
}
