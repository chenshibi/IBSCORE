package com.huateng.boa.log4j;

import java.io.IOException;

import org.apache.log4j.RollingFileAppender;

import com.huateng.report.utils.FilePermissonUtils;

public class CustRollingFileAppender extends RollingFileAppender {

    public synchronized void setFile(String fileName, boolean append, boolean bufferedIO, int bufferSize)
            throws IOException {
        super.setFile(fileName, append, this.bufferedIO, this.bufferSize);
        FilePermissonUtils.setPermission644(fileName);
    }

}
