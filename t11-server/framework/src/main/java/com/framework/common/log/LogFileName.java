/**
 */
package com.framework.common.log;

/***
 * Date:2021/7/24
 * Title:日志类型枚举类
 * Description：对本文件的详细描述，原则上不能少于30字
 * 
 */
public enum LogFileName {
    /** 业务系统 */
    SYS_LOG("sysLog");

    private String logFileName;

    LogFileName(String fileName) {
        this.logFileName = fileName;
    }

    public String getLogFileName() {
        return logFileName;
    }

    public void setLogFileName(String logFileName) {
        this.logFileName = logFileName;
    }

}
