<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
String rand = request.getParameter("rand");
String contractId = request.getParameter("contractId");
%>
<frameset rows="0,*">
  <frame src="about:blank">
  <frame src="upload.jsp?rand=<c:out value='${rand}'/>&contractId=<c:out value='${contractId}'/>
 </frameset>