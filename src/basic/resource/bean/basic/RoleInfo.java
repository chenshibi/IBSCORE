package resource.bean.basic;

import resource.bean.basic.base.BaseRoleInfo;

public class RoleInfo extends BaseRoleInfo {
    private static final long serialVersionUID = 1L;
    private String roleList;
    private String statusModFlag;

    public String getIsInqMaker() {
        return isInqMaker;
    }

    public void setIsInqMaker(String isInqMaker) {
        this.isInqMaker = isInqMaker;
    }

    public String getIsInqChecker() {
        return isInqChecker;
    }

    public void setIsInqChecker(String isInqChecker) {
        this.isInqChecker = isInqChecker;
    }

    public String getIsCtlMaker() {
        return isCtlMaker;
    }

    public void setIsCtlMaker(String isCtlMaker) {
        this.isCtlMaker = isCtlMaker;
    }

    public String getIsCtlChecker() {
        return isCtlChecker;
    }

    public void setIsCtlChecker(String isCtlChecker) {
        this.isCtlChecker = isCtlChecker;
    }

    private String isInqMaker;
    private String isInqChecker;
    private String isCtlMaker;
    private String isCtlChecker;
    private String mail;
    private String brno;
    private String roleGroup;
    private String isTxndtlMaker;
    private String isTxndtlChecker;
    private String isDynqueMaker;
    private String isDynqueChecker;
    private String isAllactMaker;
    private String isAllactChecker;

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    /* [CONSTRUCTOR MARKER BEGIN] */
    public RoleInfo() {
        super();
    }

    /**
     * Constructor for primary key
     */
    public RoleInfo(java.lang.String id) {
        super(id);
    }

    public String getRoleList() {
        return roleList;
    }

    public void setRoleList(String roleList) {
        this.roleList = roleList;
    }

    public String getStatusModFlag() {
        return statusModFlag;
    }

    public void setStatusModFlag(String statusModFlag) {
        this.statusModFlag = statusModFlag;
    }

    public String getBrno() {
        return brno;
    }

    public void setBrno(String brno) {
        this.brno = brno;
    }

    public String getRoleGroup() {
        return roleGroup;
    }

    public void setRoleGroup(String roleGroup) {
        this.roleGroup = roleGroup;
    }

    public String getIsTxndtlMaker() {
        return isTxndtlMaker;
    }

    public void setIsTxndtlMaker(String isTxndtlMaker) {
        this.isTxndtlMaker = isTxndtlMaker;
    }

    public String getIsTxndtlChecker() {
        return isTxndtlChecker;
    }

    public void setIsTxndtlChecker(String isTxndtlChecker) {
        this.isTxndtlChecker = isTxndtlChecker;
    }

    public String getIsDynqueMaker() {
        return isDynqueMaker;
    }

    public void setIsDynqueMaker(String isDynqueMaker) {
        this.isDynqueMaker = isDynqueMaker;
    }

    public String getIsDynqueChecker() {
        return isDynqueChecker;
    }

    public void setIsDynqueChecker(String isDynqueChecker) {
        this.isDynqueChecker = isDynqueChecker;
    }

    public String getIsAllactMaker() {
        return isAllactMaker;
    }

    public void setIsAllactMaker(String isAllactMaker) {
        this.isAllactMaker = isAllactMaker;
    }

    public String getIsAllactChecker() {
        return isAllactChecker;
    }

    public void setIsAllactChecker(String isAllactChecker) {
        this.isAllactChecker = isAllactChecker;
    }

    /* [CONSTRUCTOR MARKER END] */

}