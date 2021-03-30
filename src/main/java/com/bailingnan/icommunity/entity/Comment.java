package com.bailingnan.icommunity.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author bailingnan
 * @date 2021/3/31
 */
@Data
public class Comment {
    private int id;
    private int userId;
    private int entityType;
    private int entityId;
    private int targetId;
    private String content;
    private int status;
    private Date createTime;
}
