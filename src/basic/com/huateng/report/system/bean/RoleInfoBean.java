package com.huateng.report.system.bean;

import java.io.Serializable;
import java.util.Date;

public class RoleInfoBean implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = -9138190104567042159L;
    private String id;
    private String idOld;
    private String roleid;
    private String roleNameOld;
    private String roleName;
    private String isInqMaker;
    private String isInqMakerOld;
    private String isInqChecker;
    private String isInqCheckerOld;
    private String mail;
    private String mailOld;
    private String status;
    private String statusOld;
    private String isLock;
    private String funcList;
    private String funcListNew;
    private String taskId;
    private String updTransCd;
    private String taskName;
    private String intOperId;
    private String crtDt;
    private Date effectDate;
    private Date expireDate;

    private String roleGroup;
    private String isTxndtlMaker;
    private String isTxndtlChecker;
    private String isDynqueMaker;
    private String isDynqueChecker;
    private String isAllactMaker;
    private String isAllactChecker;

    private String roleGroupOld;
    private String isTxndtlMakerOld;
    private String isTxndtlCheckerOld;
    private String isDynqueMakerOld;
    private String isDynqueCheckerOld;
    private String isAllactMakerOld;
    private String isAllactCheckerOld;

    public String getIdOld() {
        return idOld;
    }

    public void setIdOld(String idOld) {
        this.idOld = idOld;
    }

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFuncList() {
        return funcList;
    }

    public void setFuncList(String funcList) {
        this.funcList = funcList;
    }

    public String getFuncListNew() {
        return funcListNew;
    }

    public void setFuncListNew(String funcListNew) {
        this.funcListNew = funcListNew;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getUpdTransCd() {
        return updTransCd;
    }

    public void setUpdTransCd(String updTransCd) {
        this.updTransCd = updTransCd;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getIntOperId() {
        return intOperId;
    }

    public void setIntOperId(String intOperId) {
        this.intOperId = intOperId;
    }

    public String getCrtDt() {
        return crtDt;
    }

    public void setCrtDt(String crtDt) {
        this.crtDt = crtDt;
    }

    public String getStatusOld() {
        return statusOld;
    }

    public void setStatusOld(String statusOld) {
        this.statusOld = statusOld;
    }

    public String getIsLock() {
        return isLock;
    }

    public void setIsLock(String isLock) {
        this.isLock = isLock;
    }

    public Date getEffectDate() {
        return effectDate;
    }

    public void setEffectDate(Date effectDate) {
        this.effectDate = effectDate;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public String getIsInqMaker() {
        return isInqMaker;
    }

    public void setIsInqMaker(String isInqMaker) {
        this.isInqMaker = isInqMaker;
    }

    public String getIsInqMakerOld() {
        return isInqMakerOld;
    }

    public void setIsInqMakerOld(String isInqMakerOld) {
        this.isInqMakerOld = isInqMakerOld;
    }

    public String getIsInqChecker() {
        return isInqChecker;
    }

    public void setIsInqChecker(String isInqChecker) {
        this.isInqChecker = isInqChecker;
    }

    public String getIsInqCheckerOld() {
        return isInqCheckerOld;
    }

    public void setIsInqCheckerOld(String isInqCheckerOld) {
        this.isInqCheckerOld = isInqCheckerOld;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMailOld() {
        return mailOld;
    }

    public void setMailOld(String mailOld) {
        this.mailOld = mailOld;
    }

    public String getRoleNameOld() {
        return roleNameOld;
    }

    public void setRoleNameOld(String roleNameOld) {
        this.roleNameOld = roleNameOld;
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

    public String getRoleGroupOld() {
        return roleGroupOld;
    }

    public void setRoleGroupOld(String roleGroupOld) {
        this.roleGroupOld = roleGroupOld;
    }

    public String getIsTxndtlMakerOld() {
        return isTxndtlMakerOld;
    }

    public void setIsTxndtlMakerOld(String isTxndtlMakerOld) {
        this.isTxndtlMakerOld = isTxndtlMakerOld;
    }

    public String getIsTxndtlCheckerOld() {
        return isTxndtlCheckerOld;
    }

    public void setIsTxndtlCheckerOld(String isTxndtlCheckerOld) {
        this.isTxndtlCheckerOld = isTxndtlCheckerOld;
    }

    public String getIsDynqueMakerOld() {
        return isDynqueMakerOld;
    }

    public void setIsDynqueMakerOld(String isDynqueMakerOld) {
        this.isDynqueMakerOld = isDynqueMakerOld;
    }

    public String getIsDynqueCheckerOld() {
        return isDynqueCheckerOld;
    }

    public void setIsDynqueCheckerOld(String isDynqueCheckerOld) {
        this.isDynqueCheckerOld = isDynqueCheckerOld;
    }

    public String getIsAllactMakerOld() {
        return isAllactMakerOld;
    }

    public void setIsAllactMakerOld(String isAllactMakerOld) {
        this.isAllactMakerOld = isAllactMakerOld;
    }

    public String getIsAllactCheckerOld() {
        return isAllactCheckerOld;
    }

    public void setIsAllactCheckerOld(String isAllactCheckerOld) {
        this.isAllactCheckerOld = isAllactCheckerOld;
    }

}
