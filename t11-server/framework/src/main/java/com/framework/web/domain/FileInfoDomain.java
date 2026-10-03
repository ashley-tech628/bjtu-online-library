/**
 * Copyright 2019 Zhongke ruicheng (Beijing) information technology co. LTD
 * All right reserved.
 * 项目名称: 北京交通大学（威海）约车系统
 * 创建日期:2021/7/3
 */
package com.framework.web.domain;

import lombok.Data;

import java.io.Serializable;

/***
 * Date:2021/8/15
 * Title:图片附件实体
 * Description：对本文件的详细描述，原则上不能少于30字
 * @author Admin
 * @mender：（文件的修改者，文件创建者之外的人）
 * @version 1.0
 * Remark：认为有必要的其他信息
 */
@Data
public class FileInfoDomain implements Serializable {
    /**
     * 附件id
     */
    private String path;
    private String fileId;
    /**
     * 附件组id
     */
    private String groupId;
    /**
     * 附件类型
     */
    private String contentType;
    /**
     * 附件名称
     */
    private String fileName;
    /**
     * 附件扩展名
     */
    private String extName;
    /**
     * 附件大小
     */
    private Double fileSize;
    /**
     * 图片附件base64内容
     */
    private String fileData;

}
