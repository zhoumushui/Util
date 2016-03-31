package com.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.FeatureInfo;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.format.Formatter;

public class DeviceUtil {

	public DeviceUtil() {
	}

	/**
	 * 获取传感器信息
	 */
	private String getSensorInfo(Context context) {
		SensorManager sensorManager = (SensorManager) context
				.getSystemService(Context.SENSOR_SERVICE);
		String checkResult = "\nSensor:\n";

		// ACCELEROMETER
		if (sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER) != null) {
			checkResult = checkResult + "加速传感器: YES"
					+ getSensorDetail(context, Sensor.TYPE_ACCELEROMETER);
		} else {
			checkResult = checkResult + "加速传感器: NO\n";
		}

		// AMBIENT_TEMPERATURE
		if (sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE) != null) {
			checkResult = checkResult + "温度计: YES"
					+ getSensorDetail(context, Sensor.TYPE_AMBIENT_TEMPERATURE);
		} else {
			checkResult = checkResult + "温度计: NO\n";
		}

		// GAME_ROTATION_VECTOR
		if (sensorManager.getDefaultSensor(Sensor.TYPE_GAME_ROTATION_VECTOR) != null) {
			checkResult = checkResult
					+ "游戏旋转矢量传感器: YES"
					+ getSensorDetail(context, Sensor.TYPE_GAME_ROTATION_VECTOR);
		} else {
			checkResult = checkResult + "游戏旋转矢量传感器: NO\n";
		}

		// GEOMAGNETIC_ROTATION_VECTOR
		if (sensorManager
				.getDefaultSensor(Sensor.TYPE_GEOMAGNETIC_ROTATION_VECTOR) != null) {
			checkResult = checkResult
					+ "地磁旋转矢量传感器: YES"
					+ getSensorDetail(context,
							Sensor.TYPE_GEOMAGNETIC_ROTATION_VECTOR);
		} else {
			checkResult = checkResult + "地磁旋转矢量传感器: NO\n";
		}

		// GRAVITY
		if (sensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY) != null) {
			checkResult = checkResult + "重力传感器: YES"
					+ getSensorDetail(context, Sensor.TYPE_GRAVITY);
		} else {
			checkResult = checkResult + "重力传感器: NO\n";
		}

		// GYROSCOPE
		if (sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE) != null) {
			checkResult = checkResult + "陀螺仪: YES"
					+ getSensorDetail(context, Sensor.TYPE_GYROSCOPE);
		} else {
			checkResult = checkResult + "陀螺仪: NO\n";
		}

		// GYROSCOPE_UNCALIBRATED
		if (sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE_UNCALIBRATED) != null) {
			checkResult = checkResult
					+ "未校准陀螺仪: YES"
					+ getSensorDetail(context,
							Sensor.TYPE_GYROSCOPE_UNCALIBRATED);
		} else {
			checkResult = checkResult + "未校准陀螺仪: NO\n";
		}

		// LIGHT
		if (sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT) != null) {
			checkResult = checkResult + "光线传感器: YES"
					+ getSensorDetail(context, Sensor.TYPE_LIGHT);
		} else {
			checkResult = checkResult + "光线传感器: NO\n";
		}

		// LINEAR_ACCELERATION
		if (sensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION) != null) {
			checkResult = checkResult + "加速度传感器: YES"
					+ getSensorDetail(context, Sensor.TYPE_LINEAR_ACCELERATION);
		} else {
			checkResult = checkResult + "加速度传感器: NO\n";
		}

		// MAGNETIC_FIELD
		if (sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD) != null) {
			checkResult = checkResult + "磁场传感器: YES"
					+ getSensorDetail(context, Sensor.TYPE_MAGNETIC_FIELD);
		} else {
			checkResult = checkResult + "磁场传感器: NO\n";
		}

		// MAGNETIC_FIELD_UNCALIBRATED
		if (sensorManager
				.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD_UNCALIBRATED) != null) {
			checkResult = checkResult
					+ "未校准磁场传感器: YES"
					+ getSensorDetail(context,
							Sensor.TYPE_MAGNETIC_FIELD_UNCALIBRATED);
		} else {
			checkResult = checkResult + "未校准磁场传感器: NO\n";
		}

		// ORIENTATION
		if (sensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION) != null) {
			checkResult = checkResult + "方向传感器: YES"
					+ getSensorDetail(context, Sensor.TYPE_ORIENTATION);
		} else {
			checkResult = checkResult + "方向传感器: NO\n";
		}

		// PRESSURE
		if (sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE) != null) {
			Sensor sensor = sensorManager
					.getDefaultSensor(Sensor.TYPE_PRESSURE);
			checkResult = checkResult + "压力传感器: YES"
					+ getSensorDetail(context, Sensor.TYPE_PRESSURE);
		} else {
			checkResult = checkResult + "压力传感器: NO\n";
		}

		// PROXIMITY
		if (sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY) != null) {
			checkResult = checkResult + "距离传感器: YES"
					+ getSensorDetail(context, Sensor.TYPE_PROXIMITY);
		} else {
			checkResult = checkResult + "距离传感器: NO\n";
		}

		// RELATIVE_HUMIDITY
		if (sensorManager.getDefaultSensor(Sensor.TYPE_RELATIVE_HUMIDITY) != null) {
			checkResult = checkResult + "相对湿度传感器: YES"
					+ getSensorDetail(context, Sensor.TYPE_RELATIVE_HUMIDITY);
		} else {
			checkResult = checkResult + "相对湿度传感器: NO\n";
		}

		// ROTATION_VECTOR
		if (sensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR) != null) {
			checkResult = checkResult + "旋转矢量传感器: YES"
					+ getSensorDetail(context, Sensor.TYPE_ROTATION_VECTOR);
		} else {
			checkResult = checkResult + "旋转矢量传感器: NO\n";
		}

		// SIGNIFICANT_MOTION
		if (sensorManager.getDefaultSensor(Sensor.TYPE_SIGNIFICANT_MOTION) != null) {
			checkResult = checkResult + "显著运动传感器: YES"
					+ getSensorDetail(context, Sensor.TYPE_SIGNIFICANT_MOTION);
		} else {
			checkResult = checkResult + "显著运动传感器: NO\n";
		}

		// STEP_COUNTER
		if (sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER) != null) {
			checkResult = checkResult + "计步传感器: YES"
					+ getSensorDetail(context, Sensor.TYPE_STEP_COUNTER);
		} else {
			checkResult = checkResult + "计步传感器: NO\n";
		}

		// STEP_DETECTOR
		if (sensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR) != null) {
			checkResult = checkResult + "步伐探测器: YES"
					+ getSensorDetail(context, Sensor.TYPE_STEP_DETECTOR);
		} else {
			checkResult = checkResult + "步伐探测器: NO\n";
		}

		// TEMPERATURE
		if (sensorManager.getDefaultSensor(Sensor.TYPE_TEMPERATURE) != null) {
			checkResult = checkResult + "温度传感器: YES"
					+ getSensorDetail(context, Sensor.TYPE_TEMPERATURE);
		} else {
			checkResult = checkResult + "温度传感器: NO\n";
		}
		return checkResult;
	}

	/**
	 * Get sensor's detail info when exist, called by getSensorInfo().
	 * 
	 * @param type
	 * @return Sensor Detail Information
	 */
	private String getSensorDetail(Context context, int type) {
		SensorManager sensorManager = (SensorManager) context
				.getSystemService(Context.SENSOR_SERVICE);
		Sensor sensor = sensorManager.getDefaultSensor(type);
		return " | Name:" + sensor.getName() + " | Vendor:"
				+ sensor.getVendor() + " | Version:" + sensor.getVersion()
				+ " | Power:" + sensor.getPower() + " | Resolution:"
				+ sensor.getResolution() + " | MinDelay:"
				+ sensor.getMinDelay() + " | Type:" + sensor.getType()
				+ " | MaxRange:" + sensor.getMaximumRange() + "\n";
	}

	/**
	 * 获取编译信息
	 * 
	 * @param type
	 *            0-All,1-Model,2-VersionRelease,Other-Error.
	 * @return String
	 */
	private String getBuildInfo(int type) {
		String model = Build.MODEL; // 型号
		String versionRelease = Build.VERSION.RELEASE;
		String versionSDK = Build.VERSION.SDK;
		String versionIncremental = Build.VERSION.INCREMENTAL;
		String brand = Build.BRAND;
		String id = Build.ID;
		String manufacturer = Build.MANUFACTURER;
		String hardware = Build.HARDWARE;
		String product = Build.PRODUCT;
		String cpuABI = Build.CPU_ABI;
		String cpuABI2 = Build.CPU_ABI2;
		String fingerPrint = Build.FINGERPRINT;
		String board = Build.BOARD;
		String serial = Build.SERIAL;
		String user = Build.USER;
		if (type == 0) {
			return "Model:" + model + "\nVersionRelease:" + versionRelease
					+ "\nVersionSDK:" + versionSDK + "\nVersionIncremental:"
					+ versionIncremental + "\nBrand:" + brand + "\nID:" + id
					+ "\nManufacturer:" + manufacturer + "\nHardware:"
					+ hardware + "\nProduct:" + product + "\nCpuABI:" + cpuABI
					+ "\nCpuABI2:" + cpuABI2 + "\nFingerPrint:" + fingerPrint
					+ "\nBoard:" + board + "\nSerial:" + serial + "\nUser:"
					+ user + "\n";
		} else if (type == 1) {
			return "Model" + model + "\n";
		} else if (type == 2) {
			return "VersionRelease:" + versionRelease + "\n";
		} else {
			return "[getBuildInfo Err]";
		}
	}

	private void getFeatureInfo(Context context) {
		PackageManager pm = context.getPackageManager();
		// List<FeatureInfo> list = new ArrayList<FeatureInfo>();
		List list = new ArrayList();
		FeatureInfo[] rawList = pm.getSystemAvailableFeatures();
		for (int i = 0; i < rawList.length; i++) {
			String[] strFeature = rawList[i].toString().split(" ");
			list.add(strFeature[1]);
		}
		// ArrayAdapter arrayAdapter = new ArrayAdapter(this,
		// R.layout.list_feature, R.id.tvFeature,
		// list);
		// ViewGroup.LayoutParams params = lvFeature.getLayoutParams();
		// View listItem = arrayAdapter.getView(0, null, lvFeature);
		// listItem.measure(0, 0);
		// params.height = listItem.getMeasuredHeight() * (list.size() + 1);
		// lvFeature.setLayoutParams(params);
		// lvFeature.setAdapter(arrayAdapter);
	}

	public static String getPermissionsInfo() {
		File path = new File("/etc/permissions/");
		File[] files = path.listFiles();
		ArrayList name = new ArrayList();
		if (files != null) {
			for (File file : files) {
				String fileName = file.getName();
				if (fileName.endsWith(".xml")) {
					name.add(fileName.substring(0, fileName.lastIndexOf("."))
							.toString());
				}
			}
		}
		String permissionsInfo = "\nPermissions Info:\n";
		for (int i = 0; i < name.size(); i++) {
			permissionsInfo = permissionsInfo + name.get(i).toString() + "\n";
		}
		return permissionsInfo;
	}

	private String getHardwareInfo(Context context, int type) {
		WifiManager wifiManager = (WifiManager) context
				.getSystemService(Context.WIFI_SERVICE);
		WifiInfo wifiInfo = wifiManager.getConnectionInfo();
		String macAddress = wifiInfo.getMacAddress();

		String strCPU = "";
		String[] cpuInfo = { "", "" }; // 1-cpu型号 //2-cpu频率
		String[] arrayOfStringCPU;
		try {
			FileReader fileReader = new FileReader("/proc/cpuinfo");
			BufferedReader localBufferedReader = new BufferedReader(fileReader,
					8192);
			strCPU = localBufferedReader.readLine();
			arrayOfStringCPU = strCPU.split("\\s+");
			for (int i = 2; i < arrayOfStringCPU.length; i++) {
				cpuInfo[0] = cpuInfo[0] + arrayOfStringCPU[i] + " ";
			}
			strCPU = localBufferedReader.readLine();
			arrayOfStringCPU = strCPU.split("\\s+");
			cpuInfo[1] += arrayOfStringCPU[2];
			localBufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// adb shell;cat /proc/meminfo
		ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
		ActivityManager activityManager = (ActivityManager) context
				.getSystemService(Context.ACTIVITY_SERVICE);
		activityManager.getMemoryInfo(memoryInfo);
		long mTotalMem = memoryInfo.totalMem;// 0;
		long mAvailMem = memoryInfo.availMem;
		/*
		 * String strMemory; String[] arrayOfStringMemory; try { FileReader
		 * localFileReader = new FileReader("/proc/meminfo"); BufferedReader
		 * localBufferedReader = new BufferedReader(localFileReader, 8192);
		 * strMemory = localBufferedReader.readLine(); arrayOfStringMemory =
		 * strMemory.split("\\s+"); mTotalMem =
		 * Integer.valueOf(arrayOfStringMemory[1]).intValue() * 1024;
		 * localBufferedReader.close(); } catch (IOException e) {
		 * e.printStackTrace(); }
		 */
		String totalMemory = Formatter.formatFileSize(context, mTotalMem);
		String availMemory = Formatter.formatFileSize(context, mAvailMem);

		if (type == 0) {
			return "MacAddress:" + macAddress + "\nCpuModel:" + cpuInfo[0]
					+ "\nCpuClock:" + cpuInfo[1] + "\nTotalMemory:"
					+ totalMemory + "\nAvailableMemory:" + availMemory + "\n";
		} else {
			return "";
		}
	}
}
