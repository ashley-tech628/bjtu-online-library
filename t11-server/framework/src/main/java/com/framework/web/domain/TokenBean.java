/**
 * 
 *  * 
 */
package com.framework.web.domain;

import lombok.Data;

/**
 *  * 
 * Title: 文件所属模块（必须填写）
 * Description：对本文件的详细描述，原则上不能少于30字
 * @author DSH
 * @mender：（文件的修改者，文件创建者之外的人）
 * @version 1.0
 * Remark：认为有必要的其他信息
 */
@Data
public class TokenBean {

    private String accessToken;

    private String userTicket;

    /** token有效时长 */
    private int tokenExpiresIn;

    /** ticket有效时长 */
    private int ticketExpiresIn;

    private String state;

    private String code;

}
