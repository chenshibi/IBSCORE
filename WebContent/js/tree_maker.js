/************************************************************************************
*Title   :   treeMaker 脚本文件 (Ver 3.0)
*program :   区钊贤
*website :   http://www.ouzx.com
*e-mail  :   ouzhaoxian@21cn.com
*Date    :   2003-03-03  (all right reserved)
************************************************************************************/
var Tree_CHILD=-1;
var Tree_LAST=-2;
var Tree_ROOT=-3;
var Tree_FIRST=-4;
var Tree_SIBLING=-5;
var Tree_PREV=-6;
var Tree_NEXT=-7;
var Tree_const_begin_folder=-1;
var Tree_const_folder=0;
var Tree_const_end_folder=1;
var Tree_const_file=2;
var Tree_LINK=3;
var Tree_SCRIPT=4;
var Tree_const_end=5;
var Tree_isNC6 = (document.getElementById && !document.all)?true:false;
var Tree_isIE = (document.all)?true:false;
/* add by zhaozhiguo 是否以post方式将funcid传到后台 begin*/
var Tree_postFuncId = true;
var Tree_targetFrame = "main";
/* add by zhaozhiguo 是否以post方式将funcid传到后台 end*/
if(Tree_isNC6==false&&Tree_isIE==false)
	alert("本脚本不支持你的浏览器");
//---------------------------
var Tree_treeView_index=0;
var Tree_node_index=0;
var Tree_treeView_array=new Array();
var Tree_node_array=new Array();
//----------------------------
function Tree_action(type,script,link,target,treeViewIndex)
{
	this.type=type;
	this.link=link;
	this.target=target;
	this.script=script;
	this.treeViewIndex = treeViewIndex;
}
//---------------------------
function Tree_treeView()
{
	this.showLine=false;
	this.lineFolder="./";//连线图片文件夹
	this.Indent=13;
	this.useImage=this.useHint=this.useStatus=this.useTitleAsStatus
		=this.showSelect=this.useTitleAsHint=true;
	this.fileImg=this.folderImg1=this.folderImg2="";
	this.folderClass1=this.folderClass2=this.folderClass3=
		this.fileClass1=this.fileClass2=this.fileClass3="";
	this.target="_blank";
	this.closeall=true;
	//----------------
	this.selectID=null;
	this.id=Tree_treeView_index;
	this.flag=false;
	Tree_treeView_array[this.id]=this;
	var action=new Tree_action(0,0,0,0,Tree_treeView_index++);
	this.container=new Tree_node("","","","","",action);
	this.container.expand=true;
	//---------call back function
	this.callback_expanding=function callback_expanding(nodeID){return true;}
	this.callback_expanded=function callback_expanded(nodeID){}
	this.callback_collapsing=function callback_collapsing(nodeID){return true;}
	this.callback_collapsed=function callback_collapsed(nodeID){}
	this.callback_click=function callback_click(nodeID){return true;}
	this.callback_rightClick=function callback_rightClick(nodeID)
	{
		var node =this.getNode(nodeID);
		if(node.parent.id == 1)
		{
			showMenu("01",nodeID)
		}
		else
		{
			showMenu("10",nodeID)
		}
		return true;
	}
	//---------
	this.getRoot=function getRoot(){
		return this.container.childCount>0?this.container.child[0]:null;
	}
	this.click=function click(nodeID){
		var node=this.getNode(nodeID);
		if(node) Tree_clickNode(nodeID);
	}
	this.helper=function helper(node){
		if(node.childCount==0) return;
		this.expand(node.id,true);
		var i=0;
		while(i<=node.childCount-1)
			this.helper(node.child[i++]);
	}
	this.expandAll=function expandAll(){
		this.flag=true;
		var i=0;
		while(i<=this.container.childCount-1)
			this.helper(this.container.child[i++]);
		this.flag=false;
	}
	this.select=function select(nodeID,flag){
		var node=this.getNode(nodeID);
		if(node){
			flag=(typeof(flag)=="boolean"?flag:true);
			if(flag)Tree_selectNode(nodeID);
			else {
				var td=document.getElementById("Tree_td_"+nodeID);
				this.selectID=null;
				if(this.showSelect && td)
					td.className=(Tree_node_array[nodeID].childCount>0 && node.level() == 1)?
						this.folderClass1:this.fileClass1;
			}
			node.selected=flag;
		}
	}
	this.setText=function setText(nodeID,text){
		var node=this.getNode(nodeID);
		if(node)
			node.setText(text);
	}
	this.getImage=function getImage(nodeID){
		var node=this.getNode(nodeID);
		if(node)return node.getImage();
		return null;
	}
	this.getSelect=function getSelect(){//返回选择结点
		if(this.selectID!=null)
			return this.getNode(this.selectID);
		return null;
	}
	this.expand=function expand(nodeID,isExpand){
		var node=this.getNode(nodeID);
		this.flag=true;
		var div=document.getElementById("Tree_expand_"+nodeID);
		var td=document.getElementById("Tree_td_"+nodeID);
		if(node){
			if(node.expanded==isExpand)return;
			if(td)td.onclick();
			else node.expanded=isExpand;
		}
		this.flag=false;
	}
	this.clear=function clear(){
		this.container.child.length=this.container.childCount=0;
		this.refresh();
	}
	this.add=function add(relate_ID,nOption,nIndex,text,hint,status,img1,img2){
		if(nOption==Tree_ROOT)	{
			return this.container.addChild(nIndex,text,hint,status,img1,img2);
		}
		if(nOption==Tree_CHILD){
			var parent=this.getNode(relate_ID);
			if(parent==null) return null;
			return parent.addChild(nIndex,text,hint,status,img1,img2);
		}
		if(nOption==Tree_SIBLING){
			if(relate_ID==this.container.id) return null;
			var node=this.getNode(relate_ID);
			if(node==null) return null;
			return node.addSibling(nIndex,text,hint,status,img1,img2);
		}
		return null;
	}
	this.del=function del(id){
		if(id==this.container.id)
			return;
		var obj=this.getNode(id);
		if(obj)obj.parent.delChild(obj.index);
	}
	this.getNode=function getNode(nID){
		if(nID==this.container.id)return null;
		var obj=null;
		try{
			obj=Tree_node_array[nID];
			if(obj&&obj.id==nID)
				return obj.container()==this.container?obj:null;
			return null;
		}
		catch(e){return null;}
	}
	this.refresh=function refresh(){
		this.container.refresh();
	}
	this.isReady=function isReady(){
		return document.getElementById("Tree_treeView_"+this.id)!=null;
	}
}
//-----------------------------
function Tree_node(text,hint,status,img1,img2,action)
{
	this.img1=typeof(img1)=="string"?img1:"";
	this.img2=typeof(img2)=="string"?img2:"";
	this.text=typeof(text)=="string"?text:"";
	this.hint=typeof(hint)=="string"?hint:"";
	this.status=typeof(status)=="string"?status:"";
	//------------------
	this.child = new Array();
	this.id=Tree_node_index;
	this.parent=null;
	this.action=action;
	this.expanded=false;
	this.selected=false;
	this.index=0;
	this.childCount=0;
	Tree_node_array[Tree_node_index++]=this;
	//------------------
	this.addChild=function addChild(index,text,hint,status,img1,img2){
		var action=new Tree_action(0,0,0,0,this.action.treeViewIndex);
		var node=new Tree_node(text,hint,status,img1,img2,action);
		this.add(node,index);
		return node;
	}
	this.getImage=function getImage(){
		return document.getElementById("Tree_img_"+this.id);
	}
	this.refresh=function refresh(){
		if(this.parent)return;
		var html="<DIV id='Tree_treeView_"+this.id+"'>";
		var div=document.getElementById("Tree_treeView_"+this.id);
		if(div==null)
			document.write(html+this.getHtml()+"</DIV>");
		else div.innerHTML=this.getHtml();
	}
	this.setLink=function setLink(link,target){
		if(this.parent==null) return;
		this.action.type=Tree_LINK;
		this.action.target=target;
		this.action.link=link;
	}
	this.setScript=function setScript(script){
		this.action.type=Tree_SCRIPT;
		this.action.script=script;
	}
	this.next=function getNext(){
		if(this.parent==null || this.index>=this.parent.childCount-1)
			return null;
		return (this.parent.child[this.index+1]);
	}
	this.prev=function getPrev(){
		if(this.parent==null || this.index<=0)
			return null;
		return (this.parent.child[this.index-1]);
	}
	this.container=function container(){
		var tmp=this.parent;
		while(tmp && tmp.parent)
			tmp=tmp.parent;
		return tmp;
	}
	this.addSibling=function addSibling(index,text,hint, status,img1,img2){
		if(this.parent==null)return null;
		if(index==Tree_PREV) index=this.index;
		if(index==Tree_NEXT) index=this.index+1;
		return this.parent.addChild(index,text,hint,status,img1,img2);
	}
	this.add=function add(childNode,index){
		if(index==Tree_FIRST)
			index=0;
		if(index==Tree_LAST)
			index=this.childCount;
		if(index<0)
			index=0;
		if(index>this.childCount)
			index=this.childCount;
		var len=this.childCount-1;
		while(len>=index){
			this.child[len+1]=this.child[len];
			this.child[len+1].index=len+1;
			len--;
		}
		this.child[index]=childNode;
		childNode.index=index;
		childNode.parent=this;
		this.childCount++;
		var tree=this.getTreeView();
		if(tree.flag==true) return;
		if(tree.isReady()) {
			var img = this.getImage();
			if(this.parent && img )
				img.src=Tree_imgSrc(this);
			var line=document.getElementById("Tree_line_"+ this.id);
			if(line)line.src=Tree_GetLineImg(this);
			var parent=document.getElementById("Tree_expand_"+ this.id);
			if(parent==null)
				parent=document.getElementById("Tree_treeView_"+ this.id);
			var div=document.createElement("DIV");
			div.innerHTML=Tree_table(childNode)+"<DIV id=Tree_expand_"+ childNode.id+
						" STYLE='{display:"+(childNode.expanded?"block;":"none;")
						+"}'></DIV>";
			var before=null;
			if(this.childCount==1);
			else if(this.childCount-1==index){
				var node=this.child[index-1];
				line=document.getElementById("Tree_line_"+ node.id);
				if(line){
					line.src=Tree_GetLineImg(node);
					line=document.getElementsByName("Tree_td_line_"+ node.id);
					for(var i=line.length-1;i>=0;i--)
						line[i].innerHTML="<IMG  src="+tree.lineFolder+"/tree_I.gif>";
				}
			}
			else {
				line=document.getElementById("Tree_line_"+ this.child[index+1].id);
				if(line)line.src=Tree_GetLineImg(this.child[index+1]);
				before=document.getElementById("Tree_expand_"+this.child[index+1].id).parentNode;
			}
			parent.insertBefore(div,before);
		}
		else this.getTreeView().refresh();
	}//--------------
	this.contain=function contain(childnodeID)
	{
		if(childnodeID==null) return false;
		var tmp=Tree_node_array[childnodeID];
		while(tmp.parent)
		{
			if(tmp.parent==this||tmp==this)
				return true;
			tmp=tmp.parent;
		}
		return false;
	}
	//-----------
	this.level=function level()	{
		if(this.parent==null) return -1;//container
		var tmp=this;var n=0;
		while(tmp && tmp.parent)	{
			n++;
			tmp=tmp.parent;
		}
		return n;
	}
	this.getParentEx=function getParentEx(level){
		var p=this;var n=this.level();
		if(n<=1)return null;
		while(p && level!=n){
			p=p.parent;n--;
		}
		return p;
	}
	//-------------------
	this.getType=function getType(){
		return this.action.type;
	}
	this.getLink=function getLink(){
		return this.action.link;
	}
	this.getTarget=function getTarget(){
		return this.action.target;
	}
	this.getScript=function getScript(){
		return this.action.script;
	}
	//------------
	this.getTreeView=function getTreeView(){
		return Tree_treeView_array[this.action.treeViewIndex];
	}
	//---------
	this.delChild=function delChild(index)
	{
		if(index>this.childCount-1 || index<0)
			return;
		var len=this.childCount-1;
		var tree=this.getTreeView();
		if(tree.isReady())//refresh
		{
			var div=document.getElementById("Tree_expand_"+ this.child[index].id).parentNode;
			div.parentNode.removeChild(div);
			if(this.childCount==1&&this.parent)
			{
				this.childCount--;
				var img = this.getImage();
				if(img) img.src=Tree_imgSrc(this);
				this.childCount++;
			}
			if(index==this.childCount-1 &&index>0){
				this.childCount--;
				var node=this.child[index-1];
				var line=document.getElementsByName("Tree_td_line_"+ node.id);
				for(var i=line.length-1;i>=0;i--)
					line[i].innerHTML="<IMG style='width:19px;height:20px;visibility:hidden'>";
				line=document.getElementById("Tree_line_"+node.id);
				if(line)	line.src=Tree_GetLineImg(node);
				this.childCount++;
			}
			if(this.childCount==1){
				this.childCount--;
				var line=document.getElementById("Tree_line_"+ this.id);
				if(line)	line.src=Tree_GetLineImg(this);
				document.getElementById("Tree_expand_"+this.id).style.display="none";
				this.childCount++;
			}
		}
		if(this.child[index].contain(tree.selectID))//select node will be deleted
			tree.selectID=null;
		Tree_node_array[this.child[index].id]=null;
		while(index<=len-1)//move element
		{
			this.child[index+1].index=index;
			this.child[index]=this.child[index+1];
			index++;
		}
		this.child.length=(--this.childCount);
	}
	//--------------
	this.getHtml=function getHtml()
	{
		var html="";
		if(this.parent)
		{
			var tree=this.getTreeView();
			html+="<DIV >";
			html+=Tree_table(this);
			html+="<DIV id=Tree_expand_"+ this.id+
						" STYLE='{display:"+(this.expanded?"block;":"none;")+"}'>";
		}
		if(this.childCount>0)	{//folder
			for(var i=0;i<=this.childCount-1;i++)
			{
				html+=this.child[i].getHtml();
			}
		}
		if(this.parent)html+="</DIV></DIV>";
		return html;
	}
	//----------
	this.setText=function setText(text){
		var td=document.getElementById("Tree_td_"+this.id);
		if(td)
			td.innerHTML=this.text=text;
	}
	//---
	this.expand=function expand(toExpand){
		this.getTreeView().expand(this.id,toExpand);
	}
	//--
	this.click=function click()	{
		this.getTreeView().click(this.id);
	}
	//--
	this.select=function select(flag)	{
		this.getTreeView().select(this.id,flag);
	}
	this.gethint=function gethint()	{
		return this.hint;
	}
}
//--------------------
function Tree_on_action(action)//fire when click node
{
	if(action.type==Tree_LINK)//link
	{
		var target = action.target;
		if(target=="")//default target
		{
		
/* add by zhaozhiguo 是否以post方式将funcid传到后台 begin*/
			if (Tree_postFuncId) {
				try {
					var form = document.getElementById("Tree_Form");
					if (!form) {
						form = document.createElement("FORM");
						form.id = "Tree_Form";
						form.method = "post";
						form.target = Tree_targetFrame;
						form.style.visibility ="hidden";
						form.insertAdjacentHTML("beforeEnd","<input type=\"hidden\" name=\"__FuncId\" >");
						document.body.appendChild(form);
					}
					form.action = action.link;
					if (tree) {
						form["__FuncId"].value = tree.getSelect().hint;
					}
					form.submit();
				} catch (e) {
					alert("tree_maker.js:"+e);
				}
			} else {
				target = Tree_treeView_array[action.treeViewIndex].target;
				////本系统默认页面
				//parent.parent.window.frames[1].location=action.link;
				window.open(action.link,"main");
			}
/* add by zhaozhiguo 是否以post方式将funcid传到后台 end*/
		}
		if( target=="_self"||target=="_top"||target=="_parent"||target=="_blank")
			window.open(action.link,target);
		else
		{

			var command = target +".location = action.link";

		}
	}
	else if(action.type==Tree_SCRIPT)//run script
	{
		try{eval(action.script);}catch(e){alert("error\r\n\r\n"+e.description);}
	}
}

//----------------
function Tree_selectNode(nodeID)
{
	var node=Tree_node_array[nodeID];
	if(node==null||node.parent==null)return;
	//add by zhaozhiguo BMSA-53-1选中菜单高亮 begin
	if(node.childCount>0)return;
	////add by zhaozhiguo BMSA-53-1选中菜单高亮 end
	var level=node.level();
	var tree=node.getTreeView();
	var td=document.getElementById("Tree_td_"+nodeID);
	var tdOld=document.getElementById("Tree_td_"+tree.selectID);
	node.selected=true;//select node
	if(tree.selectID!=null)
	{
		Tree_node_array[tree.selectID].selected=false;//unselect node
		if(tree.showSelect && tdOld)
			tdOld.className=Tree_node_array[tree.selectID].childCount>0?
				tree.folderClass1:tree.fileClass1;//reset to normal class
	}
	tree.selectID=nodeID;
	if(tree.showSelect && td)
		td.className=Tree_node_array[tree.selectID].childCount>0?
			tree.folderClass3:tree.fileClass3;
}

//--------------------
function Tree_closeAll(nodeID,Childid)
{

	var node=Tree_node_array[nodeID];
	if(node.childCount <= 0)
	return;
	var tree=node.getTreeView();
	var i=0;
	while(i<node.childCount)
	{
		var nodeChild=node.child[i];
		var nodeChildId=node.child[i].id;
		if(nodeChildId==Childid)
		{
			i++;
			continue;
		}
		var div=document.getElementById("Tree_expand_"+nodeChildId);
		var img=document.getElementById("Tree_img_"+nodeChildId);
		var td=document.getElementById("Tree_td_"+nodeChildId);
		if(tree.flag==false)Tree_selectNode(nodeChildId);
		if(node.childCount>0)//folder
		{
			nodeChild.expanded=false;
			if(div)div.style.display="none";
			if(img)	img.src=Tree_imgSrc(nodeChild);
			var line=document.getElementById("Tree_line_"+nodeChildId);
			if(line)line.src=Tree_GetLineImg(nodeChild);
		}
		i++;
	}
}

//--------------------
function Tree_clickNode(nodeID)
{
	var node=Tree_node_array[nodeID];
	if(node==null||node.parent==null)return;//root
	var tree=node.getTreeView();
	if(tree.closeall == true)
		Tree_closeAll(node.parent.id,nodeID);
	var div=document.getElementById("Tree_expand_"+nodeID);
	var img=document.getElementById("Tree_img_"+nodeID);
	var td=document.getElementById("Tree_td_"+nodeID);
	//---------
	if(!node.expanded && node.childCount>0 &&tree.flag==false)
		if(tree.callback_expanding(nodeID)==false)//cancel expand
			return;
	if(node.expanded && node.childCount>0 &&tree.flag==false)
		if(tree.callback_collapsing(nodeID)==false)//cancel collapse
			return;
	node.expanded=!node.expanded && node.childCount>0;
	if(tree.flag==false)Tree_selectNode(nodeID);
	if(node.childCount>0)//folder
	{
		if(div)div.style.display=node.expanded?"block":"none";
		if(img)	img.src=Tree_imgSrc(node);
		var line=document.getElementById("Tree_line_"+nodeID);
		if(line)line.src=Tree_GetLineImg(node);
	}
	if(tree.callback_click(nodeID)==true &&tree.flag==false)//do action
		Tree_on_action(node.action);
	//------
	if(node.expanded && node.childCount>0 &&tree.flag==false)
		tree.callback_expanded(nodeID);
	if(!node.expanded && node.childCount>0 &&tree.flag==false)
		tree.callback_collapsed(nodeID);
}
//----------------------------
function Tree_buildTree(node,treeView)//init treeView from array
{
	Tree_treeView_array[treeView.id]=treeView;
	treeView.flag=true;
	var nLen = node.length-1;
	var index = 0;
	var count = 0;
	var nodeChild=null;
	var nodeParent=null;
	while( index <= nLen )
	{
		switch( node[index] ){
		case Tree_const_end:
			break;
		case Tree_const_begin_folder:
			count++;
			break;
		case Tree_const_end_folder:
			nodeParent=nodeParent.parent;
			count--;
			break;
		case Tree_const_file:
			var action = new Tree_action(node[index+5],node[index+6],node[index+7],node[index+8],treeView.id);
			nodeChild=new Tree_node(node[index+1],node[index+2],node[index+3],node[index+4],node[index+4],action);
			if(count==0) treeView.container.add(nodeChild,Tree_LAST);
			else nodeParent.add(nodeChild,Tree_LAST);
			break;
		case Tree_const_folder:
			var action = new Tree_action(node[index+6],node[index+7],node[index+8],node[index+9],treeView.id);
			nodeChild=new Tree_node(node[index+1],node[index+2],node[index+3],node[index+4],node[index+5],action);
			if(count==0) treeView.container.add(nodeChild,Tree_LAST);
			else nodeParent.add(nodeChild,Tree_LAST);
			nodeParent=nodeChild;
			break;
		}
		index ++;
	}
	treeView.flag=false;
	treeView.refresh();
}
//---------
function Tree_imgSrc(node)
{
	var tree=node.getTreeView();
	var src1=node.img1.length>0?node.img1:tree.folderImg1;
	var src2=node.img2.length>0?node.img2:tree.folderImg2;
	var src3=node.img1.length>0?node.img1:tree.fileImg;
	return node.childCount>0?(node.expanded?src2:src1):src3;
}
//-------------------------------------------
function Tree_img(node)
{
	var src=Tree_imgSrc(node);
	if( node.getTreeView().useImage && src.length > 0 )
		return ("<IMG style='cursor: pointer;cursor: hand;' SRC=\"" + src + "\" id='Tree_img_"+node.id+"'></IMG>");
	return "";
}
//-------------
function Tree_table(node)
{
	var tree=node.getTreeView();
	var html="<TABLE border=0 cellspacing=0  cellpadding=0 width='100%' ><TBODY><TR >";
	var level=node.level();
	var count=1;
	if(tree.showLine){
		while(count<level){
			var parent=node.getParentEx(count++);
			if( parent && parent.index==parent.parent.childCount-1)
				html+="<TD NAME=Tree_td_line_"+parent.id+" id=Tree_td_line_"+parent.id+"><IMG style='width:19px;height:20px;visibility:hidden'></TD>";
			else html+="<TD NAME=Tree_td_line_"+parent.id+" id=Tree_td_line_"+parent.id+"><IMG  src="+tree.lineFolder+"tree_I.gif></TD>";
		}
		html+="<TD oncontextmenu='return Tree_treeView_array["+tree.id+"].callback_rightClick("+node.id+
				")' onclick=Tree_clickNode("+node.id+") style='cursor: pointer;cursor: hand;'>"+
			"<IMG id=Tree_line_"+node.id+" src="+Tree_GetLineImg(node)+"></TD>";
	}
	else {
		while(count++<=level){
			html+="<TD width=\"" +tree.Indent+"px\" class=\"";
			if(node.childCount>0)//folder
				html += (node.selected?tree.folderClass3:tree.folderClass1)+"\">";
			else //file
				html += (node.selected?tree.fileClass3:tree.fileClass1)+"\">";
			html +="<IMG style='height:0px;visibility:hidden'></TD>";
		}
	}
	//html+="<TD oncontextmenu='return Tree_treeView_array["+tree.id+"].callback_rightClick("+node.id+
	//			")' onclick=Tree_clickNode("+node.id+")>"+Tree_img(node)+"</TD>";
	html+=Tree_td(node)+"</TR></TBODY></TABLE>";
	return html;
}
//-------------------------------------------
function Tree_td(node)
{
	var tree=node.getTreeView();
	var level=node.level();
	var ret = "<TD oncontextmenu='return Tree_treeView_array["+tree.id+"].callback_rightClick("+node.id+
				")' onclick=Tree_clickNode("+node.id+") style='cursor: pointer;cursor: hand;'  NOWRAP id='Tree_td_"+node.id+"' onmouseover=Tree_mouseover(this,"+node.id+
		") onmouseout=Tree_mouseout(this,"+node.id+") class=\"";
	if(node.childCount>0)//folder
		ret += (node.selected?tree.folderClass3:tree.folderClass1)+"\">";
	else //file
		ret += (node.selected?tree.fileClass3:tree.fileClass1)+"\">";
	return (ret+Tree_img(node)+Tree_formatText(node.text)+"</TD>");
}
//--------
function Tree_formatText(text)
{
	text=text.replace(/</g,"&lt;");
	text=text.replace(/>/g,"&gt;");
	text=text.replace(/ /g,"&nbsp;");
	return text.replace(/\"/g,"&quot;");
}
//-------------------------------------------
function Tree_mouseover(obj,nodeID)
{

	if(Tree_isIE && document.readyState!="complete") return;
	var node=Tree_node_array[nodeID];
	var level=node.level();
	var tree = node.getTreeView();
	if(node.childCount>0)//folder
		obj.className=tree.folderClass2;
	//del by zhaozhiguo BMSA-53-1选中菜单高亮 begin
	//else
	//	obj.className=tree.fileClass2;
	//del by zhaozhiguo BMSA-53-1选中菜单高亮 end
	if(tree.useStatus)
		window.status=tree.useTitleAsStatus==false?node.status:
			(node.status!=""?node.status:node.text);
	obj.title=(tree.useHint==false?"":
				(tree.useTitleAsHint==false?node.hint:
					(node.hint==""?node.text:node.hint)));
}
//-------------------------------------------
function Tree_mouseout(obj,nodeID)
{

	if(Tree_isIE && document.readyState!="complete") return;
	var node=Tree_node_array[nodeID];
	var level=node.level();
	var tree = node.getTreeView();
	if(tree.showSelect && nodeID==tree.selectID )
		obj.className = (node.childCount>0)?tree.folderClass3:tree.fileClass3;
	else if(node.childCount>0 )//folder
		obj.className=tree.folderClass1;
	//del by zhaozhiguo BMSA-53-1选中菜单高亮 begin
	//else
	//	obj.className=tree.fileClass1;
	//del by zhaozhiguo BMSA-53-1选中菜单高亮 end
}
//-------------------------------------------
function Tree_GetLineImg(node)
{
	var tree=node.getTreeView();
	if(tree.showLine==false||node.parent==null) return "";
	if(node.childCount>0){
		if(node.expanded)
			return tree.lineFolder+((node.index==node.parent.childCount-1)?"tree_Lminus.gif":"tree_Tminus.gif");
		else
			return tree.lineFolder+((node.index==node.parent.childCount-1)?"tree_Lplus.gif":"tree_Tplus.gif");
	}
	else return tree.lineFolder+((node.index==node.parent.childCount-1)?"tree_L.gif":"tree_T.gif");
}

//----------------------------
function Tree_AddNode(nodeid,newnode)//init treeView from array
{
	var nodeParent=Tree_node_array[nodeid];
	var tree=nodeParent.getTreeView();
	nodeParent.add(newnode,Tree_LAST);
	tree.flag=false;
	tree.refresh();
}
//------------------------------
function Tree_GetTree(treeView)
{
	var tree= Tree_treeView_array[treeView.id];
	return tree;
}

function Tree_SetTree(treeView)
{
	Tree_treeView_array[treeView.id]=treeView;
}

/**
*根据传入的id显示右键菜单
*/
function showMenu(num,nodeID)
{
    popMenu(100,num,nodeID);
    event.returnValue=false;
    event.cancelBubble=true;
    return false;
}


/**
*显示弹出菜单
*menuDiv:右键菜单的内容
*width:行显示的宽度
*rowControlString:行控制字符串，0表示不显示，1表示显示，如“101”，则表示第1、3行显示，第2行不显示
*/
function popMenu(width,rowControlString,nodeID)
{

    //创建弹出菜单
    var pop=window.createPopup();
    //设置弹出菜单的内容
    pop.document.body.innerHTML="<table border='1' width='100%' height='100%' bgcolor='#EDF2F6' style='border:thin; ' cellspacing='0'> <tr><td style='cursor:default;border:outset 1;font-family: 宋体; font-size: 13px;' align='center' onclick='parent.create("+nodeID+")'> 添加到收藏夹 </td></tr><tr><td style='cursor:default;border:outset 1;font-family: 宋体; font-size: 13px;' align='center' onclick='parent.del("+nodeID+")'>删除 </td> </tr></table>";
    var rowObjs=pop.document.body.all[0].rows;
    //获得弹出菜单的行数
    var rowCount=rowObjs.length;
    //循环设置每行的属性
    for(var i=0;i<rowObjs.length;i++)
    {
        //如果设置该行不显示，则行数减一
        var hide=rowControlString.charAt(i)!='1';
        if(hide){
            rowCount--;
        }
        //设置是否显示该行
        rowObjs[i].style.display=(hide)?"none":"";
        //设置鼠标滑入该行时的效果
        rowObjs[i].cells[0].onmouseover=function()
        {
            this.style.background="#818181";
            this.style.color="white";
        }
        //设置鼠标滑出该行时的效果
        rowObjs[i].cells[0].onmouseout=function(){
            this.style.background="#cccccc";
            this.style.color="black";
        }
    }
    //屏蔽菜单的菜单
    pop.document.oncontextmenu=function()
    {
            return false;
    }
    //选择右键菜单的一项后，菜单隐藏
    pop.document.onclick=function()
    {
            pop.hide();
    }
    //显示菜单
    pop.show(event.clientX-1,event.clientY,width,rowCount*25,document.body);
    return true;
}




function create(nodeID)
{
	var newnode = Tree_node_array[nodeID];
    var nodeParent = Tree_node_array[1];
	var tree=nodeParent.getTreeView();
	nodeParent.add(newnode,Tree_LAST);
	tree.flag=false;
	tree.refresh();
    PrivAction.InsertFolder(newnode.gethint(),function(data){result=data;});
}


function update(nodeID)
{
    alert("update "+nodeID);
}


function del(nodeID)
{
	var newnode = Tree_node_array[nodeID];
   var nodeParent = Tree_node_array[1];
	var tree=nodeParent.getTreeView();
	tree.del(nodeID)
	tree.flag=false;
	tree.refresh();
	 PrivAction.DeleteFolder(newnode.gethint(),function(data){result=data;});
}


function clickMenu()
{
    alert("you click a menu!");
}