package com.util;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

public class ConvertUtil {
	/**
	 * @param num
	 * @param mode
	 *            小端序 ByteOrder.{@link ByteOrder#LITTLE_ENDIAN LITTLE_ENDIAN}
	 *            大端序 ByteOrder.{@link ByteOrder#BIG_ENDIAN BIG_ENDIAN}
	 * @return
	 */
	public static byte[] intToBytes(int num, ByteOrder mode) {

		byte[] b = new byte[4];
		ByteBuffer buffer = ByteBuffer.allocate(4).order(mode);

		buffer.putInt(num);
		buffer.clear();
		buffer.get(b);
		return b;
	}

	/**
	 * 数组翻转
	 * 
	 * @param array
	 * @return
	 */
	public static byte[] byteArrayRev(byte[] array) {
		byte[] nArray = new byte[array.length];
		for (int i = 0; i < array.length; i++) {
			nArray[i] = array[array.length - 1 - i];
		}
		return nArray;
	}

	/**
	 * @param array
	 *            需要分割的数组
	 * @param offset
	 *            数组起始下标
	 * @param count
	 *            需要分割的长度
	 * @return
	 */
	public static byte[] splitArray(byte[] array, int offset, int count) {
		byte[] b = new byte[count];
		for (int i = 0; i < count; i++) {
			b[i] = array[offset + i];
		}
		return b;
	}

	/**
	 * 连接字节数组
	 * 
	 * @param first
	 * @param rest
	 * @return
	 */
	public static byte[] concatAll(byte[] first, byte[]... rest) {
		int totalLength = first.length;
		for (byte[] array : rest) {
			totalLength += array.length;
		}
		byte[] result = Arrays.copyOf(first, totalLength);
		int offset = first.length;
		for (byte[] array : rest) {
			System.arraycopy(array, 0, result, offset, array.length);
			offset += array.length;
		}
		return result;
	}

	/**
	 * 合并两个byte数组
	 * 
	 * @param byte_1
	 * @param byte_2
	 * @return
	 */
	public static byte[] byteMerger(byte[] byte_1, byte[] byte_2) {
		byte[] byte_3 = new byte[byte_1.length + byte_2.length];
		System.arraycopy(byte_1, 0, byte_3, 0, byte_1.length);
		System.arraycopy(byte_2, 0, byte_3, byte_1.length, byte_2.length);
		return byte_3;
	}

	/**
	 * byte数组中取int数值，本方法适用于(低位在前，高位在后)的顺序，和和intToBytes()配套使用
	 * 
	 * @param src
	 *            byte数组
	 * @param offset
	 *            从数组的第offset位开始
	 * @return int数值
	 */
	public static int bytesToInt(byte[] src, int offset) {
		int value;
		value = (int) ((src[offset] & 0xFF) | ((src[offset + 1] & 0xFF) << 8)
				| ((src[offset + 2] & 0xFF) << 16) | ((src[offset + 3] & 0xFF) << 24));
		return value;
	}

	/**
	 * byte数组中取int数值，本方法适用于(低位在后，高位在前)的顺序。和intToBytes2（）配套使用
	 */
	public static int bytesToInt2(byte[] src, int offset) {
		int value;
		value = (int) (((src[offset] & 0xFF) << 24)
				| ((src[offset + 1] & 0xFF) << 16)
				| ((src[offset + 2] & 0xFF) << 8) | (src[offset + 3] & 0xFF));
		return value;
	}

	/**
	 * 将int数值转换为占四个字节的byte数组，本方法适用于(低位在前，高位在后)的顺序。 和bytesToInt（）配套使用
	 * 
	 * @param value
	 *            要转换的int值
	 * @return byte数组
	 */
	public static byte[] intToBytes(int value) {
		byte[] src = new byte[4];
		src[3] = (byte) ((value >> 24) & 0xFF);
		src[2] = (byte) ((value >> 16) & 0xFF);
		src[1] = (byte) ((value >> 8) & 0xFF);
		src[0] = (byte) (value & 0xFF);
		return src;
	}

	/**
	 * 将int数值转换为占四个字节的byte数组，本方法适用于(高位在前，低位在后)的顺序。 和bytesToInt2（）配套使用
	 */
	public static byte[] intToBytes2(int value) {
		byte[] src = new byte[4];
		src[0] = (byte) ((value >> 24) & 0xFF);
		src[1] = (byte) ((value >> 16) & 0xFF);
		src[2] = (byte) ((value >> 8) & 0xFF);
		src[3] = (byte) (value & 0xFF);
		return src;
	}

	public static int bytesToShort(byte[] src, int offset) {
		short value;
		value = (short) ((src[offset] & 0xFF) | ((src[offset + 1] & 0xFF) << 8));
		return value;
	}

	public static short bytesToShort2(byte[] src, int offset) {
		short value;
		value = (short) (((src[offset] & 0xFF) << 8) | ((src[offset + 1] & 0xFF)));

		return value;
	}

	public static long bytesToLong(byte[] src, int offset) {
		long value;
		value = (long) ((src[offset] & 0xFF) | ((src[offset + 1] & 0xFF) << 8)
				| ((src[offset + 2] & 0xFF) << 16)
				| ((src[offset + 3] & 0xFF) << 24)
				| ((src[offset + 4] & 0xFF) << 32)
				| ((src[offset + 5] & 0xFF) << 40)
				| ((src[offset + 6] & 0xFF) << 48) | ((src[offset + 7] & 0xFF) << 56));
		return value;
	}

	/**
	 * byte数组中取int数值，本方法适用于(低位在后，高位在前)的顺序。和intToBytes2（）配套使用
	 */
	public static long bytesToLong2(byte[] src, int offset) {
		long value;
		value = (long) (((src[offset] & 0xFF) << 56)
				| ((src[offset + 1] & 0xFF) << 48)
				| ((src[offset + 2] & 0xFF) << 40)
				| ((src[offset + 3] & 0xFF) << 32)
				| ((src[offset + 4] & 0xFF) << 24)
				| ((src[offset + 5] & 0xFF) << 16)
				| ((src[offset + 6] & 0xFF) << 8) | ((src[offset + 7] & 0xFF)));
		return value;
	}

	/**
	 * 把16进制字符串转换成字节数组
	 * 
	 * @param hexString
	 * @return byte[]
	 */
	public static byte[] hexStringToByte(String hex) {
		hex = hex.toUpperCase();
		int len = (hex.length() / 2);
		byte[] result = new byte[len];
		char[] achar = hex.toCharArray();
		for (int i = 0; i < len; i++) {
			int pos = i * 2;
			result[i] = (byte) (toByte(achar[pos]) << 4 | toByte(achar[pos + 1]));
		}
		return result;
	}

	private static int toByte(char c) {
		byte b = (byte) "0123456789ABCDEF".indexOf(c);
		return b;
	}

	public static String ByteToHexString(byte[] b, int offset, int count) {
		String sHex = "0123456789ABCDEF";
		char[] cHex = sHex.toCharArray();
		StringBuilder sb = new StringBuilder();
		for (int i = offset; i < count; i++) {
			sb.append(cHex[(b[i] >> 4) & 0x0f]);
			sb.append(cHex[(b[i] & 0x0f)]);
		}
		return sb.toString();
	}

	/**
	 * 数组转换成十六进制字符串
	 * 
	 * @param byte[]
	 * @return HexString
	 */
	public static final String bytesToHexString(byte[] bArray) {
		StringBuffer sb = new StringBuffer(bArray.length);
		String sTemp;
		for (int i = 0; i < bArray.length; i++) {
			sTemp = Integer.toHexString(0xFF & bArray[i]);
			if (sTemp.length() < 2)
				sb.append(0);
			sb.append(sTemp.toUpperCase());
		}
		return sb.toString();
	}

	public static byte[] FloatToBytes2(float f) {
		int i;
		i = Float.floatToIntBits(f);
		byte[] b = new byte[4];
		b[0] = (byte) ((i >> 24) & 0xff);
		b[1] = (byte) ((i >> 16) & 0xff);
		b[2] = (byte) ((i >> 8) & 0xff);
		b[3] = (byte) (i & 0xff);
		return b;
	}

	public static float ByteToFloat2(byte[] b, int offset) {
		int i;
		i = ((b[offset] << 24) & 0xff000000)
				| ((b[offset + 1] << 16) & 0xff0000)
				| ((b[offset + 2] << 8) & 0xff00) | ((b[offset + 3]) & 0xff);
		return Float.intBitsToFloat(i);
	}

	// FIXME************************* Below is OLD *************************

	/** String -> byte[] */
	public static byte[] stringToBytes(String str) {
		byte[] result = null;
		try {
			result = str.getBytes("UTF8"); // 为UTF8编码,ISO单字节编码:ISO-8859-1
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}

	/** byte[] -> String */
	public static String bytesToString(byte[] bytes) {
		String str = "";
		try {
			str = new String(bytes, "UTF-8"); // ISO-8859-1
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return str;
	}

	public static long doubleToLong(double d) {
		return Math.round(d);
	}

	public static double longToDouble(long l) {
		return (double) l;
	}

	// 以下 是整型数 和 网络字节序的 byte[] 数组之间的转换
	public static byte[] longToBytes(long n) {
		byte[] b = new byte[8];
		b[7] = (byte) (n & 0xff);
		b[6] = (byte) (n >> 8 & 0xff);
		b[5] = (byte) (n >> 16 & 0xff);
		b[4] = (byte) (n >> 24 & 0xff);
		b[3] = (byte) (n >> 32 & 0xff);
		b[2] = (byte) (n >> 40 & 0xff);
		b[1] = (byte) (n >> 48 & 0xff);
		b[0] = (byte) (n >> 56 & 0xff);
		return b;
	}

	public static void longToBytes(long n, byte[] array, int offset) {
		array[7 + offset] = (byte) (n & 0xff);
		array[6 + offset] = (byte) (n >> 8 & 0xff);
		array[5 + offset] = (byte) (n >> 16 & 0xff);
		array[4 + offset] = (byte) (n >> 24 & 0xff);
		array[3 + offset] = (byte) (n >> 32 & 0xff);
		array[2 + offset] = (byte) (n >> 40 & 0xff);
		array[1 + offset] = (byte) (n >> 48 & 0xff);
		array[0 + offset] = (byte) (n >> 56 & 0xff);
	}

	public static long bytesToLong(byte[] array) {
		return ((((long) array[0] & 0xff) << 56)
				| (((long) array[1] & 0xff) << 48)
				| (((long) array[2] & 0xff) << 40)
				| (((long) array[3] & 0xff) << 32)
				| (((long) array[4] & 0xff) << 24)
				| (((long) array[5] & 0xff) << 16)
				| (((long) array[6] & 0xff) << 8) | (((long) array[7] & 0xff) << 0));
	}

	public static void intToBytes(int n, byte[] array, int offset) {
		array[3 + offset] = (byte) (n & 0xff);
		array[2 + offset] = (byte) (n >> 8 & 0xff);
		array[1 + offset] = (byte) (n >> 16 & 0xff);
		array[offset] = (byte) (n >> 24 & 0xff);
	}

	public static int bytesToInt(byte b[]) {
		return b[3] & 0xff | (b[2] & 0xff) << 8 | (b[1] & 0xff) << 16
				| (b[0] & 0xff) << 24;
	}

	public static byte[] uintToBytes(long n) {
		byte[] b = new byte[4];
		b[3] = (byte) (n & 0xff);
		b[2] = (byte) (n >> 8 & 0xff);
		b[1] = (byte) (n >> 16 & 0xff);
		b[0] = (byte) (n >> 24 & 0xff);

		return b;
	}

	public static void uintToBytes(long n, byte[] array, int offset) {
		array[3 + offset] = (byte) (n);
		array[2 + offset] = (byte) (n >> 8 & 0xff);
		array[1 + offset] = (byte) (n >> 16 & 0xff);
		array[offset] = (byte) (n >> 24 & 0xff);
	}

	public static long bytesToUint(byte[] array) {
		return ((long) (array[3] & 0xff)) | ((long) (array[2] & 0xff)) << 8
				| ((long) (array[1] & 0xff)) << 16
				| ((long) (array[0] & 0xff)) << 24;
	}

	public static long bytesToUint(byte[] array, int offset) {
		return ((long) (array[offset + 3] & 0xff))
				| ((long) (array[offset + 2] & 0xff)) << 8
				| ((long) (array[offset + 1] & 0xff)) << 16
				| ((long) (array[offset] & 0xff)) << 24;
	}

	public static byte[] shortToBytes(short n) {
		byte[] b = new byte[2];
		b[1] = (byte) (n & 0xff);
		b[0] = (byte) ((n >> 8) & 0xff);
		return b;
	}

	public static void shortToBytes(short n, byte[] array, int offset) {
		array[offset + 1] = (byte) (n & 0xff);
		array[offset] = (byte) ((n >> 8) & 0xff);
	}

	public static short bytesToShort(byte[] b) {
		return (short) (b[1] & 0xff | (b[0] & 0xff) << 8);
	}

	public static byte[] ushortToBytes(int n) {
		byte[] b = new byte[2];
		b[1] = (byte) (n & 0xff);
		b[0] = (byte) ((n >> 8) & 0xff);
		return b;
	}

	public static void ushortToBytes(int n, byte[] array, int offset) {
		array[offset + 1] = (byte) (n & 0xff);
		array[offset] = (byte) ((n >> 8) & 0xff);
	}

	public static int bytesToUshort(byte b[]) {
		return b[1] & 0xff | (b[0] & 0xff) << 8;
	}

	public static int bytesToUshort(byte b[], int offset) {
		return b[offset + 1] & 0xff | (b[offset] & 0xff) << 8;
	}

	public static byte[] ubyteToBytes(int n) {
		byte[] b = new byte[1];
		b[0] = (byte) (n & 0xff);
		return b;
	}

	public static void ubyteToBytes(int n, byte[] array, int offset) {
		array[0] = (byte) (n & 0xff);
	}

	public static int bytesToUbyte(byte[] array) {
		return array[0] & 0xff;
	}

	public static int bytesToUbyte(byte[] array, int offset) {
		return array[offset] & 0xff;
	}

}
