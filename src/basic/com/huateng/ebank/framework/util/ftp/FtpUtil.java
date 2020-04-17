package com.huateng.ebank.framework.util.ftp;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;


/**
 * ftp涓婁紶锛屼笅杞�
 * 
 * @author jonay
 * 
 */
public class FtpUtil {

    private String ip = "";

    private String username = "";

    private String password = "";

    private int port = -1;

    private int TIMEOUT = 600000;

    private String path = "";

    private FTPClient ftpClient = null;

    private OutputStream os = null;

    private FileInputStream is = null;

    public FtpUtil(String serverIP, String username, String password) {
        this.ip = serverIP;
        this.username = username;
        this.password = password;
    }

    public FtpUtil(String serverIP, int port, String username, String password) {
        this.ip = serverIP;
        this.username = username;
        this.password = password;
        this.port = port;
    }

    /**
     * 杩炴帴ftp鏈嶅姟鍣�
     * 
     * @throws IOException
     */
    public boolean connectServer(int ftpMode) {
        // ftpClient = new FtpClient();
        // try {
        // ftpClient.setReadTimeout(TIMEOUT);
        // if (this.port != -1) {
        // ftpClient.openServer(this.ip, this.port);
        // } else {
        // ftpClient.openServer(this.ip);
        // }
        // ftpClient.login(this.username, this.password);
        // if (this.path.length() != 0) {
        // ftpClient.cd(this.path);// path鏄痜tp鏈嶅姟涓嬩富鐩綍鐨勫瓙鐩綍
        // }
        //
        // if (FTP.BINARY_FILE_TYPE == ftpMode) {// 2 浜岃繘鍒�
        // ftpClient.binary();
        // } else if (FTP.ASCII_FILE_TYPE == ftpMode) {// 0 ASCII鐮�
        // ftpClient.ascii();
        // }
        // System.out.println("宸茬櫥褰曞埌\"" + ftpClient.pwd() + "\"鐩綍");
        // return true;
        // } catch (IOException e) {
        // e.printStackTrace();
        return false;
        // }
    }

    /**
     * 鏂紑涓巉tp鏈嶅姟鍣ㄨ繛鎺�
     * 
     * @throws IOException
     */
    public boolean closeServer() {
        try {
            if (is != null) {
                is.close();
            }
            if (os != null) {
                os.close();
            }
            if (ftpClient != null) {
                // ftpClient.closeServer();
            }
            System.out.println("宸蹭粠鏈嶅姟鍣ㄦ柇寮�");
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 浠巉tp涓嬭浇鏂囦欢鍒版湰鍦�
     * 
     * @param filename
     *            鏈嶅姟鍣ㄤ笂鐨勬枃浠跺悕
     * @param newfilename
     *            鏈湴鐢熸垚鐨勬枃浠跺悕
     * @return
     * @throws Exception
     */
    public long downloadFile(String filename, String newfilename) {
        long result = 0;
        // TelnetInputStream is = null;
        // FileOutputStream os = null;
        // try {
        // is = ftpClient.get(filename);
        // File outfile = new File(newfilename);
        // if (!outfile.getParentFile().exists()) {
        // outfile.getParentFile().mkdirs();
        // }
        // os = new FileOutputStream(outfile);
        // byte[] bytes = new byte[1024];
        // int c;
        // while ((c = is.read(bytes)) != -1) {
        // os.write(bytes, 0, c);
        // result = result + c;
        // }
        // } catch (IOException e) {
        // e.printStackTrace();
        // } finally {
        // try {
        // if (is != null) {
        // is.close();
        // }
        // if (os != null) {
        // os.close();
        // }
        // } catch (IOException e) {
        // e.printStackTrace();
        // }
        // }
        return result;
    }

    public static void main(String[] args) {
        FtpUtil ftp = new FtpUtil("127.0.0.1", 21, "test1", "test");
        ftp.connectServer(FTP.BINARY_FILE_TYPE);
        System.out.println(ftp.downloadFile("upload/test浣犲ソ鍚�.xls", "f:/upload/test浣犲ソ鍚�.xls"));
        ftp.closeServer();
        /**
         * FTP杩滅▼鍛戒护鍒楄〃 USER PORT RETR ALLO DELE SITE XMKD CDUP FEAT PASS PASV
         * STOR REST CWD STAT RMD XCUP OPTS ACCT TYPE APPE RNFR XCWD HELP XRMD
         * STOU AUTH REIN STRU SMNT RNTO LIST NOOP PWD SIZE PBSZ QUIT MODE SYST
         * ABOR NLST MKD XPWD MDTM PROT
         * 鍦ㄦ湇鍔″櫒涓婃墽琛屽懡浠�,濡傛灉鐢╯endServer鏉ユ墽琛岃繙绋嬪懡浠�(涓嶈兘鎵ц鏈湴FTP鍛戒护)鐨勮瘽锛屾墍鏈塅TP鍛戒护閮借鍔犱笂\r\n
         * ftpclient.sendServer("XMKD /test/bb\r\n"); //鎵ц鏈嶅姟鍣ㄤ笂鐨凢TP鍛戒护
         * ftpclient.readServerResponse涓�瀹氳鍦╯endServer鍚庤皟鐢�
         * nameList("/test")鑾峰彇鎸囩洰褰曚笅鐨勬枃浠跺垪琛�
         * XMKD寤虹珛鐩綍锛屽綋鐩綍瀛樺湪鐨勬儏鍐典笅鍐嶆鍒涘缓鐩綍鏃舵姤閿� XRMD鍒犻櫎鐩綍 DELE鍒犻櫎鏂囦欢
         */
    }

}