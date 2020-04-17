//===============================================
var bMoveable=true;		//
var _VersionInfo=""
var monthNames=new Array("1\u6708","2\u6708","3\u6708","4\u6708","5\u6708","6\u6708","7\u6708","8\u6708","9\u6708","10\u6708","11\u6708","12\u6708");

//===============================================
var strFrame;		//
document.writeln('<iframe  id=meizzDateLayer frameborder=0 HEIGHT="211" width="169" style="position:absolute; z-index:9998; display: none"></iframe>');
strFrame='<style>';
strFrame+='INPUT.button{BORDER-RIGHT: #ff9900 1px solid;BORDER-TOP: #ff9900 1px solid;BORDER-LEFT: #ff9900 1px solid;';
strFrame+='BORDER-BOTTOM: #ff9900 1px solid;BACKGROUND-COLOR: #fff8ec;font-family:Verdana;}';
strFrame+='TD{FONT-SIZE: 8px;font-family:Verdana;}';
strFrame+='</style>';
strFrame+='<scr' + 'ipt>';
strFrame+='var datelayerx,datelayery;	/*\u5b58\u653e\u65e5\u5386\u63a7\u4ef6\u7684\u9f20\u6807\u4f4d\u7f6e*/';
strFrame+='var bDrag;	/*\u6807\u8bb0\u662f\u5426\u5f00\u59cb\u62d6\u52a8*/';
strFrame+='function document.onmousemove()	/*\u5728\u9f20\u6807\u79fb\u52a8\u4e8b\u4ef6\u4e2d\uff0c\u5982\u679c\u5f00\u59cb\u62d6\u52a8\u65e5\u5386\uff0c\u5219\u79fb\u52a8\u65e5\u5386*/';
strFrame+='{if(bDrag && window.event.button==1)';
strFrame+='	{var DateLayer=parent.document.getElementById("meizzDateLayer").style;';
strFrame+='		DateLayer.posLeft += window.event.clientX-datelayerx;/*\u7531\u4e8e\u6bcf\u6b21\u79fb\u52a8\u4ee5\u540e\u9f20\u6807\u4f4d\u7f6e\u90fd\u6062\u590d\u4e3a\u521d\u59cb\u7684\u4f4d\u7f6e\uff0c\u56e0\u6b64\u5199\u6cd5\u4e0ediv\u4e2d\u4e0d\u540c*/';
strFrame+='		DateLayer.posTop += window.event.clientY-datelayery;}}';
strFrame+='function DragStart()		/*\u5f00\u59cb\u65e5\u5386\u62d6\u52a8*/';
strFrame+='{var DateLayer=parent.document.getElementById("meizzDateLayer").style;';
strFrame+='	datelayerx=window.event.clientX;';
strFrame+='	datelayery=window.event.clientY;';
strFrame+='	bDrag=true;}';
strFrame+='function DragEnd(){		/*\u7ed3\u675f\u65e5\u5386\u62d6\u52a8*/';
strFrame+='	bDrag=false;}';
strFrame+='</scr' + 'ipt>';
strFrame+='<div style="z-index:9999;position: absolute; left:0; top:0;" onselectstart="return false"><span id=tmpSelectYearLayer Author=wayx style="z-index: 9999;position: absolute;top: 3; left: 19;display: none"></span>';
strFrame+='<span id=tmpSelectMonthLayer Author=wayx style="z-index: 9999;position: absolute;top: 3; left: 78;display: none"></span>';
strFrame+='<table border=1 cellspacing=0 cellpadding=0 width=167 height=160 bordercolor=#ff9900 bgcolor=#ff9900 Author="wayx">';
strFrame+='  <tr Author="wayx"><td width=167 height=23 Author="wayx" bgcolor=#FFFFFF><table border=0 cellspacing=1 cellpadding=0 width=165 Author="wayx" height=23>';
strFrame+='      <tr align=center Author="wayx"><td width=16 align=center bgcolor=#ff9900 style="font-size:11px;cursor: hand;color: #ffffff" ';
strFrame+='        onclick="parent.meizzPrevM()" title="\u4e0a\u7ffb\u4e00\u4e2a\u6708" Author=meizz><b Author=meizz>&lt;';
strFrame+='        </td><td width=82 align=center style="font-size:11px;cursor:default" Author=meizz ';
strFrame+='onmouseover="style.backgroundColor=\'#FFD700\'" onmouseout="style.backgroundColor=\'white\'" ';
strFrame+='onclick="parent.tmpSelectYearInnerHTML(this.innerText.substring(0,4))" title="\u9009\u62e9\u5e74\u4efd"><span Author=meizz id=meizzYearHead></span></td>';
strFrame+='<td width=82 align=center style="font-size:11px;cursor:default" Author=meizz onmouseover="style.backgroundColor=\'#FFD700\'" ';
strFrame+=' onmouseout="style.backgroundColor=\'white\'" onclick="parent.tmpSelectMonthInnerHTML(this.innerText)"';
strFrame+='        title="\u9009\u62e9\u6708\u4efd"><span id=meizzMonthHead Author=meizz></span></td>';
strFrame+='        <td width=16 bgcolor=#ff9900 align=center style="font-size:11px;cursor: hand;color: #ffffff" ';
strFrame+='         onclick="parent.meizzNextM()" title="\u4e0b\u7ffb\u4e00\u4e2a\u6708" Author=meizz><b Author=meizz>&gt;</td></tr>';
strFrame+='</table></td></tr>';
strFrame+='  <tr Author="wayx"><td width=167 height=18 Author="wayx">';
strFrame+='<table border=1 cellspacing=0 cellpadding=0 bgcolor=#ff9900 ' + (bMoveable? 'onmousedown="DragStart()" onmouseup="DragEnd()"':'');
strFrame+=' BORDERCOLORLIGHT=#FF9900 BORDERCOLORDARK=#FFFFFF width=162 height=20 Author="wayx" style="cursor:' + (bMoveable ? 'move':'default') + '">';
strFrame+='<tr Author="wayx" align=center valign=bottom><td style="font-size:11px;color:#FFFFFF" Author=meizz>\u65e5</td>';
strFrame+='<td style="font-size:11px;color:#FFFFFF" Author=meizz>\u4e00</td><td style="font-size:11px;color:#FFFFFF" Author=meizz>\u4e8c</td>';
strFrame+='<td style="font-size:11px;color:#FFFFFF" Author=meizz>\u4e09</td><td style="font-size:11px;color:#FFFFFF" Author=meizz>\u56db</td>';
strFrame+='<td style="font-size:11px;color:#FFFFFF" Author=meizz>\u4e94</td><td style="font-size:11px;color:#FFFFFF" Author=meizz>\u516d</td></tr>';
strFrame+='</table></td></tr><!-- Author:F.R.Huang(meizz) http://www.meizz.com/ mail: meizz@hzcnc.com 2002-10-8 -->';
strFrame+='  <tr Author="wayx"><td width=142 height=120 Author="wayx">';
strFrame+='    <table border=1 cellspacing=2 cellpadding=0 BORDERCOLORLIGHT=#FF9900 BORDERCOLORDARK=#FFFFFF bgcolor=#fff8ec width=165 height=115 Author="wayx">';
var n=0; for (j=0;j<5;j++){ strFrame+= ' <tr align=center Author="wayx">'; for (i=0;i<7;i++){
strFrame+='<td width=20 height=20 id=meizzDay'+n+' style="font-size:11px" Author=meizz onclick=parent.meizzDayClick(this.innerText,0)></td>';n++;}
strFrame+='</tr>';}
strFrame+='      <tr align=center Author="wayx">';
for (i=35;i<39;i++)strFrame+='<td width=20 height=20 id=meizzDay'+i+' style="font-size:11px" Author=wayx onclick="parent.meizzDayClick(this.innerText,0)"></td>';
strFrame+='        <td colspan=3 align=right Author=meizz><span onclick=parent.clearDate() style="font-size:10px;font-family:webdings;cursor: hand"';
strFrame+='         Author=meizz title="\u6e05\u9664"><u>=</u></span> <span onclick=javascript:parent.closeLayer() style="font-family:webdings;font-size:10px;cursor: hand" Author=meizz title="\u5173\u95ed"><u>r</u></span>&nbsp;</td></tr>';
strFrame+='    </table></td></tr><tr Author="wayx"><td Author="wayx">';
strFrame+='        <table border=0 cellspacing=1 cellpadding=0 width=100% Author="wayx" bgcolor=#FFFFFF>';
strFrame+='          <tr Author="wayx"><td Author=meizz align=left><input Author=meizz type=button class=button value="<<" title="\u4e0a\u7ffb\u4e00\u5e74" onclick="parent.meizzPrevY()" ';
strFrame+='             onfocus="this.blur()" style="font-size: 11px; height: 20px"><input Author=meizz class=button title="\u4e0a\u7ffb\u4e00\u4e2a\u6708" type=button ';
strFrame+='             value="< " onclick="parent.meizzPrevM()" onfocus="this.blur()" style="font-size: 11px; height: 20px"></td><td ';
strFrame+='             Author=meizz align=center><input Author=meizz type=button class=button value=\u4eca\u5929 title="\u5f53\u524d\u65e5\u671f" onclick="parent.meizzToday()" ';
strFrame+='             onfocus="this.blur()" style="font-size: 11px; height: 20px; cursor:hand"></td><td ';
strFrame+='             Author=meizz align=right><input Author=meizz type=button class=button value=" >" onclick="parent.meizzNextM()" ';
strFrame+='             onfocus="this.blur()" title="\u4e0b\u7ffb\u4e00\u4e2a\u6708" class=button style="font-size: 11px; height: 20px"><input ';
strFrame+='             Author=meizz type=button class=button value=">>" title="\u4e0b\u7ffb\u4e00\u5e74" onclick="parent.meizzNextY()"';
strFrame+='             onfocus="this.blur()" style="font-size: 11px; height: 20px"></td>';
strFrame+='</tr></table></td></tr></table></div>';

window.frames.meizzDateLayer.document.writeln(strFrame);
window.frames.meizzDateLayer.document.close();		//\u89e3\u51b3ie\u8fdb\u5ea6\u6761\u4e0d\u7ed3\u675f\u7684\u95ee\u9898

//==================================================== WEB \u9875\u9762\u663e\u793a\u90e8\u5206 ======================================================
var outObject;
var outButton;		//\u70b9\u51fb\u7684\u6309\u94ae
var outDate="";		//\u5b58\u653e\u5bf9\u8c61\u7684\u65e5\u671f
var odatelayer=window.frames.meizzDateLayer.document.all;		//\u5b58\u653e\u65e5\u5386\u5bf9\u8c61
function setday(tt,obj) //\u4e3b\u8c03\u51fd\u6570
{
	if (arguments.length >  2){alert("Script error");return;}
	if (arguments.length == 0){alert("Script error");return;}
	var dads  = document.getElementById("meizzDateLayer").style;
	var th = tt;
	var ttop  = tt.offsetTop;     //TT\u63a7\u4ef6\u7684\u5b9a\u4f4d\u70b9\u9ad8
	var thei  = tt.clientHeight;  //TT\u63a7\u4ef6\u672c\u8eab\u7684\u9ad8
	var tleft = tt.offsetLeft;    //TT\u63a7\u4ef6\u7684\u5b9a\u4f4d\u70b9\u5bbd
	var ttyp  = tt.type;          //TT\u63a7\u4ef6\u7684\u7c7b\u578b
	var pos = calPos(tt);
	var whei = getViewPortHeight();
	var downflag = 1;
	if (pos.y+160 > whei) {
		downflag = 0;
	}
	while (tt = tt.offsetParent){
		if (downflag) ttop+=tt.offsetTop;
		tleft+=tt.offsetLeft;
	}
	dads.top  = (ttyp=="image")? ttop+thei : ttop+thei+6;
	dads.left = tleft;
	outObject = (arguments.length == 1) ? th : obj;
	outButton = (arguments.length == 1) ? null : th;	//\u8bbe\u5b9a\u5916\u90e8\u70b9\u51fb\u7684\u6309\u94ae
	//\u6839\u636e\u5f53\u524d\u8f93\u5165\u6846\u7684\u65e5\u671f\u663e\u793a\u65e5\u5386\u7684\u5e74\u6708
	var reg = /^(\d{4})(\d{2})(\d{2})$/;
	var r = outObject.value.match(reg);
	if(r!=null){
		r[2]=r[2]-1;
		var d= new Date(r[1], r[2],r[3]);
		if(d.getFullYear()==r[1] && d.getMonth()==r[2] && d.getDate()==r[3]){
			outDate=d;		//\u4fdd\u5b58\u5916\u90e8\u4f20\u5165\u7684\u65e5\u671f
		}
		else outDate="";
			meizzSetDay(r[1],r[2]+1);
	}
	else{
		outDate="";
		meizzSetDay(new Date().getFullYear(), new Date().getMonth() + 1);
	}
	dads.display = '';

	event.returnValue=false;
}

var MonHead = new Array(12);    		   //\u5b9a\u4e49\u9633\u5386\u4e2d\u6bcf\u4e2a\u6708\u7684\u6700\u5927\u5929\u6570
    MonHead[0] = 31; MonHead[1] = 28; MonHead[2] = 31; MonHead[3] = 30; MonHead[4]  = 31; MonHead[5]  = 30;
    MonHead[6] = 31; MonHead[7] = 31; MonHead[8] = 30; MonHead[9] = 31; MonHead[10] = 30; MonHead[11] = 31;

var meizzTheYear=new Date().getFullYear(); //\u5b9a\u4e49\u5e74\u7684\u53d8\u91cf\u7684\u521d\u59cb\u503c
var meizzTheMonth=new Date().getMonth()+1; //\u5b9a\u4e49\u6708\u7684\u53d8\u91cf\u7684\u521d\u59cb\u503c
var meizzWDay=new Array(39);               //\u5b9a\u4e49\u5199\u65e5\u671f\u7684\u6570\u7ec4

document.onclick() //\u4efb\u610f\u70b9\u51fb\u65f6\u5173\u95ed\u8be5\u63a7\u4ef6	//ie6\u7684\u60c5\u51b5\u53ef\u4ee5\u7531\u4e0b\u9762\u7684\u5207\u6362\u7126\u70b9\u5904\u7406\u4ee3\u66ff
{
  with(window.event)
  { if (srcElement.getAttribute("Author")==null && srcElement != outObject && srcElement != outButton)
    closeLayer();
  }
}

document.onkeyup()		//\u6309Esc\u952e\u5173\u95ed\uff0c\u5207\u6362\u7126\u70b9\u5173\u95ed
  {
    if (window.event.keyCode==27){
		if(outObject)outObject.blur();
		closeLayer();
	}
	else if(document.activeElement)
		if(document.activeElement.getAttribute("Author")==null && document.activeElement != outObject && document.activeElement != outButton)
		{
			closeLayer();
		}
  }

function meizzWriteHead(yy,mm)  //\u5f80 head \u4e2d\u5199\u5165\u5f53\u524d\u7684\u5e74\u4e0e\u6708
  {
	odatelayer.meizzYearHead.innerHTML  = yy;
    odatelayer.meizzMonthHead.innerHTML = monthNames[mm-1];
  }

function tmpSelectYearInnerHTML(strYear) //\u5e74\u4efd\u7684\u4e0b\u62c9\u6846
{
  if (strYear.match(/\D/)!=null){alert("Script error");return;}
  var m = (strYear) ? strYear : new Date().getFullYear();
  if (m < 1000 || m > 9999) {alert("Script error");return;}
  var n = m - 10;
  if (n < 1000) n = 1000;
  if (n + 26 > 9999) n = 9974;
  var s = "<select Author=meizz name=tmpSelectYear style='font-size: 11px;width=65' "
     s += "onblur='document.all.tmpSelectYearLayer.style.display=\"none\"' "
     s += "onchange='document.all.tmpSelectYearLayer.style.display=\"none\";"
     s += "parent.meizzTheYear = this.value; parent.meizzSetDay(parent.meizzTheYear,parent.meizzTheMonth)'>\r\n";
  var selectInnerHTML = s;
  for (var i = n; i < n + 26; i++)
  {
    if (i == m)
       {selectInnerHTML += "<option Author=wayx value='" + i + "' selected>" + i + "" + "</option>\r\n";}
    else {selectInnerHTML += "<option Author=wayx value='" + i + "'>" + i + "" + "</option>\r\n";}
  }
  selectInnerHTML += "</select>";
  odatelayer.tmpSelectYearLayer.style.display="";
  odatelayer.tmpSelectYearLayer.innerHTML = selectInnerHTML;
  odatelayer.tmpSelectYear.focus();
}

function tmpSelectMonthInnerHTML(strMonth) //\u6708\u4efd\u7684\u4e0b\u62c9\u6846
{
  var thisMonth = -1;
  for(var j=0;j<12;j++){
  		if(strMonth == monthNames[j]){
  			thisMonth = j+1;
  			break;
  		}
  	}
  m = thisMonth;
  var s = "<select Author=meizz name=tmpSelectMonth style='font-size: 11px;width=65' "
     s += "onblur='document.all.tmpSelectMonthLayer.style.display=\"none\"' "
     s += "onchange='document.all.tmpSelectMonthLayer.style.display=\"none\";"
     s += "parent.meizzTheMonth = this.value; parent.meizzSetDay(parent.meizzTheYear,parent.meizzTheMonth)'>\r\n";

  var selectInnerHTML = s;
  for (var i = 1; i < 13; i++)
  {
    if (i == m)
       {selectInnerHTML += "<option Author=wayx value='"+i+"' selected>"+monthNames[i-1]+""+"</option>\r\n";}
    else {selectInnerHTML += "<option Author=wayx value='"+i+"'>"+monthNames[i-1]+""+"</option>\r\n";}
  }
  selectInnerHTML += "</select>";
  odatelayer.tmpSelectMonthLayer.style.display="";
  odatelayer.tmpSelectMonthLayer.innerHTML = selectInnerHTML;
  odatelayer.tmpSelectMonth.focus();
}

function closeLayer()               //\u8fd9\u4e2a\u5c42\u7684\u5173\u95ed
  {
    document.getElementById("meizzDateLayer").style.display="none";
  }

function IsPinYear(year)            //\u5224\u65ad\u662f\u5426\u95f0\u5e73\u5e74
  {
    if (0==year%4&&((year%100!=0)||(year%400==0))) return true;else return false;
  }

function GetMonthCount(year,month)  //\u95f0\u5e74\u4e8c\u6708\u4e3a29\u5929
  {
    var c=MonHead[month-1];if((month==2)&&IsPinYear(year)) c++;return c;
  }
function GetDOW(day,month,year)     //\u6c42\u67d0\u5929\u7684\u661f\u671f\u51e0
  {
    var dt=new Date(year,month-1,day).getDay()/7; return dt;
  }

function meizzPrevY()  //\u5f80\u524d\u7ffb Year
  {
    if(meizzTheYear > 999 && meizzTheYear <10000){meizzTheYear--;}
    else{alert("Script error");}
    meizzSetDay(meizzTheYear,meizzTheMonth);
  }
function meizzNextY()  //\u5f80\u540e\u7ffb Year
  {
    if(meizzTheYear > 999 && meizzTheYear <10000){meizzTheYear++;}
    else{alert("Script error");}
    meizzSetDay(meizzTheYear,meizzTheMonth);
  }
function meizzToday()  //Today Button
  {
	var today;
    meizzTheYear = new Date().getFullYear();
    meizzTheMonth = new Date().getMonth()+1;
    today=new Date().getDate();
    //meizzSetDay(meizzTheYear,meizzTheMonth);
    if(outObject){
		outObject.value=meizzTheYear + "" + (meizzTheMonth<10?"0":"")+meizzTheMonth + "" + (today<10?"0":"")+today;
		if(outObject.onblur)outObject.onblur();
    }
    closeLayer();
  }
function meizzPrevM()  //\u5f80\u524d\u7ffb\u6708\u4efd
  {
    if(meizzTheMonth>1){meizzTheMonth--}else{meizzTheYear--;meizzTheMonth=12;}
    meizzSetDay(meizzTheYear,meizzTheMonth);
  }
function meizzNextM()  //\u5f80\u540e\u7ffb\u6708\u4efd
  {
    if(meizzTheMonth==12){meizzTheYear++;meizzTheMonth=1}else{meizzTheMonth++}
    meizzSetDay(meizzTheYear,meizzTheMonth);
  }
function clearDate(){
	outObject.value="";
	if(outObject.onblur)outObject.onblur();
	closeLayer();
  }

function meizzSetDay(yy,mm)   //\u4e3b\u8981\u7684\u5199\u7a0b\u5e8f**********
{
  meizzWriteHead(yy,mm);
  //\u8bbe\u7f6e\u5f53\u524d\u5e74\u6708\u7684\u516c\u5171\u53d8\u91cf\u4e3a\u4f20\u5165\u503c
  meizzTheYear=yy;
  meizzTheMonth=mm;

  for (var i = 0; i < 39; i++){meizzWDay[i]=""};  //\u5c06\u663e\u793a\u6846\u7684\u5185\u5bb9\u5168\u90e8\u6e05\u7a7a
  var day1 = 1,day2=1,firstday = new Date(yy,mm-1,1).getDay();  //\u67d0\u6708\u7b2c\u4e00\u5929\u7684\u661f\u671f\u51e0
  for (i=0;i<firstday;i++)meizzWDay[i]=GetMonthCount(mm==1?yy-1:yy,mm==1?12:mm-1)-firstday+i+1	//\u4e0a\u4e2a\u6708\u7684\u6700\u540e\u51e0\u5929
  for (i = firstday; day1 < GetMonthCount(yy,mm)+1; i++){meizzWDay[i]=day1;day1++;}
  for (i=firstday+GetMonthCount(yy,mm);i<39;i++){meizzWDay[i]=day2;day2++}
  for (i = 0; i < 39; i++)
  { var da = eval("odatelayer.meizzDay"+i)     //\u4e66\u5199\u65b0\u7684\u4e00\u4e2a\u6708\u7684\u65e5\u671f\u661f\u671f\u6392\u5217
    if (meizzWDay[i]!="")
      {
		//\u521d\u59cb\u5316\u8fb9\u6846
		da.borderColorLight="#FF9900";
		da.borderColorDark="#FFFFFF";
		if(i<firstday)		//\u4e0a\u4e2a\u6708\u7684\u90e8\u5206
		{
			da.innerHTML="<font color=gray>" + meizzWDay[i] + "</font>";
			da.title=(mm==1?(meizzTheYear-1):meizzTheYear)+"-"+(mm==1?12:mm-1) +"-" + meizzWDay[i];
			da.onclick=Function("meizzDayClick(this.innerText,-1)");
			if(!outDate)
				da.style.backgroundColor = ((mm==1?yy-1:yy) == new Date().getFullYear() &&
					(mm==1?12:mm-1) == new Date().getMonth()+1 && meizzWDay[i] == new Date().getDate()) ?
					 "#FFD700":"#e0e0e0";
			else
			{
				da.style.backgroundColor =((mm==1?yy-1:yy)==outDate.getFullYear() && (mm==1?12:mm-1)== outDate.getMonth() + 1 &&
				meizzWDay[i]==outDate.getDate())? "#00ffff" :
				(((mm==1?yy-1:yy) == new Date().getFullYear() && (mm==1?12:mm-1) == new Date().getMonth()+1 &&
				meizzWDay[i] == new Date().getDate()) ? "#FFD700":"#e0e0e0");
				//\u5c06\u9009\u4e2d\u7684\u65e5\u671f\u663e\u793a\u4e3a\u51f9\u4e0b\u53bb
				if((mm==1?yy-1:yy)==outDate.getFullYear() && (mm==1?12:mm-1)== outDate.getMonth() + 1 &&
				meizzWDay[i]==outDate.getDate())
				{
					da.borderColorLight="#FFFFFF";
					da.borderColorDark="#FF9900";
				}
			}
		}
		else if (i>=firstday+GetMonthCount(yy,mm))		//\u4e0b\u4e2a\u6708\u7684\u90e8\u5206
		{
			var yyyy =0;
			yyyy = (mm==12?meizzTheYear-1+2:meizzTheYear);

			da.innerHTML="<font color=gray>" + meizzWDay[i] + "</font>";
			da.title= yyyy +"-"+ (mm==12?1:mm+1) +"-" + meizzWDay[i];
			da.onclick=Function("meizzDayClick(this.innerText,1)");
			if(!outDate)
				da.style.backgroundColor = ((mm==12?yy+1:yy) == new Date().getFullYear() &&
					(mm==12?1:mm+1) == new Date().getMonth()+1 && meizzWDay[i] == new Date().getDate()) ?
					 "#FFD700":"#e0e0e0";
			else
			{
				da.style.backgroundColor =((mm==12?yy+1:yy)==outDate.getFullYear() && (mm==12?1:mm+1)== outDate.getMonth() + 1 &&
				meizzWDay[i]==outDate.getDate())? "#00ffff" :
				(((mm==12?yy+1:yy) == new Date().getFullYear() && (mm==12?1:mm+1) == new Date().getMonth()+1 &&
				meizzWDay[i] == new Date().getDate()) ? "#FFD700":"#e0e0e0");
				if((mm==12?yy+1:yy)==outDate.getFullYear() && (mm==12?1:mm+1)== outDate.getMonth() + 1 &&
				meizzWDay[i]==outDate.getDate())
				{
					da.borderColorLight="#FFFFFF";
					da.borderColorDark="#FF9900";
				}
			}
		}
		else
		{
			da.innerHTML="" + meizzWDay[i] + "";
			da.title= meizzTheYear+"-"+(mm) +"-" + meizzWDay[i];
			da.onclick=Function("meizzDayClick(this.innerText,0)");		//\u7ed9td\u8d4b\u4e88onclick\u4e8b\u4ef6\u7684\u5904\u7406
			//\u5982\u679c\u662f\u5f53\u524d\u9009\u62e9\u7684\u65e5\u671f\uff0c\u5219\u663e\u793a\u4eae\u84dd\u8272\u7684\u80cc\u666f\uff1b\u5982\u679c\u662f\u5f53\u524d\u65e5\u671f\uff0c\u5219\u663e\u793a\u6697\u9ec4\u8272\u80cc\u666f
			if(!outDate)
				da.style.backgroundColor = (yy == new Date().getFullYear() && mm == new Date().getMonth()+1 && meizzWDay[i] == new Date().getDate())?
					"#FFD700":"#e0e0e0";
			else
			{
				da.style.backgroundColor =(yy==outDate.getFullYear() && mm== outDate.getMonth() + 1 && meizzWDay[i]==outDate.getDate())?
					"#00ffff":((yy == new Date().getFullYear() && mm == new Date().getMonth()+1 && meizzWDay[i] == new Date().getDate())?
					"#FFD700":"#e0e0e0");
				//\u5c06\u9009\u4e2d\u7684\u65e5\u671f\u663e\u793a\u4e3a\u51f9\u4e0b\u53bb
				if(yy==outDate.getFullYear() && mm== outDate.getMonth() + 1 && meizzWDay[i]==outDate.getDate())
				{
					da.borderColorLight="#FFFFFF";
					da.borderColorDark="#FF9900";
				}
			}
		}
        da.style.cursor="hand"
      }
    else{da.innerHTML="";da.style.backgroundColor="";da.style.cursor="default"}
  }
}

function meizzDayClick(n,ex)  //\u70b9\u51fb\u663e\u793a\u6846\u9009\u53d6\u65e5\u671f\uff0c\u4e3b\u8f93\u5165\u51fd\u6570*************
{
  var yy=meizzTheYear;
  var mm = parseInt(meizzTheMonth)+ex;	//ex\u8868\u793a\u504f\u79fb\u91cf\uff0c\u7528\u4e8e\u9009\u62e9\u4e0a\u4e2a\u6708\u4efd\u548c\u4e0b\u4e2a\u6708\u4efd\u7684\u65e5\u671f
	//\u5224\u65ad\u6708\u4efd\uff0c\u5e76\u8fdb\u884c\u5bf9\u5e94\u7684\u5904\u7406
	if(mm<1){
		yy--;
		mm=12+mm;
	}
	else if(mm>12){
		yy++;
		mm=mm-12;
	}

  if (mm < 10){mm = "0" + mm;}
  if (outObject)
  {
    if (!n) {//outObject.value="";
      return;}
    if ( n < 10){n = "0" + n;}
    outObject.value= yy + "" + mm + "" + n ; //\u6ce8\uff1a\u5728\u8fd9\u91cc\u4f60\u53ef\u4ee5\u8f93\u51fa\u6539\u6210\u4f60\u60f3\u8981\u7684\u683c\u5f0f
    if(outObject.onblur)
    	outObject.onblur();
    else
    {
    	if(outObject.bounddataset!=null)
    	{
    		outObject.bounddataset.setValue(outObject.dataset_fieldName, outObject.value);
    	}
    }
    closeLayer();
  }
  else {closeLayer(); alert("Script error");}
}
function showcal(obj){
	setday(obj);
}
function calPos(obj){
	var x=0;
	var y=0;
	while(obj!=null)
	{
		x+=obj.offsetLeft;
		y+=obj.offsetTop;
		obj = obj.offsetParent;
	}
	return {x:x,y:y};
}

function getViewPortHeight(){
    var height = 0;
    if (window.innerHeight)
    {
        height = window.innerHeight - 18;
    }
    else if ((document.documentElement) && (document.documentElement.clientHeight))
    {
        height = document.documentElement.clientHeight;
    }
    return height;
};