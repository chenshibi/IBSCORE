<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=request.getContextPath()%>/css/public.css" rel="stylesheet" type="text/css">
</head>


<body style="margin: 0; background-color:#E6F4FB" >
<div class="leftmenu2">
<input type="checkbox" id="check" onclick="check()" checked>自动折叠</input>
</div>
<SCRIPT LANGUAGE="JavaScript" src="<%=request.getContextPath()%>/js/tree_maker.js"></SCRIPT>
<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/engine.js'> </script>
<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/util.js'> </script>
<SCRIPT LANGUAGE="JavaScript">
<%
StringBuffer t = (StringBuffer)request.getSession().getAttribute("tree");
%>
   		var   tree_node=new   Array(<c:out value='${t}'/>);
		document.write('<style>');
		document.write('TD.Tree_FOLDER_1{font-size: 15px; font-weight: bold; color: #0151A6; line-height: 35px;  padding-bottom:4px; padding-top:4px; border-bottom-width: 1px; border-bottom-style: inset; text-align:left; border-bottom-color: #51B2DF; background-color:#CBE8F5}');
		document.write('TD.Tree_FOLDER_2{font-size: 15px; font-weight: bold; color: #0151A6; line-height: 35px;  padding-bottom:4px; padding-top:4px; border-bottom-width: 1px; border-bottom-style: inset; text-align:left; border-bottom-color: #51B2DF; background-color:#CBE8F5}');
		document.write('TD.Tree_FOLDER_3{font-size: 15px; font-weight: bold; color: #0151A6; line-height: 35px;  padding-bottom:4px; padding-top:4px; border-bottom-width: 1px; border-bottom-style: inset; text-align:left; border-bottom-color: #51B2DF; background-color:#CBE8F5}');
		document.write('TD.Tree_FILE_1{font-size: 13px;  color: #0E026A;  font-weight: normal; padding-bottom:3px; padding-top:3px;  border-bottom-width: 1px;  border-bottom-style: dashed;  border-bottom-color: #51B0E0; text-align:left; line-height: 35px; }');
		document.write('TD.Tree_FILE_2{font-size: 13px;  color: #0E026A;  font-weight: normal; padding-bottom:3px; padding-top:3px;  border-bottom-width: 1px;  border-bottom-style: dashed;  border-bottom-color: #51B0E0; text-align:left; line-height: 35px; }');
		document.write('TD.Tree_FILE_3{font-size: 13px;  color: #0E026A;  font-weight: normal; padding-bottom:3px; padding-top:3px;  border-bottom-width: 1px;  border-bottom-style: dashed;  border-bottom-color: #51B0E0; text-align:left; line-height: 35px; }');
		document.write('</style>');
        var tree=new Tree_treeView();
        tree.useImage=true;
        tree.useTitleAsHint=true;
        tree.useTitleAsStatus=true;
        tree.useHint=true;
        tree.useStatus=true;
        tree.showSelect=true;
        tree.showLine=false;
        tree.Indent=10;
        tree.folderImg1="<%=request.getContextPath()%>/images/news_logo_01.gif";
        tree.lineFolder="<%=request.getContextPath()%>/images/";
        tree.folderImg2="<%=request.getContextPath()%>/images/news_logo_01.gif";
        tree.fileImg="<%=request.getContextPath()%>/images/c6.gif";
        tree.target="main";
        tree.folderClass1="Tree_FOLDER_1";
        tree.folderClass2="Tree_FOLDER_2";
        tree.folderClass3="Tree_FOLDER_3";
        tree.fileClass1="Tree_FILE_1";
        tree.fileClass2="Tree_FILE_2";
        tree.fileClass3="Tree_FILE_3";
        tree.closeall=true;
        Tree_buildTree(tree_node,tree);
        Tree_clickNode(0);

 		function add()
 		{
 			var name=parent.parent.frames["main"].document.title;
 			var url=parent.parent.frames["main"].location.href;
			var action = new Tree_action(3,"",url,"",tree.id);
			var nodeChild=new Tree_node(name,name,name,"","",action);
			Tree_AddNode(1,nodeChild);
 		}

 		function check()
 		{
 			var treeview = Tree_GetTree(tree);
 			treeview.closeall=document.getElementById("check").checked;
 			Tree_SetTree(treeview);
 		}
    </SCRIPT>

</body>
</html>
