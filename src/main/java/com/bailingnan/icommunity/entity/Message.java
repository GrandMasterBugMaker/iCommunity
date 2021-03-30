package com.bailingnan.icommunity.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author bailingnan
 * @date 2021/3/31
 */
@Data
public class Message {

    private int id;
    private int fromId;
    private int toId;
    private String conversationId;
    private String content;
    private int status;
    private Date createTime;

}

