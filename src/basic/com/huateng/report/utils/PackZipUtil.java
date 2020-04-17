package com.huateng.report.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import com.huateng.ebank.framework.report.common.ReportConstant;
/**
 * 
 * @author Grassy
 *
 */
public class PackZipUtil {

    /**
     * 创建ZIP文件
     *
     * @param sourcePath
     *            文件或文件夹路径
     * @param zipPath
     *            生成的zip文件存在路径（包括文件名）
     * @throws Exception
     */
    public void createZip(String packPath, String[] packs, String zipPath) throws Exception {
        FileOutputStream fos = null;
        ZipOutputStream zos = null;
        try {
        	zipPath=HuaTengUtils.toStringAndTrim(zipPath);
            fos = new FileOutputStream(zipPath);
            zos = new ZipOutputStream(fos);
            for (int i = 0; i < packs.length; i++) {
                String sourcePath = packPath + packs[i] + File.separator;
                sourcePath=HuaTengUtils.toStringAndTrim(sourcePath);
                this.writeZip(new File(sourcePath), "", zos);
            }
        } catch (FileNotFoundException e) {
            throw new Exception("文件或目录不存在：" + e.getMessage());
        } finally {
            if (zos != null) {
                zos.close();
            }
            if (fos != null) {
                fos.close();
            }
        }
    }

    public static void createZip(List<String> filePathList, String zipPath) throws Exception {
        FileOutputStream fos = null;
        ZipOutputStream zos = null;
        try {
            fos = new FileOutputStream(zipPath);
            zos = new ZipOutputStream(fos);
            for (int i = 0; i < filePathList.size(); i++) {
                  writeZip(new File(filePathList.get(i)), "", zos);
            }
        } catch (FileNotFoundException e) {
            throw new Exception("文件或目录不存在：" + e.getMessage());
        } finally {
            if (zos != null) {
                zos.close();
            }
            if (fos != null) {
                fos.close();
            }
        }
    }

    private static void writeZip(File file, String parentPath, ZipOutputStream zos) throws Exception {
        if (file.exists()) {
            if (file.isDirectory()) {// 处理文件夹
                parentPath += file.getName() + File.separator;
                File[] files = file.listFiles();
                if(files != null){
                    for (File f : files) {
                         writeZip(f, parentPath, zos);
                    }
                }
            } else {
                FileInputStream fis = null;
                DataInputStream dis = null;
                try {
                    fis = new FileInputStream(file);
                    dis = new DataInputStream(new BufferedInputStream(fis));
                    ZipEntry ze = new ZipEntry(parentPath + file.getName());
                    zos.putNextEntry(ze);
                    byte[] content = new byte[1024];
                    int len;
                    while ((len = fis.read(content)) != -1) {
                        zos.write(content, 0, len);
                    }
                    zos.flush();
                } catch (Exception e) {
                    throw e;
                } finally {
                    if (dis != null) {
                        dis.close();
                    }
                    if (fis != null) {
                        fis.close();
                    }
                }
            }
        }
    }

    public Map<String, String> unZip(String zipFilePath, String saveFilePath, String appName) throws Exception {
        File zipFile = new File(zipFilePath);
        if (!zipFile.exists()) {
            throw new Exception("文件不存在：" + zipFilePath);
        }
        File sf = new File(saveFilePath);
        if (!sf.isDirectory()) {
            sf.mkdirs();
            FilePermissonUtils.setPermission755(saveFilePath);
        }
        Map<String, String> fileMap = new HashMap<String, String>();
        ZipEntry zipEntry = null;
        ZipInputStream zipInputStream = null;
        FileOutputStream os = null;
        FileInputStream fis = null;
        BufferedOutputStream bos = null;
        try {
            fis = new FileInputStream(zipFile);
            zipInputStream = new ZipInputStream(new BufferedInputStream(fis));
            while ((zipEntry = zipInputStream.getNextEntry()) != null) {
                String fileName = zipEntry.getName();
                String tableName = fileName.replaceAll(ReportConstant.BAK_FILE_EXT, "");
                if (appName != null) {
                    fileName = appName + fileName;
                }
                File saveFile = new File(saveFilePath + fileName);
                os = new FileOutputStream(saveFile);
                bos = new BufferedOutputStream(os);
                byte[] content = new byte[1024];
                int len;
                while ((len = zipInputStream.read(content)) != -1) {
                    bos.write(content, 0, len);
                }
                bos.flush();
                bos.close();
                os.close();
                bos = null;
                os = null;
                fileMap.put(tableName, saveFile.getPath());
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (bos != null) {
                bos.close();
            }
            if (os != null) {
                os.close();
            }
            if (zipInputStream != null) {
                zipInputStream.close();
            }
            if (fis != null) {
                fis.close();
            }
        }
        return fileMap;
    }

    /**
     * 将zip文件解压到给定的目录下
     * 
     * @param zipFilePath
     * @param saveFilePath
     * @return
     * @throws Exception
     */
    public List<File> unZip(String zipFilePath, String saveFilePath) throws Exception {
        File zipFile = new File(zipFilePath);
        if (!zipFile.exists()) {
            throw new Exception("文件不存在：" + zipFilePath);
        }

        List<File> unFileList = new ArrayList<File>();

        ZipEntry zipEntry = null;
        ZipInputStream zipInputStream = null;
        FileOutputStream os = null;
        FileInputStream fis = null;
        BufferedOutputStream bos = null;
        try {
            fis = new FileInputStream(zipFile);
            zipInputStream = new ZipInputStream(new BufferedInputStream(fis));
            while ((zipEntry = zipInputStream.getNextEntry()) != null) {
                String fileName = zipEntry.getName();
                String filePath = saveFilePath + fileName;
                File saveFile = new File(filePath);
                os = new FileOutputStream(saveFile);
                bos = new BufferedOutputStream(os);
                byte[] content = new byte[1024];
                int len;
                while ((len = zipInputStream.read(content)) != -1) {
                    bos.write(content, 0, len);
                }
                bos.flush();
                bos.close();
                os.close();
                bos = null;
                os = null;
                unFileList.add(saveFile);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (bos != null) {
                bos.close();
            }
            if (os != null) {
                os.close();
            }
            if (zipInputStream != null) {
                zipInputStream.close();
            }
            if (fis != null) {
                fis.close();
            }
        }
        return unFileList;
    }
    
	
	public static  byte[] createZip(String srcSource) throws Exception{
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ZipOutputStream zip = new ZipOutputStream(outputStream);
        //将目标文件打包成zip导出
        File file = new File(srcSource); 
        a(zip,file,"");
        IOUtils.closeQuietly(zip);
        return outputStream.toByteArray();
    }
	
	public static void a(ZipOutputStream zip, File file, String dir) throws Exception {
        //如果当前的是文件夹，则进行进一步处理
        if (file.isDirectory()) {
            //得到文件列表信息
            File[] files = file.listFiles();
            //将文件夹添加到下一级打包目录
            zip.putNextEntry(new ZipEntry(dir + "/"));
            dir = dir.length() == 0 ? "" : dir + "/";
            //循环将文件夹中的文件打包
            for (int i = 0; i < files.length; i++) {
                a(zip, files[i], dir + files[i].getName());         //递归处理
            }
        } else {   //当前的是文件，打包处理
            //文件输入流
           BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
           ZipEntry entry = new ZipEntry(dir);
           zip.putNextEntry(entry);
           zip.write(FileUtils.readFileToByteArray(file));
           IOUtils.closeQuietly(bis);
           zip.flush();
           zip.closeEntry();
        }
}

}
