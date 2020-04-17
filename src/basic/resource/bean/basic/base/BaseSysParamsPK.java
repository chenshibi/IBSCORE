package resource.bean.basic.base;

import java.io.Serializable;

public abstract class BaseSysParamsPK implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -3243609538400802937L;

    protected int hashCode = Integer.MIN_VALUE;

    private java.lang.String paramgroupId;
    private java.lang.String paramId;

    public BaseSysParamsPK() {
    }

    public BaseSysParamsPK(java.lang.String paramgroupId, java.lang.String paramId) {

        this.setParamgroupId(paramgroupId);
        this.setParamId(paramId);
    }

    /**
     * Return the value associated with the column: PARAMGROUP_ID
     */
    public java.lang.String getParamgroupId() {
        return paramgroupId;
    }

    /**
     * Set the value related to the column: PARAMGROUP_ID
     * 
     * @param paramgroupId
     *            the PARAMGROUP_ID value
     */
    public void setParamgroupId(java.lang.String paramgroupId) {
        this.paramgroupId = paramgroupId;
    }

    /**
     * Return the value associated with the column: PARAM_ID
     */
    public java.lang.String getParamId() {
        return paramId;
    }

    /**
     * Set the value related to the column: PARAM_ID
     * 
     * @param paramId
     *            the PARAM_ID value
     */
    public void setParamId(java.lang.String paramId) {
        this.paramId = paramId;
    }

    public boolean equals(Object obj) {
        if (null == obj)
            return false;
        if (!(obj instanceof resource.bean.basic.SysParamsPK))
            return false;
        else {
            resource.bean.basic.SysParamsPK mObj = (resource.bean.basic.SysParamsPK) obj;
            if (null != this.getParamgroupId() && null != mObj.getParamgroupId()) {
                if (!this.getParamgroupId().equals(mObj.getParamgroupId())) {
                    return false;
                }
            } else {
                return false;
            }
            if (null != this.getParamId() && null != mObj.getParamId()) {
                if (!this.getParamId().equals(mObj.getParamId())) {
                    return false;
                }
            } else {
                return false;
            }
            return true;
        }
    }

    public int hashCode() {
        if (Integer.MIN_VALUE == this.hashCode) {
            StringBuilder sb = new StringBuilder();
            if (null != this.getParamgroupId()) {
                sb.append(this.getParamgroupId().hashCode());
                sb.append(":");
            } else {
                return super.hashCode();
            }
            if (null != this.getParamId()) {
                sb.append(this.getParamId().hashCode());
                sb.append(":");
            } else {
                return super.hashCode();
            }
            this.hashCode = sb.toString().hashCode();
        }
        return this.hashCode;
    }

}