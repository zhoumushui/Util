package com.util;

import android.content.Context;
import android.widget.Toast;

public class HintUtil {

	public static void showToast(Context context, String content) {
		Toast.makeText(context, content, Toast.LENGTH_SHORT).show();
	}

}
