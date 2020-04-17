package resource.bean.basic.base;

import java.io.Serializable;

import resource.bean.basic.TlrBctlRel;

/**
 * This is an object that contains data related to the TLR_BCTL_REL table. Do
 * not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 *
 * @hibernate.class table="TLR_BCTL_REL"
 */

public abstract class BaseTlrBctlRel implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 21965594455814381L;
    public static String REF = "TlrBctlRel";
    public static String PROP_TLR_NO = "tlrNo";
    public static String PROP_ID = "id";
    public static String PROP_BR_NO = "brNo";
    public static String PROP_STATUS = "status";

    // constructors
    public BaseTlrBctlRel() {
        initialize();
    }

    /**
     * Constructor for primary key
     */
    public BaseTlrBctlRel(java.lang.String id) {
        this.setId(id);
        initialize();
    }

    protected void initialize() {
    }

    private int hashCode = Integer.MIN_VALUE;

    // primary key
    private java.lang.String id;

    // fields
    private java.lang.String tlrNo;
    private java.lang.String brNo;
    private java.lang.String status;

    public java.lang.String getStatus() {
        return status;
    }

    public void setStatus(java.lang.String status) {
        this.status = status;
    }

    /**
     * Return the unique identifier of this class
     * 
     * @hibernate.id generator-class="sequence" column="ID"
     */
    public java.lang.String getId() {
        return id;
    }

    /**
     * Set the unique identifier of this class
     * 
     * @param id
     *            the new ID
     */
    public void setId(java.lang.String id) {
        this.id = id;
        this.hashCode = Integer.MIN_VALUE;
    }

    /**
     * Return the value associated with the column: TLR_NO
     */
    public java.lang.String getTlrNo() {
        return tlrNo;
    }

    /**
     * Set the value related to the column: TLR_NO
     * 
     * @param tlrNo
     *            the TLR_NO value
     */
    public void setTlrNo(java.lang.String tlrNo) {
        this.tlrNo = tlrNo;
    }

    /**
     * Return the value associated with the column: BR_NO
     */
    public java.lang.String getBrNo() {
        return brNo;
    }

    /**
     * Set the value related to the column: BR_NO
     * 
     * @param brNo
     *            the BR_NO value
     */
    public void setBrNo(java.lang.String brNo) {
        this.brNo = brNo;
    }

    public boolean equals(Object obj) {
        if (null == obj)
            return false;
        if (!(obj instanceof TlrBctlRel))
            return false;
        else {
            TlrBctlRel tlrBctlRel = (TlrBctlRel) obj;
            if (null == this.getId() || null == tlrBctlRel.getId())
                return false;
            else
                return (this.getId().equals(tlrBctlRel.getId()));
        }
    }

    public int hashCode() {
        if (Integer.MIN_VALUE == this.hashCode) {
            if (null == this.getId())
                return super.hashCode();
            else {
                String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
                this.hashCode = hashStr.hashCode();
            }
        }
        return this.hashCode;
    }

    public String toString() {
        return super.toString();
    }

}