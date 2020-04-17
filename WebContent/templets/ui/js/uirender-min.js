var _fileIncluded_control = true;
var _init_flag = true;
function initDataPilot(h) {
	var f = getElementDataset(h);
	if (!h.getAttribute("pageSize")) {
		if (f) {
			h.pageSize = f.pageSize
		}
	}
	var b = h.getAttribute("pageSize");
	for ( var c = 0; c < h.tBodies[0].rows.length; c++) {
		var g = h.tBodies[0].rows[c];
		g.removeNode(true)
	}
	var e = getValidStr(h.getAttribute("buttons"));
	if (e == "" || compareText(e, "default")) {
		e = "movefirst,prevpage,moveprev,movenext,nextpage,movelast,appendrecord,deleterecord,cancelrecord,updaterecord"
	} else {
		if (compareText(e, "readonly")) {
			e = "movefirst,prevpage,moveprev,movenext,nextpage,movelast"
		}
	}
	e = e.toLowerCase();
	var d = e.split(",");
	var g = h.tBodies[0].insertRow();
	g.align = "center";
	for ( var c = 0; c < d.length; c++) {
		btn = document
				.createElement('<input type=button class=button hideFocus=true style="height: 22px">');
		btn.style.backgroundImage = "url(" + _theme_root + "/button.gif)";
		btn.tabIndex = -1;
		btn.onmouseover = _button_onmouseover;
		btn.onmouseout = _button_onmouseout;
		btn.onclick = _datapilot_onclick;
		btn.dataset = h.getAttribute("dataset");
		btn.buttonType = d[c];
		btn.datapiolt = h;
		switch (d[c]) {
		case "movefirst":
			btn.style.fontFamily = "Webdings";
			btn.value = "9";
			btn.title = constDatasetMoveFirst;
			btn.style.width = 30;
			break;
		case "prevpage":
			btn.style.fontFamily = "Webdings";
			btn.value = "7";
			btn.title = constDatasetPrevPage;
			btn.style.width = 30;
			break;
		case "moveprev":
			btn.style.fontFamily = "Webdings";
			btn.value = "3";
			btn.title = constDatasetMovePrev;
			btn.style.width = 30;
			break;
		case "movenext":
			btn.style.fontFamily = "Webdings";
			btn.value = "4";
			btn.title = constDatasetMoveNext;
			btn.style.width = 30;
			break;
		case "nextpage":
			btn.style.fontFamily = "Webdings";
			btn.value = "8";
			btn.title = constDatasetNextPage;
			btn.style.width = 30;
			break;
		case "movelast":
			btn.style.fontFamily = "Webdings";
			btn.value = ":";
			btn.title = constDatasetMoveLast;
			btn.style.width = 30;
			break;
		case "insertrecord":
			btn.value = constBtnInsertRecord;
			btn.title = constDatasetInsertRecord;
			btn.style.width = 45;
			break;
		case "appendrecord":
			btn.value = constBtnAppendRecord;
			btn.title = constDatasetAppendRecord;
			btn.style.width = 45;
			break;
		case "deleterecord":
			btn.value = constBtnDeleteRecord;
			btn.title = constDatasetDeleteRecord;
			btn.style.width = 45;
			break;
		case "editrecord":
			btn.value = constBtnEditRecord;
			btn.title = constDatasetEditRecord;
			btn.style.width = 45;
			break;
		case "cancelrecord":
			btn.value = constBtnCancelRecord;
			btn.title = constDatasetCancelRecord;
			btn.style.width = 45;
			break;
		case "updaterecord":
			btn.value = constBtnUpdateRecord;
			btn.title = constDatasetUpdateRecord;
			btn.style.width = 45;
			break
		}
		btn.id = h.id + "_" + btn.buttonType;
		g.insertCell().appendChild(btn)
	}
	refreshDataPilot(h)
}
function setDataPilotButtons(c, b) {
	c.buttons = b;
	initDataPilot(c)
}
function refreshDataPilot(g) {
	function d(i, h) {
		i.disabled = !h;
		refreshButtonColor(i)
	}
	var e = getElementDataset(g);
	var f = g.rows[0];
	for ( var c = 0; c < f.cells.length; c++) {
		var b = f.cells[c].children[0];
		switch (b.buttonType) {
		case "movefirst":
		case "moveprev":
			d(b, (e && !e.bof));
			break;
		case "prevpage":
			d(b, (e && e.record && e.record.pageIndex > 1));
			break;
		case "movenext":
		case "movelast":
			d(b, (e && !e.eof));
			break;
		case "nextpage":
			d(b, (e && e.record && e.record.pageIndex < e.pageCount));
			break;
		case "insertrecord":
		case "appendrecord":
			d(b, (e && !e.readOnly));
			break;
		case "editrecord":
			d(b, (e && !(e.bof && e.eof) && !e.readOnly));
			break;
		case "deleterecord":
			d(b, (e && !(e.bof && e.eof) && !e.readOnly));
			break;
		case "cancelrecord":
		case "updaterecord":
			d(
					b,
					(e && (e.state == "insert" || e.state == "modify") && !e.readOnly));
			break
		}
		fireUserEvent(getElementEventName(g, "onRefreshButton"), [ g, b,
				b.buttonType, e ])
	}
}
function _datapilot_onclick() {
	if (event.srcElement.disabled) {
		return
	}
	var f = event.srcElement.datapiolt;
	var g = getElementDataset(f);
	var d = getElementEventName(f, "onButtonClick");
	if (isUserEventDefined(d)) {
		var e = fireUserEvent(d, [ f, event.srcElement,
				event.srcElement.buttonType, g ]);
		if (!e) {
			return
		}
	}
	var c = f.getAttribute("pageSize");
	switch (event.srcElement.buttonType) {
	case "movefirst":
		g.moveFirst();
		break;
	case "prevpage":
		var b = (g.record) ? g.record.pageIndex - 1 : 1;
		g.moveToPage(b);
		break;
	case "moveprev":
		g.movePrev();
		break;
	case "movenext":
		g.moveNext();
		break;
	case "nextpage":
		var b = (g.record) ? g.record.pageIndex + 1 : 1;
		g.moveToPage(b);
		break;
	case "movelast":
		g.moveLast();
		break;
	case "insertrecord":
		g.insertRecord("before");
		break;
	case "appendrecord":
		g.insertRecord("end");
		break;
	case "editrecord":
		dataset_setState(g, "modify");
		break;
	case "deleterecord":
		if (isTrue(f.getAttribute("confirmDelete"))) {
			if (confirm(constDatasetDeleteRecord)) {
				g.deleteRecord()
			}
		} else {
			g.deleteRecord()
		}
		break;
	case "cancelrecord":
		if (isTrue(f.getAttribute("confirmCancel"))) {
			if (confirm(constDatasetCancelRecord)) {
				g.cancelRecord()
			}
		} else {
			g.cancelRecord()
		}
		break;
	case "updaterecord":
		g.updateRecord();
		break
	}
}
function initTabSet(tabset) {
	tabset._imagePrefix = _theme_root + "/tabset/" + tabset.tabPlacement + "_";
	var parentDiv = tabset.parentElement;
	parentDiv.style.width = parentDiv.offsetWidth;
	var tabs = tabset.getAttribute("tabs");
	if (tabs.length > 0 && tabs.substring(tabs.length - 1, tabs.length) == ";") {
		tabs = tabs.substring(0, tabs.length - 1)
	}
	if (!tabs) {
		return
	}
	var tabs = tabs.split(";");
	for ( var i = 0; i < tabset.tBodies[0].rows.length; i++) {
		var row = tabset.tBodies[0].rows[i];
		row.removeNode(true)
	}
	var row = tabset.tBodies[0].insertRow();
	var cell = row.insertCell();
	cell.firstCell = true;
	cell.innerHTML = '<img src="' + tabset._imagePrefix + 'start_tab.gif">';
	var label, tabname, index;
	for (i = 0; i < tabs.length; i++) {
		props = tabs[i].split(",");
		cell = row.insertCell();
		cell.background = tabset._imagePrefix + "tab_button.gif";
		cell._tabIndex = i;
		label = props[0];
		tabname = props[1];
		cell.tabName = tabname;
		cell.label = label;
		cell.targetUrl = getDecodeStr(props[2]);
		btn = document
				.createElement("<DIV hideFocus=true nowrap class=tab></DIV>");
		btn.innerText = getDecodeStr(props[0]);
		btn._tabIndex = -1;
		btn.onclick = _tabset_onclick;
		btn.onmouseover = _tabset_onmouseover;
		btn.onmouseout = _tabset_onmouseout;
		btn.tab = cell;
		cell.appendChild(btn);
		cell = row.insertCell();
		if (i != tabs.length - 1) {
			cell.innerHTML = '<img src="' + tabset._imagePrefix + 'tab.gif">'
		} else {
			cell.lastCell = true;
			cell.innerHTML = '<img src="' + tabset._imagePrefix
					+ 'end_tab.gif">'
		}
		eval("var tabsetBody=_body_" + tabset.id + ";");
		eval("if (typeof(" + tabset.id + "_" + tabname
				+ ')!="undefined") var tab=' + tabset.id + "_" + tabname + ";");
		if (typeof (tab) != "undefined") {
			tab.extra = "tab";
			tab.style.visibility = "hidden";
			_setChildTableVisibility(tab, "hidden");
			tab.style.overflow = "auto";
			tab.style.position = "absolute";
			tab.style.left = 0;
			tab.style.top = 0;
			tab.style.width = tabsetBody.clientWidth - 4;
			tab.style.height = tabsetBody.clientHeight - 4;
			tab.style.margin = 2
		}
	}
	cell = row.insertCell();
	cell.width = "100%";
	cell.background = tabset._imagePrefix + "tab_blank.gif";
	if (v_currentTab) {
		setActiveTab(tabset, v_currentTab)
	} else {
		setActiveTabIndex(tabset, getInt(tabset.getAttribute("tabIndex")))
	}
	if (tabset.offsetWidth > parentDiv.clientWidth) {
		var buttonPane = document
				.createElement('<div style="width:30; cursor:hand; z-index:1000"></div>');
		buttonPane.innerHTML = '<img width="15" height="15" src="'
				+ _theme_root
				+ '/tabset/scroll_button1.gif" onmousedown="_tabpane_'
				+ tabset.id + ".scrollLeft=_tabpane_" + tabset.id
				+ '.scrollLeft-50"><img width="15" height="15" src="'
				+ _theme_root
				+ '/tabset/scroll_button2.gif" onmousedown="_tabpane_'
				+ tabset.id + ".scrollLeft=_tabpane_" + tabset.id
				+ '.scrollLeft+50">';
		buttonPane.style.position = "absolute";
		eval("var pos=getAbsPosition(_tabpane_" + tabset.id + ");");
		buttonPane.style.left = pos[0];
		buttonPane.style.top = pos[1] + 4;
		eval("_tabdiv_" + tabset.id + ".appendChild(buttonPane);")
	}
	eval("var tabsetPane=_tabsetpane_" + tabset.id + ";");
	tabsetPane.tabPane = parentDiv;
	tabsetPane.onresize = tabSet_onResize
}
function tabSet_onResize() {
	var c = event.srcElement;
	var b = c.tabPane;
	b.style.width = c.offsetWidth
}
function setTabs(c, b) {
	c.tabs = b;
	initTabSet(c)
}
function _setChildTableVisibility(c, d) {
	for ( var b = 0; b < c.children.length; b++) {
		var e = c.children[b];
		if (compareText(e.getAttribute("extra"), "datatable")) {
			e.style.visibility = d;
			if (!compareText(d, "hidden") && e.needRefresh) {
				e.refreshData()
			}
		}
		_setChildTableVisibility(e, d)
	}
}
function _setActiveTab(cell) {
	try {
		var row = getRowByCell(cell);
		var tabset = getTableByRow(row);
		var selectCell = tabset.selectTab;
		if (selectCell == cell) {
			return
		}
		var oldName = (selectCell) ? selectCell.tabName : "";
		var newName = cell.tabName;
		var eventName = getElementEventName(tabset, "beforeTabChange");
		var event_result = fireUserEvent(eventName,
				[ tabset, oldName, newName ]);
		if (event_result) {
			throw event_result
		}
		eval("var tabsetBody=_body_" + tabset.id + ";");
		if (selectCell) {
			var prevCell = row.cells[selectCell.cellIndex - 1];
			var nextCell = row.cells[selectCell.cellIndex + 1];
			selectCell.background = tabset._imagePrefix + "tab_button.gif";
			if (prevCell.firstCell) {
				prevCell.firstChild.src = tabset._imagePrefix + "start_tab.gif"
			} else {
				prevCell.firstChild.src = tabset._imagePrefix + "tab.gif"
			}
			if (nextCell.lastCell) {
				nextCell.firstChild.src = tabset._imagePrefix + "end_tab.gif"
			} else {
				nextCell.firstChild.src = tabset._imagePrefix + "tab.gif"
			}
			var tab = null;
			eval("if (typeof(" + tabset.id + "_" + oldName
					+ ')!="undefined") tab=' + tabset.id + "_" + oldName + ";");
			if (tab) {
				_stored_element = tab;
				_setChildTableVisibility(tab, "hidden");
				document.body.appendChild(tab);
				var s = '_stored_element.style.position="absolute";_stored_element.style.visibility="hidden";';
				setTimeout(s, 0)
			}
		}
		var prevCell = row.cells[cell.cellIndex - 1];
		var nextCell = row.cells[cell.cellIndex + 1];
		cell.background = tabset._imagePrefix + "active_tab_button.gif";
		if (prevCell.firstCell) {
			prevCell.firstChild.src = tabset._imagePrefix
					+ "active_start_tab.gif"
		} else {
			prevCell.firstChild.src = tabset._imagePrefix + "active_tab1.gif"
		}
		if (nextCell.lastCell) {
			nextCell.firstChild.src = tabset._imagePrefix
					+ "active_end_tab.gif"
		} else {
			nextCell.firstChild.src = tabset._imagePrefix + "active_tab2.gif"
		}
		var tab = null;
		eval("if (typeof(" + tabset.id + "_" + newName + ')!="undefined") tab='
				+ tabset.id + "_" + newName + ";");
		if (tab) {
			tabsetBody.appendChild(tab);
			tab.style.position = "";
			tab.style.visibility = "";
			_setChildTableVisibility(tab, "")
		}
		tabset.selectTab = cell;
		tabset.selectName = cell.tabName;
		tabset.selectIndex = cell._tabIndex;
		if (cell.targetUrl) {
			open(cell.targetUrl, tabset.targetFrame)
		}
		var eventName = getElementEventName(tabset, "afterTabChange");
		fireUserEvent(eventName, [ tabset, oldName, newName ])
	} catch (e) {
		processException(e)
	}
}
function setActiveTab(c, d) {
	if (!d) {
		return
	}
	for ( var b = 0; b < c.cells.length; b++) {
		if (c.cells[b].tabName == d) {
			_setActiveTab(c.cells[b]);
			break
		}
	}
}
function setActiveTabIndex(d, b) {
	for ( var c = 0; c < d.cells.length; c++) {
		if (d.cells[c]._tabIndex == b) {
			_setActiveTab(d.cells[c]);
			if (b > 10) {
				temp = document.getElementById("_tabpane_" + d.id);
				temp.scrollLeft = temp.scrollLeft + 500
			}
			break
		}
	}
}
function setActiveTabIndex_new(d, b) {
	for ( var c = 0; c < d.cells.length; c++) {
		if (d.cells[c]._tabIndex == b) {
			_setActiveTab_new(d.cells[c]);
			if (b > 10) {
				temp = document.getElementById("_tabpane_" + d.id);
				temp.scrollLeft = temp.scrollLeft + 500
			}
			break
		}
	}
}
function _setActiveTab_new(cell) {
	try {
		var row = getRowByCell(cell);
		var tabset = getTableByRow(row);
		var selectCell = tabset.selectTab;
		if (selectCell == cell) {
			return
		}
		var oldName = (selectCell) ? selectCell.tabName : "";
		var newName = cell.tabName;
		var eventName = getElementEventName(tabset, "beforeTabChange");
		var event_result = fireUserEvent(eventName,
				[ tabset, oldName, newName ]);
		if (event_result) {
			throw event_result
		}
		eval("var tabsetBody=_body_" + tabset.id + ";");
		if (selectCell) {
			var prevCell = row.cells[selectCell.cellIndex - 1];
			var nextCell = row.cells[selectCell.cellIndex + 1];
			selectCell.background = tabset._imagePrefix + "tab_button.gif";
			if (prevCell.firstCell) {
				prevCell.firstChild.src = tabset._imagePrefix + "start_tab.gif"
			} else {
				prevCell.firstChild.src = tabset._imagePrefix + "tab.gif"
			}
			if (nextCell.lastCell) {
				nextCell.firstChild.src = tabset._imagePrefix + "end_tab.gif"
			} else {
				nextCell.firstChild.src = tabset._imagePrefix + "tab.gif"
			}
			var tab = null;
			eval("if (typeof(" + tabset.id + "_" + oldName
					+ ')!="undefined") tab=' + tabset.id + "_" + oldName + ";");
			if (tab) {
				_stored_element = tab;
				_setChildTableVisibility(tab, "hidden");
				document.body.appendChild(tab);
				var s = '_stored_element.style.position="absolute";_stored_element.style.visibility="hidden";';
				setTimeout(s, 0)
			}
		}
		var prevCell = row.cells[cell.cellIndex - 1];
		var nextCell = row.cells[cell.cellIndex + 1];
		cell.background = tabset._imagePrefix + "active_tab_button.gif";
		if (prevCell.firstCell) {
			prevCell.firstChild.src = tabset._imagePrefix
					+ "active_start_tab.gif"
		} else {
			prevCell.firstChild.src = tabset._imagePrefix + "active_tab1.gif"
		}
		if (nextCell.lastCell) {
			nextCell.firstChild.src = tabset._imagePrefix
					+ "active_end_tab.gif"
		} else {
			nextCell.firstChild.src = tabset._imagePrefix + "active_tab2.gif"
		}
		var tab = null;
		eval("if (typeof(" + tabset.id + "_" + newName + ')!="undefined") tab='
				+ tabset.id + "_" + newName + ";");
		if (tab) {
			tabsetBody.appendChild(tab);
			tab.style.position = "";
			tab.style.visibility = "";
			_setChildTableVisibility(tab, "")
		}
		tabset.selectTab = cell;
		tabset.selectName = cell.tabName;
		tabset.selectIndex = cell._tabIndex;
		if (cell.targetUrl) {
		}
		var eventName = getElementEventName(tabset, "afterTabChange");
		fireUserEvent(eventName, [ tabset, oldName, newName ])
	} catch (e) {
		processException(e)
	}
}
function _tabset_onclick() {
	var b = event.srcElement.tab;
	_setActiveTab(b)
}
function _tabset_onmouseover() {
	event.srcElement.style.color = "blue";
	event.srcElement.style.textDecorationUnderline = true
}
function _tabset_onmouseout() {
	event.srcElement.style.color = "black";
	event.srcElement.style.textDecorationUnderline = false
}
function initButton(b) {
	b.hideFocus = true;
	setButtonDown(b, b.getAttribute("down"));
	b.onmousedown = function() {
		_button_onmousedown(b)
	};
	b.onmouseup = function() {
		_button_onmouseup(b)
	};
	b.onmouseover = function() {
		_button_onmouseover(b)
	};
	b.onmouseout = function() {
		_button_onmouseout(b)
	};
	b.title = getDecodeStr(b.toolTip)
}
function setButtonDown(b, c) {
	b.down = isTrue(c)
}
function _button_onmousedown(b) {
	fireUserEvent(getElementEventName(b, "onMouseDown"), [ b ])
}
function _button_onmouseup(b) {
	if (isTrue(b.getAttribute("allowPushDown"))) {
		var c = b.getAttribute("down");
		setButtonDown(b, !c)
	}
	fireUserEvent(getElementEventName(b, "onMouseUp"), [ b ])
}
function _button_onmouseover(b) {
	try {
		if (b.disabled || b.down) {
			return
		}
		fireUserEvent(getElementEventName(b, "onMouseEnter"), [ b ])
	} catch (c) {
	}
}
function _button_onmouseout(b) {
	try {
		if (b.disabled) {
			return
		}
		fireUserEvent(getElementEventName(b, "onMouseLeave"), [ b ])
	} catch (c) {
	}
}
function initGroupBox(d) {
	var e = d.expand;
	var c = d.getElementsByTagName("DIV")[0];
	if (c) {
		var b = c.getElementsByTagName("DIV")[0];
		if (b) {
			if (e != "true") {
				c.style.height = "5px";
				b.style.display = "none"
			} else {
				c.style.height = "";
				b.style.display = ""
			}
		}
	}
}
function initGroupBoxTitle(b) {
	var c = b.parentElement.expand;
	var e;
	var d;
	if (c == "true") {
		e = _theme_root + "/group_expand.gif";
		d = constGroupBoxCollapseAlt
	} else {
		e = _theme_root + "/group_collapse.gif";
		d = constGroupBoxExpandAlt
	}
	b.innerHTML += "<img expand='"
			+ c
			+ "' alt='"
			+ d
			+ "' src='"
			+ e
			+ "' onclick='_groupboxtitle_onClick(this)' style='cursor: hand;'/>"
}
function _groupboxtitle_onClick(c) {
	var d = c.parentElement.parentElement.getElementsByTagName("DIV")[0];
	if (!d) {
		return
	}
	var b = d.getElementsByTagName("DIV")[0];
	if (!b) {
		return
	}
	if (c.expand == "true") {
		d.style.height = "5px";
		d.style.width = d.offsetWidth;
		b.style.display = "none";
		c.src = _theme_root + "/group_collapse.gif";
		c.alt = constGroupBoxExpandAlt;
		c.expand = "false"
	} else {
		d.style.height = "";
		d.style.width = "";
		b.style.display = "";
		c.src = _theme_root + "/group_expand.gif";
		c.alt = constGroupBoxCollapseAlt;
		c.expand = "true"
	}
}
function initSubWindow(c) {
	var d = c.defaultZoom;
	var b = getSubWindowContainer(c);
	if (!b) {
		return
	}
	if (d == "min") {
		b.style.display = "none"
	} else {
		if (d == "max") {
		} else {
			b.style.display = ""
		}
	}
}
function initSubWindowTitle(d) {
	var b = d.children[0];
	var e = d.defaultZoom;
	var f = d.minimize;
	var g = d.maximize;
	if (f == "true") {
		var c = b.rows[0].insertCell();
		c.innerHTML = "<img src='' onclick='_subwindowtitle_min_onClick(this)' style='cursor: hand;'/>"
	}
	if (g == "true") {
		var c = b.rows[0].insertCell();
		c.innerHTML = "<img src='' onclick='_subwindowtitle_max_onClick(this)' style='cursor: hand;'/>"
	}
	zoomSubWindow(d, e)
}
function getSubWindowFromTitle(b) {
	return b.parentElement.parentElement.parentElement.parentElement
}
function getSubWindowContainer(b) {
	return b.children[0].rows[1].cells[0].children[0]
}
function getSubWindowTitleFromImg(b) {
	return b.parentElement.parentElement.parentElement.parentElement.parentElement
}
function getSubWindowMinImg(b) {
	return b.children[0].rows[0].cells[1].children[0]
}
function getSubWindowMaxImg(b) {
	return b.children[0].rows[0].cells[2].children[0]
}
function _subwindowtitle_min_onClick(b) {
	var d = getSubWindowTitleFromImg(b);
	var c;
	if (d.currentZoom == "min") {
		zoomSubWindow(d, "normal")
	} else {
		zoomSubWindow(d, "min")
	}
}
function _subwindowtitle_max_onClick(b) {
	var c = getSubWindowTitleFromImg(b);
	if (c.currentZoom == "max") {
		zoomSubWindow(c, "normal")
	} else {
		zoomSubWindow(c, "max")
	}
}
function zoomSubWindow(g, f) {
	var e = getSubWindowFromTitle(g);
	var b = getSubWindowContainer(e);
	var d = null;
	if (g.minimize == "true") {
		d = getSubWindowMinImg(g)
	}
	var c = null;
	if (g.maximize == "true") {
		c = getSubWindowMaxImg(g)
	}
	g.currentZoom = f;
	if (f == "normal") {
		if (d) {
			d.src = _theme_root + "/subwindow_minimize.gif"
		}
		if (c) {
			c.src = _theme_root + "/subwindow_maximize.gif"
		}
		b.style.display = "";
		e.style.height = e.defaultHeight
	} else {
		if (f == "min") {
			if (d) {
				d.src = _theme_root + "/subwindow_normal.gif"
			}
			if (c) {
				c.src = _theme_root + "/subwindow_maximize.gif"
			}
			b.style.display = "none";
			e.style.height = ""
		} else {
			if (f == "max") {
				if (d) {
					d.src = _theme_root + "/subwindow_minimize.gif"
				}
				if (c) {
					c.src = _theme_root + "/subwindow_normal.gif"
				}
				b.style.display = ""
			}
		}
	}
}
function _initButton(c, h, b, d, j, f, i, k, e) {
	var g = $("#" + c);
	if (g.size()) {
		g = g.get(0);
		g.onclick = function() {
			_button_onclick_new(c);
			return false
		};
		g.componentDataset = h;
		g.url = b;
		g.updateclass = d;
		g.resultDataset = j;
		g.submitDataset = f;
		g.targetFrame = i;
		g.defaultOperation = k;
		g.funcId = e
	}
}
function initEasyTabSet(d) {
	var b = $(d).attr("id");
	var c = $(d).attr("tabs");
	_jtabset_list[_jtabset_list.length] = $(d).tabs({
		onBeforeSelect : function(m, k) {
			m = m.substring(b.length + 1);
			if (!v_curretnTabId) {
				v_curretnTabId = m;
				return true
			}
			if (m == v_curretnTabId) {
				return true
			}
			var g = $(this).tabs("selectHis");
			var j = $(this).tabs("getTab", g[g.length - 1]);
			var l = j.find("iframe")[0].contentWindow;
			var f = getElementEventName(d, "beforeTabChange");
			try {
				var h = l.fireUserEvent(f, [ d, v_curretnTabId, m ]);
				if (h) {
					if (h != false) {
						alert(h)
					}
					return false
				}
			} catch (i) {
			}
			return true
		},
		onSelect : function(f) {
			var e = $(this).tabs("getTab", f);
			var g = e.find("iframe");
			if (g.attr("src") == "") {
				g.attr("src", g.attr("url"))
			}
		},
		onAfterSelect : function(l, j) {
			l = l.substring(b.length + 1);
			if (!v_curretnTabId) {
				v_curretnTabId = l;
				return
			}
			if (l == v_curretnTabId) {
				return
			}
			var g = $(this).tabs("selectHis");
			var i = $(this).tabs("getTab", g[g.length - 2]);
			var k = i.find("iframe")[0].contentWindow;
			var f = getElementEventName(d, "afterTabChange");
			try {
				k.fireUserEvent(f, [ d, v_curretnTabId, l ])
			} catch (h) {
			}
			v_curretnTabId = l
		}
	})
}
function getTabSetById(b) {
	var d = window.parent._tabset_list;
	for ( var c = 0; c < d.length; c++) {
		if (d[c].id == b) {
			return d[c]
		}
	}
}
function setTabSetById(b, d) {
	var e = window.parent._tabset_list;
	for ( var c = 0; c < e.length; c++) {
		if (e[c].id == b) {
			e[c] = d
		}
	}
}
function getJTabSetById(c) {
	var b = window.parent._jtabset_list;
	for ( var d = 0; d < b.length; d++) {
		if (b[d].attr("id") == c) {
			return b[d]
		}
	}
}
function setActiveTab(c, b) {
	if (!b) {
		return
	}
	c.setActiveTab(b)
}
function setActiveTabIndex(c, b) {
	if (b < 0) {
		return
	}
	tabset.setActiveTabIndex(b)
}
var _fileIncluded_dropdown = true;
var _dropdown_parentwindow = null;
var _dropdown_parentbox = null;
var _dropdown_box = null;
var _dropdown_table = null;
var _dropdown_frame = null;
var _dropdown_dataset = null;
var _date_dropdown_box = null;
var _array_dropdown = new Array();
var _calendarControl = null;
var _tmp_dataset_date = null;
function createDropDown(c) {
	var b = new Object();
	b.id = c;
	b.clearCache = dropdown_clearCache;
	return b
}
function initDropDown(b) {
	_array_dropdown[_array_dropdown.length] = b
}
function getDropDownByID(ID) {
	for ( var i = 0; i < _array_dropdown.length; i++) {
		if (_array_dropdown[i].id == ID) {
			return _array_dropdown[i]
		}
	}
	var result = null;
	eval("if (typeof(" + ID + ')!="undefined") result=' + ID + ";");
	return result
}
function getDropDowns() {
	return _array_dropdown
}
function dropdown_clearCache() {
	var b = this;
	b.dropdownbox = null
}
function initDropDownBox(c) {
	try {
		_isDropDownPage = true;
		if (typeof (_dropdown_succeed) != "undefined"
				&& !isTrue(_dropdown_succeed)) {
			throw getDecodeStr(_dropdown_error)
		} else {
			if (c == "dynamic") {
				if (typeof (datasetDropDown) != "undefined") {
					_dropdown_dataset = datasetDropDown
				}
			}
			initDocument();
			_initDropDownBox(c)
		}
		return true
	} catch (b) {
		processException(b);
		hideDropDown();
		hideStatusLabel(window.parent);
		return false
	}
}
function _initDropDownBox(dropDownType) {
	_document_loading = true;
	switch (dropDownType) {
	case "dynamic":
		_dropdown_div.onkeydown = _dropdown_onkeydown;
	case "custom":
		_dropdown_parentwindow = window.parent;
		_dropdown_parentbox = _dropdown_parentwindow._dropdown_box;
		if (_dropdown_parentbox == null) {
			return
		}
		_dropdown_parentwindow._dropdown_window = window;
		if (!_dropdown_parentbox
				|| _dropdown_parentbox.style.visibility == "hidden") {
			return
		}
		var editor = _dropdown_parentbox.editor;
		_dropdown_div.style.width = (_dropdown_parentbox.offsetWidth > editor.offsetWidth) ? _dropdown_parentbox.offsetWidth
				: editor.offsetWidth;
		_dropdown_parentwindow.sizeDropDownBox();
		with (_dropdown_parentwindow._dropdown_frame) {
			width = "100%";
			if (filters.blendTrans.status != 2) {
				if (getIEVersion() < "5.5") {
					style.visibility = "visible"
				} else {
					filters.blendTrans.apply();
					style.visibility = "visible";
					filters.blendTrans.play()
				}
			}
		}
		_dropdown_parentbox.dropDown.dropdownbox = _dropdown_parentbox;
		hideStatusLabel(_dropdown_parentwindow);
		break;
	case "predate":
	case "postdate":
	case "date":
		_dropdown_parentwindow = window;
		_dropdown_parentbox = _dropdown_parentwindow._dropdown_box;
		_dropdown_parentwindow._dropdown_window = window;
		sizeDropDownBox();
		if ((getIEVersion() >= "5.5")
				&& _dropdown_parentbox.filters.blendTrans.status != 2) {
			_dropdown_parentbox.filters.blendTrans.play()
		}
		break;
	default:
		_dropdown_parentwindow = window;
		_dropdown_parentbox = _dropdown_parentwindow._dropdown_box;
		_dropdown_parentwindow._dropdown_window = window;
		_dropdown_dataset = getElementDataset(_dropdown_table);
		sizeDropDownBox();
		if ((getIEVersion() >= "5.5")
				&& _dropdown_parentbox.filters.blendTrans.status != 2) {
			_dropdown_parentbox.filters.blendTrans.play()
		}
		break
	}
	_dropdown_parentbox.prepared = true;
	var editor = _dropdown_parentbox.editor;
	if (editor) {
		dropDownLocate()
	}
	_document_loading = false
}
function sizeDropDownBox() {
	function _sizeDropDownBox(new_width, new_height) {
		with (_dropdown_box) {
			var editor = _dropdown_box.editor;
			var dropdown = _dropdown_box.dropDown;
			var maxHeight = parseInt(dropdown.height);
			if (isNaN(maxHeight) || maxHeight < 20) {
				maxHeight = 300
			}
			var pos = getAbsPosition(editor, document.body);
			var _posLeft = pos[0];
			var _posTop = pos[1] + editor.offsetHeight + 1;
			if (new_height > maxHeight
					&& !(dropdown.type == "dynamic" && getInt(dropdown.pageSize) > 0)) {
				new_height = maxHeight;
				new_width += 16;
				if (!(getIEVersion() < "5.5")) {
					style.overflowY = "scroll"
				} else {
					style.overflowY = "visible"
				}
			} else {
				style.overflowY = "hidden"
			}
			var document_width = document.body.clientWidth
					+ document.body.scrollLeft;
			var document_height = document.body.clientHeight
					+ document.body.scrollTop;
			if (_posLeft + new_width > document_width
					&& document_width > new_width) {
				_posLeft = document_width - new_width
			}
			if (_posTop + new_height > document_height && pos[1] > new_height) {
				_posTop = pos[1] - new_height - 5
			}
			style.posLeft = _posLeft;
			style.posTop = _posTop;
			style.posHeight = new_height + 4;
			if (Math.abs(new_width + 4 - style.posWidth) > 4) {
				style.posWidth = new_width + 4
			}
			style.borderWidth = "2px"
		}
	}
	if (!isDropdownBoxVisible()) {
		return
	}
	try {
		var _width, _height;
		switch (_dropdown_box.dropDown.type) {
		case "dynamic":
		case "custom":
			with (_dropdown_frame) {
				_height = _dropdown_window._dropdown_div.offsetHeight;
				_width = _dropdown_window._dropdown_div.offsetWidth;
				style.posWidth = _width;
				style.posHeight = _height
			}
			break;
		case "predate":
		case "postdate":
		case "date":
			_width = CalendarTable.offsetWidth;
			_height = CalendarTable.offsetHeight;
			break;
		default:
			_width = _dropdown_table.offsetWidth;
			_height = _dropdown_table.offsetHeight;
			break
		}
		_sizeDropDownBox(_width, _height)
	} catch (e) {
	}
}
function canDropDown(c) {
	var d = getElementField(c);
	var b = ((d && d.dropDown) || c.getAttribute("dropDown"));
	return (b && !compareText(c.type, "checkbox"))
}
function getDropDownBox(c) {
	var b = null;
	if (c.cached == false) {
		if (c.cache) {
			c.clearCache()
		}
	}
	if (c.cache) {
		b = c.dropdownbox
	}
	if (!b) {
		b = document
				.createElement('<DIV class="dropdown_frame" style="overflow-X: hidden; position: absolute; visibility: hidden; z-index: 10000"></DIV>');
		document.body.appendChild(b);
		b.dropDown = c
	}
	_dropdown_box = b
}
function getDropDownBtn() {
	if (typeof (_dropdown_btn) == "undefined") {
		obj = document
				.createElement('<INPUT class="dropdown_button" id=_dropdown_btn type=button tabindex=-1 value=6 hidefocus=true style="position: absolute; visibility: hidden; z-index: 9999" LANGUAGE=javascript onmousedown="return _dropdown_btn_onmousedown(this)" onfocus="return _dropdown_btn_onfocus(this)">');
		obj.style.background = "url(" + _theme_root + "/dropdown_button.gif)";
		document.body.appendChild(obj);
		return obj
	} else {
		return _dropdown_btn
	}
}
function showDropDownBox(_editor) {
	try {
		if (!canDropDown(_editor)) {
			return
		}
		if (!isDropdownBoxVisible()) {
			var dropDownId = _editor.getAttribute("dropDown");
			if (!dropDownId) {
				var field = getElementField(_editor);
				if (field) {
					dropDownId = field.dropDown
				}
			}
			eval("var dropdown=" + dropDownId);
			var eventName = getElementEventName(dropdown, "beforeOpen");
			var event_result = fireUserEvent(eventName, [ dropdown ]);
			if (event_result) {
				throw event_result
			}
			getDropDownBox(dropdown);
			_dropdown_box.editor = _editor;
			_dropdown_box.prepared = false;
			if (_dropdown_box.filters.blendTrans.status == 2) {
				return
			}
			var dataset = getElementDataset(_editor);
			if (dataset) {
				if (!dataset.record) {
					dataset.insertRecord()
				}
			}
			with (_dropdown_box) {
				style.overflowY = "hidden";
				switch (dropdown.type) {
				case "dynamic":
				case "custom":
					style.visibility = "visible";
					style.length = "1";
					if (_editor.offsetWidth > 128) {
						style.width = editor.offsetWidth
					} else {
						style.width = 128
					}
					break;
				default:
					if (filters.blendTrans.status != 2) {
						if (!(getIEVersion() < "5.5")) {
							filters.blendTrans.apply()
						}
						style.visibility = "visible"
					}
					break
				}
				if (!_dropdown_box.cached) {
					switch (dropdown.type) {
					case "dynamic":
						showStatusLabel(window, constDownLoadingData, _editor);
						if (dropdown.sessionKey) {
							var dyDDUrl = _dynamicDropDownUrl;
							if (dropdown.viewType == "table") {
								dyDDUrl = _dynamicDropDownUrl
							} else {
								if (dropdown.viewType == "tree") {
									dyDDUrl = _dynamicDropDownTreeUrl
								} else {
									dyDDUrl = _dynamicDropDownUrl
								}
							}
							var _url = _extra_library + dyDDUrl
									+ "?sessionkey=" + dropdown.sessionKey
									+ "&fields=" + getValidStr(dropdown.fields)
									+ "&showheader="
									+ ((dropdown.showHeader) ? "1" : "0")
									+ "&fieldmeta=" + dropdown.fieldMeta;
							var _dataset = dropdown.dataset;
							if (typeof (_dataset) == "string") {
								_dataset = getDatasetByID(_dataset)
							}
							if (_dataset) {
								_url += "&paramstr="
										+ converDateSetParameter2Str(_dataset);
								_url += "&CQId="
										+ _dataset.getParameter("CQId");
								_url += "&init=" + _dataset.init;
								_url += "&require=" + _dataset.require;
								_url += "&viewField=" + dropdown.fields
							}
							_dropdown_box.innerHTML = '<IFRAME height=0 frameborder=0 marginheight=0 marginwidth=0 scrolling=no src="'
									+ _url
									+ '" style="position:_absolute;visibility:hidden;border-style: none"></IFRAME>';
							_dropdown_frame = _dropdown_box.firstChild
						}
						break;
					case "custom":
						showStatusLabel(window, constDownLoadingData, _editor);
						var _url = dropdown.url;
						if (_url.substring(0, 1) == "/") {
							_url = _application_root + _url
						}
						var fieldMapStr = dropdown.fieldMap;
						var viewField = dropdown.fields;
						var fieldId = dropdown.fieldId;
						if (_url.lastIndexOf("?") != -1) {
							_url += "&sessionkey=" + dropdown.sessionKey
									+ "&fieldMapStr=" + fieldMapStr
									+ "&viewField=" + viewField + "&fieldId="
									+ fieldId
						} else {
							_url += "?sessionkey=" + dropdown.sessionKey
									+ "&fieldMapStr=" + fieldMapStr
									+ "&viewField=" + viewField + "&fieldId="
									+ fieldId
						}
						var _targetDataset = dropdown.targetDataset;
						if (typeof (_targetDataset) == "string") {
							_targetDataset = getDatasetByID(_targetDataset)
						}
						if (_targetDataset) {
							var targetFieldStr = converDateSet2Str(_targetDataset);
							_url += "&targetFieldStr=" + targetFieldStr
						}
						var _dataset = dropdown.dataset;
						if (typeof (_dataset) == "string") {
							_dataset = getDatasetByID(_dataset)
						}
						if (_dataset) {
							var paramStr = converDateSetParameter2Str(_dataset);
							_url += "&paramStr=" + paramStr
						}
						_dropdown_box.innerHTML = '<IFRAME height=0 frameborder=0 marginheight=0 marginwidth=0 scrolling=no src="'
								+ _url
								+ '" style="overflow: hidden; position:_absolute; visibility:hidden; border-style: none"></IFRAME>';
						_dropdown_frame = _dropdown_box.firstChild;
						break;
					case "predate":
					case "postdate":
					case "date":
						var field = getElementField(_editor);
						createCalendar(_dropdown_box, field, _editor);
						_initDropDownBox(dropdown.type);
						_dropdown_box.onkeydown = _calendar_onkeydown;
						break;
					default:
						style.width = _editor.offsetWidth;
						createListTable(_dropdown_box);
						_dropdown_table.onkeydown = _dropdown_onkeydown;
						var _dataset;
						if (dropdown.type == "list") {
							_dataset = getDropDownItems(dropdown);
							if (!dropdown.fields) {
								if (isTrue(dropdown.mapValue)) {
									dropdown.fields = "label"
								} else {
									dropdown.fields = "value"
								}
							}
						} else {
							_dataset = dropdown.dataset;
							if (typeof (_dataset) == "string") {
								_dataset = getDatasetByID(_dataset)
							}
						}
						if (_dataset) {
							setElementDataset(_dropdown_table, _dataset);
							_dropdown_table.fields = dropdown.fields;
							initElements(_dropdown_table);
							refreshTableData(_dropdown_table)
						}
						_initDropDownBox(dropdown.type);
						break
					}
				} else {
					switch (dropdown.type) {
					case "dynamic":
					case "custom":
						_dropdown_frame = _dropdown_box.firstChild;
						dropdown.dropdown_window
								._initDropDownBox(dropdown.type);
						break;
					default:
						for ( var i = 0; i < _dropdown_box.children.length; i++) {
							var obj = _dropdown_box.children[i];
							obj.style.visibility = "visible";
							if (compareText(obj.getAttribute("extra"),
									"datatable")) {
								if (obj.needRefresh) {
									obj.refreshData()
								}
							}
						}
						_dropdown_table = dropdown.dropdown_table;
						_initDropDownBox(dropdown.type);
						break
					}
				}
			}
			_editor.dropDownVisible = true;
			if (typeof (_dropdown_btn) != "undefined") {
				_dropdown_btn.value = "5"
			}
		}
	} catch (e) {
		processException(e)
	}
}
function hideDropDownBox() {
	if (!_dropdown_box) {
		return
	}
	if (isDropdownBoxVisible()) {
		_skip_activeChanged = true;
		var c = _dropdown_box.editor;
		var d = _dropdown_box.dropDown;
		if (_dropdown_box.prepared && d.cache) {
			d.dropdown_box = _dropdown_box;
			_dropdown_box.cached = true;
			switch (d.type) {
			case "list":
			case "dataset":
				d.dropdown_table = _dropdown_table;
				break;
			case "dynamic":
			case "custom":
				d.dropdown_window = _dropdown_window;
				break
			}
			for ( var b = 0; b < _dropdown_box.children.length; b++) {
				_dropdown_box.children[b].style.visibility = "hidden"
			}
			_dropdown_box.style.visibility = "hidden";
			_dropdown_window = null
		} else {
			_dropdown_box.editor = null;
			switch (_dropdown_box.dropDown.type) {
			case "list":
			case "dataset":
				setElementDataset(_dropdown_table, null);
				break;
			case "dynamic":
			case "custom":
				if (typeof (_dropdown_frame) != "undefined") {
					_dropdown_frame.style.visibility = "hidden";
					_dropdown_frame.removeNode(true)
				}
				break
			}
			_dropdown_window = null;
			for ( var b = 0; b < _dropdown_box.children.length; b++) {
				_dropdown_box.children[b].style.visibility = "hidden"
			}
			_dropdown_box.style.visibility = "hidden";
			_dropdown_box.removeNode(true);
			_dropdown_box = null
		}
		c.dropDownVisible = false;
		if (typeof (_dropdown_btn) != "undefined") {
			_dropdown_btn.value = "6"
		}
	}
}
function isDropDownBtnVisible() {
	if (typeof (_dropdown_btn) != "undefined") {
		return (_dropdown_btn.style.visibility == "visible")
	} else {
		return false
	}
}
function sizeDropDownBtn(_editor) {
	if (!isDropDownBtnVisible()) {
		return
	}
	with (_dropdown_btn) {
		var pos = getAbsPosition(_editor);
		style.height = _editor.offsetHeight - 2;
		style.width = 16;
		style.posLeft = pos[0] + _editor.offsetWidth - offsetWidth - 1;
		style.posTop = pos[1] + 1
	}
}
function showDropDownBtn(_editor) {
	if (!canDropDown(_editor)) {
		return
	}
	getDropDownBtn();
	if (typeof (_dropdown_btn) == "undefined") {
		return
	}
	with (_dropdown_btn) {
		if (!isDropDownBtnVisible()) {
			setAttribute("editor", _editor);
			style.visibility = "visible";
			sizeDropDownBtn(_editor);
			var oldWidth = _editor.offsetWidth;
			_editor.style.borderRightWidth = 18;
			_editor.style.width = oldWidth
		}
	}
}
function hideDropDownBtn() {
	if (typeof (_dropdown_btn) == "undefined") {
		return
	}
	if (isDropDownBtnVisible()) {
		var c = _dropdown_btn.editor;
		if (c) {
			var b = c.offsetWidth;
			c.style.borderRightWidth = 1;
			c.style.width = b
		}
		_dropdown_btn.style.visibility = "hidden";
		_dropdown_btn.editor = null
	}
}
function _dropdown_btn_onmousedown(b) {
	var c = b.editor;
	if (!isDropdownBoxVisible()) {
		if (c) {
			showDropDownBox(c)
		}
	} else {
		hideDropDownBox()
	}
}
function _dropdown_btn_onfocus(b) {
	var c = b.editor;
	if (c) {
		c.focus()
	}
}
function createListTable(b) {
	_dropdown_table = document
			.createElement("<table extra=datatable isDropDownTable=true readOnly=true width=100%  cellspacing=0 cellpadding=2 rules=all></table>");
	if (b) {
		b.appendChild(_dropdown_table)
	} else {
		document.body.appendChild(_dropdown_table)
	}
}
function dropDownLocate() {
	var d = _dropdown_parentbox.editor;
	var g = _dropdown_parentbox.dropDown;
	switch (g.type) {
	case "predate":
	case "postdate":
	case "date":
		var c = convertStr2Date_new(d.value);
		if (!isNaN(c)) {
			setCalendarDate(c)
		}
		break;
	default:
		if (_dropdown_dataset) {
			var f;
			if (g.type == "list") {
				f = (isTrue(g.mapValue)) ? "label" : "value"
			} else {
				f = g.dataField;
				if (!f) {
					f = d.getAttribute("dataField")
				}
			}
			var e = d.value;
			var b = _dropdown_dataset.locate(f, e);
			if (b) {
				_dropdown_dataset.setRecord(b)
			}
		}
		break
	}
}
function hideDropDown() {
	var b = _dropdown_parentbox.editor;
	_dropdown_parentwindow.hideDropDownBox();
	b.focus()
}
function _standard_dropdown_keyDown(c) {
	switch (c) {
	case 33:
		if (_dropdown_dataset) {
			var b = (_dropdown_dataset.record) ? _dropdown_dataset.record.pageIndex - 1
					: 1;
			_dropdown_dataset.moveToPage(b)
		}
		break;
	case 34:
		if (_dropdown_dataset) {
			var b = (_dropdown_dataset.record) ? _dropdown_dataset.record.pageIndex + 1
					: 1;
			_dropdown_dataset.moveToPage(b)
		}
		break;
	case 38:
		if (_dropdown_dataset) {
			_dropdown_dataset.movePrev()
		}
		break;
	case 40:
		if (_dropdown_dataset) {
			_dropdown_dataset.moveNext()
		}
		break
	}
}
function processDropDownKeyDown(b) {
	switch (b) {
	case 13:
		if (_dropdown_parentbox.dropDown.type == "date"
				|| _dropdown_parentbox.dropDown.type == "predate"
				|| _dropdown_parentbox.dropDown.type == "postdate") {
			var c = validateCalendarDateValue();
			if (c[0] == false) {
				alert(c[1]);
				return
			}
		}
		dropDownSelected();
		break;
	case 27:
		hideDropDown();
		break;
	case 113:
		hideDropDown();
		break;
	case 118:
		hideDropDown();
		break;
	default:
		switch (_dropdown_parentbox.dropDown.type) {
		case "list":
		case "dataset":
		case "dynamic":
			_standard_dropdown_keyDown(b);
			break;
		case "predate":
		case "postdate":
		case "date":
			_calendar_onkeydown();
			break;
		default:
			if (typeof (dropDown_onKeyDown) != "undefined") {
				dropDown_onKeyDown(b)
			}
			break
		}
	}
}
function dropDownSelected() {
	var b;
	switch (_dropdown_parentbox.dropDown.type) {
	case "list":
	case "dataset":
	case "dynamic":
		if (_dropdown_dataset) {
			b = _dropdown_dataset.record
		}
		if (typeof (b) == "undefined") {
			hideDropDown();
			break
		}
		if (_dropdown_parentbox.editor.value == b.getValue(0)) {
			hideDropDown();
			return
		}
		break;
	case "predate":
	case "postdate":
	case "date":
		_tmp_dataset_date = createDataset("_tmp_dataset_date");
		_tmp_dataset_date.addField("value");
		initDataset(_tmp_dataset_date);
		_tmp_dataset_date.insertRecord();
		_tmp_dataset_date.setValue("value", new Date(_calendarControl.year,
				_calendarControl.month, _calendarControl.day));
		_tmp_dataset_date.updateRecord();
		b = _tmp_dataset_date.record;
		break;
	default:
		if (typeof (dropDown_onGetRecord) != "undefined") {
			b = dropDown_onGetRecord()
		}
		break
	}
	if (b) {
		_dropdown_parentwindow.processDropDownSelected(
				_dropdown_parentbox.editor, b, false);
		hideDropDown()
	}
	if (_tmp_dataset_date) {
		freeDataset(_tmp_dataset_date)
	}
}
function _dropdown_onkeydown() {
	processDropDownKeyDown(event.keyCode)
}
function getDropDownItems(c) {
	var b = c._items;
	if (!b) {
		initDropDownItems(c);
		b = c._items
	}
	return b
}
function _initDropDownItems(j, g) {
	if (!j) {
		return null
	}
	var f = ";";
	var b = createDataset();
	b.id = "_dropDown_items";
	b.readOnly = true;
	if (g) {
		var h;
		h = b.addField("label");
		h = b.addField("value");
		h.visible = false;
		var e = j.split(f);
		var c;
		for ( var d = 0; d < e.length; d++) {
			c = e[d].indexOf("=");
			record = new Array();
			record[0] = getDecodeStr(e[d].substr(0, c));
			record[1] = getDecodeStr(e[d].substr(c + 1));
			pArray_insert(b, "end", null, record)
		}
	} else {
		b.addField("value");
		var e = j.split(f);
		for ( var d = 0; d < e.length; d++) {
			record = new Array();
			record[0] = getDecodeStr(e[d]);
			pArray_insert(b, "end", null, record)
		}
	}
	return b
}
function initDropDownItems(c) {
	if (!c.items) {
		return
	}
	var b = _initDropDownItems(c.items, isTrue(c.mapValue));
	if (!b) {
		return
	}
	initDataset(b);
	c._items = b
}
var _calendar_days;
function _calendar_year_onpropertychange() {
	if (!_calender_year.processing && event.propertyName == "value") {
		if (_calender_year.value.length == 4) {
			_calender_year.processing = true;
			changeCalendarDate(getInt(_calender_year.value),
					_calendarControl.month);
			_calender_year.processing = false
		}
	}
}
function _calendar_month_onpropertychange() {
	if (!_calender_month.processing && _activeElement == _calender_month
			&& event.propertyName == "value") {
		if (_calender_month.value.length > 0) {
			_calender_month.processing = true;
			changeCalendarDate(_calendarControl.year,
					getInt(_calender_month.value - 1));
			_calender_month.processing = false
		}
	}
}
function createCalendar(l, k, h) {
	function e() {
		var i = NaN;
		var j = NaN;
		if (h) {
			j = convertStr2Date_new(h.value)
		}
		if (typeof (_today_date) == "object") {
			i = _today_date
		} else {
			i = new Date()
		}
		if (isNaN(j)) {
			j = i
		}
		this.todayDay = i.getDate();
		this.todayMonth = i.getMonth();
		this.todayYear = i.getFullYear();
		this.activeCellIndex = 0;
		this.oldDate = j
	}
	if (typeof (CalendarTable) == "object") {
		CalendarTable.removeNode(true)
	}
	_calendar_days = new Array(constSunday, constMonday, constTuesday,
			constWednesday, constThursday, constFriday, constSaturday);
	_calendarControl = new e();
	_calendarControl.minDate = NaN;
	_calendarControl.maxDate = NaN;
	_calendarControl.editor = null;
	if (h) {
		_calendarControl.editor = h
	}
	if (k && k.dataType) {
		if (k.dataType == "predate") {
			_calendarControl.maxDate = new Date(_calendarControl.todayYear,
					_calendarControl.todayMonth, _calendarControl.todayDay - 1)
		} else {
			if (k.dataType == "postdate") {
				_calendarControl.minDate = new Date(_calendarControl.todayYear,
						_calendarControl.todayMonth,
						_calendarControl.todayDay + 1)
			}
		}
	}
	if (k && k.name && k.dataset && k.dataset.id) {
		var g = k.dataset.id + "_" + k.name + "_onInitCalendar";
		var c = fireUserEvent(g, [ _calendarControl, k ]);
		if (c) {
			throw c
		}
	}
	var b = "";
	b += '<TABLE id="CalendarTable" class="calendar" width=200px cellspacing=0 cellpadding=1 rule=all>';
	b += '<TR class="title" valign=top><TD>';
	b += "<TABLE WIDTH=100% CELLSPACING=1 CELLPADDING=0>";
	b += "<TR><TD align=right>";
	b += '<INPUT type=button extra=button value=3 title="'
			+ constLastYear
			+ '" style="FONT-SIZE:8;FONT-FAMILY:webdings;WIDTH:18px;HEIGHT:20px" onclick="changeCalendarDate(_calendarControl.year-1,_calendarControl.month)">';
	b += "</TD><TD width=40>";
	b += '<INPUT id="_calender_year" type=text class=editor size=4 maxlength=4 onpropertychange="return _calendar_year_onpropertychange()">';
	b += "</TD><TD align=left width=20px>";
	b += '<INPUT type=button extra=button value=4 title="'
			+ constNextYear
			+ '" style="FONT-SIZE:8;FONT-FAMILY:webdings;WIDTH:18px;HEIGHT:20px" onclick="changeCalendarDate(_calendarControl.year+1,_calendarControl.month)">';
	b += "</TD>";
	b += "<TD align=right width=20px>";
	b += '<INPUT type=button extra=button value=3 title="'
			+ constLastMonth
			+ '" style="FONT-SIZE:8;FONT-FAMILY:webdings;WIDTH:18px;HEIGHT:20px" onclick="changeCalendarDate(_calendarControl.preYear,_calendarControl.preMonth)">';
	b += "</TD><TD width=20>";
	b += '<INPUT id="_calender_month" type=text class=editor size=2 maxlength=2 onpropertychange="return _calendar_month_onpropertychange()">';
	b += "</TD><TD align=left>";
	b += '<INPUT type=button extra=button value=4 title="'
			+ constNextMonth
			+ '" style="FONT-SIZE: 8;FONT-FAMILY:webdings;WIDTH:18px;HEIGHT:20px" onclick="changeCalendarDate(_calendarControl.nextYear,_calendarControl.nextMonth)">';
	b += "</TD></TR>";
	b += "</TABLE></TD></TR>";
	b += "<TR><TD>";
	b += '<TABLE border=1 bordercolor=silver id="calendarData" HEIGHT=100% WIDTH=100% CELLSPACING=0 CELLPADDING=0 style="BORDER-COLLAPSE: collapse"';
	b += 'onclick="_calendar_cell_onclick(event.srcElement)">';
	b += '<TR height=20px style="background-image: url(' + _theme_root
			+ '/table_title.gif)">';
	for ( var f = 0; f <= 6; f++) {
		b += "<TD align=center>" + _calendar_days[f] + "</TD>"
	}
	b += "</TR>";
	for ( var f = 0; f <= 5; f++) {
		b += "<TR>";
		for ( var d = 0; d <= 6; d++) {
			b += "<TD align=center></TD>"
		}
		b += "</TR>"
	}
	b += "</TABLE></TD></TR>";
	b += '<TR class="footer"><TD align=right>';
	b += '<INPUT extra=button type=button id="button_today" value="'
			+ constToday + " " + _calendarControl.todayYear + "-"
			+ (_calendarControl.todayMonth + 1) + "-"
			+ _calendarControl.todayDay
			+ '" onclick="_calendar_today_onclick()"';
	b += "</TD></TR></TABLE>";
	if (l) {
		l.innerHTML = b
	} else {
		document.body.innerHTML = b
	}
	initElements(CalendarTable);
	changeCalendarDate(_calendarControl.oldDate.getFullYear(),
			_calendarControl.oldDate.getMonth(), _calendarControl.oldDate
					.getDate());
	if (h) {
		h.select()
	}
}
function setCalendarDate(b) {
	changeCalendarDate(b.getFullYear(), b.getMonth(), b.getDate())
}
function changeCalendarDate(j, h, k) {
	if (_calendarControl.year == j && _calendarControl.month == h
			&& (!k || _calendarControl.day == k)) {
		return
	}
	if (_calendarControl.year != j || _calendarControl.month != h) {
		_calendarControl.year = j;
		_calendarControl.month = h;
		if (h == 0) {
			_calendarControl.preMonth = 11;
			_calendarControl.preYear = _calendarControl.year - 1
		} else {
			_calendarControl.preMonth = _calendarControl.month - 1;
			_calendarControl.preYear = _calendarControl.year
		}
		if (h == 11) {
			_calendarControl.nextMonth = 0;
			_calendarControl.nextYear = _calendarControl.year + 1
		} else {
			_calendarControl.nextMonth = _calendarControl.month + 1;
			_calendarControl.nextYear = _calendarControl.year
		}
		_calendarControl.startday = (new Date(j, h, 1)).getDay();
		if (_calendarControl.startday == 0) {
			_calendarControl.startday = 7
		}
		var e = getNumberOfDays(_calendarControl.month, _calendarControl.year);
		var l = getNumberOfDays(_calendarControl.preMonth,
				_calendarControl.preYear);
		var d = getNumberOfDays(_calendarControl.nextMonth,
				_calendarControl.nextYear);
		var b = l - _calendarControl.startday + 1;
		var g = 42 - e - _calendarControl.startday;
		_calender_month.value = (_calendarControl.month + 1);
		_calender_year.innerText = _calendarControl.year;
		var o = 0;
		var c;
		for ( var f = b; f <= l; f++) {
			var m = calendarData.cells[o + 7];
			m.monthAttribute = "pre";
			m.className = "cell_trailing";
			m.innerText = f;
			c = new Date(_calendarControl.preYear, _calendarControl.preMonth, f);
			if (outTimeRange(_calendarControl.minDate,
					_calendarControl.maxDate, c)) {
				m.className = "cell_trailing_outrange"
			}
			o++
		}
		for ( var f = 1; f <= e; f++) {
			var m = calendarData.cells[o + 7];
			m.monthAttribute = "cur";
			if (o != _calendarControl.activeCellIndex) {
				m.className = "cell_day"
			}
			m.innerText = f;
			c = new Date(_calendarControl.year, _calendarControl.month, f);
			if (outTimeRange(_calendarControl.minDate,
					_calendarControl.maxDate, c)) {
				m.className = "cell_day_outrange"
			}
			o++
		}
		for ( var f = 1; f <= g; f++) {
			var m = calendarData.cells[o + 7];
			m.monthAttribute = "next";
			m.className = "cell_trailing";
			m.innerText = f;
			c = new Date(_calendarControl.nextYear, _calendarControl.nextMonth,
					f);
			if (outTimeRange(_calendarControl.minDate,
					_calendarControl.maxDate, c)) {
				m.className = "cell_trailing_outrange"
			}
			o++
		}
	}
	if (k) {
		_calendarControl.day = k
	}
	setCalendarActiveCell(calendarData.cells[_calendarControl.day
			+ _calendarControl.startday - 1 + 7])
}
function setCalendarActiveCell(cell) {
	function setActiveCell(cellIndex) {
		var cell = calendarData.cells[_calendarControl.activeCellIndex + 7];
		var tmpDate;
		with (_calendarControl) {
			if (cell.monthAttribute == "cur") {
				cell.className = "cell_day";
				tmpDate = new Date(year, month, activeCellIndex - startday + 1);
				if (outTimeRange(_calendarControl.minDate,
						_calendarControl.maxDate, tmpDate)) {
					cell.className = "cell_day_outrange"
				}
			} else {
				if (cell.monthAttribute == "pre") {
					cell.className = "cell_trailing";
					tmpDate = new Date(preYear, preMonth, getNumberOfDays(
							preMonth, preYear)
							- startday + activeCellIndex + 1);
					if (outTimeRange(_calendarControl.minDate,
							_calendarControl.maxDate, tmpDate)) {
						cell.className = "cell_trailing_outrange"
					}
				} else {
					cell.className = "cell_trailing";
					tmpDate = new Date(nextYear, nextMonth, activeCellIndex
							- getNumberOfDays(month, year) - startday + 1);
					if (outTimeRange(_calendarControl.minDate,
							_calendarControl.maxDate, tmpDate)) {
						cell.className = "cell_trailing_outrange"
					}
				}
			}
		}
		var cell = calendarData.cells[cellIndex + 7];
		cell.className = "cell_selected";
		_calendarControl.activeCellIndex = cellIndex
	}
	function setEditorValue(year, month, day) {
		with (_calendarControl) {
			if (editor) {
				var _date = convertStr2Date_new(editor.value);
				if (!isNaN(_date) && _date.getFullYear() == year
						&& _date.getMonth() == month && _date.getDate() == day) {
					return
				}
				editor.value = year + "-" + (month + 1) + "-" + day
			}
		}
	}
	if (cell.tagName.toLowerCase() != "td") {
		return false
	}
	var _activeCellIndex = cell.parentElement.rowIndex * 7 + cell.cellIndex - 7;
	with (_calendarControl) {
		if (activeCellIndex == _activeCellIndex) {
			return true
		}
		var monthAttribute = cell.monthAttribute;
		switch (monthAttribute) {
		case "pre":
			changeCalendarDate(preYear, preMonth, getNumberOfDays(preMonth,
					preYear)
					- startday + _activeCellIndex + 1);
			setActiveCell(startday + day - 1);
			setEditorValue(preYear, preMonth,
					getNumberOfDays(preMonth, preYear) - startday
							+ _activeCellIndex + 1);
			break;
		case "cur":
			changeCalendarDate(year, month, _activeCellIndex - startday + 1);
			setActiveCell(_activeCellIndex);
			setEditorValue(year, month, _activeCellIndex - startday + 1);
			break;
		case "next":
			changeCalendarDate(nextYear, nextMonth, _activeCellIndex
					- getNumberOfDays(month, year) - startday + 1);
			setActiveCell(startday + day - 1);
			setEditorValue(nextYear, nextMonth, _activeCellIndex
					- getNumberOfDays(month, year) - startday + 1);
			break
		}
	}
	return true
}
function _calendar_cell_onclick(b) {
	setCalendarActiveCell(b);
	var c = validateCalendarDateValue();
	if (c[0] == false) {
		return
	}
	dropDownSelected()
}
function _calendar_onkeydown() {
	switch (event.keyCode) {
	case 33:
		if (event.ctrlKey) {
			changeCalendarDate(_calendarControl.year - 1,
					_calendarControl.month)
		} else {
			changeCalendarDate(_calendarControl.preYear,
					_calendarControl.preMonth)
		}
		break;
	case 34:
		if (event.ctrlKey) {
			changeCalendarDate(_calendarControl.year + 1,
					_calendarControl.month)
		} else {
			changeCalendarDate(_calendarControl.nextYear,
					_calendarControl.nextMonth)
		}
		break;
	case 35:
		var c = getNumberOfDays(_calendarControl.month, _calendarControl.year)
				+ _calendarControl.startday - 1;
		setCalendarActiveCell(calendarData.cells[c + 7 + 7]);
		break;
	case 36:
		setCalendarActiveCell(calendarData.cells[_calendarControl.startday + 7 + 7]);
		break;
	case 37:
		var c = _calendarControl.activeCellIndex - 1;
		if (c < 0) {
			c = 0
		}
		setCalendarActiveCell(calendarData.cells[c + 7]);
		break;
	case 38:
		if (_calendarControl.activeCellIndex < 14) {
			var b = getNumberOfDays(_calendarControl.preMonth,
					_calendarControl.preYear)
					+ _calendarControl.day - 7;
			setCalendarDate(new Date(_calendarControl.preYear,
					_calendarControl.preMonth, b))
		} else {
			var c = _calendarControl.activeCellIndex - 7;
			setCalendarActiveCell(calendarData.cells[c + 7])
		}
		break;
	case 39:
		var c = _calendarControl.activeCellIndex + 1;
		if (c >= calendarData.cells.length - 7) {
			c = calendarData.cells.length - 8
		}
		setCalendarActiveCell(calendarData.cells[c + 7]);
		break;
	case 40:
		if (_calendarControl.activeCellIndex > 34) {
			var b = 7 - (getNumberOfDays(_calendarControl.month,
					_calendarControl.year) - _calendarControl.day);
			setCalendarDate(new Date(_calendarControl.nextYear,
					_calendarControl.nextMonth, b))
		} else {
			var c = _calendarControl.activeCellIndex + 7;
			setCalendarActiveCell(calendarData.cells[c + 7])
		}
		break
	}
}
function _calendar_today_onclick() {
	var c = validateCalendarDateValue(_calendarControl.todayYear,
			_calendarControl.todayMonth, _calendarControl.todayDay);
	if (c[0] == false) {
		alert(c[1]);
		return
	}
	changeCalendarDate(_calendarControl.todayYear, _calendarControl.todayMonth,
			_calendarControl.todayDay);
	var b = _calendarControl.todayDay + _calendarControl.startday - 1;
	setCalendarActiveCell(calendarData.cells[b + 7]);
	dropDownSelected()
}
function getNumberOfDays(d, c) {
	var b = new Array(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31);
	n = b[d];
	if (d == 1 && (c % 4 == 0 && c % 100 != 0 || c % 400 == 0)) {
		n++
	}
	return n
}
function outTimeRange(e, f, d) {
	var c, b;
	if (e && d < e) {
		c = true
	} else {
		c = false
	}
	if (f && d > f) {
		b = true
	} else {
		b = false
	}
	if (e > f) {
		return c == b
	} else {
		return c != b
	}
}
function getTimeRangeDesc(e, f) {
	var b;
	var c;
	var d;
	if (!e && !f) {
		b = ""
	} else {
		if (e && f) {
			if (e > f) {
				b = constDateTimeRangeMultiple.replace("%s1", f.getFullYear()
						+ "/" + (f.getMonth() + 1) + "/" + f.getDate());
				b = b.replace("%s2", e.getFullYear() + "/" + (e.getMonth() + 1)
						+ "/" + e.getDate())
			} else {
				if (e < f) {
					b = constDateTimeRangeSingle.replace("%s1", e.getFullYear()
							+ "/" + (e.getMonth() + 1) + "/" + e.getDate());
					b = b.replace("%s2", f.getFullYear() + "/"
							+ (f.getMonth() + 1) + "/" + f.getDate())
				} else {
					b = constDateTimeRangeUnique.replace("%s", f.getFullYear()
							+ "/" + (f.getMonth() + 1) + "/" + f.getDate())
				}
			}
		} else {
			if (e) {
				b = constDateTimeRangeLeft.replace("%s", e.getFullYear() + "/"
						+ (e.getMonth() + 1) + "/" + e.getDate())
			} else {
				b = constDateTimeRangeRight.replace("%s", f.getFullYear() + "/"
						+ (f.getMonth() + 1) + "/" + f.getDate())
			}
		}
	}
	return b
}
function validateCalendarDateValue(e, f, d) {
	var b = new Array();
	b[0] = true;
	if (!_calendarControl) {
		return b
	}
	if (!e) {
		e = _calendarControl.year
	}
	if (!f) {
		f = _calendarControl.month
	}
	if (!d) {
		d = _calendarControl.day
	}
	var c = new Date(e, f, d);
	if (isNaN(c)) {
		b[0] = false;
		b[1] = constErrTypeDate
	} else {
		if (outTimeRange(_calendarControl.minDate, _calendarControl.maxDate, c)) {
			b[0] = false;
			b[1] = constDateTimeOutRange
					+ " "
					+ getTimeRangeDesc(_calendarControl.minDate,
							_calendarControl.maxDate)
		}
	}
	return b
}
function dropDownClear() {
	var b;
	switch (_dropdown_parentbox.dropDown.type) {
	case "dynamic":
		if (_dropdown_dataset) {
			b = _dropdown_dataset.record
		}
		if (typeof (b) == "undefined") {
			break
		}
		_dropdown_parentbox.editor.value = "";
		break;
	default:
		break
	}
	if (b) {
		_dropdown_parentwindow.processDropDownSelectedClear(
				_dropdown_parentbox.editor, b)
	}
}
function _initDropDown(g, v, m, h, u, j, d, p, s, l, f) {
	var b = getDropDownByID(v);
	if (typeof (b) == "undefined" || b == null) {
		if (m.length > 0 && m.substring(m.length - 1, m.length) == ";") {
			m = m.substring(0, m.length - 1)
		}
		if (l != "true") {
			m = ";" + m
		}
	}
	var o = getDatasetByID(g);
	if (typeof (o) == "undefined" || o == null) {
		var e = createDataset(g, "", m), k;
		e.readOnly = s;
		e.pageSize = 1000;
		e.pageIndex = 1;
		e.pageCount = 1;
		e.masterDataset = "";
		e.type = "dropdown";
		e.references = "";
		e.submitData = "allchange";
		e.autoLoadPage = true;
		e.autoLoadDetail = true;
		e.downloadUrl = getDecodeStr("~2fextraservice~2fdownloaddata");
		e.sessionKey = "";
		e.insertOnEmpty = false;
		e.tag = "";
		e.initDocumentFlag = false;
		if (h) {
			var t = h;
			var q = t.split(",");
			for ( var r = 0; r < q.length; r++) {
				k = e.addField(q[r], "string");
				k.label = u;
				k.size = 0;
				k.scale = 0;
				k.readOnly = false;
				k.required = false;
				k.nullable = true;
				k.defaultValue = getDecodeStr("");
				k.updatable = true;
				k.valueProtected = false;
				k.visible = true;
				k.autoGenId = false;
				k.tableName = "";
				k.fieldName = q[r].split("=")[1];
				k.tag = "";
				k.editorType = "";
				k.dropDown = "";
				k.mask = getDecodeStr("");
				k.maskErrorMessage = getDecodeStr("");
				k.toolTip = getDecodeStr("");
				k.lobDownloadURL = getDecodeStr("");
				k.lobPopupURL = getDecodeStr("")
			}
		}
		initDataset(e);
		var c = createDropDown(v);
		if (f) {
			c.type = f
		} else {
			c.type = "list"
		}
		c.cache = true;
		c.fixed = true;
		c.fieldMap = j;
		c.autoDropDown = true;
		c.editable = true;
		if (p && p != "") {
			c.height = p
		} else {
			c.height = 0
		}
		c.tag = "";
		c.dataset = g;
		c.fields = d;
		c.showHeader = false;
		initDropDown(c)
	} else {
	}
}
function _initDropDown_cust1(e, f, g, i, c, h, j) {
	var b = getDropDownByID(f);
	if (typeof (b) == "undefined" || b == null) {
		var d = createDropDown(f);
		d.type = g;
		d.cache = true;
		d.fixed = true;
		d.fieldMeta = "";
		d.fieldMap = i;
		d.sessionKey = "dd";
		d.autoDropDown = true;
		d.editable = true;
		d.tag = "";
		d.viewType = c;
		d.dataset = e;
		d.fields = h;
		d.showHeader = false;
		if (j != "") {
			d.height = j
		} else {
			d.height = 0
		}
		initDropDown(d)
	} else {
	}
}
function _initDropDown_cust2(g, i, h, l, j, m, o, b, d) {
	var e = getDropDownByID(i);
	if (typeof (e) == "undefined" || e == null) {
		var c = createDataset(g, "", "");
		var k;
		c.readOnly = l;
		c.pageSize = 1000;
		c.pageIndex = 1;
		c.pageCount = 1;
		c.masterDataset = "";
		c.type = j;
		c.references = "";
		c.submitData = "allchange";
		c.autoLoadPage = true;
		c.autoLoadDetail = true;
		c.downloadUrl = getDecodeStr("~2fextraservice~2fdownloaddata");
		c.sessionKey = "";
		c.insertOnEmpty = false;
		c.tag = "";
		initDataset(c);
		var f = createDropDown(i);
		f.type = j;
		f.cache = true;
		f.fixed = true;
		f.fieldMeta = "";
		f.fieldMap = m;
		f.sessionKey = "dd";
		f.autoDropDown = true;
		f.editable = true;
		f.tag = "";
		f.url = b;
		f.targetDataset = h;
		f.dataset = g;
		f.fieldId = d;
		if (o != "") {
			f.height = o
		} else {
			f.height = 0
		}
		initDropDown(f)
	} else {
	}
}
function exporter(c, b) {
	this.CSV = "CSV";
	this.canExpCsv = false;
	this.csvImage = "/images/csv_image_export.gif";
	this.DOC = "DOC";
	this.canExpDoc = false;
	this.docImage = "/images/doc_image_export.gif";
	this.XLS = "XLS";
	this.canExpXls = false;
	this.xlsImage = "/images/xls_image_export.gif";
	this.PDF = "PDF";
	this.canExpPdf = false;
	this.pdfImage = "/images/pdf_image_export.gif";
	this.HTML = "HTML";
	this.canExpHtml = false;
	this.htmlImage = "/images/html_image_export.gif";
	this.downloadURL = c;
	this.isLimit = b;
	this.dataSet = null;
	this.dataSetInterface = null;
	this.target = "xxxxxxxxxxx";
	this.expDiv = null;
	this.expType = this.CSV;
	this.contentPath = "";
	this.div_els = null;
	this.setContentPath = function(d) {
		this.contentPath = d
	};
	this.setDataSet = function(d) {
		this.dataSet = d
	};
	this.setDataSetInterface = function(d) {
		this.dataSetInterface = d
	};
	this.setDivEls = function(d) {
		this.div_els = d
	};
	this.setCanExpCsv = function(d, e) {
		if (d != null) {
			this.canExpCsv = d
		}
		if (e != null && e != "undefined") {
			this.csvImage = e
		}
	};
	this.setCanExpDoc = function(d, e) {
		if (d != null) {
			this.canExpDoc = d
		}
		if (e != null && e != "undefined") {
			this.docImage = e
		}
	};
	this.setCanExpXls = function(d, e) {
		if (d != null) {
			this.canExpXls = d
		}
		if (e != null && e != "undefined") {
			this.xlsImage = e
		}
	};
	this.setCanExpPdf = function(d, e) {
		if (d != null) {
			this.canExpPdf = d
		}
		if (e != null && e != "undefined") {
			this.pdfImage = e
		}
	};
	this.setCanExpHtml = function(d, e) {
		if (d != null) {
			this.canExpHtml = d
		}
		if (e != null && e != "undefined") {
			this.htmlImage = e
		}
	};
	this.setExpWinId = function(e, d) {
		this.expwinid = e;
		this.errdivid = d
	};
	this.openExpWin = function(e) {
		this.expType = e;
		if (this.isLimit) {
			if (!this.expWin) {
				this.expWin = $(this.expwinid).show();
				var d = this;
				this.expWin.dialog({
					width : 400,
					title : d.expWin.attr("buttontext"),
					modal : true,
					buttons : [ {
						text : d.expWin.attr("buttontext"),
						iconCls : "icon-export",
						handler : function() {
							var g = d.download();
							if (g) {
								d.expWin.dialog("close")
							}
						}
					} ]
				});
				var f = document.getElementsByName(this.target);
				if (!f || !f[0]) {
					f = $("<iframe name='" + this.target + "'></iframe>")
							.hide().appendTo("body")[0]
				}
				if ($.data(this.expWin[0], "window").mask) {
					$.data(this.expWin[0], "window").mask.click(function() {
						d.expWin.dialog("close")
					})
				}
			}
			this.expWin.dialog("open");
			this.expWin.dialog("center")
		} else {
			this.download()
		}
	};
	this.openLimitDiv = this.openExpWin;
	this.setNewDivId = function(d, f, e) {
		if (this.expDiv == null || this.expDiv == "undefined") {
			this.expDiv = new openDivWindow()
		}
		this.expDiv.setNewDivId(d, f, e)
	};
	this.getPageSize = function() {
		var d = getDatasetByID(this.dataSet);
		return d.pageCount
	};
	this.checkDivEl = function(e, d) {
		var f = $("input[name=" + e.na + "]").get(0);
		var g = $("#a_p")[0].checked;
		if (!g) {
			if (e.rule != null && e.rule != "" && e.rule != "undefined") {
				if (f.value == "" || (!e.rule(f.value))) {
					$(this.errdivid).html(e.err);
					return false
				}
			}
			if (e.maxChk != null && e.maxChk != "" && e.maxChk != "undefined") {
				if (f.value == "" || (!e.maxChk(f.value, d))) {
					$(this.errdivid).html(e.err);
					return false
				}
			}
		}
		return true
	};
	this.download = function() {
		var g = getDatasetByID(this.dataSet);
		$(this.errdivid).empty();
		var m = document.getElementById("exp_download");
		if (m == null || m == "undefined") {
			m = document.createElement("DIV");
			m.id = "exp_download";
			m.style.visibility = "hidden"
		}
		m.innerHTML = "";
		document.body.appendChild(m);
		var e = document.createElement("FORM");
		e.method = "post";
		e.action = this.contentPath + this.downloadURL;
		e.style.visibility = "hidden";
		e.target = this.target;
		var t = getDatasetByID(this.dataSetInterface);
		if (t) {
			copyDateSetParameter(t, g);
			g.setParameter("everyPage", g.pageSize);
			g.setParameter("nextPage", g.pageIndex);
			for ( var l = 0; l < t.fields.fieldCount; l++) {
				e.insertAdjacentHTML("beforeEnd", '<input type="hidden" name="'
						+ t.getField(l).fieldName + '" value="'
						+ t.getString(l) + '"/>')
			}
		}
		var p, d;
		for ( var l = 0; l < g.parameters.length; l++) {
			p = g.parameters[l].name;
			d = g.parameters[l].value;
			if (d != null) {
				if (e[p]) {
					continue
				}
				e.insertAdjacentHTML("beforeEnd", '<input type="hidden" name="'
						+ p + '" value="' + d + '"/>')
			}
		}
		var o = arguments.length < 1 && this.isLimit;
		if (o) {
			for (l = 0; l < this.div_els.length; l++) {
				var f = this.div_els[l];
				var s = document.getElementsByName(f.na)[0];
				if (!this.checkDivEl(f, g.pageCount)) {
					return false
				}
				if (f.type == "checkbox" && (!s.checked)) {
					continue
				}
				if ("mulSelect" == f.type) {
					var h = "";
					var q = document.getElementsByName(f.na);
					for ( var k = 0; k < q.length; k++) {
						if (q[k].checked) {
							if (h == "") {
								h = q[k].value
							} else {
								h = h + "," + q[k].value
							}
						}
					}
					e.insertAdjacentHTML("beforeEnd",
							'<input type="hidden" name="' + f.na + '" value="'
									+ getEncodeStr(h) + '"/>')
				} else {
					e.insertAdjacentHTML("beforeEnd",
							'<input type="hidden" name="' + f.na + '" value="'
									+ getEncodeStr(s.value) + '"/>')
				}
			}
		} else {
			if (arguments.length == 7) {
				this.expType = arguments[0];
				var r = this.dataSet.substring(0, this.dataSet.length - 8);
				e.insertAdjacentHTML("beforeEnd", '<input type="hidden" name="'
						+ r + '_expAll" value="' + (arguments[1] ? 1 : 0)
						+ '"/>');
				e.insertAdjacentHTML("beforeEnd", '<input type="hidden" name="'
						+ r + '_complex" value="' + (arguments[2] ? 1 : 0)
						+ '"/>');
				e.insertAdjacentHTML("beforeEnd", '<input type="hidden" name="'
						+ r + '_expElements" value="'
						+ getEncodeStr(arguments[3]) + '"/>');
				e.insertAdjacentHTML("beforeEnd", '<input type="hidden" name="'
						+ r + '_startPage" value="' + arguments[4] + '"/>');
				e.insertAdjacentHTML("beforeEnd", '<input type="hidden" name="'
						+ r + '_endPage" value="' + arguments[5] + '"/>');
				e.insertAdjacentHTML("beforeEnd", '<input type="hidden" name="'
						+ r + '_allPage" value="' + (arguments[6] ? 1 : 0)
						+ '"/>')
			}
		}
		e.insertAdjacentHTML("beforeEnd",
				'<input type="hidden" name="expType" value="' + this.expType
						+ '"/>');
		m.appendChild(e);
		e.submit();
		return true
	}
}
exporter.checkPageNumber = function(c, b) {
	if (c < 1 || c > b) {
		return false
	}
	return true
};
function checkAllpage(d, c, b) {
	c.disabled = b.disabled = d.checked
}
function checkExpall(e, d, c, b) {
	d.disabled = !e.checked;
	c.disabled = b.disabled = e.checked && d.checked
}
function mulSelect(b) {
	this.els_name = b;
	this.selected_label = null;
	this.selected_checkbox = null;
	this.selectedNode = function(f, g) {
		var d = document.getElementById(g);
		if (d.className == "nock") {
			d.className = "cked";
			this.selected_label = g;
			this.selected_checkbox = f;
			var h = document.getElementsByName(this.els_name);
			for ( var e = 0; e < h.length; e++) {
				var c = h[e].parentNode;
				if (c.id != g) {
					c.className = "nock"
				}
			}
		} else {
			d.className = "nock";
			this.selected_label = null;
			this.selected_checkbox = null
		}
	};
	this.up = function() {
		if (this.selected_label == null) {
			return false
		}
		var c = "";
		var e = document.getElementById(this.selected_label);
		var d = e.previousSibling;
		if (d == null || d == "undefined") {
			return false
		}
		c = e.innerHTML;
		tempClassName = e.className;
		tempId = e.id;
		e.innerHTML = d.innerHTML;
		e.className = d.className;
		e.id = d.id;
		d.innerHTML = c;
		d.className = tempClassName;
		d.id = tempId;
		return true
	};
	this.down = function() {
		if (this.selected_label == null) {
			return false
		}
		var c = "";
		var g = "";
		var d = "";
		var f = document.getElementById(this.selected_label);
		var e = f.nextSibling;
		if (e == null || e == "undefined") {
			return false
		}
		c = f.innerHTML;
		g = f.className;
		d = f.id;
		f.innerHTML = e.innerHTML;
		f.className = e.className;
		f.id = e.id;
		e.innerHTML = c;
		e.className = g;
		e.id = d;
		return true
	}
}
function openDivWindow() {
	this.mask_div_id = "mask_div_id";
	this.new_Div_id = "newWinFrame";
	this.err_div_id = "expErrDiv";
	this.newDivCenter = function() {
		var c = document.getElementById(this.mask_div_id);
		_scrollWidth = document.compatMode == "BackCompat" ? Math.max(
				document.body.scrollWidth, document.body.clientWidth) : Math
				.max(document.documentElement.scrollWidth,
						document.documentElement.clientWidth);
		_scrollHeight = document.compatMode == "BackCompat" ? Math.max(
				document.body.scrollHeight, document.body.clientHeight) : Math
				.max(document.documentElement.scrollHeight,
						document.documentElement.clientHeight);
		c.style.width = _scrollWidth + "px";
		c.style.height = _scrollHeight + "px";
		c.style.filter = "alpha(opacity=60)";
		c.style.opacity = "0.6";
		c.style.backgroundColor = "#EEEEEE";
		c.style.zIndex = 1001;
		var b = document.getElementById(this.new_Div_id);
		b.style.top = ($(window).height() - $(exp_file_div).height()) / 2
				+ $(document).scrollTop() + "px";
		b.style.left = ($(window).width() - $(exp_file_div).width()) / 2
				+ $(document).scrollLeft() + "px"
	};
	this.setNewDivId = function(b, d, c) {
		this.mask_div_id = b;
		this.new_Div_id = d;
		this.err_div_id = c
	};
	this.closeWin = function() {
		var b = openDivWindow.docEle(this.new_Div_id);
		var c = openDivWindow.docEle(this.mask_div_id);
		b.style.display = "none";
		c.style.display = "none";
		document.body.scroll = "yes";
		return false
	};
	this.openNewWindow = function() {
		var b = openDivWindow.docEle(this.new_Div_id);
		var c = openDivWindow.docEle(this.mask_div_id);
		b.style.display = "inline";
		c.style.display = "inline"
	}
}
openDivWindow.docEle = function() {
	return document.getElementById(arguments[0]) || false
};
function _initPagePilot(c) {
	c.refresh = _pagePilot_refresh;
	var b = getElementDataset(c);
	if (b) {
	}
	c.refresh()
}
function refreshPagePilot(b) {
	b.refresh()
}
function pageCacheToPage(d, b) {
	var c = getElementDataset(d);
	c.moveToPage(b);
	c.pageIndex = b;
	refreshPagePilot(d)
}
function _pagePilot_refresh() {
	var h = this;
	function b(m, o, i) {
		if (o == c.pageIndex) {
			m.innerHTML = "<b>" + o + "</b>"
		} else {
			var p = h.pageCache;
			if (isTrue(p)) {
				m.innerHTML = '<span onclick="javascript:pageCacheToPage('
						+ h.id + "," + o
						+ ")\" style='cursor:hand'><font COLOR='blue'><u>" + o
						+ "</u></font></span>"
			} else {
				m.innerHTML = '<span onclick="javascript:' + c.id
						+ ".flushData(" + o
						+ ")\" style='cursor:hand'><font COLOR='blue'><u>" + o
						+ "</u></font></span>"
			}
		}
	}
	var h = this;
	var c = getElementDataset(h);
	if (c) {
		var l = h.tBodies[0].rows[0];
		if (l) {
			l.removeNode(true)
		}
		var e = getInt(h.maxPageLink);
		var j = c.pageIndex - getInt(e / 2);
		if (j > (c.pageCount - e + 1)) {
			j = c.pageCount - e + 1
		}
		if (j < 1) {
			j = 1
		}
		var f = j + e - 1;
		if (f > c.pageCount) {
			f = c.pageCount
		}
		l = h.tBodies[0].insertRow();
		if (j > 1) {
			var k = l.insertCell();
			b(k, 1, c.pageIndex);
			if (j > 2) {
				var k = l.insertCell();
				k.innerHTML = "..."
			}
		}
		for ( var d = j; d <= f; d++) {
			var k = l.insertCell();
			b(k, d, c.pageIndex)
		}
		if (f < c.pageCount) {
			if (f < c.pageCount - 1) {
				var k = l.insertCell();
				k.innerHTML = "..."
			}
			var k = l.insertCell();
			b(k, c.pageCount, c.pageIndex)
		}
		var k = l.insertCell();
		k.innerHTML = " ";
		var k = l.insertCell();
		k.innerHTML = " ";
		var g = c.ExpFileDiv;
		if (g && g.canExpCsv) {
			var k = l.insertCell();
			k.innerHTML = '<a href="#" onClick="'
					+ c.id
					+ '_exporter.openLimitDiv(\'CSV\');"><img style="BORDER: 0px;" src="'
					+ g.contentPath + g.csvImage + '" title="' + constCSVExport
					+ '"/></a>'
		}
		if (g && g.canExpXls) {
			var k = l.insertCell();
			k.innerHTML = '<a href="#" onClick="'
					+ c.id
					+ '_exporter.openLimitDiv(\'XLS\');"><img style="BORDER: 0px;" src="'
					+ g.contentPath + g.xlsImage + '" title="' + constXLSExport
					+ '"/></a>'
		}
		if (g && g.canExpPdf) {
			var k = l.insertCell();
			k.innerHTML = '<a href="#" onClick="'
					+ c.id
					+ '_exporter.openLimitDiv(\'PDF\');"><img style="BORDER: 0px;" src="'
					+ g.contentPath + g.pdfImage + '" title="' + constPDFExport
					+ '"/></a>'
		}
	}
}
function RadioRender(c) {
	RadioRender._array_radio[RadioRender._array_radio.length] = this;
	var j = c;
	var i = undefined;
	var g = undefined;
	var f = undefined;
	var m = undefined;
	var b = undefined;
	var e = undefined;
	var d = undefined;
	var k = new Array();
	var l;
	var h = 0;
	this.type;
	this.fields;
	this.table;
	this.require;
	this.getDataset = function() {
		if (typeof (g) == "string") {
			g = getDatasetByID(g)
		}
		return g
	};
	this.getTargetDataset = function() {
		if (typeof (d) == "string") {
			d = getDatasetByID(d)
		}
		return d
	};
	this.getRadioValueField = function() {
		return f
	};
	this.getRadioViewField = function() {
		return m
	};
	this.getValueField = function() {
		return e
	};
	this.getViewField = function() {
		return b
	};
	this.setDataset = function(o) {
		g = o
	};
	this.setTargetDataset = function(o) {
		d = o
	};
	this.setHiddenRadioBox = function(o) {
		l = o
	};
	this.getRowLen = function() {
		return h
	};
	this.setRowLen = function(o) {
		h = o
	};
	this.setFieldMap = function(r) {
		i = r;
		if (!i) {
			return
		}
		var s = i.split(";");
		if (s.length < 2) {
			return
		}
		var t = s[0];
		var p = s[1];
		var o = t.split("=");
		var q = p.split("=");
		if (o.length < 2 || q.length < 2) {
			return
		}
		e = o[0];
		f = o[1];
		b = q[0];
		m = q[1]
	};
	this.getId = function() {
		return j
	};
	this.addRadioBox = function(o) {
		if (o.isHidden()) {
			o.setName(j + "render_hidden");
			l = o
		} else {
			k.push(o);
			o.setName(j + "render" + k.length)
		}
	};
	this.showRadioRenderBox = function(p) {
		if (!p) {
			return
		}
		if (!l) {
			var o = new RadioBox(this, true);
			this.addRadioBox(o)
		}
		l.showHiddenRadioBox(p)
	};
	this.hideRadioRenderBox = function() {
		if (l) {
			l.hide()
		}
	};
	this.getRadioNameValue = function(r) {
		var o = "";
		var q = this.getDataset();
		var p = q.firstUnit;
		while (p) {
			if (p.getValue(f) == r) {
				o = p.getValue(m);
				break
			}
			p = p.nextUnit
		}
		return o
	};
	this.selRadioFromRecord = function(o) {
		if (o) {
			var q = o.getValue(e);
			for ( var r = 0; r < k.length; r++) {
				var p = k[r];
				p.selRadio(q)
			}
			if (l) {
				l.selRadio(q)
			}
		}
	};
	this.sizeRadioBox = function() {
		if (l) {
			l.size()
		}
	};
	this.setReadOnly = function(p) {
		for ( var q = 0; q < k.length; q++) {
			var o = k[q];
			if (o) {
				o.setReadOnly(p)
			}
		}
	}
}
function RadioBox(b, p) {
	var q;
	var l = false;
	var f = undefined;
	var s = false;
	var g = 0;
	if (typeof (p) == "boolean") {
		s = p
	}
	var h = RadioRender.getRadio(b);
	if (typeof (h) == "object") {
		g = h.getRowLen()
	}
	function d(t) {
		if (!h) {
			return
		}
		var v = h.getRadioValueField();
		if (!v) {
			return
		}
		var w = h.getRadioViewField();
		if (!w) {
			return
		}
		var u = document.createElement("<input type='radio' value='"
				+ t.getValue(v) + "' name='" + q + "'/>");
		u.onclick = m;
		u.onmouseup = c;
		u.label = t.getValue(w);
		return u
	}
	function k(t) {
		if (!h) {
			return
		}
		var v = h.getRadioViewField();
		if (!v) {
			return
		}
		var u = document.createElement("<front></front>");
		u.innerText = t.getValue(v);
		return u
	}
	function j() {
		var t = document.createElement("<br></br>");
		return t
	}
	function o(t) {
		f = document
				.createElement("<div style='diplay:none;position:absolute;'></div>");
		f.style.zIndex = 1000;
		f.style.textAlign = "left";
		document.body.appendChild(f);
		f.radio = h.getId()
	}
	function m() {
		return false
	}
	function c() {
		var t = event.srcElement;
		if (f && f.valueHolder) {
			if (t.checked) {
				t.checked = false;
				f.valueHolder.value = "";
				i()
			} else {
				t.checked = true;
				f.valueHolder.value = t.value;
				r(t)
			}
		}
	}
	function r(u) {
		var w = h.getTargetDataset();
		var t = h.getValueField();
		var v = h.getViewField();
		if (w && t && v) {
			w.setValue(t, u.value);
			w.setValue(v, u.label)
		}
	}
	function i() {
		var v = h.getTargetDataset();
		var t = h.getValueField();
		var u = h.getViewField();
		if (v && t && u) {
			v.setValue(t, "");
			v.setValue(u, "")
		}
	}
	function e(u) {
		if (f) {
			for ( var t = 0; t < f.children.length; t++) {
				var v = f.children[t];
				if (compareText(v.tagName, "input")) {
					if (v.value == u) {
						v.checked = true
					} else {
						v.checked = false
					}
				}
			}
		}
	}
	this.getName = function() {
		return q
	};
	this.setName = function(t) {
		q = t
	};
	this.isHidden = function() {
		return s
	};
	this.setContainer = function(t) {
		f = t;
		if (compareText(f.parentElement.tagName.toLowerCase(), "td")) {
			f.valueHolder = f.parentElement.children[0]
		}
		f.radio = h.getId()
	};
	this.init = function() {
		if (typeof (h) == "undefined") {
			return
		}
		if (!q || !f) {
			return
		}
		f.innerHTML = "";
		f.contentEditable = false;
		var t, u, v = 1;
		u = h.getDataset();
		t = u.firstUnit;
		while (t) {
			f.appendChild(d(t));
			f.appendChild(k(t));
			if (!s && g != 0 && v % g == 0) {
				f.appendChild(j())
			}
			t = t.nextUnit;
			v++
		}
		l = true
	};
	this.showHiddenRadioBox = function(v) {
		if (!v || !h || !s) {
			return
		}
		if (!f) {
			o()
		}
		if (l == false) {
			this.init()
		}
		f.style.posLeft = v.style.posLeft;
		f.style.posTop = v.style.posTop;
		f.style.width = v.offsetWidth;
		f.style.backgroundColor = "white";
		f.style.display = "";
		f.style.border = "dimgray 1px solid";
		f.valueHolder = v;
		if (f.offsetHeight < f.valueHolder.offsetHeight) {
			f.style.height = f.valueHolder.offsetHeight
		}
		RadioRender._dockRadioBox = f;
		var w = getElementDataset(f.valueHolder);
		var u = h.getValueField();
		if (w && u) {
			var t = w.getValue(u);
			e(t)
		}
	};
	this.hide = function() {
		if (f) {
			f.style.display = "none";
			RadioRender._dockRadioBox = undefined
		}
	};
	this.selRadio = e;
	this.size = function() {
		if (f && f.valueHolder) {
			f.style.width = f.valueHolder.offsetWidth;
			if (f.offsetHeight < f.valueHolder.offsetHeight) {
				f.style.height = f.valueHolder.offsetHeight
			}
			f.style.posLeft = f.valueHolder.style.posLeft;
			f.style.posTop = f.valueHolder.style.posTop
		}
	};
	this.setReadOnly = function(t) {
		if (f) {
			for ( var u = 0; u < f.children.length; u++) {
				var v = f.children[u];
				if (compareText(v.tagName, "input")) {
					v.disabled = t
				}
			}
		}
	}
}
RadioRender._array_radio = new Array();
RadioRender.getRadioById = function(d) {
	for ( var c = 0; c < this._array_radio.length; c++) {
		if (this._array_radio[c].getId() == d) {
			return this._array_radio[c]
		}
	}
	var b;
	return b
};
RadioRender._dockRadioBox = undefined;
RadioRender.getRadio = function(c) {
	var b;
	if (typeof (c) == "object") {
		b = c
	} else {
		if (typeof (c) == "string") {
			b = this.getRadioById(c)
		}
	}
	return b
};
RadioRender.getRadios = function() {
	return this._array_radio
};
RadioRender.sizeRadioBox = function(c) {
	if (RadioRender._dockRadioBox) {
		var b = this.getRadio(RadioRender._dockRadioBox.radio);
		if (b) {
			b.sizeRadioBox()
		}
	}
};
function _initRadio(datasetId, selectValues, radioId, readOnly, label,
		ddsfiles, fileMapString, targetDataset, field, rowlen) {
	var dataset = getDatasetByID(datasetId);
	if (typeof (dataset) == "undefined" || dataset == null) {
		if (selectValues.length > 0
				&& selectValues.substring(selectValues.length - 1,
						selectValues.length) == ";") {
			selectValues = selectValues.substring(0, selectValues.length - 1)
		}
		eval("var " + datasetId + "=createDataset(datasetId,'',selectValues)");
		var dds_t = getDatasetByID(datasetId), dds_f;
		dds_t.readOnly = readOnly;
		dds_t.pageSize = 1000;
		dds_t.pageIndex = 1;
		dds_t.pageCount = 1;
		dds_t.masterDataset = "";
		dds_t.type = "dropdown";
		dds_t.references = "";
		dds_t.submitData = "allchange";
		dds_t.autoLoadPage = true;
		dds_t.autoLoadDetail = true;
		dds_t.downloadUrl = getDecodeStr("~2fextraservice~2fdownloaddata");
		dds_t.sessionKey = "";
		dds_t.insertOnEmpty = false;
		dds_t.tag = "";
		dds_t.initDocumentFlag = false;
		if (ddsfiles) {
			var temp = ddsfiles;
			var temps = temp.split(",");
			for ( var i = 0; i < temps.length; i++) {
				dds_f = dds_t.addField(temps[i], "string");
				dds_f.label = label;
				dds_f.size = 0;
				dds_f.scale = 0;
				dds_f.readOnly = false;
				dds_f.required = false;
				dds_f.nullable = true;
				dds_f.defaultValue = getDecodeStr("");
				dds_f.updatable = true;
				dds_f.valueProtected = false;
				dds_f.visible = true;
				dds_f.autoGenId = false;
				dds_f.tableName = "";
				dds_f.fieldName = temps[i].split("=")[1];
				dds_f.tag = "";
				dds_f.editorType = "";
				dds_f.dropDown = "";
				dds_f.mask = getDecodeStr("");
				dds_f.maskErrorMessage = getDecodeStr("");
				dds_f.toolTip = getDecodeStr("");
				dds_f.lobDownloadURL = getDecodeStr("");
				dds_f.lobPopupURL = getDecodeStr("")
			}
		}
		initDataset(dds_t)
	}
	if (typeof (RadioRender.getRadioById(radioId)) == "undefined") {
		eval("var " + radioId + " =new RadioRender(radioId)");
		var dd_t = RadioRender.getRadioById(radioId);
		dd_t.type = "dataset";
		dd_t.setFieldMap(fileMapString);
		dd_t.setDataset(dds_t);
		dd_t.setTargetDataset(targetDataset);
		dd_t.fields = field
	}
}
function errAlert(b) {
	switch (typeof (b)) {
	case "string":
		if (b == null || b == "" || b == "null") {
			cAlert(constAlertTipFailed, constAlertMsgSysErr, "red")
		} else {
			cAlert(constAlertTipFailed, b, "red")
		}
		break;
	case "object":
		if (b == null) {
			cAlert(constAlertTipFailed, constAlertMsgSysErr, "red")
		} else {
			cAlert(constAlertTipFailed, b.description, "red")
		}
		break;
	default:
		cAlert(constAlertTipFailed, constAlertMsgSysErr, "red");
		break
	}
}
function wrnAlert(b) {
	cAlert(constAlertTipInfo, b, "#336699")
}
function cAlert(b, d, c) {
	switch (c) {
	case "red":
		if (self != top && ALERT_POSITION == "TOP") {
			top.easyMsg.error(d, {
				title : b
			})
		} else {
			easyMsg.error(d, {
				title : b
			})
		}
		break;
	case "#336699":
		if (self != top && ALERT_POSITION == "TOP") {
			top.easyMsg.warn(d, {
				title : b
			})
		} else {
			easyMsg.warn(d, {
				title : b
			})
		}
		break;
	default:
		if (self != top && ALERT_POSITION == "TOP") {
			top.easyMsg.info(d, {
				title : b
			})
		} else {
			easyMsg.info(d, {
				title : b
			})
		}
		break
	}
}
function sAlert(p, m, k) {
	var j, f, i;
	j = 400;
	f = 100;
	titleheight = 25;
	i = k;
	titlecolor = "#99CCFF";
	var e, h;
	e = document.body.offsetWidth;
	h = screen.height;
	var l = document.getElementById("bgDiv");
	if (l && typeof (l) == "object") {
		var c = document.getElementById("msgTxt");
		if (c) {
			c.innerHTML = c.innerHTML + "<br>" + m;
			return
		}
	}
	var d = document.createElement("div");
	d.setAttribute("id", "bgDiv");
	d.style.position = "absolute";
	d.style.top = "0";
	d.style.background = "#777";
	d.style.filter = "progid:DXImageTransform.Microsoft.Alpha(style=3,opacity=25,finishOpacity=75";
	d.style.opacity = "0.6";
	d.style.left = "0";
	d.style.width = e + "px";
	d.style.height = h + "px";
	d.style.zIndex = "10000";
	document.body.appendChild(d);
	var b = document.createElement("div");
	b.setAttribute("id", "msgDiv");
	b.setAttribute("align", "center");
	b.style.background = "white";
	b.style.border = "1px solid " + i;
	b.style.position = "absolute";
	b.style.left = "50%";
	b.style.top = "50%";
	b.style.font = "12px/1.6em Verdana, Geneva, Arial, Helvetica, sans-serif";
	b.style.marginLeft = "-225px";
	b.style.marginTop = -75 + document.documentElement.scrollTop + "px";
	b.style.width = j + "px";
	b.style.height = f + "px";
	b.style.textAlign = "center";
	b.style.lineHeight = "25px";
	b.style.zIndex = "10001";
	var o = document.createElement("h4");
	o.setAttribute("id", "msgTitle");
	o.setAttribute("align", "right");
	o.style.margin = "0";
	o.style.padding = "3px";
	o.style.background = i;
	o.style.filter = "progid:DXImageTransform.Microsoft.Alpha(startX=20, startY=20, finishX=100, finishY=100,style=1,opacity=75,finishOpacity=100);";
	o.style.opacity = "0.75";
	o.style.border = "1px solid " + i;
	o.style.height = "18px";
	o.style.font = "12px Verdana, Geneva, Arial, Helvetica, sans-serif";
	o.style.color = "white";
	o.style.cursor = "pointer";
	o.innerHTML = "<center>" + p + "</center>";
	o.setAttribute("title", p);
	o.onclick = function() {
		document.body.removeChild(d);
		document.getElementById("msgDiv").removeChild(o);
		document.body.removeChild(b)
	};
	document.body.appendChild(b);
	document.getElementById("msgDiv").appendChild(o);
	var g = document.createElement("p");
	g.style.margin = "1em 0";
	g.setAttribute("id", "msgTxt");
	g.innerHTML = m;
	document.getElementById("msgDiv").appendChild(g)
}
function FloatWindow(d, h) {
	var k = d;
	var b = $(h);
	var i = null;
	function f() {
		return k
	}
	function j() {
		b.show();
		i = b.dialog({
			draggable : b.attr("drag") != "false",
			modal : true,
			onBeforeOpen : function() {
				var o = b.dialog("options");
				if (o.inited) {
					var m = fireUserEvent(k + "_floatWindow_beforeShow",
							[ this ]);
					if (m == false) {
						return false
					}
				}
			},
			onOpen : function() {
				fireUserEvent(k + "_floatWindow_afterShow", [ this ])
			},
			onBeforeClose : function() {
				var o = b.dialog("options");
				if (o.inited) {
					if (o.action == "hide") {
						var m = fireUserEvent(k + "_floatWindow_beforeHide",
								[ this ]);
						if (m == false) {
							return false
						}
					} else {
						var m = fireUserEvent(k + "_floatWindow_beforeClose",
								[ this ]);
						if (m == false) {
							return false
						}
					}
				}
			},
			onClose : function() {
				var m = b.dialog("options");
				if (m.inited) {
					if (m.action == "hide") {
						fireUserEvent(k + "_floatWindow_afterHide", [ this ])
					} else {
						fireUserEvent(k + "_floatWindow_afterClose", [ this ])
					}
				}
				$("div.validatebox-tip").each(function(o) {
					$(this).hide()
				})
			}
		});
		if (b.attr("show") == "false") {
			b.dialog("close")
		}
		var l = b.dialog("options");
		if ($.data(b[0], "window").mask && b.attr("ismodal") == "false") {
			$.data(b[0], "window").mask.click(function() {
				var m = b.dialog("options");
				m.action = "hide";
				b.dialog("close");
				m.action = ""
			})
		}
		l.inited = true
	}
	function g() {
		if (!i) {
			j()
		}
		b.dialog("open");
		b.dialog("center")
	}
	function e() {
		var l = b.dialog("options");
		l.action = "hide";
		b.dialog("close")
	}
	function c() {
		var l = b.dialog("options");
		l.action = "close";
		b.dialog("close")
	}
	FloatWindow._array_windows.push(this);
	this.init = j;
	this.getId = f;
	this.show = g;
	this.hide = e;
	this.close = c
}
FloatWindow._array_windows = new Array();
FloatWindow.getSubWindowById = function(c) {
	for ( var b = 0; b < this._array_windows.length; b++) {
		if (this._array_windows[b].getId() == c) {
			return this._array_windows[b]
		}
	}
	return null
};
FloatWindow.showSubWindow = function(c) {
	var b = this.getSubWindowById(c);
	if (b) {
		b.show()
	}
};
FloatWindow.hideSubWindow = function(c) {
	var b = this.getSubWindowById(c);
	if (b) {
		b.hide()
	}
};
FloatWindow.closeSubWindow = function(c) {
	var b = this.getSubWindowById(c);
	if (b) {
		b.close()
	}
};
var recordFields;
var interfaceflag = false;
var _groupflag = true;
function refreshDataTable(b) {
	if (b.getAttribute("treeGrid") == "false") {
		refreshDataGrid(b)
	} else {
		refreshTreeGrid(b)
	}
}
function refreshReadonlyTable(f) {
	var d = getElementDataset(f);
	var c = $(f);
	var e = c.rdatagrid("options");
	if (e.pageCache) {
		d.pageCache = true;
		e.cache["cache-data"] = d
	}
	var b = d.toJson(e);
	e.pageNumber = d.pageIndex || 0;
	c.rdatagrid("loadData", b)
}
function initDataTable(b) {
	if (!b.style.width.endWith("px")) {
		var c = $(b).parents("table");
		c.each(function(h) {
			if (this.style.width.endWith("%") || this.width.endWith("%")) {
			} else {
				if (window._AUTO_TALBE_MODE == "FULL" && !this.width
						&& !this.style.width) {
					this.style.width = "100%";
					return
				}
				if (h == 0) {
					$("table.rdatagrid").removeClass("rdatagrid").hide();
					var g = $(b);
					var d = $("<div style='width:100%'/>");
					g.after(d);
					var f = d.width();
					var e = 0;
					if (f < 100) {
						g.find("th").each(function() {
							var i = parseFloat(this.width) || 100;
							e += i + 1;
							this.width = i + "px"
						});
						if (g.attr("rownumbers") == "true") {
							e += 30 + 15 + 4
						}
					} else {
						e = f
					}
					g.data("initWidth", e);
					$(this).width(e);
					$("table.rdatagrid").show()
				}
			}
		})
	}
	if (b.getAttribute("treeGrid") == "false") {
		initDataGrid(b)
	} else {
		initTreeGrid(b)
	}
}
function initTreeGrid(e) {
	var d = $(e);
	d.addClass("resizable-datagrid").attr("_width",
			d[0] ? d[0].style.width : "");
	var f = getElementDataset(e);
	var h = copyDataset(d.attr("componentDataset") + "_copyed", d
			.attr("componentDataset"));
	h.cqId = "";
	var c = e.getAttribute("readonly");
	addEditor(d, f, c);
	var b = null;
	var g = d.attr("selectkey");
	if (g) {
		b = d.attr("selectkey").indexOf("[");
		if (b > -1) {
			g = d.attr("selectkey").substr(0, b)
		}
	}
	d.treegrid({
		select : g || "select",
		singleSelect : true,
		checkOnSelect : false,
		selectOnCheck : false,
		pagination : false,
		editId : -1,
		selectedId : -1,
		dataset : f,
		copyedds : h,
		init : false,
		readOnly : c != "false",
		onInit : function() {
			return false
		},
		rowStyler : function(i, j) {
			if (i % 2 == 1) {
				return "background-color:#fafafa;"
			}
		},
		loader : function(m, l, j) {
			var k = d.treegrid("options");
			var i = k.copyedds;
			k.init = false;
			k.loadby = 1;
			i.setParameter("_id", m.id);
			i.flushData(m.page);
			k.queryParams = {};
			i.setParameter("_id", null);
			l(i)
		},
		loadFilter : function(k) {
			var u = {};
			u.pageIndex = k.pageIndex;
			u.total = k.total;
			u.rows = [];
			if (k.length > 0) {
				var t = k.getFirstRecord();
				var o = {};
				while (t) {
					var w = {};
					for ( var l = 0; l < k.fields.fieldCount; l++) {
						var m = k.getField(l);
						var s = m.fieldName;
						var r = t.getValue(s);
						w[s] = r
					}
					var j = t.getString("_state")
							|| (t.getString("_hasChild_") == "true" ? "closed"
									: "open");
					w.state = j;
					w._parentId = t.getString("_parentId");
					w.iconCls = t.getString("_icon");
					w.checked = t.getString("_checked") == "true";
					w.children = [];
					w.record = t;
					w._recordUUID = w._id;
					t._uuid = w._id;
					o[w._id] = w;
					t = t.getNextRecord()
				}
				t = k.getFirstRecord();
				while (t) {
					var q = t.getValue("_id");
					var w = o[q];
					var p = o[w._parentId];
					if (p) {
						p.children[p.children.length] = w
					} else {
						u.rows[u.rows.length] = w
					}
					t = t.getNextRecord()
				}
			}
			return u
		},
		onHeaderClick : function(j, i, k) {
			fireUserEvent(d.attr("id") + "_" + k.toLowerCase()
					+ "_onHeaderClick", [ j, i ])
		},
		onDblClickRow : function(l, j) {
			var i = d.attr("id") + "_onDbClick";
			if (isUserEventDefined(i)) {
				try {
					fireUserEvent(i, [ this, j.record, l ])
				} catch (k) {
				}
			}
		},
		onLoadSuccess : function(o, q) {
			var m = d.treegrid("options");
			if ($.type(q) == "array") {
				q = {
					rows : q
				}
			}
			if (g) {
				var k = m.dataset.getField(m.select);
				if (k) {
					for ( var l = 0; l < q.rows.length; l++) {
						var p = q.rows[l];
						var j = p.record;
						if (j) {
							if (k) {
								isTrue(j.getValue(m.select)) ? d.treegrid(
										"checkRow", p[m.idField]) : d.treegrid(
										"uncheckRow", p[m.idField])
							}
						}
					}
				}
			}
			if (m.loadby != 1 && q.rows[0]) {
				if (m.dataset.record) {
					d.treegrid("select", m.dataset.record.getValue("_id")
							|| q.rows[0][m.idField])
				} else {
					d.treegrid("select", q.rows[0][m.idField])
				}
			} else {
				for ( var l = 0; l < q.rows.length; l++) {
					var r = q.rows[l].record;
					r.dataset = m.dataset;
					pArray_insert(m.dataset, "end", null, r)
				}
			}
			m.init = true;
			m.loadby = 0
		},
		onSelect : function(j) {
			if (j) {
				var i = d.treegrid("options");
				i.selectedId = j[i.idField]
			}
		},
		onCheck : function(j) {
			var i = d.treegrid("options");
			if (j && i.init) {
			}
		},
		onUncheck : function(j) {
			var i = d.treegrid("options");
			if (i.init) {
			}
		},
		onClickRow : function(l, k) {
			var j = d.treegrid("options");
			var o = l[j.idField];
			var i = $(k).hasClass("datagrid-row-selected");
			var p = j.selectedId;
			if (p != o && !j.editing) {
				j.dataset.setRecord(l.record)
			}
			if (g) {
				var m = j.dataset.getField(j.select);
				if (m && !m.readOnly && l.record) {
					l.record.setValue(j.select, !isTrue(l.record
							.getValue(j.select)))
				}
			}
		},
		onBeforeEdit : function(j) {
			var i = d.treegrid("options");
			if (!i.readOnly) {
				i.editing = true;
				i.editId = j[i.idField];
				$(document).unbind(".treegrid").bind("mousedown.treegrid",
						function(k) {
							if (i.editId || i.editId == 0) {
								d.treegrid("endEdit", i.editId)
							}
						}).bind("keydown.datagrid", function(k) {
				})
			}
			return !i.readOnly
		},
		onAfterEdit : function(k, i) {
			var j = d.treegrid("options");
			j.editing = false;
			j.editId = -1;
			$(document).unbind(".treegrid")
		},
		onCanelEdit : function(k, i) {
			var j = d.treegrid("options");
			j.editing = false;
			j.editId = -1;
			$(document).unbind(".treegrid")
		},
		onDblClickCell : function(m, k) {
			var j = d.treegrid("options");
			if (!j.editing) {
				var l = k[j.idField];
				d.treegrid("beginEdit", l);
				var i = d.treegrid("getEditor", {
					index : l,
					field : m
				});
				if (i) {
					i.target.focus();
					if (i.type == "datebox" || i.type == "datetimebox"
							|| i.type == "combobox" || i.type == "combo") {
						$(i.target).combo("textbox").focus()
					}
				}
			}
		}
	})
}
function refreshTreeGrid(e) {
	var c = getElementDataset(e);
	var b = $(e);
	var d = b.treegrid("options");
	b.treegrid("loadData", c)
}
function dataToMap(g, f, h) {
	var c = g.getField(h + "Name");
	if (c) {
		var b = c.tag;
		if (b == "selectName") {
		}
		if (b == "radioName") {
			var e = getDatasetByID(h + "_RadioDataset");
			var d = e.getFirstRecord();
			while (d) {
				if (d[0] == f) {
					f = d[1];
					break
				}
				d = d.getNextRecord()
			}
		}
	}
	return f
}
function addEditor(grid, dataset, readonly) {
	var trs = $("thead tr th", grid);
	for ( var i = 0; i < trs.length; i++) {
		var tr = trs.eq(i);
		var fieldName = tr.attr("field");
		if (!fieldName) {
			continue
		}
		var field = dataset.getField(fieldName);
		if (tr.attr("checkbox") == "true") {
			tr.attr("readonly", field.readOnly);
			continue
		}
		tr.attr("formatter", "_cellFormatter");
		tr.attr("align", tr.attr("align") || field.align);
		if (field.editType == "select") {
			if (field.tag == "select" || field.tag == "selectCQ"
					|| field.tag == "selectTree") {
				tr.attr("formatter", field.fieldName + "_cellFormatter")
			}
			if (field.tag == "select") {
				var Json = _initSelectJson(field);
				eval(field.fieldName + "_Json=Json;")
			}
		}
		tr.attr("sortable", grid.attr("sortable") == "true" ? true : false);
		tr.attr("headAlign", grid.attr("headAlign"));
		if (readonly == "false") {
			var vtype = "";
			var vopts = "_a:1";
			switch (field.editType) {
			case "textarea":
				vtype = "textarea";
				break;
			case "checkbox":
				vtype = "checkbox";
				vopts = "on:true,off:false";
				break;
			case "predate":
				vtype = "datebox";
				vopts = "today:'" + today()
						+ "',comparemode:'le',dateType:'predate'";
				break;
			case "postdate":
				vtype = "datebox";
				vopts = "today:'" + today()
						+ "',comparemode:'ge',dateType:'postdate'";
				break;
			case "date":
				if (field.dataType == "timestamp") {
					vtype = "datetimebox"
				} else {
					vtype = "datebox"
				}
				vopts = "today:'" + today() + "'";
				break;
			case "timestamp":
				vtype = "datetimebox";
				vopts = "today:'" + today() + "'";
				break;
			case "select":
				switch (field.tag) {
				case "select":
					vtype = "combobox";
					vopts = "valueField:'id',textField:'text',data:"
							+ field.fieldName + "_Json,multiple:"
							+ field.multiple + ",dataField:'" + field.fieldName
							+ "',dropDown:'" + field.dropDown + "'";
					break;
				case "selectCQ":
					vtype = "combogrid";
					vopts = "dataField:'" + field.fieldName + "',dropDown:'"
							+ field.dropDown + "',datasetName:'"
							+ field.dropDownDataset + "',multiple:"
							+ field.multiple;
					break;
				case "selectCustom":
					vtype = "validatebox";
					vopts = "dataField:'" + field.fieldName + "',dropDown:'"
							+ field.dropDown + "',datasetName:'"
							+ field.dropDownDataset + "'";
					break;
				case "selectTree":
					vtype = "combotree";
					vopts = "dataField:'" + field.fieldName + "',dropDown:'"
							+ field.dropDown + "',datasetName:'"
							+ field.dropDownDataset + "',multiple:"
							+ field.multiple;
					break
				}
				break;
			default:
				switch (field.dataType) {
				case "int":
					vtype = "numberbox";
					break;
				case "double":
				case "float":
					vtype = "numberbox";
					vopts = "precision:" + field.scale;
					break;
				case "currency":
					vtype = "numberbox";
					vopts = "groupSeparator:','";
					if (field.scale) {
						vopts = vopts + ",precision:" + field.scale
					}
					if (field.prefix) {
						vopts = vopts + ",prefix:'" + field.prefix + "'"
					}
					break;
				case "predate":
					vtype = "datebox";
					vopts = "today:'" + today()
							+ "',comparemode:'le',dateType:'predate'";
					break;
				case "postdate":
					vtype = "datebox";
					vopts = "today:'" + today()
							+ "',comparemode:'ge',dateType:'postdate'";
					break;
				case "date":
					vtype = "datebox";
					vopts = "today:'" + today() + "'";
					break;
				case "timestamp":
					vtype = "datetimebox";
					vopts = "today:'" + today() + "'";
					break;
				default:
					vtype = "validatebox";
					break
				}
			}
			if (vtype) {
				if (field.required) {
					vopts = "required:true," + vopts
				}
				if (field.editType == "select") {
					vopts = "extra:'dropDownSelect'," + vopts
				} else {
					vopts = "extra:'editor'," + vopts
				}
				vopts = "componentDataset:'" + dataset.id + "'," + vopts;
				var mask = field.mask;
				var maskErrorMessage = field.maskErrorMessage;
				if (mask && mask != "null") {
					vopts = "validType:'" + mask + "',msg:'" + maskErrorMessage
							+ "'," + vopts
				}
				tr.attr("editor", "{type:'" + vtype + "',options:{" + vopts
						+ "}}")
			}
		}
	}
}
function _viewformat(e, c) {
	switch (e.dataType) {
	case "string":
		if (e.editType == "date" || e.editType == "predate"
				|| e.editType == "postdate") {
			var f = cast(c, "date");
			c = f.format(_VIEW_DATE_PATTERN)
		} else {
			if (e.editType == "timestamp") {
				var f = cast(c, "timestamp");
				c = f.format(_VIEW_DATETIME_PATTERN)
			} else {
				if (e.editType == "currency") {
					c = formatCurrency("" + c)
				}
			}
		}
		break;
	case "date":
	case "predate":
	case "postdate":
		var f = cast(c, "date");
		c = f.format(_VIEW_DATE_PATTERN);
		break;
	case "timestamp":
		var f = cast(c, "timestamp");
		c = f.format(_VIEW_DATETIME_PATTERN);
		break;
	case "currency":
		var b = formatFloat(c, e.scale);
		c = formatCurrency(b);
		break;
	case "float":
	case "double":
		c = formatFloat(c, e.scale);
		break;
	default:
		break
	}
	return c
}
function _cellFormatter(o, c, l, p, b, m) {
	if (c.isfoot) {
		return o
	}
	var k = m[0];
	var g = c.record;
	var d = g.dataset;
	try {
		var h = b + "_" + p.toLowerCase() + "_onRefresh";
		if (isUserEventDefined(h)) {
			try {
				fireUserEvent(h, [ k, o, g ])
			} catch (j) {
				return "cell format error"
			}
			return k.innerHTML
		} else {
			var i = d.getField(p);
			try {
				o = _viewformat(i, o)
			} catch (j) {
				return "cell format error"
			}
			if (i.editType == "process") {
				var q = 0;
				if (i.dataType == "int") {
					q = parseInt(o)
				} else {
					if (i.dataType == "string") {
						q = parseInt(o) || 0
					} else {
						q = Math.floor(parseFloat(o) * 100)
					}
				}
				if (q || q == 0) {
				} else {
					q = 0
				}
				return $("<div/>").progressbar(
						{
							value : Math.floor(q),
							onChange : function(r, t) {
								var f = b + "_" + p + "_onProgress";
								if (isUserEventDefined(f)) {
									try {
										fireUserEvent(f, [ r, t,
												this.children[1],
												this.children[0] ])
									} catch (s) {
									}
								}
							}
						})[0].outerHTML
			} else {
				if (i.editType == "checkbox") {
					var q = isTrue(o);
					if (q) {
						return "<div class='datagrid-checked'></div>"
					} else {
						return "<div class='datagrid-nochecked'></div>"
					}
				}
			}
			if (typeof o == "string") {
				o = o.replace(/ /g, "&nbsp;")
			}
			return o
		}
	} catch (j) {
		return o
	}
}
function _initSelectJson(f, c) {
	var e;
	var h;
	if (typeof (f) != "string") {
		e = getDatasetByID(f.fieldName + "_DropDownDataset");
		h = f.required
	} else {
		e = getDatasetByID(f + "_DropDownDataset");
		h = (c == "true" ? true : false)
	}
	var d = [];
	if (true) {
		var g = {
			id : "",
			text : ""
		};
		d[0] = g
	}
	var b = e.getFirstRecord();
	while (b) {
		if (b[0]) {
			var g = {};
			g.id = b[0];
			g.text = b[1];
			d[d.length] = g
		}
		b = b.getNextRecord()
	}
	return d
}
function initColumnSelectDialog(o, k, p) {
	var c = $(k);
	var d = c.data("hasContextMenu");
	if (!d) {
		d = $('<div style="width:150px;position:absolute;display:none"></div>')
				.appendTo($("body"));
		if (p == 1) {
			var m = $.data(k, "rdatagrid").dc.header.find("td[field]");
			m.each(function(e) {
				var j = $(this);
				if (!j.hasClass("datagrid-header-check")) {
					d.append("<div data-options=\"name:'"
							+ j.attr("field")
							+ "',iconCls:'"
							+ (j.is(":hidden") ? "tree-checkbox0"
									: "tree-checkbox1") + "'\">" + j.text()
							+ "</div>")
				}
			})
		} else {
			var b = c.data("datagrid").options;
			if (b.columns) {
				for ( var l = 0; l < b.columns.length; l++) {
					var g = b.columns[l];
					for ( var h = 0; h < g.length; h++) {
						var f = g[h];
						if (!f.checkbox) {
							d.append("<div data-options=\"name:'"
									+ f.field
									+ "',iconCls:'"
									+ (f.hidden ? "tree-checkbox0"
											: "tree-checkbox1") + "'\">"
									+ f.title + "</div>")
						}
					}
				}
			}
		}
		if (d.height() > 250) {
			d.height(250);
			d.css({
				"overflow-y" : "auto"
			})
		}
		d.menu({
			onClick : function(e) {
				if (e.iconCls == "tree-checkbox1") {
					if (p == 1) {
						c.rdatagrid("hideColumn", e.name)
					} else {
						c.datagrid("hideColumn", e.name)
					}
					d.menu("setIcon", {
						target : e.target,
						iconCls : "tree-checkbox0"
					})
				} else {
					if (e.iconCls == "tree-checkbox0") {
						if (p == 1) {
							c.rdatagrid("showColumn", e.name)
						} else {
							c.datagrid("showColumn", e.name)
						}
						d.menu("setIcon", {
							target : e.target,
							iconCls : "tree-checkbox1"
						})
					}
				}
				var j = d.find("div.tree-checkbox1");
				if (j.size() == 1) {
					var i = j.parent()[0];
					d.menu("disableItem", i);
					d.data("disabledItem", i)
				} else {
					if (d.data("disabledItem")) {
						d.menu("enableItem", d.data("disabledItem"))
					}
				}
			}
		});
		d.find(".menu-text").css({
			height : 25,
			overflow : "hidden"
		});
		d.children().each(function(e) {
			this.submenu = $("<div></div>")
		});
		c.data("hasContextMenu", d)
	}
	d.menu("show", {
		left : o.pageX,
		top : o.pageY
	})
}
function initReadonlyDataTable(e) {
	var d = $(e);
	if (!e.style.width.endWith("px")) {
		var h = d.parents("table");
		h.each(function(m) {
			if (this.style.width.endWith("%") || this.width.endWith("%")) {
				$(this).addClass("auto-table")
			} else {
				if (window._AUTO_TALBE_MODE == "FULL" && !this.width
						&& !this.style.width) {
					$(this).addClass("auto-table");
					this.style.width = "100%";
					return
				}
				if (m == 0) {
					$("table.rdatagrid").removeClass("rdatagrid").hide();
					var j = $("<div style='width:100%'/>");
					d.after(j);
					var l = j.width();
					var k = 0;
					if (l < 100) {
						d.find("th").each(function() {
							var o = parseFloat(this.width) || 100;
							k += o;
							this.width = o + "px"
						});
						if (d.attr("rownumbers") == "true") {
							k += 30 + 15 + 2
						}
					} else {
						k = l
					}
					d.data("initWidth", k);
					$(this).width(k);
					$("table.rdatagrid").show()
				}
			}
		})
	}
	var g = d.attr("pkid") || "id";
	var f = getElementDataset(e);
	var c = d.attr("remeberCheck") == "true";
	if (c && !f.getField(g)) {
		errAlert("pkid must be configured in macro.")
	}
	addEditor(d, f, "true");
	var b = null;
	var i = d.attr("selectkey");
	if (i) {
		b = d.attr("selectkey").indexOf("[");
		if (b > -1) {
			i = d.attr("selectkey").substr(0, b)
		}
	}
	d
			.rdatagrid({
				select : i || "select",
				cache : {},
				pkid : g,
				checked : {},
				showPageList : d.attr("showPageList") != "false",
				nowrap : d.attr("nowrap") == "true",
				pageCache : d.attr("pageCache") == "true",
				rowStyler : function(j, k) {
					if (j % 2 == 1) {
						return "background-color:#fafafa;"
					}
				},
				onHeaderClick : function(k, j, l) {
					if (l) {
						fireUserEvent(e.getAttribute("id") + "_"
								+ l.toLowerCase() + "_onHeaderClick", [ k, j ])
					}
				},
				onClickRow : function(o, l, k) {
					var j = d.rdatagrid("options");
					if (j.selectedIndex != o) {
						j.dataset.setRecord(l.record)
					}
					if (i) {
						var m = j.dataset.getField(j.select);
						if (m && !m.readOnly && l.record) {
							l.record.setValue(j.select, !isTrue(l.record
									.getValue(j.select)))
						}
					}
				},
				onDblClickRow : function(m, k) {
					var j = d.attr("id") + "_onDbClick";
					if (isUserEventDefined(j)) {
						try {
							fireUserEvent(j, [ this, k.record, m ])
						} catch (l) {
						}
					} else {
						if (d.attr("floatwindow")) {
							if (typeof (FloatWindow) != "undefined") {
								FloatWindow
										.showSubWindow(d.attr("floatwindow"))
							}
						}
					}
				},
				onLoadSuccess : function(s) {
					var k = d.rdatagrid("options");
					k.loaded = true;
					var r = k.dataset;
					if (r.record) {
						d.rdatagrid("selectRecord", r.record._uuid)
					}
					var y = false;
					var y = false;
					if (i) {
						y = r.getField(k.select);
						for ( var t = 0; t < s.rows.length; t++) {
							var o = s.rows[t];
							var x = d.rdatagrid("getRowIndex", o[k.idField]);
							o.rowIndex = x
						}
					}
					k.init = true;
					if (i && c) {
						for ( var t = 0; t < s.rows.length; t++) {
							var o = s.rows[t];
							var u = o.record;
							if (!k.checked[""] && k.checked[o[k.pkid]]) {
								if (u) {
									if (y) {
										u.setValue(k.select, true)
									}
								}
								d.rdatagrid("checkRow", o.rowIndex)
							} else {
								d.rdatagrid("uncheckRow", o.rowIndex)
							}
						}
					}
					var w = d.attr("mergeCols");
					if (w && s.rows.length > 1) {
						var z = w.split(",");
						var B = s.rows;
						var l = 0, p = 1;
						for ( var t = 1; t < B.length; t++) {
							var A = B[t];
							var v = true;
							for ( var q = 0; q < z.length; q++) {
								var m = z[q];
								if (A[m] !== B[t - 1][m]) {
									v = false
								}
							}
							if (v) {
								p++;
								if (t == B.length - 1) {
									if (p > 1) {
										for ( var q = 0; q < z.length; q++) {
											var m = z[q];
											d.rdatagrid("mergeCells", {
												index : l,
												field : m,
												rowspan : p
											})
										}
									}
								}
							} else {
								if (p > 1) {
									for ( var q = 0; q < z.length; q++) {
										var m = z[q];
										d.rdatagrid("mergeCells", {
											index : l,
											field : m,
											rowspan : p
										})
									}
								}
								l = t;
								p = 1
							}
						}
					}
				},
				onSelect : function(l, k) {
					var j = d.rdatagrid("options");
					j.selectedIndex = l
				},
				onCheck : function(o, l) {
					var k = d.rdatagrid("options");
					if (k.init) {
						var m = k.dataset;
						var j = l.record;
						if (j) {
							k.checked[j.getString(k.pkid)] = true
						}
					}
				},
				onUncheck : function(o, l) {
					var k = d.rdatagrid("options");
					if (k.init) {
						var m = k.dataset;
						var j = l.record;
						if (j) {
							k.checked[j.getString(k.pkid)] = false
						}
					}
				},
				onCheckAll : function(p) {
					var o = d.rdatagrid("options");
					if (o.init) {
						var q = o.dataset;
						q.disableControls();
						var l = q.getField(o.select);
						var j = q.record;
						q.isCheckAll = true;
						for ( var m = 0; m < p.length; m++) {
							var k = p[m].record;
							if (k) {
								if (l) {
									if (k == j) {
										q.disableControlCount = (q.disableControlCount > 0) ? q.disableControlCount - 1
												: 0
									}
									k.setValue(o.select, true);
									if (k == j) {
										q.disableControls()
									}
								}
								o.checked[k.getString(o.pkid)] = true
							}
						}
						q.isCheckAll = false;
						q.record = j;
						q.disableControlCount = (q.disableControlCount > 0) ? q.disableControlCount - 1
								: 0
					}
				},
				onUncheckAll : function(p) {
					var o = d.rdatagrid("options");
					if (o.init) {
						var q = o.dataset;
						q.disableControls();
						var l = q.getField(o.select);
						var j = q.record;
						q.isCheckAll = true;
						for ( var m = 0; m < p.length; m++) {
							var k = p[m].record;
							if (k) {
								if (l) {
									if (k == j) {
										q.disableControlCount = (q.disableControlCount > 0) ? q.disableControlCount - 1
												: 0
									}
									k.setValue(o.select, false);
									if (k == j) {
										q.disableControls()
									}
								}
								o.checked[k.getString(o.pkid)] = false
							}
						}
						q.isCheckAll = false;
						q.record = j;
						q.disableControlCount = (q.disableControlCount > 0) ? q.disableControlCount - 1
								: 0
					}
				}
			});
	setTimeout(function() {
		var k = d.attr("moreFieldStr") || "";
		var j = k.match(/[a-zA-Z_$][a-zA-Z0-9_$]*/g) || [];
		for ( var l = 0; l < j.length; l++) {
			d.rdatagrid("hideColumn", j[l])
		}
	})
}
function initDataGrid(j) {
	var c = $(j);
	c.addClass("resizable-datagrid").attr("_width",
			c[0] ? c[0].style.width : "");
	parse_complete_event.push(function() {
		var q = c.find("th:first").attr("rowspan");
		var p = $.data(j, "datagrid").dc;
		var r = p.view1.children("div.datagrid-header").find(
				"tr.datagrid-header-row").find("div.datagrid-header-rownumber")
				.parent();
		r.attr("rowspan", q || 1)
	});
	var l = j.getAttribute("readonly");
	var h = getElementDataset(j);
	var e = c.attr("pkid") || "id";
	var d = c.attr("remeberCheck") == "true";
	if (d && !h.getField(e)) {
		errAlert("pkid must be configured in macro.")
	}
	addEditor(c, h, l);
	var k = null;
	var f = c.attr("selectkey");
	if (f) {
		k = c.attr("selectkey").indexOf("[");
		if (k > -1) {
			f = c.attr("selectkey").substr(0, k)
		}
	}
	var g = [ 10, 20, 30, 40, 50 ];
	var m = h.masterDataset ? 999999 : h.pageSize;
	if ($.inArray(m, g) == -1) {
		g.push(m);
		g.sort(function(q, p) {
			return q - p
		})
	}
	var i = {
		showRefresh : c.attr("showRefresh") != "false",
		pageSize : m,
		pageList : g,
		pageNumber : 1,
		displayMsg : "",
		showPageList : c.attr("showPageList") != "false" || !h.masterDataset,
		onBeforeRefresh : function(q, p) {
			var r = c.datagrid("options");
			r.checked = {};
			if (!r.loaded) {
				return false
			}
			if (r.editIndex > -1) {
				c.datagrid("cancelEdit", r.editIndex)
			}
		},
		onSelectPage : function(s, r) {
			var t = c.datagrid("options");
			t.init = false;
			if (t.editing) {
				t.editing = false
			}
			var w = getElementEventName(h, "beforeSelectPage");
			if (isUserEventDefined(w)) {
				try {
					var q = fireUserEvent(w, [ h, s, r ]);
					if (q == false) {
						return
					}
				} catch (v) {
					return
				}
			}
			h.setParameter("nextPage", s);
			h.setParameter("everyPage", r);
			h.pageIndex = s;
			h.pageSize = r;
			t.pageNumber = s;
			t.pageSize = r;
			if (!t.loaded) {
				return false
			}
			if (t.pageCache) {
				var p = t.cache["cache-data"];
				var u = p.toJson(t);
				u.total = p.length;
				c.datagrid("loadData", u);
				if (u.rows[0]) {
					h.setRecord(u.rows[0].record)
				}
			} else {
				h.flushData(s)
			}
		}
	};
	c
			.datagrid({
				isHiddenScoll : c.attr("isHiddenScoll") == "true" ? true
						: false,
				pageopts : i,
				setValueCheck : false,
				checkOnSelect : false,
				selectOnCheck : false,
				nowrap : c.attr("nowrap") == "true",
				singleSelect : true,
				select : f || "select",
				editIndex : -1,
				selectedIndex : -1,
				dataset : h,
				init : false,
				loaded : false,
				readOnly : l != "false",
				sumfieldstr : c.attr("sumfieldstr"),
				pagination_toolbar : "#" + c.attr("id") + "_paginationbar",
				headBar : c.attr("id") + "_headBar",
				pageCache : c.attr("pageCache") == "true",
				cache : {},
				pkid : e,
				checked : {},
				fixed : false,
				onInit : function() {
					return false
				},
				rowStyler : function(p, r, q) {
					if (p % 2 == 1) {
						return "background-color:#fafafa;"
					}
				},
				onHeaderClick : function(q, p, r) {
					if (r) {
						fireUserEvent(j.getAttribute("id") + "_"
								+ r.toLowerCase() + "_onHeaderClick", [ q, p ])
					}
				},
				onLoadSuccess : function(w) {
					var p = c.datagrid("options");
					p.loaded = true;
					var v = p.dataset;
					if (v.record) {
						c.datagrid("selectRecord", v.record._uuid)
					}
					var C = false;
					if (f) {
						C = v.getField(p.select);
						for ( var x = 0; x < w.rows.length; x++) {
							var s = w.rows[x];
							var y = s.record;
							var B = c.datagrid("getRowIndex", s[p.idField]);
							s.rowIndex = B;
							if (y) {
								if (C) {
									isTrue(y.getValue(p.select)) ? c.datagrid(
											"checkRow", B) : c.datagrid(
											"uncheckRow", B)
								}
							}
						}
					}
					p.init = true;
					if (f && d) {
						for ( var x = 0; x < w.rows.length; x++) {
							var s = w.rows[x];
							var y = s.record;
							if (!p.checked[""] && p.checked[s[p.pkid]]) {
								if (y) {
									if (C) {
										y.setValue(p.select, true)
									}
								}
								c.datagrid("checkRow", s.rowIndex)
							} else {
								c.datagrid("uncheckRow", s.rowIndex)
							}
						}
					}
					var A = c.attr("mergeCols");
					if (A && w.rows.length > 1) {
						var D = A.split(",");
						var F = w.rows;
						var q = 0, t = 1;
						for ( var x = 1; x < F.length; x++) {
							var E = F[x];
							var z = true;
							for ( var u = 0; u < D.length; u++) {
								var r = D[u];
								if (E[r] !== F[x - 1][r]) {
									z = false
								}
							}
							if (z) {
								t++;
								if (x == F.length - 1) {
									if (t > 1) {
										for ( var u = 0; u < D.length; u++) {
											var r = D[u];
											c.datagrid("mergeCells", {
												index : q,
												field : r,
												rowspan : t
											})
										}
									}
								}
							} else {
								if (t > 1) {
									for ( var u = 0; u < D.length; u++) {
										var r = D[u];
										c.datagrid("mergeCells", {
											index : q,
											field : r,
											rowspan : t
										})
									}
								}
								q = x;
								t = 1
							}
						}
					}
					_show_message_when_nodata(c)
				},
				onClickCheckbox : function(s, r) {
					var q = c.datagrid("options");
					if (q.init) {
						var t = q.dataset;
						var p = s.record;
						t.setRecord(p);
						q.setValueCheck = true
					}
				},
				onSelect : function(r, q) {
					var p = c.datagrid("options");
					if (p.init) {
						p.selectedIndex = r
					}
				},
				onCheck : function(t, r) {
					var q = c.datagrid("options");
					if (q.init && q.setValueCheck) {
						q.setValueCheck = false;
						var s = q.dataset;
						var p = r.record;
						if (p) {
							q.checked[p.getString(q.pkid)] = true
						}
					}
				},
				onUncheck : function(t, r) {
					var q = c.datagrid("options");
					if (q.init && q.setValueCheck) {
						q.setValueCheck = false;
						var s = q.dataset;
						var p = r.record;
						if (p) {
							q.checked[p.getString(q.pkid)] = false
						}
					}
				},
				onCheckAll : function(u) {
					var t = c.datagrid("options");
					if (t.init) {
						var v = t.dataset;
						v.disableControls();
						var r = v.getField(t.select);
						var p = v.record;
						v.isCheckAll = true;
						for ( var s = 0; s < u.length; s++) {
							var q = u[s].record;
							if (q) {
								if (r) {
									if (q == p) {
										v.disableControlCount = (v.disableControlCount > 0) ? v.disableControlCount - 1
												: 0
									}
									q.setValue(t.select, true);
									if (q == p) {
										v.disableControls()
									}
								}
								t.checked[q.getString(t.pkid)] = true
							}
						}
						v.isCheckAll = false;
						v.record = p;
						v.disableControlCount = (v.disableControlCount > 0) ? v.disableControlCount - 1
								: 0
					}
				},
				onUncheckAll : function(u) {
					var t = c.datagrid("options");
					if (t.init) {
						var v = t.dataset;
						v.disableControls();
						var r = v.getField(t.select);
						var p = v.record;
						v.isCheckAll = true;
						for ( var s = 0; s < u.length; s++) {
							var q = u[s].record;
							if (q) {
								if (r) {
									if (q == p) {
										v.disableControlCount = (v.disableControlCount > 0) ? v.disableControlCount - 1
												: 0
									}
									q.setValue(t.select, false);
									if (q == p) {
										v.disableControls()
									}
								}
								t.checked[q.getString(t.pkid)] = false
							}
						}
						v.isCheckAll = false;
						v.record = p;
						v.disableControlCount = (v.disableControlCount > 0) ? v.disableControlCount - 1
								: 0
					}
				},
				onClickRow : function(t, r, q) {
					var p = c.datagrid("options");
					if (p.selectedIndex != t && !p.editing) {
						p.dataset.setRecord(r.record)
					}
					if (f) {
						var s = p.dataset.getField(p.select);
						if (s && !s.readOnly && r.record) {
							r.record.setValue(p.select, !isTrue(r.record
									.getValue(p.select)))
						}
					}
				},
				onSortColumn : function(q, p) {
					var r = c.datagrid("options");
					var s = r.dataset;
					s.sort((p == "desc" ? "-" : "") + q)
				},
				onBeforeEdit : function(t, s) {
					var q = c.attr("id") + "_beforeEdit";
					var p = fireUserEvent(q, [ t, s.record ]);
					if (typeof (p) == "boolean" && !p) {
						return false
					}
					var r = c.datagrid("options");
					if (!r.readOnly) {
						r.editing = true;
						r.editIndex = t;
						$(document).unbind(".datagrid").bind(
								"mousedown.datagrid", function(u) {
									if (r.editIndex > -1) {
										c.datagrid("endEdit", r.editIndex)
									}
								}).bind("keydown.datagrid", function(u) {
						})
					}
					return !r.readOnly
				},
				onAfterEdit : function(u, t, r) {
					var s = c.datagrid("options");
					s.editing = false;
					s.editIndex = -1;
					$(document).unbind(".datagrid");
					var q = c.attr("id") + "_afterEdit";
					var p = fireUserEvent(q, [ u, t.record ])
				},
				onCancelEdit : function(r, q) {
					var p = c.datagrid("options");
					p.editing = false;
					p.editIndex = -1;
					$(document).unbind(".datagrid")
				},
				onDeleteRow : function(q) {
					var p = $.data(j, "datagrid").dc;
					var r = p.view;
					if (r.height() < 30) {
						r.height(50)
					}
				},
				onDblClickCell : function(t, s, r) {
					var q = c.datagrid("options");
					if (!q.editing) {
						c.datagrid("beginEdit", t);
						var p = c.datagrid("getEditor", {
							index : t,
							field : s
						});
						if (p) {
							p.target.focus();
							if (p.type == "datebox" || p.type == "datetimebox"
									|| p.type == "combobox"
									|| p.type == "combo") {
								$(p.target).combo("textbox").focus()
							}
						}
					}
				},
				onDblClickRow : function(s, q) {
					var p = c.attr("id") + "_onDbClick";
					if (isUserEventDefined(p)) {
						try {
							fireUserEvent(p, [ this, q.record, s ])
						} catch (r) {
						}
					} else {
						if (c.attr("floatwindow")) {
							if (typeof (FloatWindow) != "undefined") {
								FloatWindow
										.showSubWindow(c.attr("floatwindow"))
							}
						}
					}
				}
			});
	var o = $.data(j, "datagrid").dc;
	var b = o.view;
	if (b.height() < 30) {
		b.height(50)
	}
	setTimeout(function() {
		var q = c.attr("moreFieldStr");
		var p = q.match(/[a-zA-Z_$][a-zA-Z0-9_$]*/g) || [];
		for ( var r = 0; r < p.length; r++) {
			c.datagrid("hideColumn", p[r])
		}
	})
}
function _show_message_when_nodata(e) {
	var b = e.datagrid("getPanel").children("div.datagrid-view");
	var d = b.children("div.datagrid-view2");
	var f = d.children("div.datagrid-body");
	var c = f.find(".datagrid-btable tbody tr");
	if (!c[0]) {
		f.html("<div class='datagrid-has-no-data'>"
				+ $.fn.datagrid.defaults.emptyMsg + "</div>")
	}
}
function refreshDataGrid(f) {
	var d = getElementDataset(f);
	var c = $(f);
	var e = c.datagrid("options");
	if (e.pageCache) {
		d.pageCache = true;
		e.cache["cache-data"] = d
	}
	var b = d.toJson(e);
	e.pageNumber = d.pageIndex || 0;
	c.datagrid("loadData", b)
}
function refreshDatagridCursor(e, g, c, b) {
	var d = $(e);
	if (c) {
		if (d.attr("treeGrid") == "false") {
			d.datagrid("selectRecord", c._uuid)
		} else {
			var f = d.treegrid("options");
			d.treegrid("select", c._uuid)
		}
	} else {
		d.datagrid("clearSelections")
	}
}
function refreshReadonlyTableCursor(e, f, c, b) {
	var d = $(e);
	if (c) {
		d.rdatagrid("selectRecord", c._uuid)
	} else {
		d.rdatagrid("clearSelections")
	}
}
function refreshPagination(c, b) {
}
function refreshDataGridRow(f, e, h, c) {
	var l = {};
	l.record = h;
	for ( var g = 0; g < e.fields.fieldCount; g++) {
		var k = e.getField(g).fieldName;
		var b = h.getJsonValue(k);
		l[k] = b
	}
	if (f.getAttribute("treeGrid") == "false") {
		var j = $(f).datagrid("getRowIndex", h._uuid);
		$(f).datagrid("updateRow", {
			index : j,
			row : l
		})
	} else {
		var d = h._uuid;
		$(f).treegrid("update", {
			id : d,
			row : l
		})
	}
}
function refreshDataGridCellValue(j, f, p, k) {
	if (j.getAttribute("treeGrid") == "false") {
		var b = $(j).datagrid("options");
		var o = b.editIndex;
		var m = $(j).datagrid("getRowIndex", k._uuid);
		var d = b.finder.getRow(j, m);
		if (b.setValueCheck) {
			return
		}
		if (p.fieldName == b.select) {
			if (isTrue(k.getValue(b.select))) {
				$(j).datagrid("checkRow", m)
			} else {
				$(j).datagrid("uncheckRow", m)
			}
			d[b.select] = isTrue(k.getValue(b.select));
			b.checked[k.getString(b.pkid)] = k.getValue(b.select);
			b.setValueCheck = false;
			return
		}
		if ((o == m) && d) {
			var q = k.getJsonValue(p.fieldName);
			q = q.replace(/</g, "&lt;");
			q = q.replace(/>/g, "&gt;");
			d[p.fieldName] = q;
			var l = b.finder.getTr(j, m);
			l.children("td").each(
					function() {
						var t = $(this).attr("field");
						if (t == p.fieldName || t + "Name" == p.fieldName) {
							var i = $(this).find("div.datagrid-cell");
							var s = i.find("td").children();
							if (s[0]) {
								refreshInputValue(
										s.size() == 2 ? (s.eq(0).attr(
												"edittype") == null ? s[1]
												: s[0]) : s[0], f, k)
							} else {
								var r = $(j).datagrid("getColumnOption", t);
								if (r) {
									if (r.formatter) {
										i.html(r.formatter(d[t], d, c, p, $(j)
												.attr("id"), i))
									} else {
										i.html(d[t])
									}
								}
							}
						}
					})
		} else {
			var h = $(j).datagrid("getData");
			for ( var g = 0; g < h.rows.length; g++) {
				if (h.rows[g][b.idField] == k._uuid) {
					var q = k.getJsonValue(p.fieldName);
					q = q.replace(/</g, "&lt;");
					q = q.replace(/>/g, "&gt;");
					h.rows[g][p.fieldName] = q;
					$(j).datagrid("updateRow", {
						index : m,
						row : h.rows[g]
					});
					break
				}
			}
		}
	} else {
		var b = $(j).treegrid("options");
		var c = k._uuid;
		var e = b.editId;
		var d = $(j).treegrid("find", c);
		if (!d) {
			return
		}
		d[p.fieldName] = k.getJsonValue(p.fieldName);
		if (b.setValueCheck) {
			return
		}
		if (p.fieldName == b.select) {
			if (isTrue(k.getValue(b.select))) {
				$(j).treegrid("checkRow", c)
			} else {
				$(j).treegrid("uncheckRow", c)
			}
			d[b.select] = isTrue(k.getValue(b.select));
			b.setValueCheck = false;
			return
		}
		if (c == e) {
			var l = b.finder.getTr(j, c);
			l.children("td").each(
					function() {
						var t = $(this).attr("field");
						if (t == p.fieldName || t + "Name" == p.fieldName) {
							var i = $(this).find("div.datagrid-cell");
							var s = i.find("td").children();
							if (s[0]) {
								refreshInputValue(s[0], f, k)
							} else {
								var r = $(j).datagrid("getColumnOption", t);
								if (r) {
									if (r.formatter) {
										i.html(r.formatter(d[t], d, c, p, $(j)
												.attr("id"), i))
									} else {
										i.html(d[t])
									}
								}
							}
						}
					})
		} else {
			$(j).treegrid("update", {
				id : c,
				row : d
			})
		}
	}
}
function refreshReadonlyTableRow(f, e, h, c) {
	var l = {};
	l.record = h;
	for ( var g = 0; g < e.fields.fieldCount; g++) {
		var k = e.getField(g).fieldName;
		var b = h.getJsonValue(k);
		l[k] = b
	}
	if (f.getAttribute("treeGrid") == "false") {
		var j = $(f).rdatagrid("getRowIndex", h._uuid);
		$(f).rdatagrid("updateRow", {
			index : j,
			row : l
		})
	} else {
		var d = h._uuid;
		$(f).treegrid("update", {
			id : d,
			row : l
		})
	}
}
function refreshReadonlyTableCellValue(j, f, p, k) {
	var d = $(j);
	var c = $.data(j, "rdatagrid");
	var b = c.options;
	var h = c.data;
	var r = c.dc;
	var o = b.editIndex;
	var m = d.rdatagrid("getRowIndex", k._uuid);
	var e = h.rows[m];
	if (p.fieldName == b.select) {
		if (isTrue(k.getValue(b.select))) {
			d.rdatagrid("checkRow", m)
		} else {
			d.rdatagrid("uncheckRow", m)
		}
		e[b.select] = isTrue(k.getValue(b.select));
		b.checked[k.getString(b.pkid)] = k.getValue(b.select);
		return
	}
	if ((o == m) && e) {
		var q = k.getJsonValue(p.fieldName);
		q = q.replace(/</g, "&lt;");
		q = q.replace(/>/g, "&gt;");
		e[p.fieldName] = q;
		var l = r.body.find("tr[datagrid-row-index=" + m + "]");
		l.children("td").each(
				function() {
					var u = $(this).attr("field");
					if (u == p.fieldName || u + "Name" == p.fieldName) {
						var i = $(this).find("div.datagrid-cell");
						var t = i.find("td").children();
						if (t[0]) {
							refreshInputValue(t.size() == 2 ? (t.eq(0).attr(
									"edittype") == null ? t[1] : t[0]) : t[0],
									f, k)
						} else {
							var s = d.rdatagrid("getColumnOption", u);
							if (s) {
								if (s.formatter) {
									i.html(s.formatter(e[u], e, rowId, p, b.id,
											i))
								} else {
									i.html(e[u])
								}
							}
						}
					}
				})
	} else {
		for ( var g = 0; g < h.rows.length; g++) {
			if (h.rows[g][b.idField] == k._uuid) {
				var q = k.getJsonValue(p.fieldName);
				q = q.replace(/</g, "&lt;");
				q = q.replace(/>/g, "&gt;");
				h.rows[g][p.fieldName] = q;
				d.rdatagrid("updateRow", {
					index : m,
					row : h.rows[g]
				});
				break
			}
		}
	}
}
function today() {
	var b = _today_date || new Date();
	return b.format(_VIEW_DATE_PATTERN)
}
function initEditor(c) {
	var d = $(c);
	var b = d.attr("editType");
	var e = d.attr("placeholder");
	switch (b) {
	case "datebox":
	case "datetimebox":
		_dataInitEvent(d, e, b);
		c.setReadOnly = editor_setReadOnly;
		break;
	case "radio":
		initRadioGroup(c);
		break;
	case "checkbox":
		d.bind("click", function(f) {
			_checkboxChangeEvent(f)
		});
		break;
	case "checkboxs":
		initCheckboxs(c);
		break;
	case "password":
	case "validatebox":
	case "textarea":
	case "hidden":
		d.bind("change", function(f) {
			_fieldChangeEvent(f)
		});
		validEditorInput(d);
		d.validatebox();
		break;
	case "numberbox":
		d.bind("change", function(f) {
			_fieldChangeEvent(f)
		});
		validEditorInput(d);
		d.numberbox();
		break;
	default:
		break
	}
	c.setReadOnly = editor_setReadOnly
}
function initCheckboxs(element) {
	var fieldName = element.getAttribute("name");
	eval("var checkboxDataset=" + element.getAttribute("dataField")
			+ "_CheckboxDataset");
	var resultDataset = element.getAttribute("componentDataset");
	var checkboxGroup = new Array();
	var _record = checkboxDataset.getFirstRecord();
	checkboxGroup.push("<div>");
	var rid = $.uuid++;
	while (_record) {
		checkboxGroup.push('<input id="' + fieldName
				+ '" type="checkbox" name="' + fieldName + rid + '" value="'
				+ _record[0] + '" >' + _record[1] + "</input>");
		_record = _record.getNextRecord()
	}
	checkboxGroup.push("</div>");
	var check = $(checkboxGroup.join(""));
	element.appendChild(check[0]);
	$("div", element).andSelf().css("display", "inline");
	$("input[name=" + fieldName + rid + "]").bind("click", function(e) {
		checkboxGroupChangeEvent(e)
	})
}
function checkboxGroupChangeEvent(g) {
	var b = g.target || window.event.srcElement;
	var c = b.parentNode.parentNode;
	if (c) {
		var h = $(c);
		var l = h.attr("dataField");
		var j = $("input", h);
		var k = "";
		for ( var f = 0; f < j.size(); f++) {
			if (j.eq(f)[0].checked) {
				if (k == "") {
					k = j.eq(f)[0].value
				} else {
					k = k + "," + j.eq(f)[0].value
				}
			}
		}
		var d = getDatasetByID(h.attr("componentDataset"));
		setElementValue(c, d, l, k)
	}
}
function setElementValue(b, f, g, c) {
	try {
		if (f.length == 0) {
			f.insertRecord("end")
		}
		_record_setValue(f.record, g, c)
	} catch (d) {
		refreshInputValue(b, f, f.record);
		processException(d);
		$(b).focus()
	}
}
function _editor_setReadOnly(d, b) {
	var e = $(d);
	var c = e.attr("editType");
	var f = b ? "disable" : "enable";
	switch (c) {
	case "datebox":
	case "datetimebox":
	case "dropDownSelect":
		e.combo(f);
		if (b) {
			e.combo("textbox").addClass("input-readonly");
			e.combo("textbox").removeClass("validatebox-invalid")
		} else {
			e.combo("textbox").removeClass("input-readonly")
		}
		break;
	case "radio":
		if (b) {
			e.find("input").attr("disabled", "true")
		} else {
			e.find("input").removeAttr("disabled")
		}
		break;
	case "checkbox":
		if (b) {
			e.attr("disabled", "true")
		} else {
			e.removeAttr("disabled")
		}
		break;
	case "checkboxs":
		if (b) {
			e.find("input").attr("disabled", "true")
		} else {
			e.find("input").removeAttr("disabled")
		}
		break;
	default:
		if (b) {
			e.attr("readonly", "true");
			e.addClass("input-readonly");
			e.removeClass("validatebox-invalid")
		} else {
			e.removeAttr("readonly");
			e.removeClass("input-readonly")
		}
		break
	}
}
function _editor_setRequired(c, e) {
	var d = $(c);
	var b = d.attr("editType");
	if (e) {
		d.attr("required", "required")
	} else {
		d.removeAttr("required");
		d.removeClass("validatebox-invalid")
	}
	switch (b) {
	case "password":
	case "validatebox":
	case "numberbox":
		$.data(c, "validatebox").options.required = e;
		break;
	case "datebox":
	case "datetimebox":
	case "dropDownSelect":
		d.combo("options").required = e;
		if (d.combo("textbox").data("validatebox").options) {
			d.combo("textbox").data("validatebox").options.required = e
		}
		d.combo("textbox").removeClass("validatebox-invalid");
		break;
	case "radio":
		break;
	case "checkbox":
		break;
	default:
		break
	}
}
function editor_setReadOnly(b) {
	_editor_setReadOnly(this, b)
}
function _dataInitEvent(f, g, c, e) {
	var d = true;
	var b = f.attr("dateType") == "postdate" ? "ge"
			: f.attr("dateType") == "predate" ? "le" : f.attr("comparemode");
	if (!g) {
		g = c == "datebox" ? _VIEW_DATE_PATTERN : _VIEW_DATETIME_PATTERN
	}
	f
			.combo({
				type : "date",
				placeholder : g,
				editable : d,
				onInputText : function(k) {
					var j = f.combo("getValue");
					var i = cast(k, c == "datebox" ? "date" : "timestamp");
					var h = i.format(c == "datebox" ? _DATE_PATTERN_
							: _DATETIME_PATTERN_);
					if (h != j) {
						if (h == "") {
							_dateChangeEvent("", f, c)
						} else {
							if ($.type(i) != "date") {
								var l = cast(j, c == "datebox" ? "date"
										: "timestamp");
								$(this)
										.combo(
												"setText",
												l
														.format(c == "datebox" ? _VIEW_DATE_PATTERN
																: _VIEW_DATETIME_PATTERN))
							} else {
								_dateChangeEvent(h, f, c)
							}
						}
					} else {
						$(this).combo(
								"setText",
								i.format(c == "datebox" ? _VIEW_DATE_PATTERN
										: _VIEW_DATETIME_PATTERN))
					}
				},
				oneClick : function() {
					var h = f.combo("options");
					var i = {
						multiple : false,
						formEl : true,
						today : today(),
						editable : d,
						changed : false,
						comparemode : b,
						onChange : function(k, j) {
							h.changed = true
						},
						onShowPanel : function() {
							if (f.combo("getText") == "") {
								try {
									var p = f.datebox("calendar").calendar(
											"options").current;
									var o = "";
									if (c != "datebox") {
										var k = new Date();
										p.setHours(k.getHours());
										p.setMinutes(k.getMinutes(), k
												.getSeconds(), k
												.getMilliseconds());
										o = p.format(_VIEW_DATETIME_PATTERN)
									} else {
										o = p.format(_VIEW_DATE_PATTERN)
									}
									f.combo("setText", o)
								} catch (m) {
								}
							} else {
								if (c != "datebox") {
									var l = f.datebox("calendar");
									var j = cast(f.combo("getText"),
											"timestamp");
									if (j != "NaN" && j != "Invalid Date"
											&& $.type(j) == "date") {
										l.calendar("moveTo", j)
									} else {
									}
								}
							}
						},
						onInputText : h.onInputText
					};
					if (c == "datebox") {
						f.datebox($.extend(i, {
							onSelect : function(j) {
								if (h.changed) {
									h.changed = false
								}
							}
						}))
					} else {
						f.datetimebox($.extend(i, {
							onOk : function(j) {
								if (h.changed) {
									h.changed = false
								}
							}
						}))
					}
					$("div.combo-panel").panel("close");
					f.combo("textbox").focus();
					if (e) {
						f.combo("resize", e)
					}
					f.combo("showPanel")
				}
			});
	f.combo("textbox").parent().addClass("datebox")
}
function _dateChangeEvent(c, e, b) {
	var d = getDatasetByID(e.attr("componentDataset"));
	setElementValue(e[0], d, e.attr("dataField"), c)
}
function _checkboxChangeEvent(g) {
	var i = g.target || window.event.srcElement;
	var b = i.id;
	if (b) {
		var f = $(i);
		var d = f[0].checked;
		var c = getDatasetByID(f.attr("componentDataset"));
		var h = f.attr("dataField");
		setElementValue(i, c, h, d)
	}
}
function editorFieldChangeEvent(b) {
	var c = b.target || window.event.srcElement;
	_fieldChangeEvent(b)
}
function _fieldChangeEvent(k) {
	var b = k.target || window.event.srcElement;
	var h = b.id;
	var o = $(b);
	var c = getDatasetByID(o.attr("componentDataset"));
	var r = o.attr("dataField");
	var j = c.getField(r);
	var s = j.mask;
	var m = j.dataType;
	var l = c.getField(r).maskErrorMessage;
	if (o.attr("extra") != "dropDownSelect") {
		var p = o.val();
		if (p != c.getString(r)) {
			var i;
			if (o.attr("editType") == "numberbox") {
				o.numberbox("fix");
				i = o.numberbox("getValue");
				var g = getValidStr(i);
				if (m != "int") {
					var q = g.indexOf(".");
					g = q > -1 ? g.substring(0, q) : g
				}
				if (g.length > 14 || g.indexOf("e") > -1 || g.indexOf("E") > -1) {
					refreshInputValue(b, c, c.record);
					errAlert(constErrTypeNumber.replace("%s", p));
					o.focus();
					return
				}
			} else {
				i = p
			}
			setElementValue(b, c, r, i)
		}
		if (isUserEventDefined(h + "_onUpdate")) {
			var d = fireUserEvent(h + "_onUpdate", [ o[0] ]);
			if (d) {
				throw d
			}
		}
	}
}
function validFieldLength(f, h) {
	var c = h.size;
	var b = h.dataType;
	if (b == "int" || b == "double" || b == "float" || b == "short"
			|| b == "currency") {
		if (b == "double" || b == "float" || b == "currency") {
			var g = (f + "").split(".")[0];
			var i = parseInt(c);
			var d = i - parseInt(h.scale);
			if (d <= 0) {
				alert(constScaleErr)
			}
			if (g.length > (i - parseInt(h.scale))) {
				setTimeout(function() {
					alert(constIntLength.replace("%a", d)
							.replace("%b", h.scale).replace("%c", g.length))
				}, 10);
				f = cutstr(g, d)
			}
		} else {
			if (f && (f.length > parseInt(c))) {
				setTimeout(function() {
					alert(constLength.replace("%a", f.length).replace("%b", c))
				}, 10);
				f = cutstr(f, parseInt(c))
			}
		}
	} else {
		if (b == "" || b == "string" || b == "String") {
			if (f != "") {
				var e = f.replace(/[^\x00-\xff]/g, "**").length;
				if (e > (parseInt(c))) {
					setTimeout(function() {
						alert(constLength.replace("%a", e).replace("%b", c))
					}, 10)
				}
				f = cutstr(f, c)
			}
		}
	}
	return f
}
function refreshInputValue(element, _dataset, record) {
	var dataField = element.getAttribute("dataField");
	var readOnly = _dataset.getField(dataField).readOnly;
	var _value = record ? record.getValue(dataField) : "";
	element.dataset = _dataset;
	var field = $(element);
	var eventName = "editor_" + dataField + "_onSetValue";
	if (_dataset.loadCompleted && isUserEventDefined(eventName)) {
		var return_result = fireUserEvent(eventName, [ element, _value ]);
		if (return_result == false) {
			return
		}
	}
	switch (element.getAttribute("editType")) {
	case "dropDownSelect":
		var _dropDown = getDropDownByID(element.getAttribute("dropDown"));
		var isStaticSelect = false;
		switch (_dropDown.type) {
		case "list":
			isStaticSelect = true;
		case "dic":
			isStaticSelect = true;
		case "dynamictree":
		case "cq":
			var val = _value.split(",");
			if (element.getAttribute("multi") != "true") {
				field.combo("setValue", _value)
			} else {
				if (!val[0]) {
					val.splice(0, 1)
				}
				field.combo("setValues", val)
			}
			if (isStaticSelect) {
				var tArray = new Array();
				var data = eval(dataField + "_Json");
				if (data) {
					for ( var i = 0; i < val.length; i++) {
						for ( var j = 0; j < data.length; j++) {
							if (val[i] == (data[j].id + "")) {
								tArray.push(data[j].text);
								break
							}
						}
					}
				}
				field.combo("setText", tArray.length == 0 ? _value : tArray
						.join(","))
			} else {
				field.combo("setText",
						_dataset.getValue(dataField + "Name") != "" ? _dataset
								.getValue(dataField + "Name") : _value)
			}
			break;
		case "dialog":
			field.combo("setValue", _value);
			field.combo("setText",
					_dataset.getValue(dataField + "Name") != "" ? _dataset
							.getValue(dataField + "Name") : _value);
			break;
		default:
			field.combo("setValue", _value).combo("setText", _value)
		}
		if (field.hasClass("input-readonly")) {
			break
		}
		if (_dataset.modified) {
			if (!readOnly) {
				field.combo("isValid")
			} else {
				$.data(element, "combo").combo.find("input.combo-text")
						.removeClass("validatebox-invalid")
			}
		} else {
			$.data(element, "combo").combo.find("input.combo-text")
					.removeClass("validatebox-invalid")
		}
		break;
	case "numberbox":
		field.numberbox("setValue", _value);
		if (field.hasClass("input-readonly")) {
			break
		}
		if (_dataset.modified) {
			if (!readOnly) {
				field.validatebox("isValid")
			} else {
				field.removeClass("validatebox-invalid")
			}
		} else {
			field.removeClass("validatebox-invalid")
		}
		break;
	case "datebox":
		var _key = "";
		var dd = cast(_value, "date");
		if ($.type(dd) == "date") {
			_key = dd.format(_DATE_PATTERN_);
			_value = dd.format(_VIEW_DATE_PATTERN)
		} else {
			_key = dd
		}
		field.combo("setValue", _key).combo("setText", _value);
		if (field.hasClass("input-readonly")) {
			break
		}
		if (_dataset.modified) {
			if (!readOnly) {
				field.datebox("isValid")
			} else {
				$.data(element, "combo").combo.find("input.combo-text")
						.removeClass("validatebox-invalid")
			}
		} else {
			$.data(element, "combo").combo.find("input.combo-text")
					.removeClass("validatebox-invalid")
		}
		break;
	case "datetimebox":
		var _key = "";
		var dd = cast(_value, "timestamp");
		if ($.type(dd) == "date") {
			_key = dd.format(_DATETIME_PATTERN_);
			_value = dd.format(_VIEW_DATETIME_PATTERN)
		} else {
			_key = dd
		}
		field.combo("setValue", _key).combo("setText", _value);
		if (field.hasClass("input-readonly")) {
			break
		}
		if (_dataset.modified) {
			if (!readOnly) {
				field.datebox("isValid")
			} else {
				$.data(element, "combo").combo.find("input.combo-text")
						.removeClass("validatebox-invalid")
			}
		} else {
			$.data(element, "combo").combo.find("input.combo-text")
					.removeClass("validatebox-invalid")
		}
		break;
	case "checkbox":
		if (_value) {
			field.attr("checked", true)
		} else {
			field.attr("checked", false)
		}
		break;
	case "checkboxs":
		if (_value !== "") {
			var v = (_value + "").split(",");
			var input = $("input", element);
			for ( var i = 0; i < input.size(); i++) {
				input.eq(i).attr("checked", false);
				for (j = 0; j < v.length; j++) {
					if (input.eq(i)[0].value == v[j]) {
						input.eq(i).attr("checked", true)
					}
				}
			}
		} else {
			var input = $("input", element);
			for ( var i = 0; i < input.size(); i++) {
				input.eq(i).attr("checked", false)
			}
		}
		break;
	case "radio":
		$("input", field).each(function(i) {
			if (this.value == _value) {
				this.checked = true
			} else {
				this.checked = false
			}
		});
		break;
	default:
		field.val(_value);
		if (field.hasClass("input-readonly")) {
			break
		}
		if (_dataset.modified) {
			if (!readOnly) {
				field.validatebox("isValid")
			} else {
				field.removeClass("validatebox-invalid")
			}
		} else {
			field.removeClass("validatebox-invalid")
		}
		break
	}
}
function initFieldlabel(c) {
	var e = $(c);
	e.addClass("form-labeltd");
	var b = e.attr("label");
	var d = getElementField(c);
	if (d) {
		b = d.label
	}
	e.html(b)
}
function refreshDatalabelValue(d, c, f) {
	if (!f) {
		return
	}
	var b = $(d);
	var i = d.getAttribute("dataField");
	var h = f.getValue(i);
	var k = h;
	var g = getElementEventName(d, "onRefresh");
	try {
		if (isUserEventDefined(g)) {
			if (!fireUserEvent(g, [ d, k ])) {
				return
			}
		} else {
			k = _viewformat(c.getField(i), h)
		}
	} catch (j) {
		errAlert("refreshDatalabelValue error")
	}
	b.text(k)
}
function initRadioGroup(element) {
	var fieldName = element.getAttribute("name");
	eval("var radioDataset="
			+ element.getAttribute("id").replace("editor_", "")
			+ "_RadioDataset");
	var resultDataset = element.getAttribute("componentDataset");
	var radioGroup = new Array();
	var _record = radioDataset.getFirstRecord();
	radioGroup.push("<div>");
	var rid = $.uuid++;
	while (_record) {
		radioGroup.push('<input id="' + fieldName + '" type="radio" name="'
				+ fieldName + rid + '" value="' + _record[0] + '" >'
				+ _record[1] + "</input>");
		_record = _record.getNextRecord()
	}
	radioGroup.push("</div>");
	var radio = $(radioGroup.join(""));
	element.appendChild(radio[0]);
	$("div", element).andSelf().css("display", "inline");
	$("input[name=" + fieldName + rid + "]").bind("click", function(e) {
		radioGroupChangeEvent(e, resultDataset)
	})
}
function radioGroupChangeEvent(d, g) {
	var f = d.target || window.event.srcElement;
	var b = f.value;
	var c = getDatasetByID(g);
	c.setValue(f.id, b)
}
function cutstr(f, b) {
	var d = 0;
	var e = 0;
	str_cut = new String();
	e = f.length;
	for ( var c = 0; c < e; c++) {
		a = f.charAt(c);
		d++;
		if (escape(a).length > 4) {
			d++
		}
		str_cut = str_cut.concat(a);
		if (d >= b) {
			return str_cut
		}
	}
	if (d < b) {
		return f
	}
}
function validEditorInput(e) {
	var c = getDatasetByID(e.attr("componentDataset"));
	var f = e.attr("dataField");
	var g = c.getField(f);
	var b = g.mask;
	var d = g.maskErrorMessage;
	if (b) {
		e.attr("validType", b);
		e.attr("msg", d)
	}
}
$.extend($.fn.validatebox.defaults.rules, {
	rul : {
		validator : function(value, param) {
			try {
				param = eval(param);
				return new RegExp(param).test(value)
			} catch (e) {
				return true
			}
		},
		message : function(b) {
			return b
		}
	}
});
function initDropdownTreeClick(d, f, e) {
	var c = isTrue(d.getAttribute("editable"));
	var b = e || setElementValue;
	var g = getDatasetByID(d.getAttribute("componentDataset"));
	$(d).combo({
		editable : c,
		onInputText : function(h) {
			b(d, g, d.getAttribute("dataField"), h);
			b(d, g, d.getAttribute("dataField") + "Name", h)
		},
		oneClick : function() {
			initDropdownTree(d, f, e)
		}
	});
	d.setReadOnly = editor_setReadOnly
}
function initSelectCQClick(d, f, g, e) {
	var c = isTrue(d.getAttribute("editable"));
	var b = e || setElementValue;
	var h = getDatasetByID(d.getAttribute("componentDataset"));
	$(d).combo({
		editable : c,
		onInputText : function(i) {
			b(d, h, d.getAttribute("dataField"), i);
			b(d, h, d.getAttribute("dataField") + "Name", i)
		},
		oneClick : function() {
			initSelectCQCQ(d, f, g, e)
		}
	});
	d.setReadOnly = editor_setReadOnly
}
function initImgCQClick(d, f, g, e) {
	var c = isTrue(d.getAttribute("editable"));
	var b = e || setElementValue;
	var h = getDatasetByID(d.getAttribute("componentDataset"));
	$(d).combo({
		editable : c,
		onInputText : function(i) {
			b(d, h, d.getAttribute("dataField"), i);
			b(d, h, d.getAttribute("dataField") + "Name", i)
		},
		oneClick : function() {
			initSelectCQ(d, f, g, e)
		}
	});
	d.setReadOnly = editor_setReadOnly
}
function initSelectAndDicClick(d, g, f) {
	var c = isTrue(d.getAttribute("editable"));
	var b = f || setElementValue;
	var h = getDatasetByID(d.getAttribute("componentDataset"));
	var e = d.getAttribute("_width");
	$(d).combo({
		editable : c,
		onInputText : function(i) {
			b(d, h, d.getAttribute("dataField"), i);
			b(d, h, d.getAttribute("dataField") + "Name", i)
		},
		oneClick : function() {
			initSelectAndDic(d, g, f);
			if (e) {
				$(d).combobox("resize", e)
			}
		}
	});
	d.setReadOnly = editor_setReadOnly
}
function initSelectCustomClick(d, f, e) {
	var c = isTrue(d.getAttribute("editable"));
	var b = e || setElementValue;
	var g = getDatasetByID(d.getAttribute("componentDataset"));
	$(d).combo({
		editable : c,
		onInputText : function(h) {
			b(d, g, d.getAttribute("dataField"), h);
			b(d, g, d.getAttribute("dataField") + "Name", h)
		},
		oneClick : function() {
			initSelectCustom(d, f, e);
			$(d).combo("showPanel")
		}
	});
	d.setReadOnly = editor_setReadOnly
}
function initSelectDialogClick(d, f, e) {
	var c = isTrue(d.getAttribute("editable"));
	var b = e || setElementValue;
	var g = getDatasetByID(d.getAttribute("componentDataset"));
	$(d).combo({
		editable : c,
		onInputText : function(h) {
			b(d, g, d.getAttribute("dataField"), h);
			b(d, g, d.getAttribute("dataField") + "Name", h)
		},
		oneClick : function() {
			initSelectDialog(d, f, e);
			$("div.combo-panel").panel("close")
		}
	});
	$(d).combo("textbox").parent().addClass("popselect");
	d.setReadOnly = editor_setReadOnly
}
function initDropdownTree(h, i, g, d) {
	var p = g || setElementValue;
	var o = i || setFieldMapValue;
	var l = $(h);
	var c = getDropDownByID(h.getAttribute("dropDown"));
	var f = getDatasetByID(h.getAttribute("componentdataset"));
	var e = getDatasetByID(h.getAttribute("datasetName"));
	var j = copyDataset(h.getAttribute("datasetName") + $.uuid++, h
			.getAttribute("datasetName"));
	j.type = "dropdwon";
	var k = l.attr("dataField");
	var m = isTrue(l.attr("multi"));
	if (m) {
		editable = false
	}
	l.combotree({
		panelHeight : 200,
		init : false,
		async : false,
		isreload : false,
		clearCls : "icon-clear",
		multiple : m,
		dropdownName : l.attr("dropDown"),
		dropdown : c,
		maindataset : f,
		dataset : j,
		currentRecord : {},
		cascadeCheck : m,
		viewField : c.fields || "_id",
		loader : function(u, t, q) {
			var r = l.combotree("options");
			var s = r.dataset;
			s.setParameter("_id", u.id);
			s.flushData(1);
			s.setParameter("_id", null);
			r.loadtype = 1;
			t(r.dataset);
			r.loadtype = 0
		},
		loadFilter : function(r) {
			var q = l.combotree("options");
			return treedataset2json(r, q)
		},
		onChange : function() {
			var q = l.combotree("options");
			q.changed = true
		},
		onBeforeClick : function(u, t) {
			var s = l.combotree("options");
			if (u.canSelected == "false") {
				return false
			}
			if ((s.multiple && t) || !s.multiple) {
				var r = s.dropdownName + "_onSelect";
				var q = (isUserEventDefined(r) && !fireUserEvent(r, [
						s.dropdown, u.attributes.record, this ]));
				if (q) {
					return false
				}
			}
		},
		onClick : function(t, q) {
			var s = l.combotree("options");
			if (!s.multiple && s.changed) {
				s.changed = false;
				if (t.id != "") {
				}
				if (!s.multiple) {
					o(h, s.dropdown.fieldMap, s.maindataset,
							t.attributes.record)
				} else {
					var r = l.combotree("getValues").join(",");
					var u = l.combotree("getText");
					p(h, f, k, r);
					p(h, f, k + "Name", u)
				}
			}
		},
		onShowPanel : function() {
			var q = l.combotree("options");
			var t = c.cached != false;
			if (!q.init || !t) {
				q.dataset.flushData(1);
				l.combotree("loadData", q.dataset);
				q.init = true
			}
			var B = l.combotree("getValues");
			var x = l.combotree("tree");
			var F = x.tree("options");
			var w = function() {
			};
			var y = F.onSelect;
			var C = F.onCheck;
			F.onSelect = w;
			F.onCheck = w;
			x.find("span.tree-checkbox").addClass("tree-checkbox0")
					.removeClass("tree-checkbox1 tree-checkbox2");
			x.find("div.tree-node-selected").removeClass("tree-node-selected");
			var z = [], E = [];
			for ( var u = 0; u < B.length; u++) {
				var A = B[u];
				var D = A;
				var r = x.tree("find", A);
				if (r) {
					D = r.text;
					x.tree("check", r.target);
					x.tree("select", r.target)
				}
				z.push(A);
				E.push(D)
			}
			F.onSelect = y;
			F.onCheck = C
		},
		onInputText : function(q) {
			p(h, f, l.attr("dataField"), q);
			p(h, f, l.attr("dataField") + "Name", q)
		},
		onCheck : function(r, w) {
			var s = l.combotree("tree");
			var v = [], y = [];
			var u = s.tree("getChecked");
			for ( var t = 0; t < u.length; t++) {
				v.push(u[t].id);
				y.push(u[t].text)
			}
			var x = v.join(",");
			var q = y.join(",");
			p(h, f, l.attr("dataField"), x);
			p(h, f, l.attr("dataField") + "Name", q)
		}
	});
	var b = l.combotree("panel");
	b.panel({
		onBeforeOpen : function() {
			var s = h.getAttribute("dropDown") + "_beforeOpen";
			if (isUserEventDefined(s)) {
				var r = fireUserEvent(s, [ q ]);
				if (r) {
					if (r != true) {
						errAlert(r);
						return false
					}
					return false
				}
			}
			var u = l.combotree("options");
			var q = u.dropdown;
			u.outerParam = converDateSetParameter2Str(e);
			var t = q.cached != false;
			if (t) {
				converStr2DataSetParameter(u.outerParam, u.dataset)
			}
		}
	});
	l.combotree("showPanel");
	l.combotree("resize", d)
}
function refreshCustom(h, f, k) {
	var e = h.getAttribute("datasetName");
	var i = h.getAttribute("componentDataset");
	var d = h.getAttribute("id");
	var g = getDatasetByID(e);
	var c = k.url;
	var j = getDatasetByID(i);
	var b = $("<div></div>");
	b.html('<IFRAME frameborder=0 marginheight=0 marginwidth=0 src="'
			+ _application_root + c
			+ '"  style="width:100%;height:100%;"></IFRAME>');
	f.combo({
		panelWidth : "200",
		panelHeight : "300"
	});
	b.appendTo(f.combo("panel"))
}
function initSelectDialog(f) {
	var c = $(f);
	var e = c.attr("componentDataset");
	var d = getDatasetByID(e);
	var h = c.attr("dropDown");
	var b = getDropDownByID(h);
	var g = c.combo("options");
	c.popselect({
		maindataset : d,
		dropdown : b,
		url : _application_root + b.url,
		onInputText : g.onInputText,
		onSelect : function(i) {
			var j = h + "_onSelect";
			needAbort = (isUserEventDefined(j) && !fireUserEvent(j, [ b, i,
					this ]));
			if (needAbort) {
				return
			}
			var k = c.popselect("options");
			setFieldMapValue(f, k.dropdown.fieldMap, k.maindataset, i)
		},
		onShowPanel : function() {
			var j = h + "_beforeOpen";
			if (isUserEventDefined(j)) {
				var i = fireUserEvent(j, [ b ]);
				if (i) {
					if (i != true) {
						errAlert(i);
						return false
					}
					return false
				}
			}
		}
	});
	c.popselect("showPanel")
}
function setFieldMapValue(f, g, h, c) {
	if (g) {
		var b = g.split(";");
		for ( var e = 0; e < b.length; e++) {
			var d = b[e].indexOf("=");
			if (d >= 0) {
				setElementValue(f, h, b[e].substr(0, d), c ? c.getValue(b[e]
						.substr(d + 1)) : "")
			} else {
				setElementValue(f, h, b[e], c ? c.getValue(b[e]) : "")
			}
		}
	}
}
function setMultipleFieldMapValue(f, d, e, h, b) {
	if (d) {
		var k = d.split(";");
		for ( var g = 0; g < k.length; g++) {
			var l = k[g].indexOf("=");
			if (l >= 0) {
				var j = h ? h.getValue(k[g].substr(l + 1)) : "";
				var c = k[g].substr(0, l);
				var m = e.getValue(c);
				if (!m) {
					m = j
				} else {
					if (!b) {
						m = m + "," + j
					} else {
						m = m.replace(j, "").replace(",,", ",");
						if (m.substring(0, 1) == ",") {
							m = m.substring(1)
						}
						if (m.substring(m.length - 1) == ",") {
							m = m.substring(0, m.length - 1)
						}
					}
				}
				setElementValue(f, e, c, m)
			} else {
				var j = h ? h.getValue(k[g]) : "";
				var c = k[g];
				var m = e.getValue(c);
				if (!m) {
					m = j
				} else {
					if (!b) {
						m = m + "," + j
					} else {
						m = m.replace(j, "").replace(",,", ",");
						if (m.substring(0, 1) == ",") {
							m = m.substring(1)
						}
						if (m.substring(m.length - 1) == ",") {
							m = m.substring(0, m.length - 1)
						}
					}
				}
				setElementValue(f, e, c, m)
			}
		}
	}
}
function initSelectCQCQ(u, c, P, N) {
	var q = P || setFieldMapValue;
	var V = N || setElementValue;
	var I = $(u);
	var Y = getDatasetByID(I.attr("componentDataset"));
	var w = copyDataset("_tmp_" + I.attr("datasetName") + $.uuid++, I
			.attr("datasetName"));
	I.attr("tmpdatasetid", w.id);
	w.type = "dropdwon";
	var o = true;
	var A = I.attr("dataField");
	var y = getDropDownByID(I.attr("dropDown"));
	var d = [];
	var S = y.fields ? y.fields.split(",") : [];
	for ( var R = 0; R < S.length; R++) {
		var K = {};
		K.field = S[R];
		var k = w.getField(S[R]);
		K.title = k ? k.label : "undefinedField";
		K.width = 100;
		if (y.type == "img") {
			if (S[R] == "url") {
				K.formatter = function(j, Z, i) {
					return '<div><img src="' + _application_root
							+ "/templets/ui/themes/" + j + '" /></div>'
				}
			}
		}
		d.push(K)
	}
	var Q = new Array();
	Q.push("<div id='div_" + A
			+ "' class='datagrid-view2' style='width:248px;left:0px;'>");
	Q.push("<div id='head_" + A
			+ "' class='datagrid-header' style='height:24px'>");
	Q
			.push("<table class='datagrid-htable'><tbody class='datagrid-header'><tr class='datagrid-header-row'>");
	var C = 0;
	var M = 100;
	for ( var R = 0; R < d.length; R++) {
		if (d.length == 1) {
			M = 250
		}
		if (d.length == 2) {
			M = 125
		}
		Q.push("<td class='datagrid-cell' style='width:" + M + "px'>"
				+ d[R].title + "</td>");
		C++
	}
	Q.push("</tr></tbody></table></div>");
	Q.push("<div id='body_" + A
			+ "' class='datagrid-body' style='width:248px'>");
	Q
			.push("<table class='datagrid-btable' cellspacing='0' cellpadding='0' border='0' style='width:231px;table-layout:auto' ><tbody>");
	var J;
	var g;
	var L;
	var T = w.pageSize || 10;
	var v;
	var r = null;
	w.autoPageNum = T;
	var t = false;
	var G = I.attr("dropDown") + "_beforeOpen";
	var W = 1;
	if (isUserEventDefined(G)) {
		t = fireUserEvent(G, [ y ]);
		W = 3
	}
	var E = false;
	if (w.init == "true" && !t) {
		w.flushData(1);
		J = w.getFirstRecord();
		g = J;
		L = 0;
		var X = 0;
		if (w.length > T) {
			w.autoPageFlag = true;
			v = w.length % w.autoPageNum == 0 ? parseInt(w.length
					/ w.autoPageNum) : parseInt(w.length / T) + 1;
			w.autoPageCount = v
		} else {
			X = T - w.length
		}
		var h = 0;
		while (J) {
			var H = "style='background-color:#fafafa;'";
			if (L % 2) {
				H = ""
			}
			Q.push("<tr class='datagrid-row cqtable' " + H + ">");
			for ( var R = 0; R < d.length; R++) {
				var b = J.getValue(d[R].field);
				if (typeof b == "string") {
					b = b.replace(/ /g, "&nbsp;")
				}
				Q.push("<td class='datagrid-cell' style='height:auto;'>" + b
						+ "</td>")
			}
			Q.push("</tr>");
			J = J.getNextRecord();
			L++;
			h++;
			if (h == T) {
				r = J;
				break
			}
		}
		for ( var R = 0; R < X; R++) {
			var H = "style='background-color:#fafafa;display:none;'";
			if (R % 2) {
				H = "style='display:none;'"
			}
			Q.push("<tr class='datagrid-row cqtable' " + H + ">");
			for ( var O = 0; O < d.length; O++) {
				Q.push("<td class='datagrid-cell' style='height:auto;'></td>")
			}
			Q.push("</tr>")
		}
	} else {
		E = true;
		w.autoPageFlag = false;
		Q.push("<tr class='colorBackground'><td colspan='" + d.length
				+ "' align='center'>no data!</td></tr>")
	}
	Q.push("</tbody>");
	Q.push("</table>");
	Q.push("</div>");
	Q.push('<div class="datagrid-pager pagination">');
	Q.push('<table cellspacing="0" cellpadding="0" border="0"><tbody><tr>');
	Q
			.push('<td><a href="javascript:void(0);" class="l-btn l-btn-plain l-btn-disabled" id="first_'
					+ A
					+ '" ><span class="l-btn-left"><span class="l-btn-text"><span class="l-btn-empty pagination-first">&nbsp;</span></span></span></a></td>');
	Q
			.push('<td><a href="javascript:void(0);" class="l-btn l-btn-plain l-btn-disabled" id="pre_'
					+ A
					+ '" ><span class="l-btn-left"><span class="l-btn-text"><span class="l-btn-empty pagination-prev">&nbsp;</span></span></span></a></td>');
	Q.push('<td><div class="pagination-btn-separator"></div></td>');
	Q.push('<td><span style="padding-left:6px;"></span></td>');
	Q.push('<td><input id="current_' + A
			+ '" class="pagination-num" type="text" value="1" size="2"></td>');
	Q.push('<td>/<span class="pagination-sumNum" id="sumNum_' + A
			+ '" style="padding-right:6px;">2</span></td>');
	Q.push('<td><div class="pagination-btn-separator"></div></td>');
	Q
			.push('<td><a href="javascript:void(0)" class="l-btn l-btn-plain" id="next_'
					+ A
					+ '"><span class="l-btn-left"><span class="l-btn-text"><span class="l-btn-empty pagination-next">&nbsp;</span></span></span></a></td>');
	Q
			.push('<td><a href="javascript:void(0)" class="l-btn l-btn-plain" id="last_'
					+ A
					+ '"><span class="l-btn-left"><span class="l-btn-text"><span class="l-btn-empty pagination-last">&nbsp;</span></span></span></a></td>');
	Q
			.push('<td><div class="pagination-btn-separator"></div></td><td><a href="javascript:void(0)" class="l-btn l-btn-plain" id=""><span class="l-btn-left"><span class="l-btn-text"><span class="l-btn-empty icon-clear" title="清除">&nbsp;</span></span></span></a></td>');
	Q
			.push('</tr></tbody></table><div class="pagination-info"></div><div style="clear:both;"></div></div>');
	Q.push("</div>");
	var f = $(Q.join(""));
	var F = (I.attr("multi") == "true" || I.attr("multi") == true);
	f.multiple = F;
	f.element = u;
	f.fieldMap = y.fieldMap;
	f.maindataset = Y;
	f.dropdown = y;
	f.fieldName = A;
	f._setFieldMapValue = q;
	f.headField = d;
	f.find('.pagination-num').keydown(function(event) {
		switch (event.keyCode) {
		case 13:
			if (!parseInt(this.value)) {
				break;
			}
			var newv = Math.max(parseInt(this.value), 1);
			var maxv = parseInt($('.pagination-sumNum', f).text()) || 1;
			var page = Math.min(maxv, newv);
			if (!w.autoPageFlag) {
				w.flushData(page);
			} else {
				w.autoPageIndex = page;
			}
			loadCustomeTable(f, w, d);
			$('.l-btn-disabled', f).removeClass("l-btn-disabled");
			if (page == 1) {
				$("#pre_" + A, f).addClass("l-btn-disabled");
				$("#first_" + A, f).addClass("l-btn-disabled");
			}
			if (page == maxv) {
				$("#last_" + A, f).addClass("l-btn-disabled");
				$("#next_" + A, f).addClass("l-btn-disabled");
			}
			this.value = page;
			break;
		default:
			break;
		}
	});
	J = w.getFirstRecord();
	var m = $("table tbody tr.cqtable", f).each(
			function() {
				$(this).hover(function() {
					$(this).addClass("datagrid-row-over")
				}, function() {
					$(this).removeClass("datagrid-row-over")
				});
				$(this).data("record", J);
				$(this).bind(
						"click",
						function() {
							var j = I.attr("dropDown") + "_onSelect";
							var i = (isUserEventDefined(j) && !fireUserEvent(j,
									[ y, $(this).data("record"), this ]));
							if (i) {
								return false
							}
							if (F) {
								var Z;
								if ($(this).hasClass("datagrid-row-selected")) {
									$(this)
											.removeClass(
													"datagrid-row-selected");
									Z = true
								} else {
									$(this).addClass("datagrid-row-selected");
									Z = false
								}
								if (!isUserEventDefined(j)) {
									setMultipleFieldMapValue(u, y.fieldMap, Y,
											$(this).data("record"), Z)
								}
							} else {
								f.find("tr.datagrid-row-selected").removeClass(
										"datagrid-row-selected");
								$(this).addClass("datagrid-row-selected");
								q(u, y.fieldMap, Y, $(this).data("record"))
							}
							Y.CachedRecord = $(this).data("record");
							if (!F) {
								I.combo("hidePanel")
							}
						});
				if (J) {
					J = J.getNextRecord()
				}
			});
	if (w.autoPageFlag) {
		f.data("record1", g);
		f.data("record2", r)
	}
	w.autoPageIndex = 1;
	$("#first_" + A, f).bind("click", function() {
		if ($(this).hasClass("l-btn-disabled")) {
			return
		}
		if (!w.autoPageFlag) {
			w.flushData(1)
		} else {
			w.autoPageIndex = 1
		}
		loadCustomeTable(f, w, d);
		$(this).addClass("l-btn-disabled");
		$("#pre_" + A, f).addClass("l-btn-disabled");
		$("#last_" + A, f).removeClass("l-btn-disabled");
		$("#next_" + A, f).removeClass("l-btn-disabled")
	});
	$("#last_" + A, f).bind("click", function() {
		if ($(this).hasClass("l-btn-disabled")) {
			return
		}
		if (!w.autoPageFlag) {
			w.flushData(w.pageCount)
		} else {
			w.autoPageIndex = w.autoPageCount
		}
		loadCustomeTable(f, w, d);
		$(this).addClass("l-btn-disabled");
		$("#next_" + A, f).addClass("l-btn-disabled");
		$("#first_" + A, f).removeClass("l-btn-disabled");
		$("#pre_" + A, f).removeClass("l-btn-disabled")
	});
	$("#pre_" + A, f).bind("click", function() {
		if ($(this).hasClass("l-btn-disabled")) {
			return
		}
		var j = w.autoPageFlag ? w.autoPageIndex : w.pageIndex;
		var i = w.autoPageFlag ? w.autoPageCount : w.pageCount;
		if (i == 1) {
			return
		}
		if (j > 1) {
			if (!w.autoPageFlag) {
				w.flushData(w.pageIndex - 1)
			} else {
				w.autoPageIndex = w.autoPageIndex - 1
			}
			loadCustomeTable(f, w, d)
		}
		$("#next_" + A, f).removeClass("l-btn-disabled");
		$("#last_" + A, f).removeClass("l-btn-disabled");
		if ((j - 1) == 1) {
			$(this).addClass("l-btn-disabled");
			$("#first_" + A, f).addClass("l-btn-disabled")
		}
	});
	$("#next_" + A, f).bind("click", function() {
		if ($(this).hasClass("l-btn-disabled")) {
			return
		}
		var j = w.autoPageFlag ? w.autoPageIndex : w.pageIndex;
		var i = w.autoPageFlag ? w.autoPageCount : w.pageCount;
		if (i == 1) {
			return
		}
		if (j < i) {
			if (!w.autoPageFlag) {
				w.flushData(w.pageIndex + 1)
			} else {
				w.autoPageIndex = w.autoPageIndex + 1
			}
			loadCustomeTable(f, w, d)
		}
		$("#pre_" + A, f).removeClass("l-btn-disabled");
		$("#first_" + A, f).removeClass("l-btn-disabled");
		if ((j + 1) == i) {
			$(this).addClass("l-btn-disabled");
			$("#last_" + A, f).addClass("l-btn-disabled")
		}
	});
	$("#sumNum_" + A, f).html(w.pageCount);
	$("#current_" + A, f).val(w.pageIndex);
	var e = w.pKey || [];
	if (e.length > 0) {
		var l = $("<div style='height:auto'></div>").addClass(
				"datagrid-toolbar").prependTo(f);
		var z = $(
				"<table class='combogrid-where' width='100%' border='0'></table>")
				.appendTo(l);
		for ( var R = 0; R < e.length; R++) {
			if (e[R].name && e[R].name.startWith("value")) {
				var p = $("<label for='" + e[R].name + "'>" + e[R].desc
						+ "</label>");
				var x = $(
						"<input name='" + e[R].name
								+ "' type='text' style='width:100px;' >")
						.validatebox();
				var U = $("<tr style='display: inline;'></tr>").append(
						$("<td></td>").append(p)).append(
						$("<td></td>").append(x));
				U.appendTo(z)
			}
		}
		var B = $("<a href='javascript:void(0);' style='margin-left:5px'/>");
		B.linkbutton({
			plain : true,
			iconCls : "icon-search"
		});
		function s() {
			fireUserEvent("doQuery_onClick", []);
			z.find("input").each(function() {
				w.setParameter(this.name, this.value || "%%")
			});
			w.flushData(1);
			w.autoPageIndex = 1;
			w.doQuery = true;
			$("table tbody tr.cqtable", f).remove();
			loadCustomeTable(f, w, d, true)
		}
		z.find("input").keydown(function(i) {
			if (i.keyCode == 13) {
				s()
			}
		});
		B.click(function() {
			s()
		});
		z.find("td:last").append(B)
	} else {
		w.init = "true"
	}
	$(".icon-clear", f).bind("click", function() {
		V(u, Y, I.attr("dataField"), "");
		V(u, Y, I.attr("dataField") + "Name", "");
		I.combo("hidePanel")
	});
	f.comboOnInit = w.init == "true";
	function D(ab) {
		var aa = I.combo("options");
		var i = I.combo("panel");
		var j = i.find("tr.datagrid-row-selected");
		var Z;
		if (j.length) {
			Z = ab > 0 ? j.next() : j.prev();
			if (!Z.length) {
				Z = i.find("tr.cqtable:" + (ab > 0 ? "first" : "last"))
			}
		} else {
			Z = i.find("tr.cqtable:" + (ab > 0 ? "first" : "last"))
		}
		if (Z.length) {
			j.removeClass("datagrid-row-selected");
			Z.addClass("datagrid-row-selected")
		}
		var ae = f.find(".datagrid-body");
		var ad = Z.position().top - f.find(".datagrid-toolbar").outerHeight()
				- f.find(".datagrid-header").outerHeight() + ae.scrollTop();
		var ac = ae.height();
		if (ad < ac) {
			ae.scrollTop(0)
		} else {
			ae.scrollTop(ad)
		}
	}
	I.combo({
		panelWidth : C > 2 ? 100 * C : 250,
		panelHeight : 280,
		fit : true,
		doinit : true,
		onShowPanel : function() {
			o = typeof (y.cached) == "boolean" ? y.cached : true;
			if (f.comboOnInit && !o && E) {
				var i = $("table tbody tr.cqtable", f);
				$(".pagination-sumNum").html("1");
				i.remove();
				w.flushData(1);
				loadCustomeTable(f, w, d, !o);
				w.autoPageIndex = 1;
				$("#pre_" + A, f).addClass("l-btn-disabled");
				$("#first_" + A, f).addClass("l-btn-disabled");
				$(".pagination-num", f).val(1)
			}
			E = true;
			setTimeout(function() {
				if (z) {
					z.find("input:first").focus()
				}
			}, 1)
		},
		onBeforeShowPanel : function() {
			if (W == 2) {
				var j = I.attr("dropDown") + "_beforeOpen";
				var i = fireUserEvent(j, [ y ]);
				if (i) {
					if (i != true) {
						errAlert(i);
						return false
					}
					return false
				}
			} else {
				W = 2;
				if (t) {
					return false
				} else {
					return true
				}
			}
		},
		onHidePanel : function() {
		},
		keyHandler : {
			up : function() {
				D(-1)
			},
			down : function() {
				D(1)
			},
			enter : function() {
			}
		}
	});
	I.combo("panel").attr("tabindex", 0).bind("keydown.combo", function(j) {
		var i = I.data("combo").options;
		if (i.multiple) {
			return
		}
		var Z = I[0];
		switch (j.keyCode) {
		case 38:
			i.keyHandler.up.call(Z);
			return false;
		case 40:
			i.keyHandler.down.call(Z);
			return false;
		case 27:
			I.combo("hidePanel");
			break;
		default:
			break
		}
	});
	f.appendTo(I.combo("panel"));
	if (w.length == 0) {
		$("#next_" + A, f).addClass("l-btn-disabled");
		$("#last_" + A, f).addClass("l-btn-disabled")
	}
	I.combo("showPanel");
	cqResize(f)
}
function cqResize(h) {
	var c = h.headField;
	var f = h.find(".datagrid-toolbar").height();
	var g = h.find(".pagination").height();
	var e = h.find(".datagrid-header").height();
	h.find(".datagrid-body").height(280 - f - g - e - 5);
	for ( var d = 0; d < c.length; d++) {
		var b = h.find(".datagrid-body td").eq(d).width();
		if (b) {
			h.find(".datagrid-header td").eq(d).width(b)
		}
	}
}
function loadCustomeTable(A, s, m, t) {
	var h = null;
	if (t) {
		h = s.getFirstRecord()
	}
	A.comboOnInit = true;
	var w = $("table tbody tr.cqtable", A);
	if (!t) {
		var c = s.autoPageIndex;
		if (s.autoPageFlag && !s.doQuery) {
			h = A.data("record" + c);
			if (!h) {
				h = s.getFirstRecord();
				var q = s.autoPageNum * (c - 1);
				var r = 0;
				while (r < q) {
					h = h.getNextRecord();
					r++
				}
				A.data("record" + c, h.getNextRecord())
			}
		} else {
			h = s.getFirstRecord()
		}
		w.each(function() {
			var i = $(this);
			i.data("record", h);
			if (!h) {
				$(this).css("display", "none")
			} else {
				$(this).css("display", "")
			}
			$("td", i).each(function(G) {
				var I = $(this);
				if (h) {
					var H = h.getValue(m[G].field);
					if (typeof H == "string") {
						H = H.replace(/ /g, "&nbsp;")
					}
					I.html(H)
				} else {
					I.html("")
				}
			});
			if (h) {
				h = h.getNextRecord()
			}
		})
	}
	if (w.size() == 0) {
		A.find(".colorBackground").remove();
		A.data("record1", h);
		var p = h;
		var j = 0;
		var d;
		var e = null;
		var o = A.autoPageNum;
		if (s.length > s.autoPageNum) {
			s.autoPageFlag = true;
			d = s.length % s.autoPageNum == 0 ? parseInt(s.length
					/ s.autoPageNum) : parseInt(s.length / s.autoPageNum) + 1;
			s.autoPageCount = d
		} else {
			s.autoPageCount = 1
		}
		var u = 0;
		var b = new Array();
		var m = A.headField;
		var f = A.element;
		var E = $(f);
		var F = getDatasetByID(E.attr("componentDataset"));
		var D = F.CachedRecord;
		while (h) {
			var k = "style='background-color:#fafafa';";
			if (j % 2) {
				k = ""
			}
			var v = "";
			if (D && h.toString() == D.toString()) {
				v = "datagrid-row-selected"
			}
			b.push("<tr class='datagrid-row " + v + " cqtable' " + k + ">");
			for ( var y = 0; y < m.length; y++) {
				var x = h.getValue(m[y].field);
				if (typeof x == "string") {
					x = x.replace(/ /g, "&nbsp;")
				}
				b.push("<td class='datagrid-cell' style='height:auto;'>" + x
						+ "</td>")
			}
			h = h.getNextRecord();
			j++;
			u++;
			if (u == s.autoPageNum) {
				e = h;
				break
			}
		}
		var g = $(b.join(""));
		g.appendTo($("table tbody", $(".datagrid-body", A)));
		var C = A.multiple;
		var l = A.fieldMap;
		var z = A.dropdown;
		var B = A._setFieldMapValue;
		h = p;
		A
				.find(".cqtable")
				.each(
						function() {
							$(this).hover(function() {
								$(this).addClass("datagrid-row-over")
							}, function() {
								$(this).removeClass("datagrid-row-over")
							});
							$(this).data("record", h);
							$(this)
									.bind(
											"click",
											function() {
												if (C) {
													var H;
													if ($(this)
															.hasClass(
																	"datagrid-row-selected")) {
														$(this)
																.removeClass(
																		"datagrid-row-selected");
														H = true
													} else {
														$(this)
																.addClass(
																		"datagrid-row-selected");
														H = false
													}
													setMultipleFieldMapValue(f,
															l, F, $(this).data(
																	"record"),
															H)
												} else {
													A
															.find(
																	"tr.datagrid-row-selected")
															.removeClass(
																	"datagrid-row-selected");
													$(this)
															.addClass(
																	"datagrid-row-selected");
													B(f, l, F, $(this).data(
															"record"))
												}
												F.CachedRecord = $(this).data(
														"record");
												var G = $(f).attr("dropDown")
														+ "_onSelect";
												var i = (isUserEventDefined(G) && !fireUserEvent(
														G,
														[
																z,
																$(this)
																		.data(
																				"record"),
																this ]));
												if (i) {
													return false
												}
												if (!C) {
													$(f).combo("hidePanel")
												}
											});
							if (h) {
								h = h.getNextRecord()
							}
						})
	}
	if (s.autoPageFlag) {
		if (!s.doQuery) {
			A.data("record" + (s.autoPageIndex + 1), h)
		}
		if (s.length <= s.autoPageNum) {
			$("#next_" + A.fieldName, A).addClass("l-btn-disabled");
			$("#last_" + A.fieldName, A).addClass("l-btn-disabled")
		} else {
			$("#next_" + A.fieldName, A).removeClass("l-btn-disabled");
			$("#last_" + A.fieldName, A).removeClass("l-btn-disabled")
		}
		$(".pagination-num", A).val(s.autoPageIndex);
		if (!s.doQuery) {
			$(".pagination-sumNum").html(s.autoPageCount)
		} else {
			$(".pagination-sumNum").html(
					(parseInt(s.length / s.autoPageNum) + 1))
		}
	} else {
		if (s.pageCount == 1) {
			$("#next_" + A.fieldName, A).addClass("l-btn-disabled");
			$("#last_" + A.fieldName, A).addClass("l-btn-disabled")
		} else {
			$("#next_" + A.fieldName, A).removeClass("l-btn-disabled");
			$("#last_" + A.fieldName, A).removeClass("l-btn-disabled")
		}
		$(".pagination-num", A).val(s.pageIndex);
		$(".pagination-sumNum").html(s.pageCount)
	}
	cqResize(A);
	s.doQuery = false
}
function initSelectCQ(q, b, H, G) {
	var l = H || setFieldMapValue;
	var M = G || setElementValue;
	var B = $(q);
	var N = getDatasetByID(B.attr("componentDataset"));
	var j = getDatasetByID(B.attr("datasetName"));
	var t = copyDataset("_tmp_" + B.attr("datasetName") + $.uuid++, B
			.attr("datasetName"));
	B.attr("tmpdatasetid", t.id);
	t.type = "dropdwon";
	var y = B.attr("dataField");
	var v = getDropDownByID(B.attr("dropDown"));
	var d = [];
	var K = v.fields ? v.fields.split(",") : [];
	for ( var I = 0; I < K.length; I++) {
		var D = {};
		D.field = K[I];
		var g = t.getField(K[I]);
		D.title = g ? g.label : "undefinedField";
		D.width = 100;
		if (v.type == "img") {
			if (K[I] == "url") {
				D.formatter = function(s, O, i) {
					return '<div><img src="' + _application_root
							+ "/templets/ui/themes/" + s + '" /></div>'
				}
			}
		}
		d.push(D)
	}
	var J = v.fieldMap ? v.fieldMap.split(";") : [];
	var o = "";
	var w = "";
	for ( var I = 0; I < J.length; I++) {
		var E = J[I].split("=");
		if (E[0] == (y + "Name")) {
			o = E[1]
		} else {
			if (E[0] == y) {
				w = E[1]
			}
		}
	}
	var A = (B.attr("multi") == "true" || B.attr("multi") == true);
	if (A) {
		editable = false
	}
	B.combogrid({
		dd : {},
		panelWidth : 250,
		panelHeight : 300,
		idField : w,
		multiple : A,
		textField : o,
		columns : [ d ],
		pagination : true,
		nowrap : false,
		init : false,
		pageCache : false,
		cache : {},
		dataset : t,
		onShowPanel : function() {
			setTimeout(function() {
				B.combogrid("panel").find(".combogrid-where input:first")
						.focus()
			}, 1);
			var s = B.combogrid("options");
			var O = v.cached != false;
			if (t.init != "true" && O) {
				return
			}
			if (!O || !s.init) {
				s.dataset.flushData(1);
				B.combogrid("grid").datagrid("loadData", s.dataset.toJson());
				s.init = true
			}
			var V = B.combogrid("getValues");
			var R = B.combogrid("grid");
			var W = R.datagrid("options");
			var Q = function() {
			};
			var T = W.onUnselectAll;
			var U = W.onSelect;
			W.onUnselectAll = Q;
			W.onSelect = Q;
			R.datagrid("clearSelections");
			for ( var P = 0; P < V.length; P++) {
				var S = R.datagrid("getRowIndex", V[P]);
				if (S >= 0) {
					R.datagrid("selectRow", S)
				}
			}
			W.onUnselectAll = T;
			W.onSelect = U
		},
		onChange : function() {
			var i = B.combogrid("options");
			i.changed = true
		},
		onHidePanel : function() {
		},
		onLoadSuccess : function(s) {
			var i = B.combogrid("options");
			if (i.dataset.pageSize < i.dataset.length) {
				i.pageCache = true;
				i.cache["cache-data"] = i.dataset
			} else {
			}
		}
	});
	B.combo("resize", b);
	var r = B.combogrid("panel");
	r.panel({
		onBeforeOpen : function() {
			var s = B.attr("dropDown") + "_beforeOpen";
			if (isUserEventDefined(s)) {
				var i = fireUserEvent(s, [ v ]);
				if (i) {
					if (i != true) {
						errAlert(i);
						return false
					}
					return false
				}
			}
			var P = B.combogrid("options");
			P.outerParam = converDateSetParameter2Str(j);
			var O = v.cached != false;
			if (O) {
				converStr2DataSetParameter(P.outerParam, P.dataset)
			}
		}
	});
	var C = B.combogrid("grid");
	C.datagrid({
		isdropdown : true,
		singleSelect : !A,
		fitColumns : true,
		onLoadSuccess : function(i) {
			if (!v.cached) {
				C.datagrid("clearSelections")
			}
		},
		onBeforeClickRow : function(Q, P, O) {
			var s = B.attr("dropDown") + "_onSelect";
			var i = (isUserEventDefined(s) && !fireUserEvent(s, [ v, P.record,
					this ]));
			if (i) {
				return false
			}
		},
		onClickRow : function(Q, O) {
			var s = B.combogrid("options");
			if (s.multiple) {
				var i = B.combogrid("getValues").join(",");
				var P = B.combogrid("getText");
				M(q, N, B.attr("dataField"), i);
				M(q, N, B.attr("dataField") + "Name", P)
			} else {
				if (s.changed) {
					s.changed = false;
					l(q, v.fieldMap, N, O.record)
				}
				B.combo("hidePanel")
			}
		},
		onSelect : function(s, i) {
			e(i, 1)
		},
		onUnselect : function(s, i) {
			e(i, 0)
		},
		rowStyler : function(i, s) {
			if (i % 2 == 1) {
				return "background-color:#fafafa;"
			}
		}
	});
	function e(R, Q) {
		var i = B.combo("getValues");
		var S = B.combo("getText");
		if (!B.data("combo").options.multiple) {
			B.combo("setValues", [ R[w] ]);
			B.combo("setText", R[o]);
			return
		}
		var P = [], s = [];
		P = i;
		s = S ? S.split(",") : [];
		var O = $.inArray(R[w], P);
		if (Q == 0) {
			if (O > -1) {
				P.splice(O, 1);
				s.splice(O, 1)
			}
		} else {
			if (Q == 1) {
				if (O == -1) {
					P.push(R[w]);
					s.push(R[o])
				}
			}
		}
		B.combo("setValues", P);
		B.combo("setText", s.join(","))
	}
	var f = t.pKey || [];
	if (f.length > 0) {
		var c = C.datagrid("getPanel");
		var h = $("<div style='height:auto'></div>").addClass(
				"datagrid-toolbar").prependTo(c);
		var x = $(
				"<table class='combogrid-where' width='100%' border='0'></table>")
				.appendTo(h);
		for ( var I = 0; I < f.length; I++) {
			if (f[I].name && f[I].name.startWith("value")) {
				var k = $("<label for='" + f[I].name + "'>" + f[I].desc
						+ "</label>");
				var u = $(
						"<input name='" + f[I].name
								+ "' type='text' style='width:100px;' >")
						.validatebox();
				var L = $("<tr style='display: inline;'></tr>").append(
						$("<td></td>").append(k)).append(
						$("<td></td>").append(u));
				L.appendTo(x)
			}
		}
		var z = $("<a href='javascript:void(0);' style='margin-left:5px'/>");
		z.linkbutton({
			plain : true,
			iconCls : "icon-search"
		});
		function p() {
			fireUserEvent("doQuery_onClick", []);
			x.find("input").each(function() {
				t.setParameter(this.name, this.value || "%%")
			});
			t.flushData(1);
			B.combogrid("grid").datagrid("loadData", t.toJson())
		}
		x.find("input").keydown(function(i) {
			if (i.keyCode == 13) {
				p()
			}
		}).bind("keydown.combo", function(s) {
			var i = B.data("combo").options;
			var O = B[0];
			switch (s.keyCode) {
			case 38:
				i.keyHandler.up.call(O);
				break;
			case 40:
				i.keyHandler.down.call(O);
				break;
			case 27:
				B.combo("hidePanel");
				break;
			default:
				break
			}
		});
		z.click(function() {
			p()
		});
		x.find("td:last").append(z)
	} else {
		t.init = "true"
	}
	var F = [ N.pageSize ];
	var m = C.datagrid("getPager");
	m.pagination({
		showRefresh : false,
		showPageList : false,
		pageSize : t.pageSize || 10,
		displayMsg : "",
		beforePageText : "",
		afterPageText : "/{pages}",
		buttons : [ {
			iconCls : "icon-clear",
			handler : function() {
				C.datagrid("clearSelections");
				l(q, v.fieldMap, N, null)
			}
		} ],
		onSelectPage : function(O, s) {
			var P = B.combogrid("options");
			var i;
			if (P.pageCache) {
				i = P.cache["cache-data"]
			} else {
				i = P.dataset;
				i.flushData(O)
			}
			i.setParameter("nextPage", O);
			i.setParameter("everyPage", s);
			i.pageIndex = O;
			i.pageSize = s;
			C.datagrid("loadData", i.toJson())
		}
	});
	B.combogrid("showPanel")
}
function initSelectAndDic(element) {
	var select = $(element);
	var datasetName = select.attr("datasetName");
	var maindatasetName = select.attr("componentDataset");
	var _dropdown_dataset = getDatasetByID(datasetName);
	var _maindataset = getDatasetByID(maindatasetName);
	var dropdownName = select.attr("dropDown");
	var _dropdown = getDropDownByID(select.attr("dropDown"));
	var multiple = select.attr("multi");
	var textArray1 = new Array();
	var tArray1 = new Array();
	select.combobox({
		panelHeight : _dropdown_dataset.length > 10 ? 300 : "auto",
		maindataset : _maindataset,
		dropdowndataset : _dropdown_dataset,
		onBeforeSelect : function(value) {
			var eventName = dropdownName + "_onSelect";
			needAbort = (isUserEventDefined(eventName) && !fireUserEvent(
					eventName, [ _dropdown, value.record, this ]));
			if (needAbort) {
				return false
			}
		},
		onSelect : function(value) {
			var opts = select.combobox("options");
			if (value.id) {
				var values = select.combobox("getValues");
				setElementValue(element, opts.maindataset, select
						.attr("dataField"), values.join(","));
				if (!opts.multiple) {
					setElementValue(element, opts.maindataset, select
							.attr("dataField")
							+ "Name", value.text)
				} else {
					var textArray = new Array();
					var tArray = new Array();
					var data = eval(select.attr("dataField") + "_Json");
					for ( var i = 0; i < values.length; i++) {
						for ( var j = 0; j < data.length; j++) {
							if (values[i] == data[j].id) {
								textArray.push(data[j]);
								tArray.push(data[j].text);
								break
							}
						}
					}
					textArray1 = textArray;
					tArray1 = tArray;
					setElementValue(element, opts.maindataset, select
							.attr("dataField")
							+ "Name", tArray.join(","))
				}
			} else {
				textArray1 = new Array();
				setElementValue(element, opts.maindataset, select
						.attr("dataField"), "");
				select.combobox("clear")
			}
		},
		onUnselect : function(value) {
			var opts = select.combobox("options");
			var _dropdown_dataset = opts.dropdowndataset;
			var eventName = dropdownName + "_onUnSelect";
			needAbort = (isUserEventDefined(eventName) && !fireUserEvent(
					eventName, [ _dropdown, value.record, this ]));
			if (needAbort) {
				return
			}
			if (opts.multiple) {
				for ( var i = 0; i < textArray1.length; i++) {
					if (textArray1[i].id == value.id) {
						textArray1.splice(i, 1);
						tArray1.splice(i, 1);
						break
					}
				}
				var values = select.combobox("getValues");
				setElementValue(element, opts.maindataset, select
						.attr("dataField"), values.join(","));
				setElementValue(element, opts.maindataset, select
						.attr("dataField")
						+ "Name", tArray1.join(","))
			}
		},
		onInputText : function(value) {
			var opts = select.combobox("options");
			setElementValue(element, opts.maindataset,
					select.attr("dataField"), value)
		}
	});
	select.combobox("panel").panel({
		onBeforeOpen : function() {
			$(this).find(".combobox-item").css("height", "14px");
//			$(this).find(".combobox-item:first[value=]").css("height", "14px");
			var eventName = dropdownName + "_beforeOpen";
			if (isUserEventDefined(eventName)) {
				var result = fireUserEvent(eventName, [ _dropdown ]);
				if (result) {
					if (result != true) {
						errAlert(result);
						return false
					}
					return false
				}
			}
		}
	});
	var json = [];
	if (true) {
		var row = {
			id : "",
			text : ""
		};
		json[0] = row
	}
	var record = _dropdown_dataset.getFirstRecord();
	while (record) {
		if (record[0]) {
			var row = {};
			row.id = record[0];
			row.text = record[1];
			row.record = record;
			json[json.length] = row
		}
		record = record.getNextRecord()
	}
	select.combobox("loadData", json);
	select.combobox("showPanel")
}
function treedataset2json(e, b) {
	var j = [];
	if (e.length > 0) {
		var i = e.getFirstRecord();
		if (b.loadtype != 1 && !b.multiple) {
			var k = {};
			k.id = "";
			k.text = "";
			k.state = "open";
			k.iconCls = b.clearCls;
			k.attributes = {};
			j[0] = k
		}
		var f = {};
		while (i) {
			var k = {};
			var d = {};
			d.record = i;
			k.id = i.getValue("_id");
			var c = i.getString("_state")
					|| (i.getString("_hasChild_") == "true" ? "closed" : "open");
			k.state = c;
			k.pid = i.getString("_parentId");
			k.text = i.getString(b.viewField);
			k.iconCls = i.getString("_icon");
			k.canSelected = i.getString("_canSelected_");
			k.checked = i.getString("_checked") == "true";
			k.attributes = d;
			k.children = [];
			f[k.id] = k;
			i = i.getNextRecord()
		}
		i = e.getFirstRecord();
		while (i) {
			var h = i.getValue("_id");
			var k = f[h];
			var g = f[k.pid];
			if (g) {
				g.children[g.children.length] = k
			} else {
				j[j.length] = k
			}
			i = i.getNextRecord()
		}
	}
	return j
}
function refreshComboGrid(element, combo, dropdown) {
	var datasetName = element.getAttribute("datasetName");
	var resultName = element.getAttribute("componentDataset");
	var id = element.getAttribute("id");
	var _dataset = getDatasetByID(datasetName);
	var resultDataset = getDatasetByID(resultName);
	_dataset.flushData(1);
	var pKey = _dataset.pKey;
	var div = [];
	var selectField = new Array();
	div.push('<div style="overflow-x:hidden" >');
	div.push('<input id="forfocus_' + id + '" style="margin-left:-200px;">');
	div.push('<table style="float:right"><tr><td>');
	div.push("<table >");
	for ( var i = 0; i < pKey.length; i++) {
		if (pKey[i].name.substring(0, 5) == "value") {
			if (i == 0) {
				div
						.push('<tr><td sytle="width:50px" colspan="2"><div>'
								+ pKey[i].desc
								+ '</div></td><td colspan="2"><input  type="text" dropdown="text" style="width:100px;" ></td><td></td></tr>')
			} else {
				div
						.push('<tr><td sytle="width:50px" colspan="2"><div>'
								+ pKey[i].desc
								+ '</div></td><td colspan="2"><input  type="text" dropdown="text" style="width:100px" ></td></tr>')
			}
		}
	}
	div.push("</table></td></tr>");
	div
			.push('<tr><table border="0" cellpadding="0" cellspacing="0"><tbody><tr>');
	div
			.push('<td><a class="l-btn l-btn-plain l-btn-disabled" href="javascript:void(0)" icon="pagination-first"><span class="l-btn-left"><span class="l-btn-text">');
	div
			.push('<span class="l-btn-empty pagination-first">&nbsp;</span></span></span></a></td>');
	div
			.push('<td><a class="l-btn l-btn-plain l-btn-disabled" href="javascript:void(0)" icon="pagination-prev"><span class="l-btn-left"><span class="l-btn-text">');
	div
			.push('<span class="l-btn-empty pagination-prev">&nbsp;</span></span></span></a></td><td><div class="pagination-btn-separator"></div></td>');
	div
			.push('<td><input id="'
					+ id
					+ '_DDIndex" class="pagination-num" value="1" size="2" type="text"></td><td><span id="pageCount111" style="padding-right:6px;">/'
					+ _dataset.pageCount + "</span></td>");
	div
			.push('<td><div class="pagination-btn-separator"></div></td><td><a class="l-btn l-btn-plain l-btn-disabled" href="javascript:void(0)" icon="pagination-next">');
	div
			.push('<span class="l-btn-left"><span class="l-btn-text"><span class="l-btn-empty pagination-next">&nbsp;</span></span></span></a></td>');
	div
			.push('<td><a class="l-btn l-btn-plain l-btn-disabled" href="javascript:void(0)" icon="pagination-last"><span class="l-btn-left"><span class="l-btn-text">');
	div
			.push('<span class="l-btn-empty pagination-last">&nbsp;</span></span></span></a></td><td><a id="dropdownClear" href="#" class="easyui-linkbutton" plain="true" iconCls="icon-cancel" title="清空"></a></td></tr></tbody></table><div style="clear:both;"></div>');
	div.push("</tr></table></td></tr><tr><td>");
	var dsave = div.length;
	div.push("<table>");
	div.push("<thead><tr>");
	var dropFields = dropdown.fields;
	dropFields = dropFields.split(",");
	var sumWidth = 0;
	for ( var i = 0; i < dropFields.length; i++) {
		var fi = dropFields[i].split(":");
		var fh = fi[1];
		if (!fi[1]) {
			if (dropFields.length == 1) {
				fh = "220"
			} else {
				fh = "100"
			}
		}
		div.push("<th field=" + fi[0] + ' width="' + fh + '">funcId</th>');
		selectField.push(fi[0]);
		sumWidth = sumWidth + parseInt(fh)
	}
	div.push("</tr></thead></table></td></tr></table>");
	div.push("</div>");
	if (_dataset.length >= 10) {
		div[dsave] = '<table  id="' + id
				+ '_d"  class="easyui-datagrid" style="width:' + (sumWidth + 6)
				+ 'px;height:285px" singleSelect="true">'
	} else {
		div[dsave] = '<table  id="' + id
				+ '_d"  class="easyui-datagrid" style="width:' + (sumWidth + 6)
				+ 'px;" autoHeight="true" singleSelect="true">'
	}
	var d = $(div.join(""));
	var w = null;
	var h = null;
	if (pKey[0]) {
		w = pKey[0].width;
		h = pKey[0].height
	}
	$("#" + id + "_m").replaceWith(d);
	if (!w) {
		w = sumWidth
	}
	if (!h) {
		h = "auto"
	}
	var grid = $("#" + id + "_d");
	grid.datagrid();
	var JsonObject = new Object();
	var recordObject = new Object();
	eval("JsonObject.a"
			+ 1
			+ '=loadDataToGrid(combo,selectField,_dataset,"",grid,dropdown,recordObject);');
	_dataset.setParameter("cacheIndex", 0);
	combo.combo({
		panelWidth : parseInt(w) + 7,
		panelHeight : h
	});
	d.appendTo(combo.combo("panel"));
	dropDownBindEvent(combo, grid, _dataset, resultDataset, dropdown, pKey,
			selectField, id, dropdown, JsonObject, recordObject);
	SArray.put(id, recordObject.a1)
}
function dropDownInterface(g, f, c, e, h, d) {
	var b = $("input[dropdown=text]");
	b.bind("click", function() {
		$(this).focus()
	});
	b.bind("keydown", function(l) {
		var k = l.which;
		if (k == 13) {
			for ( var j = 0; j < b.length; j++) {
				f.setParameter(c[j].name, b.eq(j).val())
			}
			f.flushData(1);
			loadDataToGrid(g, e, f, h, "", "", d);
			$("#" + h + "_DDIndex").val(1);
			$("#pageCount111").text("/" + f.pageCount);
			return false
		}
	})
}
function dropDownBindEvent(A, b, z, y, w, B, k, p, w, x, e) {
	var t = A.combo("panel");
	var l = $("tbody tr.datagrid-row", t);
	var v = $("#pageCount111", t);
	var o = w.fieldMap.split(";");
	var c = w.id.replace("_DropDown", "");
	var h = new Array();
	var r = new Array();
	var q = null;
	var g = null;
	if (z.pageCount == 1) {
		v.text("/" + x.a1.length)
	}
	for ( var u = 0; u < o.length; u++) {
		var m = o[u].split("=");
		if (m[0] == (c + "Name")) {
			q = m[1]
		}
		if (m[0] == c) {
			g = m[1]
		}
		h.push(m[0]);
		r.push(m[1])
	}
	var f = 0;
	t.bind("keydown", function(G) {
		var E = G.which;
		if (E == 38) {
			t.focus();
			if (f > 0) {
				f--;
				b.datagrid("selectRow", f)
			}
			return false
		}
		if (E == 40) {
			t.focus();
			if (f < l.length - 1) {
				f++;
				b.datagrid("selectRow", f)
			}
			return false
		}
		if (E == 37) {
			dropDownPrev(b, k, p, z, A, x, w, e);
			if (z.pageCount != 1) {
				f = 0
			}
			return false
		}
		if (E == 39) {
			dropDownNext(b, k, p, z, A, x, w, e);
			if (z.pageCount != 1) {
				f = 0
			}
			return false
		}
		if (E == 13) {
			A.combo("hidePanel");
			var C = SArray.get(p)[f];
			f = 0;
			var F = C.getValue(q);
			y.setValue(c, F);
			for ( var D = 0; D < h.length; D++) {
				y.setValue(h[D], C.getValue(r[D]))
			}
			fireUserEvent(A.attr("dropDown") + "_onSelect", [ w,
					SArray.get(p)[rowIndex], A[0] ]);
			return false
		}
	});
	var j = [];
	var d = [];
	var s = [];
	b.datagrid({
		onClickRow : function(K, E) {
			fireUserEvent(A.attr("dropDown") + "_onSelect", [ w,
					SArray.get(p)[K], A[0] ]);
			var F = E[g];
			var D = E[q];
			if (A.attr("multi") == "false") {
				b.datagrid("selectRow", K);
				A.combo("hidePanel");
				var H = SArray.get(p)[K];
				for ( var G = 0; G < h.length; G++) {
					y.setValue(h[G], H.getValue(r[G]))
				}
			} else {
				var C = b.datagrid("options");
				C.singleSelect = false;
				var J = null;
				for ( var G = 0; G < s.length; G++) {
					if (s[G] == K) {
						J = K;
						s.splice(G, 1);
						break
					}
				}
				if (J || J == 0) {
					b.datagrid("unselectRow", J)
				} else {
					b.datagrid("selectRow", K);
					s.push(K)
				}
				var I = true;
				for ( var G = 0; G < j.length; G++) {
					if (j[G] == F) {
						j.splice(G, 1);
						d.splice(G, 1);
						I = false;
						break
					}
				}
				if (I) {
					j.push(F);
					d.push(D)
				}
				y.setValue(c, j.join(","));
				y.setValue(c + "Name", d.join(","))
			}
		}
	});
	$(document).bind("mousedown", function(i) {
		A.combo("hidePanel");
		f = 0
	});
	$("#dropdownClear").linkbutton();
	$("#dropdownClear").bind("click", function() {
		A.combo("clear");
		y.setValue(c, "")
	});
	dropDownInterface(A, z, B, k, p, e);
	t.bind("mousedown", function(i) {
		i.stopPropagation();
		window.event.cancelBubble = true
	});
	$("a[icon=pagination-first]", t).bind("click", function() {
		dropDownFirst(b, k, p, z, A, x, w, e)
	});
	$("a[icon=pagination-prev]", t).bind("click", function() {
		dropDownPrev(b, k, p, z, A, x, w, e)
	});
	$("a[icon=pagination-next]", t).bind("click", function() {
		dropDownNext(b, k, p, z, A, x, w, e)
	});
	$("a[icon=pagination-last]", t).bind("click", function() {
		dropDownLast(b, k, p, z, A, x, w, e)
	});
	t.find(".datagrid-body").eq(1).css("overflow-x", "hidden");
	$(".datagrid-header", t).css("display", "none");
	$(".datagrid-wrap", t).css("height", "200")
}
var SArray = new Map();
function dropDownFirst(b, i, c, e, d, g, j, f) {
	var h = $("#" + c + "_d");
	if (e.pageCount > 1) {
		if (j.cached == false) {
			e.flushData(1);
			$("#" + c + "_DDIndex").val(1);
			loadDataToGrid(d, i, e, c, "", "", f)
		} else {
			h.datagrid("loadData", g.a1[0]);
			$("#" + c + "_DDIndex").val(1)
		}
	} else {
		h.datagrid("loadData", g.a1[0]);
		$("#" + c + "_DDIndex").val(1)
	}
	SArray.put(c, f.a1);
	e.setParameter("cacheIndex", 0)
}
function dropDownPrev(grid, selectField, id, _dataset, combo, JsonObject,
		dropdown, recordObject) {
	if (_dataset.pageCount > 1) {
		if (dropdown.cached == true) {
			var cacheIndex = parseInt(_dataset.getParameter("cacheIndex"));
			if (cacheIndex == 0) {
				return
			} else {
				$("#" + id + "_DDIndex").val(cacheIndex);
				cacheIndex = cacheIndex - 1;
				var json = eval("JsonObject.a" + (cacheIndex + 1));
				if (json) {
					$("#" + id + "_d").datagrid("loadData", json[0]);
					_dataset.setParameter("cacheIndex", cacheIndex);
					SArray.put(id, eval("recordObject.a" + (cacheIndex + 1)))
				} else {
					_dataset.flushData(cacheIndex + 1);
					$("#" + id + "_DDIndex").val(cacheIndex + 1);
					eval("JsonObject.a"
							+ (cacheIndex + 1)
							+ '=loadDataToGrid(combo,selectField,_dataset,id,"","",recordObject)');
					_dataset.setParameter("cacheIndex", cacheIndex);
					SArray.put(id, eval("recordObject.a" + (cacheIndex + 1)))
				}
			}
		} else {
			if (_dataset.pageIndex == 1) {
				$(this).linkbutton({
					disabled : true
				});
				return
			}
			_dataset.flushData(_dataset.pageIndex - 1);
			$("#" + id + "_DDIndex").val(_dataset.pageIndex);
			var jarray = loadDataToGrid(combo, selectField, _dataset, id, "",
					"", recordObject);
			JsonArray.push(jarray[0]);
			var cacheIndex = parseInt(_dataset.getParameter("cacheIndex"));
			_dataset.setParameter("cacheIndex", cacheIndex - 1)
		}
	} else {
		var cacheIndex = parseInt(_dataset.getParameter("cacheIndex"));
		if (cacheIndex == 0) {
			return
		} else {
			$("#" + id + "_DDIndex").val(cacheIndex);
			cacheIndex = cacheIndex - 1;
			$("#" + id + "_d").datagrid("loadData", JsonObject.a1[cacheIndex]);
			_dataset.setParameter("cacheIndex", cacheIndex);
			SArray.put(id, eval("recordObject.a" + (cacheIndex + 1)))
		}
	}
}
function dropDownNext(grid, selectField, id, _dataset, combo, JsonObject,
		dropdown, recordObject) {
	var cacheIndex = parseInt(_dataset.getParameter("cacheIndex"));
	if (_dataset.pageCount > 1) {
		if (dropdown.cached == true) {
			if ((cacheIndex + 1) == _dataset.pageCount) {
				return
			}
			var json = eval("JsonObject.a" + (cacheIndex + 2));
			if (json) {
				var cacheIndex = parseInt(_dataset.getParameter("cacheIndex"));
				cacheIndex = cacheIndex + 1;
				$("#" + id + "_DDIndex").val(cacheIndex + 1);
				$("#" + id + "_d").datagrid("loadData", json[0]);
				_dataset.setParameter("cacheIndex", cacheIndex);
				SArray.put(id, eval("recordObject.a" + (cacheIndex + 1)))
			} else {
				_dataset.flushData(cacheIndex + 2);
				$("#" + id + "_DDIndex").val(_dataset.pageIndex);
				eval("JsonObject.a"
						+ _dataset.pageIndex
						+ '=loadDataToGrid(combo,selectField,_dataset,id,"","",recordObject)');
				_dataset.setParameter("cacheIndex", cacheIndex + 1);
				SArray.put(id, eval("recordObject.a" + _dataset.pageIndex))
			}
		} else {
			if (_dataset.pageIndex == _dataset.pageCount) {
				return
			}
			_dataset.flushData(_dataset.pageIndex + 1);
			$("#" + id + "_DDIndex").val(_dataset.pageIndex);
			loadDataToGrid(combo, selectField, _dataset, id, "", "",
					recordObject);
			_dataset.setParameter("cacheIndex", _dataset.pageIndex)
		}
	} else {
		var cacheIndex = parseInt(_dataset.getParameter("cacheIndex"));
		if (cacheIndex == JsonObject.a1.length - 1) {
			return
		} else {
			cacheIndex = cacheIndex + 2;
			$("#" + id + "_DDIndex").val(cacheIndex);
			$("#" + id + "_d").datagrid("loadData",
					JsonObject.a1[cacheIndex - 1]);
			_dataset.setParameter("cacheIndex", cacheIndex - 1);
			SArray.put(id, eval("recordObject.a" + cacheIndex))
		}
	}
}
function dropDownLast(grid, selectField, id, _dataset, combo, JsonObject,
		dropdown, recordObject) {
	if (_dataset.pageCount > 1) {
		if (dropdown.cached == false) {
			_dataset.flushData(_dataset.pageCount);
			$("#" + id + "_DDIndex").val(_dataset.pageCount);
			loadDataToGrid(combo, selectField, _dataset, id, "", "",
					recordObject)
		} else {
			var json = eval("JsonObject.a" + _dataset.pageCount);
			if (json) {
				$("#" + id + "_d").datagrid("loadData", json[0]);
				$("#" + id + "_DDIndex").val(_dataset.pageCount);
				SArray.put(id, eval("recordObject.a" + _dataset.pageCount))
			} else {
				_dataset.flushData(_dataset.pageCount);
				$("#" + id + "_DDIndex").val(_dataset.pageCount);
				eval("JsonObject.a"
						+ _dataset.pageCount
						+ '=loadDataToGrid(combo,selectField,_dataset,id,"","",recordObject)');
				SArray.put(id, eval("recordObject.a" + _dataset.pageCount))
			}
		}
		_dataset.setParameter("cacheIndex", _dataset.pageCount - 1)
	} else {
		$("#" + id + "_d").datagrid("loadData",
				JsonObject.a1[JsonObject.a1.length - 1]);
		$("#" + id + "_DDIndex").val(JsonObject.a1.length);
		_dataset.setParameter("cacheIndex", JsonObject.a1.length - 1);
		SArray.put(id, eval("recordObject.a" + (JsonObject.a1.length - 1)))
	}
}
function loadDataToGrid(combo, selectField, _dataset, id, datagrid, dropdown,
		recordObject) {
	var _record = _dataset.getFirstRecord();
	var grid;
	if (datagrid) {
		grid = datagrid
	} else {
		grid = $("#" + id + "_d")
	}
	var JsonArray = new Array();
	var index = 0;
	for ( var j = 0; j < _dataset.length / 10; j++) {
		var recordJson = {};
		recordJson.total = 10;
		recordJson.rows = [];
		var total = 0;
		var downRecordArray = new Array();
		while (_record) {
			downRecordArray.push(_record);
			total++;
			var row = {};
			for ( var i = 0; i < _dataset.fields.fieldCount; i++) {
				var _f = _dataset.getField(i);
				var fieldName = _f.fieldName;
				var field = _record.getValue(fieldName);
				row[fieldName] = field
			}
			if (total == 10) {
				if (_dataset.pageCount > 1) {
					eval("recordObject.a" + _dataset.pageIndex
							+ "=downRecordArray")
				} else {
					eval("recordObject.a" + (++index) + "=downRecordArray")
				}
				break
			}
			recordJson.rows.push(row);
			_record = _record.getNextRecord()
		}
		if (_dataset.length < 10) {
			if (_dataset.pageCount > 1) {
				eval("recordObject.a" + _dataset.pageIndex + "=downRecordArray")
			} else {
				eval("recordObject.a" + (++index) + "=downRecordArray")
			}
		}
		JsonArray.push(recordJson)
	}
	if (_dataset.length) {
		grid.datagrid("loadData", JsonArray[0]);
		var fname = combo.attr("dataField") + "_selectCQDropDown";
		eval(fname + "=downRecordArray;")
	} else {
		grid.datagrid("loadData", 0)
	}
	return JsonArray
}
var _dropdown_parentbox;
function _dropdown_onclick() {
	if (parent._dropdown_parentbox) {
		parent._dropdown_parentbox.combo("hidePanel")
	}
}
function _dropdown_resize() {
	if (_dropdown_parentbox) {
		var b = _dropdown_parentbox.combo("options").ifr.contentWindow
				.winsize();
		_dropdown_parentbox.combo("panel").panel("resize", b)
	}
}
function initSelectCustom(i) {
	var f = $(i);
	var e = f.attr("datasetName");
	var k = f.attr("componentDataset");
	var h = getDatasetByID(k);
	var c = getDatasetByID(e);
	var d = getDropDownByID(f.attr("dropDown"));
	var g = $('<iframe scrolling=no height=0 frameborder=0 marginheight=0 marginwidth=0 style="width:100%;height:100%" onload="(function(){})()"></iframe>');
	f.combo({
		panelHeight : 5,
		ifr : g[0],
		onHidePanel : function() {
			var l = g[0];
			if (l.contentWindow.dropDown_onGetRecord) {
				record = l.contentWindow.dropDown_onGetRecord()
			}
			var m = f.attr("dropDown") + "_onSelect";
			needAbort = (isUserEventDefined(m) && !fireUserEvent(m, [ d,
					record, this ]));
			if (needAbort) {
				return
			}
			setFieldMapValue(i, d.fieldMap, h, record)
		}
	});
	var b = f.combo("panel");
	b.panel({
		onBeforeOpen : function() {
			var m = f.attr("dropDown") + "_beforeOpen";
			if (isUserEventDefined(m)) {
				var l = fireUserEvent(m, [ d ]);
				if (l) {
					if (l != true) {
						errAlert(l);
						return false
					}
					return false
				}
			}
			_dropdown_parentbox = f;
			if (!g.attr("src")) {
				if (g[0].attachEvent) {
					g[0].attachEvent("onload", _dropdown_resize)
				} else {
					g[0].onload = _dropdown_resize
				}
				g.attr("src", j(d))
			}
		}
	});
	g.appendTo(b);
	if (c.init == "true") {
		g.attr("src", j(d))
	}
	function j(u) {
		var p = u.url;
		if (p.substring(0, 1) == "/") {
			p = _application_root + p
		}
		var s = u.fieldMap;
		var l = u.fields;
		var r = u.fieldId;
		if (p.lastIndexOf("?") != -1) {
			p += "&sessionkey=" + u.sessionKey + "&fieldMapStr=" + s
					+ "&viewField=" + l + "&fieldId=" + r
		} else {
			p += "?sessionkey=" + u.sessionKey + "&fieldMapStr=" + s
					+ "&viewField=" + l + "&fieldId=" + r
		}
		var m = u.targetDataset;
		if (typeof (m) == "string") {
			m = getDatasetByID(m)
		}
		if (m) {
			var t = converDateSet2Str(m);
			p += "&targetFieldStr=" + t
		}
		var o = u.dataset;
		if (typeof (o) == "string") {
			o = getDatasetByID(o)
		}
		if (o) {
			var q = converDateSetParameter2Str(o);
			p += "&paramStr=" + q
		}
		return p
	}
}
var _activeElement = null;
var _activeEditor = null;
var _activeTable = null;
var _dropdown_window = null;
var _isDropDownPage = false;
var _document_loading = false;
var _stored_element = null;
var _array_dataset = new Array();
var _tabset_list = new Array();
var _jtabset_list = new Array();
var _array_submitmanager = new Array();
var _user_events = {
	me : function() {
		var b = {};
		for ( var c in this) {
			b[c] = this[c]
		}
		return b
	}
};
var _oidmap = null;
var _skip_activeChanged = false;
function _finishInitializtion() {
	for ( var b = 0; b < _tabset_list.length; b++) {
		initElement(_tabset_list[b])
	}
}
function _topmask(b) {
	if (top.masktimer) {
		clearTimeout(top.masktimer);
		top.masktimer = null
	}
	if (b == 0) {
		top.masktimer = setTimeout(function() {
			if (top.maskwin) {
				top.maskwin = null;
				top.masktimer = null;
				top.$.messager.progress("close")
			}
		}, 500)
	} else {
		if (!top.maskwin) {
			top.maskwin = top.$.messager.progress({
				title : "&nbsp;",
				text : "",
				msg : $.fn.datagrid.defaults.loadMsg
			})
		}
	}
}
if (!window._SHOW_TAB_LOADING) {
	_topmask = function() {
	}
}
function initDocument() {
	fireUserEvent("document_onInit", []);
	with (document) {
		initElements(body);
		for ( var i = 0; i < _array_dataset.length; i++) {
			var dataset = _array_dataset[i];
			if (dataset.masterDataset) {
				dataset.setMasterDataset(dataset.masterDataset,
						dataset.references)
			}
			var event_name = getElementEventName(dataset, "onFilterRecord");
			dataset.filtered = isUserEventDefined(event_name);
			dataset.initDocumentFlag = true;
			dataset.pageElement = "document"
		}
		_finishInitializtion();
		language = "javascript"
	}
	$(window).unload(function() {
		if ($.browser.msie) {
			CollectGarbage()
		}
	});
	fireUserEvent("document_afterInit", [])
}
function initDocumentLet(element) {
	fireUserEvent("documentlet_onInit", []);
	with (document) {
		initElements(element);
		for ( var i = 0; i < _array_dataset.length; i++) {
			var dataset = _array_dataset[i];
			if (dataset.initDocumentFlag == false) {
				if (dataset.masterDataset) {
					dataset.setMasterDataset(dataset.masterDataset,
							dataset.references)
				}
				var event_name = getElementEventName(dataset, "onFilterRecord");
				dataset.filtered = isUserEventDefined(event_name);
				dataset.pageElement = element.id;
				dataset.initDocumentFlag = true
			}
		}
	}
	_topmask(0);
	fireUserEvent("documentlet_afterInit", [])
}
function fireUserEvent(d, e) {
	var b;
	if (d == "") {
		return
	}
	var c = _user_events[d];
	if (c == null) {
		if (!isUserEventDefined(d)) {
			return
		}
		c = _user_events[d]
	}
	if (c != null && c.defined) {
		b = c.handle(e[0], e[1], e[2], e[3])
	}
	return b
}
function initElements(c) {
	if (compareText(c.getAttribute("extra"), "tabset")) {
		_tabset_list[_tabset_list.length] = c
	} else {
		if (!initElement(c)) {
			return
		}
	}
	for ( var b = 0; b < c.children.length; b++) {
		initElements(c.children[b])
	}
}
function initElementDataset(b) {
	var c = b.getAttribute("componentDataset");
	if (c) {
		setElementDataset(b, c)
	}
}
function initElementDropdownDataset(b) {
	var c = b.getAttribute("datasetName");
	if (c) {
		setElementDataset(b, c)
	}
}
function initElement(element) {
	
	if(element.getAttribute && element.getAttribute("style")){
		var tmp_style = element.getAttribute("style");
		var index1 = tmp_style.indexOf("%px");
		if(index1 > -1){
			element.style = tmp_style.replace('%px', '%');
		}
	}
	
	
	var _extra = element.getAttribute("extra");
	var noExtra = isTrue(element.getAttribute("noExtra"));
	var initChildren = !noExtra;
	
	if (_extra && !noExtra) {
		element.window = window;
		switch (_extra) {
		case "fieldlabel":
			initElementDataset(element);
			initFieldlabel(element);
			break;
		case "datalabel":
			initElementDataset(element);
			element.setReadOnly = editor_setReadOnly;
			break;
		case "editor":
			initEditor(element);
			initElementDataset(element);
			break;
		case "dropDownSelect":
			initElementDataset(element);
			var _dropdown = getDropDownByID(element.getAttribute("dropDown"));
			switch (_dropdown.type) {
			case "img":
				initImgCQClick(element);
				break;
			case "cq":
				initSelectCQClick(element);
				break;
			case "dynamictree":
				initDropdownTreeClick(element);
				break;
			case "custom":
				initSelectCustomClick(element);
				break;
			case "dialog":
				initSelectDialogClick(element);
				break;
			default:
				initSelectAndDicClick(element)
			}
			break;
		case "datagrid":
			initElementDataset(element);
			initDataTable(element);
			break;
		case "rdatagrid":
			initElementDataset(element);
			initReadonlyDataTable(element);
			break;
		case "pagination":
			initElementDataset(element);
			break;
		case "button":
			initChildren = false;
			if (element.tagName == "A") {
				$(element).linkbutton()
			}
			break;
		case "tabset":
			initEasyTabSet(element);
			initChildren = false;
			break;
		case "menuitem":
			var menu = $(element);
			menu.bind("contextmenu", function() {
				return false
			});
			var id = menu.attr("id");
			menu.menu({
				onClick : function(item) {
					var opts = $.data(element, "menu").options;
					fireUserEvent(id + "_onClick", [ item, opts.data ])
				},
				onShow : function(item) {
					var opts = $.data(element, "menu").options;
					fireUserEvent(id + "_onShow", [ item, opts.data ])
				},
				onHide : function(item) {
					var opts = $.data(element, "menu").options;
					fireUserEvent(id + "_onHide", [ item, opts.data ])
				}
			});
			break;
		case "tree":
			var dtree = new DynamicTree(element);
			eval(element.getAttribute("id") + "=dtree;");
			break;
		case "tabs":
			var _tabs = $(element);
			var dtabs = new DynamicTabSet(element, {
				fit : _tabs.attr("fit") != "false"
			});
			var $P = window[_tabs.attr("id") + "_params"] || {};
			try {
				var url = window.location.href;
				url = url.replace("&amp;", "&");
				var i = url.indexOf("?");
				if (i > -1) {
					url = url.substring(i + 1);
					var p = url.split("&");
					for ( var j = 0; j < p.length; j++) {
						var kv = p[j].split("=");
						if (kv.length == 2) {
							$P[kv[0]] = kv[1]
						}
					}
				}
			} catch (e) {
				errAlert("dynamic tab url params parse error")
			}
			eval(_tabs.attr("id") + "=dtabs;dtabs.setParams($P);");
			break;
		case "floatwindow":
			var _win = $(element);
			setTimeout(function() {
				_win.hide()
			}, 0);
			var fwin = new FloatWindow(_win.attr("id"), element);
			eval("subwindow_" + _win.attr("id") + "=fwin;");
			break;
		case "accordionMenu":
			var _accmenu = $(element);
			var _accordion = new AccordionMenu(element);
			eval(_accmenu.attr("id") + "=_accordion;");
			break;
		case "groupbox":
			var groupbox = $(element);
			var expand = groupbox.attr("expand");
			var outerContainer = groupbox.find("div:first");
			outerContainer.css("height", "100%");
			var innerContainer = outerContainer.find("div:first");
			var imgUrl;
			var alt;
			if (expand == "true") {
				alt = constGroupBoxExpandAlt;
				innerContainer.show();
				imgUrl = _theme_root + "/group_expand.gif"
			} else {
				imgUrl = _theme_root + "/group_collapse.gif";
				alt = constGroupBoxCollapseAlt;
				innerContainer.hide()
			}
			$("<img/>").css("cursor", "hand").attr("expand", expand).attr(
					"alt", alt).attr("src", imgUrl).click(
					function() {
						var img = $(this);
						if (img.attr("expand") == "true") {
							innerContainer.hide();
							img.attr("expand", "false").attr("alt",
									constGroupBoxExpandAlt).attr("src",
									_theme_root + "/group_collapse.gif")
						} else {
							innerContainer.show();
							img.attr("expand", "true").attr("alt",
									constGroupBoxCollapseAlt).attr("src",
									_theme_root + "/group_expand.gif")
						}
					}).appendTo(groupbox.find("legend"));
			break;
		case "requiredlabel":
			initElementDataset(element);
			var $e = $(element);
			if ($e.hasClass("required")) {
				$e.text("*")
			}
			break;
		default:
			if (!element.className && _extra) {
				element.className = _extra
			}
			break
		}
	}
	$(element).attr("noExtra", "true");
	return initChildren
}
function _createParameters() {
	var b = new Array();
	b.setParameter = parameters_setParameter;
	b.getParameter = parameters_getParameter;
	return b
}
function _createPageState() {
	this.version = "0";
	this.REQUEST_PARAM_NAME = "SubmitManager.PageState";
	this.parameter = _createParameters();
	this.getString = _PageState_getString;
	this.setString = _PageState_setString;
	this.getCount = _PageState_getCount;
	this.getStringCode = _PageState_toString;
	this.getRequestText = _PageState_getRequestText;
	return this
}
function parameters_setParameter(c, f, b) {
	var h;
	if (typeof (c) == "number") {
		var d = c;
		this[d].name = c;
		this[d].value = f;
		if (b) {
			this[d].dataType = b
		}
	} else {
		var e = this.length;
		var g = false;
		for ( var d = 0; d < e; d++) {
			if (this[d].name == c) {
				g = true;
				break
			}
		}
		if (!g) {
			d = e;
			this[d] = new Object()
		}
		this[d].name = c;
		this[d].value = f;
		if (b) {
			this[d].dataType = b
		}
	}
}
function parameters_getParameter(b) {
	if (typeof (b) == "number") {
		return this[b].value
	} else {
		var d = this.length;
		for ( var c = 0; c < d; c++) {
			if (this[c].name == b) {
				return this[c].value;
				break
			}
		}
		return ""
	}
}
function _PageState_getString(b) {
	return this.parameter.getParameter(b)
}
function _PageState_setString(b, c) {
	this.parameter.setParameter(b, c)
}
function _PageState_getCount() {
	return this.parameter.length
}
function _PageState_toString() {
	var b = "";
	var d = this.parameter;
	for ( var c = 0; c < d.length; c++) {
		b += (c == 0) ? "" : ";";
		b += getEncodeStr(d[c].name) + "=" + getEncodeStr(d[c].value)
	}
	return getEncodeStr(b)
}
function _PageState_getRequestText() {
	return this.REQUEST_PARAM_NAME + "=" + this.getStringCode()
}
function getElementEventName(e, c) {
	var b = "";
	if (e.extra != "dockeditor") {
		b = e.id + "_" + c
	} else {
		var d = e.editorHolder;
		if (d) {
			b = d.id + "_" + c
		}
	}
	return b
}
function isUserEventDefined(function_name) {
	if (function_name == "") {
		return false
	}
	var eventInfo = _user_events[function_name];
	if (eventInfo == null) {
		eventInfo = new Object();
		_user_events[function_name] = eventInfo;
		var script = "eventInfo.defined=(typeof(" + function_name
				+ ')!="undefined");if (eventInfo.defined) eventInfo.handle='
				+ function_name + ";";
		eval(script)
	}
	return eventInfo.defined
}
function unfireUserEvent(c) {
	var b = _user_events[c];
	if (b == null) {
	} else {
		_user_events[c] = null
	}
}
function isFileIncluded(fileId) {
	var included = false;
	eval("included=(typeof(_fileIncluded_" + fileId + ')!="undefined")');
	return included
}
function getElementDataset(b) {
	var c = b.getAttribute("componentDataset");
	if (typeof (c) == "string") {
		c = getDatasetByID(c)
	}
	return c
}
function _image_onClick() {
	var e = event.srcElement;
	var d = e.parentElement;
	var g = getElementField(d);
	var f = g.dataset;
	var b = g.name;
	var h = new Object();
	h.dataset = f;
	h.field = g.fieldName;
	h.image = e.src;
	var c = g.lobPopupURL;
	if (c.indexOf("?") < 0) {
		c += "?"
	}
	c += "&lob_sessionkey=" + f.getValue(b);
	c += "&dataset_sessionKey=" + f.sessionKey;
	c += "&lobfield=" + g.fieldName;
	c += "&oid=" + f.getValue("oid");
	showModalDialog(
			_application_root + c,
			h,
			"dialogHeight: 400px; dialogWidth: 400px; center: Yes; help: No; resizable: yes; status: No");
	f.setValue(b, f.getValue(b))
}
function addParams2TabsUrl(g, h, f) {
	var e = h.split(",");
	var d = f.split(",");
	for ( var c = 0; c < g.cells.length; c++) {
		if (typeof (g.cells[c].targetUrl) != "undefined"
				&& g.cells[c].targetUrl != "") {
			for ( var b = 0; b < e.length; b++) {
				if (b == 0) {
					g.cells[c].targetUrl = g.cells[c].targetUrl + "?" + e[b]
							+ "=" + d[b]
				} else {
					g.cells[c].targetUrl = g.cells[c].targetUrl + "&" + e[b]
							+ "=" + d[b]
				}
			}
		}
	}
}
function addParams2TabsUrl(c, d, b) {
	c.addParams(d, b)
}
function megerURL(d, b) {
	var e = b;
	if (e && e.length > 0) {
		var c = e.substring(0, 1);
		if (c == "/") {
			return d + e
		} else {
			return d + "/" + e
		}
	} else {
		return d + "/"
	}
}
function compareDate(e, c, d) {
	var b = e.getFullYear();
	var g = e.getMonth();
	var f = e.getDate();
	if (new Date(b, g + d, f) < c) {
		return false
	} else {
		return true
	}
}
function compareDateFunction(d, c) {
	var b;
	var e;
	if (typeof (d) == "object") {
		b = d
	} else {
		b = convertStr2Date(d)
	}
	if (typeof (c) == "object") {
		e = c
	} else {
		e = convertStr2Date(c)
	}
	return compareDate(b, e, 0)
}
function convertStr2Date(d) {
	var e = parseInt(d.substring(0, 4));
	var b = d.substring(4, 6);
	if ("0" == b.charAt(0)) {
		b = b.substring(1, 2)
	}
	var f = parseInt(b);
	if (d.substring(6, 7) == "0") {
		var c = parseInt(d.substring(7, 8))
	} else {
		var c = parseInt(d.substring(6, 8))
	}
	return new Date(e + "/" + f + "/" + c)
}
function convertStr2Date_new(d) {
	var c;
	c = new Date(d);
	if (!isNaN(c)) {
		return c
	}
	var e = /^(\d{4})(\-)(\d{1,2})\-(\d{1,2})$/;
	var b = e.exec(d);
	if (b != null) {
		c = new Date(b[1], b[3] - 1, b[4]);
		return c
	}
	return convertStr2Date(d)
}
function traversalRecords(c, e, b) {
	var d = 0;
	var f = e.length;
	for (; !e.eof; e.moveNext(), f--) {
		if (e.getString("select") == "true") {
			d++;
			if (!c(e.getString(b))) {
				return false
			}
		}
	}
	var g = 0;
	for (e.moveFirst(); g < f; e.moveNext(), g++) {
		if (e.getString("select") == "true") {
			d++;
			if (!checkCancelStatus(e.getString(b))) {
				return false
			}
		}
	}
	e.moveFirst();
	e.move(f);
	if (d == 0) {
		alert(constTraversalRecords);
		return false
	}
	return true
}
Request = {
	QueryString : function(c) {
		var b = location.search.match(new RegExp("[?&]" + c + "=([^&]*)(&?)",
				"i"));
		return b ? b[1] : b
	}
};
function getRecordStateNum(f, j) {
	var d = f.firstUnit;
	var i = 0;
	var c = 0;
	var b = 0;
	var e = 0;
	var g = 0;
	var h = 0;
	while (d) {
		if (d.recordState == "none") {
			i = i + 1
		}
		if (d.recordState == "insert") {
			c = v_inert + 1
		}
		if (d.recordState == "modify") {
			b = b + 1
		}
		if (d.recordState == "delete") {
			e = e + 1
		}
		if (d.recordState == "new") {
			g = g + 1
		}
		if (d.recordState == "discard") {
			h = h + 1
		}
		d = d.nextUnit
	}
	if (j == "none") {
		return i
	}
	if (j == "insert") {
		return c
	}
	if (j == "modify") {
		return b
	}
	if (j == "delete") {
		return e
	}
	if (j == "new") {
		return g
	}
	if (j == "discard") {
		return h
	}
}
function getElementField(b) {
	var c = getElementDataset(b);
	if (!c) {
		return
	}
	return c.getField(b.getAttribute("dataField"))
}
function uninitLet(element) {
	var elementId;
	uninitElements(element);
	if (!element) {
		elementId = "document"
	} else {
		elementId = element.id
	}
	var _new_array_dataset = new Array();
	for ( var i = 0; i < _array_dataset.length; i++) {
		var dataset = _array_dataset[i];
		if (dataset.pageElement == elementId && dataset.type != "dropdown") {
			dataset.disableControls();
			dataset.disableEvents();
			freeDataset(dataset);
			eval(dataset.id + "=undefined;")
		} else {
			_new_array_dataset[_new_array_dataset.length] = dataset
		}
	}
	_array_dataset = _new_array_dataset
}
function uninitElements(c) {
	if (!c) {
		for ( var b = 0; b < _array_dataset.length; b++) {
			var d = _array_dataset[b];
			if (d.window == window) {
				d.setMasterDataset(null)
			}
		}
		c = document.body
	}
	var e = isTrue(c.getAttribute("noExtra"));
	$(c).removeAttr("noextra");
	if (c && !e) {
		for ( var b = 0; b < c.children.length; b++) {
			uninitElements(c.children[b])
		}
		uninitElement(c)
	}
}
function uninitElement(b) {
	var c = b.getAttribute("extra");
	switch (c) {
	case "datalabel":
	case "editor":
	case "dockeditor":
	case "datatable":
	case "tablecell":
	case "pagepilot":
	case "datagrid":
	case "datagridgroup":
	case "datapilot":
		if (typeof (setElementDataset) != "undefined") {
			setElementDataset(b, null)
		}
		break
	}
}
function showMoreQueryCondition(c, j) {
	var b = $("#" + c);
	if (b[0]) {
		if (!b.data("rendered")) {
			b.removeAttr("noextra");
			initElements(b[0]);
			b.data("rendered", true)
		}
		if (!b.data("isShow")) {
			if (j) {
				j(b, "show")
			} else {
				if (b.data("moretrs")) {
					if (b.data("queryBtn")) {
						b.data("queryBtn").appendTo(
								b.data("queryBtnPositionNew"))
					}
					b.data("moretrs").show()
				} else {
					var f = b.find("table");
					var h = f.find("tr");
					var i = f.attr("dataset");
					var d = b.next();
					var k = $("#" + i + "_btnSubmit", d);
					if (k[0]) {
						b.data("queryBtn", k);
						b.data("queryBtnPositionOld", k.parent());
						var g = $('<table width="100%"></table>');
						var e = $(
								'<td class="button-qry-td" align="center"></td>')
								.append(k);
						b.data("queryBtnPositionNew", e);
						e.wrap("<tr></tr>").appendTo(g);
						d.after(g)
					}
					b.data("moretrs", h);
					d.append(h)
				}
			}
			b.data("isShow", true)
		} else {
			if (j) {
				j(b, "hide")
			} else {
				if (b.data("moretrs")) {
					if (b.data("queryBtn")) {
						b.data("queryBtn").appendTo(
								b.data("queryBtnPositionOld"))
					}
					b.data("moretrs").hide()
				}
			}
			b.data("isShow", false)
		}
	}
};