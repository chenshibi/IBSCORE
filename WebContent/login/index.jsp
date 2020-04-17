<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.huateng.ebank.business.common.GlobalInfo"%>
<%@page import="com.huateng.ebank.business.common.UserSessionInfo"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9" />
<meta   http-equiv="Expires"   CONTENT="0">     
<meta   http-equiv="Cache-Control"   CONTENT="no-cache">     
<meta   http-equiv="Pragma"   CONTENT="no-cache">     
<title>Internal Bureau System</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/templets/ui/themes/blue/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/templets/ui/themes/icon.css">
<script type="text/javascript" src="<%=request.getContextPath() %>/templets/ui/js/jquery.js"></script>
<script type="text/javascript">
    jQuery.browser = {};
    (function () {
        jQuery.browser.msie = false;
        jQuery.browser.version = 0;
        if (navigator.userAgent.match(/MSIE ([0-9]+)\./)) {
            jQuery.browser.msie = true;
            jQuery.browser.version = RegExp.$1;
        }
    })();
    if(jQuery.uuid == null ||jQuery.uuid == "undefined" || jQuery.uuid == undefined){
        jQuery.uuid = 0;
    }
</script>
<script type="text/javascript" src="<%=request.getContextPath() %>/templets/ui/js/uicore-min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/templets/ui/locale/lang-zh_CN.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/templets/ui/js/basic.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/templets/ui/js/uiextend-min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/templets/ui/js/uirender-min.js"></script>
<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/engine.js'> </script>
<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/util.js'> </script>
<script type='text/javascript' src="<%=request.getContextPath()%>/dwr/interface/PrivAction.js" ></script>
<script type='text/javascript' src="<%=request.getContextPath()%>/templets/ui/js/uidata-min.js" ></script>
<!-- <script type='text/javascript' src="<%=request.getContextPath()%>/dwr/interface/SessionTicketProcess.js" ></script> -->
</head>
<script type="text/javascript">
<!--        
javascript:window.history.forward(1);      
//-->                    
var _application_root="<c:out value='<%=request.getContextPath()%>'/>"
var _current_user = "<c:out value='<%=((GlobalInfo) session.getAttribute(GlobalInfo.KEY_GLOBAL_INFO)).getTlrno()%>'/>";
switchTheme();
</script>
<style type="text/css">
    #li8 a {
        background:url('<%=request.getContextPath() %>/templets/ui/themes/blue/images/login/c_18.png') no-repeat;
    }
</style>
<body scroll="no" style="overflow:hidden;padding:0px;marggin:0px;">
<div id="northDiv" region="north" class="index-north" border="false">
<table id="headtbl" cellpadding="0" cellspacing="0" width="100%" height="0px" border="0" >
    <tr valign="top"  id="topIndex">
        <td class="banner-left" rowspan=2 ></td>
        <td class="banner-right" nowrap="nowrap">
            
            <ul class="small-tool">
           
                <li id="li1"><a href="javascript:void(0)" title="返回主页" onclick="showHome()"></a></li>
             
              <!-- 
               <li id="li2"><a href="javascript:void(0)" title="分行切换" onclick="switchBrno()"></a></li>
              -->
                <li id="li8"><a href="javascript:void(0)" title="个人密码修改" onclick="doWork('999999','密码修改','/fpages/management/ftl/ChangePwd.ftl');"></a></li>
                <li id="li3"><a href="javascript:void(0)" title="精简菜单" onclick="topHidden()"></a></li>
                <li id="li4"><a href="javascript:void(0)" title="退出"onclick="JavaScript:sExit()"></a></li>
            </ul>
        </td>
    </tr>
    <tr>
        <td>
            <%@ include file="menu/easymenu.jsp"%>
        </td>
        <td id="topMenu" style="display:none;white-space:nowrap;" nowrap="nowrap">
            <ul class="small-tool">
                <li id="li3"><a href="javascript:void(0)" title="还原" onclick="topShow()"></a></li>
                <li id="li4"><a href="javascript:void(0)" title="退出" onclick="JavaScript:sExit()"></a></li>
            </ul>
        </td>
    </tr>
</table>
</div>
<div region="center" border="false" id="centerDiv">
<div id ="workframe"></div>
</div>
<div region="south" border="false" class="index-south">
<table id="footer" cellpadding="0" cellspacing="0"  border="0">
    <td class="footer-left">
        <div class="footer-text">
        <c:out value='<%=((UserSessionInfo) session.getAttribute("USER_SESSION_INFO")).getFootbar()%>'/>
        </div>
    </td>
    <td class="footer-right" nowrap="nowrap">
            版本:v1.0.0
    </td>
</table>
</div>
<script type="text/javascript">

    function changeTheme() {
        openSubWin("changeTheme", "主题切换", "/login/theme.jsp");
    }
    
    function switchBrno() {
        openSubWin("switchBrno", "分行切换", "/login/switchBrno.jsp");
    }

    function showHome() {
        dts.refresh('home');
        dts.select('home');
    }
    function topHidden(){
        document.getElementById("topIndex").style.display ="none";
        //document.getElementById("loginMsgTr").style.display = "none";
        document.getElementById("topMenu").style.display = "";
        //$('#northDiv').width($(this).width());
        $('#northDiv').height($("#headtbl").height());
        $('body').layout('panel','north').panel('resize',{height:$("#headtbl").height()});
        $('body').layout('resize');
    }

    function topShow(){
        document.getElementById("topMenu").style.display = "none";
        //document.getElementById("loginMsgTr").style.display = "";
        document.getElementById("topIndex").style.display ="";
        $('#northDiv').height($("#headtbl").height());
        $('body').layout('panel','north').panel('resize',{height:$("#headtbl").height()});
        $('body').layout('resize');
    }

    function sExit(){
        var bl = window.confirm("确定要退出系统吗?");
        if(bl){ 
//              this.window.opener = null; window.open("","_self");  window.close();
                window.open("<%=request.getContextPath()%>/custlogout.do", "_top");
        }else{
                return false;
        }
    }

    function doWork(funId,title, url){
        if(url=='null') {
            dts.add({id:funId,title:title,content:'<h2>页面['+title+']未实现......</h2>',closable:true});
        } else {
            dts.add({id:funId,title:title,url:url,closable:true});
        }
    }

    function doErrProc(funId,title,url){
        if(dts.isExist(funId)){
            dts.refresh(funId, url);
            dts.select(funId);
        }else{
            doWork(funId,title, url);
        }
    }


    $('body').layout();
    var _application_root="<%=request.getContextPath()%>";
    var dts = new DynamicTabSet($("#workframe"),{isHaveNavigate:false});
    var _rootName=null;
    $(function(){
        $("#_MenuBar a").hover(
                function(e){
                    var src = e.target || window.event.srcElement;
                    var rName=src.outerText||src.textContent;
                    _rootName=rName;
                },
                function(){}
        );
        $('#northDiv').css('overflow','visible');
        $('#northDiv').parent().css('overflow','visible');
        dts.add({id:'home',title:'主页',url:'/login/homepage/home.jsp',isHaveNavigate:false});
        dts.setClosable('home',false);
        _resize();
    });

    function _resize(){
        $('#northDiv').width($(this)._outerWidth());
        $('#northDiv').height($("#headtbl").height());
        $('body').layout('panel','north').panel('resize',{height:$("#headtbl").height()});
        $('body').layout('resize');
    }
    //优化
    $(window).resize(_resize);

</script>
</body>
</html>