package com.huateng.msgplatform.mail;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import org.apache.log4j.Logger;

import com.huateng.report.system.service.SysParamsService;
import com.huateng.report.utils.LogExceptionUtils;
import com.sun.mail.smtp.SMTPMessage;
import com.sun.mail.smtp.SMTPSendFailedException;

public class MailUtil {
    private static Logger log = Logger.getLogger(MailUtil.class);

    public static MailSendResult sendMail(SmtpInfo smtpInfo, MailInfo mailInfo) {
        List<MailSendResult> resultList = null;
        List<MailInfo> mailInfoList = new ArrayList<MailInfo>();
        mailInfoList.add(mailInfo);
        resultList = sendMail(smtpInfo, mailInfoList);
        if (resultList == null || resultList.size() == 0) {
            return null;
        } else {
            return resultList.get(0);
        }
    }

    public static List<MailSendResult> sendMail(SmtpInfo smtpInfo, List<MailInfo> mailInfoList) {
        List<MailSendResult> resultList = new ArrayList<MailSendResult>();

        for (MailInfo mailInfo : mailInfoList) {
            MailSendResult result = new MailSendResult();
            result.setId(mailInfo.getId());
            result.setSendResult(false);

            try {
                MyAuthenticator authenticator = null;
                if (smtpInfo.isValidate()) {
                    authenticator = new MyAuthenticator(smtpInfo.getUserName(), smtpInfo.getPassword());
                }
                Properties pro = smtpInfo.getProperties();
                Session sendMailSession = Session.getInstance(pro, authenticator);
                sendMailSession.setDebug(true);

                SMTPMessage mailMessage = new SMTPMessage(sendMailSession);
                Address from = new InternetAddress(smtpInfo.getFromAddress());
                mailMessage.setFrom(from);
                if (null == mailInfo.getAddresses() || mailInfo.getAddresses().size() == 0) {
                    log.error("mail receiver is null return false.");
                    result.setFailedReason("mail receiver is null.");
                    result.setSendResult(false);
                    resultList.add(result);
                    continue;
                }
                Address[] torArray = new InternetAddress[mailInfo.getAddresses().size()];
                int i = 0;
                for (String addr : mailInfo.getAddresses()) {
                    torArray[i] = new InternetAddress(addr);
                    i++;
                }
                mailMessage.setRecipients(Message.RecipientType.TO, torArray);
                mailMessage.setSubject(mailInfo.getTitle());
                mailMessage.setSentDate(new Date());
                mailMessage.setSendPartial(true);
                // MiniMultipart类是一个容器类，包含MimeBodyPart类型的对象
                Multipart mainPart = new MimeMultipart();
                // 创建一个包含HTML内容的MimeBodyPart
                BodyPart mbp = new MimeBodyPart();

                mbp.setContent(mailInfo.getContent(), "text/html; charset=utf-8");
                mainPart.addBodyPart(mbp);
                if (mailInfo.getAttachFileNames() != null && mailInfo.getAttachFileNames().length > 0) {
                    // 将MiniMultipart对象设置为邮件内容
                    String attachFiles[] = mailInfo.getAttachFileNames();
                    for (String f : attachFiles) {
                        mbp = new MimeBodyPart();
                        FileDataSource fds = new FileDataSource(f); // 得到数据源
                        mbp.setDataHandler(new DataHandler(fds)); // 得到附件本身并至入BodyPart
                        mbp.setFileName(MimeUtility.encodeText(fds.getName())); // 得到文件名同样至入BodyPart,MimeUtility.encodeText()避免中文乱码
                        mainPart.addBodyPart(mbp);
                    }
                }
                // 将MiniMultipart对象设置为邮件内容
                mailMessage.setContent(mainPart);
                Transport transport = null;
                try {
                    transport = sendMailSession.getTransport("smtp");
                    transport.connect();
                    transport.sendMessage(mailMessage, mailMessage.getAllRecipients());
                    result.setSendResult(true);
                    resultList.add(result);
                } catch (SMTPSendFailedException ssfe) {
                    boolean sentFlag = false;
                    if (ssfe.getValidSentAddresses() != null) {
                        for (Address addr : ssfe.getValidSentAddresses()) {
                            log.error("ValidSentAddress + " + addr);
                            sentFlag = true;
                        }
                    }
                    StringBuffer sb = new StringBuffer();
                    if (ssfe.getValidUnsentAddresses() != null && ssfe.getValidUnsentAddresses().length > 0) {
                        sb.append("ValidUnsentAddress: ");
                        for (Address addr : ssfe.getValidUnsentAddresses()) {
                            sb.append(addr + ", ");
                            log.error("ValidUnsentAddress + " + addr);
                        }
                    }

                    if (ssfe.getInvalidAddresses() != null && ssfe.getInvalidAddresses().length > 0) {
                        if (sb.length() == 0) {
                            sb.append("InvalidAddresses: ");
                        } else {
                            sb.append("; InvalidAddresses: ");
                        }
                        for (Address addr : ssfe.getInvalidAddresses()) {
                            sb.append(addr + ", ");
                            log.error("InvalidAddress + " + addr);
                        }
                    }
                    result.setFailedReason(sb.toString());
                    result.setSendResult(sentFlag);
                } catch (Exception ex) {
                    LogExceptionUtils.logException(log, ex);
                    log.error(ex);
                    result.setFailedReason(ex.getMessage());
                    result.setSendResult(false);
                } finally {
                    try {
                        if (transport != null) {
                            transport.close();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                continue;
            } catch (Exception ex) {
                LogExceptionUtils.logException(log, ex);
                result.setFailedReason(ex.getMessage());
            }
            result.setSendResult(false);
            resultList.add(result);
        }
        return resultList;
    }

    public static SmtpInfo initSmtpInfo() {

        SmtpInfo smtpInfo = new SmtpInfo();
        try {
            String mailSvr = SysParamsService.getInstance().getParaVal("SMTP", "MAILSVR");
            String username = SysParamsService.getInstance().getParaVal("SMTP", "USER");
            String password = SysParamsService.getInstance().getParaVal("SMTP", "PWD");
            String port = SysParamsService.getInstance().getParaVal("SMTP", "PORT");
            String from = SysParamsService.getInstance().getParaVal("SMTP", "FROM");
            String validate = SysParamsService.getInstance().getParaVal("SMTP", "NEEDLOGIN");

            if (mailSvr == null || mailSvr.length() == 0) {
                log.error("SMTP-MAILSVR is not in sysparams");
                return null;
            }
            if (username == null || username.length() == 0) {
                log.error("SMTP-USER is not in sysparams");
                return null;
            }

            boolean needValidate = false;
            if ("true".equalsIgnoreCase(validate)) {
                needValidate = true;
            }

            if (needValidate && (password == null || password.length() == 0)) {
                log.error("SMTP need validate but password is null");
                return null;
            }
            int iPort = 25;
            try {
                iPort = Integer.parseInt(port);
            } catch (Exception e) {
                LogExceptionUtils.logException(log, e);
                log.info("get port from sysparams failed, set to 25");
                iPort = 25;
            }

            smtpInfo.setFromAddress(from);
            smtpInfo.setMailServerHost(mailSvr);
            smtpInfo.setMailServerPort(iPort);
            smtpInfo.setPassword(password);
            smtpInfo.setValidate(needValidate);
            smtpInfo.setUserName(username);
            return smtpInfo;
        } catch (Exception e) {
            LogExceptionUtils.logException(log, e);
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String args[]) {
        // File file = new File("C:\\temp\\cics\\upload");
        // try {
        // if(file.exists()){
        // file.mkdirs();
        // }
        // System.out.println(file.getAbsolutePath());
        // } catch (Exception e) {
        // e.printStackTrace();
        // }
        // UUIDHexGenerator uuidGen = new UUIDHexGenerator();
        // for(int i=0;i<70000;i++){
        // if(i%65536 < 1){
        // System.out.println(i + ":" + uuidGen.generate(null, null));
        // }else{
        // uuidGen.generate(null, null);
        // }
        // }
        // System.out.println(System.currentTimeMillis());
        // UUID2Identifier uuid2 = new UUID2Identifier();
        // System.out.println(uuidGen.generate(null, null));
        // System.out.println(uuidGen.generate(null, null));
        // System.out.println(uuidGen.generate(null, null));
        // System.out.println(uuidGen.generate(null, null));
        // System.out.println(uuidGen.generate(null, null));
        // System.out.println(uuidGen.generate(null, null));
        // System.out.println(uuidGen.generate(null, null));
        // System.out.println(uuidGen.generate(null, null));
        // System.out.println(uuidGen.generate(null, null));
        // System.out.println(uuidGen.generate(null, null));
        // System.out.println(uuidGen.generate(null, null));
        // System.out.println(uuidGen.generate(null, null));
        // System.out.println(uuidGen.generate(null, null));
        // System.out.println(UUID.randomUUID().toString());
        // System.out.println(UUID.randomUUID().toString());
        // System.out.println(UUID.randomUUID().toString());
        // System.out.println(UUID.randomUUID().toString());
        // System.out.println(UUID.randomUUID().toString());
        // System.out.println(UUID.randomUUID().toString());
        // System.out.println(UUID.randomUUID().toString());
        // System.out.println(UUID.randomUUID().toString());
        // System.out.println(UUID.randomUUID().toString());
        // System.out.println(UUID.randomUUID().toString());

        // try {
        // InetAddress localHost = InetAddress.getLocalHost();
        // System.out.println(new Date());
        // String hostname = localHost.getCanonicalHostName();
        // System.out.println(new Date() + "-----" + hostname);
        // } catch (UnknownHostException e) {
        // e.printStackTrace();
        // }

        MailInfo mailInfo = new MailInfo();
        ArrayList<String> list = new ArrayList<String>();
        list.add("yi_siliang@huateng.com");
        list.add("yang_li11111111111@huateng.com");
        list.add("yang_li@huateng.com");
        list.add("yisiliang@foxmail.com");
        list.add("fdsafdsafdsafafsdafsd@huateng.com");
        List<MailInfo> mailInfoList = new ArrayList<MailInfo>();

        mailInfo.setAddresses(list);
        mailInfo.setContent("setContent");
        mailInfo.setTitle("setTitle");

        SmtpInfo smtpInfo = new SmtpInfo();
        smtpInfo.setFromAddress("wang_zhen@huateng.com");
        smtpInfo.setMailServerHost("mail.huateng.com");
        smtpInfo.setMailServerPort(25);
        smtpInfo.setPassword("Hu@teng123");
        smtpInfo.setUserName("zhen.wang");
        smtpInfo.setValidate(true);
        System.out.println(new Date());
        mailInfoList.add(mailInfo);
        // mailInfoList.add(mailInfo);
        // mailInfoList.add(mailInfo);
        // mailInfoList.add(mailInfo);
        // mailInfoList.add(mailInfo);
        // mailInfoList.add(mailInfo);
        MailUtil.sendMail(smtpInfo, mailInfoList);
        System.out.println(new Date());
    }

}
