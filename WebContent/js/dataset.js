function Dataset(queryID,column){
	this.url = "/BillSys/AdapterHandleServlet?ActionId="+encodeURI(queryID);
	this.queryID = queryID;
	this.column = column;
	this.columnIndexTable = new Map();
	for(var i=0;i<column.length;i++)
	{
		this.columnIndexTable.put(column[i].columnNodeName, i);
	}
	this.order = new Array();
	this.recordList = new Array();
	this.bindElements = new Array();
	this.pageElements = new Array();
	this.lastQueryWhere = null;
	this.extraData = new Map();

	this.selectedRows = new Array();
	this.currentPos = null;

	this._updateViewEnabled = true;

	this.beginRow = 0;
	this.pageSize = 20;
	this.totalRows = 0;

	this.errorCode = 0;
	this.errorDes = "";
	
	this.total = 0;
}

Dataset.prototype.queryData = _dataset_queryData;
Dataset.prototype.queryLastPage = _dataset_queryLastPage;
Dataset.prototype.queryNextPage = _dataset_queryNextPage;
Dataset.prototype.bindPageElement = _dataset_bindPageElement;
Dataset.prototype.refreshPageElement = _dataset_refreshPageElement;
//Dataset.prototype.queryColumn = _dataset_queryColumn;
Dataset.prototype.bind = _dataset_bindElement;
Dataset.prototype.bindSelect = _dataset_bindSelect;
Dataset.prototype.fireUpdateView = _dataset_fireUpdateView;
Dataset.prototype.fireInitView = _dataset_fireInitView;
Dataset.prototype.fillTable = _dataset_fillTable;
Dataset.prototype.updateTable = _dataset_updateTable;
Dataset.prototype.fillInput = _dataset_fillInput;
Dataset.prototype.fillSelectInput = _dataset_fillSelectInput;
Dataset.prototype.setCurrentPos = _dataset_setCurrentPos;
Dataset.prototype.getValue = _dataset_getValue;
Dataset.prototype.getRawValue = _dataset_getRawValue;
Dataset.prototype.setValue = _dataset_setValue;
Dataset.prototype.setOrder = _dataset_setOrder;
Dataset.prototype.preInsert = _dataset_preInsert;
Dataset.prototype.insert = _dataset_insert;
Dataset.prototype.update = _dataset_update;
Dataset.prototype.sendCEleAndKey = _dataset_sendCustomerElementAndKey;
Dataset.prototype.genKeyWhere = _dataset_genKeyWhere;
Dataset.prototype.enableUpdateView = _dataset_enableUpdateView;
Dataset.prototype.disableUpdateView = _dataset_disableUpdateView;
//Dataset.prototype.getRowsFromDataset = _dataset_getRowsFromDataset;
Dataset.prototype.validate = _dataset_validate;
Dataset.prototype.filter = _dataset_filter;
Dataset.prototype.filterOrder = _dataset_order;
//Dataset.prototype.checkValue =_dataset_checkValue;
//function _dataset_checkValue(dataset,fieldName,value)
//{
//	for(var i=0;i<dataset.column.length;i++)
//	{
//		if(fieldName==dataset.column[i].columnNodeName)
//		{
//			alert(dataset.column[i].columnType.check(value));
//		}
//	}
//}

function WhereQuery(type)
{
	this.fieldType = type;
	this.fieldList = new Array();
}
WhereQuery.prototype.pushField = _whereQuery_pushField;
WhereQuery.prototype.genNodeInDoc = _whereQuery_genNodeInDoc;
WhereQuery.prototype.replaceField = _whereQuery_replaceField;

function Record(dataset)
{
	this.dataset = dataset;
	this.data = new Object();
	this.newData = new Object();
	this.checkPass = new Object();
	for(var i=0;i<dataset.column.length;i++)
	{
		this.checkPass[dataset.column[i].columnNodeName]=true;
	}
	this.updated = false;
	this.preInsert = false;
}
Record.prototype.getValue = _record_getValue;
Record.prototype.getRawValue = _record_getRawValue;
Record.prototype.setValue = _record_setValue;
Record.prototype.initValue = _record_initValue;

function CustomData(elementName)
{
	this.elementName = elementName;
	this.fieldName = new Array();
	this.data = new Object();
}
CustomData.prototype.setValue = _customData_setValue;
CustomData.prototype.getValue = _customData_getValue;


function createXmlHttp(){
	if(/*Sys.ie==7||*/Sys.firefox!=null)
	{
		return new XMLHttpRequest();
	}
	else
	{
		var xmlHttp;
		var xmlhttpObj = ["Msxml2.XMLHTTP.5.0","Msxml2.XMLHTTP.4.0","Msxml2.XMLHTTP.3.0","Msxml2.XMLHTTP","Microsoft.XMLHTTP"];
		for(i=0;i<xmlhttpObj.length;i++)
        {
        	try{
            	xmlHttp = new ActiveXObject(xmlhttpObj[i]);
            }catch(e){}
            if(xmlHttp)
            {
                break;
            }
        }
		if(!xmlHttp)alert("create XMLHTTP failed!!");
		return xmlHttp;
	}
}

function ajaxDataset(query,dataset,initView,customFun,args)
{
	var xmlHttp = createXmlHttp();
	var arg = args;
	xmlHttp.onreadystatechange=function(){
		//alert(xmlHttp.readyState);
		if (xmlHttp.readyState == 4 ){
			if(xmlHttp.status == 200 ){
				xmlParser(xmlHttp.responseText,dataset);
				if(dataset.errorCode<0)
				{
					alert(dataset.errorDes);
				}
				if(initView)
				{
					dataset.fireInitView();
				}
				dataset.refreshPageElement();
				if(typeof(customFun)=="function")
				{
					customFun.apply(null,args);
				}
			}
			else{
				alert(xmlHttp.responseText);
			}
		}
	}
	xmlHttp.open("POST", dataset.url ,true);
	//xmlHttp.setRequestHeader("Content-Length",query.length);
	xmlHttp.setRequestHeader("Connection", "close");
	xmlHttp.setRequestHeader("Content-type","application/x-www-form-urlencoded;charset=UTF-8");
    xmlHttp.send(query);
}

function _dataset_queryData(where_query,customFun){

	var doc;
    if(window.ActiveXObject) {
        doc = new ActiveXObject("MSXML2.DOMDocument");
    }else if(window.Document) {
        doc = document.implementation.createDocument("","",null);
		doc.async="false";
    }
    var query = doc.createElement("query");
    query.setAttribute("id",this.queryID);
    query.setAttribute("beginRow",this.beginRow);
    query.setAttribute("pageSize",this.pageSize);

	this.lastQueryWhere = where_query;

    if(where_query!=null)
    {
    	var where = doc.createElement("where");
    	where.appendChild(where_query.genNodeInDoc(doc));
    	query.appendChild(where);
    }

    if(this.order!=null&&this.order.length!=null&&this.order.length>0)
   	{
   		var order = doc.createElement("order");
   		for(var i=0;i<this.order.length;i++)
   		{
   			var field = doc.createElement("field");
   			field.setAttribute("name",this.order[i].columnNodeName);
   			field.setAttribute("order",(this.order[i].order=="up")?"asc":(this.order[i].order=="down"?"desc":""));
   			if(field.getAttribute("order")!="")
   			{
   				order.appendChild(field);
   			}
   		}
   		query.appendChild(order);
   	}
    doc.appendChild(query);
    var text = "";
    if(window.ActiveXObject)
    {
    	text = doc.xml;
    }else if(window.XMLSerializer)
    {
    	text = (new XMLSerializer()).serializeToString(doc);
    }
    var query = "data="+encodeURI(text);

    var args = Array.prototype.slice.call(arguments,2);
    ajaxDataset(query,this,true,customFun,args);
/*
    var xmlHttp = createXmlHttp();
    var dataset = this;
    xmlHttp.onreadystatechange=
	xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded;charset=UTF-8");
	xmlHttp.setRequestHeader("Content-Length",query.length);
	xmlHttp.setRequestHeader("Connection", "close");
	xmlHttp.open("POST", this.url ,false);
    xmlHttp.send(query);
*/
}

function _dataset_queryLastPage()
{
	this.beginRow-=this.pageSize;
	if(this.beginRow<0)
		this.beginRow=0;
	this.queryData(this.lastQueryWhere);
}
function _dataset_queryNextPage()
{
	if(this.beginRow+this.pageSize<this.totalRows)
		this.beginRow+=this.pageSize;
	this.queryData(this.lastQueryWhere);
}
function _dataset_bindPageElement(pageElement,style)
{
	this.pageElements.push({pageElement:pageElement,style:style});
}
function _dataset_refreshPageElement()
{
	for(var i=0;i<this.pageElements.length;i++)
	{
		var div = $doc(this.pageElements[i].pageElement);
		var showText = "\u5171 "+this.totalRows+" \u6761\uff0c";
		showText += "\u5f53\u524d\u663e\u793a\u7b2c "+(this.beginRow+1)+" \u6761\u81f3\u7b2c ";
		showText += Math.min(this.totalRows,this.beginRow+this.pageSize);
		showText += " \u6761";
		div.innerHTML = showText;
	}
}

function xmlParser(source,dataset){
	var doc;
    if(window.ActiveXObject) {
        doc = new ActiveXObject("MSXML2.DOMDocument");
        doc.loadXML(source);
    }else if(window.DOMParser) {
        doc = (new DOMParser()).parseFromString(source,"text/xml");
    }
    var dataNodes = evaluateXPath(doc,"data",doc);
    if(dataNodes.length!=0)
    {
	    var totalRows = dataNodes.item(0).getAttribute("totalRows");
	    var beginRow = dataNodes.item(0).getAttribute("beginRow");
	    var pageSize = dataNodes.item(0).getAttribute("pageSize");
	    dataset.totalRows = parseInt(totalRows);
	    dataset.beginRow = parseInt(beginRow);
	    dataset.pageSize = parseInt(pageSize);
	    if(isNaN(dataset.totalRows))
	    {dataset.totalRows=0;}
	    if(isNaN(dataset.beginRow))
	    {dataset.beginRow=0;}
	    if(isNaN(dataset.pageSize))
	    {dataset.pageSize=20;}

	    var columnNodes = evaluateXPath(doc,"data/columns/column",doc);
	    if(columnNodes.length>0)
	    {
	    	dataset.column = new Array();
	    }
	    for(var i=0;i<columnNodes.length;i++)
	    {
	    	var columnNode = columnNodes.item(i);
	    	var column = {
	    			columnName:		columnNode.getAttribute("name"),
	    			columnAlign:	columnNode.getAttribute("align"),
	    			columnType:		columnNode.getAttribute("type"),
	    			cellAlign:		columnNode.getAttribute("cellAlign"),
	    			columnNodeName:	columnNode.getAttribute("nodeName"),
	    			width:			columnNode.getAttribute("width"),
	    			show:			columnNode.getAttribute("show")=="true",
	    			isKey:			columnNode.getAttribute("isKey")=="true"||
	    							columnNode.getAttribute("isKey")=="yes"||
	    							columnNode.getAttribute("isKey")=="1"
	    				};
	    	dataset.column.push(column);
	    }
	    var recordNodes = evaluateXPath(doc,"data/records/record",doc);
	    dataset.recordList = new Array();
	    for(var i=0;i<recordNodes.length;i++)
	    {
	    	var columnNode = recordNodes.item(i);
	    	var _record = new Record(dataset);
	    	for(var j=0;j<dataset.column.length;j++)
	    	{
	    		var field = evaluateXPath(doc,"field[@name='"+dataset.column[j].columnNodeName+"']",columnNode);
	    		if(field.item(0).firstChild==null)
	    		{
	    			_record.initValue(dataset.column[j].columnNodeName,
	    				"",
	    				dataset.column[j].columnType);
	    		}
	    		else
	    		{
	    			_record.initValue(dataset.column[j].columnNodeName,
	    					field.item(0).firstChild.nodeValue,
	    					dataset.column[j].columnType);
	    		}
	    	}
	    	dataset.recordList.push(_record);
	    }
	    dataset.currentPos = null;
	    if(recordNodes.length>0)
	    	dataset.currentPos=0;
	    dataset.selectedRows.splice(0,dataset.selectedRows.length);
    }
    dataset.extraData = new Map();
    var extraNodes = evaluateXPath(doc,"data/extra/value",doc);
    for(var i=0;i<extraNodes.length;i++)
    {
    	dataset.extraData.put(extraNodes.item(i).getAttribute("key"),extraNodes.item(i).firstChild.nodeValue);
    }

   	dataset.errorCode = 0;
   	dataset.errorDes = "";
   	var errorNodes = evaluateXPath(doc,"data/error",doc);
    if(errorNodes.length!=0)
    {
    	var errorCodeNodes = evaluateXPath(doc,"error_code",errorNodes.item(0));
    	if(errorCodeNodes.length!=0)
    	{
    		dataset.errorCode = parseInt(errorCodeNodes.item(0).firstChild.nodeValue);
    	}
    	var errorDecriptionNodes = evaluateXPath(doc,"error_des",errorNodes.item(0));
    	if(errorDecriptionNodes.length!=0)
    	{
    		dataset.errorDes = errorDecriptionNodes.item(0).firstChild.nodeValue;
    	}
    }
}


function _dataset_bindElement(ElementId,fieldName)
{
	var element = $doc(ElementId);
	for(var i=0;i<this.bindElements.length;i++)
	{
		if(this.bindElements[i]==element)return;
	}
	element.dataset_fieldName = fieldName;
	element.bounddataset = this;
	if(element.tagName.toLowerCase()=="input")
	{
		attachEvent(element,"blur",function (){
			this.bounddataset.setValue(this.dataset_fieldName, this.value);
		},element);
	}
	this.bindElements.push(element);
}

function _dataset_bindSelect(ElementId,fieldName)
{
	var element = $doc(ElementId);
	for(var i=0;i<this.bindElements.length;i++)
	{
		if(this.bindElements[i]==element)return;
	}
	var columnType = this.column[this.columnIndexTable.get(fieldName)].columnType;
	if(columnType.type!="Enum")return;
	element.dataset_fieldName = fieldName;
	element.bounddataset = this;
	element.bindEnum = columnType.data;
//	attachEvent(element,"blur",function (){
//		this.bounddataset.setValue(this.dataset_fieldName, this.value);
//		//getCustPopMenu().style.display="none";
//		//getCustPopMenu().style.display = "none";
//	},element);
	attachEvent(element,"focus",select_onfocus,element);
	this.bindElements.push(element);
}

function _dataset_fireUpdateView(fieldName)
{
	for(var i=0;i<this.bindElements.length;i++)
	{
		var element = this.bindElements[i];
		switch(element.tagName.toLowerCase())
		{
		case "table":
			this.updateTable(element);
			_initTable(element);
			break;
		case "input":
			if(fieldName!=null&&fieldName!=element.dataset_fieldName)continue;
			if(this.currentPos==null)continue;
			if(element.type=="hidden")
			{
				this.fillSelectInput(element);
				break;
			}
			this.fillInput(element);
			break;
		}
	}
}

function _dataset_fireInitView(){
	for(var i=0;i<this.bindElements.length;i++)
	{
		var element = this.bindElements[i];
		if(element==null)continue;
		switch(element.tagName.toLowerCase())
		{
		case "table":
			this.fillTable(element);
			_initTable(element);
			break;
		case "input":
			if(this.currentPos==null)break;
			if(element.type=="hidden")
			{
				this.fillSelectInput(element);
				break;
			}
			this.fillInput(element);
			break;
		}
	}
}

function _dataset_fillSelectInput(element)
{
	var refInput =
		Sys.ie?element.refInput:
		(Sys.firefox?element.getAttribute("refInput"):null);
	var refDiv =
		Sys.ie?element.refDiv:
		(Sys.firefox?element.getAttribute("refDiv"):null);
	if(refInput!=null&&refDiv!=null)
	{
		var input = $doc(refInput);
		var table = getFirstChildElement($doc(refDiv));
		var value = "";
		for(var j=0;j<table.rows.length;j++)
		{
			if(table.rows[j].cells[0]._key == this.getValue(element.dataset_fieldName))
			{
				value = table.rows[j].cells[0].innerHTML;
				break;
			}
		}
		input.value=this.getValue(element.dataset_fieldName);
	}
}

function _dataset_fillTable(table)
{
	table.bounddataset = this;
	var tHead = table.tHead;

	if(tHead==null)
	{
		tHead = table.ownerDocument.createElement("thead");
		table.appendChild(tHead);
	}

	while(tHead.rows.length>0)
		tHead.deleteRow(0);
	tHead.insertRow(0);
	tHead.className="datatable";
	for(var i=0;i<this.column.length;i++)
	{
		if(this.column[i].show)
		{
			var cell = tHead.rows[0].insertCell(tHead.rows[0].cells.length);
			cell.nodeName_=this.column[i].columnNodeName;
			cell.innerHTML=this.column[i].columnName;
			cell.align=this.column[i].columnAlign;
			if(this.column[i].width!=null)
			{
				cell.style.width=this.column[i].width;
			}
		}
	}
	var tBody = table.tBodies[0];
	if(tBody==null)
	{
		tBody = table.ownerDocument.createElement("tbody");
		table.appendChild(tBody);
	}
	tBody.className="datatable";
	while(tBody.rows.length>0)
		tBody.deleteRow(0);
	for(var i=0;i<this.recordList.length;i++)
	{
		var row = tBody.insertRow(i);
		for(var j=0;j<this.column.length;j++)
		{
			if(this.column[j].show)
			{
				var cell = row.insertCell(tBody.rows[i].cells.length);
				cell.innerHTML = this.recordList[i].getValue(this.column[j].columnNodeName);
				cell.align = this.column[j].cellAlign;
			}
		}
		tBody.rows[i].dataset_recordPos=i;
	}
	while(this.recordList.length<tBody.rows.length)
		tBody.deleteRow(this.recordList.length);
}

function _dataset_updateTable(table)
{
	if(table.bounddataset==this){
		var tBody = table.tBodies[0];
		var rowOffset = 0;
		for(var i=0;i<this.recordList.length;i++)
		{
			if(tBody.rows[rowOffset]==null)
			{
				tBody.insertRow(rowOffset);
				for(var j=0;j<this.column.length;j++){
					if(this.column[j].show){
						tBody.rows[rowOffset].insertCell(tBody.rows[rowOffset].cells.length);
					}
				}
			}
			var t = 0;
			for(var j=0;j<this.column.length;j++)
			{
				if(this.column[j].show)
				{
					tBody.rows[rowOffset].cells[t].innerHTML = this.recordList[i].getValue(this.column[j].columnNodeName);
					tBody.rows[rowOffset].cells[t].align = this.column[j].cellAlign;
					t++;
				}
			}
			tBody.rows[rowOffset].dataset_recordPos=i;
			rowOffset++;
		}
		while(rowOffset<tBody.rows.length)
			tBody.deleteRow(rowOffset);
	}
}

function _dataset_fillInput(input)
{
	if(this.currentPos==null)return;
	if(!this.recordList[this.currentPos].checkPass[input.dataset_fieldName])
	{
		input.style.backgroundColor="red";
	}
	else
	{
		input.style.backgroundColor="";
		input.value = this.getValue(input.dataset_fieldName);
	}
}

function _dataset_setCurrentPos(pos)
{
	this.currentPos = pos;
	this.fireUpdateView();
}

function _record_getValue(field){
	if(this.checkPass[field])
	{
		return this.dataset.column[this.dataset.columnIndexTable.get(field)].columnType.toDisplay(this.newData[field]);
	}
	else
	{
		return this.newData[field];
	}
}

function _record_getRawValue(field){
	if(this.newData[field]!=null)
		return this.newData[field];
	else
		return null;
}

function _record_setValue(field,value){
	this.updated = false;
	for(var i=0;i<this.dataset.column.length;i++)
	{
		var nodeName = this.dataset.column[i].columnNodeName;
		if(field==nodeName)
		{
			this.checkPass[nodeName] = this.dataset.column[i].columnType.check(value);
			if(this.checkPass[nodeName])
			{
				this.newData[field]=this.dataset.column[i].columnType.toRaw(value,this.newData[field]);
			}
			else
			{
				this.newData[field]=value;
			}
		}
		if(!this.updated&&this.newData[nodeName]!=null&&this.data[nodeName]!=this.newData[nodeName])
		{
			this.updated = true;
		}
	}
}

function _record_initValue(nodeName,value,type)
{
	this.data[nodeName]=value;
	this.newData[nodeName]=value;
//	var eva = "new "+type+"(\""+value+"\")";
//	var x = 0;
//	try{
//
//	this.data[nodeName]=eval(eva);
//	x=1;
//	this.newData[nodeName]=eval(eva);
//	}
//	catch(e)
//	{
//		alert(eva+x);
//	}
}


function _dataset_getValue(field){
	if(this.currentPos==null)return;
	return this.recordList[this.currentPos].getValue(field);
}

function _dataset_getRawValue(field){
	if(this.currentPos==null)return;
	return this.recordList[this.currentPos].getRawValue(field);
}

function _dataset_setValue(field,value){
	if(this.currentPos==null)return;
	this.recordList[this.currentPos].setValue(field,value);
	if(this._updateViewEnabled)
	{
		this.fireUpdateView(field);
	}
}

function _dataset_setOrder(nodeName,orderType)
{
	var orderItem = null;
	for(var i=0;i<this.order.length;i++)
	{
		if(this.order[i].columnNodeName==nodeName){
			this.order.splice(i,1);
			break;
		}
	}
	switch(orderType)
	{
	case "down":
		orderItem = {columnNodeName:nodeName,order:"down"};
		break;
	case "up":
		orderItem = {columnNodeName:nodeName,order:"up"};
		break;
	default:
	}
	if(orderItem!=null)
	{
		this.order.unshift(orderItem);
	}
}

function _whereQuery_pushField(nodeName,type,value)
{
	if(nodeName instanceof WhereQuery)
	{
		this.fieldList.push(nodeName);
	}
	else
	{
		var field = {nodeName:nodeName,type:type,value:value};
		this.fieldList.push(field);
	}
}

function _whereQuery_genNodeInDoc(doc)
{
	var package = null;

	if(this.fieldType=="or")
	{
		package = doc.createElement("or");
	}
	else
	{
		package = doc.createElement("and");
	}
	for(var i=0;i<this.fieldList.length;i++)
	{
		var element = null;
		if(this.fieldList[i] instanceof WhereQuery)
		{
			element = this.fieldList[i].genNodeInDoc(doc);
		}
		else
		{
			element = doc.createElement("field");
			element.setAttribute("name",this.fieldList[i].nodeName);
			element.setAttribute(this.fieldList[i].type,this.fieldList[i].value);
		}
		package.appendChild(element);
	}
	return package;
}

function _whereQuery_replaceField(oldNodeName,newNodeName)
{
	for(var i=0;i<this.fieldList.length;i++)
	{
		if(this.fieldList[i] instanceof WhereQuery)
		{
			this.fieldList[i].replaceField(oldNodeName,newNodeName);
		}
		else
		{
			if(this.fieldList[i].nodeName == oldNodeName)
				this.fieldList[i].nodeName = newNodeName;
		}
	}
}

function _customData_setValue(fieldName,value)
{
	if(this.data[fieldName]===undefined)
	{
		this.fieldName.push(fieldName);
	}
	this.data[fieldName] = value;
}

function _customData_getValue(fieldName)
{
	return data[fieldName];
}


function _dataset_insert(customFun)
{
    var doc;
    if(window.ActiveXObject) {
        doc = new ActiveXObject("MSXML2.DOMDocument");
    }else if(window.Document) {
        doc = document.implementation.createDocument("","",null);
		doc.async="false";
    }
    var insert = doc.createElement("insert");
    insert.setAttribute("id",this.queryID);
    doc.appendChild(insert);
    for(var i=0;i<this.recordList.length;i++)
    {
    	if(this.recordList[i].preInsert)
    	{
    		var row = doc.createElement("row");
			for(var j=0;j<this.column.length;j++)
			{
				var field = doc.createElement("field");
				field.setAttribute("name",this.column[j].columnNodeName);
				var value = this.recordList[i].newData[this.column[j].columnNodeName];
				field.setAttribute("value",value);
				row.appendChild(field);
			}
			insert.appendChild(row);
    	}
    }




	var text = "";
    if(window.ActiveXObject)
    {
    	text = doc.xml;
    }else if(window.XMLSerializer)
    {
    	text = (new XMLSerializer()).serializeToString(doc);
    }
	var query = "data="+encodeURI(text);
	//alert(text);
	var args = Array.prototype.slice.call(arguments,1)
	ajaxDataset(query,this,false,customFun,args);

}

function _dataset_update(customFun)
{
	if(!this.validate())return false;
    var doc;
    if(window.ActiveXObject) {
        doc = new ActiveXObject("MSXML2.DOMDocument");
    }else if(window.Document) {
        doc = document.implementation.createDocument("","",null);
		doc.async="false";
    }
    var update = doc.createElement("update");
    update.setAttribute("id",this.queryID);
    doc.appendChild(update);

    for(var i=0;i<this.recordList.length;i++)
    {
    	if(this.recordList[i].updated&&!this.recordList[i].preInsert)
    	{
	    	var row = doc.createElement("row");
	    	var newdata = doc.createElement("newdata");
	    	for(var j=0;j<this.column.length;j++)
	    	{
	    		var nodeName = this.column[j].columnNodeName;
    			var field = doc.createElement("field");
    			field.setAttribute("name",nodeName);
    			field.setAttribute("value",this.recordList[i].newData[nodeName]);
    			newdata.appendChild(field);
	    	}
	    	row.appendChild(newdata);
	    	var where = doc.createElement("where");
	    	for(var j=0;j<this.column.length;j++)
	    	{
	    		var nodeName = this.column[j].columnNodeName;
	    		if(this.column[j].isKey)
	    		{
	    			var field = doc.createElement("field");
	    			field.setAttribute("name",nodeName);
	    			field.setAttribute("value",this.recordList[i].data[nodeName]);
	    			where.appendChild(field);
	    		}
	    	}
	    	row.appendChild(where);
	    	update.appendChild(row);
    	}
    }
	var text = "";
    if(window.ActiveXObject)
    {
    	text = doc.xml;
    }else if(window.XMLSerializer)
    {
    	text = (new XMLSerializer()).serializeToString(doc);
    }
	var query = "data="+encodeURI(text);
	var args = Array.prototype.slice.call(arguments,1);
	ajaxDataset(query,this,false,customFun,args);
}

function _dataset_sendCustomerElementAndKey(elementName,customFun)
{
	if(this.currentPos==null)return;
	var doc;
    if(window.ActiveXObject) {
        doc = new ActiveXObject("MSXML2.DOMDocument");
    }else if(window.Document) {
        doc = document.implementation.createDocument("","",null);
		doc.async="false";
    }
    var element = null
    if(elementName instanceof CustomData)
    {
    	element = doc.createElement(elementName.elementName);
    }
    else
    {
    	element = doc.createElement(elementName);
    }
    element.setAttribute("id",this.queryID);
    doc.appendChild(element);
    for(var i=0;i<this.selectedRows.length;i++)
    {
    	var row = doc.createElement("row");

    	var newdata = doc.createElement("data");
    	for(var j=0;j<this.column.length;j++)
    	{
    		var nodeName = this.column[j].columnNodeName;
   			var field = doc.createElement("field");
   			field.setAttribute("name",nodeName);
   			field.setAttribute("value",this.recordList[this.selectedRows[i]].newData[nodeName]);
   			newdata.appendChild(field);
    	}
    	row.appendChild(newdata);


    	var where = doc.createElement("where");
    	for(var j=0;j<this.column.length;j++)
	   	{
	   		var nodeName = this.column[j].columnNodeName;
	   		if(this.column[j].isKey)
	   		{
	   			var field = doc.createElement("field");
	   			field.setAttribute("name",nodeName);
	   			//alert(this.selectedRows[i]);
	   			field.setAttribute("value",this.recordList[this.selectedRows[i]].data[nodeName]);
	   			where.appendChild(field);
	   		}
	   	}
	    row.appendChild(where);
	    element.appendChild(row);
    }
    if(elementName instanceof CustomData)
    {
    	var extra = doc.createElement("extraData");
    	for(var i=0;i<elementName.fieldName.length;i++)
    	{
    		var pair = doc.createElement("pair");
    		var key = doc.createElement("key");
    		var value = doc.createElement("value");
    		key.appendChild(doc.createTextNode(elementName.fieldName[i]));
    		value.appendChild(doc.createTextNode(elementName.data[elementName.fieldName[i]]));
    		pair.appendChild(key);
    		pair.appendChild(value);
    		extra.appendChild(pair);
    	}
    	if(elementName.fieldName.length>0)
    	{
    		element.appendChild(extra);
    	}
    }

    if(window.ActiveXObject)
    {
    	text = doc.xml;
    }else if(window.XMLSerializer)
    {
    	text = (new XMLSerializer()).serializeToString(doc);
    }
	var query = "data="+encodeURI(text);
	//alert(text);
	var args = Array.prototype.slice.call(arguments,2);
	ajaxDataset(query,this,true,customFun,args);
}

function _dataset_preInsert()
{
	var _record = new Record(this);
	_record.preInsert = true;
   	for(var j=0;j<this.column.length;j++)
   	{
   		_record.initValue(this.column[j].columnNodeName,"",this.column[j].columnType);
   	}
   	this.recordList.push(_record);
   	this.setCurrentPos(this.recordList.length-1);
   	this.fireUpdateView();
}

function _dataset_genKeyWhere()
{
	if(this.currentPos==null)return;
	var where = new WhereQuery("and");
	for(var i=0;i<this.column.length;i++)
	{
		if(this.column[i].isKey)
		{
			where.pushField(this.column[i].columnNodeName,"eq",this.getValue(this.column[i].columnNodeName));
		}
	}
	return where;
}

function _dataset_enableUpdateView()
{
	this._updateViewEnabled = true;
}

function _dataset_disableUpdateView()
{
	this._updateViewEnabled = false;
}

function _dataset_validate()
{
	for(var i=0;i<this.recordList.length;i++)
	{
		//FIXME check each field is validate.
	}
	return true;
}

function _dataset_filter(nodeName,type,queryValue,customFun)
{
	var doc = createDoc();
	var filter = doc.createElement("filter");
	var query = doc.createElement("query");
	query.setAttribute("node",nodeName);
	query.setAttribute("type",type);
	var value = doc.createTextNode("value");
	doc.appendChild(filter);
	filter.appendChild(query);
	query.appendChild(value);
	value.nodeValue=queryValue;
	if(window.ActiveXObject)
    {
    	text = doc.xml;
    }else if(window.XMLSerializer)
    {
    	text = (new XMLSerializer()).serializeToString(doc);
    }
	var query = "data="+encodeURI(text);
	var args = Array.prototype.slice.call(arguments,2);
	ajaxDataset(query,this,true,customFun,args);
}
function _dataset_order(nodeName,des)
{
	var doc = createDoc();
	var filter = doc.createElement("filter");
	var order = doc.createElement("order");
	order.setAttribute("node",nodeName);
	order.setAttribute("des",des);
	doc.appendChild(filter);
	filter.appendChild(order);
	if(window.ActiveXObject)
    {
    	text = doc.xml;
    }else if(window.XMLSerializer)
    {
    	text = (new XMLSerializer()).serializeToString(doc);
    }
	var query = "data="+encodeURI(text);
	var args = [this,nodeName];
	ajaxDataset(query,this,false,updateDataset,args);
}

function updateDataset(_dataset,_nodename)
{
	_dataset.fireUpdateView(_nodename);
}