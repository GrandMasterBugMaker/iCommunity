package com.bailingnan.icommunity.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author bailingnan
 * @date 2021/3/29
 */
@Data
public class LoginTicket {
    private int id;
    private int userId;
    private String ticket;
    private int status;
    private Date expired;
}
