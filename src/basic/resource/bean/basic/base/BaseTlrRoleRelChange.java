package resource.bean.basic.base;

import java.io.Serializable;

import resource.bean.basic.TlrRoleRel;

/**
 * This is an object that contains data related to the TLR_ROLE_REL table. Do
 * not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 *
 * @hibernate.class table="TLR_ROLE_REL"
 */

public abstract class BaseTlrRoleRelChange implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -2184361488154099939L;
	/**
     * 
     */
    public static String REF = "TlrRoleRelChange";
    public static String PROP_CHANGE_ID = "changeId";
    public static String PROP_ID = "id";
    public static String PROP_ROLE_ID = "roleId";
    public static String PROP_TLRNO = "tlrNo";


    // primary key
    private java.lang.Integer id;
    // fields
    private java.lang.String changeId;
    private java.lang.String roleId;
    private java.lang.String tlrNo;
    
	public BaseTlrRoleRelChange(Integer id, String changeId, String roleId,
			String tlrNo) {
		super();
		this.id = id;
		this.changeId = changeId;
		this.roleId = roleId;
		this.tlrNo = tlrNo;
	}
	public java.lang.String getTlrNo() {
		return tlrNo;
	}
	public void setTlrNo(java.lang.String tlrNo) {
		this.tlrNo = tlrNo;
	}
	public static String getREF() {
		return REF;
	}
	public static void setREF(String rEF) {
		REF = rEF;
	}
	public static String getPROP_CHANGE_ID() {
		return PROP_CHANGE_ID;
	}
	public static void setPROP_CHANGE_ID(String pROP_CHANGE_ID) {
		PROP_CHANGE_ID = pROP_CHANGE_ID;
	}
	public static String getPROP_ID() {
		return PROP_ID;
	}
	public static void setPROP_ID(String pROP_ID) {
		PROP_ID = pROP_ID;
	}
	public static String getPROP_ROLE_ID() {
		return PROP_ROLE_ID;
	}
	public static void setPROP_ROLE_ID(String pROP_ROLE_ID) {
		PROP_ROLE_ID = pROP_ROLE_ID;
	}
	public java.lang.Integer getId() {
		return id;
	}
	public void setId(java.lang.Integer id) {
		this.id = id;
	}
	public java.lang.String getChangeId() {
		return changeId;
	}
	public void setChangeId(java.lang.String changeId) {
		this.changeId = changeId;
	}
	public java.lang.String getRoleId() {
		return roleId;
	}
	public void setRoleId(java.lang.String roleId) {
		this.roleId = roleId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "BaseTlrRoleRelChange [id=" + id + ", changeId=" + changeId
				+ ", roleId=" + roleId + ", tlrNo=" + tlrNo + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((changeId == null) ? 0 : changeId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((roleId == null) ? 0 : roleId.hashCode());
		result = prime * result + ((tlrNo == null) ? 0 : tlrNo.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BaseTlrRoleRelChange other = (BaseTlrRoleRelChange) obj;
		if (changeId == null) {
			if (other.changeId != null)
				return false;
		} else if (!changeId.equals(other.changeId))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (roleId == null) {
			if (other.roleId != null)
				return false;
		} else if (!roleId.equals(other.roleId))
			return false;
		if (tlrNo == null) {
			if (other.tlrNo != null)
				return false;
		} else if (!tlrNo.equals(other.tlrNo))
			return false;
		return true;
	}
	public BaseTlrRoleRelChange(Integer id, String changeId, String roleId) {
		super();
		this.id = id;
		this.changeId = changeId;
		this.roleId = roleId;
	}
	public BaseTlrRoleRelChange() {
		super();
	}

    
}