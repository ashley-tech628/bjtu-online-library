/**
 * 
 */
package com.foundation.springcontext.configure;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/***
 * 创建日期:2021/8/2
 * Title: 系统文件配置参数
 * 
 */
@Data
@Component
public class FileConfig {

    /** windows上传地址 */
    private static String directoryWindows;

    /** linux上传地址 */
    private static String directoryLinux;

    private static final String PLATFORM_WINDOWS = "WINDOWS";

    /**
     * Function:获取附件在服务器上的存储地址
     * Author: Admin
     * Date:2021/8/14
     * @return java.lang.String
     * @throws Exception
     */
    public static String getFileRootDirectory() {
        String os = System.getProperties().getProperty("os.name");
        if (StringUtils.isNotBlank(os)) {
            if (os.toUpperCase().contains(PLATFORM_WINDOWS)) {
                return directoryWindows;
            } else {
                return directoryLinux;
            }
        }
        return "";
    }

    /**
     * 获取下载路径
     */
    public static String getDownloadPath() {
        return getFileRootDirectory() + "/download/";
    }

    @Value("${apollo.file.storedirectory.windows}")
    public void setDirectoryWindows(String directoryWindows) {
        FileConfig.directoryWindows = directoryWindows;
    }

    @Value("${apollo.file.storedirectory.linux}")
    public void setDirectoryLinux(String directoryLinux) {
        FileConfig.directoryLinux = directoryLinux;
    }
}

