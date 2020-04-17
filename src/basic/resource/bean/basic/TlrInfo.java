package resource.bean.basic;

import java.util.List;

import resource.bean.basic.base.BaseTlrInfo;

public class TlrInfo extends BaseTlrInfo {
    private static final long serialVersionUID = 1L;

    /* [CONSTRUCTOR MARKER BEGIN] */
    public TlrInfo() {
        super();
    }

    /**
     * Constructor for primary key
     */
    public TlrInfo(java.lang.String tlrno) {
        super(tlrno);
    }

    /* [CONSTRUCTOR MARKER END] */
    private String brno;

    public String getBrno() {
        return getBrcode();
    }

    public void setBrno(String brno) {
        this.brno = brno;
    }

    /** add by zhaozhiguo 2011-6-20 BMS-3153 begin */
    private String lastPwdUpdTime;
    private String lastfailedtm;
    private String isLock;
    private String lockReason;
    private List roleList;
    private String newFlag;
    private String RestFlg;

    private String reset;
    private String maker;
    private String makeTime;
    private String checker;
    private String checkTime;
    //private String roleGroup;
    
    //新增字段
    private String city;
    private String region; 
    private String department;
    public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public String getMakeTime() {
        return makeTime;
    }

    public void setMakeTime(String makeTime) {
        this.makeTime = makeTime;
    }

    public String getChecker() {
        return checker;
    }

    public void setChecker(String checker) {
        this.checker = checker;
    }

    public String getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(String checkTime) {
        this.checkTime = checkTime;
    }

    public String getReset() {
        return reset;
    }

    public void setReset(String reset) {
        this.reset = reset;
    }

    public String getLastfailedtm() {
        return lastfailedtm;
    }

    public void setLastfailedtm(String lastfailedtm) {
        this.lastfailedtm = lastfailedtm;
    }

    public String getIsLock() {
        return isLock;
    }

    public void setIsLock(String isLock) {
        this.isLock = isLock;
    }

    public String getLockReason() {
        return lockReason;
    }

    public void setLockReason(String lockReason) {
        this.lockReason = lockReason;
    }

    public String getLastPwdUpdTime() {
        return lastPwdUpdTime;
    }

    public void setLastPwdUpdTime(String lastPwdUpdTime) {
        this.lastPwdUpdTime = lastPwdUpdTime;
    }

    /** add by zhaozhiguo 2011-6-20 BMS-3153 end */

    // 操作员审批阀值
    private long maxWl;

    public long getMaxWl() {
        return maxWl;
    }

    public void setMaxWl(long maxWl) {
        this.maxWl = maxWl;
    }

    public List getRoleList() {
        return roleList;
    }

    public void setRoleList(List roleList) {
        this.roleList = roleList;
    }

    public String getNewFlag() {
        return newFlag;
    }

    public void setNewFlag(String newFlag) {
        this.newFlag = newFlag;
    }

    public String getRestFlg() {
        return RestFlg;
    }

    public void setRestFlg(String restFlg) {
        RestFlg = restFlg;
    }
/**
    public String getRoleGroup() {
        return roleGroup;
    }

    public void setRoleGroup(String roleGroup) {
        this.roleGroup = roleGroup;
    }
*/
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

    
    
    
}