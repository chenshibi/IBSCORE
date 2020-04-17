function initButton(buttonId)
{
	button = document.getElementById(buttonId);
	if(button==null)return;
	if(button.tagName==null||button.tagName.toLowerCase()!="button")return;
	_initButton(button);
}
function _initButton(button)
{
	button.onmouseover=function(){this.style.backgroundImage="url()";}
	button.onmouseout=function(){this.style.backgroundImage="";}
}
function initTable(tableId)
{
	table = document.getElementById(tableId);
	if(table==null)return;
	if(table.tagName==null||table.tagName.toLowerCase()!="table")return;
	_initTable(table);
}
function _initTable(table)
{
	if(table.bounddataset==null)
		return;
	if(table.tBodies[0]!=null&&table.tBodies[0].rows.length!=0)
	{
		var selectedRows = table.bounddataset.selectedRows;
		
		for(var i=0;i<table.tBodies[0].rows.length;i++)
		{
			var row = table.tBodies[0].rows[i];
			var selected = false;
			for(var j=0;j<selectedRows.length;j++)
			{
				if(selectedRows[j]==row.dataset_recordPos)
				{
					row.style.backgroundColor="lightblue";
					selected = true;
				}
			}
			if(!selected)
			{
				row.style.backgroundColor = "";
				row.onmouseover=function(){this.style.backgroundColor = "#E0E0E0";}
				row.onmouseout=function(){this.style.backgroundColor = "";}
				row.onclick=function(e){
					if(!(Sys.firefox&&e.ctrlKey||Sys.ie&&event.ctrlKey))
					{
						while(selectedRows.length>0)
							selectedRows.pop();
					}
					selectedRows.push(this.dataset_recordPos);
					this.style.backgroundColor = "lightblue";
					table.bounddataset.setCurrentPos(this.dataset_recordPos);
					table.bounddataset.fireUpdateView();
				}
			}
			else
			{
				row.onmouseover=null;
				row.onmouseout=null;
				row.onclick=function(e){
					if(selectedRows.length>1)
					{
						if(!(Sys.firefox&&e.ctrlKey||Sys.ie&&event.ctrlKey))
						{
							while(selectedRows.length>0)
								selectedRows.pop();
							selectedRows.push(this.dataset_recordPos);
							this.style.backgroundColor = "lightblue";
						}
						else
						{
							for(var j=0;j<selectedRows.length;j++)
							{
								if(selectedRows[j]==this.dataset_recordPos)
								{
									t = j;
								}
							}
							selectedRows.splice(t,1);
							this.style.backgroundColor = "#E0E0E0";
						}
					}
					else
					{
						selectedRows.pop();
						this.style.backgroundColor = "#E0E0E0";
					}
					this.style.backgroundColor = "#E0E0E0";
					table.bounddataset.setCurrentPos(this.dataset_recordPos);
					table.bounddataset.fireUpdateView();
				}
			}
		}
	}
	if(table.tHead!=null&&table.tHead.rows.length==1)
	{
		
		for(var i=0;i<table.tHead.rows[0].cells.length;i++)
		{
			var cell = table.tHead.rows[0].cells[i];
			table.tHead.rows[0].cells[i].cancelContextMenu=true;
			table.tHead.rows[0].cells[i].onclick=function(e){
				e = e || window.event;
				if(e.button!=2)
				{
					var dataset = this.parentNode.parentNode.parentNode.bounddataset;
					if(dataset==null)return;
					if(this.columnName==null)
					{
						this.columnName = this.innerHTML;
						this.columnOrder = "up";
					}
					switch(this.columnOrder)
					{
					case "up":
						this.innerHTML = this.columnName+"\u2193";
						this.columnOrder = "down";
						dataset.filterOrder(this.nodeName_,"asc");
						break;
					case "down":
						this.innerHTML = this.columnName+"\u2191";
						this.columnOrder = "normal";
						dataset.filterOrder(this.nodeName_,"desc");
						break;
					case "normal":
						this.innerHTML = this.columnName;
						this.columnOrder = "up";
						break;
					}
				}
			}
			table.tHead.rows[0].cells[i].popcustMenu=function(e){
				var table = this.parentNode.parentNode.parentNode;
				var dataset = table.bounddataset;
				if(dataset==null)return;
				var popMenu = getCustPopMenu();
				popMenu.style.top = e.clientY+"px";
				popMenu.style.left = e.clientX+"px";
				popMenu.onclick=null;
				popMenu.continueshow=false;
				popMenu.style.width = "";
				popMenu.style.display = "block";
				popMenu.style.backgroundColor = "#F0F0F0";
				var menuTable = document.createElement("table");
				while(popMenu.childNodes.length>0)
					popMenu.removeChild(popMenu.childNodes[0]);
				popMenu.appendChild(menuTable);
				var titleRow = menuTable.insertRow(0);
				var titleCell = titleRow.insertCell(0);
				titleCell.innerHTML = "\u65b0\u589e\u8fc7\u6ee4\u6761\u4ef6";
				var queryRow = menuTable.insertRow(1);
				var queryCell = queryRow.insertCell(0);
				var queryTextNode = document.createTextNode(this.innerHTML);
				var querySelection = document.createElement("select");
				var queryoptions = [["EQ","\u7b49\u4e8e"],["NE","\u4e0d\u7b49\u4e8e"],["GT","\u5927\u4e8e"],["GE","\u5927\u4e8e\u7b49\u4e8e"],["LT","\u5c0f\u4e8e"],["LE","\u5c0f\u4e8e\u7b49\u4e8e"]];
				for(var i=0;i<queryoptions.length;i++){
					var queryOption = document.createElement("option");
					queryOption.text=queryoptions[i][1];
					queryOption.value=queryoptions[i][0];
					querySelection.options.add(queryOption);
				}
				queryCell.appendChild(queryTextNode);
				queryCell.appendChild(querySelection);
				var valueRow = menuTable.insertRow(2);
				var valueCell = valueRow.insertCell(0);
				var valueInput = document.createElement("input");
				valueCell.appendChild(valueInput);
				var buttonRow = menuTable.insertRow(3);
				var buttonCell = buttonRow.insertCell(0);
				var button = document.createElement("button");
				button.innerHTML="\u8fc7\u6ee4";
				buttonCell.appendChild(button);
				var nodeName=this.nodeName_
				attachEvent(button,"click",function (){
					dataset.filter(nodeName,querySelection.value,valueInput.value);
					popMenu.style.display = "none";
				},button);
				
				
//				popMenu.innerHTML="<table><tr><td>\u65b0\u589e\u8fc7\u6ee4\u6761\u4ef6</td></tr>"+
//				"<tr><td>\u6b64\u5217<select><option>\u5927\u4e8e</option><option>\u5927\u4e8e</option></select></td></tr>"+
//				"<tr><td><input type=\"text\" value=\"\"></td></tr>"+
//				"<tr><td><input type=\"button\" value=\"\u8fc7\u6ee4\"></td></tr>"+
//				"</table>";
			}
		}
	}
}

function select_onfocus(){
	var popMenu = getCustPopMenu();
	this.refMenu = popMenu;
	while(popMenu.childNodes.length>0)
		popMenu.removeChild(popMenu.childNodes[0]);
	var dataset = this.bounddataset;
	var fieldName = this.dataset_fieldName;
	var table = document.createElement("table");
	var select = this;
	for(var i=0;i<this.bindEnum.length;i++)
	{
		var row=table.insertRow(i);
		var cell=row.insertCell(0);
		cell.innerHTML=this.bindEnum[i].v;
		row.keyValue=this.bindEnum[i].k;
		row.onclick=function(){dataset.setValue(fieldName,this.keyValue);popMenu.continueshow=false;popMenu.style.display="none";fireEvent(select,"change");}
		row.onmouseover=function(){this.style.backgroundColor="lightblue";popMenu.continueshow=true;};
		row.onmouseout=function(){this.style.backgroundColor="";popMenu.continueshow=false;};
	}
	popMenu.appendChild(table);
	table.width="100%";
	popMenu.style.display = "block";
	popMenu.style.backgroundColor = "#FFFFFF";
	popMenu.style.border = "1px solid";
	var pos = calPos(this);
	if(document.body.scrollTop+document.body.clientHeight>pos.y + this.offsetHeight + popMenu.clientHeight||document.body.clientHeight<this.offsetHeight + popMenu.clientHeight)
	{
		popMenu.style.top = pos.y + this.offsetHeight + "px";
	}
	else
	{
		popMenu.style.top = pos.y - popMenu.clientHeight + "px";
	}
	popMenu.style.width = this.offsetWidth + "px";
	popMenu.style.left = pos.x + "px";
	popMenu.continueshow = true;
}

function ____initSelect(inputId,divId,hiddenId)
{
	var inputBox = document.getElementById(inputId);
	var div = document.getElementById(divId);
	var hiddenBox = document.getElementById(hiddenId)
	var table = getFirstChildElement(div);
	this.mouseover=false;
	inputBox.onfocus = function(){
		if(div.mouseover)
		{
			div.style.backgroundColor="red";
			return;
		}
		div.style.display = "block";
		var pos = calPos(inputBox);
		if(document.body.scrollTop+document.body.clientHeight>pos.y + inputBox.offsetHeight + div.clientHeight||document.body.clientHeight<inputBox.offsetHeight + div.clientHeight)
		{
			div.style.top = pos.y + inputBox.offsetHeight + "px";
		}
		else
		{
			div.style.top = pos.y - div.clientHeight + "px";
		}
		div.style.width = inputBox.offsetWidth + "px";
		div.style.left = pos.x + "px";
	};
	inputBox.onclick = inputBox.onfocus;
	inputBox.onblur = function(){
		if(div.mouseover==true)return;
		div.style.display = "none";
	};
	div.onmouseover=function(){
		this.mouseover = true;
	}
	div.onmouseout=function(){
		this.mouseover = false;
	}
	inputBox.onkeydown=function(e){
		var keynum;
		if(window.event) // IE
		{
			keynum = window.event.keyCode;
		}
		else if(e.which) // Netscape/Firefox/Opera
		{
			keynum = e.which;
		}
		
		if(keynum==38||keynum==40)
		{
			table.oldLine = table.highLight;
			if(keynum==38)
			{
				div.style.display="block";
				if(table.oldLine==null)
					table.highLight=table.rows.length-1;
				else
					table.highLight=(table.oldLine+table.rows.length-1)%table.rows.length;
			}
			if(keynum==40)
			{
				div.style.display="block";
				if(table.oldLine==null)
					table.highLight=0;
				else
					table.highLight=(table.oldLine+1)%table.rows.length;
			}
			if(table.oldLine!=null)table.rows[table.oldLine].cells[0].style.backgroundColor="";
			table.rows[table.highLight].cells[0].style.backgroundColor="lightblue";
		}
		if(keynum==13)
		{
			inputBox.value = table.rows[table.highLight].cells[0].innerHTML;
			div.style.display = "none";
			hiddenBox.onblur();
			if(inputBox.onchange)
			inputBox.onchange();
		}
	}
	for(var i=0;i<table.rows.length;i++){
		table.rows[i].style.backgroundColor="white";
		table.rows[i].onclick=function(){
			inputBox.value = this.cells[0].innerHTML;
			hiddenBox.value = this.cells[0]._key;
			inputBox.focus();
			div.style.display = "none";
			hiddenBox.onblur();
			if(inputBox.onchange)
			inputBox.onchange();
		}
		table.rows[i].onmouseover=function(){
			if(table.highLight!=null)table.rows[table.highLight].cells[0].style.backgroundColor="white";
			this.cells[0].style.backgroundColor="lightblue";
		}
		table.rows[i].onmouseout=function(){
			this.cells[0].style.backgroundColor="white";
		}
	} 
}