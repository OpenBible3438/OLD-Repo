package com.util;

public class StringToHex {
	
	public static String stringToHexString(String str) {
		char[] chars = str.toCharArray();
		StringBuffer hex = new StringBuffer();
		for (int i = 0; i < chars.length; i++){
			hex.append(Integer.toHexString((int) chars[i]));
		}
		return hex.toString();
	}
	
	public static byte[] hexStringToByteArray(String str) {
		int len = str.length();
		byte[] data = new byte[len / 2];
		for (int i = 0; i < len; i += 2) {
			data[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4)
					+ Character.digit(str.charAt(i+1), 16));
		}
		return data;
	}
	
	public static String byteArrayToHexString(byte[] byteArray) {
	    StringBuilder sb = new StringBuilder();
	    for(final byte b: byteArray)
	        sb.append(String.format("%02x ", b&0xff));
	    return sb.toString();
	}
}
