package com.huateng.msgplatform.mail;

import java.util.Properties;

public class SmtpInfo {
    private String mailServerHost;
    private int mailServerPort = 25;
    // 邮件发送者的地址
    private String fromAddress;
    // 登陆邮件发送服务器的用户名和密码
    private String userName;
    private String password;
    // 是否需要身份验证
    private boolean validate = false;

    public boolean compare(SmtpInfo smtpInfo) {
        if (smtpInfo.getFromAddress().equalsIgnoreCase(this.getFromAddress())
                && smtpInfo.getMailServerHost().equalsIgnoreCase(this.getMailServerHost())
                && smtpInfo.getMailServerPort() == this.getMailServerPort()
                && smtpInfo.getPassword().equals(this.getPassword())
                && smtpInfo.getUserName().equalsIgnoreCase(this.getUserName())
                && smtpInfo.isValidate() == this.isValidate()) {
            return true;
        } else {
            return false;
        }
    }

    public Properties getProperties() {
        Properties p = new Properties();
        p.put("mail.smtp.host", this.mailServerHost);
        p.put("mail.smtp.port", this.mailServerPort);
        p.put("mail.smtp.auth", validate ? "true" : "false");
        p.put("mail.socket.debug", "true");
        System.setProperty("mail.socket.debug", "true");
        // p.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");//gmail需要
        return p;
    }

    public String getMailServerHost() {
        return mailServerHost;
    }

    public void setMailServerHost(String mailServerHost) {
        this.mailServerHost = mailServerHost;
    }

    public int getMailServerPort() {
        return mailServerPort;
    }

    public void setMailServerPort(int mailServerPort) {
        this.mailServerPort = mailServerPort;
    }

    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isValidate() {
        return validate;
    }

    public void setValidate(boolean validate) {
        this.validate = validate;
    }

}
