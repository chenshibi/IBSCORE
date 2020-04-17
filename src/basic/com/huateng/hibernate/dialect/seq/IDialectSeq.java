package com.huateng.hibernate.dialect.seq;

import java.util.List;

import com.huateng.exception.AppException;

public interface IDialectSeq {

    public abstract Integer getSeqNo(String sequenceName) throws AppException;

    public abstract void setId(String id);

    public abstract String getDesc();

    public abstract void setDesc(String desc);

    public abstract List getSequenceList();

    public abstract void setSequenceList(List sequenceList);

    public abstract void initSeqGenerator();

}
