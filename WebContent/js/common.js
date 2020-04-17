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

function getNextElement(node)
{
	if(node!=null)
		node = node.nextSibling;
	while(node!=null&&node.nodeType!=1)
	{
		node = node.nextSibling;
	}
	return node;
}

function getFirstChildElement(node)
{
	node = node.firstChild;
	while(node!=null&&node.nodeType!=1)
	{
		node = node.nextSibling;
	}
	return node;
}

function getFirstChildElementByName(node,nodeName)
{
	node = node.firstChild;
	while(node!=null&&(node.nodeType!=1||node.nodeName!=nodeName))
	{
		node = node.nextSibling;
	}
	return node;
}
var Sys = {};
function getOs()
{
	var ua = navigator.userAgent.toLowerCase();
	var s;
	(s = ua.match(/msie ([\d.]+)/)) ? Sys.ie = s[1] :
	(s = ua.match(/firefox\/([\d.]+)/)) ? Sys.firefox = s[1] :
	(s = ua.match(/chrome\/([\d.]+)/)) ? Sys.chrome = s[1] :
	(s = ua.match(/opera.([\d.]+)/)) ? Sys.opera = s[1] :
	(s = ua.match(/version\/([\d.]+).*safari/)) ? Sys.safari = s[1] : 0;
}
getOs();
function $doc(elementId)
{
	return document.getElementById(elementId);
}
function disableElement(elementId)
{
	var element = $doc(elementId);
	if(element==null)return;
	if(element.tagName.toLowerCase()=="label")
	{
		element.style.color="gray";
		htmlFor = Sys.ie?element.htmlFor:element.getAttribute("for");
		if(htmlFor!="")
		{
			disableElement(htmlFor);
		}
	}
	if(element.tagName.toLowerCase()=="input")
	{
		element.style.backgroundColor="#E0E0E0";
	}
	element.disabled=true;
}
function enableElement(elementId)
{
	var element = $doc(elementId);
	if(element==null)return;
	if(element.tagName.toLowerCase()=="label")
	{
		element.style.color="";
		htmlFor = Sys.ie?element.htmlFor:element.getAttribute("for");
		if(htmlFor!="")
		{
			enableElement(htmlFor);
		}
	}
	if(element.tagName.toLowerCase()=="input")
	{
		element.style.backgroundColor="";
	}
	element.disabled=false;
}
String.prototype.trim = function () {
    return this.replace(/^\s*/, "").replace(/\s*$/, "");
}
function attachEvent(obj,eventName,fun,thisObj)
{
	var funArg = Array.prototype.slice.call(arguments,4);
	if(Sys.ie)
	{
		obj.attachEvent("on"+eventName,function(){return fun.apply(thisObj,funArg);});
	}
	if(Sys.firefox)
	{
		if(funArg.length!=0)
		{
			obj.addEventListener(eventName,function(){return fun.apply(thisObj,funArg);},false);
		}
		else
		{
			obj.addEventListener(eventName,function(e){return fun.apply(thisObj,[e]);},false);
		}
	}
}
function fireEvent(obj,eventName)
{
	if(Sys.ie)
	{
		obj.fireEvent("on"+eventName);
	}
	else
	{
		var evt = document.createEvent("HTMLEvents");
		evt.initEvent(eventName,true,true);
		obj.dispatchEvent(evt);
	}
}
document.oncontextmenu = function(e){
	e = e || window.event;
	if((Sys.ie&&e.srcElement.cancelContextMenu)||(Sys.firefox&&e.target.cancelContextMenu))
	{
		if(Sys.ie)e.srcElement.popcustMenu(e);
		if(Sys.firefox)e.target.popcustMenu(e);
		return false;
	}
	return true;
}
var custPopMenu;
function getCustPopMenu()
{
	if(custPopMenu==null)
	{
		custPopMenu = document.createElement("div");
		custPopMenu.cancelContextMenu = false;
		custPopMenu.style.display="none";
		custPopMenu.style.position="absolute";
		document.body.appendChild(custPopMenu);
	}
	return custPopMenu;
}
attachEvent(document,"click",function(e){
	e = e || window.event;
	var element = null;
	if(Sys.ie)element = e.srcElement;
	if(Sys.firefox)element = e.target;
	var popMenu = getCustPopMenu();
	while(element!=null)
	{
		if(element==popMenu||element.refMenu==popMenu){break;}
		element = element.parentNode;
	}
	if(element==null&&!popMenu.continueshow)popMenu.style.display="none";
	},null);
function Map(){this.data=new Array();}
Map.prototype.get=function(key){for(var i=0;i<this.data.length;i++){if(this.data[i].k==key){return this.data[i].v}}return null;}
Map.prototype.put=function(key,value){for(var i=0;i<this.data.length;i++){if(this.data[i].k==key){this.data[i].v=value;return;}}this.data.push({k:key,v:value});}
Map.prototype.containKey=function(key){for(var i=0;i<this.data.length;i++){if(this.data[i].k==key){return true;}}return false;}
Map.prototype.containValue=function(value){for(var i=0;i<this.data.length;i++){if(this.data[i].v==value){return true;}}return false;}
var ____window_setTimeout = window.setTimeout;
window.setTimeout = function (_fun,__time){
	if(typeof(_fun)=="function")
	{
		var args = Array.prototype.slice.call(arguments,2);
		var __f = function(){ _fun.apply(null,args);}; 
		return ____window_setTimeout(__f,__time);
	}
	return ____window_setTimeout(_fun,__time);
}
var ____window_setInterval = window.setInterval;
window.setInterval = function (_fun,__time){
	if(typeof(_fun)=="function")
	{
		var args = Array.prototype.slice.call(arguments,2);
		var __f = function(){ _fun.apply(null,args);}; 
		return ____window_setInterval(__f,__time);
	}
	return ____window_setInterval(_fun,__time);
}