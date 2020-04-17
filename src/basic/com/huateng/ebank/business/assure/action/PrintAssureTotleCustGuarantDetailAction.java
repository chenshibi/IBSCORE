package com.huateng.ebank.business.assure.action;

import java.io.ByteArrayInputStream;
import java.nio.charset.Charset;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.huateng.ebank.framework.web.struts.ResponseContentType;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontProvider;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

public class PrintAssureTotleCustGuarantDetailAction  extends Action{
	private static final Logger logger = Logger.getLogger(PrintAssureTotleCustGuarantDetailAction.class);

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		
		String htmlpdf= request.getParameter("htmlpdf");
		String fileName = System.currentTimeMillis()+".pdf";
		setResponse(response,fileName);
		htmlpdf = java.net.URLDecoder.decode(java.net.URLDecoder.decode(htmlpdf, "UTF-8"),"UTF-8");
//		System.out.println(htmlpdf);
		htmlpdf = htmlpdf.replaceAll("\\\\", "");
		
		htmlpdf = htmlpdf.replaceAll("<br/>", "");
		htmlpdf = htmlpdf.replaceAll("<br>", "");
		StringBuilder stringBuilder = new StringBuilder("");
		stringBuilder.append("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
		stringBuilder.append("<HTML>");
		stringBuilder.append("<HEAD>");
		stringBuilder.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"/>");
		stringBuilder.append("<TITLE>保证合同详细信息</TITLE>");
		stringBuilder.append("<style type=\"text/css\">");
		stringBuilder.append(".tableStyle {border-collapse: collapse;border: none;border-color: black;}");
		stringBuilder.append(".tdStyle {border: 0.5 solid; font-family:Microsoft YaHei;   color: #0066cc; font-size: 8px; }</style>");
		stringBuilder.append("<style type=\"text/css\">");
		stringBuilder.append(".style1 {   font-family:Microsoft YaHei;   color: #0066cc; font-size: 8px; }");
		stringBuilder.append(".style4 { color: #0066cc; font-size: 8px; }");
		stringBuilder.append("TD {  font-family:Microsoft YaHei; font-size: 8px; }   .high {font-family:Microsoft YaHei; font-size: 8px; }</style>	</HEAD>");
		stringBuilder.append("<body clase=\"style1\">");
		stringBuilder.append(htmlpdf);
		stringBuilder.append("</body></html>"); 
		System.out.println(htmlpdf);
		//设置
		
        // step 1
        Document document = new Document();
        // step 2
        PdfWriter writer = PdfWriter. getInstance(document, response.getOutputStream());
        // step 3
        document.open();
        FontProvider fontProvider = new FontProvider(){

			public Font getFont(String fontname, String encoding, boolean embedded, float size, int style, BaseColor color) {
				// TODO Auto-generated method stub
				BaseFont bf = null;
				try {
					bf = BaseFont.createFont("msyh.ttf", BaseFont.IDENTITY_H,BaseFont.NOT_EMBEDDED);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Font font = new Font(bf,size,style,color);
				font.setColor(color);
				return font;
			}

			public boolean isRegistered(String arg0) {
				// TODO Auto-generated method stub
				return false;
			}
        	
        };
		// step 4
//        XMLWorkerHelper. getInstance().parseXHtml(writer, document,
//                new FileInputStream( HTML),Charset.forName("UTF-8"));
        XMLWorkerHelper. getInstance().parseXHtml(writer, document, new ByteArrayInputStream(stringBuilder.toString().getBytes("UTF-8")),Charset.forName("UTF-8"),fontProvider );
        // step 5
        document.close();
        response.getOutputStream().flush();
		response.getOutputStream().close();
		return null;
	}
	private void setResponse(HttpServletResponse response,String fileName) {
		try {
			response.reset();

			String contentType = ResponseContentType.APPLICATION_MSEXCEL;
			String headerValue = "attachment;   filename=" + java.net.URLEncoder.encode(fileName, "UTF-8");
			String charset="UTF-8";

			response.setContentType(contentType);
			response.setHeader("Content-Disposition", headerValue);
			response.setCharacterEncoding(charset);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
