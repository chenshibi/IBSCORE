/*package com.huateng;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

public class Text {
	*//**
	 * 获取登录用户IP地址
	 * 
	 * @param request
	 * @return
	 *//*
	// http://www.jb51.net/article/73882.htm

	public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		if (ip.equals("0:0:0:0:0:0:0:1")) {
			ip = "本地";
		}
		return ip;
	}

	public static String getMacAddr(String ipAddress) {
		String str = "";
		String macAddress = "";
		try {
			System.out.println(ipAddress);
			Process p = Runtime.getRuntime().exec("nbtstat -A " + ipAddress);
			System.out.println("===process==" + p);
			InputStreamReader ir = new InputStreamReader(p.getInputStream());
			BufferedReader br = new BufferedReader(ir);
			while ((str = br.readLine()) != null) {
				if (str.indexOf("MAC") > 1) {
					macAddress = str.substring(str.indexOf("MAC") + 9,
							str.length());
					macAddress = macAddress.trim();
					System.out.println("macAddress:" + macAddress);
					break;
				}
			}
			p.destroy();
			br.close();
			ir.close();
		} catch (IOException ex) {
			System.out.println(ex);
		}
		return macAddress;
	}

	public static String getMac() {
		String ip = null;
		String mac = null;
		try {
			Process p = Runtime.getRuntime().exec("arp -n");
			InputStreamReader ir = new InputStreamReader(p.getInputStream());
			LineNumberReader input = new LineNumberReader(ir);
			try {
				p.waitFor();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			boolean flag = true;
			String ipStr = "(" + ip + ")";
			while (flag) {
				String str = input.readLine();
				if (str != null) {
					if (str.indexOf(ipStr) > 1) {
						int temp = str.indexOf("at");
						mac = str.substring(temp + 3, temp + 20);
						break;
					}
				} else
					flag = false;
			}
		} catch (IOException e) {
System.out.println(e);
		}
		return mac;
	}

	public static void main(String[] args) {
		//System.out.println(getMac());
		
		 InetAddress addr;
		try {
			addr = InetAddress.getByName("192.168.0.125");
		
         String ip=addr.getHostAddress().toString(); //获取本机ip  
         String hostName=addr.getHostName().toString(); //获取本机计算机名称  
         System.out.println("本机IP："+ip+"\n本机名称:"+hostName);  
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
	}
}
*/