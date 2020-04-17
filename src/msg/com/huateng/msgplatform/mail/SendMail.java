package com.huateng.msgplatform.mail;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

import org.apache.log4j.Logger;

import com.huateng.ebank.business.common.ROOTDAO;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.report.utils.LogExceptionUtils;

import resource.bean.msg.CpgMsgCtl;
import resource.bean.msg.CpgMsgGroup;
import resource.bean.msg.CpgMsgSndCtl;
import resource.bean.msg.CpgMsgUsr;

public class SendMail {
    private static Logger log = Logger.getLogger(SendMail.class);

    public void send(MailBean bean) throws Exception {
        if (bean != null) {// bean为空的时候说明未配置相关收邮件人
            String title = bean.getTitle();
            String content = bean.getContent();
            List<String> receiveAddresses = bean.getAddresses();

            final Properties props = new Properties();
            // 表示SMTP发送邮件，需要进行身份验证
            // props.setProperty("mail.debug", "true");
            // props.setProperty("mail.smtp.auth",
            // Config.getValue("mail.smtp.auth"));
            // props.setProperty("mail.smtp.host",
            // Config.getValue("mail.smtp.host"));
            // props.setProperty("mail.transport.protocol",
            // Config.getValue("mail.transport.protocol"));
            // // 发件人的账号
            // props.setProperty("mail.user", Config.getValue("mail.user"));
            // // 访问SMTP服务时需要提供的密码
            // props.setProperty("mail.password",
            // Config.getValue("mail.password"));
            Authenticator authenticator = new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    // 用户名、密码
                    String userName = props.getProperty("mail.user");
                    String password = props.getProperty("mail.password");
                    return new PasswordAuthentication(userName, password);
                }
            };
            for (int i = 0; i < receiveAddresses.size(); i++) {
                try {
                    // 使用环境属性和授权信息，创建邮件会话
                    Session mailSession = Session.getInstance(props, authenticator);
                    // 创建邮件消息
                    MimeMessage message = new MimeMessage(mailSession);
                    // 设置发件人
                    InternetAddress form = new InternetAddress(props.getProperty("mail.user"));
                    message.setFrom(form);

                    InternetAddress to = new InternetAddress(receiveAddresses.get(i));
                    message.setRecipient(RecipientType.TO, to);
                    // 设置邮件标题
                    // message.setSubject(title);
                    message.setSubject(MimeUtility.encodeText(title, "utf-8", "B"));
                    // 设置邮件的内容体
                    message.setContent(content, "text/html;charset=UTF-8");
                    // 发送邮件
                    Transport.send(message);
                } catch (AddressException e) {
                    LogExceptionUtils.logException(log, e);
                    System.out.println("地址问题");
                    e.printStackTrace();
                } catch (MessagingException e) {
                    LogExceptionUtils.logException(log, e);
                    System.out.println("发送失败");
                    e.printStackTrace();
                }
            }
        }
        /*
         * // 使用环境属性和授权信息，创建邮件会话 Session mailSession =
         * Session.getInstance(props, authenticator); // 创建邮件消息 MimeMessage
         * message = new MimeMessage(mailSession); // 设置发件人 InternetAddress form
         * = new InternetAddress(props.getProperty("mail.user"));
         * message.setFrom(form); // 设置收件人 --多个 InternetAddress[] to = new
         * InternetAddress[receiveAddresses.size()]; for(int
         * i=0;i<receiveAddresses.size();i++){ to[i] = new
         * InternetAddress(receiveAddresses.get(i)); }
         * message.setRecipients(RecipientType.TO, to); // 设置抄送 //
         * InternetAddress[] cc = new InternetAddress[ccAddresses.size()]; //
         * for(int i=0;i<ccAddresses.size();i++){ // cc[i] = new
         * InternetAddress(ccAddresses.get(i)); // } //
         * message.setRecipients(RecipientType.CC, cc); // 设置邮件标题
         * message.setSubject(title); // 设置邮件的内容体 message.setContent(content,
         * "text/html;charset=UTF-8"); // 发送邮件 Transport.send(message);
         */
    }

    private MailBean getMailBean(String type, String brno) throws CommonException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
        String nowDate = sdf.format(new Date());
        MailBean resultbean = new MailBean();
        String title = null;
        String content = null;
        String msgId = null;
        List<String> addresses = new ArrayList<String>();// address
        Map<String, String> oppIds = new HashMap<String, String>();

        ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
        String hql_CpgMsgCtl = "from CpgMsgCtl where status = '" + MailConstant.MSG_STATUS_0 + "' and subType = '"
                + type + "'";// 消息注册表
        List<CpgMsgCtl> lsit_CpgMsgCtl = rootdao.queryByQL2List(hql_CpgMsgCtl);
        for (CpgMsgCtl bean_CpgMsgCtl : lsit_CpgMsgCtl) {
            if (title == null) {
                title = bean_CpgMsgCtl.getRsv1() + "【" + brno + "】 —— " + nowDate;
            }
            if (content == null) {
                content = bean_CpgMsgCtl.getRsv2() + "【" + brno + "】—— " + nowDate;
            }
            if (msgId == null) {
                msgId = bean_CpgMsgCtl.getMsgId();
            }
            String hql_CpgMsgSndCtl = "from CpgMsgSndCtl where msgId = '" + bean_CpgMsgCtl.getMsgId() + "'";// 消息发送配置维护
            List<CpgMsgSndCtl> lis_CpgMsgSndCtl = rootdao.queryByQL2List(hql_CpgMsgSndCtl);
            for (CpgMsgSndCtl bean_CpgMsgSndCtl : lis_CpgMsgSndCtl) {
                if (MailConstant.MSG_OPP_ID_TYPE_2.equals(bean_CpgMsgSndCtl.getOppIdType())) {// 组
                    String hql_CpgMsgGroup = "from CpgMsgGroup where groupId = '" + bean_CpgMsgSndCtl.getOppId() + "'";// 组相关表
                    List<CpgMsgGroup> list_CpgMsgGroup = rootdao.queryByQL2List(hql_CpgMsgGroup);
                    for (CpgMsgGroup bean_CpgMsgGroup : list_CpgMsgGroup) {
                        String hql_CpgMsgUsr = "from CpgMsgUsr u,CpgMsgUsrBranch b where u.userId = b.userId and u.userId = '"
                                + bean_CpgMsgGroup.getUserId() + "' and b.brno='" + brno + "'";// 用户相关表
                        List<Object[]> list = rootdao.queryByQL2List(hql_CpgMsgUsr);
                        for (Object[] bean : list) {
                            CpgMsgUsr user = (CpgMsgUsr) bean[0];
                            addresses.add(user.getRcvInf());
                            oppIds.put(user.getRcvInf(), user.getUserId());
                        }
                    }
                } else if (MailConstant.MSG_OPP_ID_TYPE_1.equals(bean_CpgMsgSndCtl.getOppIdType())) {// 用户
                    String hql_CpgMsgUsr = "from CpgMsgUsr u,CpgMsgUsrBranch b where u.userId = b.userId and u.userId = '"
                            + bean_CpgMsgSndCtl.getOppId() + "' and b.brno='" + brno + "'";// 用户相关表
                    List<Object[]> list = rootdao.queryByQL2List(hql_CpgMsgUsr);
                    for (Object[] bean : list) {
                        CpgMsgUsr user = (CpgMsgUsr) bean[0];
                        addresses.add(user.getRcvInf());
                        oppIds.put(user.getRcvInf(), user.getUserId());
                    }
                }
            }
        }
        if (addresses.size() > 0) {
            resultbean.setTitle(title);
            resultbean.setContent(content);
            resultbean.setMsgId(msgId);
            resultbean.setAddresses(addresses);
            resultbean.setOppIds(oppIds);
            return resultbean;
        } else {
            return null;
        }

    }

    public void sendMail(String type, String brno) throws Exception {
        send(getMailBean(type, brno));
    }

    public static void main(String[] args) throws Exception {
        SendMail servcie = new SendMail();
        MailBean bean = new MailBean();
        List<String> list = new ArrayList<String>();
        list.add("qq.zhang@huateng.com1");
        bean.setAddresses(list);
        bean.setTitle("标题");
        bean.setContent("内容");
        servcie.send(bean);
        // System.out.println(Config.getValue("mail.user"));
    }
}
