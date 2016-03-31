package com.util;

import android.hardware.Camera;

public class CameraUtil {

	public CameraUtil() {
	}

	public static String getCameraInfo() {
		int cameraNum = Camera.getNumberOfCameras();
		return "CameraNum:" + cameraNum + "\n";
	}

}
