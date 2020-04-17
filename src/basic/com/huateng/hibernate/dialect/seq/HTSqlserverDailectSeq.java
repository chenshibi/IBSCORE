package com.huateng.hibernate.dialect.seq;

import com.huateng.exception.AppException;

public class HTSqlserverDailectSeq extends _DialectSeq {

    public static void main(String[] args) throws Exception {
    }

    public void initSeqGenerator() {
        // try{
        // createAndCheckSequence(getNextSequence,defaultCreateSequece);
        // }catch(AppException e){}
    }

    @Override
    public Integer getSeqNo(String sequenceName) throws AppException {
        // TODO Auto-generated method stub
        return null;
    }
}
