package com.huateng.commquery.result;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.huateng.common.Code;
import com.huateng.exception.AppException;

public class Result {
    private String _$8 = "";
    private Page _$7;
    private List<?> _$6;
    private List<RowData> _$5 = new ArrayList();
    private Map<String, String> _$4 = new HashMap();
    private String _$3 = "";
    private String _$2 = "";
    private String _$1 = "";
    private int total;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<RowData> getData() {
        return _$5;
    }

    public void setData(List<RowData> paramList) {
        _$5 = paramList;
    }

    public void addRow(RowData paramRowData) {
        _$5.add(paramRowData);
    }

    public RowData getRow(int paramInt) throws AppException {
        RowData localRowData = (RowData) _$5.get(paramInt);
        if (localRowData == null) {
            throw new AppException("SY", "CQ66", "row number " + paramInt + " no exist!");
        }
        return localRowData;
    }

    public String getOrigData(int paramInt, String paramString) throws AppException {
        RowData localRowData = getRow(paramInt);
        return localRowData.getField(paramString).getOrig();
    }

    public String getOprData(int paramInt, String paramString) throws AppException {
        RowData localRowData = getRow(paramInt);
        return localRowData.getField(paramString).getOpr();
    }

    public Result() {
    }

    public Result(Page paramPage, List<Object> paramList) {
        this();
        _$7 = paramPage;
        _$6 = paramList;
    }

    public List<?> getContent() {
        return _$6;
    }

    public Page getPage() {
        return _$7;
    }

    public void setContent(List<?> paramList) {
        _$6 = paramList;
    }

    public void setPage(Page paramPage) {
        _$7 = paramPage;
    }

    public String toString() {
        return getOprString();
    }

    public String getOprString() {
        StringBuffer localStringBuffer = new StringBuffer();
        if (_$5 != null) {
            Iterator localIterator = _$5.iterator();
            RowData localRowData = null;
            while (localIterator.hasNext()) {
                localRowData = (RowData) localIterator.next();
                if (localStringBuffer.length() == 0) {
                    localStringBuffer.append(localRowData.getOprString());
                } else {
                    localStringBuffer.append(";" + localRowData.getOprString());
                }
            }
            return localStringBuffer.toString();
        }
        return super.toString();
    }

    public String getOrigString() {
        StringBuffer localStringBuffer = new StringBuffer();
        if (_$5 != null) {
            Iterator localIterator = _$5.iterator();
            RowData localRowData = null;
            while (localIterator.hasNext()) {
                localRowData = (RowData) localIterator.next();
                if (localStringBuffer.length() == 0) {
                    localStringBuffer.append(localRowData.getOrigString());
                } else {
                    localStringBuffer.append(";" + localRowData.getOrigString());
                }
            }
            return localStringBuffer.toString();
        }
        return super.toString();
    }

    public void init() {
        setResultOprStr(getOprString());
        initParamStr();
    }

    public String getResultOprStr() {
        return _$3;
    }

    public void setResultOprStr(String paramString) {
        _$3 = paramString;
    }

    public String getResultOrigStr() {
        return _$2;
    }

    public void setResultOrigStr(String paramString) {
        _$2 = paramString;
    }

    public void setParameter(String paramString1, String paramString2) {
        _$4.put(paramString1, paramString2);
    }

    public Object getParameter(String paramString) {
        return _$4.get(paramString);
    }

    public Map<String, String> getParamMap() {
        return _$4;
    }

    public void setParamMap(Map<String, String> paramMap) {
        _$4 = paramMap;
    }

    public String getParamStr() {
        return _$1;
    }

    public void setParamStr(String paramString) {
        _$1 = paramString;
    }

    public void initParamStr() {
        Iterator localIterator = _$4.keySet().iterator();
        StringBuffer localStringBuffer = new StringBuffer();
        while (localIterator.hasNext()) {
            String str1 = (String) localIterator.next();
            String str2 = _$4.get(str1) == null ? "" : ((String) _$4.get(str1)).toString();
            if (localStringBuffer.length() == 0) {
                localStringBuffer.append(str1 + "," + Code.encode(str2));
            } else {
                localStringBuffer.append(";" + str1 + "," + Code.encode(str2));
            }
        }
        _$1 = localStringBuffer.toString();
    }

    public String getCqId() {
        return _$8;
    }

    public void setCqId(String paramString) {
        _$8 = paramString;
    }
}

/*
 * Location:
 * /Users/YiSiliang/Documents/workspace_CICS/CICS/WebContent/WEB-INF/lib/
 * BasePackage.jar Qualified Name: com.huateng.commquery.result.Result Java
 * Class Version: 5 (49.0) JD-Core Version: 0.7.1
 */