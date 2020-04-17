package com.huateng.report.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import com.sun.jndi.toolkit.chars.BASE64Decoder;


public class ReportObjectSerializerUtil {

    /**
     * 序列化压缩、加密对象
     *
     * @param obj
     * @return
     * @throws IOException
     */
    public static String serialize(Object obj) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        GZIPOutputStream gzip = new GZIPOutputStream(bos);

        try {
            oos.writeObject(obj);
            oos.flush();
            byte abyte0[] = baos.toByteArray();
            gzip.write(abyte0);
            gzip.flush();
            gzip.finish();
            bos.flush();
            byte[] bytes = bos.toByteArray();
            return (new Base64Encode()).encode(bytes);
        } finally {
            if (oos != null) {
                oos.close();
            }
            if (baos != null) {
                baos.close();
            }
            if (gzip != null) {
                gzip.close();
            }
            if (bos != null) {
                bos.close();
            }
        }
    }

    /**
     * 字符串转为对象
     *
     * @param objectString
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static Object unserialize(String objectString) throws IOException, ClassNotFoundException {
        byte[] abyte1 = new BASE64Decoder().decodeBuffer(objectString);
        ByteArrayInputStream bais = new ByteArrayInputStream(abyte1);
        GZIPInputStream gzip = new GZIPInputStream(bais);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        int num = -1;
        while ((num = gzip.read(buf, 0, buf.length)) != -1) {
            baos.write(buf, 0, num);
        }
        baos.flush();
        ByteArrayInputStream bis = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        try {
            Object obj = ois.readObject();
            return obj;
        } finally {
            if (ois != null) {
                ois.close();
            }
            if (bis != null) {
                bis.close();
            }
            if (baos != null) {
                baos.close();
            }
            if (gzip != null) {
                gzip.close();
            }
            if (bais != null) {
                bais.close();
            }
        }
    }

    public static void main(String[] args) {
        try {
            String s = serialize(new Date());
            System.out.println(s);
            Object obj = unserialize(s);
            System.out.println(obj.toString());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
