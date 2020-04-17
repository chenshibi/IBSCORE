package com.huateng.report.utils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
public class GZIPUtils  {
    public static final String GZIP_ENCODE_UTF_8 = "UTF-8"; 
    public static final String GZIP_ENCODE_ISO_8859_1 = "ISO-8859-1";

    
    public static byte[] compress(String str, String encoding) {
        if (str == null || str.length() == 0) {
            return null;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        GZIPOutputStream gzip;
        try {
            gzip = new GZIPOutputStream(out);
            gzip.write(str.getBytes(encoding));
            gzip.close();
        } catch ( Exception e) {
            e.printStackTrace();
        }
        return out.toByteArray();
    }
    
    public static byte[] compress(String str) throws IOException {  
        return compress(str, GZIP_ENCODE_UTF_8);  
    }
    
    public static byte[] uncompress(byte[] bytes) {
        if (bytes == null || bytes.length == 0) {
            return null;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream(bytes);
        try {
            GZIPInputStream ungzip = new GZIPInputStream(in);
            byte[] buffer = new byte[256];
            int n;
            while ((n = ungzip.read(buffer)) >= 0) {
                out.write(buffer, 0, n);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toByteArray();
    }
    
    public static String uncompressToString(byte[] bytes, String encoding) {  
        if (bytes == null || bytes.length == 0) {  
            return null;  
        }  
        ByteArrayOutputStream out = new ByteArrayOutputStream();  
        ByteArrayInputStream in = new ByteArrayInputStream(bytes);  
        try {
            GZIPInputStream ungzip = new GZIPInputStream(in);  
            byte[] buffer = new byte[256];  
            int n;  
            while ((n = ungzip.read(buffer)) >= 0) {  
                out.write(buffer, 0, n);  
            }  
            return out.toString(encoding);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static String uncompressToString(byte[] bytes) {  
        return uncompressToString(bytes, GZIP_ENCODE_UTF_8);  
    } 
    
    public static String CompressToBase64(String string){        
    	try {            
    		ByteArrayOutputStream os = new ByteArrayOutputStream(string.length());            
    		GZIPOutputStream gos = new GZIPOutputStream(os);            
    		gos.write(string.getBytes());            
    		gos.close();            
    		byte[] compressed = os.toByteArray();            
    		os.close();              
    		String result = Base64Encode.encode(compressed);            
    		return result;        
    		} catch (IOException e) {            
    			e.printStackTrace();            
    			}        catch (Exception ex){         
    				
    			}        return "";   
    			
    } 
 
    public static String DecompressToBase64(String textToDecode){        
        try {
         byte[] compressed =Base64.base64ToByteArray(textToDecode);       
    	 final int BUFFER_SIZE = 32;            
    	 ByteArrayInputStream inputStream = new ByteArrayInputStream(compressed);              
    	 GZIPInputStream gis  = new GZIPInputStream(inputStream, BUFFER_SIZE);              
    	 ByteArrayOutputStream baos = new ByteArrayOutputStream();           
    	 byte[] data = new byte[BUFFER_SIZE];            
    	 int bytesRead;            
    	 while ((bytesRead = gis.read(data)) != -1) {               
    	 baos.write(data, 0, bytesRead);            }             
    	 return baos.toString("UTF-8");        }        
    	 catch (IOException e) {            
    	 e.printStackTrace();        
    	 }       
    	 catch (Exception ex){          
    	 }        return "";    
    	 }

}