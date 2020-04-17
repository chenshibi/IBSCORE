package com.huateng.report.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;

/**
 * SM3杂凑算法实现
 *
 * @author Potato
 */
public class SM3 {

    private static char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8',
            '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static final String IV_HEX_STR = "7380166f 4914b2b9 172442d7 da8a0600 a96f30bc 163138aa e38dee4d b0fb0e4e";
    private static final BigInteger IV = new BigInteger(IV_HEX_STR.replaceAll(" ", ""), 16);
    private static final Integer TJ_15 = Integer.valueOf("79cc4519", 16);
    private static final Integer TJ_63 = Integer.valueOf("7a879d8a", 16);
    private static final byte[] FIRST_PADDING = {(byte) 0x80};
    private static final byte[] ZERO_PADDING = {(byte) 0x00};

    private static int T(int j) {
        if (j >= 0 && j <= 15) {
            return TJ_15.intValue();
        } else if (j >= 16 && j <= 63) {
            return TJ_63.intValue();
        } else {
            throw new RuntimeException("data invalid");
        }
    }

    private static Integer FF(Integer x, Integer y, Integer z, int j) {
        if (j >= 0 && j <= 15) {
            return Integer.valueOf(x.intValue() ^ y.intValue() ^ z.intValue());
        } else if (j >= 16 && j <= 63) {
            return Integer.valueOf((x.intValue() & y.intValue())
                    | (x.intValue() & z.intValue())
                    | (y.intValue() & z.intValue()));
        } else {
            throw new RuntimeException("data invalid");
        }
    }

    private static Integer GG(Integer x, Integer y, Integer z, int j) {
        if (j >= 0 && j <= 15) {
            return Integer.valueOf(x.intValue() ^ y.intValue() ^ z.intValue());
        } else if (j >= 16 && j <= 63) {
            return Integer.valueOf((x.intValue() & y.intValue())
                    | (~x.intValue() & z.intValue()));
        } else {
            throw new RuntimeException("data invalid");
        }
    }

    private static Integer P0(Integer x) {
        return Integer.valueOf(x.intValue()
                ^ Integer.rotateLeft(x.intValue(), 9)
                ^ Integer.rotateLeft(x.intValue(), 17));
    }

    private static Integer P1(Integer x) {
        return Integer.valueOf(x.intValue()
                ^ Integer.rotateLeft(x.intValue(), 15)
                ^ Integer.rotateLeft(x.intValue(), 23));
    }

    private static byte[] padding(byte[] source) throws IOException {
        if (source.length >= 0x2000000000000000l) {
            throw new RuntimeException("src data invalid.");
        }
        long l = source.length * 8;
        long k = 448 - (l + 1) % 512;
        if (k < 0) {
            k = k + 512;
        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baos.write(source);
        baos.write(FIRST_PADDING);
        long i = k - 7;
        while (i > 0) {
            baos.write(ZERO_PADDING);
            i -= 8;
        }
        baos.write(long2bytes(l));
        return baos.toByteArray();
    }

    private static byte[] long2bytes(long l) {
        byte[] bytes = new byte[8];
        for (int i = 0; i < 8; i++) {
            bytes[i] = (byte) (l >>> ((7 - i) * 8));
        }
        return bytes;
    }

    static byte[] hash(byte[] source) throws IOException {
        byte[] m1 = padding(source);
        int n = m1.length / (512 / 8);
        byte[] b;
        byte[] vi = IV.toByteArray();
        byte[] vi1 = null;
        for (int i = 0; i < n; i++) {
            b = Arrays.copyOfRange(m1, i * 64, (i + 1) * 64);
            vi1 = CF(vi, b);
            vi = vi1;
        }
        return vi1;
    }

    private static byte[] CF(byte[] vi, byte[] bi) throws IOException {
        int a, b, c, d, e, f, g, h;
        a = toInteger(vi, 0);
        b = toInteger(vi, 1);
        c = toInteger(vi, 2);
        d = toInteger(vi, 3);
        e = toInteger(vi, 4);
        f = toInteger(vi, 5);
        g = toInteger(vi, 6);
        h = toInteger(vi, 7);

        int[] w = new int[68];
        int[] w1 = new int[64];
        for (int i = 0; i < 16; i++) {
            w[i] = toInteger(bi, i);
        }
        for (int j = 16; j < 68; j++) {
            w[j] = P1(w[j - 16] ^ w[j - 9] ^ Integer.rotateLeft(w[j - 3], 15))
                    ^ Integer.rotateLeft(w[j - 13], 7) ^ w[j - 6];
        }
        for (int j = 0; j < 64; j++) {
            w1[j] = w[j] ^ w[j + 4];
        }
        int ss1, ss2, tt1, tt2;
        for (int j = 0; j < 64; j++) {
            ss1 = Integer
                    .rotateLeft(
                            Integer.rotateLeft(a, 12) + e
                                    + Integer.rotateLeft(T(j), j), 7);
            ss2 = ss1 ^ Integer.rotateLeft(a, 12);
            tt1 = FF(a, b, c, j) + d + ss2 + w1[j];
            tt2 = GG(e, f, g, j) + h + ss1 + w[j];
            d = c;
            c = Integer.rotateLeft(b, 9);
            b = a;
            a = tt1;
            h = g;
            g = Integer.rotateLeft(f, 19);
            f = e;
            e = P0(tt2);
        }
        byte[] v = toByteArray(a, b, c, d, e, f, g, h);
        for (int i = 0; i < v.length; i++) {
            v[i] = (byte) (v[i] ^ vi[i]);
        }
        return v;
    }

    private static int toInteger(byte[] source, int index) {
        StringBuilder valueStr = new StringBuilder("");
        for (int i = 0; i < 4; i++) {
            valueStr.append(hexDigits[(byte) ((source[index * 4 + i] & 0xF0) >> 4)]);
            valueStr.append(hexDigits[(byte) (source[index * 4 + i] & 0x0F)]);
        }
        return Long.valueOf(valueStr.toString(), 16).intValue();

    }

    private static byte[] toByteArray(int a, int b, int c, int d, int e, int f,
                                      int g, int h) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream(32);
        baos.write(toByteArray(a));
        baos.write(toByteArray(b));
        baos.write(toByteArray(c));
        baos.write(toByteArray(d));
        baos.write(toByteArray(e));
        baos.write(toByteArray(f));
        baos.write(toByteArray(g));
        baos.write(toByteArray(h));
        return baos.toByteArray();
    }

  public static byte[] toByteArray(int i) {
        byte[] byteArray = new byte[4];
        byteArray[0] = (byte) (i >>> 24);
        byteArray[1] = (byte) ((i & 0xFFFFFF) >>> 16);
        byteArray[2] = (byte) ((i & 0xFFFF) >>> 8);
        byteArray[3] = (byte) (i & 0xFF);
        return byteArray;
    }

    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0)
            n = 256 + n;
        int d1 = n / 16;
        int d2 = n % 16;
        return "" + hexDigits[d1] + hexDigits[d2];
    }

    private static String byteArrayToHexString(byte[] b) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            resultSb.append(byteToHexString(b[i]));
        }
        return resultSb.toString();
    }

    /**
     * 得到字符串的SM3哈希值，字符串会转成编码为UTF-8的字节去计算
     * @param value     需要计算的值
     * @return          返回的SM3哈希值
     * @throws Exception
     */
    public static String getHash(String value) throws Exception{
        return SM3.byteArrayToHexString(SM3.hash(value.getBytes("UTF-8")));
    }

    /**
     * 得到字节数组的SM3哈希值
     * @param values    需要计算的值
     * @return          返回的SM3哈希值
     * @throws Exception
     */
    public static String getHash(byte[] values) throws Exception{
        return SM3.byteArrayToHexString(SM3.hash(values));
    }

/*    public static void main(String[] args) throws IOException {
        System.out.println(SM3.byteArrayToHexString(SM3.hash("test sm3 hash".getBytes())));
    }*/
    

    public static void main(String[] args) throws Exception {
    	String hash = SM3.getHash("Aa123456789");
    	System.out.println("============="+hash);
      //  System.out.println(SM3.byteArrayToHexString(SM3.hash("test sm3 hash".getBytes())));
    }
}