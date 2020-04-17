package com.huateng.commquery.result;

public class ResultParamBean extends ResCdMsg {

    private String _$8;
    private String _$7;
    private String _$6;
    private String _$5;
    private String _$4;
    private int _$3;
    private int _$2;
    private int _$1;
    private int total;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public ResultParamBean(String paramString1, String paramString2, String paramString3, String paramString4,
            String paramString5, int paramInt1, int paramInt2, int paramInt3, String paramString6,
            String paramString7) {
        super(paramString6, paramString7);
        _$8 = paramString1;
        _$7 = paramString2;
        _$6 = paramString3;
        _$5 = paramString4;
        _$3 = paramInt1;
        _$2 = paramInt2;
        _$1 = paramInt3;
        _$4 = paramString5;
    }

    public ResultParamBean() {
    }

    public ResultParamBean(String paramString1, String paramString2) {
        _$7 = paramString1;
        _$6 = paramString2;
    }

    public String getFieldString() {
        return _$7;
    }

    public void setFieldString(String paramString) {
        _$7 = paramString;
    }

    public String getRecordString() {
        return _$6;
    }

    public void setRecordString(String paramString) {
        _$6 = paramString;
    }

    public String getRecordOrigString() {
        return _$5;
    }

    public void setRecordOrigString(String paramString) {
        _$5 = paramString;
    }

    public int getPageCount() {
        return _$3;
    }

    public void setPageCount(int paramInt) {
        _$3 = paramInt;
    }

    public int getPageIndex() {
        return _$2;
    }

    public void setPageIndex(int paramInt) {
        _$2 = paramInt;
    }

    public int getPageSize() {
        return _$1;
    }

    public void setPageSize(int paramInt) {
        _$1 = paramInt;
    }

    public String getCqId() {
        return _$8;
    }

    public void setCqId(String paramString) {
        _$8 = paramString;
    }

    public String getParameterString() {
        return _$4;
    }

    public void setParameterString(String paramString) {
        _$4 = paramString;
    }

}
