package com.huateng.ebank.business.management.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.huateng.ebank.business.common.ROOTDAO;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.htaml.reportForm.util.FaYuanConstant;
import com.huateng.msgplatform.mail.MailBean;

import resource.bean.msg.CpgMsgCtl;
import resource.bean.msg.CpgMsgGroup;
import resource.bean.msg.CpgMsgSndCtl;
import resource.bean.msg.CpgMsgSndDtl;
import resource.bean.msg.CpgMsgUsr;




public class SendMailService {
	private static Log log = LogFactory.getLog(SendMailService.class);
	public static void sendMail(String msgType,MailBean bean) throws Exception{
		
		if(bean!=null){//bean为空的时候说明未配置相关收邮件人
			CpgMsgSndDtl cmsd = null;
			ROOTDAO rootDao = ROOTDAOUtils.getROOTDAO();
			String title = bean.getTitle();
			String content = bean.getContent();
			List<String> rcvUrlList = bean.getAddresses();
			
			log.info("==================发送邮件开始,接收用户："+rcvUrlList.toString()+"=======================");
			for(int i=0;i<rcvUrlList.size();i++){
				if(null!=rcvUrlList.get(i)){
				try{
				cmsd = new CpgMsgSndDtl();
				String oppId = bean.getOppIds().get(rcvUrlList.get(i));
				cmsd.setMsgId(bean.getMsgId());
				cmsd.setOppId(oppId !=null ? oppId :"");
				cmsd.setRcvInf(rcvUrlList.get(i));
				cmsd.setStatus("0");
				
				cmsd.setContent(content);//邮件内容
				cmsd.setTitle(title);//邮件标题
//				ResourceBundle reb = ResourceBundle.getBundle("resources.mail");
//				Properties properties=new Properties();
//				String auth=reb.getString("mail.smtp.auth");
//				String host=reb.getString("mail.smtp.host");
//			//	String port=reb.getString("mail.smtp.port");
//		        final String user=reb.getString("mail.user");
//		        final String password=reb.getString("mail.password");
//				  // 获取系统属性
////		        final Properties properties = System.getProperties();
//
//		        // 设置邮件服务器
//		        properties.setProperty("mail.smtp.host", host);//"smtp.qq.com"
//		      //  properties.setProperty("mail.smtp.port", port);//
//		        properties.put("mail.smtp.auth", auth);
//		        MailSSLSocketFactory sf = new MailSSLSocketFactory();
//		        sf.setTrustAllHosts(true);
//		        properties.put("mail.smtp.ssl.enable", "true");
//		        properties.put("mail.smtp.starttls.enable", "true");
////		        properties.put("mail.smtp.ssl.socketFactory", sf);
//		        
//		        Authenticator authenticator=null;
//		        
//		        // 获取默认session对象
//		        if("true".equals(auth)){
//		        	authenticator=new Authenticator(){
//		            public PasswordAuthentication getPasswordAuthentication()
//		            {
//		                return new PasswordAuthentication(user, password); //发件人邮件用户名、密码
//		            }
//		        	};
//		        }
//		        Session session = Session.getInstance(properties,authenticator);
//		            // 创建默认的 MimeMessage 对象
//		            MimeMessage message = new MimeMessage(session);
//
//		            // Set From: 发件人
//		            InternetAddress from = new InternetAddress(user);
//		            message.setFrom(from);
//
//		            // Set To: 接收人
//		            message.addRecipient(Message.RecipientType.TO, new InternetAddress(rcvUrlList.get(i)));
//
//		            // Set Subject: 头部头字段
//		            message.setSubject(title);
//
//		            message.setContent(content, "text/html;charset=GBK");
//
//		            // 发送消息
//		            Transport.send(message);
//		            System.out.println("Sent message successfully....");
				final Properties props = new Properties();
				ResourceBundle rBundle = ResourceBundle.getBundle("resources.mailText");
				log.info("resources.mailText: "+rBundle);
				// 表示SMTP发送邮件，需要进行身份验证
				props.setProperty("mail.debug", "true");
				props.setProperty("mail.smtp.auth", rBundle.getString("mail.smtp.auth"));
				log.info("mail.smtp.auth: "+rBundle.getString("mail.smtp.auth"));
				props.setProperty("mail.smtp.host", rBundle.getString("mail.smtp.host"));
				log.info("mail.smtp.host: "+rBundle.getString("mail.smtp.host"));
				props.setProperty("mail.smtp.port", rBundle.getString("mail.smtp.port"));
				log.info("mail.smtp.port： "+rBundle.getString("mail.smtp.port"));
			//	props.setProperty("mail.URNsend", rBundle.getString("mail.URNsend"));
				props.setProperty("mail.transport.protocol",
						rBundle.getString("mail.transport.protocol"));
				// 发件人的账号
				props.setProperty("mail.user", rBundle.getString("mail.user"));
				log.info("mail.user: "+rBundle.getString("mail.user"));
				// 访问SMTP服务时需要提供的密码
				props.setProperty("mail.password", rBundle.getString("mail.password"));
				log.info("mail.password: "+rBundle.getString("mail.password"));
				Authenticator authenticator = null;
				if ("true".equals(rBundle.getString("mail.smtp.auth"))) {
					authenticator = new Authenticator() {
						protected PasswordAuthentication getPasswordAuthentication() {
							// 用户名、密码
							String userName = props.getProperty("mail.user");
							String password = props.getProperty("mail.password");
							return new PasswordAuthentication(userName, password);
						}
					};
				}
				System.out.println("**********************step begin");

				try {

					// 使用环境属性和授权信息，创建邮件会话
					Session mailSession = Session.getInstance(props, authenticator);
					// 创建邮件消息
					MimeMessage message = new MimeMessage(mailSession);
					// 设置发件人
					InternetAddress form = new InternetAddress(
							props.getProperty("mail.user"));
					message.setFrom(form);
					message.setSubject(title);
					//message.setText(content, "text/html;charset=GBK");
					
				    // MimeMultipart类是一个容器类，包含MimeBodyPart类型的对象
		            Multipart multiPart = new MimeMultipart();
		            // 创建一个包含HTML内容的MimeBodyPart
					BodyPart bodyPart = new MimeBodyPart();
					bodyPart.setContent(content, "text/html; charset=utf-8");
					multiPart.addBodyPart(bodyPart);
					
	                 
	                 // 设置邮件消息的主要内容
	                 message.setContent(multiPart);
	                 log.info("==============================邮件内容"+multiPart+"====================================");

//					String strings = props.getProperty("mail.URNsend");
//					String[] addrs = strings.split("\\$");
//					for (int i1 = 0; i1 < addrs.length; i1++) {
						InternetAddress toURN = new InternetAddress(rcvUrlList.get(i));
						message.setRecipient(RecipientType.TO, toURN);
						Transport.send(message);
						System.out.println("Sent message successfully....");
//					}

				} catch (AddressException e) {
					System.out.println("地址问题");
				} catch (MessagingException e) {
					System.out.println("发送失败");
					e.printStackTrace();
				}

				System.out.println("**********************step end");
				
				} catch(Exception e){
					log.info("==================发送邮件失败,接收用户："+rcvUrlList.get(i)+"ERROR："+e.toString()+"=======================");
					cmsd.setStatus("1");
					cmsd.setErrorType("03");
					e.printStackTrace();
				} finally{
					if(cmsd != null)
					rootDao.save(cmsd);
				}
			}
			
			log.info("==================发送邮件结束,接收用户："+rcvUrlList.toString()+"=======================");	
			}
		}
	}
	/**
	 * 
	 * @param msgType //用来查找要发送的用户好组
	 * @param mailContentBody //邮件体
	 * @param title //邮件标题
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void getMailBeanAndSendMail(String msgType, String mailContentBody,String title) throws Exception{
		MailBean mailBean = new MailBean();
		List<String> addresses = new ArrayList<String>();//address
		Map oppIdMap = new HashMap();
		
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		   StringBuffer hql = new StringBuffer("select po from CpgMsgCtl po where po.status = '"+FaYuanConstant.MSG_STATUS_0+"' and po.subType = '"+msgType+"'");//消息注册表
		List<CpgMsgCtl> lsit_CpgMsgCtl =  rootdao.queryByCondition(hql.toString());
		CpgMsgCtl cpgMsgCtl = new CpgMsgCtl();
		if(lsit_CpgMsgCtl != null && lsit_CpgMsgCtl.size()>0){
			cpgMsgCtl = lsit_CpgMsgCtl.get(0);
		}else{
			log.info("=====发送邮件时，消息类型表CpgMsgCtl中找不到相应的消息子类型subType=====");
		}
		String msgId = cpgMsgCtl.getMsgId();
		String content = mailContentBody;
		log.info("===================================================邮件的内容为"+content+"=================================================================");
		String hql_CpgMsgSndCtl = "from CpgMsgSndCtl where msgId = '"+cpgMsgCtl.getMsgId()+"'";//消息发送配置维护
		List<CpgMsgSndCtl> lis_CpgMsgSndCtl = rootdao.queryByQL2List(hql_CpgMsgSndCtl);
		for(CpgMsgSndCtl bean_CpgMsgSndCtl : lis_CpgMsgSndCtl){
			if(FaYuanConstant.MSG_OPP_ID_TYPE_2.equals(bean_CpgMsgSndCtl.getOppIdType())){//组
				log.info("====================================================发送给相关组=======================================================");
				String hql_CpgMsgGroup = "from CpgMsgGroup where groupId = '"+bean_CpgMsgSndCtl.getOppId()+"'";//组相关表
				List<CpgMsgGroup> list_CpgMsgGroup = rootdao.queryByQL2List(hql_CpgMsgGroup);
				for(CpgMsgGroup bean_CpgMsgGroup : list_CpgMsgGroup){
					String hql_CpgMsgUsr = "from CpgMsgUsr u where  u.userId = '"+bean_CpgMsgGroup.getUserId()+"'";//用户相关表
					List<CpgMsgUsr> list = rootdao.queryByQL2List(hql_CpgMsgUsr);
					for(CpgMsgUsr user : list){
						addresses.add(user.getRcvInf());
						oppIdMap.put(user.getRcvInf(), user.getUserId());
					}
				}
			}else if(FaYuanConstant.MSG_OPP_ID_TYPE_1.equals(bean_CpgMsgSndCtl.getOppIdType())){//用户
				log.info("====================================================发送给相关组=======================================================");
				StringBuffer hql_CpgMsgUsr = new StringBuffer("select u from CpgMsgUsr u where  u.userId = '"+bean_CpgMsgSndCtl.getOppId()+"'");//用户相关表
					List<CpgMsgUsr> list = rootdao.queryByCondition(hql_CpgMsgUsr.toString());
					for(CpgMsgUsr user : list){
						addresses.add(user.getRcvInf());
						oppIdMap.put(user.getRcvInf(), user.getUserId());
					}
			}
		}
		if(addresses.size()>0){
			log.info("==================mail addresses before sync:"+addresses.toString()+"=====================");
			//发送地址去重
			try{
				Map<String,String> syncMap = new HashMap<String,String>();
				for(int i=0;i<addresses.size();i++){
					if(!syncMap.containsKey(addresses.get(i))){
						syncMap.put(addresses.get(i),addresses.get(i));
					}
				}
				addresses = new ArrayList<String>(syncMap.values());
			}catch(Exception e){
				log.info("==================mail addresses sync ERROR:"+e.getMessage()+"=====================");
			}
			log.info("==================mail addresses after sync:"+addresses.toString()+"=====================");
			mailBean.setTitle(title);
			mailBean.setContent(content);
			mailBean.setMsgId(msgId);
			mailBean.setAddresses(addresses);
			mailBean.setOppIds(oppIdMap);
		}else{
			mailBean = null;
		}
		if(mailBean != null){
			sendMail(msgType,mailBean);
		}
		
	}
}
