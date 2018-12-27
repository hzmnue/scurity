package com.agile.framework.security.utils;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {

    /**
     * 　　* 利用java原生的摘要实现MD5 32编码
     * 　　* @param str 加密后的报文
     * 　　* @return
     *
     */
    public static String encode(String str) {
        MessageDigest messageDigest;
        String encodeStr = "";
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes("UTF-8"));
            encodeStr = byteToHex(messageDigest.digest());
            String md5code = new BigInteger(1, messageDigest.digest()).toString(16);// 16进制数字
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return encodeStr;
    }

    /**
     * 　　* 将byte转为16进制
     * 　　* @param bytes
     * 　　* @return
     *
     */
    private static String byteToHex(byte[] bytes) {
        char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
        StringBuffer stringBuffer = new StringBuffer();
        String temp = null;
        for (int i = 0; i < bytes.length; i++) {
            stringBuffer.append(hexDigits[bytes[i]>>> 4 & 15]);
            stringBuffer.append(hexDigits[bytes[i]&15]);
        }
        return stringBuffer.toString();
    }
}
