var _fileIncluded_dataset = true;
var _maxAutoGenID = 0;
function _getAutoGenID() {
	_maxAutoGenID++;
	return "__" + _maxAutoGenID
}
function _downloadData(f, c, b) {
	try {
		if (f.sessionKey) {
			var a = new Object();
			return a
		}
	} catch (d) {
		processException(d)
	}
}
function getDatasetByID(a) {
	for (var b = 0; b < _array_dataset.length; b++) {
		if (_array_dataset[b].id == a) {
			return _array_dataset[b]
		}
	}
}
function getDatasets() {
	return _array_dataset
}
function setElementDataset(a, c) {
	var b = getDatasetByID(c);
	a.dataset = b;
	if (b) {
		var d = b.editors;
		if (!d) {
			d = new pArray();
			b.editors = d
		}
		pArray_ex_insert(d, a)
	}
}
function _dataset_getField(a, d) {
	var c = null;
	if (typeof (d) == "number") {
		c = a[d]
	} else {
		if (typeof (d) == "string") {
			var b = a["_index_" + d.toLowerCase()];
			if (!isNaN(b)) {
				c = a[b]
			}
		}
	}
	return c
}
function dataset_getField(b) {
	var a = this;
	return _dataset_getField(a.fields, b)
}
function appendFromDataString(c, m, h, n) {
	if (!h) {
		return
	}
	var f = null;
	if (m) {
		f = m.split(",")
	}
	var a = h.split(";");
	for (var d = 0; d < a.length; d++) {
		var e = a[d].split(",");
		for (var b = 0; b < e.length; b++) {
			e[b] = getDecodeStr(e[b])
		}
		var k = new Array();
		if (f != null) {
			for (var b = 0; b < f.length; b++) {
				var g;
				var l = _dataset_getField(c.fields, f[b].toLowerCase());
				g = c.fields["_index_" + f[b].toLowerCase()];
				k[g] = e[b]
			}
			e = k
		}
		pArray_insert(c, "end", null, e);
		if (n) {
			initRecord(e, c)
		}
	}
}
function transferToDataString(e) {
	var a = "";
	var d = 0;
	var b = e.getFirstRecord();
	while (b) {
		if (d != 0) {
			a += ";"
		}
		for (var c = 0; c < e.fields.fieldCount; c++) {
			if (c != 0) {
				a += ","
			}
			a += getEncodeStr(b.getString(c))
		}
		b = b.getNextRecord();
		d++
	}
	return a
}
function createDataset(b, e, d) {
	var f = new pArray();
	f.fields = new Array();
	f.parameters = _createParameters();
	f.updateItems = new Array();
	f.fields.fieldCount = 0;
	f.addField = dataset_addField;
	f.pageSize = 9999;
	f.pageCount = 1;
	f.pageIndex = 1;
	f.autoLoadPage = true;
	f.loadCompleted = false;
	f._saveOldValue = record_saveOldValue;
	f._getValue = record_getValue;
	f._getString = record_getString;
	f._getViewString = record_getViewString;
	f._setValue = record_setValue;
	f._getCurValue = record_getCurValue;
	f._setCurValue = record_setCurValue;
	f._getOldValue = record_getOldValue;
	f._setOldValue = record_setOldValue;
	f._getPrevRecord = record_getPrevRecord;
	f._getNextRecord = record_getNextRecord;
	f.validate = dataset_validate;
	f.getField = dataset_getField;
	f.getValue = dataset_getValue;
	f.getString = dataset_getString;
	f.getViewString = dataset_getViewString;
	f.setValue = dataset_setValue;
	f.setValue2 = dataset_setValue_2;
	f.getCurValue = dataset_getCurValue;
	f.setCurValue = dataset_setCurValue;
	f.getOldValue = dataset_getOldValue;
	f.setOldValue = dataset_setOldValue;
	f.disableControls = dataset_disableControls;
	f.enableControls = dataset_enableControls;
	f.disableEvents = dataset_disableEvents;
	f.enableEvents = dataset_enableEvents;
	f.refreshControls = dataset_refreshControls;
	f.setRecord = dataset_setRecord;
	f.setReadOnly = dataset_setReadOnly;
	f.setAllFieldsReadOnly = dataset_setAllFieldsReadOnly;
	f.setFieldReadOnly = dataset_setFieldReadOnly;
	f.setFieldRequired = dataset_setFieldRequired;
	f.setFieldHidden = dataset_setFieldHidden;
	f.getFirstRecord = dataset_getFirstRecord;
	f.getLastRecord = dataset_getLastRecord;
	f.move = dataset_move;
	f.movePrev = dataset_movePrev;
	f.moveNext = dataset_moveNext;
	f.moveFirst = dataset_moveFirst;
	f.moveLast = dataset_moveLast;
	f.find = dataset_find;
	f.findRecordByUUID = dataset_findRecordByUUID;
	f.locate = dataset_locate;
	f.updateRecord = dataset_updateRecord;
	f.cancelRecord = dataset_cancelRecord;
	f.insertRecord = dataset_insertRecord;
	f.deleteRecord = dataset_deleteRecord;
	f.copyRecord = dataset_copyRecord;
	f.loadPage = dataset_loadPage;
	f.loadDetail = dataset_loadDetail;
	f.isPageLoaded = dataset_isPageLoaded;
	f.moveToPage = dataset_moveToPage;
	f.setMasterDataset = dataset_setMasterDataset;
	f.flushData = dataset_flushData;
	f.clearData = dataset_clearData;
	f.sort = dataset_sort;
	f.setParameter = dataset_setParameter;
	f.getParameter = dataset_getParameter;
	f.getParameterName = dataset_getParameterName;
	f.getParameterCount = dataset_getParameterCount;
	f.getRealRecordCounts = dataset_getRealRecordCounts;
	f.toJson = dataset_toJson;
	if (b) {
		f.id = b;
		_array_dataset[_array_dataset.length] = f
	}
	if (e) {
		var a = e.split(",");
		for (var c = 0; c < a.length; c++) {
			f.addField(a[c])
		}
	}
	appendFromDataString(f, null, d);
	return f
}
function dataset_validate() {
	var b = this;
	var a = _FieldValid(b);
	if (typeof (a) == "string") {
		return a
	}
	return !a.isValid
}
function dataset_setParameter(b, c, a) {
	this.parameters.setParameter(b, c, a)
}
function dataset_getParameter(a) {
	return this.parameters.getParameter(a)
}
function dataset_getParameterName(a) {
	return this.parameters.getParameter(a)
}
function dataset_getParameterCount() {
	var a = this;
	return a.parameters.length
}
function dataset_addField(c, b) {
	var h = this;
	try {
		if (getValidStr(c) == "") {
			throw constErrEmptyFieldName
		}
		if (h.prepared) {
			throw constErrAddDataField
		}
		var a = c.toLowerCase();
		var g = new Object;
		var d = h.fields.length;
		h.fields["_index_" + a] = d;
		h.fields[d] = g;
		h.fields.fieldCount++;
		g.index = d;
		g.dataset = h;
		g.fields = h.fields;
		g.name = a;
		g.label = c;
		g.fieldName = c;
		g.dataType = b;
		switch (b) {
		case "string":
			g.editorType = "text";
			g.align = "left";
			g.vAlign = "top";
			break;
		case "byte":
		case "short":
		case "int":
		case "long":
		case "float":
		case "double":
		case "currency":
		case "bigdecimal":
			g.editorType = "text";
			g.align = "right";
			g.vAlign = "top";
			break;
		case "boolean":
			g.editorType = "checkbox";
			g.align = "center";
			g.vAlign = "middle";
			break;
		case "predate":
		case "postdate":
		case "date":
			g.editorType = "text";
			g.align = "left";
			g.vAlign = "top";
			g.size = 10;
			break;
		case "time":
			g.editorType = "text";
			g.align = "left";
			g.vAlign = "top";
			g.size = 8;
			break;
		case "timestamp":
			g.editorType = "text";
			g.align = "left";
			g.vAlign = "top";
			g.size = 19;
			break;
		default:
			g.editorType = "text";
			g.align = "left";
			g.vAlign = "top";
			break
		}
		return g
	} catch (f) {
		processException(f)
	}
}
function _addUpdateItem(b) {
	var a = new Object();
	b.updateItems[b.updateItems.length] = a;
	return a
}
function initFieldArray(dataset, fields) {
	var fieldCount = fields.fieldCount;
	fields.dataset = dataset;
	for (var i = 0; i < fieldCount; i++) {
		if (dataset.id) {
			if (fields[i].id && typeof (_element_property) != "undefined") {
				var root = _element_property[fields[i].id];
				if (root) {
					var property_count = root.length;
					for (var j = 0; j < property_count; j++) {
						eval("fields[i]." + root[j].property
								+ "=getDecodeStr(root[j].value)")
					}
				}
			}
		}
		fields[fieldCount + i] = new Object;
		fields[fieldCount + i].name = "_cur_" + fields[i].name;
		fields[fieldCount + i].dataType = fields[i].dataType;
		fields["_index__cur_" + fields[i].name] = fieldCount + i;
		fields[fieldCount * 2 + i] = new Object;
		fields[fieldCount * 2 + i].name = "_old_" + fields[i].name;
		fields[fieldCount * 2 + i].dataType = fields[i].dataType;
		fields["_index__old_" + fields[i].name] = fieldCount * 2 + i;
		fields[i].readOnly = isTrue(fields[i].readOnly);
		fireUserEvent(getElementEventName(dataset, "onInitField"), [ dataset,
				fields[i] ])
	}
}
function initRecord(a, c, b) {
	a.dataset = c;
	a.fields = c.fields;
	a.recordState = "none";
	a.pageIndex = c.pageIndex;
	a.visible = true;
	a.saveOldValue = c._saveOldValue;
	a.getValue = c._getValue;
	a.getString = c._getString;
	a.getViewString = c._getViewString;
	a.setValue = c._setValue;
	a.getCurValue = c._getCurValue;
	a.setCurValue = c._setCurValue;
	a.getOldValue = c._getOldValue;
	a.setOldValue = c._setOldValue;
	a.getPrevRecord = c._getPrevRecord;
	a.getNextRecord = c._getNextRecord;
	a.getJsonValue = _record_getJsonValue;
	if (!b) {
		a.saveOldValue()
	}
}
function initDataset(dataset) {
	if (dataset.prepared) {
		return
	}
	dataset.disableControlCount = 1;
	dataset.disableEventCount = 1;
	try {
		if (dataset.id && typeof (_element_property) != "undefined") {
			var root = _element_property[dataset.id];
			if (root) {
				var property_count = root.length;
				for (var i = 0; i < property_count; i++) {
					eval("dataset." + root[i].property
							+ "=getDecodeStr(root[i].value)")
				}
			}
		}
		dataset.window = window;
		dataset.bof = true;
		dataset.eof = true;
		dataset.state = "none";
		dataset.readOnly = isTrue(dataset.readOnly);
		dataset.sortFields = "";
		dataset.loadedPage = new Array();
		if (dataset.pageIndex > 0) {
			dataset.loadedPage[dataset.pageIndex - 1] = true
		}
		fireUserEvent(getElementEventName(dataset, "onInitDataset"),
				[ dataset ]);
		dataset.setReadOnly(isTrue(dataset.readOnly));
		initFieldArray(dataset, dataset.fields);
		var record = dataset.firstUnit;
		while (record) {
			initRecord(record, dataset);
			record = record.nextUnit
		}
		dataset.prepared = true
	} finally {
		dataset.disableControlCount = 0;
		dataset.disableEventCount = 0
	}
	if (dataset.pageIndex == 1 || !dataset.autoLoadPage) {
		dataset.moveFirst()
	} else {
		dataset.setRecord(dataset.getFirstRecord())
	}
	if (!dataset.record) {
		if (dataset.insertOnEmpty && !dataset.readOnly) {
			dataset.insertRecord()
		}
	}
	fireUserEvent(getElementEventName(dataset, "afterInitDataset"), [ dataset ])
}
function isFieldEditable(d, c) {
	if (c) {
		var a = !(d.readOnly || c.readOnly);
		if (d.record) {
			var b = d.record.recordState;
			a = (a && !((b == "none" || b == "modify") && c.valueProtected))
		}
	} else {
		var a = true
	}
	return a
}
function _dataset_setMasterDataset(b, a, e) {
	if (b.masterDataset) {
		var f = b.masterDataset.detailDatasets;
		if (f) {
			pArray_ex_delete(f, b)
		}
	}
	if (typeof (a) == "string") {
		a = getDatasetByID(a)
	}
	b.masterDataset = a;
	if (a) {
		var f = a.detailDatasets;
		if (!f) {
			f = new pArray();
			a.detailDatasets = f
		}
		pArray_ex_insert(f, b);
		var g = e.split(";");
		var h, j;
		b.referencesString = e;
		b.references = new Array();
		for (var c = 0; c < g.length; c++) {
			var d = g[c].indexOf("=");
			b.references[c] = new Object();
			if (d >= 0) {
				j = g[c].substr(0, d)
			} else {
				j = g[c]
			}
			h = a.getField(j);
			if (h) {
				b.references[c].masterField = h.name;
				b.references[c].masterIndex = h.index
			} else {
				throw constErrCantFindMasterField.replace("%s", j)
			}
			if (d >= 0) {
				j = g[c].substr(d + 1)
			} else {
				j = g[c]
			}
			h = b.getField(j);
			if (h) {
				b.references[c].detailField = h.name;
				b.references[c].detailIndex = h.index
			} else {
				throw constErrCantFindDetailField.replace("%s", j)
			}
		}
		delete g;
		delete b.loaded_detail;
		b.loaded_detail = new Array;
		a.loadDetail()
	}
}
function dataset_setMasterDataset(d, a) {
	var c = this;
	try {
		_dataset_setMasterDataset(c, d, a)
	} catch (b) {
		processException(b)
	}
}
function _dataset_loadDetail(c) {
	if (c.detailDatasets) {
		var m = c.detailDatasets.firstUnit;
		while (m && m.data) {
			var a = m.data;
			if (c.record && c.record.recordState != "insert"
					&& c.record.recordState != "new") {
				try {
					validateDatasetCursor(a);
					if (a.bof && a.eof) {
						var k = false;
						if (c.record) {
							var j = "";
							for (var f = 0; f < a.references.length; f++) {
								j += c.record[a.references[f].masterIndex]
							}
							for (var f = 0; f < a.loaded_detail.length; f++) {
								if (a.loaded_detail[f] == j) {
									k = true;
									break
								}
							}
						}
						if (!k) {
							var d = false;
							var b = fireDatasetEvent(a, "beforeLoadDetail", [
									a, c ]);
							if (b) {
								throw b
							}
							if (a.references.length > 0) {
								for (var f = 0; f < a.references.length; f++) {
									a
											.setParameter(
													a.references[f].detailField,
													c
															.getValue(a.references[f].masterIndex));
									var h = c
											.getValue(a.references[f].masterIndex);
									var l = c
											.getField(a.references[f].masterIndex).dataType;
									if (l == "timestamp" || l == "date"
											|| l == "time" || l == "predate"
											|| l == "postdate") {
										a.setParameter(
												a.references[f].detailField,
												formatDateTime(h, l))
									}
								}
								var n = _downloadData_new(a);
								if (n && n.recordStr) {
									appendFromDataString(a, n.fieldStr,
											n.recordStr, true)
								}
								delete n
							}
							a.loaded_detail[a.loaded_detail.length] = j
						}
					}
				} catch (g) {
					processException(g)
				}
			}
			a.refreshControls();
			a.moveFirst();
			m = m.nextUnit
		}
	}
}
function dataset_loadDetail() {
	var b = this;
	try {
		_dataset_loadDetail(b)
	} catch (a) {
		processException(a)
	}
}
function dataset_isPageLoaded(a) {
	var b = this;
	return b.loadedPage[a - 1]
}
function _dataset_loadPage(f, b) {
	if (!f.autoLoadPage || b < 1 || b > f.pageCount || f.isPageLoaded(b)) {
		return
	}
	if (f.masterDataset) {
		throw constErrLoadPageOnDetailDataset
	}
	if (f.sortFields) {
		throw constErrLoadPageAfterSort
	}
	var a = _downloadData_new(f, f.pageSize, b);
	if (a && a.recordStr) {
		var e = new pArray();
		e.fields = f.fields;
		appendFromDataString(e, a.fieldStr, a.recordStr);
		var c = e.lastUnit;
		while (c) {
			initRecord(c, f);
			c.pageIndex = b;
			c = c.prevUnit
		}
		var d = false;
		var c = f.lastUnit;
		while (c) {
			if (c.pageIndex < b) {
				pArray_insertArray(f, "after", c, e);
				d = true;
				break
			}
			c = c.prevUnit
		}
		if (!d) {
			pArray_insertArray(f, "begin", null, e)
		}
		delete e;
		f.loadedPage[b - 1] = true;
		f.refreshControls()
	}
	delete a
}
function dataset_loadPage(a) {
	try {
		var c = this;
		_dataset_loadPage(c, a)
	} catch (b) {
		processException(b)
	}
}
function _dataset_clearData(b) {
	b.disableControls();
	var a = b.autoLoadPage;
	b.autoLoadPage = false;
	try {
		b.modified = false;
		if (b.loaded_detail) {
			delete b.loaded_detail
		}
		if (b.loadedPage) {
			delete b.loadedPage
		}
		b.loaded_detail = new Array();
		b.loadedPage = new Array();
		if (b.pageIndex > 0) {
			b.loadedPage[b.pageIndex - 1] = true
		}
		pArray_clear(b);
		b.moveFirst()
	} finally {
		b.modified = true;
		b.enableControls();
		b.autoLoadPage = a
	}
}
function dataset_clearData() {
	try {
		var b = this;
		_dataset_clearData(b)
	} catch (a) {
		processException(a)
	}
}
function freeDataset(a) {
	if (a.detailDatasets) {
		pArray_clear(a.detailDatasets)
	}
	if (a.editors) {
		pArray_clear(a.editors)
	}
	delete a.references;
	pArray_clear(a.fields);
	a.clearData();
	delete a
}
function _dataset_flushData(c, b) {
	c.disableControls();
	try {
		c.clearData();
		var a = _downloadData(c, c.pageSize, b);
		if (a) {
			if (a.recordStr) {
				appendFromDataString(c, a.fieldStr, a.recordStr, true)
			}
			c.pageIndex = a.pageIndex;
			c.pageCount = a.pageCount
		}
		delete a
	} finally {
		c.enableControls();
		c.loadDetail()
	}
}
function dataset_flushData(a) {
	try {
		var c = this;
		_dataset_flushData(c, a)
	} catch (b) {
		processException(b)
	}
}
function dataset_moveToPage(a) {
	try {
		var d = this;
		if (!d.isPageLoaded(a)) {
			_dataset_loadPage(d, a)
		}
		var b = d.getFirstRecord();
		while (b) {
			if (b.pageIndex >= a) {
				_dataset_setRecord(d, b);
				break
			}
			b = b.getNextRecord()
		}
	} catch (c) {
		processException(c)
	}
}
function record_saveOldValue() {
	var a = this;
	var c = a.fields.fieldCount;
	for (var b = 0; b < c; b++) {
		a[c + b] = a[b];
		a[c * 2 + b] = a[b]
	}
}
function _dataset_sort(d, h) {
	function k(u, x, w, j) {
		function s(z, C) {
			if (x.length > 0) {
				var A, y;
				for (var B = 0; B < x.length; B++) {
					if (m[B].ascend) {
						A = 1;
						y = -1
					} else {
						A = -1;
						y = 1
					}
					if (z.getValue(x[B].index) > C[B]) {
						return A
					} else {
						if (z.getValue(x[B].index) < C[B]) {
							return y
						}
					}
				}
			} else {
				if (z.recordno > C[0]) {
					return 1
				} else {
					if (z.recordno < C[0]) {
						return -1
					}
				}
			}
			return 0
		}
		var t = w;
		var p = j;
		var v = getInt((t + p) / 2);
		var o = new Array();
		if (x.length > 0) {
			for (var r = 0; r < x.length; r++) {
				o[r] = u[v].getValue(x[r].index)
			}
		} else {
			o[0] = u[v].recordno
		}
		do {
			while (s(u[t], o) < 0) {
				t++
			}
			while (s(u[p], o) > 0) {
				p--
			}
			if (t <= p) {
				var q = u[t];
				u[t] = u[p];
				u[p] = q;
				t++;
				p--
			}
		} while (t <= p);
		if (p > w) {
			k(u, x, w, p)
		}
		if (j > t) {
			k(u, x, t, j)
		}
	}
	var m = new Array();
	if (h) {
		var b = h.split(",");
		for (var e = 0; e < b.length; e++) {
			m[e] = new Object();
			m[e].ascend = true;
			var g = b[e].substring(0, 1);
			var l;
			if (g == "+" || g == "-") {
				if (g == "-") {
					m[e].ascend = false
				}
				l = b[e].substring(1, b[e].length)
			} else {
				l = b[e]
			}
			for (var c = 0; c < d.fields.fieldCount; c++) {
				if (compareText(l, d.fields[c].name)) {
					m[e].index = c;
					break
				}
			}
		}
	}
	function n(r, j, q) {
		function p(v, u) {
			var w = getElementEventName(d, "onCompareRecord");
			if (isUserEventDefined(w)) {
				return fireUserEvent(w, [ v.dataset, v, u ])
			}
		}
		var i = j;
		var t = q;
		var s = r[getInt((i + t) / 2)];
		do {
			while (p(r[i], s) < 0) {
				i++
			}
			while (p(r[t], s) > 0) {
				t--
			}
			if (i <= t) {
				var o = r[i];
				r[i] = r[t];
				r[t] = o;
				i++;
				t--
			}
		} while (i <= t);
		if (t > j) {
			n(r, j, t)
		}
		if (q > i) {
			n(r, i, q)
		}
	}
	var m = new Array();
	if (h) {
		if (h != "#custom") {
			var b = h.split(",");
			for (var e = 0; e < b.length; e++) {
				m[e] = new Object();
				m[e].ascend = true;
				var g = b[e].substring(0, 1);
				var l;
				if (g == "+" || g == "-") {
					if (g == "-") {
						m[e].ascend = false
					}
					l = b[e].substring(1, b[e].length)
				} else {
					l = b[e]
				}
				for (var c = 0; c < d.fields.fieldCount; c++) {
					if (compareText(l, d.fields[c].name)) {
						m[e].index = c;
						break
					}
				}
			}
		}
	}
	if (!d.firstUnit) {
		return
	}
	var a = new Array();
	try {
		var f = d.firstUnit;
		var e = 0;
		while (f) {
			a[e++] = f;
			if (!d.sortFields) {
				f.recordno = e
			}
			f = f.nextUnit
		}
		d.sortFields = h;
		if (h != "#custom") {
			k(a, m, 0, a.length - 1)
		} else {
			n(a, 0, a.length - 1)
		}
		d.firstUnit = null;
		d.lastUnit = null;
		d.length = 0;
		for (var e = 0; e < a.length; e++) {
			pArray_insert(d, "end", null, a[e])
		}
		d.refreshControls()
	} finally {
		delete a;
		for (var e = 0; e < m.length; e++) {
			delete m[e]
		}
		delete m
	}
}
function dataset_sort(a) {
	try {
		var c = this;
		_dataset_sort(c, a)
	} catch (b) {
		processException(b)
	}
}
function dataset_setReadOnly(b) {
	var a = this;
	a.readOnly = b;
	_broadcastDatasetMsg(_notifyDatasetStateChanged, a)
}
function dataset_setAllFieldsReadOnly(c) {
	var b = this;
	for (var a = 0; a < b.fields.length; a++) {
		if (typeof (b.fields[a].fieldName) != "undefined") {
			dataset_setFieldReadOnly2(b, b.fields[a].fieldName, c)
		}
	}
}
function dataset_setFieldHidden(f, c) {
	var e = this;
	var d = e.getField(f);
	var f = d.fieldName;
	var a = $("#editor_" + f);
	var b = $("#fldlabel_" + f);
	switch (d.editType) {
	case "datalabel":
	case "textarea":
	case "radio":
	case "checkbox":
	case "text":
		if (a) {
			if (c) {
				a.parent().hide()
			} else {
				a.parent().show()
			}
		}
		if (b) {
			if (c) {
				b.parent().hide()
			} else {
				b.parent().show()
			}
		}
		break;
	case "postdate":
	case "predate":
	case "timestamp":
	case "date":
	case "select":
		if (a) {
			if (c) {
				a.parent().parent().hide()
			} else {
				a.parent().parent().show()
			}
		}
		if (b) {
			if (c) {
				b.parent().hide()
			} else {
				b.parent().show()
			}
		}
		break
	}
}
function dataset_setFieldReadOnly(d, c) {
	var b = this;
	var a = b.getField(d);
	if (a) {
		a.readOnly = c;
		_broadcastFieldMsg(_notifyFieldStateChanged, b, b.record, a, {
			state : "readonly"
		})
	} else {
		throw constErrCantFindField.replace("%s", b.id + "." + d)
	}
}
function dataset_setFieldRequired(d, c) {
	var b = this;
	var a = b.getField(d);
	if (a) {
		a.required = c;
		_broadcastFieldMsg(_notifyFieldStateChanged, b, b.record, a, {
			state : "required",
			value : c
		})
	} else {
		throw constErrCantFindField.replace("%s", b.id + "." + d)
	}
}
function dataset_setFieldReadOnly2(a, d, c) {
	var b = a.getField(d);
	if (b) {
		b.readOnly = c;
		_broadcastFieldMsg(_notifyFieldStateChanged, a, a.record, b, {
			state : "readonly"
		})
	} else {
		throw constErrCantFindField.replace("%s", a.id + "." + d)
	}
}
function fireDatasetEvent(c, b, d) {
	if (c.disableEventCount > 0) {
		return
	}
	var a;
	a = fireUserEvent(getElementEventName(c, b), d);
	return a
}
function dataset_isRecordValid(c) {
	if (!c) {
		return false
	} else {
		var b = (c.recordState != "delete" && c.recordState != "discard" && c.visible);
		var f = c.dataset;
		var h = f.masterDataset;
		if (b) {
			if (h) {
				if (!h.record) {
					return false
				}
				for (var d = 0; d < f.references.length; d++) {
					var a = getStringValue(h
							.getCurValue(f.references[d].masterIndex));
					var g = getStringValue(getTypedValue(
							c[f.references[d].detailIndex],
							f.getField(f.references[d].detailIndex).dataType));
					if (compareText(a, g) == false) {
						b = false;
						break
					}
				}
			}
			if (f.filtered && !(c == f.record && f.state != "none")) {
				var e = getElementEventName(f, "onFilterRecord");
				if (isUserEventDefined(e)) {
					if (!fireUserEvent(e, [ f, c ])) {
						b = false
					}
				}
			}
		}
		return b
	}
}
function dataset_setBofnEof(c, b, a) {
	if (c.bof != b || c.eof != a) {
		c.bof = b;
		c.eof = a;
		_broadcastDatasetMsg(_notifyDatasetStateChanged, c, c.record)
	}
}
function _do_dataset_setRecord(e, a) {
	if (e.record != a) {
		if (e.record) {
			_dataset_updateRecord(e)
		}
		if (e.detailDatasets) {
			var b = e.detailDatasets.firstUnit;
			while (b) {
				var d = b.data;
				_dataset_updateRecord(d);
				b = b.nextUnit
			}
		}
		var c = fireDatasetEvent(e, "beforeScroll", [ e ]);
		if (c) {
			throw c
		}
		e.record = a;
		e.modified = false;
		if (e.disableControlCount < 1) {
			e.loadDetail()
		}
		fireDatasetEvent(e, "afterScroll", [ e ]);
		_broadcastDatasetMsg(_notifyDatasetStateChanged, e, a);
		_broadcastDatasetMsg(_notifyDatasetCursorChanged, e, a)
	}
}
function _dataset_setRecord(b, a) {
	_do_dataset_setRecord(b, a);
	if (a) {
		dataset_setBofnEof(b, false, false);
		dataset_setBofnEof(b, false, false)
	}
}
function dataset_setRecord(a) {
	try {
		_dataset_setRecord(this, a)
	} catch (b) {
		processException(b)
	}
}
function validateDatasetCursor(c) {
	var d = false, e = false;
	var a = (c.record) ? c.record : c.firstUnit;
	var b = a;
	while (b) {
		if (dataset_isRecordValid(b)) {
			_do_dataset_setRecord(c, b);
			e = true;
			break
		}
		b = _record_getPrevRecord(b)
	}
	var b = a;
	while (b) {
		if (dataset_isRecordValid(b)) {
			_do_dataset_setRecord(c, b);
			d = true;
			break
		}
		b = _record_getNextRecord(b)
	}
	if (!e && !d) {
		_do_dataset_setRecord(c, null)
	}
	dataset_setBofnEof(c, (!e), (!d))
}
function dataset_setState(b, a) {
	b.state = a;
	_broadcastDatasetMsg(_notifyDatasetStateChanged, b, b.record);
	fireDatasetEvent(b, "onStateChanged", [ b ])
}
function dataset_getState(a) {
	return a.state
}
function _record_getValue(c, g) {
	var f = c.dataset;
	var b = c.fields;
	var d = -1;
	var a;
	if (typeof (g) == "number") {
		d = g
	} else {
		if (typeof (g) == "string") {
			d = b["_index_" + g.toLowerCase()]
		}
	}
	var e = b[d];
	if (typeof (e) == "undefined") {
		throw constErrCantFindField.replace("%s", c.dataset.id + "." + g)
	}
	a = getTypedValue(c[d], e.dataType);
	return a
}
function record_getValue(b) {
	try {
		return _record_getValue(this, b)
	} catch (a) {
		processException(a)
	}
}
function _record_getJsonValue(e) {
	var b = this;
	var a = "";
	var d = b.dataset.getField(e);
	if (d) {
		var c = b.getValue(e);
		switch (d.dataType) {
		case "string":
			a = getValidStr(c);
			break;
		case "byte":
		case "short":
		case "int":
		case "long":
			if (!isNaN(c)) {
				a = c + ""
			}
			break;
		case "float":
		case "double":
		case "currency":
		case "bigdecimal":
			if (!isNaN(c)) {
				a = formatFloat(c, d.scale)
			}
			break;
		case "predate":
		case "postdate":
		case "date":
			if (typeof (c) == "object" && !isNaN(c)) {
				a = c.format(_VIEW_DATE_PATTERN)
			} else {
				a = ""
			}
			break;
		case "time":
			if (typeof (c) == "object" && !isNaN(c)) {
				a = c.format(_VIEW_TIME_PATTERN)
			} else {
				a = ""
			}
			break;
		case "timestamp":
			if (typeof (c) == "object" && !isNaN(c)) {
				a = c.format(_VIEW_DATETIME_PATTERN)
			} else {
				a = ""
			}
			break;
		case "boolean":
		default:
			a = getValidStr(c);
			break
		}
	}
	return a
}
function record_getString(g) {
	var b = this, f, a = "";
	var f = b.dataset.getField(g);
	if (f) {
		var c = b.getValue(g);
		switch (f.dataType) {
		case "string":
			a = getValidStr(c);
			break;
		case "byte":
		case "short":
		case "int":
		case "long":
			if (!isNaN(c)) {
				a = c + ""
			}
			break;
		case "float":
		case "double":
		case "currency":
		case "bigdecimal":
			if (!isNaN(c)) {
				a = formatFloat(c, f.scale)
			}
			break;
		case "predate":
		case "postdate":
		case "date":
		case "time":
		case "timestamp":
			a = formatDateTime(c, f.dataType);
			break;
		case "boolean":
		default:
			a = getValidStr(c);
			break
		}
	}
	try {
		if (typeof (f.tag) != "undefined" && f.tag != ""
				&& f.tag == "selectName" && c == "") {
			a = getFieldSelectNameValue(b, f)
		} else {
			if (typeof (f.tag) != "undefined" && f.tag != ""
					&& f.tag == "radioName" && c == "") {
				a = getFieldRadioNameValue(b, f)
			}
		}
	} catch (d) {
	} finally {
		return a
	}
}
function record_getViewString(g) {
	var b = this, f, a = "";
	var f = b.dataset.getField(g);
	if (f) {
		var c = b.getValue(g);
		switch (f.dataType) {
		case "string":
			a = getValidStr(c);
			break;
		case "byte":
		case "short":
		case "int":
		case "long":
			if (!isNaN(c)) {
				a = c + ""
			}
			break;
		case "currency":
			if (!isNaN(c)) {
				a = formatFloat(c, f.scale);
				a = formatCurrency(a)
			}
			break;
		case "float":
		case "double":
		case "bigdecimal":
			if (!isNaN(c)) {
				a = formatFloat(c, f.scale)
			}
			break;
		case "predate":
		case "postdate":
		case "date":
		case "time":
		case "timestamp":
			a = formatViewDateTime(c, f.dataType);
			break;
		case "boolean":
		default:
			a = getValidStr(c);
			break
		}
	}
	try {
		if (typeof (f.tag) != "undefined" && f.tag != ""
				&& f.tag == "selectName" && c == "") {
			a = getFieldSelectNameValue(b, f)
		} else {
			if (f.tag == "radioName" && c == "") {
				a = getFieldRadioNameValue(b, f)
			}
		}
	} catch (d) {
	} finally {
		return a
	}
}
function record_getString_2(b, e) {
	var d, a = "";
	var d = b.dataset.getField(e);
	if (d) {
		var c = b.getValue(e);
		switch (d.dataType) {
		case "string":
			a = getValidStr(c);
			break;
		case "byte":
		case "short":
		case "int":
		case "long":
			if (!isNaN(c)) {
				a = c + ""
			}
			break;
		case "float":
		case "double":
		case "bigdecimal":
			if (!isNaN(c)) {
				a = formatFloat(c, d.scale)
			}
			break;
		case "predate":
		case "postdate":
		case "date":
		case "time":
		case "timestamp":
			a = formatDateTime(c, d.dataType);
			break;
		case "boolean":
		default:
			a = getValidStr(c);
			break
		}
	}
	return a
}
function _record_setValue(record, fieldName, value) {
	var dataset = record.dataset;
	var fields = record.fields;
	var fieldIndex = -1;
	if (typeof (fieldName) == "number") {
		fieldIndex = fieldName
	} else {
		if (typeof (fieldName) == "string") {
			fieldIndex = fields["_index_" + fieldName.toLowerCase()]
		}
	}
	if (typeof (fields[fieldIndex]) == "undefined") {
		throw constErrCantFindField.replace("%s", record.dataset.id + "."
				+ fieldName)
	}
	var field = fields[fieldIndex];
	if (field.mask && field.mask != "null") {
		if (value == "" && !field.required) {
		} else {
			var valid = false;
			value = (value + "").replace(/\\/g, "\\\\");
			value = value.replace(/\"/g, '\\"');
			var rule;
			try {
				rule = eval(field.mask);
				var valid = new RegExp(rule).test(value + "");
				if (!valid) {
					if (field.maskErrorMessage) {
						throw field.maskErrorMessage.replace("%s", value)
					} else {
						throw constErrInputMask.replace("%s", value)
					}
				}
			} catch (e) {
			}
		}
	}
	switch (field.dataType) {
	case "int":
		value = getValidStr(value);
		value = parseInt(parseFloat(value));
		if (isNaN(value)) {
			value = ""
		}
		break;
	case "float":
	case "double":
		value = getValidStr(value);
		value = parseFloat(value);
		if (isNaN(value)) {
			value = ""
		}
		break;
	case "predate":
	case "postdate":
	case "date":
		if ($.type(value) != "date") {
			value = getValidStr(value);
			value = parseDate(value)
		}
		break;
	case "timestamp":
		if ($.type(value) != "date") {
			value = getValidStr(value);
			value = parseTimestamp(value)
		}
		break;
	case "time":
		if ($.type(value) != "date") {
			value = getValidStr(value);
			value = new Date("2000/01/01 " + value.replace(/-/g, "/"))
		}
		break;
	case "boolean":
		value = isTrue(value);
		break
	}
	if (dataset.loadCompleted) {
		var event_result = fireDatasetEvent(dataset, "beforeChange", [ dataset,
				field, value ]);
		if (event_result) {
			throw event_result
		}
	}
	var eventName = getElementEventName(dataset, "onSetValue");
	if (isUserEventDefined(eventName) && dataset.record
			&& dataset.loadCompleted) {
		value = fireUserEvent(eventName, [ dataset, field, value ])
	}
	record[fieldIndex] = value;
	dataset.modified = true;
	if (dataset.isCheckAll) {
		dataset.record = record
	}
	fireDatasetEvent(dataset, "afterChange", [ dataset, field ]);
	if (record.recordState == "none") {
		record.recordState = "modify"
	}
	if (dataset.state == "none") {
		dataset_setState(dataset, "modify")
	}
	_broadcastFieldMsg(_notifyFieldDataChanged, dataset, record, field)
}
function _record_setValue_2(record, fieldName, value) {
	var dataset = record.dataset;
	var fields = record.fields;
	var fieldIndex = -1;
	if (typeof (fieldName) == "number") {
		fieldIndex = fieldName
	} else {
		if (typeof (fieldName) == "string") {
			fieldIndex = fields["_index_" + fieldName.toLowerCase()]
		}
	}
	if (typeof (fields[fieldIndex]) == "undefined") {
		throw constErrCantFindField.replace("%s", record.dataset.id + "."
				+ fieldName)
	}
	var field = fields[fieldIndex];
	if (getValidStr(field.mask) != "") {
		if (value == "" && !field.required) {
		} else {
			var valid = false;
			eval("valid=" + field.mask + '.test("'
					+ (value + "").replace(/\\/g, "\\\\") + '");');
			if (!valid) {
				if (field.maskErrorMessage) {
					throw field.maskErrorMessage.replace("%s", value)
				} else {
					throw constErrInputMask.replace("%s", value)
				}
			}
		}
	}
	switch (field.dataType) {
	case "int":
		value = getValidStr(value);
		value = parseInt(value);
		break;
	case "float":
		value = getValidStr(value);
		value = parseFloat(value);
		break;
	case "double":
		value = getValidStr(value);
		value = value * 1;
		break;
	case "predate":
	case "postdate":
	case "date":
	case "timestamp":
		value = getValidStr(value);
		value = new Date(value.replace(/-/g, "/"));
		break;
	case "time":
		value = getValidStr(value);
		value = new Date("2000/01/01 " + value.replace(/-/g, "/"));
		break;
	case "boolean":
		value = isTrue(value);
		break
	}
	if (dataset.loadCompleted) {
		var event_result = fireDatasetEvent(dataset, "beforeChange", [ dataset,
				field, value ]);
		if (event_result) {
			throw event_result
		}
	}
	var eventName = getElementEventName(dataset, "onSetValue");
	if (isUserEventDefined(eventName) && dataset.record
			&& dataset.loadCompleted) {
		value = fireUserEvent(eventName, [ dataset, field, value ])
	}
	record[fieldIndex] = value
}
function record_setValue(c, a) {
	try {
		_record_setValue(this, c, a)
	} catch (b) {
		processException(b)
	}
}
function record_getCurValue(b) {
	var a = this;
	if (typeof (b) == "number") {
		return a.getValue(b + a.fields.fieldCount)
	} else {
		return a.getValue("_cur_" + b)
	}
}
function record_setCurValue(c, b) {
	var a = this;
	if (typeof (c) == "number") {
		a.setValue(c + a.fields.fieldCount, b)
	} else {
		a.setValue("_cur_" + c, b)
	}
}
function record_getOldValue(b) {
	var a = this;
	if (typeof (b) == "number") {
		return a.getValue(b + a.fields.fieldCount * 2)
	} else {
		return a.getValue("_old_" + b)
	}
}
function record_setOldValue(c, b) {
	var a = this;
	if (typeof (c) == "number") {
		a.setValue(c + a.fields.fieldCount * 2, b)
	} else {
		a.setValue("_old_" + c, b)
	}
}
function dataset_getValue(b) {
	var a = this;
	if (a.record) {
		return a.record.getValue(b)
	} else {
		return ""
	}
}
function dataset_getString(b) {
	var a = this;
	if (a.record) {
		return a.record.getString(b)
	} else {
		return ""
	}
}
function dataset_getViewString(b) {
	var a = this;
	if (a.record) {
		return a.record.getViewString(b)
	} else {
		return ""
	}
}
function dataset_setValue(d, a) {
	try {
		var c = this;
		if (c.record) {
			c.record.setValue(d, a)
		} else {
			c.insertRecord();
			c.record.setValue(d, a)
		}
	} catch (b) {
		processException(b)
	}
}
function dataset_setValue_2(d, a) {
	try {
		var c = this;
		if (c.record) {
			c.record.setValue(d, a)
		} else {
			c.insertRecord();
			c.record.setValue(d, a)
		}
	} catch (b) {
		processException(b)
	}
}
function dataset_getCurValue(b) {
	var a = this;
	if (typeof (b) == "number") {
		return a.getValue(b + a.fields.fieldCount)
	} else {
		return a.getValue("_cur_" + b)
	}
}
function dataset_setCurValue(c, a) {
	var b = this;
	if (typeof (c) == "number") {
		b.setValue(c + b.fields.fieldCount, a)
	} else {
		b.setValue("_cur_" + c, a)
	}
}
function dataset_getOldValue(b) {
	var a = this;
	if (typeof (b) == "number") {
		return a.getValue(b + a.fields.fieldCount * 2)
	} else {
		return a.getValue("_old_" + b)
	}
}
function dataset_setOldValue(c, a) {
	var b = this;
	if (typeof (c) == "number") {
		b.setValue(c + b.fields.fieldCount * 2, a)
	} else {
		b.setValue("_old_" + c, a)
	}
}
function _record_getPrevRecord(a) {
	var b = a;
	while (b) {
		b = b.prevUnit;
		if (dataset_isRecordValid(b)) {
			return b
		}
	}
}
function record_getPrevRecord() {
	return _record_getPrevRecord(this)
}
function _record_getNextRecord(a) {
	var b = a;
	while (b) {
		b = b.nextUnit;
		if (dataset_isRecordValid(b)) {
			return b
		}
	}
}
function record_getNextRecord() {
	return _record_getNextRecord(this)
}
function dataset_disableControls() {
	var a = this;
	a.disableControlCount = a.disableControlCount + 1
}
function dataset_enableControls() {
	var a = this;
	a.disableControlCount = (a.disableControlCount > 0) ? a.disableControlCount - 1
			: 0;
	a.refreshControls()
}
function dataset_disableEvents() {
	var a = this;
	a.disableEventCount = a.disableEventCount + 1
}
function dataset_enableEvents() {
	var a = this;
	a.disableEventCount = (a.disableEventCount > 0) ? a.disableEventCount - 1
			: 0
}
function dataset_refreshControls() {
	var a = this;
	validateDatasetCursor(a);
	_broadcastDatasetMsg(_notifyDatasetRefresh, a, a.record)
}
function _dataset_move(c, f) {
	var j = c.record;
	if (!j) {
		j = c.getFirstRecord()
	}
	if (!j) {
		return
	}
	var e = j;
	if (f > 0) {
		var g = e.pageIndex;
		var h = false;
		for (var d = 0; d < f; d++) {
			var b = 0;
			j = e.getNextRecord();
			if (!j || (j && j.pageIndex != g)) {
				if (g < c.pageCount) {
					if (!c.isPageLoaded(g + 1)) {
						if ((d + c.pageSize < f) && (g + 1 < c.pageCount)) {
							d += c.pageSize - 1;
							j = e
						} else {
							_dataset_loadPage(c, g + 1);
							j = e.getNextRecord()
						}
					}
				}
				g++
			}
			if (j) {
				e = j
			} else {
				h = true;
				break
			}
		}
		dataset_setBofnEof(c, (!dataset_isRecordValid(c.record)), h)
	} else {
		var g = e.pageIndex;
		var a = false;
		for (var d = f; d < 0; d++) {
			var b = 0;
			j = e.getPrevRecord();
			if (!j || (j && j.pageIndex != g)) {
				if (g > 1) {
					if (!c.isPageLoaded(g - 1)) {
						if ((d + c.pageSize < 0) && (g > 1)) {
							d += c.pageSize - 1;
							j = e
						} else {
							_dataset_loadPage(c, g - 1);
							j = e.getPrevRecord()
						}
					}
				}
				g--
			}
			if (j) {
				e = j
			} else {
				a = true;
				break
			}
		}
		dataset_setBofnEof(c, a, (!dataset_isRecordValid(c.record)))
	}
	if (e) {
		_do_dataset_setRecord(c, e)
	}
}
function dataset_move(a) {
	var c = this;
	try {
		_dataset_move(c, a)
	} catch (b) {
		processException(b)
	}
}
function dataset_movePrev() {
	var b = this;
	try {
		_dataset_move(b, -1)
	} catch (a) {
		processException(a)
	}
}
function dataset_moveNext() {
	var b = this;
	try {
		_dataset_move(b, 1)
	} catch (a) {
		processException(a)
	}
}
function _dataset_getFirstRecord(b) {
	var a = b.firstUnit;
	if (a && !dataset_isRecordValid(a)) {
		a = a.getNextRecord()
	}
	return a
}
function dataset_getFirstRecord() {
	return _dataset_getFirstRecord(this)
}
function dataset_moveFirst() {
	var b = this;
	try {
		if (!b.isPageLoaded(1)) {
			_dataset_loadPage(b, 1)
		}
		_do_dataset_setRecord(b, b.getFirstRecord());
		dataset_setBofnEof(b, true, (!dataset_isRecordValid(b.record)))
	} catch (a) {
		processException(a)
	}
}
function _dataset_getLastRecord(b) {
	var a = b.lastUnit;
	if (!dataset_isRecordValid(a) && a) {
		a = a.getPrevRecord()
	}
	return a
}
function dataset_getLastRecord() {
	return _dataset_getLastRecord(this)
}
function dataset_moveLast() {
	var b = this;
	try {
		if (!b.isPageLoaded(b.pageCount)) {
			_dataset_loadPage(b, b.pageCount)
		}
		_do_dataset_setRecord(b, b.getLastRecord());
		dataset_setBofnEof(b, (!dataset_isRecordValid(b.record)), true)
	} catch (a) {
		processException(a)
	}
}
function dataset_find(f, b, c) {
	function d(l, i, h) {
		var g = true;
		for (var k = 0; k < l.length && k < i.length; k++) {
			if (!compareText(h.getString(l[k]), i[k])) {
				g = false;
				break
			}
		}
		return g
	}
	if (!f || !b) {
		return false
	}
	var e = this;
	if (!e.record) {
		return
	}
	if (d(f, b, e.record)) {
		return e.record
	}
	var a = (c) ? c : e.getFirstRecord();
	while (a) {
		if (d(f, b, a)) {
			return a
		}
		a = a.getNextRecord()
	}
}
function dataset_findRecordByUUID(b) {
	var a = this.getFirstRecord();
	while (a) {
		if (a._uuid == b) {
			return a
		}
		a = a.getNextRecord()
	}
}
function dataset_locate(g, e, c) {
	function d(k, j, h) {
		var i = h.getString(k);
		return (i && compareText(i.substr(0, a), j))
	}
	if (!e) {
		return false
	}
	var f = this;
	if (!f.record) {
		return
	}
	if (d(g, e, f.record)) {
		return f.record
	}
	var a = e.length;
	var b = (c) ? c : f.getFirstRecord();
	while (b) {
		if (d(g, e, b)) {
			return b
		}
		b = b.getNextRecord()
	}
}
function _dataset_insertRecord(e, j) {
	_dataset_updateRecord(e);
	var d = fireDatasetEvent(e, "beforeInsert", [ e, j ]);
	if (d) {
		throw d
	}
	var f = e.masterDataset;
	if (f) {
		if (f.record) {
			_dataset_updateRecord(f)
		}
	}
	var b = (e.record) ? e.record.pageIndex : 1;
	var k = new Array();
	pArray_insert(e, j, e.record, k);
	initRecord(k, e);
	switch (j) {
	case "begin":
		k.pageIndex = 1;
		break;
	case "end":
		k.pageIndex = e.pageCount;
		break;
	default:
		k.pageIndex = b;
		break
	}
	k.recordState = "new";
	k.recordno = 9999;
	var f = e.masterDataset;
	if (f) {
		if (f.record) {
			for (var g = 0; g < e.references.length; g++) {
				var o = e.references[g].masterIndex;
				if (f.getString(o) == "") {
					var m = f.getField(o);
					switch (m.dataType) {
					case "string":
						f.setValue(o, _getAutoGenID());
						break;
					case "byte":
					case "short":
					case "int":
					case "long":
					case "float":
					case "double":
					case "bigdecimal":
						var a = 0;
						var h = f.firstUnit;
						while (h) {
							if (h.getValue(o) > a) {
								a = h.getValue(o)
							}
							h = h.nextUnit
						}
						f.setValue(o, a + 1);
						break
					}
				}
			}
			_dataset_updateRecord(f);
			for (var g = 0; g < e.references.length; g++) {
				var c = e.references[g];
				k[c.detailIndex] = f.getValue(c.masterIndex)
			}
		} else {
			throw constErrNoMasterRecord
		}
	}
	var n = e.fields.fieldCount;
	for (var g = 0; g < n; g++) {
		var m = e.fields[g];
		var l = getValidStr(m.defaultValue);
		if (l != "") {
			k[g] = l
		}
	}
	dataset_setState(e, "insert");
	_broadcastDatasetMsg(_notifyDatasetInsert, e, e.record, [ j, k ]);
	_dataset_setRecord(e, k);
	var n = e.fields.fieldCount;
	for (var g = 0; g < n; g++) {
		var m = e.fields[g];
		if (m.autoGenId) {
			e.setValue(g, _getAutoGenID())
		}
	}
	fireDatasetEvent(e, "afterInsert", [ e, j ]);
	e.modified = true
}
function dataset_insertRecord(b) {
	try {
		_dataset_insertRecord(this, b)
	} catch (a) {
		processException(a)
	}
}
function _dataset_deleteRecord(c) {
	if (!c.record) {
		return
	}
	if (c.detailDatasets) {
		var a = c.detailDatasets.firstUnit;
		while (a && a.data) {
			var d = a.data;
			if (d.references.length > 0) {
				_dataset_updateRecord(d);
				d.moveFirst();
				while (!d.eof) {
					d.deleteRecord()
				}
			}
			d.refreshControls();
			a = a.nextUnit
		}
	}
	needUpdateEditor = false;
	try {
		if (c.record.recordState == "new" || c.record.recordState == "insert") {
			var b = fireDatasetEvent(c, "beforeDelete", [ c ]);
			if (b) {
				throw b
			}
			c.record.recordState = "discard"
		} else {
			var b = fireDatasetEvent(c, "beforeDelete", [ c ]);
			if (b) {
				throw b
			}
			c.record.recordState = "delete";
			_changeMasterRecordState(c)
		}
		c.modified = false;
		fireDatasetEvent(c, "afterDelete", [ c ]);
		dataset_setState(c, "none");
		_broadcastDatasetMsg(_notifyDatasetDelete, c, c.record);
		validateDatasetCursor(c)
	} finally {
		needUpdateEditor = true
	}
}
function dataset_deleteRecord() {
	try {
		_dataset_deleteRecord(this)
	} catch (a) {
		processException(a)
	}
}
function _dataset_updateRecord(e) {
	if (!e.record) {
		return
	}
	if (!dataset_isRecordValid(e.record)) {
		return
	}
	_broadcastDatasetMsg(_notifyDatasetBeforeUpdate, e, e.record);
	if (e.modified) {
		var l = e.fields.fieldCount;
		for (var g = 0; g < l; g++) {
			if (!isTrue(e.fields[g].readOnly) && isTrue(e.fields[g].required)
					&& e.getString(g) == "" && e.fields[g].tag != "selectName") {
				throw constErrFieldValueRequired.replace("%s",
						e.fields[g].label)
			}
		}
		var d = fireDatasetEvent(e, "beforeUpdate", [ e ]);
		if (d) {
			throw d
		}
		var c = new Array();
		if (e.detailDatasets) {
			var k = e.detailDatasets.firstUnit;
			while (k && k.data) {
				var a = k.data;
				if (a.references.length > 0) {
					var h = a.disableControlCount;
					a.disableControlCount = 1;
					try {
						var f = false;
						_dataset_updateRecord(a);
						a.moveFirst();
						while (!a.eof) {
							for (var g = 0; g < a.references.length; g++) {
								var j = a.references[g].detailIndex;
								var b = a.references[g].masterIndex;
								if (a.getValue(j) != e.getValue(b)) {
									a.setValue(j, e.getValue(b));
									f = true
								}
							}
							_dataset_updateRecord(a);
							a.moveNext()
						}
					} finally {
						a.disableControlCount = h
					}
					if (f) {
						c[c.length] = a
					}
				}
				k = k.nextUnit
			}
		}
		switch (e.record.recordState) {
		case "none":
			e.record.recordState = "modify";
			_changeMasterRecordState(e);
			break;
		case "new":
			e.record.recordState = "insert";
			_changeMasterRecordState(e);
			break
		}
		for (var g = 0; g < l; g++) {
			e.record[l + g] = e.record[g]
		}
		e.modified = false;
		fireDatasetEvent(e, "afterUpdate", [ e ]);
		dataset_setState(e, "none");
		for (var g = 0; g < c.length; g++) {
			a.refreshControls();
			validateDatasetCursor(a)
		}
	} else {
		if (e.record.recordState == "new") {
			e.record.recordState = "discard";
			dataset_setState(e, "none");
			_broadcastDatasetMsg(_notifyDatasetDelete, e, e.record);
			validateDatasetCursor(e)
		}
	}
}
function dataset_updateRecord() {
	try {
		_dataset_updateRecord(this);
		return true
	} catch (a) {
		processException(a);
		return false
	}
}
function _dataset_cancelRecord(d) {
	if (!d.record) {
		return
	}
	needUpdateEditor = false;
	try {
		if (d.record.recordState == "new") {
			var c = fireDatasetEvent(d, "beforeCancel", [ d ]);
			if (c) {
				throw c
			}
			d.record.recordState = "discard";
			fireDatasetEvent(d, "afterCancel", [ d ]);
			dataset_setState(d, "none");
			_broadcastDatasetMsg(_notifyDatasetDelete, d, d.record);
			validateDatasetCursor(d)
		} else {
			if (d.modified) {
				var c = fireDatasetEvent(d, "beforeCancel", [ d ]);
				if (c) {
					throw c
				}
				var b = d.fields.fieldCount;
				for (var a = 0; a < b; a++) {
					d.record[a] = d.record[b + a]
				}
				d.modified = false;
				fireDatasetEvent(d, "afterCancel", [ d ]);
				dataset_setState(d, "none");
				_broadcastDatasetMsg(_notifyDatasetRefreshRecord, d, d.record)
			}
		}
	} finally {
		needUpdateEditor = true
	}
}
function dataset_cancelRecord() {
	try {
		_dataset_cancelRecord(this)
	} catch (a) {
		processException(a)
	}
}
function _dataset_copyRecord(d, g, b) {
	if (b) {
		var a = new Array();
		var h = b.split(";");
		var e = "", c = "";
		for (var f = 0; f < h.length; f++) {
			a[f] = new Object();
			var j = h[f].indexOf("=");
			if (j >= 0) {
				e = h[f].substr(0, j);
				c = h[f].substr(j + 1)
			} else {
				e = h[f];
				c = h[f]
			}
			var l = g.getValue(c);
			if (typeof (l) != "undefined") {
				d.setValue(e, l)
			}
		}
	} else {
		for (var f = 0; f < d.fields.fieldCount; f++) {
			var m = d.getField(f).name;
			var k = g.dataset.getField(m);
			if (k) {
				var l = g.getValue(m);
				if (typeof (l) != "undefined") {
					d.setValue(m, l)
				}
			}
		}
	}
}
function dataset_copyRecord(a, b) {
	var c = this;
	_dataset_copyRecord(c, a, b)
}
function _broadcastDatasetMsg(c, f, b, a) {
	if (f.disableControlCount > 0) {
		return
	}
	var d = f.editors;
	if (d) {
		var e = d.firstUnit;
		while (e && e.data) {
			c(e.data, f, b, a);
			e = e.nextUnit
		}
	}
}
function _broadcastFieldMsg(c, g, b, f, a) {
	if (g.disableControlCount > 0) {
		return
	}
	var d = g.editors;
	if (d) {
		var e = d.firstUnit;
		while (e && e.data) {
			c(e.data, g, b, f, a);
			e = e.nextUnit
		}
	}
}
function _FieldValid(c) {
	if (c.disableControlCount > 0) {
		return {
			fieldArray : new Array(),
			isValid : false
		}
	}
	var f = c.editors;
	var m = new Array();
	var a = new Array();
	var l = c.fields.fieldCount;
	for (var e = 0; e < l; e++) {
		m.push(c.fields[e])
	}
	var n = false;
	if (f) {
		var h = f.firstUnit;
		while (h && h.data) {
			var d = h.data;
			switch (d.getAttribute("extra")) {
			case "dropDownSelect":
			case "editor":
			case "dockeditor":
				var o = d.getAttribute("dataField");
				var g = c.getField(o);
				if (!g.readOnly) {
					if ($(d).parent().is(":hidden") && validateQuery(false, d)) {
						return $(d).attr("dataField")
					}
					n = validateQuery(n, d);
					a.push(d.getAttribute("dataField"))
				}
				break
			}
			h = h.nextUnit
		}
	}
	for (var e = 0; e < m.length;) {
		var k = true;
		for (var b = 0; b < a.length; b++) {
			if (m[e] && m[e].fieldName == a[b]) {
				m.splice(e, 1);
				k = false
			}
		}
		if (k) {
			e++
		}
	}
	return {
		fieldArray : m,
		isValid : n
	}
}
function _notifyDatasetCursorChanged(c, d, b, a) {
	switch (c.getAttribute("extra")) {
	case "datagrid":
		refreshDatagridCursor(c, d, b, a);
		break;
	case "rdatagrid":
		refreshReadonlyTableCursor(c, d, b, a);
		break;
	case "datalabel":
		refreshDatalabelValue(c, d, b);
		break;
	case "dropDownSelect":
		if (d.type == "dropdown") {
			break
		}
	case "editor":
		refreshInputValue(c, d, b);
		c.isUserInput = false;
		break
	}
}
function _notifyDatasetBeforeUpdate(c, d, b, a) {
	var e = c.window;
	switch (c.getAttribute("extra")) {
	case "dockeditor":
		e.updateEditorInput(c);
		break
	}
}
function _notifyDatasetStateChanged(c, e, b, a) {
	var f = c.window;
	switch (c.getAttribute("extra")) {
	case "editor":
	case "dropDownSelect":
	case "dockeditor":
		var d = f.getElementField(c);
		c.setReadOnly(!isFieldEditable(e, d));
		break;
	case "datapilot":
		f.refreshDataPilot(c);
		break;
	case "datatable":
		if (c.activeRow) {
			f.refreshTableRowIndicate(c.activeRow)
		}
		break
	}
}
function _notifyDatasetInsert(m, j, n, f) {
	var c = m.window;
	switch (m.getAttribute("extra")) {
	case "datagrid":
		var b = $(m);
		var r = {};
		var q = f[1];
		var e = q.getString("_id") || "_j" + new Date().getTime() + $.uuid++;
		var o = f[0];
		q._uuid = e;
		r.record = q;
		r._recordUUID = e;
		for (var l = 0; l < j.fields.fieldCount; l++) {
			var p = j.getField(l).fieldName;
			var d = q.getJsonValue(p);
			r[p] = d
		}
		if (b.attr("treeGrid") == "false") {
			var a = b.datagrid("options");
			var g = a.selectedIndex;
			if (g > -1) {
				if (o == "begin") {
					b.datagrid("insertRow", {
						index : 0,
						row : r
					})
				} else {
					if (o == "before") {
						b.datagrid("insertRow", {
							index : g,
							row : r
						})
					} else {
						if (o == "after") {
							b.datagrid("insertRow", {
								index : g + 1,
								row : r
							})
						} else {
							b.datagrid("appendRow", r)
						}
					}
				}
			} else {
				b.datagrid("appendRow", r)
			}
			b.datagrid("selectRecord", e);
			a.init = true;
			a.editing = false
		} else {
			var a = b.treegrid("options");
			var h = a.selectedId;
			var k = a.loadFilter;
			a.loadFilter = function(i, s) {
				return i
			};
			if (h) {
				if (!n) {
					o = "end"
				}
				if (o == "begin") {
					b.treegrid("insert", {
						before : j.firstUnit[a.idField],
						row : r
					})
				} else {
					if (o == "before") {
						b.treegrid("insert", {
							before : h,
							data : r
						})
					} else {
						if (o == "after") {
							b.treegrid("insert", {
								after : h,
								data : r
							})
						} else {
							if (o == "child") {
								r._parentId = h;
								q[n.fields._index__parentid] = h;
								a.loadFilter = k;
								b.treegrid("expand", h);
								a.loadFilter = function(i, s) {
									return i
								};
								b.treegrid("append", {
									parent : h,
									data : [ r ]
								})
							} else {
								b.treegrid("append", {
									data : [ r ]
								})
							}
						}
					}
				}
			} else {
				b.treegrid("append", {
					data : [ r ]
				})
			}
			a.loadFilter = k;
			a.init = true;
			a.editing = false
		}
		break;
	case "rdatagrid":
		var b = $(m);
		var r = {};
		var q = f[1];
		var e = q.getString("_id") || "_j" + new Date().getTime() + $.uuid++;
		var o = f[0];
		q._uuid = e;
		r.record = q;
		r._recordUUID = e;
		for (var l = 0; l < j.fields.fieldCount; l++) {
			var p = j.getField(l).fieldName;
			var d = q.getJsonValue(p);
			r[p] = d
		}
		var a = b.rdatagrid("options");
		var g = a.selectedIndex;
		if (g > -1) {
			if (o == "begin") {
				b.rdatagrid("insertRow", {
					index : 0,
					row : r
				})
			} else {
				if (o == "before") {
					b.rdatagrid("insertRow", {
						index : g,
						row : r
					})
				} else {
					if (o == "after") {
						b.rdatagrid("insertRow", {
							index : g + 1,
							row : r
						})
					} else {
						b.rdatagrid("appendRow", r)
					}
				}
			}
		} else {
			b.rdatagrid("appendRow", r)
		}
		b.rdatagrid("selectRecord", e);
		a.init = true;
		a.editing = false;
		break
	}
}
function _notifyDatasetDelete(j, g, k, e) {
	switch (j.getAttribute("extra")) {
	case "datagrid":
		if (k) {
			var c = $(j);
			if (c.attr("treeGrid") == "false") {
				var b = c.datagrid("options");
				var f = b.selectedIndex;
				c.datagrid("deleteRow", f);
				b.selectedIndex--;
				b.editing = false
			} else {
				var d = c.treegrid("getChildren", k._uuid);
				for (var h = 0; h < d.length; h++) {
					var a = d[h].record;
					if (a.recordSate == "new" || a.recordState == "insert") {
						a.recordState = "discard"
					} else {
						a.recordState = "delete"
					}
				}
				c.treegrid("remove", k._uuid)
			}
		}
		break;
	case "rdatagrid":
		if (k) {
			var c = $(j);
			var b = c.rdatagrid("options");
			var f = b.selectedIndex;
			c.rdatagrid("deleteRow", f);
			b.selectedIndex--
		}
		break
	}
}
function _notifyDatasetRefreshRecord(c, d, b, a) {
	var e = c.window;
	switch (c.getAttribute("extra")) {
	case "datagrid":
		if (b) {
			e.refreshDataGridRow(c, d, b, a)
		}
		break;
	case "rdatagrid":
		if (b) {
			e.refreshReadonlyTableRow(c, d, b, a)
		}
		break;
	case "datalabel":
		refreshDatalabelValue(c, d, b);
		break;
	case "editor":
	case "dropDownSelect":
	case "dockeditor":
		refreshInputValue(c, d, b);
		c.isUserInput = false;
		break
	}
	if (e.isFileIncluded("editor")) {
		e.sizeDockEditor()
	}
}
function _notifyDatasetRefresh(c, d, b, a) {
	var e = c.window;
	switch (c.getAttribute("extra")) {
	case "datagrid":
		e.refreshDataTable(c);
		break;
	case "rdatagrid":
		refreshReadonlyTable(c);
		break;
	case "datalabel":
		if (d.loadCompleted) {
			refreshDatalabelValue(c, d, b)
		}
		break;
	case "editor":
	case "dropDownSelect":
		d.modified = false;
		if (d.loadCompleted) {
			refreshInputValue(c, d, b)
		}
		break;
	case "datapilot":
		e.refreshDataPilot(c);
		break;
	case "pagination":
		e.refreshPagination(c);
		break;
	case "pagepilot":
		e.refreshPagePilot(c);
		break
	}
	_notifyDatasetStateChanged(c, d, b, a);
	if (e.isFileIncluded("editor")) {
		e.sizeDockEditor()
	}
}
function _notifyFieldDataChanged(c, e, b, d, a) {
	var f = c.window;
	switch (c.getAttribute("extra")) {
	case "datagrid":
		f.refreshDataGridCellValue(c, e, d, b);
		break;
	case "rdatagrid":
		refreshReadonlyTableCellValue(c, e, d, b);
		break;
	case "editor":
		if (compareText(c.getAttribute("dataField"), d.name)) {
			refreshInputValue(c, e, b)
		}
		break;
	case "datalabel":
		if (compareText(c.getAttribute("dataField"), d.name)) {
			refreshDatalabelValue(c, e, b)
		}
		break;
	case "dropDownSelect":
		if (compareText(c.getAttribute("dataField"), d.name)) {
			b.dropdownKey = true;
			refreshInputValue(c, e, b)
		} else {
			if (compareText(c.getAttribute("dataField") + "Name", d.name)) {
				b.dropdownKey = false;
				refreshInputValue(c, e, b)
			}
		}
		break
	}
}
function _notifyFieldStateChanged(d, c, e, h, a) {
	var i = d.getAttribute("dataField");
	if (i == h.fieldName && d.getAttribute("extra") != "fieldlabel") {
		if (a.state == "readonly") {
			d.setReadOnly(!isFieldEditable(c, h))
		} else {
			if (a.state == "required") {
				$(d).prevAll("span.requiredlabel").html(
						a.value ? "*" : "&nbsp;");
				_editor_setRequired(d, a.value)
			}
		}
	} else {
		if (d.getAttribute("extra") == "rdatagrid") {
			if (a.state == "readonly") {
				if (h.name == "select") {
					$.data(d, "rdatagrid").dc.view
							.find(
									".datagrid-header-check :checkbox,.datagrid-cell-check :checkbox")
							.each(function() {
								this.disabled = !isFieldEditable(c, h)
							})
				}
			}
		} else {
			if (d.getAttribute("extra") == "datagrid") {
				if (a.state == "readonly") {
					if (h.name == "select") {
						$.data(d, "datagrid").dc.view1
								.find(
										".datagrid-header-check :checkbox,.datagrid-cell-check :checkbox")
								.each(function() {
									this.disabled = !isFieldEditable(c, h)
								})
					}
				} else {
					if (a.state == "required") {
						var b = null;
						var g = null;
						var f = null;
						if ($(d).attr("treeGrid") == "false") {
							b = $(d).datagrid("getColumnOption", h.fieldName);
							g = $(d).datagrid("options").editIndex;
							f = $(d).datagrid("getEditor", {
								index : g,
								field : h.fieldName
							});
							if (f) {
								_editor_setRequired(f.target)
							}
						} else {
							b = $(d).treegrid("getColumnOption", h.fieldName);
							g = $(d).treegrid("options").editId;
							f = $(d).treegrid("getEditor", {
								id : g,
								field : h.fieldName
							});
							if (f) {
								_editor_setRequired(f.target)
							}
						}
						if (b) {
							b.required = a.value;
							if (b.editor && b.editor.options) {
								b.editor.options.required = a.value
							}
						}
					}
				}
			}
		}
	}
}
function _resetRecordState(a) {
	a.saveOldValue();
	if (a.recordState == "delete") {
		a.recordState = "discard"
	} else {
		if (a.recordState != "discard") {
			a.recordState = "none"
		}
	}
}
function _resetDatasetsState(e) {
	for (var c = 0; c < e.datasets.length; c++) {
		var h = e.datasets[c];
		h.disableControls()
	}
	try {
		for (var c = 0; c < e.datasets.length; c++) {
			var h = e.datasets[c];
			var a = h.firstUnit;
			while (a) {
				if (a.recordState != "none" && a.recordState != "discard") {
					var d = h.fields.fieldCount;
					for (var b = 0; b < d; b++) {
						var g = a.fields[b];
						if (g.dataType == "lob") {
							a.setValue(b, "")
						}
						if (_oidmap && a.recordState == "insert") {
							if (g.autoGenId) {
								var f = _oidmap[a.getString(b)];
								if (getValidStr(f) != "") {
									h.setRecord(a);
									h.setValue(b, f)
								}
								h.updateRecord()
							}
						}
					}
				}
				_resetRecordState(a);
				a = a.nextUnit
			}
		}
	} finally {
		for (var c = 0; c < e.datasets.length; c++) {
			var h = e.datasets[c];
			h.enableControls()
		}
	}
}
function _getUpdateString(c) {
	function d(g) {
		var e = "";
		e += 'id="' + g.id + '" ';
		e += 'sessionKey="' + g.sessionKey + '" ';
		if (g.masterDataset) {
			e += 'masterDataset="' + g.masterDataset.id + '" ';
			e += 'references="' + g.referencesString + '" '
		}
		e += 'tag="' + getEncodeStr(g.tag) + '" ';
		var n = "<Dataset " + e + ">";
		n += "<Fields>";
		for (var h = 0; h < g.fields.fieldCount; h++) {
			var k = g.getField(h);
			var e = "";
			e += 'name="' + k.name + '" ';
			e += 'dataType="' + k.dataType + '" ';
			e += 'nullable="' + k.nullable + '" ';
			e += 'updatable="' + k.updatable + '" ';
			e += 'valueProtected="' + k.valueProtected + '" ';
			e += 'fieldName="' + k.fieldName + '" ';
			e += 'tableName="' + k.tableName + '" ';
			e += 'tag="' + getEncodeStr(k.tag) + '" ';
			n += "<Field " + e + "/>"
		}
		n += "</Fields>";
		n += "<Records>";
		var j = g.firstUnit;
		while (j) {
			var l, f;
			if (g.submitData == "current") {
				l = (g.record == j);
				f = true
			} else {
				if (g.submitData == "selected") {
					l = isTrue(j.getValue("select"));
					f = true
				} else {
					switch (j.recordState) {
					case "none":
						l = (g.submitData == "all");
						f = false;
						break;
					case "insert":
						l = true;
						f = false;
						break;
					case "modify":
					case "delete":
						l = true;
						f = true;
						break;
					default:
						l = false;
						f = false;
						break
					}
				}
			}
			if (l) {
				n += '<Record state="' + j.recordState + '">';
				n += "<data>";
				for (var h = 0; h < g.fields.fieldCount; h++) {
					n += getEncodeStr(j.getString(h)) + ","
				}
				n += "</data>";
				if (f) {
					n += "<old>";
					for (var h = 0; h < g.fields.fieldCount; h++) {
						n += getEncodeStr(j.getString(g.fields.fieldCount * 2
								+ h))
								+ ","
					}
					n += "</old>"
				}
				n += "</Record>"
			}
			j = j.nextUnit
		}
		n += "</Records>";
		n += "<UpdateItems>";
		for (var h = 0; h < g.updateItems.length; h++) {
			var m = g.updateItems[h];
			var e = "";
			e += 'updateMode="' + m.updateMode + '" ';
			e += 'dataSource="' + m.dataSource + '" ';
			e += 'tableName="' + m.tableName + '" ';
			e += 'keyFields="' + m.keyFields + '" ';
			e += 'updateFields="' + m.updateFields + '" ';
			n += "<UpdateItem " + e + "/>"
		}
		n += "</UpdateItems>";
		n += "</Dataset>";
		return n
	}
	var a = '<?xml version="1.0" encoding="UTF-8"?>';
	a += '<SubmitData updaterClass="' + getValidStr(c.updaterClass) + '" ';
	a += 'forwardPath="' + c.forwardPath + '">';
	a += "<Parameters>";
	for (var b = 0; b < c.parameters.length; b++) {
		a += '<Parameter name="' + c.parameters[b].name + '">'
				+ getEncodeStr(c.parameters[b].value) + "</Parameter>"
	}
	a += "</Parameters>";
	a += "<Datasets>";
	for (var b = 0; b < c.datasets.length; b++) {
		a += d(c.datasets[b])
	}
	a += "</Datasets>";
	a += "</SubmitData>";
	return a
}
function _changeMasterRecordState(a) {
	var b = a.masterDataset;
	if (b) {
		if (b.record.recordState == "none") {
			b.record.recordState = "modify";
			_changeMasterRecordState(b)
		}
	}
}
function setFieldDropDown(d, c) {
	var b = getDatasetByID(c);
	var a = _dataset_getField(b.fields, d);
	a.dropdown = d + "_DropDown"
}
function initDropDownValues() {
	var o = new Array();
	o = getDatasets();
	for (var r = 0; r < o.length; r++) {
		var l = o[r];
		if (!l.loadCompleted && l.type && l.type == "result"
				&& l.id != "_tmp_dataset_date") {
			for (var u = 0; u < l.fields.length; u++) {
				if (l.fields[u].tag == "selectCQ") {
					var q = l.fields[u].fieldName;
					var b = q + "Name";
					var n = "";
					var v = l.fields[u].viewField;
					var t = l.fields[u].dropDown;
					var f = l.fields[u].dropDownDataset;
					var d = getDatasetByID(f);
					if (d) {
						var w = getDropDownByID(t);
						if (w != "" && w != null && w.fieldMap != "") {
							var h = w.fieldMap.split(";");
							for (var s = 0; s < h.length; s++) {
								var p = h[s].split("=");
								if (p[0] == l.fields[u].fieldName) {
									n = p[1];
									if (v == "") {
										v = n + "Name"
									}
									break
								}
							}
							var c = l.firstUnit;
							while (c) {
								var g = record_getString_2(c, q);
								var m = d.firstUnit;
								while (m) {
									var e = record_getString_2(m, n);
									if (e == g) {
										var a = record_getString_2(m, v);
										_record_setValue_2(c, b, a);
										break
									}
									m = m.nextUnit
								}
								c = c.nextUnit
							}
						}
					}
				}
			}
		} else {
			if (!l.loadCompleted && l.type && l.type == "dropdown") {
				if (l.init && l.init == "true") {
				}
			}
		}
	}
}
function getFieldSelectNameValue(d, a) {
	var c = a.fieldName;
	var b = "";
	if (c.length > 4) {
		var b = "";
		var l = d.dataset;
		var e = c.length;
		var p = c.substring(0, (e - 4));
		var n = "";
		var s = a.viewField;
		var r = a.dropDown;
		var h = a.dropDownDataset;
		var f = getDatasetByID(h);
		var t = getDropDownByID(r);
		if (f) {
			if (t.fieldMap != "") {
				var k = t.fieldMap.split(";");
				for (var q = 0; q < k.length; q++) {
					var o = k[q].split("=");
					if (o[0] == p) {
						n = o[1];
						if (s == "") {
							s = n + "Name"
						}
						break
					}
				}
				if (d) {
					var i = record_getString_2(d, p);
					if (i == "") {
						return ""
					}
					var m = f.firstUnit;
					while (m) {
						var g = record_getString_2(m, n);
						if (g == i) {
							b = record_getString_2(m, s);
							index = l.fields["_index_" + p];
							d[index] = i;
							break
						}
						m = m.nextUnit
					}
					if (b == "") {
						b = i;
						index = l.fields["_index_" + p];
						d[index] = i
					}
				}
			}
		}
	} else {
	}
	return b
}
function getFieldRadioNameValue(b, g) {
	var h = g.fieldName;
	var a = "";
	if (h.length > 4) {
		var f = b.dataset;
		var e = h.length;
		var d = h.substring(0, (e - 4));
		var c = RadioRender.getRadio(g.radio);
		if (c) {
			a = c.getRadioNameValue(b.getValue(d))
		}
	}
	return a
}
function dataset_getRealRecordCounts() {
	var b = 0;
	var c = this;
	if (c.length == 0) {
		return b
	} else {
		var a = c.firstUnit;
		while (a) {
			if (a.recordState != "discard") {
				b++
			}
			a = a.nextUnit
		}
	}
	return b
}
function dataset_toJson(l) {
	var o = null;
	var q = null;
	if (l) {
		o = l.sumfieldstr;
		q = l.id
	}
	var g = this;
	if (g.masterDataset) {
		g.pageSize = g.length;
		g.pageCount = 1
	}
	var u = {};
	u.pageIndex = g.pageIndex;
	u.pageCount = g.pageCount;
	if (l && l.pageCache) {
		u.total = g.length
	} else {
		if(g.total){
			u.total = g.total
		}
		else{
			u.total = g.pageSize < g.length ? g.length : g.pageCount * g.pageSize
		}
		
	}
	u.rows = [];
	u.footer = [];
	var p = {};
	p.isfoot = true;
	var m = "," + o + ",";
	var k = g.getFirstRecord();
	var d = (g.pageIndex - 1) * g.pageSize;
	var c = d + g.pageSize;
	var r = -1;
	while (k) {
		var h = fireUserEvent(q + "_onFilterRecord", [ g, k ]);
		if (h) {
			k = k.getNextRecord();
			continue
		}
		if (l && l.pageCache) {
			r++;
			if (r < d) {
				k = k.getNextRecord();
				continue
			} else {
			}
			if (r >= c) {
				break
			}
		}
		var f = k._uuid || "_j" + new Date().getTime() + $.uuid++;
		k._uuid = f;
		var e = {};
		e._recordUUID = f;
		e.record = k;
		for (var t = 0; t < g.fields.fieldCount; t++) {
			var b = g.getField(t);
			var a = b.fieldName;
			var j = k.getJsonValue(a);
			e[a] = j;
			if (m.indexOf(a) > -1) {
				p[a] = (parseFloat(j) || 0) + (p[a] || 0)
			} else {
				p[a] = ""
			}
		}
		u.rows[u.rows.length] = e;
		k = k.getNextRecord()
	}
	u.footer[0] = p;
	return u
}
function initDefaultDataset(d) {
	if (d.getRealRecordCounts() == 0) {
		d.insertRecord("begin")
	}
	var b = d.fields.fieldCount;
	for (var a = 0; a < b; a++) {
		var c = d.getField(a);
		if (c.defaultValue && c.defaultValue != "" && d.getString(a) == "") {
			d.setValue(a, c.defaultValue)
		}
	}
}
function copyDataset(c, d) {
	var b = createDataset(c, "", "");
	b.flushData = dataset_flushData_new;
	var a = getDatasetByID(d);
	b.fields = a.fields;
	b.parameters = a.parameters;
	b.readOnly = true;
	b.cqId = a.cqId;
	b.pageSize = a.pageSize;
	b.databusId = a.databusId;
	b.pageIndex = 1;
	b.pageCount = 1;
	b.masterDataset = a.masterDataset;
	b.references = a.references;
	b.submitData = a.submitData;
	b.autoLoadPage = false;
	b.autoLoadDetail = true;
	b.downloadUrl = getDecodeStr("~2fextraservice~2fdownloaddata");
	b.insertOnEmpty = a.insertOnEmpty;
	b.tag = "";
	b.type = "result";
	b.sessionKey = "dd";
	b.init = a.init;
	b.pKey = a.pKey;
	initDataset(b);
	return b
}
function _initField(g, c, d, b, o, e, k, u, p, t, f, j, l, v, a, h, i, q, r, s,
		n, m) {
	field = g.addField(c, d);
	field.label = u;
	field.size = p;
	field.scale = t;
	field.readOnly = j;
	field.required = f;
	field.nullable = true;
	field.defaultValue = getDecodeStr("");
	field.updatable = true;
	field.valueProtected = false;
	field.visible = true;
	field.autoGenId = false;
	field.tableName = "";
	field.fieldName = c;
	field.editorType = "";
	field.multiple = (s == "true" ? true : false);
	field.editType = r;
	field.prefix = n;
	field.editable = m;
	field.mask = o;
	field.maskErrorMessage = e;
	field.toolTip = k;
	field.lobDownloadURL = getDecodeStr("");
	field.lobPopupURL = getDecodeStr("");
	field.radio = i;
	field.RadioDataset = q;
	field.tag = v;
	field.viewField = b;
	field.dropDown = a;
	field.dropDownDataset = h;
	field.currencyAlign = l
}
function _initDataset(d, n, i, f, a, k, e, j, c, b, m, h, g) {
	var l = d;
	l.flushData = dataset_flushData_new;
	l.readOnly = false;
	l.cqId = n;
	l.pageSize = i;
	l.databusId = f;
	l.pageIndex = 1;
	l.pageCount = 1;
	l.masterDataset = a;
	l.references = k;
	l.submitData = e;
	l.autoLoadPage = false;
	l.autoLoadDetail = true;
	l.downloadUrl = getDecodeStr("~2fextraservice~2fdownloaddata");
	l.insertOnEmpty = j;
	l.tag = "";
	l.type = h;
	l.pKey = g;
	l.sessionKey = c;
	converStr2DataSetParameter(b, l);
	l.setParameter("CQId", n, "string");
	l.setParameter("nextPage", l.pageIndex);
	l.setParameter("everyPage", l.pageSize);
	l.setParameter("_session_key", l.sessionKey);
	l.setParameter("databusId", l.databusId);
	l.init = m;
	l.initDocumentFlag = false
}
function dataset_flushData_new(a) {
	try {
		var f = this;
		var b = getElementEventName(f, "flushDataPre");
		if (isUserEventDefined(b)) {
			var c = fireUserEvent(getElementEventName(f, "flushDataPre"), [ f ]);
			if (typeof (result) == "boolean" && !result) {
				return
			}
		}
		_dataset_flushData_new(f, a);
		fireUserEvent(getElementEventName(f, "flushDataComplete"), [ f ])
	} catch (d) {
		processException(d)
	}
}
function _dataset_flushData_new(dataset, pageIndex) {
	pageIndex = pageIndex || 1;
	dataset.disableControls();
	var loadDetail = false;
	try {
		dataset.clearData();
		if (dataset.sessionKey) {
			var _url = _application_root + dataset.downloadUrl;
			var pageSize = dataset.pageSize;
			var _paramMap = new Object();
			_paramMap = converDateSetParameter2Map(dataset, _paramMap);
			_paramMap.nextPage = pageIndex;
			_paramMap.everyPage = pageSize;
			_paramMap._session_key = dataset.sessionKey;
			dwr.engine.setAsync(false);
			var result = new Object();
			CommonQueryResultProcess.processAsyncBean(_paramMap, function(
					resultBean) {
				result.fieldStr = resultBean.fieldString;
				result.recordStr = resultBean.recordString;
				result.recordOrigStr = resultBean.recordOrigString;
				result.pageCount = resultBean.pageCount;
				result.pageIndex = pageIndex;
				result.pageSize = pageSize;
				dataset.resCd = resultBean.resCd;
				dataset.total = resultBean.total;
				if (resultBean.resCd != "000000") {
					dataset.pageIndex = 1;
					dataset.pageCount = 0;
					var err = new Error(resultBean.resMsg);
					err.name = resultBean.resCd;
					throw err
				} else {
					if (result.recordStr) {
						appendFromDataString(dataset, result.fieldStr,
								result.recordStr, true)
					}
					dataset.pageIndex = result.pageIndex;
					dataset.pageCount = result.pageCount;
					converStr2DataSetParameter(resultBean.parameterString,
							dataset);
					var record = dataset.firstUnit;
					var i = 0;
					while (record) {
						i++;
						initRecord(record, dataset);
						if (i / pageSize < 1) {
							record.pageIndex = 1
						} else {
							record.pageIndex = calcPageCount(i, pageSize)
						}
						record = record.nextUnit
					}
					if (result.pageCount == 1) {
						dataset.pageCount = calcPageCount(i, pageSize)
					}
				}
				dataset.enableControls();
				fireUserEvent(getElementEventName(dataset, "flushDataPost"),
						[ dataset ]);
				dataset.loadDetail();
				if (_lastDataSetID == dataset.id) {
					_lastDataSetID = null;
					initDropDownValues();
					resetDataSetRecordState();
					if (dataset.pagelet) {
						dataset.pagelet = false;
						eval('fireUserEvent("' + dataset.pageid
								+ '_initCallGetter_post",0);')
					} else {
						fireUserEvent("initCallGetter_post", 0)
					}
				}
				loadDetail = true
			});
			delete _paramMap;
			dwr.engine.setAsync(true);
			return result
		}
	} catch (e) {
		processException(e)
	} finally {
		if (!loadDetail) {
			dataset.enableControls()
		}
	}
}
function _downloadData_new(h, c, b) {
	try {
		h.disableControls();
		h.clearData();
		if (h.sessionKey) {
			var d = _application_root + h.downloadUrl;
			var f = new Object();
			f = converDateSetParameter2Map(h, f);
			f.nextPage = b;
			f.everyPage = c;
			f._session_key = h.sessionKey;
			var a = new Object();
			dwr.engine.setAsync(false);
			CommonQueryResultProcess.processAsyncBean(f, function(i) {
				a.fieldStr = i.fieldString;
				a.recordStr = i.recordString;
				a.recordOrigStr = i.recordOrigString;
				a.pageCount = i.pageCount;
				a.pageIndex = b;
				a.pageSize = c;
				if (i.resCd != "000000") {
					var e = new Error(i.resMsg);
					e.name = i.resCd;
					throw e
				}
			});
			dwr.engine.setAsync(true);
			return a
		}
	} catch (g) {
		processException(g)
	} finally {
		h.disableControlCount = (h.disableControlCount > 0) ? h.disableControlCount - 1
				: 0
	}
}
function getResultData(c, b, a) {
	var d = "";
	dwr.engine.setAsync(false);
	useLoadingMessage("loading...");
	CommonQueryResultProcess.processAsyncBean(c._param_str, function(e) {
		d = e
	});
	dwr.engine.setAsync(true);
	return d
}
var _cur_event_button;
function set_cur_event_button(a) {
	if (a) {
		var b = event.srcElement.defaultOperation.toLowerCase();
		if ("submitform" == b || "syncsubmit" == b || "asysubmit" == b
				|| "asyncqrysubmitflush" == b || "asyncqrysubmitflush" == b) {
			_cur_event_button = event.srcElement;
			_cur_event_button.disabled = true
		}
	} else {
		if (_cur_event_button) {
			_cur_event_button.disabled = false;
			_cur_event_button = null
		}
	}
}
function _button_onclick_new(id) {
	try {
		var button = eval('$("#' + id + '")');
		button = button.get(0);
		var result = fireUserEvent(id + "_onClickCheck", [ button ]);
		if (typeof (result) == "boolean" && !result) {
			return false
		}
		if (button.defaultOperation) {
			switch (button.defaultOperation.toLowerCase()) {
			case "submitupdate":
				if (button.submitManager) {
					eval(button.submitManager + ".submit();")
				}
				break;
			case "refreshpage":
				window.open(window.location.href, "_self");
				break;
			case "submitform":
				_topmask();
				var dataset = getDatasetByID(button.componentDataset);
				var form = document.createElement("FORM");
				form.method = "post";
				if (button.url) {
					form.action = megerURL(_application_root,
							_transDataActionURL)
				} else {
					form.action = _application_root + "#"
				}
				form.style.visibility = "hidden";
				for (var i = 0; i < dataset.fields.fieldCount; i++) {
					form.insertAdjacentHTML("beforeEnd",
							'<input type="hidden" name="'
									+ dataset.getField(i).fieldName + '" >')
				}
				form.insertAdjacentHTML("beforeEnd",
						'<input type="hidden" name="_button_id" >');
				form.insertAdjacentHTML("beforeEnd",
						'<input type="hidden" name="CQId" >');
				document.body.appendChild(form);
				for (var i = 0; i < dataset.fields.fieldCount; i++) {
					form[dataset.getField(i).fieldName].value = dataset
							.getString(i)
				}
				form._button_id.value = button.id;
				form.CQId.value = dataset.cqId;
				form.submit();
				break;
			case "syncsubmit":
				_topmask();
				var dataset = getDatasetByID(button.componentDataset);
				var targetFrame = button.targetFrame == "" ? "_self"
						: button.targetFrame;
				var form = document.createElement("FORM");
				form.target = targetFrame;
				form.method = "post";
				if (button.url) {
					form.action = megerURL(_application_root, button.url)
				} else {
					form.action = _application_root + "#"
				}
				form.style.visibility = "hidden";
				for (var i = 0; i < dataset.fields.fieldCount; i++) {
					form.insertAdjacentHTML("beforeEnd",
							'<input type="hidden" name="'
									+ dataset.getField(i).fieldName + '" >')
				}
				document.body.appendChild(form);
				for (var i = 0; i < dataset.fields.fieldCount; i++) {
					form[dataset.getField(i).fieldName].value = dataset
							.getString(i)
				}
				form.submit();
				break;
			case "asysubmit":
				var bean = translateDataset2Bean(button);
				var checkAnswer = checkRequireBeforeSubmit(button);
				if (typeof (checkAnswer) == "object") {
					break
				}
				if (checkAnswer && $(".validatebox-invalid").size() == 0) {
					var updateClass = button.updateclass;
					var targetFrame = button.targetFrame == "" ? "_self"
							: button.targetFrame;
					CommonQueryUpdateProcess
							.savaOrUpdate(
									updateClass,
									bean,
									function(result) {
										var resultBean = result;
										if (resultBean.resCd == "000000") {
											try {
												var buttonReturnParam = resultBean.paramMap;
												button.returnParam = buttonReturnParam;
												var _restlt = true;
												_restlt = fireUserEvent(
														getElementEventName(
																button,
																"postSubmit"),
														[ button ]);
												var url = button.url;
												var path;
												if (url != "" && url != "#") {
													path = megerURL(
															_application_root,
															url)
												} else {
													if (url == "#") {
														path = "#"
													} else {
														path = _successURL
													}
												}
												if (path != "#") {
													if (targetFrame == "_self") {
														window.location.href = path
													} else {
														window.open(path,
																targetFrame)
													}
												}
											} catch (e) {
											} finally {
												_resetRecordState2(button)
											}
										} else {
											if (resultBean.resCd == "111111") {
												var buttonReturnParam = resultBean.paramMap;
												var dataset = getDatasetByID(button.componentDataset);
												for ( var property in buttonReturnParam) {
													if (!buttonReturnParam
															.hasOwnProperty(property)) {
														continue
													}
													var fieldName = property;
													var unit = dataset.editors.firstUnit;
													while (unit && unit.data) {
														var element = unit.data;
														if (!$(element)
																.parent()
																.is(":hidden")
																&& $(element)
																		.attr(
																				"datafield") == fieldName
																&& $(element)
																		.attr(
																				"extra") != "fieldlabel") {
															var opts = $
																	.data(
																			element,
																			"validatebox").options;
															opts.msg = eval("buttonReturnParam."
																	+ fieldName);
															opts.isBackground = true;
															backgroundValid(element);
															opts.isBackground = false
														}
														unit = unit.nextUnit
													}
												}
												return
											} else {
												var err = new Error(
														result.resMsg);
												err.name = result.resCd;
												throw err
											}
										}
									})
				} else {
					errAlert(constErrValide);
					setTimeout(function() {
						top.easyMsg.close()
					}, 5000)
				}
				break;
			case "asyncqrysubmit":
				_topmask();
				var dataset = getDatasetByID(button.componentDataset);
				if (!checkBeforeQuerySubmit(button)
						|| $(".validatebox-invalid").size() > 0) {
					return
				}
				var _paramMap = new Object();
				_paramMap = converDateSet2Map(dataset);
				_paramMap = converDateSetParameter2Map(dataset, _paramMap);
				CommonQueryResultProcess.processAsyncBean(_paramMap, function(
						result) {
					var resultBean = result;
					resultBean.url = _application_root + button.url;
					if (resultBean.resCd != "000000") {
						var err = new Error(resultBean.resMsg);
						err.name = resultBean.resCd;
						throw err
					} else {
						if (resultBean.pageCount == 0) {
							wrnAlert(constNoFoundRecode);
							return
						}
						converStr2DataSetParameter(resultBean.parameterString,
								dataset);
						var form = document.createElement("FORM");
						form.method = "post";
						if (button.url) {
							form.action = megerURL(_application_root,
									button.url)
						} else {
							form.action = _application_root + "#"
						}
						form.style.visibility = "hidden";
						for (var i = 0; i < dataset.fields.fieldCount; i++) {
							form.insertAdjacentHTML("beforeEnd",
									'<input type="hidden" name="'
											+ dataset.getField(i).fieldName
											+ '"  value="'
											+ dataset.getString(i) + '">')
						}
						var pId, pVal;
						var paramStr = converDateSetParameter2Str(dataset);
						form.insertAdjacentHTML("beforeEnd",
								'<input type="hidden" name="_paramStr_" value="'
										+ paramStr + '">');
						form.insertAdjacentHTML("beforeEnd",
								'<input type="hidden" name="CQId" value="'
										+ resultBean.cqId + '">');
						form.insertAdjacentHTML("beforeEnd",
								'<input type="hidden" name="fieldString" value="'
										+ resultBean.fieldString + '">');
						form.insertAdjacentHTML("beforeEnd",
								'<input type="hidden" name="recordString" value="'
										+ resultBean.recordString + '">');
						form.insertAdjacentHTML("beforeEnd",
								'<input type="hidden" name="recordOrigString" value="'
										+ resultBean.recordOrigString + '">');
						form.insertAdjacentHTML("beforeEnd",
								'<input type="hidden" name="pageCount" value="'
										+ resultBean.pageCount + '">');
						form.insertAdjacentHTML("beforeEnd",
								'<input type="hidden" name="pageIndex" value="'
										+ resultBean.pageIndex + '">');
						form.insertAdjacentHTML("beforeEnd",
								'<input type="hidden" name="pageSize" value="'
										+ resultBean.pageSize + '">');
						document.body.appendChild(form);
						form.submit()
					}
				});
				break;
			case "addrecord":
				var dataset = getDatasetByID(button.componentDataset);
				dataset.insertRecord("end");
				fireUserEvent(getElementEventName(button, "onClick"),
						[ button ]);
				break;
			case "delrecord":
				var dataset = getDatasetByID(button.componentDataset);
				var count2 = dataset.getRealRecordCounts();
				if (count2 != 0) {
					dataset.deleteRecord()
				} else {
				}
				break;
			case "asyncqrysubmitflush":
				var dataset = getDatasetByID(button.componentDataset);
				if (!checkBeforeQuerySubmit(button)) {
					return
				}
				var resultDataset = getDatasetByID(button.resultDataset);
				copyDateSetParameter(dataset, resultDataset);
				for (var i = 0; i < dataset.fields.fieldCount; i++) {
					resultDataset.setParameter(dataset.getField(i).fieldName,
							dataset.getString(i))
				}
				resultDataset.flushData(1);
				break;
			case "href":
				if (button.url) {
					_topmask();
					var targetFrame = button.targetFrame == "" ? "_self"
							: button.targetFrame;
					var path = megerURL(_application_root, button.url);
					if (targetFrame == "_self") {
						window.location.href = path
					} else {
						window.open(path, targetFrame)
					}
				}
				break;
			case "modesubmit":
				var dataset = getDatasetByID(button.componentDataset);
				var targetFrame = button.targetFrame == "" ? "_self"
						: button.targetFrame;
				for (var i = 0; i < dataset.fields.fieldCount; i++) {
				}
				window
						.showModalDialog(
								megerURL(_application_root, button.url), "",
								"dialogHeight:600px; dialogWidth:600px; status:no; help:no; scroll:auto");
				break;
			case "delrecordasysubmit":
				var dataset = getDatasetByID(button.componentDataset);
				var count2 = dataset.getRealRecordCounts();
				if (count2 != 0) {
					var bean = translateDataset2Bean(button);
					var needSubmit = checkDelRecordSubmitNeeded(button);
					var confirmSubmit = true;
					if (needSubmit) {
						confirmSubmit = checkBeforeDelRecordSubmit(button)
					} else {
						dataset.deleteRecord();
						break
					}
					if (confirmSubmit) {
						if (needSubmit) {
							var updateClass = button.updateclass;
							var targetFrame = button.targetFrame == "" ? "_self"
									: button.targetFrame;
							CommonQueryUpdateProcess
									.savaOrUpdate(
											updateClass,
											bean,
											function(result) {
												var resultBean = result;
												if (resultBean.resCd == "000000") {
													try {
														var editDataset = getDatasetByID(button.componentDataset);
														editDataset
																.deleteRecord();
														var buttonReturnParam = resultBean.paramMap;
														button.returnParam = buttonReturnParam;
														var _restlt = true;
														_restlt = fireUserEvent(
																getElementEventName(
																		button,
																		"postSubmit"),
																[ button ]);
														var url = button.url;
														var path;
														if (url != ""
																&& url != "#") {
															path = megerURL(
																	_application_root,
																	url)
														} else {
															if (url == "#") {
																path = "#"
															} else {
																path = _successURL
															}
														}
														if (path != "#") {
															if (targetFrame == "_self") {
																window.location.href = path
															} else {
																window
																		.open(
																				path,
																				targetFrame)
															}
														}
													} catch (e) {
													} finally {
														_resetRecordState2(button)
													}
												} else {
													var err = new Error(
															result.resMsg);
													err.name = result.resCd;
													throw err
												}
											})
						}
					}
				}
				break
			}
		} else {
			fireUserEvent(getElementEventName(button, "onClick"), [ button ])
		}
	} catch (e) {
		processException(e)
	} finally {
	}
}
function backgroundValid(b) {
	var a = $(b);
	switch (a.attr("editType")) {
	case "textarea":
	case "numberbox":
	case "validatebox":
		a.validatebox("isValid");
		break;
	case "month":
	case "dropDownSelect":
		a.combo("isValid");
		break;
	case "datetimebox":
	case "datebox":
		a.datebox("isValid");
		break;
	case "hidden":
	case "radio":
	case "checkbox":
		break
	}
}
function checkRequireBeforeSubmit(a) {
	var f = fireUserEvent(getElementEventName(a, "needCheck"), [ a ]);
	if (typeof (f) == "boolean" && !f) {
		return true
	}
	var q = isNaN(a.submitUpdateTotalListSize) ? 0
			: a.submitUpdateTotalListSize;
	var t = isNaN(a.noneListSize) ? 0 : a.noneListSize;
	var c = isNaN(a.deleteSize) ? 0 : a.deleteSize;
	if (q == 0 && t == 0 && c == 0) {
		alert(constCheckModify);
		return new Object()
	} else {
		if (q != 0) {
			var h = new Array();
			if (a.submitDataset) {
				datasetStr = a.submitDataset.split(";");
				for (var o = 0; o < datasetStr.length; o++) {
					var b = getDatasetByID(datasetStr[o]);
					b.type == "result";
					h[h.length] = b
				}
			} else {
				h = getDatasets()
			}
			var s = "";
			var l = "";
			var n = false;
			for (var m = 0; m < h.length; m++) {
				var d = h[m];
				if (d.record == null) {
					continue
				}
				if (d.type != "interface" && d.type != "dropdown"
						&& d.id != "_tmp_dataset_date" && !d.readOnly) {
					var g = _FieldValid(d);
					if (typeof (g) == "string") {
						errAlert(constErrFieldValueValide.replace("%s", d
								.getField(g).label));
						return false
					}
					var v = g.fieldArray;
					if (!n) {
						n = g.isValid
					}
					var u = v.length;
					for (var p = 0; p < u; p++) {
						try {
							if (v[p].tag != "selectName"
									&& v[p].tag != "radioName"
									&& v[p].label != ""
									&& d.getValue(v[p].fieldName) === "") {
								if (!isTrue(v[p].readOnly)
										&& isTrue(v[p].required)) {
									s += constErrFieldValueRequired.replace(
											"%s", v[p].label)
											+ "\n"
								}
							}
						} catch (r) {
						}
					}
				}
			}
			if (s != "") {
				s = s.replace(/\<br\>/gi, "");
				errAlert(s);
				return false
			}
			if (n) {
				return false
			} else {
				return true
			}
		}
	}
	return true
}
function checkBeforeQuerySubmit(d) {
	var j = fireUserEvent(getElementEventName(d, "needCheck"), [ d ]);
	if (typeof (j) == "boolean" && !j) {
		return true
	}
	var a = getDatasetByID(d.componentDataset);
	if (a.record == null) {
		return true
	}
	var c = "";
	var h = "";
	var e = _FieldValid(a);
	if (typeof (e) == "string") {
		errAlert(constErrFieldValueValide.replace("%s", a.getField(e).label));
		return false
	}
	var g = e.fieldArray;
	var f = g.length;
	for (var b = 0; b < f; b++) {
		if (g[b].tag && (g[b].tag == "selectName" || g[b].tag == "radioName")) {
			continue
		}
		if (!isTrue(g[b].readOnly) && isTrue(g[b].required)
				&& a.getValue(g[b].fieldName) == ""
				&& a.getValue(g[b].fieldName) != 0) {
			c += constErrFieldValueRequired.replace("%s", g[b].label) + "\n"
		}
	}
	if (c.length != 0) {
		c = c.replace(/\<br\>/gi, "");
		throw c
	}
	if (e.isValid) {
		return false
	} else {
		return true
	}
}
function validateQuery(e, d) {
	$(document).unbind(".validateTip").bind("mousedown.validateTip",
			function(g) {
				$(".validatebox-tip").hide();
				$(document).unbind(".validateTip")
			});
	var b = $(d);
	switch (b.attr("editType")) {
	case "password":
	case "textarea":
	case "numberbox":
	case "validatebox":
		if (!b.validatebox("isValid")) {
			e = true
		}
		break;
	case "month":
	case "dropDownSelect":
		if (!b.combo("isValid")) {
			e = true
		}
		break;
	case "datetimebox":
	case "datebox":
		if (!b.datebox("isValid")) {
			e = true
		}
		break;
	case "hidden":
		if (!b.validatebox("isValid")) {
			e = true;
			alert("隐藏字段- " + b.attr("dataField") + " -为空，请输入值！")
		}
		break;
	case "radio":
		if (b.attr("required")) {
			var f = $("input", b);
			var a = false;
			for (var c = 0; c < f.length; c++) {
				if (f.eq(c)[0].checked) {
					a = true
				}
			}
			if (!a) {
				e = true;
				alert(constRadio.replace("%a", b.attr("dataField")))
			}
		}
		break;
	case "checkbox":
		if (b.attr("required")) {
			if (!b[0].checked) {
				e = true;
				alert(constRadio.replace("%a", b.attr("dataField")))
			}
		}
		break
	}
	return e
}
function translateDataset2List(d) {
	var f = getDatasetByID(d);
	var c = new Array();
	var a = f.firstUnit;
	var b = 0;
	while (a) {
		if (a.recordState != "none" && a.recordState != "discard") {
			var e = translateRecord2Map(f, a);
			c[b] = e;
			b++
		}
		_resetRecordState(a);
		a = a.nextUnit
	}
	return c
}
function translateRecord2Map(f, a) {
	var d = {};
	var c;
	var e;
	for (var b = 0; b < f.fields.fieldCount; b++) {
		c = f.getField(b).fieldName;
		e = a.getString(b);
		d[c] = e
	}
	if (a.recordState == "new") {
		d.recordState = "insert"
	} else {
		d.recordState = a.recordState
	}
	return d
}
function resetDataSetRecordState() {
	var c = getDatasets();
	for (var b = 0; b < c.length; b++) {
		var d = c[b];
		if (!d.loadCompleted) {
			d.loadCompleted = true;
			if (d.type && d.type == "result") {
				var a = d.firstUnit;
				while (a) {
					a.recordState = "none";
					a = a.nextUnit
				}
			}
		}
	}
}
var _lastDataSetID = null;
function initCallGetter() {
	var b = getDatasets();
	useLoadingImage(_theme_root + "/loading.gif");
	fireUserEvent("initCallGetter_pre", 0);
	dwr.engine.beginBatch();
	dwr.engine.setOrdered(true);
	for (var a = 0; a < b.length; a++) {
		var c = b[a];
		if (c.type && c.type == "dropdown") {
			if (c.init && c.init == "true") {
			} else {
			}
		} else {
		}
	}
	_lastDataSetID = null;
	for (var a = 0; a < b.length; a++) {
		var c = b[a];
		if (c.type && c.type == "result") {
			if (c.init && c.init == "true") {
				_lastDataSetID = c.id
			}
		}
	}
	for (var a = 0; a < b.length; a++) {
		var c = b[a];
		fireUserEvent(getElementEventName(c, "requestInit"), []);
		if (c.type && c.type == "result") {
			if (c.init && c.init == "true") {
				c.flushData(1)
			}
		} else {
			if (c.type && c.type == "interface") {
				c.refreshControls()
			}
		}
	}
	if (!_lastDataSetID) {
		initDropDownValues();
		resetDataSetRecordState();
		fireUserEvent("initCallGetter_post", 0)
	}
	dwr.engine.setOrdered(false);
	dwr.engine.endBatch()
}
function initLetCallGetter(id) {
	var datasetAry = getDatasets();
	useLoadingImage(_theme_root + "/loading.gif");
	fireUserEvent(id + "_initCallGetter_pre", 0);
	dwr.engine.beginBatch();
	dwr.engine.setOrdered(true);
	for (var i = 0; i < datasetAry.length; i++) {
		var dataset = datasetAry[i];
		if (dataset.type && dataset.type == "dropdown") {
			if (!dataset.loadCompleted && dataset.init
					&& dataset.init == "true") {
			} else {
			}
		} else {
		}
	}
	_lastDataSetID = null;
	for (var i = 0; i < datasetAry.length; i++) {
		var dataset = datasetAry[i];
		if (dataset.type && dataset.type == "result") {
			if (!dataset.loadCompleted && dataset.init
					&& dataset.init == "true") {
				_lastDataSetID = dataset.id
			}
		} else {
			if (!dataset.loadCompleted && dataset.type
					&& dataset.type == "interface") {
				dataset.refreshControls()
			}
		}
	}
	for (var i = 0; i < datasetAry.length; i++) {
		var dataset = datasetAry[i];
		fireUserEvent(getElementEventName(dataset, "requestInit"), []);
		if (dataset.type && dataset.type == "result") {
			if (!dataset.loadCompleted && dataset.init
					&& dataset.init == "true") {
				dataset.pagelet = true;
				dataset.pageid = id;
				dataset.flushData(1)
			}
		} else {
		}
	}
	if (!_lastDataSetID) {
		initDropDownValues();
		resetDataSetRecordState();
		eval('fireUserEvent("' + id + '_initCallGetter_post",0);')
	}
	dwr.engine.setOrdered(false);
	dwr.engine.endBatch()
}
function flushDataset(a) {
	a.disableControls();
	a.clearData();
	var b = converDateSetParameter2Map(a);
	CommonQueryResultProcess.processAsyncBean(b, function(c) {
		var d = c;
		if (d.resCd != "000000") {
			errAlert(d.resMsg)
		} else {
		}
		appendFromDataString(a, c.fieldString, c.recordString, true);
		a.pageIndex = c.pageIndex;
		a.pageCount = c.pageCount;
		converStr2DataSetParameter(c.parameterString, a);
		a.enableControls();
		a.loadDetail()
	})
}
function translateDataset2Bean(a) {
	var h = 0;
	var m = 0;
	var y = 0;
	var p = new Object();
	var b = new Object();
	var s = new Array();
	var w = "";
	var i = getDatasetByID(a.componentDataset);
	var q = a.funcId;
	var o = i.cqId;
	var l = a.id;
	if (a.submitDataset) {
		datasetStr = a.submitDataset.split(";");
		for (var u = 0; u < datasetStr.length; u++) {
			var g = getDatasetByID(datasetStr[u]);
			g.type = "result";
			s[s.length] = g
		}
	} else {
		s = getDatasets()
	}
	for (var t = 0; t < s.length; t++) {
		var n = s[t];
		var v = new Array();
		if (n.type && n.type == "result") {
			var e = n.firstUnit;
			while (e) {
				if (n.submitData == "allchange") {
					if (e.recordState != "none" && e.recordState != "discard") {
						var x = translateRecord2Map(n, e);
						v[v.length] = x;
						if (e.recordState != "delete") {
							h++
						}
						if (e.recordState == "delete") {
							m++
						}
					}
				} else {
					if (n.submitData == "current") {
						if (n.record == e) {
							var x = translateRecord2Map(n, e);
							v[v.length] = x;
							h++
						}
					} else {
						if (n.submitData == "selected") {
							if (e.getValue("select")) {
								var x = translateRecord2Map(n, e);
								v[v.length] = x;
								h++
							}
						} else {
							if (n.submitData == "all") {
								if (e.recordState != "discard") {
									var x = translateRecord2Map(n, e);
									v[v.length] = x;
									if (e.recordState != "none") {
										h++
									} else {
										y++
									}
								}
							} else {
							}
						}
					}
				}
				e = e.nextUnit
			}
			var c = new Object();
			c = converDateSetParameter2Map_2(s[t]);
			var f = n.id;
			if (w == "") {
				w = n.databusId
			}
			f = n.cqId;
			var d = {
				id : f,
				paramMap : c,
				totalList : v,
				recodeIndex : 0
			};
			p[f] = d
		}
	}
	b.databusId = w;
	var r = {
		updCqId : o,
		updateResult : p,
		paramMap : b,
		updBtnId : l,
		funcId : q
	};
	a.submitUpdateTotalListSize = h;
	a.noneListSize = y;
	a.deleteSize = m;
	return r
}
function _resetRecordState2(f) {
	try {
		if (f.submitDataset) {
			datasetStr = f.submitDataset.split(";");
			for (var d = 0; d < datasetStr.length; d++) {
				var b = getDatasetByID(datasetStr[d]);
				b.type == "result";
				datasetAry[datasetAry.length] = b
			}
		} else {
			datasetAry = getDatasets()
		}
		for (var c = 0; c < datasetAry.length; c++) {
			var h = datasetAry[c];
			if (h.type && h.type == "result") {
				try {
					var a = h.firstUnit;
					while (a) {
						_resetRecordState(a);
						a = a.nextUnit
					}
				} catch (g) {
				} finally {
					dataset_setState(h, "none");
					h.modified = false
				}
			}
		}
	} catch (g) {
	}
}
function converDateSetParameter2Map_2(d) {
	var c, e;
	var a = new Object();
	for (var b = 0; b < d.parameters.length; b++) {
		c = d.parameters[b].name;
		e = d.parameters[b].value;
		if (e != null) {
			a[c] = e
		}
	}
	a._dataset_id = d.id;
	return a
}
function refreshProgress() {
	dwr.engine.setPreHook(function() {
	});
	dwr.engine.setPostHook(function() {
	});
	UploadMonitor.getUploadInfo(updateProgress)
}
function updateProgress(c) {
	if (c.inProgress) {
		fireUserEvent("uploadFileProgress", 0);
		var b = c.fileIndex;
		var a = Math.ceil((c.bytesRead / c.totalSize) * 100);
		document.getElementById("progressBarText").innerHTML = "upload in progress: "
				+ a + "%";
		document.getElementById("progressBarBoxContent").style.width = parseInt(a * 3.5)
				+ "px";
		window.setTimeout("refreshProgress()", 1000)
	} else {
		fireUserEvent("uploadFileComplete", 0)
	}
	return true
}
function startProgress() {
	document.getElementById("progressBar").style.display = "block";
	document.getElementById("progressBarText").innerHTML = "upload in progress: 0%";
	window.setTimeout("refreshProgress()", 1500);
	return true
}
function loanPageLet(url, paramMap, elementId) {
	funPreHook(_theme_root + "/loading.gif");
	var v_div1 = document.getElementById(elementId);
	uninitLet(v_div1);
	v_div1.innerHTML = "";
	createXMLHttpRequest();
	var queryString = createQueryString();
	var url = _application_root + url + "?_mpf_=false" + queryString;
	xmlHttp.open("POST", url, true);
	xmlHttp.onreadystatechange = handleStateChange;
	xmlHttp.setRequestHeader("Content-Type",
			"application/x-www-form-urlencoded");
	xmlHttp.send(queryString);
	function handleStateChange() {
		if (xmlHttp.readyState == 4) {
			if (xmlHttp.status == 200) {
				parseResults()
			}
		}
	}
	function parseResults() {
		var v_div1 = document.getElementById(elementId);
		v_div1.innerHTML = xmlHttp.responseText;
		$.parser.parse($(v_div1));
		eval("_user_events_" + elementId + " = _user_events.me();");
		runScript(v_div1);
		initDocumentLet(v_div1);
		funPostHook()
	}
	function runScript(parent) {
		var v_div1 = parent;
		var arg = v_div1.getElementsByTagName("SCRIPT");
		for (var j = 0; j < arg.length; j++) {
			CQSPACE.Eval(arg[j].innerHTML)
		}
	}
	function createXMLHttpRequest() {
		if (window.ActiveXObject) {
			xmlHttp = new ActiveXObject("Microsoft.XMLHTTP")
		} else {
			if (window.XMLHttpRequest) {
				xmlHttp = new XMLHttpRequest()
			}
		}
	}
	function createQueryString() {
		var pId, pVal;
		var queryString = "";
		var keyArg = paramMap.keys();
		for (var i = 0; i < keyArg.length; i++) {
			pId = keyArg[i];
			pVal = paramMap.get(pId);
			queryString += "&" + pId + "=" + pVal
		}
		return queryString
	}
}
function unloadPageLet(a) {
	funPreHook(_theme_root + "/loading.gif");
	var b = document.getElementById(a);
	uninitLet(b);
	b.innerHTML = "";
	funPostHook()
}
var CQSPACE = {};
CQSPACE.Eval = function(code) {
	if (null == code || "" == code) {
		return
	}
	if (!!(window.attachEvent && !window.opera)) {
		execScript(code)
	} else {
		window.eval(code)
	}
};
var win = {
	target : {},
	close : function() {
		this.target.window("close")
	}
};
function loadPageWindows(id, title, url, paramMap, zone) {
	if (!$("#" + id)[0]) {
		$(document.body).append(
				"<div id='" + id + "' title='" + title + "'><div id='" + id
						+ "_" + zone + "'/></div>")
	}
	$('<input type="text" style="width:0;height:0;" name="_alertFocusCtr"/>')
			.appendTo(document.body).focus().remove();
	var _win = $("#" + id).window(
			{
				id : id,
				width : 600,
				minimizable : false,
				maximizable : false,
				height : 400,
				modal : true,
				onBeforeClose : function() {
					var panel = $.data(this, "panel").panel;
					var p = panel.parent();
					p.removeClass("panel-noscroll");
					if (p[0].tagName == "BODY") {
						$("html").removeClass("panel-fit")
					}
					var eventName = id + "_onCloseCheck";
					if (isUserEventDefined(eventName)) {
						var event_result = fireUserEvent(eventName, [ $("#"
								+ id)[0] ]);
						if (typeof (event_result) == "boolean") {
							if (event_result != true) {
								return false
							}
						}
					}
					return true
				},
				onClose : function() {
					if ($("#" + id + "_" + zone)[0]) {
						eval("_user_events = _user_events_" + id + "_" + zone
								+ "||_user_events;");
						uninitLet($("#" + id + "_" + zone)[0]);
						$("#" + id + "_" + zone)[0].innerHTML = ""
					}
					$("div.validatebox-tip").each(function(i) {
						$(this).hide()
					})
				}
			});
	_win.addClass("ie6scrollfixed");
	_win.window("maximize");
	loanPageLet(url, paramMap, id + "_" + zone);
	win.target = _win
}
function unloadPageWindows(a) {
	$("#" + a).window("close")
}
function createWindows(f, e, d, b, a) {
	var c = dhxWins.createWindow(f, e, d, b, a);
	c.setModal(true);
	c.keepInViewport(true);
	c.clearIcon();
	c.denyMove();
	c.button("help").show();
	c.button("stick").show();
	c.button("minmax1").hide();
	c.button("minmax2").hide();
	return c
}
function _printButton_onclick() {
	showLoadingImage(_theme_root + "/loading.gif", true);
	var c = event.srcElement;
	var d = c.fieldStr;
	var e = c.componentDataset;
	var b = c.headTitle;
	var a = "_" + e + "_print";
	_dataset_print = copyDataset("_" + e + "_print", e);
	_dataset_print.pageIndex = 1;
	_dataset_print.pageSize = 10000;
	_dataset_print.setReadOnly(true);
	_dataset_print.flushData(1);
	printDatasetASExcel(_dataset_print, d, b);
	_dataset_print.clearData();
	delete _dataset_print;
	showLoadingImage(_theme_root + "/loading.gif", false)
}
function checkDelRecordSubmitNeeded(a) {
	var b = getDatasetByID(a.componentDataset);
	if (b.record.recordState == "new" || b.record.recordState == "insert") {
		return false
	}
	return true
}
function checkBeforeDelRecordSubmit(c) {
	var d = getDatasetByID(c.componentDataset);
	var a = isNaN(c.submitUpdateTotalListSize) ? 0
			: c.submitUpdateTotalListSize;
	var b = isNaN(c.deleteSize) ? 0 : c.deleteSize;
	if (a == 1
			&& (d.record.recordState == "modify"
					|| d.record.recordState == "new" || d.record.recordState == "insert")) {
		return true
	} else {
		if (a != 0 || b != 0) {
			return confirm(constDatasetConfirmSubmitModifiedRecordsSameTime)
		}
	}
	return true
}
function _printapplet_clearUrlList() {
	var a = document.getElementById("PrintApplet");
	a.clearUrlList()
}
function _printapplet_addReportUrl(c, d, b) {
	var e = document.getElementById("PrintApplet");
	var a = _application_root + "/PrintServlet?";
	if (b == null) {
		e.addReportUrl(a + "report_id=" + c + "&" + d)
	} else {
		e.addReportUrl(a + "report_id=" + c + "&" + d, a + "report_id=" + c
				+ "&" + b)
	}
}
function _printapplet_showViewForm() {
	var a = document.getElementById("PrintApplet");
	a.showViewForm()
}
function openSubWin(d, k, c, e, m, a, l, b, g) {
	var i = $(document.body);
	var j = $("#subwin_" + d);
	var f = _application_root + c;
	if (c && c.startWith("http")) {
		f = c
	}
	if (j[0]) {
		j.window("open")
	} else {
		j = $("<div/>").attr("id", "subwin_" + d).attr("title", k || "&nbsp;")
				.appendTo(i);
		if (f.indexOf("?") > -1) {
			f += "&_dd_=" + new Date().getTime()
		} else {
			f += "?_dd_=" + new Date().getTime()
		}
		var h = $(
				'<iframe scrolling="auto" frameborder="0" src="' + f
						+ '" style="width:100%;height:100%;"></iframe>')
				.appendTo(j);
		j.window({
			width : e || 600,
			minimizable : false,
			maximizable : true,
			collapsible : false,
			cache : a == undefined ? false : a,
			maximized : g == undefined ? false : g,
			height : m || 400,
			modal : false,
			ifr : h,
			onBeforeClose : function() {
				var n = $.data(this, "panel").panel;
				var r = n.parent();
				r.removeClass("panel-noscroll");
				if (r[0].tagName == "BODY") {
					$("html").removeClass("panel-fit")
				}
				if (b) {
					b("close");
					return true
				}
				var o = d + "_onCloseCheck";
				if (isUserEventDefined(o)) {
					var q = fireUserEvent(o, [ j[0] ]);
					if (typeof (q) == "boolean") {
						return q
					}
				}
				return true
			},
			onClose : function() {
				var n = j.window("options");
				if (!n.cache) {
					n.ifr[0].contentWindow.document.write("");
					n.ifr.attr("src", "about:blank");
					n.ifr = null;
					j.window("destroy")
				}
				$("div.validatebox-tip").each(function(o) {
					$(this).hide()
				})
			}
		})
	}
	this.doHandler = function(n) {
		try {
			b(n)
		} catch (o) {
			errAlert(o.message)
		}
	};
	this.closetab = function() {
		j.window("close")
	};
	return this
}
function moveTreegridRecord(r, l, c, p) {
	var g = getElementDataset(r);
	if (!g.record) {
		return
	}
	var b = c || g.record.getValue("_id");
	if (!b) {
		return
	}
	var a = $(r).treegrid("options");
	var q = $(r).datagrid("getPanel").find("div.datagrid-body");
	var o = q.find("tr[node-id='" + b + "']");
	var h = p;
	var f = "insert";
	var d = {};
	switch (l) {
	case "up":
		if (!h) {
			var j = o.prev();
			while (j.size() > 0 && !j.hasClass("datagrid-row")) {
				j = j.prev()
			}
			h = j.attr("node-id")
		}
		f = "insert";
		d = {
			before : h
		};
		break;
	case "down":
		if (!h) {
			var j = o.next();
			while (j.size() > 0 && !j.hasClass("datagrid-row")) {
				j = j.next()
			}
			h = j.attr("node-id")
		}
		f = "insert";
		d = {
			after : h
		};
		break;
	default:
		break
	}
	if (h) {
		var n = $(r).treegrid("pop", b);
		var i = a.loadFilter;
		a.loadFilter = function(e, s) {
			return e
		};
		$(r).treegrid(f, $.extend(d, {
			data : n
		}));
		var k = $(r).attr("id") + "_onMove";
		if (isUserEventDefined(k)) {
			try {
				fireUserEvent(k, [ b, h, l ])
			} catch (m) {
			}
		}
		var o = q.find("tr[node-id='" + n[a.idField] + "']");
		o.addClass("datagrid-row-selected");
		a.loadFilter = i
	}
}
function fieldChangeToLabel(b) {
	var a = b ? $("#" + b) : $("body");
	$("span.combo", a)
			.each(
					function() {
						$(this)
								.after(
										$("<label/>")
												.html(
														$(this)
																.find(
																		"input[type=text]:visible")
																.val()));
						$(this).hide()
					});
	$(":checkbox,:radio", a).each(function() {
		$(this).attr("disabled", "disabled")
	});
	$("input:visible:not(:checkbox,:radio)", a).each(function() {
		$(this).after($("<label/>").html($(this).val()));
		$(this).hide()
	});
	$("textarea:visible", a).each(function() {
		$(this).after($("<label/>").html($(this).val()));
		$(this).hide()
	})
};